package com.example.marketapp.api_files.Garments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marketapp.R;

import java.util.ArrayList;

public class ListGarmentsAdapter extends RecyclerView.Adapter<ListGarmentsAdapter.ViewHolder> {

    private ArrayList<Garments> dataset;
    private Context context;

    public ListGarmentsAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_garments, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Garments item = dataset.get(position);
        holder.TextViewGarments.setText(item.getTitle());

        Glide.with(context).load(item.getThumbnail())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ImageViewGarments);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListGarments(ArrayList<Garments> listGarments) {
        dataset.addAll(listGarments);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private android.widget.ImageView ImageViewGarments;
        private android.widget.TextView TextViewGarments;

        public ViewHolder(View itemView) {
            super(itemView);

            ImageViewGarments = itemView.findViewById(R.id.ImageViewGarments);
            TextViewGarments = itemView.findViewById(R.id.TextViewGarments);
        }
    }
}
