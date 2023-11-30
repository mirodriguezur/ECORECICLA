package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton btnInfo = findViewById(R.id.btnInfoLogin);
        Button btnLogin = findViewById(R.id.btnLoginLogin);
        Button btnRegisterUser = findViewById(R.id.btnRegisterLogin);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAboutUsActivity = new Intent(LoginActivity.this, AboutUsActivity.class);
                startActivity(goToAboutUsActivity);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainMenuActivity = new Intent(LoginActivity.this, MainMenuActivity.class);
                startActivity(goToMainMenuActivity);
            }
        });

        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCreateAccountActivity = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(goToCreateAccountActivity);
            }
        });
    }
}