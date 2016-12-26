package com.santossingh.readerslibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.santossingh.readerslibrary.BaseFragment.OnListFragmentInteractionListener;
import com.santossingh.readerslibrary.Database.Item;

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

    public RecyclerViewAdapter(List<Item> itemList, OnListFragmentInteractionListener listener) {
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
        holder.mIdView.setText(itemList.get(position).getVolumeInfo().getTitle());
        holder.mContentView.setText(itemList.get(position).getVolumeInfo().getDescription());

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
        public final TextView mIdView;
        public final TextView mContentView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
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
