package com.example.yuana.project1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yuana on 02/10/15.
 */
public class ListAdapters extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String >> data;
    private LayoutInflater inflater;
    private TextView tvTask, tvLocation, tvDuedate;

    public ListAdapters(Activity act, ArrayList<HashMap<String, String>> dat){
        activity = act;
        data = dat;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @Override
    public Object getItem(int i){
        return i;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View vi = view;

        vi = inflater.inflate(R.layout.list_adapter, null);
        tvTask = (TextView) vi.findViewById(R.id.tv_task);
        tvLocation = (TextView) vi.findViewById(R.id.tv_location);
        tvDuedate = (TextView) vi.findViewById(R.id.tv_duedate);

        tvTask.setText(data.get(i).get("judul"));
        tvLocation.setText(data.get(i).get("harga"));
        tvDuedate.setText(data.get(i).get("duedate"));

        final String judul = data.get(i).get("judul");
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("  judulnya ",judul);
            }
        });
        return vi;
    }

    private void showDialog(String msg, String title){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
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
