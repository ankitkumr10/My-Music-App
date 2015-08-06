package com.example.ankit22.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ankit22.mymusicplayer.Model.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 4/8/15.
 */
public class FirstFragment extends android.support.v4.app.Fragment{
    private ListView listView;
    private List<Music> musicList = new ArrayList<>();
    private MusicAdapter musicAdapter;
    private static final String MUSIC_DETAILS = "MUSIC_DETAILS";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        listView= (ListView)view.findViewById(R.id.fragment_first_listview);
        musicAdapter = new MusicAdapter(getActivity(),musicList);
        listView.setAdapter(musicAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Music item = (Music) adapterView.getItemAtPosition(position);
//                int sound_id = getActivity().getResources().getIdentifier(item.(), "raw",
//                        getActivity().getPackageName());
                int sound_id = item.getRawResourceid();
                if (sound_id !=0){
//                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    Intent intent1 = new Intent(getActivity(),BottomFragment.class);
//                    intent.putExtra("rawResourceid",item.getRawResourceid());
//                    intent.putExtra("songName",item.getSongName());
                    intent1.putExtra("rawResourceid",item.getRawResourceid());
                    intent1.putExtra("songName",item.getSongName());
//                    intent.putExtra("artistName", item.getArtistName());
//                    intent.putExtra("albumName",item.getImageUrl());
//                   startActivity(intent);
                    startActivity(intent1);
                } else {
                    Toast.makeText(getActivity(), "cant find this song", Toast.LENGTH_SHORT).show();

                }

            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstFragment", "onCreate");
        musicList.add(new Music("Jeena Jeena", "R.drawable.image", "Badlapur", R.raw.a));
        musicList.add(new Music("Jee Karda", "R.drawable.image", "Badlapur",R.raw.b));
        musicList.add(new Music("Judaai", "R.drawable.image", "Badlapur",R.raw.c));
        musicList.add(new Music("Sun Saathiyaa", "R.drawable.image", "ABCD2",R.raw.d));
        musicList.add(new Music("song4","R.drawable.image", "title",0));
        musicList.add(new Music("song5", "R.drawable.image", "title",0));
        musicList.add(new Music("song6", "R.drawable.image", "title",0));
        musicList.add(new Music("song7", "R.drawable.image", "title",0));
    }
}
