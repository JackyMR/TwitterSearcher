package com.ezioshiki.twittersearcher.data.net.oAuth;

/**
 * Created by EzioShiki on 15/12/22.
 */

import com.ezioshiki.twittersearcher.data.net.oAuth.response.BearerTokenResponse;
import com.squareup.okhttp.RequestBody;

import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

import static com.ezioshiki.twittersearcher.data.net.oAuth.AOAConfig.AOA_PATH;
import static com.ezioshiki.twittersearcher.data.net.oAuth.AOAConfig.AUTH_HEADER;
import static com.ezioshiki.twittersearcher.data.net.oAuth.AOAConfig.CONTENT_TYPE_HEADER;

/**
 * AOA means Application-only authentication
 * To get the bearer token for search
 * */
public interface TwitterAOA {

  /**
   * @param body put a new AoaBody into it.
   * */
  @POST(AOA_PATH)
  @Headers({
      CONTENT_TYPE_HEADER,
      AUTH_HEADER
  })
  Observable<BearerTokenResponse> getBearerToken(@Body RequestBody body);

}
