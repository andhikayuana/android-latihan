package com.example.yuana.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi component
    EditText et_input1, et_input2;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mengenalkan component ke activitynya
        et_input1 = (EditText) findViewById(R.id.et_input1);
        et_input2 = (EditText) findViewById(R.id.et_input2);
        bt_login = (Button) findViewById(R.id.bt_login);


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_input1.getText().toString();
                String password = et_input2.getText().toString();

//              Log.v("EditText", isi_text);

                login(username, password);
            }
        });

    }

    //menu untuk yang di kanan
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void login(String username, String password){

        if (username.equals("andhikayuana") && password.equals("yuana")){
            Toast.makeText(MainActivity.this,"Anda berhasil Login",Toast.LENGTH_SHORT).show();

            //memanggil secondactivity
            Intent second = new Intent(MainActivity.this, SecondActivity.class);

            second.putExtra("data","ini dari login");

            //menjalankan
            startActivity(second);
        }
        else{
            Toast.makeText(MainActivity.this,"Anda Gagal Login", Toast.LENGTH_SHORT).show();
        }

    }
}
