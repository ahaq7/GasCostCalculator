package com.pack.gascostcalculator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation. NonNull;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private final ArrayList<MyModel> modelArrayList;


    public MyAdapter(Context context, ArrayList<MyModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object){
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);
        //init uid views from card_item.xml

        ImageView bannerIv = view.findViewById(R.id.bannerIv);
        TextView titleTv = view.findViewById(R.id.titleTv);
        TextView carSelectionTv = view.findViewById(R.id.carSelectionTv);

        ProgressBar progressBar1 = view.findViewById(R.id.progressBar1);
        ProgressBar progressBar2 = view.findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = view.findViewById(R.id.progressBar3);



        //setting colors:

        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
        TextView dateTv = view.findViewById(R.id.date);
        TextView speedTv = view.findViewById(R.id.speedTv);
        TextView MilesPerGallonTv = view.findViewById(R.id.MilesPerGallonTv);
        TextView acceleration = view.findViewById(R.id.acceleration);
        Button selectCarBtn = view.findViewById(R.id.selectCarBtn);





        MyModel model = modelArrayList.get(position);
        final String title = model.getTitle();
        int milesPerGallon = model.getMilesPerGallon();
        int topSpeedProgress = model.getTopSpeed();
        int accelerationProgress = model.getAcceleration();
        final String date = model.getDate();
        int image = model.getImage();

        //Colors
        ColorSetter colorSetter = modelArrayList.get(position).getColorSetter();
        int backgroundColorTemp = colorSetter.getBackground();
        int backgroundTintTemp = colorSetter.getBackgroundTint();
        int progressBackgroundTintTemp = colorSetter.getProgressBackgroundTint();
        int progressTintTemp = colorSetter.getProgressTint();
        int textColorTemp = colorSetter.getTextColor();
        int buttonColorTemp = colorSetter.getButtonColor();
        int buttonTextColorTemp = colorSetter.getButtonTextColor();



        //setting text color:
        int textColor = ContextCompat.getColor(context, textColorTemp);
        dateTv.setTextColor(textColor);
        titleTv.setTextColor(textColor);
        MilesPerGallonTv.setTextColor(textColor);
        speedTv.setTextColor(textColor);
        acceleration.setTextColor(textColor);
        carSelectionTv.setTextColor(textColor);

        //setting button color:
        int buttonColor = ContextCompat.getColor(context,buttonColorTemp);
        int buttonTextColor = ContextCompat.getColor(context, buttonTextColorTemp);
        selectCarBtn.setBackgroundColor(buttonColor);
        selectCarBtn.setTextColor(buttonTextColor);

        //setting background color:
        int backgroundColor = ContextCompat.getColor(context, backgroundColorTemp);
        linearLayout.setBackgroundColor(backgroundColor);

        //setting progress bar colors:
        progressBar1.setBackgroundTintList(ContextCompat.getColorStateList(context, backgroundColorTemp));
        progressBar1.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressBackgroundTintTemp));
        progressBar1.setProgressTintList(ContextCompat.getColorStateList(context, progressTintTemp));

        progressBar2.setBackgroundTintList(ContextCompat.getColorStateList(context, backgroundColorTemp));
        progressBar2.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressBackgroundTintTemp));
        progressBar2.setProgressTintList(ContextCompat.getColorStateList(context, progressTintTemp));

        progressBar3.setBackgroundTintList(ContextCompat.getColorStateList(context, backgroundColorTemp));
        progressBar3.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressBackgroundTintTemp));
        progressBar3.setProgressTintList(ContextCompat.getColorStateList(context, progressTintTemp));

        //setting image, title and progress percentage:
        bannerIv.setImageResource(image);
        titleTv.setText(title);
        dateTv.setText(date);
        progressBar1.setProgress(milesPerGallon);
        progressBar2.setProgress(topSpeedProgress);
        progressBar3.setProgress(accelerationProgress);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, title + "/n" +"/n" + date, Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view, position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((View)object);
    }

}