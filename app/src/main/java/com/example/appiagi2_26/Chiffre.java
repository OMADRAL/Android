package com.example.appiagi2_26;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chiffre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chiffre);
        for (int i = 1; i <= 9; i++) {
            int imageId = getResources().getIdentifier("i" + i, "id", getPackageName());
            ImageView image = findViewById(imageId);
            final int index = i;
            image.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int soundId = getResources().getIdentifier("a" + index, "raw", getPackageName());
                    MediaPlayer media = MediaPlayer.create(getApplicationContext(), soundId);
                    media.start();

                }
            });
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
