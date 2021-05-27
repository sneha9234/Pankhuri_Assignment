package com.example.pankhuri.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.pankhuri.Model.photos;
import com.example.pankhuri.R;

public class photos_adapter extends BaseAdapter {

    private com.example.pankhuri.Model.photos[] photos;
    private Context context;

    public photos_adapter(photos[] photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photos.length;
    }

    @Override
    public Object getItem(int position) {
        return photos[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        ImageView myImage;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final photos_adapter.ViewHolder holder;

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_photos, null);
            holder = new photos_adapter.ViewHolder();
            holder.myImage = convertView.findViewById(R.id.myImage);

            convertView.setTag(holder);
        }else{
            holder = (photos_adapter.ViewHolder) convertView.getTag();
        }

        int iDisplayWidth = context.getResources().getDisplayMetrics().widthPixels ;

        int iImageWidth = iDisplayWidth / 3 ;
        holder.myImage.setLayoutParams(new ConstraintLayout.LayoutParams(iImageWidth,iImageWidth));

        Glide.with(context)
                .load(photos[position].getPhotoUrl())
                .centerCrop()
                .into(holder.myImage);


        return convertView;
    }
}


