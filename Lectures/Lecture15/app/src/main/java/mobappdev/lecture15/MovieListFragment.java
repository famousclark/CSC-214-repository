package mobappdev.lecture15;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobappdev.lecture15.model.Movie;
import mobappdev.lecture15.model.MovieCollection;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieListFragment extends Fragment {
    private MovieCollection mMovieCollection;
    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;

    public MovieListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMovieCollection = MovieCollection.get(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_movies);
        updateUI();

        return view;
    }

    public void updateUI() {
        List<Movie> movies = mMovieCollection.getMovies();
        if(mAdapter == null) {
            mAdapter = new MovieAdapter(movies);
            mRecyclerView.setAdapter(mAdapter);
        }
        else {
            mAdapter.setMovies(movies);
        }
    }
}
