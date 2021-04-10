package com.blogspot.thengnet.musicarch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A dummy activity for playing audio tracks.
 */
public class PlayerActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnLongClickListener {

    private static boolean isPlaying;
    private static long elapsedTime; // milliseconds -- 1 millisecond == 1 second
    private static String title, length;

    private TextView tvMediaTitle, tvMediaElapsed, tvMediaLength;
    private ImageView imgPrevOrRewind, imgPlayPauseOrStop, imgNextOrFastForward;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent media = getIntent();
        if (media != null) {
            // get current media title & length from intent that started this activity and store as
            // {@link String} variables.
            title = media.getStringExtra("media-title");
            length = media.getStringExtra("media-length");

            // lookup the appropriate views, and set the values of #title & #length in them.
            tvMediaTitle = (TextView) findViewById(R.id.tv_media_title);
            tvMediaLength = (TextView) findViewById(R.id.tv_total_time);
            tvMediaTitle.setText(title);
            tvMediaTitle.append(" playing");
            tvMediaLength.setText(length);

            // lookup the elapsed time {@link TextView} and set it to "00:00"
            // TODO: Set this in #activity_player.xml, and don't bother doing extra work here.
            tvMediaElapsed = (TextView) findViewById(R.id.tv_elapsed_time);
            tvMediaElapsed.setText("00:00");
        }

        // lookup controller {@link ImageView}s
        imgPrevOrRewind = (ImageView) findViewById(R.id.img_previous_rewind);
        imgPlayPauseOrStop = (ImageView) findViewById(R.id.img_play_pause);
        imgNextOrFastForward = (ImageView) findViewById(R.id.img_next_fastForward);

        // attach event handler for simple clicks
        imgPrevOrRewind.setOnClickListener(this);
        imgPlayPauseOrStop.setOnClickListener(this);
        imgNextOrFastForward.setOnClickListener(this);

        // attach event handler for long clicks
        imgPrevOrRewind.setOnLongClickListener(this);
        imgPlayPauseOrStop.setOnLongClickListener(this);
        imgNextOrFastForward.setOnLongClickListener(this);

        // start playback
        play();
    }

    /**
     * View.OnClickListener callback implementation for simple clicks.
     * The @param v object clicked.
     */
    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.img_previous_rewind:
                if (isPlaying)
                    rewind();
                break;
            case R.id.img_play_pause:
                if (isPlaying)
                    pause();
                else
                    play();
                break;
            case R.id.img_next_fastForward:
                if (isPlaying)
                    fastForward();
                break;
        }
    }

    /**
     * View.OnLongClickListener callback implementation for long clicks.
     * The @param v object clicked.
     *
     * @return #true if successfully handled, otherwise #false.
     */
    @Override
    public boolean onLongClick (View v) {
        switch (v.getId()) {
            case R.id.img_previous_rewind:
                previous();
                return true;
            case R.id.img_play_pause:
                stop();
                return true;
            case R.id.img_next_fastForward:
                next();
                return true;
            default:
                return false;
        }
    }

    // TODO: think of way to interact data between #this & {@link MainActivity}, so tracks can be
    //  switched; without having to use {@link LiveData} + {@link ViewModel} yet, if possible,
    //  whatever those are.

    private void previous () {
        play();
    }

    /**
     * Utility method to rewind current track by 10,000 milliseconds -- 10 seconds.
     */
    private void rewind () {
        elapsedTime -= 10 * 1000;
        play();
    }

    /**
     * Utility method to pause playback of current track.
     */
    private void pause () {
        isPlaying = false;
    }

    /**
     * Utility method to play/resume current track (playback).
     */
    private void play () {
        isPlaying = true;
    }

    /**
     * Utility method to stop playback of current track, and reset timer to 0 millisecond.
     */
    private void stop () {
        isPlaying = false;
        elapsedTime = 0L;
    }

    /**
     * Utility method to fast-forward current track playback by 10,000 milliseconds -- 10 seconds.
     */
    private void fastForward () {
        elapsedTime += 10 * 1000;
        play();
    }

    private void next () {

    }
}