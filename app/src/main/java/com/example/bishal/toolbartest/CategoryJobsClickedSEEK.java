package com.example.bishal.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryJobsClickedSEEK extends ActionBarActivity {
    public static String HIRE_FROM_CLICKED = "";
    public static String NAME;
    public static String RANGE;
    public static String DESCRIPTION;


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
        setContentView(R.layout.activity_category_jobs_clicked);

        NAME = getIntent().getStringExtra(CategoryJobs.NAME);
        RANGE = getIntent().getStringExtra(CategoryJobs.RANGE);
        DESCRIPTION = getIntent().getStringExtra(CategoryJobs.DESCRIPTION);


        CategoryClickedAdapter adapter = new CategoryClickedAdapter(this, titles, range);
        listView = (ListView) findViewById(R.id.list_items);
        listView.setAdapter(adapter);

        EditText editText;
        editText = (EditText) findViewById(R.id.bidPrice);
        TextView yourBidPrice = (TextView) findViewById(R.id.yourBidPrice);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView1.setText(NAME);
        textView2.setText(RANGE);
        textView3.setText(DESCRIPTION);
        int price = Integer.parseInt(editText.getText().toString());
        yourBidPrice.setText(price + "");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        EditText editText;
        editText = (EditText) findViewById(R.id.bidPrice);
        TextView yourBidPrice = (TextView) findViewById(R.id.yourBidPrice);
        int price = Integer.parseInt(editText.getText().toString());
        yourBidPrice.setText(price + "");

    }

    public void subtract(View view) {
        EditText editText;
        editText = (EditText) findViewById(R.id.bidPrice);
        int price = Integer.parseInt(editText.getText().toString());
        price = price - 100;
        editText.setText(price + "");

    }

    public void add(View view) {

        EditText editText;
        editText = (EditText) findViewById(R.id.bidPrice);
        int price = Integer.parseInt(editText.getText().toString());
        price = price + 100;
        editText.setText(price + "");
    }

    public void placeBid(View view) {
        EditText editText;
        editText = (EditText) findViewById(R.id.bidPrice);
        TextView yourBidPrice = (TextView) findViewById(R.id.yourBidPrice);
        int price = Integer.parseInt(editText.getText().toString());
        yourBidPrice.setText(price + "");
        Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(CategoryJobsClickedSEEK.this, HireMeActivity.class);
        HIRE_FROM_CLICKED = "SEEK";
        i.putExtra(HIRE_FROM_CLICKED, HIRE_FROM_CLICKED);
        startActivity(i);
    }
}
