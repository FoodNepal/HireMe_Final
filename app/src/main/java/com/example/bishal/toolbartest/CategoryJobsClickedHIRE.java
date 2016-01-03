package com.example.bishal.toolbartest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class CategoryJobsClickedHIRE extends ActionBarActivity {


    ListView listView;
    String[] titles = {
            "Bider 1",
            "Bider 2",
            "Bider 3",
            "Bider 4",
            "Bider 5"
    };
    String[] range = {
            "price1",
            "price2",
            "price3",
            "price4",
            "price5"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_jobs_clicked_hire);

        CategoryClickedAdapter adapter = new CategoryClickedAdapter(this, titles, range);
        listView = (ListView) findViewById(R.id.list_items);
        listView.setAdapter(adapter);

    }

}
