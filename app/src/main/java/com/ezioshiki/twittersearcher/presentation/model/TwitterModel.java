package com.ezioshiki.twittersearcher.presentation.model;

import com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner.Status;
import com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner.StatusMayHaveRetweet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by EzioShiki on 15/12/23.
 */
public class TwitterModel {

  private StatusMayHaveRetweet mTwitter;

  public static final String MEDIA_PHOTO = "photo";

  public TwitterModel(StatusMayHaveRetweet twitter) {
    mTwitter = twitter;
    if (twitter==null||twitter.getUser()==null){
      throw new IllegalArgumentException("Empty twitter model");
    }
  }

  public boolean isRetweetPost(){
    return mTwitter.getStatus()!=null;
  }

  public String getTwitterText(){
    return mTwitter.getText();
  }

  public String getUserDisplayName(){
    return mTwitter.getUser().getName();
  }

  public String getUserAtName(){
    return mTwitter.getUser().getScreenName();
  }

  public String getUserProfileImageUrlHttps(){
    String url = mTwitter.getUser().getProfileImageUrlHttps();
    if (url==null){
      return "";
    }else {
      return url;
    }
  }

  public String getMediaType(Status twitter) throws NullPointerException{
    return twitter.getEntities().getMedia().get(0).getType();
  }

  public String getMediaUrlHttps(Status twitter) throws NullPointerException{
    return twitter.getEntities().getMedia().get(0).getMediaUrlHttps();
  }

  public String getDisplayedMediaUrlHttps() throws NullPointerException{
    if (isRetweetPost()){
      return getMediaUrlHttps(mTwitter.getStatus());
    }else {
      return getMediaUrlHttps(mTwitter);
    }
  }

  public String getDisplayedMediaType() throws NullPointerException{
    if (isRetweetPost()){
      return getMediaType(mTwitter.getStatus());
    }else {
      return getMediaType(mTwitter);
    }
  }

  public static class Mapper{
    public static TwitterModel map(StatusMayHaveRetweet status){
      return new TwitterModel(status);
    }

    public static Collection<TwitterModel> mapList(List<StatusMayHaveRetweet> statuses){
      Collection<TwitterModel> list = new ArrayList<>(statuses.size());
      for (StatusMayHaveRetweet status: statuses){
        list.add(map(status));
      }
      return list;
    }
  }

}
