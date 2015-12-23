package com.ezioshiki.twittersearcher.data.net;

import com.ezioshiki.twittersearcher.data.net.oAuth.AOAConfig;
import com.ezioshiki.twittersearcher.data.net.oAuth.TwitterAOA;
import com.ezioshiki.twittersearcher.data.net.search.SearchConfig;
import com.ezioshiki.twittersearcher.data.net.search.TwitterSearchApi;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by EzioShiki on 15/12/22.
 */
public class ServerGenerator {
  public static TwitterAOA buildAoaServer(){
    OkHttpClient okHttpClient = new OkHttpClient();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    okHttpClient.interceptors().add(interceptor);

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(AOAConfig.AOA_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    return retrofit.create(TwitterAOA.class);
  }

  public static TwitterSearchApi buildSearchServer(){
    OkHttpClient okHttpClient = new OkHttpClient();
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    okHttpClient.interceptors().add(interceptor);

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(SearchConfig.SEARCH_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    return retrofit.create(TwitterSearchApi.class);
  }
}
