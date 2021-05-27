package com.example.pankhuri.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pankhuri.Model.stories;
import com.example.pankhuri.R;

public class stories_adapter extends RecyclerView.Adapter<stories_adapter.ViewHolder>{
    private com.example.pankhuri.Model.stories[] stories;
    Context context;

    public stories_adapter(stories[] stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_stories, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final stories story = stories[position];

        Glide.with(context)
                .load(story.getImgUrl())
                .circleCrop()
                .into(holder.story_image);

        holder.story_caption.setText(story.getCaption());
    }


    @Override
    public int getItemCount() {
        return stories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView story_image;
        public TextView story_caption;
        public ViewHolder(View itemView) {
            super(itemView);
            this.story_image = itemView.findViewById(R.id.story_image);
            this.story_caption = itemView.findViewById(R.id.story_caption);
        }
    }
}