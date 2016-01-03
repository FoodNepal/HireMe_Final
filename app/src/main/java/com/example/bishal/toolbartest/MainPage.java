package com.example.bishal.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainPage extends ActionBarActivity {

    public static String HIRE_TEXT="";
    public static String SEEK_TEXT="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


    }

    public void hireClick(View view) {
        Intent i = new Intent(MainPage.this,HireMeActivity.class);
        HIRE_TEXT = "HIRE";
        SEEK_TEXT="";
        i.putExtra(HIRE_TEXT,HIRE_TEXT);
        startActivity(i);

    }

    public void seekClick(View view) {
        Intent i = new Intent(MainPage.this,HireMeActivity.class);
        SEEK_TEXT = "SEEK";
        HIRE_TEXT="";
        i.putExtra(SEEK_TEXT,SEEK_TEXT);
        startActivity(i);
    }
}
