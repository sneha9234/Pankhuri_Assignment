package com.example.pankhuri.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.pankhuri.Model.videos;
import com.example.pankhuri.R;

public class videos_adapter extends BaseAdapter {

    private com.example.pankhuri.Model.videos[] videos;
    private Context context;

    public videos_adapter(videos[] videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return videos.length;
    }

    @Override
    public Object getItem(int position) {
        return videos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        VideoView video;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final videos_adapter.ViewHolder holder;

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_videos, null);
            holder = new videos_adapter.ViewHolder();
            holder.video = convertView.findViewById(R.id.video);

            convertView.setTag(holder);
        }else{
            holder = (videos_adapter.ViewHolder) convertView.getTag();
        }

        String LINK = videos[position].getVideoUrl();

        MediaController mc = new MediaController(context);
        mc.setAnchorView(holder.video);
        mc.setMediaPlayer(holder.video);

        int iDisplayWidth = context.getResources().getDisplayMetrics().widthPixels ;

        int iImageWidth = iDisplayWidth / 3 ;
        holder.video.setLayoutParams(new ConstraintLayout.LayoutParams(iImageWidth,iImageWidth));

        if(LINK!= null) {
            Uri video = Uri.parse(LINK);
            holder.video.setMediaController(mc);
            holder.video.setVideoURI(video);
        }
        holder.video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                holder.video.start();
            }
        });

        return convertView;
    }
}

