package com.ezioshiki.twittersearcher.data.net.oAuth;

import com.ezioshiki.twittersearcher.data.Config;

/**
 * Created by EzioShiki on 15/12/22.
 */
public class AOAConfig {
  public static final String AOA_BASE_URL = "https://api.twitter.com/";
  public static final String AOA_PATH = "oauth2/token";

  public static final String CONTENT_TYPE_HEADER = "Content-Type: application/x-www-form-urlencoded;charset=UTF-8";
  public static final String AUTH_HEADER = "Authorization: Basic "+ Config.BASE64ED_CREDENTIALS;

  public static final String AOA_BODY = "grant_type=client_credentials";

}
