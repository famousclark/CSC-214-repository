package mobappdev.lecture15;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;
import java.util.UUID;

import mobappdev.lecture15.model.Movie;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieFragment.OnMovieChangedListener} interface
 * to handle interaction events.
 */
public class MovieFragment extends Fragment {

    private static final String ARG_ID = "ARG_ID";
    private OnMovieChangedListener mListener;
    private EditText mTitle;
    private EditText mDirector;
    private Spinner mGenre;
    private Button mDateButton;
    private Date mDate;
    private String[] mGenres;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static MovieFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);

        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        mGenres = getResources().getStringArray(R.array.genres_array);
//
//        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
//
//        mTitle = (EditText)view.findViewById(R.id.edit_text_title);
//        mDirector = (EditText)view.findViewById(R.id.edit_text_director);
//        // set up the spinner
//        mGenre = (Spinner)view.findViewById(R.id.spinner_genres);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.genres_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mGenre.setAdapter(adapter);
//
//        Button buttonDate = (Button)view.findViewById(R.id.button_release_date);
//        buttonDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DateDialogFragment dialog = DateDialogFragment.newInstance(null);
//                dialog.setTargetFragment(MovieFragment.this, 0);
//                dialog.show(getFragmentManager(), "DateDialog");
//            }
//        });
//
//        Button buttonOk = (Button)view.findViewById(R.id.button_ok);
//        buttonOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        Button buttonCancel = (Button)view.findViewById(R.id.button_cancel);
//        buttonCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        Bundle args = getArguments();
//        UUID id = (UUID)args.getSerializable(ARG_ID);
//        if(id != null) {
//            Movie movie = MovieCollection.get(getContext()).getMovie(id);
//            mTitle.setText(movie.getTitle());
//            mDirector.setText(movie.getDirector());
//            mGenre.setSelection(getIndexOfGenre(movie.getGenre()));
//            mDate = movie.getReleaseDate();
//        }
//
//        updateDateButton();

        return view;
    }

    public void movieChanged(Movie movie) {
        if (mListener != null) {
            mListener.onMovieChanged(movie);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        onAttach((Context) activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnMovieChangedListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnMovieChangedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            mDate = (Date)data.getExtras().getSerializable(DateDialogFragment.EXTRA_DATE);
            updateDateButton();
        }
    }

    private int getIndexOfGenre(String genre) {
        int index = -1;
        for(int i=0; i<mGenres.length && index==-1; i++) {
            if(mGenres.equals(genre)) {
                index = i;
            }
        }
        return index;
    }

    private void updateDateButton() {
        if(mDate == null) {
            mDate = new Date();
        }
        String formatted = DateFormat.getDateFormat(getContext()).format(mDate);
        mDateButton.setText(formatted);
    }

    public interface OnMovieChangedListener {
        public void onMovieChanged(Movie movie);
    }

}
