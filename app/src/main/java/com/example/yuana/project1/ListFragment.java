package com.example.yuana.project1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListFragment extends Fragment {
    ListAdapters listAdapter;
    ListView lvList;

    public ListFragment(){
        //constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list,container,false);
        lvList = (ListView) rootView.findViewById(R.id.lv_list);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        for (int i =1; i<11; i++){
            try{
                HashMap<String, String> map = new HashMap<String, String>();

                map.put("task", "Perbaikan Jalur Speedy");
                map.put("location", "PT Geschool - "+i);
                map.put("duedate", "02 Oktober 2015");

                mylist.add(map);
            }
            catch (Exception e){

            }
        }

        listAdapter = new ListAdapters(getActivity(), mylist);

        lvList.setAdapter(listAdapter);
        //untuk event klik ada 2 cara
        //pertama di sini
        //kedua di ListAdapternya => kelebihan bisa langsung ngisi datanya
        //----------------------------
        /*lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //action in here

                //showDialog("ini isinya HALO => "+i,"JUDULNYA => "+i);
            }
        });*/

        return rootView;
    }

    private void showDialog(String msg, String title){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        // set title
        alertDialogBuilder.setTitle(title);
        // set dialog message
        alertDialogBuilder.setMessage(Html.fromHtml(msg)).setCancelable(true);
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }


}
