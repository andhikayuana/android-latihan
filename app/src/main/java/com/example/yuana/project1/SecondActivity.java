package com.example.yuana.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

//    TextView tv_second_act;

    private static String TAG = SecondActivity.class.getSimpleName();

    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();

    private CharSequence mTitle;

    private void selectItemFromDrawer(int position){

        android.app.Fragment fragment = new HomeFragment();
        Log.i("position",""+position);
        if(position == 0){
            fragment = new HomeFragment();
        }else if(position == 1){
            fragment = new MyInboxFragment();
        }else if(position == 2){
            fragment = new TeamViewFragment();
        }

        if(fragment != null) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            setTitle(mNavItems.get(position).mTitle);

            // Close the drawer
            mDrawerLayout.closeDrawer(mDrawerPane);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);

        mNavItems.add(new NavItem("TODO", "The list task", R.drawable.ic_my_task));
        mNavItems.add(new NavItem("Messages", "Send message", R.drawable.ic_my_inbox));
        mNavItems.add(new NavItem("Contact", "Contact Friends", R.drawable.ic_team_view));

        //drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //populate the nav drawer w/ opsi
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);

        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

        //drawer item click listener

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d(TAG, "onDrawerClosed: " + getTitle());

                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            //attachFragment(new MytaskFragment());
            selectItemFromDrawer(0);
        }
 /*
        //ambil dari MainActivity
        String data = getIntent().getStringExtra("data");

        Toast.makeText(SecondActivity.this, data, Toast.LENGTH_SHORT).show();
        tv_second_act = (TextView) findViewById(R.id.tv_second_act);
        tv_second_act.setText(data);*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
