package com.ezioshiki.twittersearcher.data.settings;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by EzioShiki on 15/12/22.
 */
public class Setting {

  public static final String PACKAGE_NAME = "com.ezioshiki.twittersearcher.data.settings";
  public static final String SP_NAME = PACKAGE_NAME + ".sp";

  public static final String LOCATION = SP_NAME+ "LOCATION";
  public static final String LANG = SP_NAME+ "LANG";
  public static final String BEARER_TOKEN = SP_NAME + "BEARER_TOKEN";

  public static final String EMPTY_STRING = "";
  public static final String ALL = "全部";

  private Context mContext;
  private SharedPreferences sp;

  @Inject
  public Setting(Context context) {
    mContext = context;
    sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
  }

  public void setLocation(String location){
    SharedPreferences.Editor editor = sp.edit();
    editor.putString(LOCATION,location);
    editor.apply();
  }

  public String getLocation(){
    return sp.getString(LOCATION,ALL);
  }

  public void setLang(String language){
    SharedPreferences.Editor editor = sp.edit();
    editor.putString(LANG,language);
    editor.apply();
  }

  public String getLang(){
    return sp.getString(LANG,ALL);
  }

  public void setBearerToken(String token){
    SharedPreferences.Editor editor = sp.edit();
    editor.putString(BEARER_TOKEN,token);
    editor.apply();
  }

  public String getBearerToken(){
    return sp.getString(BEARER_TOKEN,EMPTY_STRING);
  }

}
