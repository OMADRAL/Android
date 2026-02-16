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

public class VideoActivity extends AppCompatActivity {
    Button br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        br=findViewById(R.id.br);
        br.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(), Activity12.class);
            intent.putExtra("c1","s1");
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void afficher(View view){
        VideoView videoView1=findViewById(R.id.Vchat);
        String videoCat= getIntent().getStringExtra("videoCat");

        Uri uri1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cat1);

        videoView1.setVideoURI(uri1);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController);
        videoView1.start();


    }
}