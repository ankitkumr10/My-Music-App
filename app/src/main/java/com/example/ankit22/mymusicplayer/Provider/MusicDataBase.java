package com.example.ankit22.mymusicplayer.Provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by ankit on 5/8/15.
 */
public class MusicDataBase extends SQLiteOpenHelper{
    public static int VERSION =1;
    public static String DATABASE_NAME = "musicdb";

    public interface Tables{
        String MUSIC= "music";
    }
    public interface TableMusic{
        String ARTIST_IMAGE_URL= "artistUrl";
        String ALBUM = "album";
        String SONG= "song";
    }

    public MusicDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    final String CREATE_TABLE_MUSIC =  "create table " + Tables.MUSIC +"("
            + BaseColumns._ID + "INTEGER PRIMARY KEY AUTOINCREAMENT,"
            + TableMusic.ARTIST_IMAGE_URL +" TEXT NOT NULL,"
            + TableMusic.ALBUM +"TEXT NOT NULL,"
            + TableMusic.SONG +"TEXT NOT NULL);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MUSIC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
