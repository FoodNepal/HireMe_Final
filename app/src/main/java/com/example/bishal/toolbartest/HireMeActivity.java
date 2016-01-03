package com.example.bishal.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HireMeActivity extends ActionBarActivity implements View.OnClickListener {

    public static String HIRE_TEXT;
    public static String HIRE_FROM_CLICKED;
    public static String HIRE_FROM_CLICKED2;
    public static String SEEK_TEXT;
    public static String CATEGORY_TEXT;
    UserLocalStore userLocalStore;


    ListView listView;
    String [] titles = {
            "Home Tutor",
            "Plumber",
            "Interior Design",
            "ELectrician",
            "Programmer",
            "Painter",
            "Manager"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_me);
        HIRE_TEXT = getIntent().getStringExtra(MainPage.HIRE_TEXT);
        HIRE_FROM_CLICKED = getIntent().getStringExtra(CategoryJobsClickedSEEK.HIRE_FROM_CLICKED);
        HIRE_FROM_CLICKED2 = getIntent().getStringExtra(HireForm.HIRE_FROM_CLICKED);
        SEEK_TEXT = getIntent().getStringExtra(MainPage.SEEK_TEXT);


        userLocalStore = new UserLocalStore(this);

        if (("HIRE".equals(HIRE_TEXT)) || ("HIRE".equals(HIRE_FROM_CLICKED2))) {
            HireMeAdapter adapter = new HireMeAdapter(this,titles);
            listView = (ListView) findViewById(R.id.list_items);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(HireMeActivity.this,HireForm.class);
                    startActivity(i);

                }
            });


        }
        if (("SEEK".equals(SEEK_TEXT)) || ("SEEK".equals(HIRE_FROM_CLICKED))) {
            HireMeAdapter adapter = new HireMeAdapter(this,titles);
            listView = (ListView) findViewById(R.id.list_items);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(HireMeActivity.this, CategoryJobs.class);
                    CATEGORY_TEXT = "seekcategory";
                    i.putExtra(CATEGORY_TEXT, CATEGORY_TEXT);

                    startActivity(i);

                }
            });
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
            // displayUserDetails();
            //new code text


        } else {

//            startActivity(new Intent(HireMeActivity.this,Login.class));

        }
    }

    private boolean authenticate() {
        return userLocalStore.getUserLoggedIn();

    }

    private void displayUserDetails() {

        User user = userLocalStore.getLoggedInUser();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


        }

    }
}
