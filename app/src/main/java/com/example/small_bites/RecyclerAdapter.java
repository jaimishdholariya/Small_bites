package com.example.small_bites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<SearchModel> arrlist;
    public RecyclerAdapter(Context context,ArrayList<SearchModel> arrlist)
    {
        this.context = context;
        this.arrlist = arrlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.foodserchitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.time.setImageResource(arrlist.get(position).img);
        holder.txtname.setText(arrlist.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView time;
        TextView txtname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.time);
            txtname = itemView.findViewById(R.id.txtname);
        }
    }
}
