package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by EzioShiki on 15/12/23.
 */

@Generated("org.jsonschema2pojo")
public class Description_ {

  @SerializedName("urls")
  @Expose
  private List<Object> urls = new ArrayList<Object>();

  /**
   *
   * @return
   * The urls
   */
  public List<Object> getUrls() {
    return urls;
  }

  /**
   *
   * @param urls
   * The urls
   */
  public void setUrls(List<Object> urls) {
    this.urls = urls;
  }

}