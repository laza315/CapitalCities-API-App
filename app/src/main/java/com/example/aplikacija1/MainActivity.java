package com.example.aplikacija1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aplikacija1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonPodaci;
    private TextView labelGlavniGradovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        buttonPodaci = findViewById(R.id.buttonPodaci);
        labelGlavniGradovi = findViewById(R.id.labelPrikaz);
        buttonPodaci.setOnClickListener(this);
    }

    ReadDataHandler handler = new ReadDataHandler() {
        @Override
        public void handleMessage(Message msg) {
            String odgovor = getJson2();
            try {
                JSONArray array = new JSONArray(odgovor);
                LinkedList<CapitalCities> cities = CapitalCities.parseJsonArray(array);
                labelGlavniGradovi.setText("Glavni gradovi: \n\n");
                for (CapitalCities c : cities) {
                    String display = "{" + "\n" + "\t\t" +
                            "name: " + c.getName() + "\n" + "\t\t" +
                            "country: " + c.getCountry() + "\n" + "\t\t" +
                            "num_residents: " + c.getNum_residents() + "\n" + "\t\t" +
                            "size: " + c.getSize() + "\n" + "\t\t" +
                            "major: "+ c.getMajor() + "\n"  + "}," + "\n";
                    labelGlavniGradovi.append(display);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onClick(View view) {
        labelGlavniGradovi.setText("Ucitavam...");
        Api.getJSON("https://run.mocky.io/v3/bed10397-ffe6-49c5-a103-6e333dff77ee", handler);
    }





}