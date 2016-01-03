package com.example.bishal.toolbartest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HireMeAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
  //  private final String[] itemDesc;
//    private final Integer[] imgid;


    public HireMeAdapter(Activity context, String[] itemname) {
        super(context, R.layout.hire_me_items, itemname);
        this.context = context;
        this.itemname = itemname;
//        this.itemDesc = itemDesc;
 //       this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.hire_me_items, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
      //  TextView extratxt = (TextView) rowView.findViewById(R.id.textView2);

        txtTitle.setText(itemname[position]);
        //imageView.setImageResource(imgid[position]);
    //    extratxt.setText(itemDesc[position]);

        return rowView;

    }


}