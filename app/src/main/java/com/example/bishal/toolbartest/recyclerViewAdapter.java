package com.example.bishal.toolbartest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.viewHolder> {
    List<NavDrawerItems> itemsData = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public recyclerViewAdapter(Context context, List<NavDrawerItems> itemsData) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        this.itemsData = itemsData;


    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_layout, parent, false);

        viewHolder Holder = new viewHolder(view);

        return Holder;

    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        NavDrawerItems current = itemsData.get(position);
        holder.listText.setText(current.title);
        holder.listDesc.setText(current.titleDesc);
        holder.listIcon.setImageResource(current.iconId);
    }
    @Override
    public int getItemCount() {
        return itemsData.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView listText;
        TextView listDesc;
        ImageView listIcon;
        //constructor
        public viewHolder(View itemView) {
            super(itemView);
            listText = (TextView) itemView.findViewById(R.id.listText);
            listDesc = (TextView) itemView.findViewById(R.id.listDesc);
            listIcon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
