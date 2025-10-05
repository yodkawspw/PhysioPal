package com.example.physiopal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class ShoulderRoll extends AppCompatActivity {

    ExoPlayer player;
    String videoUrl = "https://files.catbox.moe/2uyort.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shoulder_roll);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        StyledPlayerView playerView = findViewById(R.id.playerView);
        player = new ExoPlayer.Builder(ShoulderRoll.this).build();
        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(videoUrl);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true);
        playerView.hideController();
        player.setRepeatMode(player.REPEAT_MODE_ONE);
        player.setVolume(0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.setPlayWhenReady(false);
        player.release();
        player = null;
    }
}