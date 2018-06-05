package com.badran.aodai.androideatitserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.badran.aodai.androideatitserver.Common.Common;
import com.badran.aodai.androideatitserver.Interface.ItemClickListener;
import com.badran.aodai.androideatitserver.R;

/**
 * Created by aodai on 01/06/2018.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{

    public TextView food_name;
    public ImageView food_image;

    private ItemClickListener itemClickListener;

    public FoodViewHolder(View itemView) {
        super(itemView);

        food_name=(TextView)itemView.findViewById(R.id.food_name);
        food_image = (ImageView)itemView.findViewById(R.id.food_image);


        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);


    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {

        contextMenu.setHeaderTitle("Select the action");

        contextMenu.add(0,0,getAdapterPosition(), Common.UPDATE);
        contextMenu.add(0,0,getAdapterPosition(), Common.DELETE);

    }
}

