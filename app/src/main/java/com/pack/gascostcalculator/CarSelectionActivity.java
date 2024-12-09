package com.pack.gascostcalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pack.gascostcalculator.databinding.ActivityCarSelectionBinding;
import com.pack.gascostcalculator.databinding.ActivityMainBinding;

public class CarSelectionActivity extends AppCompatActivity {

    ActivityCarSelectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityCarSelectionBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_car_selection);
        replaceFragment(new CalculatorFragment());
        setContentView(binding.getRoot());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

                if (item.getItemId() == R.id.home) {
                    replaceFragment(new HomeFragment());
                }else if (item.getItemId() == R.id.settings){
                    replaceFragment(new SettingsFragment());
                }else if(item.getItemId() == R.id.calculator){
                    replaceFragment(new CalculatorFragment());
                }


            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}