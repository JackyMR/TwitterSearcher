package com.ezioshiki.twittersearcher.data.mock_data;

import static com.ezioshiki.twittersearcher.data.mock_data.MockLocation.*;

/**
 * Created by EzioShiki on 15/12/23.
 */
public enum TsLocation {
  Beijing("北京", BEIJING_LAT, BEIJING_LONG),
  Shanghai("上海",SHANG_HAI_LAT,SHANG_HAI_LONG),
  NewYork("纽约",NEW_YORK_LAT,NEW_YORK_LONG),
  Tokyo("东京",TOKYO_LAT,TOKYO_LONG),
  London("伦敦",LONDON_LAT,LONDON_LONG);

  private String displayName;
  private double latitude;
  private double longitude;

  TsLocation(String displayName,double latitude,double longitude){
    this.displayName = displayName;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getDisplayName() {
    return displayName;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }
}
