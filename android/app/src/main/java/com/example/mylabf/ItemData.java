package com.example.mylabf;

public class ItemData {
    // ImageView 1개, TextView 2개
    int image;  // id가 정수형
    String title;
    String contents;

    // alt + insert
    public ItemData(int image, String title, String contents) {
        this.image = image;
        this.title = title;
        this.contents = contents;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
