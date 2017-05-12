package com.spaceo.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khyati on 12/5/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<NewsModel> list;
    private final OnItemClickListener listener;


    public NewsAdapter(List<NewsModel> newsList,OnItemClickListener listener) {
        this.list = newsList;
        this.listener = listener;
    }


   @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txtName);
            date = (TextView) view.findViewById(R.id.txtDate);
        }

        public void bind(final NewsModel item, final OnItemClickListener listener) {

            title.setText(item.getTitle());
            date.setText(item.getDate());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

        }
    }


    //Interface to handle click event
    public interface OnItemClickListener {
        void onItemClick(NewsModel item);
    }
}
