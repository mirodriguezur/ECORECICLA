package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //ImageButton btnprofile = findViewById(R.id.btnProfileMainMenu);
        ImageButton btnCategory = findViewById(R.id.btnCategoryMainMenu);
        ImageButton btnstatistics = findViewById(R.id.btnStatisticMainMenu);
        ImageButton btnAdvices = findViewById(R.id.btnAdvicesMainMenu);

        //TODO: Add ProfileActivity
        //btnprofile.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Intent goToProfileActivity = new Intent(MainMenuActivity.this, ProfileActivity.class);
        //        startActivity(goToProfileActivity);
        //    }
        //});

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCategoriesFormActivity = new Intent(MainMenuActivity.this, CategoriesFormActivity.class);
                startActivity(goToCategoriesFormActivity);
            }
        });

        btnstatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToStatisticsActivity = new Intent(MainMenuActivity.this, StatisticsActivity.class);
                startActivity(goToStatisticsActivity);
            }
        });

        btnAdvices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAdvicesActivity = new Intent(MainMenuActivity.this, AdvicesActivity.class);
                startActivity(goToAdvicesActivity);
            }
        });
    }
}