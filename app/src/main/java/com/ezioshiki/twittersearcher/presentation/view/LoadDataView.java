package com.ezioshiki.twittersearcher.presentation.view;

import android.content.Context;

/**
 * Created by EzioShiki on 15/12/22.
 *
 * Interface representing a View that will use to load data.
 */
public interface LoadDataView {
  /**
   * Show a view with a progress bar indicating a loading process.
   */
  void showLoading();

  /**
   * Hide a loading view.
   */
  void hideLoading();

  /**
   * Show a retry view in case of an error when retrieving data.
   */
  void showRetry();

  /**
   * Hide a retry view shown if there was an error when retrieving data.
   */
  void hideRetry();

  /**
   * Show an error message
   *
   * @param message A string representing an error.
   */
  void showError(String message);

  /**
   * Show an empty message
   *
   * @param message A string representing results are empty.
   */
  void showEmptyResult(String message);

  /**
   * Get a {@link Context}.
   */
  Context getContext();
}
