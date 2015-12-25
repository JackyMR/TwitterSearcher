package com.ezioshiki.twittersearcher.domain.interactor;

import com.ezioshiki.twittersearcher.data.settings.Setting;

import javax.inject.Inject;

/**
 * Created by EzioShiki on 15/12/21.
 */
public class UiFragment {

  private Setting mSetting;

  @Inject
  public UiFragment(Setting setting) {

    mSetting = setting;
  }

  public String getDisplayedLanguage() {
    return mSetting.getLang();
  }

  public String getDisplayedLocation(){
    return mSetting.getLocation();
  }

  public void setLanguageToSp(String displayedLang) {
    mSetting.setLang(displayedLang);
  }

  public void setLocationToSp(String displayedLocation) {
    mSetting.setLocation(displayedLocation);
  }
}
