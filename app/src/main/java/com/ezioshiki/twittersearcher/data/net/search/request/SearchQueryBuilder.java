package com.ezioshiki.twittersearcher.data.net.search.request;

import com.ezioshiki.twittersearcher.data.mock_data.MockLocation;
import com.ezioshiki.twittersearcher.data.mock_data.TsLanguage;
import com.ezioshiki.twittersearcher.data.mock_data.TsLocation;

/**
 * Created by EzioShiki on 15/12/22.
 */
public class SearchQueryBuilder {

  public static String buildQuestionString(String q){
    String result = parseQuestion(q);
    return result;
  }

  private static String parseQuestion(String q) {
    return q;
  }

  public static String buildGeoCodeString(TsLocation location){
     return new StringBuilder().append(location.getLatitude()).append(",")
         .append(location.getLongitude()).append(",")
         .append(MockLocation.RADIUS).toString();
  }

  public static String buildLanguageString(TsLanguage language){
    return language.getIso639Name();
  }

}
