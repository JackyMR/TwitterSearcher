package com.ezioshiki.twittersearcher.domain.interactor;

import com.ezioshiki.twittersearcher.data.mock_data.TsLanguage;
import com.ezioshiki.twittersearcher.data.mock_data.TsLocation;
import com.ezioshiki.twittersearcher.data.net.search.TwitterSearchApi;
import com.ezioshiki.twittersearcher.data.net.search.request.SearchQueryBuilder;
import com.ezioshiki.twittersearcher.data.net.search.response.SearchResultResponse;
import com.ezioshiki.twittersearcher.data.settings.Setting;

import java.util.EnumSet;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by EzioShiki on 15/12/25.
 */
public class GetTwitterListInter {

  private TwitterSearchApi mSearcher;
  private Setting mSetting;

  private final EnumSet<TsLocation> locations = EnumSet.allOf(TsLocation.class);
  private final EnumSet<TsLanguage> languages = EnumSet.allOf(TsLanguage.class);

  @Inject
  public GetTwitterListInter(TwitterSearchApi searcher, Setting setting) {
    mSearcher = searcher;
    mSetting = setting;
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

}
