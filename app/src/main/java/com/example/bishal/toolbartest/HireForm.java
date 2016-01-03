package com.example.bishal.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class HireForm extends ActionBarActivity {

    public static String HIRE_FROM_CLICKED ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_form);
    }

    public void submitForm(View view) {

        Toast.makeText(getApplicationContext(),"Successful!",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(HireForm.this,HireMeActivity.class);
        HIRE_FROM_CLICKED = "HIRE";
        i.putExtra(HIRE_FROM_CLICKED,HIRE_FROM_CLICKED);
        startActivity(i);
    }
}
