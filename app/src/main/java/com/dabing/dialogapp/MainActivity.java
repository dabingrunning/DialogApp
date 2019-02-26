package com.dabing.dialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dabing.dialogapp.dialog.BottomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomDialog bottomDialog = new BottomDialog(this,null);
        bottomDialog.show();
    }
}
