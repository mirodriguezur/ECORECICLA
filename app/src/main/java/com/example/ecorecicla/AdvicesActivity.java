package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecorecicla.models.Advice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvicesActivity extends AppCompatActivity {

    private ArrayList<Advice> AdvicesList;
    private TextView Advices;
    private TextView AdviceTitle;
    private TextView AdviceSubTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advices);

        ImageButton btnBack = findViewById(R.id.backAdvices_button);
        final Intent goToMainMenuActivity = new Intent(AdvicesActivity.this, MainMenuActivity.class);

        ImageButton btnNextAdvice = findViewById(R.id.btn_next);

        Advices = findViewById(R.id.txtAdvices);
        AdviceTitle = findViewById(R.id.txtTitleAdvices);
        AdviceSubTitle = findViewById(R.id.txtSubtitleAdvice);
        AdvicesList = new ArrayList<>();
        leerConsejos();
        mostrarConsejoAleatorio();

        btnNextAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarConsejoAleatorio();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToMainMenuActivity);
            }
        });
    }
    private void mostrarConsejoAleatorio() {
        if(AdvicesList.isEmpty()){
            Advices.setText("No hay consejos disponibles.");
            return;
        }
        Random random = new Random();
        int index = random.nextInt(AdvicesList.size());
        Advice advice = AdvicesList.get(index);

        AdviceTitle.setText(advice.getCategoria());
        AdviceSubTitle.setText((advice.getSubtitle()));
        Advices.setText(advice.getAdvace());
    }
    private void leerConsejos() {
        File file = new File(getFilesDir(),"advices.txt");
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                // Dividir la línea en los datos separados por comas
                String[] userData = line.split(",");
                String Categoria = userData[0];
                String SubTitulo = userData[1];
                String Consejo = userData[2];
                // Crear un objeto Advice y añadirlo a la lista de consejos
                Advice nuevoConsejo = new Advice(Categoria, SubTitulo, Consejo);
                AdvicesList.add(nuevoConsejo);
            }
            bufferedReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}