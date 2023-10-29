package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button btnBack = findViewById(R.id.backCreateAccount_button);
        Button btnCreateAccount = findViewById(R.id.registerCreateAccount_button);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainMenuActivity = new Intent(CreateAccountActivity.this, MainMenuActivity.class);
                startActivity(goToMainMenuActivity);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainActivity = new Intent(CreateAccountActivity.this, MainActivity.class);
                startActivity(goToMainActivity);
            }
        });
    }
}