package com.example.appiagi2_26;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridActivity extends AppCompatActivity {

    String[] pays = {
            "Maroc","France","Espagne","Italie","Allemagne",
            "Portugal","Brésil","USA","Canada","Mexique",
            "Chine","Japon","Inde","Corée","Turquie",
            "Égypte","Sénégal","Nigeria","Argentine","Australie"
    };
    Button button6;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid);
        button6.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),ListGridSpinner.class);
            intent.putExtra("c2","s2");
            startActivity(intent);
        });

        gridView =findViewById(R.id.gridView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,pays);
        gridView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}