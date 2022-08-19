package com.example.sqlconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickConnect(View view) {

        ConnectionHelper con = new ConnectionHelper(view);

        try
        {
            con.open();
        }
        catch (Exception e) {
            Log.e("error ", e.getMessage());
        }
    }
}