package com.example.yuana.project1;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListFragment extends Fragment {
    ListAdapters listAdapter;
    ListView lvList;

    private ProgressDialog loading;

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

        final ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        ParentRestClient.get("buku/apibuku", null, new JsonHttpResponseHandler(){

            @Override
            public void onStart() {
                loading = new ProgressDialog(getActivity());
                loading.setMessage("Loading dulu gan");
                loading.show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try{

                    for (int i = 0; i < response.length(); i++){
                        JSONObject buku = response.getJSONObject(i);
                        String judul = buku.getString("judul");
                        String harga = buku.getString("harga");

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put("judul",judul);
                        map.put("harga",harga);
                        map.put("duedate", "02 Oktober 2015");

                        mylist.add(map);
                    }

                    listAdapter = new ListAdapters(getActivity(), mylist);

                    lvList.setAdapter(listAdapter);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onFinish() {
                if (loading.isShowing()){
                    loading.dismiss();
                }
            }
        });

//        for (int i =1; i<11; i++){
//            try{
//                HashMap<String, String> map = new HashMap<String, String>();
//
//                map.put("task", "Perbaikan Jalur Speedy");
//                map.put("location", "PT Geschool - "+i);
//                map.put("duedate", "02 Oktober 2015");
//
//                mylist.add(map);
//            }
//            catch (Exception e){
//
//            }
//        }

//        listAdapter = new ListAdapters(getActivity(), mylist);
//
//        lvList.setAdapter(listAdapter);
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
