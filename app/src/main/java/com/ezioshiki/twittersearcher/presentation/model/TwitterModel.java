package com.ezioshiki.twittersearcher.presentation.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

  @NonNull
  public String getUserProfileImageUrlHttps(){
    String url = mTwitter.getUser().getProfileImageUrlHttps();
    if (url==null){
      return "";
    }else {
      return url;
    }
  }

  @Nullable
  private String getMediaType(Status twitter) throws NullPointerException,IndexOutOfBoundsException{
    if (twitter.getEntities().getMedia().size()>0){
      return twitter.getEntities().getMedia().get(0).getType();
    }else {
      return null;
    }

  }

  @Nullable
  private String getMediaUrlHttps(Status twitter) throws NullPointerException,IndexOutOfBoundsException{
    if (twitter.getEntities().getMedia().size()>0) {
      return twitter.getEntities().getMedia().get(0).getMediaUrlHttps();
    } else {
      return null;
    }
  }

  @Nullable
  public String getDisplayedMediaUrlHttps() throws NullPointerException,IndexOutOfBoundsException{
    if (isRetweetPost()){
      return getMediaUrlHttps(mTwitter.getStatus());
    }else {
      return getMediaUrlHttps(mTwitter);
    }
  }

  @Nullable
  public String getDisplayedMediaType() throws NullPointerException,IndexOutOfBoundsException{
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
