package com.pack.gascostcalculator;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class MyModel {

    String title, date;
    int image, backgroundColor, milesPerGallon;

    public MyModel(int image, String title, int milesPerGallon, String date, int backgroundColor) {

        this.image = image;

        this.title = title;

        this.milesPerGallon = milesPerGallon;

        this.date = date;

        this.backgroundColor = backgroundColor;

    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
