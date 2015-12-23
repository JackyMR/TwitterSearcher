package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities___ {

  @SerializedName("hashtags")
  @Expose
  private List<Hashtag> hashtags = new ArrayList<Hashtag>();
  @SerializedName("symbols")
  @Expose
  private List<Object> symbols = new ArrayList<Object>();
  @SerializedName("user_mentions")
  @Expose
  private List<Object> userMentions = new ArrayList<Object>();
  @SerializedName("urls")
  @Expose
  private List<Url____> urls = new ArrayList<Url____>();
  @SerializedName("media")
  @Expose
  private List<Medium__> media = new ArrayList<Medium__>();

  /**
   *
   * @return
   * The hashtags
   */
  public List<Hashtag> getHashtags() {
    return hashtags;
  }

  /**
   *
   * @param hashtags
   * The hashtags
   */
  public void setHashtags(List<Hashtag> hashtags) {
    this.hashtags = hashtags;
  }

  /**
   *
   * @return
   * The symbols
   */
  public List<Object> getSymbols() {
    return symbols;
  }

  /**
   *
   * @param symbols
   * The symbols
   */
  public void setSymbols(List<Object> symbols) {
    this.symbols = symbols;
  }

  /**
   *
   * @return
   * The userMentions
   */
  public List<Object> getUserMentions() {
    return userMentions;
  }

  /**
   *
   * @param userMentions
   * The user_mentions
   */
  public void setUserMentions(List<Object> userMentions) {
    this.userMentions = userMentions;
  }

  /**
   *
   * @return
   * The urls
   */
  public List<Url____> getUrls() {
    return urls;
  }

  /**
   *
   * @param urls
   * The urls
   */
  public void setUrls(List<Url____> urls) {
    this.urls = urls;
  }

  /**
   *
   * @return
   * The media
   */
  public List<Medium__> getMedia() {
    return media;
  }

  /**
   *
   * @param media
   * The media
   */
  public void setMedia(List<Medium__> media) {
    this.media = media;
  }

}
