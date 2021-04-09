package com.blogspot.thengnet.musicarch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Media> mediaArrayList;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaArrayList = new ArrayList<>();

        mediaArrayList.add(new Media("The Dark Knight", "04:49"));
        mediaArrayList.add(new Media("Krieg, Teil 1", "0:49"));
        mediaArrayList.add(new Media("Der Mann in Schwarz, Teil 3", "03:05"));
        mediaArrayList.add(new Media("Krieg, Teil 11", "04:05"));
        mediaArrayList.add(new Media("Der Mann in Schwarz, Teil 8", "02:51"));
        mediaArrayList.add(new Media("Monster, Teil 4", "11:22"));
        mediaArrayList.add(new Media("Krieg, Teil 7", "11:08"));
        mediaArrayList.add(new Media("Batman, an Invocation to Heal / To Be Seen", "08:36"));
        mediaArrayList.add(new Media("Batman, a Duty to Fight/To See", "05:29"));
        mediaArrayList.add(new Media("The Batman Theme", "02:38"));
        mediaArrayList.add(new Media("Molossus", "04:49"));

        MediaAdapter mediaListAdapter = new MediaAdapter(this, mediaArrayList);

        ListView mediaList = (ListView) findViewById(R.id.list_media);
        mediaList.setAdapter(mediaListAdapter);

        mediaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Intent play = new Intent(MainActivity.this, PlayerActivity.class);
                play.putExtra("media-title", mediaArrayList.get(position).getMediaTitle());
                play.putExtra("media-length", mediaArrayList.get(position).getMediaLength());

                startActivity(play);
            }
        });
    }
}