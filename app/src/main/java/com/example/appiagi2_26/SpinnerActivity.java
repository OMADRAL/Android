package com.example.appiagi2_26;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> paysList;
    Button btnAdd;
    Button button8;
    ArrayAdapter<String> adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        button8.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),ListGridSpinner.class);
            intent.putExtra("c3","s3");
            startActivity(intent);
        });

        spinner = findViewById(R.id.spinner);

        // Déclaration et initialisation
        paysList = new ArrayList<>();
        paysList.add("Maroc");
        paysList.add("France");
        paysList.add("Espagne");
        paysList.add("Italie");
        paysList.add("Allemagne");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                paysList);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view,
                                               int position,
                                               long id) {

                        Toast.makeText(getApplicationContext(),
                                paysList.get(position),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
        findViewById(R.id.btnAdd).setOnClickListener(v -> showAddDialog());
    }

    private void showAddDialog() {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("Ajouter un pays");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Ajouter", (dialog, which) -> {

            String nouveau = input.getText().toString();

            if (!nouveau.isEmpty()) {
                paysList.add(nouveau);
                adapter.notifyDataSetChanged();
            }
        });

             builder.setNegativeButton("Annuler", null);

        builder.show();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}