package com.example.ecorecicla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.ecorecicla.models.DataValidator;
import com.example.ecorecicla.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtEmail;
    private EditText txtCellNumber;
    private EditText txtCity;
    private EditText txtPassword;
    private EditText txtRepeatPassword;
    private RadioButton rbtnTermsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ImageButton btnInfo = findViewById(R.id.btnInfoRegister);
        ImageButton btnBack = findViewById(R.id.btnBackRegister);
        Button btnCreateAccount = findViewById(R.id.btnRegisterRegister);

        txtFirstName = findViewById(R.id.editTextNameRegister);
        txtLastName = findViewById(R.id.editTextLastNameRegister);
        txtEmail = findViewById(R.id.editTextEmailRegister);
        txtCellNumber = findViewById(R.id.editTextPhoneRegister);
        txtCity = findViewById(R.id.editTextCityRegister);
        txtPassword = findViewById(R.id.editTextPasswordRegister);
        txtRepeatPassword = findViewById(R.id.editTextRepeatPasswordRegister);
        rbtnTermsAndConditions = findViewById(R.id.radioButtonTermsConditionsRegister);

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
                if (isNewUser()) {
                    Intent goToLoginActivity = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    startActivity(goToLoginActivity);
                }
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

    private boolean isNewUser() {
        if (rbtnTermsAndConditions.isChecked()) {
            // Check if the fields are completed
            if (!txtFirstName.getText().toString().isEmpty() && !txtLastName.getText().toString().isEmpty() && !txtEmail.getText().toString().isEmpty() &&
                    !txtCellNumber.getText().toString().isEmpty() && !txtCity.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty() &&
                    !txtRepeatPassword.getText().toString().isEmpty()) {

                DataValidator validator = new DataValidator();
                if (validator.validateFormatEmail(txtEmail.getText().toString()) && validator.validateFormatPassword(Integer.parseInt(txtPassword.getText().toString()))
                && validator.validateFormatCellNumber(txtCellNumber.getText().toString())) {
                    // check if the passwords are the same
                    if (txtPassword.getText().toString().equals(txtRepeatPassword.getText().toString())) {
                        // Validate if the data already exists in the file
                        if (dataExist(txtFirstName.getText().toString(), txtEmail.getText().toString(), txtCellNumber.getText().toString())) {
                            // The data already exists
                            Toast.makeText(getApplicationContext(), "El usuario ya existen", Toast.LENGTH_SHORT).show();
                        } else {
                            // The data does not exist, register
                            // Create a new User object
                            User newUser = new User(txtFirstName.getText().toString(),
                                    txtLastName.getText().toString(), txtEmail.getText().toString(),
                                    txtCellNumber.getText().toString(), txtCity.getText().toString(),
                                    Integer.parseInt(txtPassword.getText().toString()));
                            // Save data to file
                            saveUser(newUser);
                            Toast.makeText(getApplicationContext(), "Usuario guardado con éxito",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        }
                    } else {
                        // The passwords are not the same
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(CreateAccountActivity.this);
                    alert.setMessage("Revise el formato del correo \nEl número celular debe tener 10 dígitos \nLa contraseña debe tener 5 dígitos")
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
                // The fields are empty
                Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            // RadioButton is not activated
            Toast.makeText(getApplicationContext(), "Debe aceptar los términos y condiciones, ", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private boolean dataExist(String firstName, String email, String cellNumber) {
        File usersFile = new File(getFilesDir(), "userData.txt");

        try {
            FileReader reader = new FileReader(usersFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingFirstName = new ArrayList<>();
            List<String> existingEmail = new ArrayList<>();
            List<String> existingCellNumber = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                existingFirstName.add(data[0]);
                existingEmail.add(data[2]);
                existingCellNumber.add(data[3]);
            }

            bufferedReader.close();

            return existingFirstName.contains(firstName) || existingEmail.contains(email) || existingCellNumber.contains(cellNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    /**
     * Save the new user info to the file
     *
     * @param newUser Objeto Usuario con los datos del nuevo usuario with the new user's data
     */
    private void saveUser(User newUser) {
        File file = new File(getFilesDir(), "userData.txt");

        try {
            FileWriter writer = new FileWriter(file, true); // The second parameter "true" indicates that it will be added to the end of the existing file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String newRegistration = newUser.getFirstName() + "," + newUser.getLastName() + "," + newUser.getEmail() + "," + String.valueOf(newUser.getCellNumber()) + "," +
                    newUser.getCity() + "," + String.valueOf(newUser.getPassword()) + "\n";
            bufferedWriter.write(newRegistration);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}