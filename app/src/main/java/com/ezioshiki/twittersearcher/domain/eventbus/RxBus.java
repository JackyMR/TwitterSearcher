package com.ezioshiki.twittersearcher.domain.eventbus;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
import timber.log.Timber;

/**
 * Created by EzioShiki on 15/12/21.
 */
@Singleton
public class RxBus {

  @Inject
  public RxBus() {
  }

  private final Subject<RxBusEvent, RxBusEvent> _bus =
      new SerializedSubject<>(PublishSubject.<RxBusEvent>create());

  public void send(RxBusEvent o) {
    _bus.onNext(o);
    Timber.d(o.getInfo());
  }

  public Observable<RxBusEvent> listen() {
    return _bus;
  }

  public boolean hasObservers() {
    return _bus.hasObservers();
  }
}
