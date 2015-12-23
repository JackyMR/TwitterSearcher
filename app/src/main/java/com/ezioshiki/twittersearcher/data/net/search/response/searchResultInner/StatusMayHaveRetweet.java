package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StatusMayHaveRetweet extends Status{


  @SerializedName("retweeted_status")
  @Expose
  private Status mStatus;

  /**
   *
   * @return
   * The retweetedStatus
   */
  public Status getStatus() {
    return mStatus;
  }

  /**
   *
   * @param status
   * The retweeted_status
   */
  public void setStatus(Status status) {
    this.mStatus = status;
  }



}