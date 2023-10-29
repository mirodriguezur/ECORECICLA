package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecyclingRegistrationFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling_registration_form);

        Button btnBack = findViewById(R.id.backRecyclingRegistration_button);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainMenuActivity = new Intent(RecyclingRegistrationFormActivity.this, MainMenuActivity.class);
                startActivity(goToMainMenuActivity);
            }
        });
    }
}