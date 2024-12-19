package com.pack.gascostcalculator;

public class ColorSetter {

    int background, backgroundTint, progressBackgroundTint, progressTint, textColor;

    public ColorSetter(int background, int backgroundTint, int progressBackgroundTint, int progressTint, int textColor) {

        this.background = background;
        this.backgroundTint = backgroundTint;
        this.progressBackgroundTint = progressBackgroundTint;
        this.progressTint = progressTint;
        this.textColor = textColor;

    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getBackgroundTint() {
        return backgroundTint;
    }

    public void setBackgroundTint(int backgroundTint) {
        this.backgroundTint = backgroundTint;
    }

    public int getProgressBackgroundTint() {
        return progressBackgroundTint;
    }

    public void setProgressBackgroundTint(int progressBackgroundTint) {
        this.progressBackgroundTint = progressBackgroundTint;
    }

    public int getProgressTint() {
        return progressTint;
    }

    public void setProgressTint(int progressTint) {
        this.progressTint = progressTint;
    }

    public int getTextColor() {
        return textColor;
    }
}