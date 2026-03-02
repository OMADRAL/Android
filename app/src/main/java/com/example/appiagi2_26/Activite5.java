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
    Button btnPlus, btnMoins, btnFois, btnDivise, btnEffacer, btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        t4 = findViewById(R.id.t4);

        btnPlus = findViewById(R.id.btnPlus);
        btnMoins = findViewById(R.id.btnMoins);
        btnFois = findViewById(R.id.btnFois);
        btnDivise = findViewById(R.id.btnDivise);
        btnEffacer = findViewById(R.id.btnEffacer);
        btnResult = findViewById(R.id.btnResult);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerOperation("+");
            }
        });

        btnMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerOperation("-");
            }
        });

        btnFois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerOperation("*");
            }
        });

        btnDivise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerOperation("/");
            }
        });

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

                t4.setText("Veuillez choisir une opération (+, -, *, /)");
            }
        });
    }

    private void calculerOperation(String operation) {
        String v1 = e1.getText().toString();
        String v2 = e2.getText().toString();

        if (!v1.isEmpty() && !v2.isEmpty()) {
            try {
                int n1 = Integer.parseInt(v1);
                int n2 = Integer.parseInt(v2);
                int resultat = 0;
                String symbole = "";
                String messageErreur = null;

                switch (operation) {
                    case "+":
                        resultat = n1 + n2;
                        symbole = "+";
                        break;
                    case "-":
                        resultat = n1 - n2;
                        symbole = "-";
                        break;
                    case "*":
                        resultat = n1 * n2;
                        symbole = "*";
                        break;
                    case "/":
                        if (n2 != 0) {
                            resultat = n1 / n2;
                            symbole = "/";
                        } else {
                            messageErreur = "Erreur: division par zéro";
                        }
                        break;
                    default:
                        messageErreur = "Opération inconnue";
                        break;
                }

                if (messageErreur != null) {
                    t4.setText(messageErreur);
                } else {
                    t4.setText(n1 + " " + symbole + " " + n2 + " = " + resultat);
                }

            } catch (NumberFormatException e) {
                t4.setText("Erreur: nombres invalides");
            } catch (Exception e) {
                t4.setText("Erreur inattendue");
            }
        } else {
            t4.setText("Veuillez saisir deux nombres");
        }
    }
}