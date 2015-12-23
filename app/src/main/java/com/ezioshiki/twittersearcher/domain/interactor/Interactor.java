package com.ezioshiki.twittersearcher.domain.interactor;

import android.text.TextUtils;

import com.ezioshiki.twittersearcher.data.mock_data.TsLanguage;
import com.ezioshiki.twittersearcher.data.mock_data.TsLocation;
import com.ezioshiki.twittersearcher.data.net.oAuth.TwitterAOA;
import com.ezioshiki.twittersearcher.data.net.oAuth.request.AoaBodyBuilder;
import com.ezioshiki.twittersearcher.data.net.oAuth.response.BearerTokenResponse;
import com.ezioshiki.twittersearcher.data.net.search.TwitterSearchApi;
import com.ezioshiki.twittersearcher.data.net.search.request.SearchQueryBuilder;
import com.ezioshiki.twittersearcher.data.net.search.response.SearchResultResponse;
import com.ezioshiki.twittersearcher.data.settings.Setting;
import com.ezioshiki.twittersearcher.domain.eventbus.AoaFailedEvent;
import com.ezioshiki.twittersearcher.domain.eventbus.RxBus;

import java.util.EnumSet;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by EzioShiki on 15/12/21.
 */
public class Interactor {

  private TwitterAOA mAOA;
  private TwitterSearchApi mSearcher;
  private Setting mSetting;
  private RxBus mRxBus;


  private final EnumSet<TsLocation> locations = EnumSet.allOf(TsLocation.class);
  private final EnumSet<TsLanguage> languages = EnumSet.allOf(TsLanguage.class);

  @Inject
  public Interactor(TwitterAOA aoa,TwitterSearchApi search,Setting setting,RxBus rxBus) {

    mAOA = aoa;
    mSearcher = search;
    mSetting = setting;
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

  public Observable<SearchResultResponse> search(String question) {
    return mSearcher.search(
        getBearerToken(),
        question,
        getGeo(),
        getLanguage());
  }

  private String getBearerToken() {
    return "Bearer "+mSetting.getBearerToken();
  }


  private String getLanguage() {
    String displayedLang = mSetting.getLang();
    if (Setting.ALL.equals(displayedLang)){
      return null;
    }else {
      for (TsLanguage lang : languages){
        if (lang.getDisplayName().equals(displayedLang)){
          return SearchQueryBuilder.buildLanguageString(lang);
        }
      }
      throw new IllegalArgumentException("Displayed language do not match any language in data set !!!");

    }
  }

  private String getGeo() {
    String displayedLocation = mSetting.getLocation();
    if (Setting.ALL.equals(displayedLocation)){
      return null;
    }else {
      for (TsLocation location: locations){
        if (location.getDisplayName().equals(displayedLocation)){
          return SearchQueryBuilder.buildGeoCodeString(location);
        }
      }
      throw new IllegalArgumentException("Displayed location do not match any location in data set !!!");

    }

  }

  public EnumSet<TsLocation> getLocations() {
    return locations;
  }

  public EnumSet<TsLanguage> getLanguages() {
    return languages;
  }

  private void storeBearerToken(String token) {
    mSetting.setBearerToken(token);
  }
}
