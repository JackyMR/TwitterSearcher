package com.ezioshiki.twittersearcher.presentation;

import android.app.Application;
import android.content.Context;

import com.ezioshiki.twittersearcher.BuildConfig;
import com.ezioshiki.twittersearcher.presentation.di.components.ApplicationComponent;
import com.ezioshiki.twittersearcher.presentation.di.components.DaggerApplicationComponent;
import com.ezioshiki.twittersearcher.presentation.di.modules.ApplicationModule;
import com.squareup.picasso.Picasso;

import rx.plugins.DebugHook;
import rx.plugins.DebugNotification;
import rx.plugins.DebugNotificationListener;
import rx.plugins.RxJavaPlugins;
import timber.log.Timber;

/**
 * Created by EzioShiki on 15/12/21.
 */
public class TsApplication extends Application {
  private ApplicationComponent applicationComponent;

  public static ApplicationComponent getComponent(Context context) {
    return ((TsApplication) context.getApplicationContext()).applicationComponent;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    buildComponentForDagger();
    setLogger();
    setRxJavaDebugger();
    setPicassoDebugger();
  }

  private void setPicassoDebugger() {
    if (BuildConfig.DEBUG){
      Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);
      Picasso.with(getApplicationContext()).setLoggingEnabled(true);
    }
  }

  private void setLogger() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

  }

  private void setRxJavaDebugger() {
    if (BuildConfig.DEBUG) {
      RxJavaPlugins.getInstance().registerObservableExecutionHook(
          new DebugHook<>(new DebugNotificationListener<Object>() {
            @Override public <T> T onNext(DebugNotification<T> n) {
              Timber.v("RxJava on Next : " + n.toString());
              return super.onNext(n);

            }

            @Override public <T> Object start(DebugNotification<T> n) {
              return super.start(n);
            }

            @Override public void complete(Object context) {
              super.complete(context);
            }

            @Override public void error(Object context, Throwable e) {
              Timber.i("RxJava on Error : " + e.toString());
              super.error(context, e);
            }
          })
      );
    }
  }

  private void buildComponentForDagger() {
    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }
}
