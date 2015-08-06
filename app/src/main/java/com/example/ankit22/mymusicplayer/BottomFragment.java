package com.example.ankit22.mymusicplayer;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ankit22 on 5/8/15.
 */
public class BottomFragment extends Fragment {
    private TextView text;
    private ImageView play;
    private ImageView pause;
    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_bar,container,false);
        text=(TextView)view.findViewById(R.id.Song_name1);
        play=(ImageView)view.findViewById(R.id.Play);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        Intent intent = getActivity().getIntent();
        Music item = new Music(intent.getStringExtra("albumName"), intent.getStringExtra("albumName"), intent.getStringExtra("artistName"),intent.getIntExtra("rawResourceid",0));
        text.setText(item.getSongName());
        int id = item.getRawResourceid();
        if (id != 0) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.create(getActivity(),id);
            mediaPlayer.start();
            play.setVisibility(View.GONE);
            pause.setVisibility(View.VISIBLE);
        }*/
    }
}
