package com.example.appiagi2_26;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activite11 extends AppCompatActivity {
    Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite11);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void chat (View view){
        Toast t= Toast.makeText(getApplicationContext(), "coucou chat ", Toast.LENGTH_SHORT);
        t.show();
        MediaPlayer media= MediaPlayer.create(getApplicationContext(), R.raw.chat);
        media.start();
    }
    public void chien (View view){
        Toast t= Toast.makeText(getApplicationContext(), "coucou chien ", Toast.LENGTH_SHORT);
        t.show();
        MediaPlayer media= MediaPlayer.create(getApplicationContext(), R.raw.chien);
        media.start();

    }

}