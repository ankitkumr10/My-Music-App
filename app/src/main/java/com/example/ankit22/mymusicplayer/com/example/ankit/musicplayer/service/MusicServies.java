package com.example.ankit22.mymusicplayer.com.example.ankit.musicplayer.service;

/**
 * Created by ankit on 5/8/15.
 */
import android.content.Intent;
import android.app.Service;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import hugo.weaving.DebugLog;

public class MusicServies extends Service {

    private static MediaPlayer mediaPlayer;
    public static final String KEY_METHOD = "method";
    public static final String METHOD_PLAY = "method_play";
    public static final String METHOD_PAUSE = "method_pause";
    public static final String METHOD_STOP = "method_stop";
    public static final String METHOD_FASTFRWD = "method_ff";
    public static final String METHOD_REWIND = "method_rw";

    public static int getCurrentPosition(){
        if(mediaPlayer!=null) {
            if (mediaPlayer.isPlaying()){
                return mediaPlayer.getCurrentPosition();
            }
        }
        return -1;
    }
    @Override
    @DebugLog
    public void onCreate() {
        super.onCreate();
    }
    @DebugLog
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @DebugLog
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String method= intent.getStringExtra(KEY_METHOD);
        if(method.equals(METHOD_PLAY)){

        }
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
