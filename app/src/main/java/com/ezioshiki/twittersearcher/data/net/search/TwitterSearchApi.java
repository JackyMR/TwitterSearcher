package com.ezioshiki.twittersearcher.data.net.search;

import com.ezioshiki.twittersearcher.data.net.search.response.SearchResultResponse;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;
import rx.Observable;

import static com.ezioshiki.twittersearcher.data.net.search.SearchConfig.AUTH_HEADER;
import static com.ezioshiki.twittersearcher.data.net.search.SearchConfig.GEO_CODE;
import static com.ezioshiki.twittersearcher.data.net.search.SearchConfig.LANGUAGE;
import static com.ezioshiki.twittersearcher.data.net.search.SearchConfig.QUESTION;
import static com.ezioshiki.twittersearcher.data.net.search.SearchConfig.SEARCH_URL;

/**
 * Created by EzioShiki on 15/12/22.
 */
public interface TwitterSearchApi {
  @GET(SEARCH_URL)
  Observable<SearchResultResponse> search(
      @Header(AUTH_HEADER) String bearerToken,
      @Query(QUESTION) String question,
      @Query(GEO_CODE) String geoString,
      @Query(LANGUAGE) String language
  );
}
