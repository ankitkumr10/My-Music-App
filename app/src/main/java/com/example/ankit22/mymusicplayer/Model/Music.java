package com.example.ankit22.mymusicplayer.Model;

import java.io.Serializable;

/**
 * Created by ankit on 4/8/15.
 */
public class Music{
    private String songName;
    private String artistName;
    private String  ImageUrl;

    private int rawResourceid;

    public Music(String songName, String albumName, String artistName, int rawResourceid) {
        this.ImageUrl = albumName;
        this.artistName = artistName;
        this.songName = songName;
        this.rawResourceid = rawResourceid;

    }

    public int getRawResourceid() {

        return rawResourceid;
    }

    public void setRawResourceid(int rawResourceid) {

        this.rawResourceid = rawResourceid;
    }
    public String getSongName(){
        return songName;
    }
    public String getArtistName(){
        return artistName;
    }
    public String getImageUrl(){
        return ImageUrl;
    }
    public void setSongName(String s)
    {
        this.songName=s;
    }
    public void setArtistName(String s)
    {
        this.artistName =s;
    }
    public void setImageUrl(String s)
    {
        this.ImageUrl =s;
    }


}
