package com.pack.gascostcalculator;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class MyModel {

    String title, date;
    int image, milesPerGallon, topSpeed, acceleration;
    ColorSetter colorSetter;

    public MyModel(int image, String date, String title, int milesPerGallon, int topSpeed, int acceleration, ColorSetter colorSetter) {

        this.image = image;

        this.title = title;

        this.milesPerGallon = milesPerGallon;

        this.date = date;

        this.colorSetter = colorSetter;

        this.acceleration = acceleration;

        this.topSpeed = topSpeed;

    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public ColorSetter getColorSetter() {
        return colorSetter;
    }

    public void setColorSetter(ColorSetter colorSetter) {
        this.colorSetter = colorSetter;
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
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
