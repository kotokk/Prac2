package com.example.prac2;

public class HacksList {
    int Image;
    String title;

    public HacksList(int image, String title){
        Image = image;
        this.title = title;
    }

    public int getImage(){return Image;}

    public void setImage(int image){Image = image;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}
}
