package com.ezioshiki.twittersearcher.presentation.view;

import com.ezioshiki.twittersearcher.presentation.model.TwitterModel;

import java.util.Collection;

/**
 * Created by EzioShiki on 15/12/23.
 *
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link TwitterModel}.
 */
public interface SearchResultsListView extends LoadDataView {

  /**
   * Render a twitter list in the UI.
   *
   * @param twitterModelCollection The collection of {@link TwitterModel} that will be shown.
   */
  void renderResults(Collection<TwitterModel> twitterModelCollection);


}
