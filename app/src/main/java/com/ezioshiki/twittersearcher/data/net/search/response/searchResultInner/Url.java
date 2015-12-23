package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Url {

  @SerializedName("urls")
  @Expose
  private List<Url_> urls = new ArrayList<Url_>();

  /**
   *
   * @return
   * The urls
   */
  public List<Url_> getUrls() {
    return urls;
  }

  /**
   *
   * @param urls
   * The urls
   */
  public void setUrls(List<Url_> urls) {
    this.urls = urls;
  }

}
