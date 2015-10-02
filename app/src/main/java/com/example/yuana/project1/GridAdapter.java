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
public class GridAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String >> data;
    private LayoutInflater inflater;
    private TextView tvTitle;

    public GridAdapter(Activity act, ArrayList<HashMap<String, String>> dat){
        activity = act;
        data = dat;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vi = view;

        vi = inflater.inflate(R.layout.grid_adapter,null);
        tvTitle = (TextView) vi.findViewById(R.id.tv_title);

        tvTitle.setText(data.get(i).get("title"));

        final String title = data.get(i).get("title");
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(" ini isinya loh",title);
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
