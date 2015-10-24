package mobappdev.lecture15;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobappdev.lecture15.model.Movie;

/**
 * Created by USX13992 on 10/23/2015.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private static final String TAG = "MovieAdapter";
    private List<Movie> mMovies;

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder() called");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.view_movie, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder(holder," + position +") called");
        Movie movie = mMovies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount() returning " + mMovies.size());
        return mMovies.size();
    }

    /**
     * This method is called whenever the set of movies changes.  This could mean that a movie
     * was added, removed, or updated.
     *
     * @param movies The current set of movies.
     */
    public void setMovies(List<Movie> movies) {
        mMovies = movies;
        notifyDataSetChanged();
    }
}
