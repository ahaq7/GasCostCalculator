package com.pack.gascostcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Calculator extends AppCompatActivity {

    private EditText MPG;
    private EditText GasPrice;
    private EditText MilesDriven;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        naviBarMarginsSet();

        MPG = findViewById(R.id.mPG);
        GasPrice = findViewById(R.id.gasPrice);
        MilesDriven = findViewById(R.id.milesDriven);
        answer = findViewById(R.id.answer);


        ButtonCalculate();
        ResetButton();


        //ImageButton button = findViewById(R.id.imageButton);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCarSelection();
            }
        });*/
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

    private void ButtonCalculate() {
        Button button = findViewById(R.id.calculate_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mPG = 0;
                double gasPrice = 0;
                double milesDriven = 0;


                mPG = Double.parseDouble(MPG.getText().toString());
                gasPrice = Double.parseDouble(GasPrice.getText().toString());
                milesDriven = Double.parseDouble(MilesDriven.getText().toString());

                double gasCost = ((double) milesDriven / mPG) * gasPrice;

                RadioButton radioButton = findViewById(R.id.both_ways_check);
                if (radioButton.isChecked()) {
                    gasCost = gasCost * 2;
                }

                DecimalFormat formatter = new DecimalFormat("$###.##");
                String cost = formatter.format(gasCost);
                answer.setText("Balance Due: " + cost);

            }
        });
    }

    private void ResetButton(){
        Button buttonReset = findViewById(R.id.reset_btn);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MPG.setText("");
                GasPrice.setText("");
                MilesDriven.setText("");
                answer.setText("");
            }
        });

    }

    /*private void goToCarSelection() {
        Intent intent = new Intent(MainActivity.this, CarSelection.class);
        startActivity(intent);
    }*/
}