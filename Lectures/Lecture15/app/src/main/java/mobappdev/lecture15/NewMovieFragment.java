package mobappdev.lecture15;


import android.app.Activity;
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
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewMovieFragment extends Fragment {
    private static final String KEY_ID = "ID";

    private EditText mTitle;
    private EditText mDirector;
    private Spinner mGenre;
    private Button mReleaseDate;
    private Date mDate;


    public NewMovieFragment() {
        // Required empty public constructor
    }


    public static NewMovieFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(KEY_ID, id);
        NewMovieFragment fragment = new NewMovieFragment();
        fragment.setArguments(args);
        return fragment;
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

        updateReleaseDateButtonLabel();

        mReleaseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialogFragment dialog = DateDialogFragment.newInstance(mDate);
                dialog.setTargetFragment(NewMovieFragment.this, 0);
                dialog.show(getFragmentManager(), "DateDialog");
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

    private void updateReleaseDateButtonLabel() {
        if(mDate == null) {
            mDate = new Date();
        }
        String formatted = DateFormat.getMediumDateFormat(getContext()).format(mDate);
        mReleaseDate.setText(formatted);
    }


}
