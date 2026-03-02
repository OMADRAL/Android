package com.example.appiagi2_26;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {

    String pays[] = {
            "Maroc", "France", "Espagne", "Italie", "Allemagne",
            "Portugal", "Brésil", "USA", "Canada", "Mexique",
            "Chine", "Japon", "Inde", "Corée", "Turquie",
            "Égypte", "Sénégal", "Nigeria", "Argentine", "Australie"
    };
    ListView listView;
    Button button7;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listView);
        button7=findViewById(R.id.button7);
        button7.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),ListGridSpinner.class);
            intent.putExtra("c1","s1");
            startActivity(intent);
        });
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pays);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, pays[position], Toast.LENGTH_SHORT).show();});
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}