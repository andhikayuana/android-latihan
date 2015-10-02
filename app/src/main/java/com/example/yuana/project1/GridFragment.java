package com.example.yuana.project1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;


public class GridFragment extends Fragment {

    GridAdapter gridAdapter;
    GridView gridView;

    public GridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_grid, container, false);
        gridView = (GridView) rootview.findViewById(R.id.gv_grid);

        ArrayList<HashMap<String, String>> mygrid = new ArrayList<HashMap<String, String>>();

        for (int i = 1; i<25; i++){
            try{
                HashMap<String, String> map = new HashMap<String, String>();

                map.put("title", "PT Geschool");

                mygrid.add(map);
            }
            catch (Exception e){

            }
        }

        gridAdapter = new GridAdapter(getActivity(), mygrid);
        gridView.setAdapter(gridAdapter);

        return rootview;
    }

}
