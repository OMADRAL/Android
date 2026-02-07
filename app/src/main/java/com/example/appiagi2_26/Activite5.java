package com.example.appiagi2_26;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activite5 extends AppCompatActivity {
    EditText e1, e2;
    TextView t4;
    Button btnPlus, btnMoins, btnFois, btnDivise, btnEffacer,btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite5);


        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        t4 = findViewById(R.id.t4);

        btnPlus = findViewById(R.id.btnPlus);
        btnMoins = findViewById(R.id.btnMoins);
        btnFois = findViewById(R.id.btnFois);
        btnDivise = findViewById(R.id.btnDivise);
        btnEffacer = findViewById(R.id.btnEffacer);
        btnResult = findViewById(R.id.btnResult);

        // BOUTON ADDITION
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = e1.getText().toString();
                String v2 = e2.getText().toString();

                if (!v1.isEmpty() && !v2.isEmpty()) {
                    int n1 = Integer.parseInt(v1);
                    int n2 = Integer.parseInt(v2);
                    int resultat = n1 + n2;
                    t4.setText(n1 + " + " + n2 + " = " + resultat);
                }
            }
        });

        // BOUTON SOUSTRACTION
        btnMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = e1.getText().toString();
                String v2 = e2.getText().toString();

                if (!v1.isEmpty() && !v2.isEmpty()) {
                    int n1 = Integer.parseInt(v1);
                    int n2 = Integer.parseInt(v2);
                    int resultat = n1 - n2;
                    t4.setText(n1 + " - " + n2 + " = " + resultat);
                }
            }
        });

        // BOUTON MULTIPLICATION
        btnFois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = e1.getText().toString();
                String v2 = e2.getText().toString();

                if (!v1.isEmpty() && !v2.isEmpty()) {
                    int n1 = Integer.parseInt(v1);
                    int n2 = Integer.parseInt(v2);
                    int resultat = n1 * n2;
                    t4.setText(n1 + " *" + n2 + " = " + resultat);
                }
            }
        });

        // BOUTON DIVISION
        btnDivise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = e1.getText().toString();
                String v2 = e2.getText().toString();

                if (!v1.isEmpty() && !v2.isEmpty()) {
                    int n1 = Integer.parseInt(v1);
                    int n2 = Integer.parseInt(v2);

                    if (n2 != 0) {
                        int resultat = n1 / n2;
                        t4.setText(n1 + " / " + n2 + " = " + resultat);
                    } else {
                        t4.setText("Erreur: division par zéro");
                    }
                }
            }
        });

        // BOUTON EFFACER
        btnEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                t4.setText("");
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = e1.getText().toString();
                String v2 = e2.getText().toString();
                if (!v1.isEmpty() && !v2.isEmpty()) {
                    int n1 = Integer.parseInt(v1);
                    int n2 = Integer.parseInt(v2);
                    int resultat = n1 + n2;
                    t4.setText("Résultat: " + resultat);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}