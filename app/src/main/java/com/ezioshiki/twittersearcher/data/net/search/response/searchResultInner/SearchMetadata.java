package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchMetadata {

  @SerializedName("completed_in")
  @Expose
  private double completedIn;
  @SerializedName("max_id")
  @Expose
  private long maxId;
  @SerializedName("max_id_str")
  @Expose
  private String maxIdStr;
  @SerializedName("next_results")
  @Expose
  private String nextResults;
  @SerializedName("query")
  @Expose
  private String query;
  @SerializedName("refresh_url")
  @Expose
  private String refreshUrl;
  @SerializedName("count")
  @Expose
  private long count;
  @SerializedName("since_id")
  @Expose
  private long sinceId;
  @SerializedName("since_id_str")
  @Expose
  private String sinceIdStr;

  /**
   *
   * @return
   * The completedIn
   */
  public double getCompletedIn() {
    return completedIn;
  }

  /**
   *
   * @param completedIn
   * The completed_in
   */
  public void setCompletedIn(double completedIn) {
    this.completedIn = completedIn;
  }

  /**
   *
   * @return
   * The maxId
   */
  public long getMaxId() {
    return maxId;
  }

  /**
   *
   * @param maxId
   * The max_id
   */
  public void setMaxId(long maxId) {
    this.maxId = maxId;
  }

  /**
   *
   * @return
   * The maxIdStr
   */
  public String getMaxIdStr() {
    return maxIdStr;
  }

  /**
   *
   * @param maxIdStr
   * The max_id_str
   */
  public void setMaxIdStr(String maxIdStr) {
    this.maxIdStr = maxIdStr;
  }

  /**
   *
   * @return
   * The nextResults
   */
  public String getNextResults() {
    return nextResults;
  }

  /**
   *
   * @param nextResults
   * The next_results
   */
  public void setNextResults(String nextResults) {
    this.nextResults = nextResults;
  }

  /**
   *
   * @return
   * The query
   */
  public String getQuery() {
    return query;
  }

  /**
   *
   * @param query
   * The query
   */
  public void setQuery(String query) {
    this.query = query;
  }

  /**
   *
   * @return
   * The refreshUrl
   */
  public String getRefreshUrl() {
    return refreshUrl;
  }

  /**
   *
   * @param refreshUrl
   * The refresh_url
   */
  public void setRefreshUrl(String refreshUrl) {
    this.refreshUrl = refreshUrl;
  }

  /**
   *
   * @return
   * The count
   */
  public long getCount() {
    return count;
  }

  /**
   *
   * @param count
   * The count
   */
  public void setCount(long count) {
    this.count = count;
  }

  /**
   *
   * @return
   * The sinceId
   */
  public long getSinceId() {
    return sinceId;
  }

  /**
   *
   * @param sinceId
   * The since_id
   */
  public void setSinceId(long sinceId) {
    this.sinceId = sinceId;
  }

  /**
   *
   * @return
   * The sinceIdStr
   */
  public String getSinceIdStr() {
    return sinceIdStr;
  }

  /**
   *
   * @param sinceIdStr
   * The since_id_str
   */
  public void setSinceIdStr(String sinceIdStr) {
    this.sinceIdStr = sinceIdStr;
  }

}
