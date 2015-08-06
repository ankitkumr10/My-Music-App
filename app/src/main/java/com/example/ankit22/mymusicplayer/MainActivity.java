package com.example.ankit22.mymusicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ankit22.mymusicplayer.Model.Music;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView playMusic;
    private ImageView pauseMusic;
    private ImageView forwardMusic;
    private ImageView rewindMusic;
    private MediaPlayer mediaPlayer;
    private SeekBar seekbar;
    private MusicHandler handler;
    private TextView displaySongName;
    private TextView displayArtistName;
    private ImageView displayAlbumImage;
    private static final String MUSIC_DETAILS = "MUSIC_DETAILS";
    public static int MESSAGE_WAKE_UP_AND_SEEK = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playMusic = (ImageView) findViewById(R.id.activity_main_play);
        pauseMusic = (ImageView) findViewById(R.id.activity_main_pause);
        forwardMusic = (ImageView) findViewById(R.id.activity_main_fastForward);
        rewindMusic = (ImageView) findViewById(R.id.activity_main_rewind);
        seekbar = (SeekBar) findViewById(R.id.activity_main_seekbar);

        displaySongName = (TextView) findViewById(R.id.activity_song_name);
        displayArtistName = (TextView) findViewById(R.id.activity_song_artist);
        displayAlbumImage = (ImageView) findViewById(R.id.activity_image);
        handler = new MusicHandler();
        Intent intent = getIntent();

        Music item = new Music(intent.getStringExtra("songName"), intent.getStringExtra("albumName"), intent.getStringExtra("artistName"),intent.getIntExtra("rawResourceid",0));

        String songName = item.getSongName();
        String artistName = item.getArtistName();
        String albumImage = item.getImageUrl();

        int sound_id = item.getRawResourceid();

        displaySongName.setText(songName);
        displayArtistName.setText(artistName);
        Picasso.with(this).load(albumImage).into(displayAlbumImage);

        if (sound_id != 0) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer = MediaPlayer.create(this, item.getRawResourceid());
            mediaPlayer.start();
            handler.sendEmptyMessage(MESSAGE_WAKE_UP_AND_SEEK);
            seekbar.setMax(mediaPlayer.getDuration());
            playMusic.setVisibility(View.GONE);
            pauseMusic.setVisibility(View.VISIBLE);
        }

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("position", progress + "");
                int duration = mediaPlayer.getDuration();
                Log.d("duration", duration + "");
                if (fromUser) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.seekTo(progress);
                        //  mediaPlayer.seekTo((int) ((float) progress / 100 * duration));
                    } else {
                        mediaPlayer.start();
                        mediaPlayer.seekTo(progress);

                    }
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (mediaPlayer.isPlaying() && mediaPlayer != null) {
                        pauseMusic.setVisibility(View.GONE);
                        playMusic.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        playMusic.setVisibility(View.GONE);
                        pauseMusic.setVisibility(View.VISIBLE);

                    } else {

                        mediaPlayer.start();
                        playMusic.setVisibility(View.GONE);
                        pauseMusic.setVisibility(View.VISIBLE);
                        handler.sendEmptyMessage(MESSAGE_WAKE_UP_AND_SEEK);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "cant play this song", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pauseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying() && mediaPlayer != null) {
                    mediaPlayer.pause();
                    pauseMusic.setVisibility(View.GONE);
                    playMusic.setVisibility(View.VISIBLE);
                }
            }
        });

        forwardMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null)
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 10000);
                else
                    Toast.makeText(MainActivity.this, "cant forward this song", Toast.LENGTH_SHORT).show();


            }
        });

        rewindMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null)
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 10000);
                else
                    Toast.makeText(MainActivity.this, "cant rewind this song", Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
//            mediaPlayer.reset();
//            mediaPlayer.release();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.stop();
//            mediaPlayer.reset();
//            mediaPlayer.release();
        }

    }

    class MusicHandler extends android.os.Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_WAKE_UP_AND_SEEK) {
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        seekbar.setProgress(mediaPlayer.getCurrentPosition());
                        sendEmptyMessageDelayed(MESSAGE_WAKE_UP_AND_SEEK, 200);
                    }
                }
            }
            super.handleMessage(msg);
        }
    }

}
