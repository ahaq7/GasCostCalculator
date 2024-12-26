package com.pack.gascostcalculator;

import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class CarSelection extends AppCompatActivity {

    //private ActionBar actionBar;
    ViewPager viewPager;
    private MyAdapter myAdapter;
    private ArrayList<MyModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_car_selection);
        naviBarMarginsSet();

        //actionBar = getSupportActionBar();

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //String title = modelArrayList.get(position).getTitle();
                //actionBar.setTitle(title);
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
                R.color.fText,
                R.color.fButton,
                R.color.fButtonText);

        ColorSetter colorSetterBlack = new ColorSetter(
                R.color.BBackground,
                R.color.BBackground,
                R.color.BProgressBar,
                R.color.BProgress,
                R.color.BText,
                R.color.BButton,
                R.color.BButtonText);


        //ModelList

        modelArrayList = new ArrayList<>();


        modelArrayList.add(new MyModel(
                R.drawable.blacksubarubaja,
                "2003",
                "Black SUBARU",
                20,
                70,
                50,
                colorSetterBlack));

        modelArrayList.add(new MyModel(
                R.drawable.subaruyellow,
                "2003",
                "Yellow Subaru",
                20,
                70,
                50,
                colorSetterYellow));

        modelArrayList.add(new MyModel(
                R.drawable.subaruyellow,
                "2003",
                "Yellow Subaru",
                20,
                70,
                50,
                colorSetterYellow));

        modelArrayList.add(new MyModel(
                R.drawable.subaruyellow,
                "2003",
                "Yellow Subaru",
                20,
                70,
                50,
                colorSetterYellow));

        modelArrayList.add(new MyModel(
                R.drawable.subaruyellow,
                "2003",
                "Yellow Subaru",
                20,
                70,
                50,
                colorSetterYellow));

        modelArrayList.add(new MyModel(
                R.drawable.mercedessprinter,
                "2012",
                "Mercedes Sprinter",
                15,
                60,
                50,
                colorSetterBlack));



        myAdapter = new MyAdapter(this, modelArrayList);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(0,0,0,0);
    }

    private void naviBarMarginsSet() {
        View decorView = getWindow().getDecorView();

        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(){
            @NonNull
            @Override
            public WindowInsets onApplyWindowInsets(@NonNull View v, @NonNull WindowInsets insets) {
                int left = insets.getSystemWindowInsetLeft();
                int top = insets.getSystemWindowInsetTop();
                int right = insets.getSystemWindowInsetRight();
                int bottom = insets.getSystemWindowInsetBottom();

                v.setPadding(left,top,right,bottom);

                return insets.consumeSystemWindowInsets();
            }
        });
    }


}