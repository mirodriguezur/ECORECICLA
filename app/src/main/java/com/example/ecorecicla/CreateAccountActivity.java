package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ImageButton btnInfo = findViewById(R.id.btnInfoRegister);
        ImageButton btnBack = findViewById(R.id.btnBackRegister);
        Button btnCreateAccount = findViewById(R.id.btnRegisterRegister);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAboutUsActivity = new Intent(CreateAccountActivity.this, AboutUsActivity.class);
                startActivity(goToAboutUsActivity);
            }
        });

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