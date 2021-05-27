package com.example.pankhuri.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.GridView;

import com.bumptech.glide.Glide;
import com.example.pankhuri.databinding.ActivityMainBinding;
import com.example.pankhuri.Model.photos;
import com.example.pankhuri.Adapter.photos_adapter;
import com.example.pankhuri.Model.stories;
import com.example.pankhuri.Adapter.stories_adapter;
import com.example.pankhuri.Model.videos;
import com.example.pankhuri.Adapter.videos_adapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadStories();
        getTabContent(0);

        binding.tabs.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener(){
            public void onTabReselected(TabLayout.Tab tab) {

            }
            public void onTabSelected(TabLayout.Tab tab){
                int tabId = tab.getPosition();
             //   binding.progressbar.setVisibility(View.VISIBLE);
                getTabContent(tabId);

            }
            public void onTabUnselected(TabLayout.Tab tab){

            }
        });

        Glide.with(MainActivity.this)
                .load("https://s3-ap-south-1.amazonaws.com/static.mangalparinay.com/blog/wp-content/uploads/2018/08/indian-bride.jpg")
                .circleCrop()
                .into(binding.profileImage);

        binding.noOfVideos.setText(Html.fromHtml("<big>1459 </big><small><b>videos</b></small>"));
        binding.noOfLikes.setText(Html.fromHtml("<big>234k </big><small><b>likes</b></small>"));

        binding.description.setText("Discription comes amet here Lorem ipsum dolorcon sec tetur sit amet, consectetur elit, amet Lorem ipsum dolorconsec tetur sit amet, consectetur elit, sed do eiusmod tempor incididunt et dolore \nhttps://www.instagram.com/stories/arotatvika");
        Spannable sa = (Spannable)binding.description.getText();
        for (URLSpan u: sa.getSpans(0, sa.length(), URLSpan.class)) {
            sa.setSpan(new UnderlineSpan() {
                public void updateDrawState(TextPaint tp) {
                    tp.setUnderlineText(false);
                }
            }, sa.getSpanStart(u), sa.getSpanEnd(u), 0);
        }

    }

    private void loadStories() {

        stories[] myListData = new stories[]{
                new stories("https://static.toiimg.com/imagenext/toiblogs/photo/readersblog/wp-content/uploads/2020/04/Indian-Bridal-Jewellery.jpg", "Top Works"),
                new stories("https://img.etimg.com/thumb/width-1200,height-900,imgsize-786987,resizemode-1,msid-81535565/prime/consumer/digitising-the-traditional-indian-wedding-market-why-wedmegood-is-up-against-a-herculean-task.jpg", "Wedding"),
                new stories("https://blog.venuelook.com/wp-content/uploads/2019/04/Pre-Wedding-Photoshoot-Destinations-in-India.jpg", "Pre Wedding"),
                new stories("https://telanganatoday.com/wp-content/uploads/2018/01/p6-6.jpg", "Haldi"),
                new stories("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTV-Nutk3cs4puRxrg0WN8g5ox7nFe4A5OeaQ&usqp=CAU", "Mehendi")
        };

        stories_adapter adapter = new stories_adapter(myListData, MainActivity.this);
        binding.rcStories.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.rcStories.setLayoutManager(layoutManager);
        binding.rcStories.setAdapter(adapter);

    }

    private void getTabContent(int tabId) {
        int iDisplayWidth = getResources().getDisplayMetrics().widthPixels ;
        int iImageWidth = iDisplayWidth / 3 ;
        binding.gridView.setColumnWidth( iImageWidth );
        binding.gridView.setStretchMode( GridView.NO_STRETCH ) ;
        binding.gridView.setExpanded(true);
        switch (tabId) {
            case 0:
                loadPhotos();
                break;
            case 1:
                loadVideos();
                break;
            case 2:
                loadAlbums();
                break;
            default:
                loadPhotos();
        }
    }

    private void loadPhotos() {
        photos[] myPhotos = new photos[]{
                new photos("https://www.thestatesman.com/wp-content/uploads/2020/02/QT-O4-9.jpg"),
                new photos("https://www.brides.com/thmb/bvv35qyktAXw5wNgI4ZI-FLRxVQ=/1425x0/filters:no_upscale():max_bytes(200000):strip_icc()/234-d3d2dbc2c1bd4083a811448b4e966681.png"),
                new photos("https://the-maharani-diaries-zxpo8io6akeffozy.netdna-ssl.com/media/2020/01/19194655/Beautiful-Fusion-Indian-Wedding-in-an-Irish-Castle_Lindsay-and-Miten_Epic-Love-Photography_56-scaled.jpg"),
                new photos("https://cdn.shopify.com/s/files/1/0278/1575/files/DLru6JqUEAIzyFd_large.jpg?v=1525696207"),
                new photos("https://i.pinimg.com/originals/77/f6/54/77f654e6620f6713048eb9a688d294a4.jpg"),
                new photos("https://file.weddingchicks.com/846180_traditional-indian-wedding-ideas-in-gold.jpg"),
                new photos("https://cdn.shopify.com/s/files/1/0278/1575/files/DLru6JqUEAIzyFd_large.jpg"),
                new photos("https://www.thestatesman.com/wp-content/uploads/2020/02/QT-O4-9.jpg"),
                new photos("https://the-maharani-diaries-zxpo8io6akeffozy.netdna-ssl.com/media/2020/01/19194655/Beautiful-Fusion-Indian-Wedding-in-an-Irish-Castle_Lindsay-and-Miten_Epic-Love-Photography_56-scaled.jpg"),
                new photos("https://www.brides.com/thmb/bvv35qyktAXw5wNgI4ZI-FLRxVQ=/1425x0/filters:no_upscale():max_bytes(200000):strip_icc()/234-d3d2dbc2c1bd4083a811448b4e966681.png"),
                new photos("https://i.pinimg.com/originals/77/f6/54/77f654e6620f6713048eb9a688d294a4.jpg"),
                new photos("https://www.brides.com/thmb/bvv35qyktAXw5wNgI4ZI-FLRxVQ=/1425x0/filters:no_upscale():max_bytes(200000):strip_icc()/234-d3d2dbc2c1bd4083a811448b4e966681.png"),
                new photos("https://www.thestatesman.com/wp-content/uploads/2020/02/QT-O4-9.jpg"),
                new photos("https://the-maharani-diaries-zxpo8io6akeffozy.netdna-ssl.com/media/2020/01/19194655/Beautiful-Fusion-Indian-Wedding-in-an-Irish-Castle_Lindsay-and-Miten_Epic-Love-Photography_56-scaled.jpg"),
                new photos("https://www.brides.com/thmb/bvv35qyktAXw5wNgI4ZI-FLRxVQ=/1425x0/filters:no_upscale():max_bytes(200000):strip_icc()/234-d3d2dbc2c1bd4083a811448b4e966681.png"),
                new photos("https://i.pinimg.com/originals/77/f6/54/77f654e6620f6713048eb9a688d294a4.jpg"),
                new photos("https://www.brides.com/thmb/bvv35qyktAXw5wNgI4ZI-FLRxVQ=/1425x0/filters:no_upscale():max_bytes(200000):strip_icc()/234-d3d2dbc2c1bd4083a811448b4e966681.png"),
                new photos("https://file.weddingchicks.com/846180_traditional-indian-wedding-ideas-in-gold.jpg"),
                new photos("https://cdn.shopify.com/s/files/1/0278/1575/files/DLru6JqUEAIzyFd_large.jpg"),
                new photos("https://www.thestatesman.com/wp-content/uploads/2020/02/QT-O4-9.jpg"),
                new photos("https://the-maharani-diaries-zxpo8io6akeffozy.netdna-ssl.com/media/2020/01/19194655/Beautiful-Fusion-Indian-Wedding-in-an-Irish-Castle_Lindsay-and-Miten_Epic-Love-Photography_56-scaled.jpg")
        };
        photos_adapter photos_adapter = new photos_adapter(myPhotos, MainActivity.this);
        binding.gridView.setAdapter(photos_adapter);
     //   binding.progressbar.setVisibility(View.GONE);

    }

    private void loadVideos() {
        videos[] myVideos = new videos[]{
        };
        videos_adapter videos_adapter = new videos_adapter(myVideos, MainActivity.this);
        binding.gridView.setAdapter(videos_adapter);
    //    binding.progressbar.setVisibility(View.GONE);

    }

    private void loadAlbums() {

    }

}

