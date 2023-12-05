package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText firstName = findViewById(R.id.txtFirstNameProfile);
        EditText lastName = findViewById(R.id.txtLastNameProfile);
        EditText email = findViewById(R.id.txtEmailProfile);
        EditText cellPhone = findViewById(R.id.txtCellphoneProfile);
        EditText city = findViewById(R.id.txtCityProfile);
        ImageButton btnBack = findViewById(R.id.btnBackProfile);

        UserSingleton user = UserSingleton.sharedInstance();
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        email.setText(user.getEmail());
        cellPhone.setText(user.getCellNumber());
        city.setText(user.getCity());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainActivity = new Intent(ProfileActivity.this, MainMenuActivity.class);
                startActivity(goToMainActivity);
            }
        });
    }
}