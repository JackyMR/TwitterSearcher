package com.ezioshiki.twittersearcher.presentation.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ezioshiki.twittersearcher.R;
import com.ezioshiki.twittersearcher.domain.eventbus.AoaFailedEvent;
import com.ezioshiki.twittersearcher.domain.eventbus.RxBus;
import com.ezioshiki.twittersearcher.domain.eventbus.RxBusEvent;
import com.ezioshiki.twittersearcher.domain.interactor.Interactor;
import com.ezioshiki.twittersearcher.presentation.Navigator;
import com.ezioshiki.twittersearcher.presentation.TsApplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

/**
 * SearchActivity , the first screen of this app.
 *
 * This activity is so simple and little data loaded,
 * So it needn't a presenter, it interact with Interactor directly.
 * */
public class SearchActivity extends BaseActivity {

  @Inject Navigator mNavigator;
  @Inject Interactor mInteractor;
  @Inject RxBus mRxBus;

  @Bind(R.id.search_act_search_bar) EditText mSearchBar;
  @Bind(R.id.search_act_search_button) ImageButton mSearchBtn;
  @Bind(R.id.search_act_notify_text) TextView mNotifyText;
  @Bind(R.id.search_act_select_language) Button mLanguageBtn;
  @Bind(R.id.search_act_select_location) Button mLocationBtn;

  @OnClick(R.id.search_act_search_button)
  public void search(View view){
    searchTwitter();
  }

  private void searchTwitter() {
    if (mSearchBar.getText()!=null) {
      mNavigator.navigateToSearchResultActivity(this,mSearchBar.getText().toString());
    }
  }

  @OnClick(R.id.search_act_select_language)
  public void popupLanguageSelectDialog(View view){
    new AlertDialog.Builder(this).setTitle("选择语言")
        .setItems(R.array.display_language, new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            mLanguageBtn.setText(mDisplayedLangs[which]);
            mInteractor.setLanguageToSp(mDisplayedLangs[which]);
            dialog.dismiss();
          }
        }).create().show();
  }

  @OnClick(R.id.search_act_select_location)
  public void popupLocationSelectDialog(View view){
    new AlertDialog.Builder(this).setTitle("选择城市")
        .setItems(R.array.display_location, new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            mLocationBtn.setText(mDisplayedLocations[which]);
            mInteractor.setLocationToSp(mDisplayedLocations[which]);
            dialog.dismiss();
          }
        }).create().show();
  }

  String[] mDisplayedLangs;
  String[] mDisplayedLocations;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    TsApplication.getComponent(this).inject(this);

    mDisplayedLangs = getResources().getStringArray(R.array.display_language);
    mDisplayedLocations = getResources().getStringArray(R.array.display_location);

    ButterKnife.bind(this);

    mLanguageBtn.setText(mInteractor.getDisplayedLanguage());
    mLocationBtn.setText(mInteractor.getDisplayedLocation());
    mInteractor.getBearerTokenAndStore();
  }



  @Override protected List<Subscription> createAutoManagerSubscriptions() {
    List<Subscription> list = new ArrayList<>();
    list.add(listenRxBus());
    // add subscription here
    return list;
  }

  private Subscription listenRxBus(){
    return mRxBus.listen().subscribe(new Action1<RxBusEvent>() {
      @Override public void call(RxBusEvent rxBusEvent) {
        if (rxBusEvent instanceof AoaFailedEvent){
          showCannotReachTwitterServerNoti();
        }
      }
    });
  }

  private void showCannotReachTwitterServerNoti() {
    mNotifyText.setVisibility(View.VISIBLE);
    mSearchBtn.setEnabled(false);
  }

  public static Intent getCallingIntent(Context context) {
    return new Intent(context,SearchActivity.class);
  }
}
