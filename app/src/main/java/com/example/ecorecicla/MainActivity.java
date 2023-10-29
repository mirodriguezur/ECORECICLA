package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.login_button);
        Button btnRegisterUser = findViewById(R.id.register_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainMenuActivity = new Intent(MainActivity.this, MainMenuActivity.class);
                startActivity(goToMainMenuActivity);
            }
        });

        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCreateAccountActivity = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(goToCreateAccountActivity);
            }
        });
    }
}