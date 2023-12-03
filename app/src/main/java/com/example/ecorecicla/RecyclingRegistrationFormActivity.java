package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla.models.ComputerWaste;
import com.example.ecorecicla.models.Metals;
import com.example.ecorecicla.models.Paper;
import com.example.ecorecicla.models.Plastic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecyclingRegistrationFormActivity extends AppCompatActivity {
    private static final double Conversion_Factor = 0.0005;
    private int count = 0;
    TextView txtlabelAmount;
    EditText txtAmount;

    EditText txtPrice;

    EditText txtPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling_registration_form);

        ImageButton btnBack = findViewById(R.id.btnBackRecyclingRegistration);
        Button btnDelete = findViewById(R.id.btnDeleteRecyclingRegistration);
        Button btnRegister = findViewById(R.id.btnRegisterRecyclingRegistration);
        Spinner spnMonths = findViewById(R.id.spnMonthsRecyclingRegistration);
        txtPoints = findViewById(R.id.txtShowPointsRecyclingRegistration);

        txtlabelAmount = findViewById(R.id.txtAmountRecyclingRegistration);
        txtPrice = findViewById(R.id.txtShowPriceRecyclingRegistration);
        txtAmount = findViewById(R.id.txtShowAmountRecyclingRegistration);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        setLabels(bundle);

        //deletFile(bundle.getString("fileCategory")); //uncomment for testing only

        txtPrice.addTextChangedListener(textWatcher);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCategoriesActivity = new Intent(RecyclingRegistrationFormActivity.this, CategoriesFormActivity.class);
                startActivity(goToCategoriesActivity);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAmount.getText().clear();
                txtPrice.getText().clear();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if fields are not empty
                if (!txtAmount.getText().toString().isEmpty() && !txtPrice.getText().toString().isEmpty()) {
                    Months selectedMonth = (Months) spnMonths.getSelectedItem();
                    String month = selectedMonth.getDescription();
                    boolean monthExists = checkMonth(month, bundle.getString("fileCategory"));

                    if (monthExists) {
                        // El mes ya existe en el archivo
                        Toast.makeText(RecyclingRegistrationFormActivity.this, "El mes ya existe",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        boolean savedData = saveData(Integer.parseInt(txtAmount.getText().toString()), Integer.parseInt(txtPrice.getText().toString()), month, Integer.parseInt(txtPoints.getText().toString()), bundle.getString("fileCategory"));
                        if (savedData) {
                            Toast.makeText(RecyclingRegistrationFormActivity.this, "Categoría registrada",
                                    Toast.LENGTH_SHORT).show();
                            Intent goMainMenuActivity = new Intent(RecyclingRegistrationFormActivity.this, MainMenuActivity.class);
                            startActivity(goMainMenuActivity);
                        } else {
                            Toast.makeText(RecyclingRegistrationFormActivity.this, "Error al guardar el archivo",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    // some fields are empty
                    Toast.makeText(RecyclingRegistrationFormActivity.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Months[] monthsList = Months.values();
        ArrayAdapter<Months> monthsAdap = new ArrayAdapter<Months>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, monthsList);
        spnMonths.setAdapter(monthsAdap);
    }

    private void  setLabels(Bundle bundle) {
        String txtLabel = bundle.getString("txtAmount");
        String txtHint = bundle.getString("txtHint");

        txtlabelAmount.setText(txtLabel);
        txtAmount.setHint(txtHint);
    }

    public boolean checkMonth(String month, String  nameFile) {
        File file = new File(getFilesDir(), nameFile);
        month = month.toLowerCase();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String monthReaded = line.split(",")[2]; // Assuming the month is in the third column separated by a comma (,)
                if (monthReaded.equalsIgnoreCase(month)) {
                    bufferedReader.close();
                    return true; // the month exists
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // the month does not exists
    }

    public boolean saveData(int amount, int price, String month, int points, String nameFile) {
        File file = new File(getFilesDir(), nameFile);
        month = month.toLowerCase();
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = "";
            if(nameFile.equals("plastico.txt")) {
                Plastic plastic = new Plastic(amount, price, month, points);
                line = plastic.getVolume() + "," + plastic.getPrice() + "," + plastic.getMonth() + "," + plastic.getPoints();
            } else if(nameFile.equals("papel.txt")) {
                Paper paper = new Paper(amount, price, month, points);
                line = paper.getNumberOfLeaves() + "," + paper.getPrice() + "," + paper.getMonth() + "," + paper.getPoints();
            } else if(nameFile.equals("metal.txt")) {
                Metals metal = new Metals(amount, price, month, points);
                line = metal.getKilograms() + "," + metal.getPrice() + "," + metal.getMonth() + "," + metal.getPoints();
            } else if(nameFile.equals("desechoinformatico.txt")) {
                ComputerWaste computerWaste = new ComputerWaste(amount, price, month, points);
                line = computerWaste.getElements() + "," + computerWaste.getPrice() + "," + computerWaste.getMonth() + "," + computerWaste.getPoints();
            }
            // Write data to file
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // Los datos se guardaron correctamente
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Error al guardar los datos
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String strAmount = txtAmount.getText().toString();
            String strPrice = editable.toString();

            //check if the fields are not empty
            if (!strAmount.isEmpty() && !strPrice.isEmpty()) {
                //Convert strings to numbers
                int amount = Integer.parseInt(strAmount);
                if (editable.length() == 1 && editable.charAt(0) == '0') {
                    count = 0;
                }
                int price = Integer.parseInt(strPrice);
                count = (count * 10) + price;
                int result = (int) Math.round(((double) amount)*((double) count)*(Conversion_Factor));
                txtPoints.setText(String.valueOf(result));
            }
        }
    };

    //MARK: Use only for testing.
    private void deletFile(String category) {
        File file = new File(getFilesDir(),category);
        if (file.exists()) {
            // Intenta eliminar el archivo
            if (file.delete()) {
                // El archivo se eliminó correctamente
                Log.d("EliminarArchivo", "Archivo eliminado");
            } else {
                // No se pudo eliminar el archivo
                Log.e("EliminarArchivo", "No se pudo eliminar el archivo");
            }
        } else {
            // El archivo no existe
            Log.d("EliminarArchivo", "El archivo no existe");
        }
    }
}