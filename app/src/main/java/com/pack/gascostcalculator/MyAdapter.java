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
        LinearLayout linearLayout = view.findViewById(R.id.linearlayout);
        ProgressBar progressBar1 = view.findViewById(R.id.progressBar1);
        TextView titleTv = view.findViewById(R.id.titleTv);
        TextView dateTv = view.findViewById(R.id.dateTv);

//get data

        MyModel model = modelArrayList.get(position);
        final String title = model.getTitle();
        int milesPerGallon = model.getMilesPerGallon();
        final String date = model.getDate();
        int image = model.getImage();
        int backgroundColorResId = model.getBackgroundColor();

//set data

        bannerIv.setImageResource(image);
        titleTv.setText(title);
        dateTv.setText(date);
        progressBar1.setProgress(milesPerGallon);

        int backgroundColor = ContextCompat.getColor(context, backgroundColorResId);
        linearLayout.setBackgroundColor(backgroundColor);

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