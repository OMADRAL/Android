package com.example.appiagi2_26;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoActivity1 extends AppCompatActivity {

    Button br1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video1);
        br1=findViewById(R.id.br1);
        br1.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(), Activity12.class);
            intent.putExtra("c2","s2");
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void afficher(View view) {
        VideoView videoView = findViewById(R.id.Vchien);
        String videoDog = getIntent().getStringExtra("videoDog");

        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dog1);

        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}