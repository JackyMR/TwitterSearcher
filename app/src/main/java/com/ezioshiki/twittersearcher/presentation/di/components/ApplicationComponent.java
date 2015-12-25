package com.ezioshiki.twittersearcher.presentation.di.components;

import android.content.Context;

import com.ezioshiki.twittersearcher.data.net.oAuth.TwitterAOA;
import com.ezioshiki.twittersearcher.data.net.search.TwitterSearchApi;
import com.ezioshiki.twittersearcher.presentation.di.modules.ApplicationModule;
import com.ezioshiki.twittersearcher.presentation.view.activity.SearchActivity;
import com.ezioshiki.twittersearcher.presentation.view.activity.SearchResultActivity;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by EzioShiki on 15/12/21.
 */
/**
 * A component whose lifetime is the life of the application.
 */
@Component(modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {

  void inject(SearchActivity activity);
  void inject(SearchResultActivity activity);


  Context context();
  Gson gson();
  TwitterAOA twitterAoa();
  TwitterSearchApi twitterSearchApi();

}
