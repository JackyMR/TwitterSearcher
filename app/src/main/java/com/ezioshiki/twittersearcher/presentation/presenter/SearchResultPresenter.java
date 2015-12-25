package com.ezioshiki.twittersearcher.presentation.presenter;

import com.ezioshiki.twittersearcher.data.net.search.response.SearchResultResponse;
import com.ezioshiki.twittersearcher.domain.interactor.GetTwitterList;
import com.ezioshiki.twittersearcher.presentation.model.TwitterModel;
import com.ezioshiki.twittersearcher.presentation.view.LoadDataView;
import com.ezioshiki.twittersearcher.presentation.view.SearchResultsListView;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by EzioShiki on 15/12/22.
 */
public class SearchResultPresenter implements Presenter {

  private SearchResultsListView mView;

  private GetTwitterList mGetTwitterList;

  @Inject
  public SearchResultPresenter(GetTwitterList getTwitterList) {
    mGetTwitterList = getTwitterList;
  }

  @Override
  public void setView(LoadDataView loadDataView) {
    mView = (SearchResultsListView) loadDataView;
  }

  public void search(String question) {
    mView.showLoading();

    mGetTwitterList.search(question)
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<SearchResultResponse>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            //mView.showError(e.getMessage());
            mView.showError("Cannot access twitter server");
          }

          @Override public void onNext(SearchResultResponse searchResultResponse) {
            mView.hideLoading();
            Timber.i("search result onNext");
            mView.renderResults(TwitterModel.Mapper.mapList(searchResultResponse.getStatuses()));
            if (searchResultResponse.getStatuses().size()==0){
              mView.showEmptyResult("No matched result");
            }
          }
        });
  }


}
