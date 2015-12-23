package com.ezioshiki.twittersearcher.domain.eventbus;

/**
 * Created by EzioShiki on 15/12/22.
 */
public class AoaFailedEvent implements RxBusEvent {
  @Override public String getInfo() {
    return "Try to get bearer token failed.";
  }
}
