package mobappdev.lecture13;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import mobappdev.lecture13.model.Comic;

public class OwnedDialog extends DialogFragment {

    private static final String ARG_SERIES = "ARG_SERIES";
    private static final String ARG_VOLUME = "ARG_VOLUME";
    private static final String ARG_NUMBER = "ARG_NUMBER";

    public OwnedDialog() {
        // Required empty public constructor
    }


    public static OwnedDialog newInstance(Comic comic) {
        OwnedDialog dialog = new OwnedDialog();
        Bundle args = new Bundle();
        args.putString(ARG_SERIES, comic.getSeries());
        args.putInt(ARG_VOLUME, comic.getVolume());
        args.putInt(ARG_NUMBER, comic.getNumber());
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_owned, null);

        Bundle args = getArguments();
        String series = args.getString(ARG_SERIES);
        TextView seriesView = (TextView)view.findViewById(R.id.text_view_series);
        seriesView.setText(series);
        int volume = args.getInt(ARG_VOLUME);
        int number = args.getInt(ARG_NUMBER);
        TextView volumeView = (TextView)view.findViewById(R.id.text_view_volume_and_number);
        volumeView.setText("Vol. " + volume + ", #" + number);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.title_comic_owned)
                .setNegativeButton(getString(R.string.label_nope),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(Activity.RESULT_CANCELED);
                            }
                        })
                .setPositiveButton(getString(R.string.label_owned),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(Activity.RESULT_OK);
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode) {
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, null);
    }
}
