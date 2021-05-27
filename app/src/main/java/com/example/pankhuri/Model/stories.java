package com.example.pankhuri.Model;

public class stories {

    private String imgUrl;
    private String caption;

    public stories(String imgUrl, String caption) {
        this.imgUrl = imgUrl;
        this.caption = caption;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
