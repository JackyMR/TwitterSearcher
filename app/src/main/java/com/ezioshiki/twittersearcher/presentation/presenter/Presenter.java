package com.ezioshiki.twittersearcher.presentation.presenter;

/**
 * Created by EzioShiki on 15/12/22.
 */

import com.ezioshiki.twittersearcher.presentation.view.LoadDataView;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public interface Presenter {
  void setView(LoadDataView loadDataView);
}
