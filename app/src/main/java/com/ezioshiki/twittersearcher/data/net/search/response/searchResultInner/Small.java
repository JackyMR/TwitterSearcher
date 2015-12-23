package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Small {

  @SerializedName("w")
  @Expose
  private int w;
  @SerializedName("h")
  @Expose
  private int h;
  @SerializedName("resize")
  @Expose
  private String resize;

  /**
   *
   * @return
   * The w
   */
  public int getW() {
    return w;
  }

  /**
   *
   * @param w
   * The w
   */
  public void setW(int w) {
    this.w = w;
  }

  /**
   *
   * @return
   * The h
   */
  public int getH() {
    return h;
  }

  /**
   *
   * @param h
   * The h
   */
  public void setH(int h) {
    this.h = h;
  }

  /**
   *
   * @return
   * The resize
   */
  public String getResize() {
    return resize;
  }

  /**
   *
   * @param resize
   * The resize
   */
  public void setResize(String resize) {
    this.resize = resize;
  }

}
