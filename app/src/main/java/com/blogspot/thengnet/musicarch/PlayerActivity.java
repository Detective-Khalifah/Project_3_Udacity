package com.blogspot.thengnet.musicarch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    private static String title, length;
    private TextView tvMediaTitle, tvMediaElapsed, tvMediaLength;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent media = getIntent();
        if (media != null) {
            title = media.getStringExtra("media-title");
            length = media.getStringExtra("media-length");

            tvMediaTitle = (TextView) findViewById(R.id.tv_media_title);
            tvMediaLength = (TextView) findViewById(R.id.tv_total_time);
            tvMediaTitle.setText(title);
            tvMediaTitle.append(" playing");
            tvMediaLength.setText(length);

            tvMediaElapsed = (TextView) findViewById(R.id.tv_elapsed_time);
            tvMediaElapsed.setText("00:00");
        }
    }
}