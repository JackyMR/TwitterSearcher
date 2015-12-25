package com.ezioshiki.twittersearcher.presentation.view.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezioshiki.twittersearcher.R;
import com.ezioshiki.twittersearcher.presentation.model.TwitterModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by EzioShiki on 15/12/23.
 *
 * Adaptar that manages a collection of {@link TwitterModel}.
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

  @Override public void onBindViewHolder(TwitterAdapter.ViewHolder holder, final int position) {
    holder.mUsername.setText("@"+mTwitters.get(position).getUserAtName());
    holder.mUserDisplayName.setText(mTwitters.get(position).getUserDisplayName());
    holder.mTwitterText.setText(mTwitters.get(position).getTwitterText());



    try {

      //show user profile photo
      String userProfileUrl = mTwitters.get(position).getUserProfileImageUrlHttps();
      if (holder.mUserProfilePhoto.getTag()==null||
          !holder.mUserProfilePhoto.getTag().equals(userProfileUrl)) {
        Picasso.with(mContext).load(userProfileUrl).placeholder(R.drawable.square48_placehodler_image)
            .fit().into(holder.mUserProfilePhoto);
        holder.mUserProfilePhoto.setTag(userProfileUrl);
      }
      //only show photo media for this demo
      if (TwitterModel.MEDIA_PHOTO.equals(mTwitters.get(position).getDisplayedMediaType())) {
        String mediaUrl = mTwitters.get(position).getDisplayedMediaUrlHttps();
        if (holder.mTwitterPhoto.getTag()==null||!holder.mTwitterPhoto.getTag().equals(mediaUrl)){

//          if (position==0){
//            Timber.i("Get image! image url: "+mediaUrl);
//          }


          Picasso.with(mContext)
              .load(mediaUrl).placeholder(R.drawable.linear_placeholder_image)
              .into(holder.mTwitterPhoto, new Callback() {
                @Override public void onSuccess() {
                  //debug info
                  if (position==0) {
                    Timber.i("onSuccess");
                  }
                }

                @Override public void onError() {
                  if (position==0) {
                    Timber.i("onError");
                  }
                }
              });

          holder.mTwitterPhoto.setVisibility(View.VISIBLE);
        }else {

        }
        holder.mTwitterPhoto.setTag(mediaUrl);


      }else {
        if (position==0){
          Timber.i("Media type isn't photo! Hide pic!");
        }
        holder.mTwitterPhoto.setImageBitmap(null);
        holder.mTwitterPhoto.setVisibility(View.GONE);
      }
    }catch (NullPointerException | IndexOutOfBoundsException e){
      e.printStackTrace();
      holder.mTwitterPhoto.setImageBitmap(null);
      holder.mTwitterPhoto.setVisibility(View.GONE);
      Timber.i("Have a error in Loading image!");
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

  public static class DividerItemDecoration extends RecyclerView.ItemDecoration{

    private int mItemSize = 1;
    private Paint mPaint;

    private static final int[] ATTRS = new int[]{
        android.R.attr.listDivider
    };

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;

    private int mOrientation;

    public DividerItemDecoration(Context context, int orientation) {
      final TypedArray a = context.obtainStyledAttributes(ATTRS);
      mDivider = a.getDrawable(0);
      a.recycle();
      setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
      if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
        throw new IllegalArgumentException("invalid orientation");
      }
      mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
      //Log.v("recyclerview - itemdecoration", "onDraw()");

      if (mOrientation == VERTICAL_LIST) {
        drawVertical(c, parent);
      } else {
        drawHorizontal(c, parent);
      }

    }


    public void drawVertical(Canvas c, RecyclerView parent) {
      final int left = parent.getPaddingLeft();
      final int right = parent.getWidth() - parent.getPaddingRight();

      final int childCount = parent.getChildCount();
      for (int i = 0; i < childCount; i++) {
        final View child = parent.getChildAt(i);
        android.support.v7.widget.RecyclerView v = new android.support.v7.widget.RecyclerView(parent.getContext());
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
            .getLayoutParams();
        final int top = child.getBottom() + params.bottomMargin;
        final int bottom = top + mDivider.getIntrinsicHeight();
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(c);
      }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
      final int top = parent.getPaddingTop();
      final int bottom = parent.getHeight() - parent.getPaddingBottom();

      final int childCount = parent.getChildCount();
      for (int i = 0; i < childCount; i++) {
        final View child = parent.getChildAt(i);
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
            .getLayoutParams();
        final int left = child.getRight() + params.rightMargin;
        final int right = left + mDivider.getIntrinsicHeight();
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(c);
      }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
      if (mOrientation == VERTICAL_LIST) {
        outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
      } else {
        outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
      }
    }
  }
}
