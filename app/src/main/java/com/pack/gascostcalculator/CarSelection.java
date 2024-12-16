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

        modelArrayList = new ArrayList<>();

        modelArrayList.add(new MyModel(
                "Title 01",
                "Description 02",
                "03/08/2024",
                R.drawable.subaru));

        modelArrayList.add(new MyModel(
                "Title 02",
                "Description 02",
                "03/23/2024",
                R.drawable.subaru));

        modelArrayList.add(new MyModel(
                "Title 03",
                "Description 03",
                "03/23/202434",
                R.drawable.subaru));

        myAdapter = new MyAdapter(this, modelArrayList);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(100,0,100,0);
    }


}