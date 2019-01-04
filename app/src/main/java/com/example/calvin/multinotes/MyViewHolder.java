package com.example.calvin.multinotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView time;
    public TextView content;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        time  = itemView.findViewById(R.id.time);
        content = itemView.findViewById(R.id.content);
    }
}
