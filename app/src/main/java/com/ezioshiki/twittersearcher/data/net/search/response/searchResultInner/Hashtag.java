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
public class Hashtag {

  @SerializedName("text")
  @Expose
  private String text;
  @SerializedName("indices")
  @Expose
  private List<Integer> indices = new ArrayList<Integer>();

  /**
   *
   * @return
   * The text
   */
  public String getText() {
    return text;
  }

  /**
   *
   * @param text
   * The text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   *
   * @return
   * The indices
   */
  public List<Integer> getIndices() {
    return indices;
  }

  /**
   *
   * @param indices
   * The indices
   */
  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }

}