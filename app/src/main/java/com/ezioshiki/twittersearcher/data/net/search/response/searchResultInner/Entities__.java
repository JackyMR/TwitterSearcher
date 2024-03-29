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
public class Entities__ {

  @SerializedName("hashtags")
  @Expose
  private List<Object> hashtags = new ArrayList<Object>();
  @SerializedName("symbols")
  @Expose
  private List<Object> symbols = new ArrayList<Object>();
  @SerializedName("user_mentions")
  @Expose
  private List<Object> userMentions = new ArrayList<Object>();
  @SerializedName("urls")
  @Expose
  private List<Url___> urls = new ArrayList<Url___>();
  @SerializedName("media")
  @Expose
  private List<Medium> media = new ArrayList<Medium>();

  /**
   *
   * @return
   * The hashtags
   */
  public List<Object> getHashtags() {
    return hashtags;
  }

  /**
   *
   * @param hashtags
   * The hashtags
   */
  public void setHashtags(List<Object> hashtags) {
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
  public List<Url___> getUrls() {
    return urls;
  }

  /**
   *
   * @param urls
   * The urls
   */
  public void setUrls(List<Url___> urls) {
    this.urls = urls;
  }

  /**
   *
   * @return
   * The media
   */
  public List<Medium> getMedia() {
    return media;
  }

  /**
   *
   * @param media
   * The media
   */
  public void setMedia(List<Medium> media) {
    this.media = media;
  }

}
