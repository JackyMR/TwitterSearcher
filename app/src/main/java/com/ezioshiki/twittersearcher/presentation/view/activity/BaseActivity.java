package com.ezioshiki.twittersearcher.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ezioshiki.twittersearcher.domain.eventbus.RxBus;
import com.ezioshiki.twittersearcher.presentation.Navigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by EzioShiki on 15/12/21.
 */
public abstract class BaseActivity extends AppCompatActivity{
  @Inject RxBus mRxBus;
  @Inject Navigator mNavigator;

  private CompositeSubscription _subscriptions;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //keep it always there, so can invoke addSubscribe() in onCreate()
    _subscriptions = new CompositeSubscription();
  }

  @Override
  protected void onStop() {
    super.onStop();
    unsubscribe();
  }


  private void unsubscribe() {
    assert _subscriptions != null;
    _subscriptions.clear();
    _subscriptions = new CompositeSubscription();
  }

  @Override
  protected void onStart() {
    super.onStart();
    subscribe();
  }


  private void subscribe() {
    for (Subscription subscription : createAutoManagerSubscriptions()) {
      _subscriptions.add(subscription);
    }
  }

  /**
   * Implement this to return all subscriptions that you want attached to this
   * activity's lifecycle. Each {@link rx.Subscription} will have
   * {@link rx.Subscription#unsubscribe() unsubscribe()} called when
   * onStop() is fired.
   */

  protected abstract List<Subscription> createAutoManagerSubscriptions();


  /**
   * add subscription and it will unsubscribed in onStop()
   * */
  protected void addOneTimeSubscription(Subscription subscription) {
    assert _subscriptions != null;
    _subscriptions.add(subscription);
  }


  protected List<Subscription> defaultCreateAutoManagerSubscriptions() {
    return new ArrayList<>();
  }
}
