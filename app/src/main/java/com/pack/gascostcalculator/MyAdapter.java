package com.pack.gascostcalculator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        ProgressBar progressBar1 = view.findViewById(R.id.progressBar1);
        TextView titleTv = view.findViewById(R.id.titleTv);



        //setting colors:

        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
        TextView speedTv = view.findViewById(R.id.speedTv);
        TextView MilesPerGallonTv = view.findViewById(R.id.MilesPerGallonTv);


        ColorSetter colorSetter = modelArrayList.get(position).getColorSetter();


        MyModel model = modelArrayList.get(position);
        final String title = model.getTitle();
        int milesPerGallon = model.getMilesPerGallon();
        final String date = model.getDate();
        int image = model.getImage();
        int backgroundColorResId = model.getBackgroundColor();

        int backgroundColorTemp = colorSetter.getBackground();
        int backgroundTintTemp = colorSetter.getBackgroundTint();
        int progressBackgroundTintTemp = colorSetter.getProgressBackgroundTint();
        int progressTintTemp = colorSetter.getProgressTint();
        int textColorTemp = colorSetter.getTextColor();



        //setting text color:
        int textColor = ContextCompat.getColor(context, textColorTemp);
        titleTv.setTextColor(textColor);
        MilesPerGallonTv.setTextColor(textColor);
        speedTv.setTextColor(textColor);

        //setting background color:
        int backgroundColor = ContextCompat.getColor(context, backgroundColorTemp);
        linearLayout.setBackgroundColor(backgroundColor);

        //setting progress bar colors:
        progressBar1.setBackgroundTintList(ContextCompat.getColorStateList(context, backgroundColorTemp));
        progressBar1.setProgressBackgroundTintList(ContextCompat.getColorStateList(context, progressBackgroundTintTemp));
        progressBar1.setProgressTintList(ContextCompat.getColorStateList(context, progressTintTemp));

        //setting image, title and progress percentage:
        bannerIv.setImageResource(image);
        titleTv.setText(title);
        progressBar1.setProgress(milesPerGallon);


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