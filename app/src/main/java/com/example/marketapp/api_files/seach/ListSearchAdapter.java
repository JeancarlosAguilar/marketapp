package com.example.marketapp.api_files.seach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marketapp.R;
import com.example.marketapp.api_files.garments.Garments;
import com.example.marketapp.api_files.garments.ListGarmentsAdapter;

import java.util.ArrayList;

public class ListSearchAdapter extends RecyclerView.Adapter<ListSearchAdapter.ViewHolder> {

    private ArrayList<Search> dataset;
    private Context context;
    private final ListSearchAdapter.OnItemClickListener listener;

    public ListSearchAdapter(Context context, ListSearchAdapter.OnItemClickListener listener) {
        this.context = context;
        dataset = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListSearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ListSearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSearchAdapter.ViewHolder holder, int position) {
        Search item = dataset.get(position);
        holder.bind(item, listener);
        holder.TextViewSearch.setText(item.getTitle());

        Glide.with(context).load(item.getThumbnail())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ImageViewSearch);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListSearch(ArrayList<Search> listSearch) {
        dataset.addAll(listSearch);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private android.widget.ImageView ImageViewSearch;
        private android.widget.TextView TextViewSearch;

        public ViewHolder(View itemView) {
            super(itemView);
            ImageViewSearch = itemView.findViewById(R.id.ImageViewSearch);
            TextViewSearch = itemView.findViewById(R.id.TextViewSearch);
        }

        public void bind(final Search item, final ListSearchAdapter.OnItemClickListener listener) {
            itemView.setOnClickListener(view -> {
                listener.onItemClick(item);
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Search item);
    }

}
