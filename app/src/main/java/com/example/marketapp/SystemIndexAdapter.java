package com.example.marketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.marketapp.databinding.ItemSystemIndexPopularBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SystemIndexAdapter extends RecyclerView.Adapter<SystemIndexAdapter.SystemIndexHolder> {

    private List<PopularModel> popularModelList;
    private Context context;

    public SystemIndexAdapter(List<PopularModel> listPopularModel) {
        this.popularModelList = listPopularModel;
    }

    @NonNull
    @Override
    public SystemIndexAdapter.SystemIndexHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemSystemIndexPopularBinding itemSystemIndexPopularBinding = ItemSystemIndexPopularBinding.inflate(layoutInflater, parent, false);
        return new SystemIndexHolder(itemSystemIndexPopularBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SystemIndexAdapter.SystemIndexHolder holder, int position) {
        PopularModel popularModel = popularModelList.get(position);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(context).load(popularModel.getImageCategory()).apply(options).into(holder.binding.imageViewPicture);
        Glide.with(context).load(popularModel.getImageCategory()).apply(options).into(holder.binding.imageViewPicture);
        holder.binding.textViewName.setText(popularModel.getNameCategory());
    }

    @Override
    public int getItemCount() {
        return popularModelList.size();
    }


    public void updateAnswers(List<PopularModel> items) {
        popularModelList = items;
        notifyDataSetChanged();
    }

    public PopularModel getPopular(int adapterPosition) {
        return popularModelList.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(String id);
    }

    public final class SystemIndexHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private PostItemListener mItemListener;

        @NotNull
        private final ItemSystemIndexPopularBinding binding;

        public final void render(PopularModel popularModel) {
        }

        @NonNull
        public final ItemSystemIndexPopularBinding getBinding() {
            return this.binding;
        }

        public SystemIndexHolder(@NonNull ItemSystemIndexPopularBinding binding) {
            super((View) binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onClick(View view) {
            PopularModel popularModel = getPopular(getAdapterPosition());
            this.mItemListener.onPostClick(popularModel.getIdCategory());
            notifyDataSetChanged();
        }
    }

}
