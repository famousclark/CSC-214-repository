package mobappdev.lecture13;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.UUID;

import mobappdev.lecture13.model.Collection;
import mobappdev.lecture13.model.Comic;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComicFragment extends Fragment {

    private static final String ARG_ID = "COMIC_ID";
    private static final String DIALOG_OWNED = "DialogOwned";
    private static final int REQUEST_OWNED = 2;
    private CheckBox mOwned;

    public ComicFragment() {
        // Required empty public constructor
    }

    public static ComicFragment newInstance(UUID id) {
        ComicFragment fragment = new ComicFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comic, container, false);

        Bundle args = getArguments();
        UUID id = (UUID)args.getSerializable(ARG_ID);
        final Comic comic = Collection.get(getActivity()).getComic(id);

        setText(view, comic.getSeries(), R.id.text_view_series);
        setText(view, "Vol. " + comic.getVolume() + ", #" + comic.getNumber(),
                R.id.text_view_volume_and_number);
        setText(view, comic.getNote(), R.id.text_view_note);
        mOwned = (CheckBox)view.findViewById(R.id.check_box_owned);
        mOwned.setChecked(comic.isOwned());
        mOwned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                OwnedDialog dialog = OwnedDialog.newInstance(comic);
                dialog.setTargetFragment(ComicFragment.this, REQUEST_OWNED);
                dialog.show(manager, DIALOG_OWNED);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_OWNED) {
            mOwned.setChecked(resultCode == Activity.RESULT_OK);
        }
    }

    private void setText(View layout, CharSequence text, int id) {
        TextView view = (TextView)layout.findViewById(id);
        view.setText(text);
    }


}
