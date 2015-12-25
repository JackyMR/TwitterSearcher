package com.ezioshiki.twittersearcher.domain.interactor;

import android.text.TextUtils;

import com.ezioshiki.twittersearcher.data.net.oAuth.TwitterAOA;
import com.ezioshiki.twittersearcher.data.net.oAuth.request.AoaBodyBuilder;
import com.ezioshiki.twittersearcher.data.net.oAuth.response.BearerTokenResponse;
import com.ezioshiki.twittersearcher.data.settings.Setting;
import com.ezioshiki.twittersearcher.domain.eventbus.AoaFailedEvent;
import com.ezioshiki.twittersearcher.domain.eventbus.RxBus;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by EzioShiki on 15/12/25.
 */
public class GetToken {

  private TwitterAOA mAOA;
  private RxBus mRxBus;
  private Setting mSetting;

  @Inject
  public GetToken(TwitterAOA twitterAOA, RxBus rxBus,Setting setting) {
    mSetting = setting;
    mAOA = twitterAOA;
    mRxBus = rxBus;
  }

  public void getBearerTokenAndStore() {
    mAOA.getBearerToken(AoaBodyBuilder.getAoaBody())
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<BearerTokenResponse>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            mRxBus.send(new AoaFailedEvent());
          }

          @Override public void onNext(BearerTokenResponse bearerTokenResponse) {
            if ("bearer".equals(bearerTokenResponse.getTokenType()) &&
                !TextUtils.isEmpty(bearerTokenResponse.getAccessToken())) {
              storeBearerToken(bearerTokenResponse.getAccessToken());
            }
          }
        });
  }

  private void storeBearerToken(String token) {
    mSetting.setBearerToken(token);
  }
}
