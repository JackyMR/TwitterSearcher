package com.ezioshiki.twittersearcher.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ezioshiki.twittersearcher.R;
import com.ezioshiki.twittersearcher.presentation.TsApplication;
import com.ezioshiki.twittersearcher.presentation.model.TwitterModel;
import com.ezioshiki.twittersearcher.presentation.presenter.SearchResultPresenter;
import com.ezioshiki.twittersearcher.presentation.view.SearchResultsListView;
import com.ezioshiki.twittersearcher.presentation.view.adapter.TwitterAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import timber.log.Timber;

public class SearchResultActivity extends BaseActivity implements SearchResultsListView {

  public static final String SEARCH_TEXT = "SEARCH_TEXT";

  @Bind(R.id.search_result_act_loading) ProgressBar mLoadingCircle;
  @Bind(R.id.search_result_act_search_bar) EditText mSearchBar;
  @Bind(R.id.search_result_act_search_btn) ImageButton mSearchBtn;
  @Bind(R.id.search_result_act_twitter_list) RecyclerView mTwitterList;

  @Inject SearchResultPresenter mPresenter;

  private TwitterAdapter mTwitterAdapter;
  private RecyclerView.LayoutManager mLayoutManager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_result);
    ButterKnife.bind(this);
    TsApplication.getComponent(this).inject(this);

    showLoading();
    mPresenter.setView(this);
    setUpTwitterList();

    String question = getQuestionString();
    mSearchBar.setText(question);
    mSearchBar.setSelection(mSearchBar.getText().length());
    mPresenter.search(question);

  }

  private void setUpTwitterList() {
    mLayoutManager = new LinearLayoutManager(this);
    mTwitterList.setLayoutManager(mLayoutManager);
    mTwitterAdapter = new TwitterAdapter(this,new ArrayList<TwitterModel>());
    mTwitterList.setAdapter(mTwitterAdapter);

  }


  @Override public void renderResults(Collection<TwitterModel> results) {
    if (results!=null){
      mTwitterAdapter.setTwitterCollection(results);
    }
  }

  private String getQuestionString() {
    return getIntent().getStringExtra(SEARCH_TEXT);
  }

  @Override protected List<Subscription> createAutoManagerSubscriptions() {
    //// TODO: 15/12/21  
    return new ArrayList<>();
  }

  @Override public void showLoading() {
    mTwitterList.setVisibility(View.GONE);
    mLoadingCircle.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    mLoadingCircle.setVisibility(View.GONE);
    mTwitterList.setVisibility(View.VISIBLE);
  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {
    hideLoading();
    hideRetry();
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    Timber.i(message);
  }

  @Override public Context getContext() {
    return this;
  }

  public static Intent getCallingIntent(Context context,String searchText) {
    Intent intent =  new Intent(context,SearchResultActivity.class);
    intent.putExtra(SEARCH_TEXT,searchText);
    return intent;
  }


}
