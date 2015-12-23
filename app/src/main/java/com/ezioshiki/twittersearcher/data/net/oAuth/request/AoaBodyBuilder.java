package com.ezioshiki.twittersearcher.data.net.oAuth.request;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

/**
 * Created by EzioShiki on 15/12/23.
 */
public class AoaBodyBuilder {
  public static RequestBody getAoaBody(){
    MediaType json = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(json,"grant_type=client_credentials");
    return body;
  }
}
