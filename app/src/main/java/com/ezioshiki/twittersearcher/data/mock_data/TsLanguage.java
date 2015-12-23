package com.ezioshiki.twittersearcher.data.mock_data;

/**
 * Created by EzioShiki on 15/12/23.
 */
public enum TsLanguage {

  Chinese("中文","zh"),English("English","en"),Japanese("日本語","ja"),
  German("Deutsch","de"),French("français","fr");

  private String displayName;
  private String iso639Name;

  TsLanguage(String displayName, String iso639Name) {
    this.displayName = displayName;
    this.iso639Name = iso639Name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getIso639Name() {
    return iso639Name;
  }
}
