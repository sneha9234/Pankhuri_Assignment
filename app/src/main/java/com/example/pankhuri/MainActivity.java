package com.example.pankhuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView profile_image;
    TextView no_of_videos, no_of_likes, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile_image = findViewById(R.id.profile_image);
        no_of_likes = findViewById(R.id.no_of_likes);
        no_of_videos = findViewById(R.id.no_of_videos);
        description = findViewById(R.id.decription);

        Glide.with(MainActivity.this)
                .load(getResources().getDrawable(R.drawable.bride))
                .circleCrop()
                .into(profile_image);

        no_of_likes.setText(Html.fromHtml("<font size=20px>1459 </font><b>likes</b>"));
        no_of_videos.setText(Html.fromHtml("<font size=20px>234k </font><b>videos</b>"));
        description.setText("Discription comes amet here Lorem ipsum dolorcon sec tetur sit amet, consectetur elit, amet Lorem ipsum dolorconsec tetur sit amet, consectetur elit, sed do eiusmod tempor incididunt et dolore https://www.instagram.com/stories/arotatvika");
    }
}