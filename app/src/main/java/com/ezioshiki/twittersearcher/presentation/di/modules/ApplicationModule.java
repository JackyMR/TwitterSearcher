package com.ezioshiki.twittersearcher.presentation.di.modules;

import android.content.Context;

import com.ezioshiki.twittersearcher.data.net.ServerGenerator;
import com.ezioshiki.twittersearcher.data.net.oAuth.TwitterAOA;
import com.ezioshiki.twittersearcher.data.net.search.TwitterSearchApi;
import com.ezioshiki.twittersearcher.presentation.TsApplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by EzioShiki on 15/12/21.
 */
/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

  private final TsApplication application;

  public ApplicationModule(TsApplication application) {
    this.application = application;
  }


  @Provides
  @Singleton
  Gson provideGson(){
    return new Gson();
  }

  @Provides
  Context provideApplicationContext(){
    return this.application;
  }

  @Provides
  @Singleton
  TwitterAOA provideTwitterAoa(){
    return ServerGenerator.buildAoaServer();
  }

  @Provides
  @Singleton
  TwitterSearchApi provideTwitterSearchApi(){
    return ServerGenerator.buildSearchServer();
  }

}
