package ly.bsagar.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongsArrayAdapter extends ArrayAdapter<Song> {
    private int mResource;

    SongsArrayAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);
        mResource =resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(mResource,parent,false);
        }

        Song song = getItem(position);

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView authorTextView = view.findViewById(R.id.artistTextView);
        TextView yearTextView = view.findViewById(R.id.yearTextView);
        ImageView imageView = view.findViewById(R.id.imageView);

        titleTextView.setText(song.songName);
        authorTextView.setText(song.artist);
        yearTextView.setText(String.valueOf(song.year));
        Picasso.get()
                .load(song.imageURL)
                .placeholder(android.R.drawable.ic_menu_slideshow)
                .into(imageView);


        return view;


    }
}
