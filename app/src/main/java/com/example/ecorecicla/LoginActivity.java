package com.example.ecorecicla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ecorecicla.models.DataValidator;
import com.example.ecorecicla.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    // User information fields
    private EditText txtEmail;
    private EditText txtPassword;
    private UserSingleton viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton btnInfo = findViewById(R.id.btnInfoLogin);
        Button btnLogin = findViewById(R.id.btnLoginLogin);
        Button btnRegisterUser = findViewById(R.id.btnRegisterLogin);

        txtEmail = findViewById(R.id.txtEmailLogin);
        txtPassword = findViewById(R.id.txtPasswordLogin);

        // read data from file .txt
        File userFile = new File(getFilesDir(), "userData.txt");
        ArrayList<User> users = new ArrayList<>();
        readDataFromFile(userFile, users);

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
                if (shouldNavigateToMainMenuActivity(users)) {
                    Intent goToMainMenuActivity = new Intent(LoginActivity.this, MainMenuActivity.class);
                    startActivity(goToMainMenuActivity);
                }
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
    private void  readDataFromFile(File userFile, ArrayList<User> users) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into user data separated by commas
                String[] userData = line.split(",");
                String firstName = userData[0];
                String lastName = userData[1];
                String email = userData[2];
                String cellNumber = userData[3];
                String city = userData[4];
                Integer password = Integer.parseInt(userData[5]);
                // Create a User object and add it to the user list
                User user = new User(firstName, lastName, email, cellNumber, city, password);
                users.add(user);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean shouldNavigateToMainMenuActivity (ArrayList<User> users) {
        // Check if username and password data have been entered
        if (!txtEmail.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()) {
            String inputUsuario = txtEmail.getText().toString();
            Integer inputPassword = Integer.parseInt(txtPassword.getText().toString());

            DataValidator validator = new DataValidator();
            if (validator.validateFormatEmail(inputUsuario) && validator.validateFormatPassword(inputPassword)) {
                // Find the matching user in the user list
                for (User user : users) {
                    if (user.getPassword().equals(inputPassword)) {
                        if (user.getEmail().equals(inputUsuario)) {
                            UserSingleton infoUser = UserSingleton.sharedInstance();
                            infoUser.setFirstName(user.getFirstName());
                            infoUser.setLastName(user.getLastName());
                            infoUser.setEmail(user.getEmail());
                            infoUser.setCellNumber(user.getCellNumber());
                            infoUser.setCity(user.getCity());
                            return true;
                        }
                    }
                }
                // If you don't find a match, display an error message when using Toast
                Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            } else {
                AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                alert.setMessage("Revise el formato del correo y/o recuerde \n que la contraseña son 5 digitos")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog title = alert.create();
                title.setTitle("Formato incorrecto");
                title.show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}