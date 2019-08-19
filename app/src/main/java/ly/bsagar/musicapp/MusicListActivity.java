package ly.bsagar.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicListActivity extends AppCompatActivity {

    ArrayList<Song> songs;

    void createSongs() {
        songs = new ArrayList<>();
        songs.add(new Song(getString(R.string.title1), getString(R.string.artist1), getString(R.string.url1)
                , getString(R.string.year1)));
        songs.add(new Song(getString(R.string.title2), getString(R.string.artist2), getString(R.string.url2),
                getString(R.string.year2)));
        songs.add(new Song(getString(R.string.title3), getString(R.string.artist3), getString(R.string.url3),
                getString(R.string.year3)));
        songs.add(new Song(getString(R.string.title4), getString(R.string.artist4), getString(R.string.url4),
                getString(R.string.year4)));
        songs.add(new Song(getString(R.string.title5), getString(R.string.artist5), getString(R.string.url5),
                getString(R.string.year5)));
        songs.add(new Song(getString(R.string.title6), getString(R.string.artist6), getString(R.string.url6),
                getString(R.string.year6)));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        setTitle(R.string.browseSongs);
        createSongs();
        RecyclerView recyclerView = findViewById(R.id.songsListView);
        MusicRecycleAdapter adapter = new MusicRecycleAdapter(this,songs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
