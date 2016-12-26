package com.santossingh.readerslibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.santossingh.readerslibrary.BaseFragment.OnListFragmentInteractionListener;
import com.santossingh.readerslibrary.Database.Item;
import com.santossingh.readerslibrary.Utilities.DynamicHeightNetworkImageView;
import com.santossingh.readerslibrary.Utilities.ImageLoaderHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Item} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Item> itemList = new ArrayList<Item>();
    private OnListFragmentInteractionListener mListener;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Item> itemList, OnListFragmentInteractionListener listener) {
        this.context = context;
        this.itemList = itemList;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = itemList.get(position);

        holder.dynamicImageView.setImageUrl(holder.mItem.getVolumeInfo().getImageLinks().getThumbnail(),
                ImageLoaderHelper.getInstance(context).getImageLoader());
        holder.dynamicImageView.setAspectRatio(0.73f);

//        Glide.with(context).load(holder.mItem.getVolumeInfo().getImageLinks().getThumbnail())
//                .placeholder(R.drawable.book1)
//                .crossFade()
//                .into(holder.mImageView);
        holder.mIdView.setText(holder.mItem.getVolumeInfo().getTitle());

//        String rating=holder.mItem.getVolumeInfo().getAuthors().get(0);
        holder.mContentView.setText(holder.mItem.getVolumeInfo().getPublishedDate() != null ? "Published: " + holder.mItem.getVolumeInfo().getPublishedDate() : "Published: Not available");
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //        public final ImageView mImageView;
        public final TextView mIdView;
        public final TextView mContentView;
        private final DynamicHeightNetworkImageView dynamicImageView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mImageView=(ImageView) view.findViewById(R.id.thumbnail);
            dynamicImageView = (DynamicHeightNetworkImageView) view.findViewById(R.id.thumbnail);
            mIdView = (TextView) view.findViewById(R.id.Title);
            mContentView = (TextView) view.findViewById(R.id.Aurthor);


        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

//        @Override
//        public void onClick(View view) {
//            int position=getAdapterPosition();
//            mListener.onListFragmentInteraction(itemList.get(position));
//        }
    }

    public void addList(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }
}
