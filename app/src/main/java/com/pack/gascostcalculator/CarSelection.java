package com.pack.gascostcalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class CarSelection extends AppCompatActivity {

    private ActionBar actionBar;
    ViewPager viewPager;
    private MyAdapter myAdapter;
    private ArrayList<MyModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_car_selection);

        actionBar = getSupportActionBar();

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void loadCards() {

        //ColorList

        ColorSetter colorSetterYellow = new ColorSetter(
                R.color.fBackground,
                R.color.fBackground,
                R.color.fProgressBar,
                R.color.fProgress,
                R.color.fText);

        ColorSetter colorSetterBlack = new ColorSetter(
                R.color.BBackground,
                R.color.BBackground,
                R.color.BProgressBar,
                R.color.BProgress,
                R.color.BText);


        //ModelList

        modelArrayList = new ArrayList<>();

        modelArrayList.add(new MyModel(
                R.drawable.dodgechalleger,
                "Dodge Challenger",
                20,
                "03/08/2024",
                R.color.red,
                colorSetterYellow));

        modelArrayList.add(new MyModel(
                R.drawable.dodgechalleger,
                "Dodge Challenger",
                79,
                "03/08/2024",
                R.color.black,
                colorSetterBlack));

        modelArrayList.add(new MyModel(
                R.drawable.dodgechalleger,
                "Dodge Challenger",
                100,
                "03/08/2024",
                R.color.red,
                colorSetterYellow));

        myAdapter = new MyAdapter(this, modelArrayList);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(0,70,0,0);
    }


}