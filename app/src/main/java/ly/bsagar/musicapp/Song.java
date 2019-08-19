package ly.bsagar.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    String songName;
    String artist;
    String imageURL;
    String year;
    String lyrics;


    public Song(String songName, String artist, String imageURL, String year, String lyrics) {
        this.songName = songName;
        this.artist = artist;
        this.imageURL = imageURL;
        this.year = year;
        this.lyrics = lyrics;
    }

    public Song(String songName, String artist, String imageURL, String year) {
        this.songName = songName;
        this.artist = artist;
        this.imageURL = imageURL;
        this.year = year;
    }

    public Song(Parcel in) {
        songName = in.readString();
        artist = in.readString();
        imageURL = in.readString();
        year = in.readString();
        lyrics  = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(songName);
        parcel.writeString(artist);
        parcel.writeString(imageURL);
        parcel.writeString(year);
        parcel.writeString(lyrics);
        }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}

