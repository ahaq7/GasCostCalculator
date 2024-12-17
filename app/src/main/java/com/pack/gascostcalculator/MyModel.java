package com.pack.gascostcalculator;

public class MyModel {

    String title, description, date;
    int image, backgroundColor;

    public MyModel(String title, String description, String date, int image, int backgroundColor) {

        this.title = title;

        this.description = description;

        this.date = date;

        this.image = image;

        this.backgroundColor = backgroundColor;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
