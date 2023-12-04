package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ecorecicla.models.ComputerWaste;
import com.example.ecorecicla.models.Metals;
import com.example.ecorecicla.models.Paper;
import com.example.ecorecicla.models.Plastic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        ImageButton btnBack = findViewById(R.id.btnBackStatistics);
        tableLayout = findViewById(R.id.tableStatistics);

        //File upload
        File plasticFile = new File(getFilesDir(), "plastico.txt");
        File paperFile = new File(getFilesDir(), "papel.txt");
        File metalFile = new File(getFilesDir(), "metal.txt");
        File computerWasteFile = new File(getFilesDir(), "desechoinformatico.txt");

        //Reading files.
        List<Plastic> plasticList = readPlasticFile(plasticFile);
        List<Paper> paperList = readPaperFile(paperFile);
        List<Metals> metalList = readMetalsFile(metalFile);
        List<ComputerWaste> computerWasteList = readComputerWasteFile(computerWasteFile);

        //Create the Table
        addPlastic(plasticList);
        addPaper(paperList);
        addMetal(metalList);
        addComputerWaste(computerWasteList);

        addAveragePlastic(plasticList);
        addAveragePaper(paperList);
        addAverageMetals(metalList);
        addAverageComputerWaste(computerWasteList);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainMenuActivity = new Intent(StatisticsActivity.this, MainMenuActivity.class);
                startActivity(goToMainMenuActivity);
            }
        });
    }

    //MARK: Reading of Files
    private static List<Plastic> readPlasticFile(File file) {
        List<Plastic> plasticList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                int amount = Integer.parseInt(datos[0]);
                int price = Integer.parseInt(datos[1]);
                String month = datos[2];
                int points = Integer.parseInt(datos[3]);

                Plastic plastic = new Plastic(amount, price, month, points);
                plasticList.add(plastic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plasticList;
    }

    private static List<Paper> readPaperFile(File file) {
        List<Paper> paperList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                int amount = Integer.parseInt(datos[0]);
                int price = Integer.parseInt(datos[1]);
                String month = datos[2];
                int points = Integer.parseInt(datos[3]);

                Paper paper = new Paper(amount, price, month, points);
                paperList.add(paper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paperList;
    }

    private static List<Metals> readMetalsFile(File file) {
        List<Metals> metalList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                int amount = Integer.parseInt(datos[0]);
                int price = Integer.parseInt(datos[1]);
                String month = datos[2];
                int points = Integer.parseInt(datos[3]);

                Metals metal = new Metals(amount, price, month, points);
                metalList.add(metal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metalList;
    }

    private static List<ComputerWaste> readComputerWasteFile(File file) {
        List<ComputerWaste> computerWasteList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                int amount = Integer.parseInt(datos[0]);
                int price = Integer.parseInt(datos[1]);
                String month = datos[2];
                int points = Integer.parseInt(datos[3]);

                ComputerWaste computerWaste = new ComputerWaste(amount, price, month, points);
                computerWasteList.add(computerWaste);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return computerWasteList;
    }

    //MARK: Construction of the table
    private void addPlastic(List<Plastic> plasticList){

        for (Plastic item: plasticList) {
            // Create a new row and add the cells
            TableRow row = new TableRow(this);
            //ADD THE INFORMATION TO CELL 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMonth());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Change R.color.tableCellBackground to the
            // desired color

            //ADD THE INFORMATION TO CELL 2
            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getVolume()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);


            //ADD THE INFORMATION TO CELL 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getPrice())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);
            // el color

            //ADD THE INFORMATION TO CELL 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPoints())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            // Add the cells to the row
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            //Add the row to the TableLayout
            tableLayout.addView(row);
        }
    }

    private void addPaper(List<Paper> paperList){

        for (Paper item: paperList) {
            // Create a new row and add the cells
            TableRow row = new TableRow(this);
            //ADD THE INFORMATION TO CELL 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMonth());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Change R.color.tableCellBackground to the
            // desired color

            //ADD THE INFORMATION TO CELL 2
            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getNumberOfLeaves()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);


            //ADD THE INFORMATION TO CELL 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getPrice())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);
            // el color

            //ADD THE INFORMATION TO CELL 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPoints())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            // Add the cells to the row
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            //Add the row to the TableLayout
            tableLayout.addView(row);
        }
    }

    private void addMetal(List<Metals> metalList){

        for (Metals item: metalList) {
            // Create a new row and add the cells
            TableRow row = new TableRow(this);
            //ADD THE INFORMATION TO CELL 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMonth());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Change R.color.tableCellBackground to the
            // desired color

            //ADD THE INFORMATION TO CELL 2
            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getKilograms()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);


            //ADD THE INFORMATION TO CELL 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getPrice())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);
            // el color

            //ADD THE INFORMATION TO CELL 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPoints())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            // Add the cells to the row
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            //Add the row to the TableLayout
            tableLayout.addView(row);
        }
    }

    private void addComputerWaste(List<ComputerWaste> computerWasteList){

        for (ComputerWaste item: computerWasteList) {
            // Create a new row and add the cells
            TableRow row = new TableRow(this);
            //ADD THE INFORMATION TO CELL 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMonth());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Change R.color.tableCellBackground to the
            // desired color

            //ADD THE INFORMATION TO CELL 2
            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getElements()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white);


            //ADD THE INFORMATION TO CELL 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getPrice())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white);
            // el color

            //ADD THE INFORMATION TO CELL 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPoints())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white);

            // Add the cells to the row
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            //Add the row to the TableLayout
            tableLayout.addView(row);
        }
    }

    private void addAveragePlastic(List<Plastic> plasticList){
        //Get a reference to the TableLayout in your activity or fragment
        float averageRecicledPlastic = calculateAveragePlasticVolume(plasticList);
        float averagePricePlastic = calculateAveragePlasticPrice(plasticList);

        TableRow row = new TableRow(this);
        //ADD THE INFORMATION TO CELL 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 2
        TextView cell2 = new TextView(this);
        cell2.setText("Plástico");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white);


        //ADD THE INFORMATION TO CELL 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(averageRecicledPlastic));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(averagePricePlastic));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white);

        // Add the cells to the row
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Add the row to the TableLayout
        tableLayout.addView(row);
    }

    private void addAveragePaper(List<Paper> paperList){
        //Get a reference to the TableLayout in your activity or fragment
        float averageRecicledPaper = calculateAveragePaper(paperList);
        float averagePricePaper = calculateAveragePaperPrice(paperList);

        TableRow row = new TableRow(this);
        //ADD THE INFORMATION TO CELL 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 2
        TextView cell2 = new TextView(this);
        cell2.setText("Papel");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white);


        //ADD THE INFORMATION TO CELL 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(averageRecicledPaper));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(averagePricePaper));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white);

        // Add the cells to the row
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Add the row to the TableLayout
        tableLayout.addView(row);
    }

    private void addAverageMetals(List<Metals> metalsList){
        //Get a reference to the TableLayout in your activity or fragment
        float averageRecicledMetals = calculateAverageMetalKilograms(metalsList);
        float averagePriceMetals = calculateAverageMetalPrice(metalsList);

        TableRow row = new TableRow(this);
        //ADD THE INFORMATION TO CELL 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 2
        TextView cell2 = new TextView(this);
        cell2.setText("Metal");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white);


        //ADD THE INFORMATION TO CELL 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(averageRecicledMetals));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(averagePriceMetals));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white);

        // Add the cells to the row
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Add the row to the TableLayout
        tableLayout.addView(row);
    }

    private void addAverageComputerWaste(List<ComputerWaste> computerWasteList){
        //Get a reference to the TableLayout in your activity or fragment
        float averageRecicledComputerWaste = calculateAverageComputerWaste(computerWasteList);
        float averagePriceComputerWaste = calculateAverageComputerWastePrice(computerWasteList);

        TableRow row = new TableRow(this);
        //ADD THE INFORMATION TO CELL 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 2
        TextView cell2 = new TextView(this);
        cell2.setText("Electrónica");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white);


        //ADD THE INFORMATION TO CELL 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(averageRecicledComputerWaste));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white);

        //ADD THE INFORMATION TO CELL 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(averagePriceComputerWaste));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white);

        // Add the cells to the row
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Add the row to the TableLayout
        tableLayout.addView(row);
    }

    private float calculateAveragePlasticVolume(List<Plastic> plasticList) {
        float sum = 0;
        for (Plastic item : plasticList) {
            sum += item.getVolume();
        }
        return sum / plasticList.size();
    }
    private float calculateAveragePlasticPrice(List<Plastic> plasticList) {
        float sum = 0;
        for (Plastic item : plasticList) {
            sum += item.getPrice();
        }
        return sum / plasticList.size();
    }

    private float calculateAveragePaper(List<Paper> paperList) {
        float sum = 0;
        for (Paper item : paperList) {
            sum += item.getNumberOfLeaves();
        }
        return sum / paperList.size();
    }
    private float calculateAveragePaperPrice(List<Paper> paperList) {
        float sum = 0;
        for (Paper item : paperList) {
            sum += item.getPrice();
        }
        return sum / paperList.size();
    }
    private float calculateAverageMetalKilograms(List<Metals> metalList) {
        float sum = 0;
        for (Metals item : metalList) {
            sum += item.getKilograms();
        }
        return sum / metalList.size();
    }
    private float calculateAverageMetalPrice(List<Metals> metalList) {
        float sum = 0;
        for (Metals item : metalList) {
            sum += item.getPrice();
        }
        return sum / metalList.size();
    }
    private float calculateAverageComputerWaste(List<ComputerWaste> computerWasteList) {
        float sum = 0;
        for (ComputerWaste item : computerWasteList) {
            sum += item.getElements();
        }
        return sum / computerWasteList.size();
    }
    private float calculateAverageComputerWastePrice(List<ComputerWaste> computerWasteList) {
        float sum = 0;
        for (ComputerWaste item : computerWasteList) {
            sum += item.getPrice();
        }
        return sum / computerWasteList.size();
    }

}