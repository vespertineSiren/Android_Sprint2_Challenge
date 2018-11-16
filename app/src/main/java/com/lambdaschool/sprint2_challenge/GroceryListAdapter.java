package com.lambdaschool.sprint2_challenge;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.ViewHolder> {
    static class ViewHolder extends  RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.parent_view);
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.image_name);
        }
    }

    private ArrayList<Grocery> groceries;
    private Context context;
    private Activity activity;

    public GroceryListAdapter(ArrayList<Grocery> groceries, Activity activity) {
        this.groceries = groceries;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.grocery_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Grocery thing = groceries.get(position);
        holder.textView.setText(thing.getName()
                .replaceAll("\\d", "").replaceAll("_", ""));
        //holder.imageView.setImageURI();

    }
}