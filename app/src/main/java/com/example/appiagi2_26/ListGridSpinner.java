package com.example.appiagi2_26;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListGridSpinner extends AppCompatActivity {
    Button btnList;
    Button btnGrid;
    Button btnSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_grid_spinner);

        btnList=findViewById(R.id.btnList);
        btnGrid=findViewById(R.id.btnGrid);
        btnSpinner=findViewById(R.id.btnSpinner);

        btnList.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),ListActivity.class);
            intent.putExtra("c1","s1");startActivity(intent);
        });

        btnGrid.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),GridActivity.class);
            intent.putExtra("c2","s2");startActivity(intent);
        });

        btnSpinner.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),SpinnerActivity.class);
            intent.putExtra("c3","s3");startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}