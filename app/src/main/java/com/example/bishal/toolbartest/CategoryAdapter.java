package com.example.bishal.toolbartest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] range;
    private final String[] noOfbids;


    public CategoryAdapter(Activity context, String[] itemname,String[] range,String[] noOfbids) {
        super(context, R.layout.category_items, itemname);
        this.context = context;
        this.itemname = itemname;
        this.range = range;
        this.noOfbids = noOfbids;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.category_items, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView2);
        TextView bids = (TextView) rowView.findViewById(R.id.textView3);

        txtTitle.setText(itemname[position]);
        extratxt.setText(range[position]);
        bids.setText(noOfbids[position]);

        return rowView;

    }


}