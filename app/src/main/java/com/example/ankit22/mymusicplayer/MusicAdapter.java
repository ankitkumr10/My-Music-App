package com.example.ankit22.mymusicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ankit22.mymusicplayer.Model.Music;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by ankit on 4/8/15.
 */
public class MusicAdapter extends BaseAdapter {
 //   Context context;
    WeakReference<Context> contextWeakReference;
    List<Music> musicList;

    public MusicAdapter(Context context,List<Music>musicList)
    {
        this.contextWeakReference= new WeakReference<Context>(context);
        this.musicList=musicList;

    }
    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView albumTextView;
        ImageView Image;
        TextView songTextView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= convertView;
        ViewHolder viewHolder=null;
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(contextWeakReference.get());
            view = layoutInflater.inflate(R.layout.item_music, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.albumTextView  = (TextView) view.findViewById(R.id.item_music_album);
            viewHolder.Image = (ImageView) view.findViewById(R.id.item_music_artist);
            viewHolder.songTextView= (TextView) view.findViewById(R.id.item_music_song);

            view.setTag(viewHolder);
        }
        if(viewHolder== null)
        {
            viewHolder = (ViewHolder)view.getTag();
        }

        Music music = (Music)getItem(position);

//        viewHolder.Image.setText(music.getImageUrl());
        Picasso.with(contextWeakReference.get())
                .load(music.getImageUrl())
                .into(viewHolder.Image);
        viewHolder.songTextView.setText(music.getSongName());
        viewHolder.albumTextView.setText(music.getArtistName());


        return view;
    }
}
