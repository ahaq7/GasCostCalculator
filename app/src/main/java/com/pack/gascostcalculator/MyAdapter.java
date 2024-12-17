package com.pack.gascostcalculator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation. NonNull;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        CardView cardView = view.findViewById(R.id.cardView);
        TextView titleTv = view.findViewById(R.id.titleTv);
        TextView descriptionTv = view.findViewById(R.id.descriptionTv);
        TextView dateTv = view.findViewById(R.id.dateTv);

//get data

        MyModel model = modelArrayList.get(position);
        final String title = model.getTitle();
        final String description = model.getDescription();
        final String date = model.getDate();
        int image = model.getImage();
        int backgroundColor = model.getBackgroundColor();

//set data

        bannerIv.setImageResource(image);
        titleTv.setText(title);
        descriptionTv.setText(description);
        dateTv.setText(date);
        cardView.setCardBackgroundColor(backgroundColor);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, title + "/n" + description +"/n" + date, Toast.LENGTH_SHORT).show();
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