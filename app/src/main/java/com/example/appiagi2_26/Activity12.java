package com.example.appiagi2_26;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity12 extends AppCompatActivity {
    ImageView dog,cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_12);

        dog =findViewById(R.id.dog);
        cat =findViewById(R.id.cat);

        dog.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),VideoActivity1.class);
            intent.putExtra("videoDog","dog1");
            startActivity(intent);
                });
        cat.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),VideoActivity.class);
            intent.putExtra("videoCat","cat1");
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}