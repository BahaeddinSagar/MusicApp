package ly.bsagar.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MusicDetailActivity extends AppCompatActivity {
    int currentIndex;
    boolean isPlay;
    ArrayList<Song> songs;
    ImageView songImage;
    TextView songNameTextView;
    TextView artistTextView;
    TextView yearTextView;
    ImageView playImage;
    ImageView FFImage;
    ImageView RRImage;
    ImageView SkipFImage;
    ImageView SkipBImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        setTitle(R.string.NowPlaying);
        Intent intent = getIntent();
        songs = intent.getParcelableArrayListExtra("SongList");
        currentIndex = intent.getIntExtra("index", -1);
        songImage = findViewById(R.id.songImage);
        songNameTextView = findViewById(R.id.songName);
        artistTextView = findViewById(R.id.artistTextView);
        yearTextView = findViewById(R.id.yearTextView);

        isPlay = true;

        playImage = findViewById(R.id.playImage);
        FFImage = findViewById(R.id.fastForwardImage);
        RRImage = findViewById(R.id.reverseImage);
        SkipFImage = findViewById(R.id.skipForwardImage);
        SkipBImage = findViewById(R.id.skipBackwardImage);

        displaySongInfo();

        playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlay) {
                    Toast.makeText(MusicDetailActivity.this, "Playing", Toast.LENGTH_SHORT).show();
                    isPlay = false;
                    playImage.setImageResource(android.R.drawable.ic_media_pause);
                } else {
                    Toast.makeText(MusicDetailActivity.this, "Paused", Toast.LENGTH_SHORT).show();
                    isPlay = true;
                    playImage.setImageResource(android.R.drawable.ic_media_play);
                }
            }
        });
        FFImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MusicDetailActivity.this, "Fast Forward", Toast.LENGTH_SHORT).show();
            }
        });
        RRImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MusicDetailActivity.this, "Fast Backword", Toast.LENGTH_SHORT).show();
            }
        });
        SkipFImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                    displaySongInfo();
                } else {
                    Toast.makeText(MusicDetailActivity.this, "End of the List", Toast.LENGTH_SHORT).show();
                }

            }
        });
        SkipBImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displaySongInfo();
                } else {
                    Toast.makeText(MusicDetailActivity.this, "beginning of the list", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void displaySongInfo() {
        Song currentSong = songs.get(currentIndex);

        songNameTextView.setText(currentSong.songName);
        artistTextView.setText(currentSong.artist);
        yearTextView.setText(String.valueOf(currentSong.year));

        Picasso.get().load(currentSong.imageURL).into(songImage);
    }

}
