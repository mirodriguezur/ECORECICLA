package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Crear archivo para registro de consejos
        File file4 = new File(getFilesDir(), "advices.txt");
        try {
            FileWriter writer = new FileWriter(file4);

            // Lista de consejos
            String[] consejos = {
                    "Plasticos,Evita los productos desechables," +
                        "Deja de usar los platos vasos y cualquier producto que sea descartable." +
                        "Elige aquellos que se puedan utilizar varias veces como los recipientes de vidrio.",
                    "Plasticos,Ten contenedores o bolsas en tu casa,"+
                        "Antes de depositar cualquier objeto en su lugar lávalo bien a fin de evitar malos olores.",
                    "Plasticos,Dona juguetes,"+
                        "Si en estos días de confinamiento has limpiado a profundidad el cuarto de tus hijos " +
                        "y descartaron juntos varios juguetes no los botes. Lávalos y dónalos " +
                        "para que tengan una segunda vida.",
                    "Plasticos,Dile adiós a las botellas de plástico,"+
                        "Diversos estudios indican que usar de manera indefinida una botella de plástico " +
                        "puede resultar perjudicial para la salud. Sustitúyelas por botellas de acero inoxidable."
            };
            // Recorrer el array y agregar los consejos al archivo
            //writer.append("Lista de consejos para reciclar:\n");
            for (String consejo : consejos) {
                writer.append(consejo).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent goToLoginActivity = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(goToLoginActivity);

    }
}