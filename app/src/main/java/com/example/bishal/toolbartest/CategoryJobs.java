package com.example.bishal.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CategoryJobs extends ActionBarActivity {
    private Toolbar toolbar;

    public static String category;
    public static String NAME = "";
    public static String RANGE = "";
    public static String DESCRIPTION = "";

    ListView listView;
    String[] titles = {
            "Job 1",
            "Job 2",
            "Job 3",
            "Job 4",
            "Job 5"
    };
    String[] range = {
            "Price Range 1",
            "Price Range 2",
            "Price Range 3",
            "Price Range 4",
            "Price Range 5"
    };
    String[] description = {
            "A Short Description about job 1",
            "A Short Description about job 2",
            "A Short Description about job 3",
            "A Short Description about job 4",
            "A Short Description about job 5"
    };
    String[] bids = {
            "1st Bid",
            "2nd Bid",
            "3rd Bid",
            "4th Bid",
            "5th Bid"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_jobs);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        category = getIntent().getStringExtra(HireMeActivity.CATEGORY_TEXT);

        if ("seekcategory".equals(category)) {
            CategoryAdapter adapter = new CategoryAdapter(this, titles, range, bids);
            listView = (ListView) findViewById(R.id.list_items);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(CategoryJobs.this, CategoryJobsClickedSEEK.class);
                    NAME = titles[position];
                    RANGE = range[position];
                    DESCRIPTION = description[position];
                    i.putExtra(NAME, NAME);
                    i.putExtra(RANGE, RANGE);
                    i.putExtra(DESCRIPTION, DESCRIPTION);

                    startActivity(i);

                }
            });
        }
        if ("hirecategory".equals(category)) {
            CategoryAdapter adapter = new CategoryAdapter(this, titles, range, bids);
            listView = (ListView) findViewById(R.id.list_items);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i = new Intent(CategoryJobs.this, CategoryJobsClickedHIRE.class);
                        startActivity(i);

                }
            });
        }

    }

}
