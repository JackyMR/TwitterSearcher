package com.ezioshiki.twittersearcher.presentation;

import android.content.Context;
import android.content.Intent;

import com.ezioshiki.twittersearcher.presentation.view.activity.SearchActivity;
import com.ezioshiki.twittersearcher.presentation.view.activity.SearchResultActivity;

import javax.inject.Inject;

/**
 * Created by EzioShiki on 15/12/21.
 *
 * Navigator between activities
 */
public class Navigator {

  @Inject
  public Navigator() {
  }

  /**
   * Goes to the search result screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToSearchResultActivity(Context context,String searchText) {
    if (context != null) {
      Intent intentToLaunch = SearchResultActivity.getCallingIntent(context,searchText);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the search screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToSearchActivity(Context context) {
    if (context != null) {
      Intent intentToLaunch = SearchActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }




}
