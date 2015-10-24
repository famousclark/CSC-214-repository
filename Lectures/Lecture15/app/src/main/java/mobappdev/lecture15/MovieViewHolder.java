package mobappdev.lecture15;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import mobappdev.lecture15.model.Movie;

/**
 * Created by USX13992 on 10/23/2015.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final TextView mTitle;
    private final TextView mDirector;
    private final TextView mGenre;
    private final TextView mReleaseYear;
    private final Calendar mCalendar;

    public MovieViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView)itemView.findViewById(R.id.text_view_title);
        mDirector = (TextView)itemView.findViewById(R.id.text_view_director);
        mGenre = (TextView)itemView.findViewById(R.id.text_view_genre);
        mReleaseYear = (TextView)itemView.findViewById(R.id.text_view_release_year);
        mCalendar = Calendar.getInstance();
    }

    public void bind(Movie movie) {
        mTitle.setText(movie.getTitle());
        mDirector.setText(movie.getDirector());
        mGenre.setText(movie.getGenre());
        mCalendar.setTime(movie.getReleaseDate());
        mReleaseYear.setText(Integer.toString(mCalendar.get(Calendar.YEAR)));
    }
}
