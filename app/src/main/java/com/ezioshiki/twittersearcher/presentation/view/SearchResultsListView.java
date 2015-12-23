package com.ezioshiki.twittersearcher.presentation.view;

import com.ezioshiki.twittersearcher.presentation.model.TwitterModel;

import java.util.Collection;

/**
 * Created by EzioShiki on 15/12/23.
 */
public interface SearchResultsListView extends LoadDataView {

  void renderResults(Collection<TwitterModel> results);

}
