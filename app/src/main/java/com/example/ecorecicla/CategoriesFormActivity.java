package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoriesFormActivity extends AppCompatActivity {

    private ImageView imageCategory;
    private TextView txtCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_form);

        ImageButton btnBack = findViewById(R.id.btnBackCategories);
        imageCategory = findViewById(R.id.imageCategory);
        txtCategory = findViewById(R.id.txtCategory);
        Button btnRegisterCategory = findViewById(R.id.btnRegisterCategories);
        Spinner spnCategories = findViewById(R.id.spnCategories);

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

        Categories[] categoriesList= Categories.values();
        ArrayAdapter<Categories> adap = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categoriesList);

        spnCategories.setAdapter(adap);

        // Manage Spinner selection
        spnCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Depending on the selected element, the image and text change
                Categories selectedItem = categoriesList[position];
                showImage(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void showImage(Categories item) {
        switch (item) {
            case PLASTICOS:
                imageCategory.setImageResource(R.drawable.bx_package);
                txtCategory.setText(R.string.plastic_category);
                break;
            case PAPEL:
                imageCategory.setImageResource(R.drawable.bxs_file_doc);
                txtCategory.setText(R.string.paper_category);
                break;
            case METALES:
                imageCategory.setImageResource(R.drawable.bx_coin_stack);
                txtCategory.setText(R.string.metal_category);
                break;
            case DESECHOS_INFORMATICOS:
                imageCategory.setImageResource(R.drawable.bx_mouse_alt);
                txtCategory.setText(R.string.computer_waste_category);
                break;
        }
    }
}