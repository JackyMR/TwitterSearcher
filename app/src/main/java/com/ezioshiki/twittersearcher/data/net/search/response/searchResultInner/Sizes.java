package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sizes {

  @SerializedName("thumb")
  @Expose
  private Thumb thumb;
  @SerializedName("large")
  @Expose
  private Large large;
  @SerializedName("small")
  @Expose
  private Small small;
  @SerializedName("medium")
  @Expose
  private Medium_ medium;

  /**
   *
   * @return
   * The thumb
   */
  public Thumb getThumb() {
    return thumb;
  }

  /**
   *
   * @param thumb
   * The thumb
   */
  public void setThumb(Thumb thumb) {
    this.thumb = thumb;
  }

  /**
   *
   * @return
   * The large
   */
  public Large getLarge() {
    return large;
  }

  /**
   *
   * @param large
   * The large
   */
  public void setLarge(Large large) {
    this.large = large;
  }

  /**
   *
   * @return
   * The small
   */
  public Small getSmall() {
    return small;
  }

  /**
   *
   * @param small
   * The small
   */
  public void setSmall(Small small) {
    this.small = small;
  }

  /**
   *
   * @return
   * The medium
   */
  public Medium_ getMedium() {
    return medium;
  }

  /**
   *
   * @param medium
   * The medium
   */
  public void setMedium(Medium_ medium) {
    this.medium = medium;
  }

}
