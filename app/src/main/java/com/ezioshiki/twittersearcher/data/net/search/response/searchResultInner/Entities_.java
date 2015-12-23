package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities_ {

  @SerializedName("description")
  @Expose
  private Description_ description;

  /**
   *
   * @return
   * The description
   */
  public Description_ getDescription() {
    return description;
  }

  /**
   *
   * @param description
   * The description
   */
  public void setDescription(Description_ description) {
    this.description = description;
  }

}
