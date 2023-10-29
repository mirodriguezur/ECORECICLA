package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoriesFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_form);

        Button btnBack = findViewById(R.id.backCategory_button);
        Button btnRegisterCategory = findViewById(R.id.categoryRegister_button);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainMenuActivity = new Intent(CategoriesFormActivity.this, MainMenuActivity.class);
                startActivity(goToMainMenuActivity);
            }
        });

        btnRegisterCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRecyclingRegistrationFormActivity = new Intent(CategoriesFormActivity.this, RecyclingRegistrationFormActivity.class);
                startActivity(goToRecyclingRegistrationFormActivity);
            }
        });
    }
}