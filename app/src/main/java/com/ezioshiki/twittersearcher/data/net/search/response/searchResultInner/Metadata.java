package com.ezioshiki.twittersearcher.data.net.search.response.searchResultInner;

/**
 * Created by EzioShiki on 15/12/23.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Metadata {

  @SerializedName("iso_language_code")
  @Expose
  private String isoLanguageCode;
  @SerializedName("result_type")
  @Expose
  private String resultType;

  /**
   *
   * @return
   * The isoLanguageCode
   */
  public String getIsoLanguageCode() {
    return isoLanguageCode;
  }

  /**
   *
   * @param isoLanguageCode
   * The iso_language_code
   */
  public void setIsoLanguageCode(String isoLanguageCode) {
    this.isoLanguageCode = isoLanguageCode;
  }

  /**
   *
   * @return
   * The resultType
   */
  public String getResultType() {
    return resultType;
  }

  /**
   *
   * @param resultType
   * The result_type
   */
  public void setResultType(String resultType) {
    this.resultType = resultType;
  }

}
