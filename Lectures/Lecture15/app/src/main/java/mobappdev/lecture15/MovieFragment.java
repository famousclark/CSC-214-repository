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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;
import java.util.UUID;

import mobappdev.lecture15.model.Movie;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    public static interface OnMovieChangedListener {
        public void onMovieChanged(int resultCode, Movie movie);
    }

    private static final String KEY_ID = "ID";

    private EditText mTitle;
    private EditText mDirector;
    private Spinner mGenre;
    private Button mReleaseDate;
    private Date mDate;
    private Movie mMovie;
    private OnMovieChangedListener mCallback;


    public MovieFragment() {
        // Required empty public constructor
    }


    public static MovieFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(KEY_ID, id);
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (OnMovieChangedListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        mTitle = (EditText)view.findViewById(R.id.edit_text_title);
        mDirector = (EditText)view.findViewById(R.id.edit_text_director);
        mGenre = (Spinner)view.findViewById(R.id.spinner_genres);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.genres_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGenre.setAdapter(adapter);

        mReleaseDate = (Button)view.findViewById(R.id.button_release_date);

        Bundle args = getArguments();
        UUID id = (UUID)args.getSerializable(KEY_ID);
        if(id != null) {

        }
        else {
            mMovie = new Movie();
        }

        updateReleaseDateButtonLabel();

        mReleaseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialogFragment dialog = DateDialogFragment.newInstance(mDate);
                dialog.setTargetFragment(MovieFragment.this, 0);
                dialog.show(getFragmentManager(), "DateDialog");
            }
        });

        Button buttonOk = (Button)view.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK);
            }
        });

        Button buttonCancel = (Button)view.findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendResult(Activity.RESULT_CANCELED);
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            mDate = (Date)data.getSerializableExtra(DateDialogFragment.EXTRA_DATE);
            updateReleaseDateButtonLabel();
        }
    }

    private void sendResult(int resultCode) {
        if(mCallback != null ) {
            mMovie.setTitle(mTitle.getText().toString());
            mMovie.setDirector(mDirector.getText().toString());
            mMovie.setGenre(mGenre.getSelectedItem().toString());
            mMovie.setReleaseDate(mDate);
            mCallback.onMovieChanged(resultCode, mMovie);
        }
    }

    private void updateReleaseDateButtonLabel() {
        if(mDate == null) {
            mDate = new Date();
        }
        String formatted = DateFormat.getMediumDateFormat(getContext()).format(mDate);
        mReleaseDate.setText(formatted);
    }


}
