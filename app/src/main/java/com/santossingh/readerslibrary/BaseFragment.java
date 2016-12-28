package com.santossingh.readerslibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.santossingh.readerslibrary.Database.BooksLibrary;
import com.santossingh.readerslibrary.Database.Item;
import com.santossingh.readerslibrary.Services.DataManager;
import com.santossingh.readerslibrary.Utilities.AutofitGridlayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Item.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class BaseFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    RecyclerView recyclerView;
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private DataManager dataManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Item> itemsList;
    private Item firstResult;
    private View view;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BaseFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BaseFragment newInstance(int columnCount) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list, container, false);

        itemsList = new ArrayList<Item>();

        // Set the adapter
        configRecycleView();
        makeService();
        return view;
    }

    private void configRecycleView() {
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), itemsList, mListener);
        recyclerView = (RecyclerView) view.findViewById(R.id.Rlist);
//        int columnCount = getResources().getInteger(R.integer.list_column_count);
        AutofitGridlayout autofitGridlayout = new AutofitGridlayout(getActivity(), 300);
        //    StaggeredGridLayoutManager sglm =
        //            new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(autofitGridlayout);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void makeService() {
        dataManager = new DataManager();
        Call<BooksLibrary> listCall;
        String query = String.valueOf(R.string.Default);
        listCall = dataManager.getJSONData().getPopBooks();

        listCall.enqueue(new Callback<BooksLibrary>() {
            @Override
            public void onResponse(Call<BooksLibrary> call, Response<BooksLibrary> response) {
                if (response.isSuccessful()) {
                    Item[] items = response.body().getItems();
                    itemsList = new ArrayList<Item>(Arrays.asList(items));
                    if (itemsList != null) {
                        recyclerViewAdapter.addList(itemsList);
                        String first = items[0].getId();
                        Toast.makeText(getContext(), first, Toast.LENGTH_LONG).show();
                        Toast.makeText(getContext(), "Successfully fetched", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity(), "Null Value", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BooksLibrary> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Item result);
    }
}
