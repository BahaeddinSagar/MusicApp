package ly.bsagar.musicapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MusicRecycleAdapter extends RecyclerView.Adapter<MusicRecycleAdapter.ViewHolder> {

    private ArrayList<Song> songs;
    private Context context;

    MusicRecycleAdapter( Context context,ArrayList<Song> songs) {
        this.songs = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.yearTextView.setText(songs.get(position).year);
        holder.titleTextView.setText(songs.get(position).songName);
        holder.artistTextView.setText(songs.get(position).artist);
        Picasso.get()
                .load(songs.get(position).imageURL)
                .into(holder.imageView);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MusicDetailActivity.class);
                intent.putExtra("SongList",songs);
                intent.putExtra("index",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView ;
        TextView artistTextView;
        TextView yearTextView ;
        ImageView imageView ;
        LinearLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            artistTextView = itemView.findViewById(R.id.artistTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            imageView = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parent);

        }
    }


}
