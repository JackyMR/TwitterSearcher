package com.ezioshiki.twittersearcher.data.net.search.response;

import com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner.SearchMetadata;
import com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner.StatusMayHaveRetweet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by EzioShiki on 15/12/22.
 */

@Generated("org.jsonschema2pojo")
public class SearchResultResponse{

  @SerializedName("statuses")
  @Expose
  private List<StatusMayHaveRetweet> mStatuses = new ArrayList<StatusMayHaveRetweet>();
  @SerializedName("search_metadata")
  @Expose
  private SearchMetadata searchMetadata;

  /**
   *
   * @return
   * The statuses
   */
  public List<StatusMayHaveRetweet> getStatuses() {
    return mStatuses;
  }

  /**
   *
   * @param statuses
   * The statuses
   */
  public void setStatuses(List<StatusMayHaveRetweet> statuses) {
    this.mStatuses = statuses;
  }

  /**
   *
   * @return
   * The searchMetadata
   */
  public SearchMetadata getSearchMetadata() {
    return searchMetadata;
  }

  /**
   *
   * @param searchMetadata
   * The search_metadata
   */
  public void setSearchMetadata(SearchMetadata searchMetadata) {
    this.searchMetadata = searchMetadata;
  }

}
