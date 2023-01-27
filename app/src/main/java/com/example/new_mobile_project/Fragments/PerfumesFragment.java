package com.example.new_mobile_project.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_mobile_project.Adapters.ProductListAdapter;
import com.example.new_mobile_project.Database.EcommerceDatabase;
import com.example.new_mobile_project.Models.ProductModel;
import com.example.new_mobile_project.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfumesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfumesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfumesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LabtopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfumesFragment newInstance(String param1, String param2) {
        PerfumesFragment fragment = new PerfumesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_perfumes, container, false);

        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        ProductListAdapter adapter;
        ArrayList<ProductModel> productsList = new ArrayList<>();
        EcommerceDatabase database;

        recyclerView = rootview.findViewById(R.id.recyclerviewperfumes);
        database = new EcommerceDatabase(getActivity().getApplicationContext());
        Cursor cursor = database.getProducts("3");
        while (!cursor.isAfterLast())
        {
            ProductModel products = new ProductModel(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(4),cursor.getInt(3));
            productsList.add(products);
            cursor.moveToNext();
        }
        adapter = new ProductListAdapter(productsList,getActivity().getApplicationContext());

        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return rootview;
    }
}