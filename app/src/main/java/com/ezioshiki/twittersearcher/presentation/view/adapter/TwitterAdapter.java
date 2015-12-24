package com.ezioshiki.twittersearcher.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezioshiki.twittersearcher.R;
import com.ezioshiki.twittersearcher.presentation.model.TwitterModel;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by EzioShiki on 15/12/23.
 */
public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.ViewHolder>{

  private List<TwitterModel> mTwitters;
  private Context mContext;

  public TwitterAdapter(Context context,Collection<TwitterModel> twitters) {
    validateTwitterCollection(twitters);
    mTwitters = (List<TwitterModel>) twitters;
    mContext = context;
  }

  @Override public TwitterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.twitter,parent,false);
    ViewHolder vh = new ViewHolder(view);
    return vh;
  }

  @Override public void onBindViewHolder(TwitterAdapter.ViewHolder holder, int position) {
    holder.mUsername.setText("@"+mTwitters.get(position).getUserAtName());
    holder.mUserDisplayName.setText(mTwitters.get(position).getUserDisplayName());
    holder.mTwitterText.setText(mTwitters.get(position).getTwitterText());
    try {
      Picasso.with(mContext).load(mTwitters.get(position).getUserProfileImageUrlHttps())
          .into(holder.mUserProfilePhoto);
      //only show photo media for this demo
      if (TwitterModel.MEDIA_PHOTO.equals(mTwitters.get(position).getDisplayedMediaType())) {
        Picasso.with(mContext).load(mTwitters.get(position).getDisplayedMediaUrlHttps())
            .into(holder.mTwitterPhoto);
      }else {
        holder.mTwitterPhoto.setImageBitmap(null);
        holder.mTwitterPhoto.setVisibility(View.GONE);
      }
    }catch (NullPointerException | IndexOutOfBoundsException e){
      e.printStackTrace();
      holder.mTwitterPhoto.setVisibility(View.GONE);
    }
  }

  @Override public int getItemCount() {
    return mTwitters.size();
  }

  public void setTwitterCollection(Collection<TwitterModel> twitters) {
    validateTwitterCollection(twitters);
    mTwitters = (List<TwitterModel>) twitters;
    notifyDataSetChanged();
  }

  private void validateTwitterCollection(Collection<TwitterModel> twitters) {
    if (twitters==null){
      throw new IllegalArgumentException("Twitters cannot be null");
    }
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.user_profile) ImageView mUserProfilePhoto;
    @Bind(R.id.twitter_photo) ImageView mTwitterPhoto;
    @Bind(R.id.user_display_name) TextView mUserDisplayName;
    @Bind(R.id.username) TextView mUsername;
    @Bind(R.id.twitter_text) TextView mTwitterText;


    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);
    }
  }
}
