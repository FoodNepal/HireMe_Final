package com.example.bishal.toolbartest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CategoryClickedAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] range;


    public CategoryClickedAdapter(Activity context, String[] itemname, String[] range) {
        super(context, R.layout.category_clicked_items, itemname);
        this.context = context;
        this.itemname = itemname;
        this.range = range;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.category_clicked_items, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView2);

        txtTitle.setText(itemname[position]);
        extratxt.setText(range[position]);

        return rowView;

    }


}