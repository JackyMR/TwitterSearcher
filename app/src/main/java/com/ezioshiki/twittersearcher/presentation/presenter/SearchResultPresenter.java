package com.ezioshiki.twittersearcher.presentation.presenter;

import com.ezioshiki.twittersearcher.data.net.search.response.SearchResultResponse;
import com.ezioshiki.twittersearcher.domain.interactor.Interactor;
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

  private Interactor mInteractor;

  @Inject
  public SearchResultPresenter(Interactor interactor) {
    mInteractor = interactor;
  }

  @Override
  public void setView(LoadDataView loadDataView) {
    mView = (SearchResultsListView) loadDataView;
  }

  public void search(String question) {
    mView.showLoading();

    mInteractor.search(question)
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<SearchResultResponse>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            //todo:add error handler
            mView.showError(e.getMessage());
          }

          @Override public void onNext(SearchResultResponse searchResultResponse) {
            mView.hideLoading();
            Timber.i("search result onNext");
            mView.renderResults(TwitterModel.Mapper.mapList(searchResultResponse.getStatuses()));



//
//            List<StatusMayHaveRetweet> list = searchResultResponse.getStatuses();
//            StatusMayHaveRetweet item = list.get(0);
//            item.getText(); //推特文字
//            item.getUser().getName(); //用户名,显示成主要的
//            item.getUser().getScreenName(); //实际用户名,显示成次要的,前面加@
//            item.getUser().getProfileImageUrlHttps(); //头像url
//
//            item.getCreatedAt(); //推特创建时间,觉得可以不做
//            item.getStatus(); //可能为null,如果不是retweet,那么检查有没有
//            item.getEntities().getMedia().get(0).getType();
//            item.getEntities().getMedia().get(0).getMediaUrlHttps();
//            //如果是retweet
//            item.getStatus().getEntities().getMedia().get(0).getMediaUrlHttps();

          }
        });
  }


}
