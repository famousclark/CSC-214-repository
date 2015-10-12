package mobappdev.lecture12.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import mobappdev.lecture12.R;
import mobappdev.lecture12.model.Comic;

/**
 * Created by USX13992 on 10/12/2015.
 */
public class ComicViewHolder extends RecyclerView.ViewHolder {

    private TextView mSeriesView;
    private TextView mVolumeView;
    private TextView mNumberView;
    private CheckBox mOwnedView;

    public ComicViewHolder(View view) {
        super(view);
        mSeriesView = (TextView)view.findViewById(R.id.text_view_series);
        mVolumeView = (TextView)view.findViewById(R.id.text_view_volume);
        mNumberView = (TextView)view.findViewById(R.id.text_view_number);
        mOwnedView = (CheckBox)view.findViewById(R.id.check_box_owned);
    }

    public void bindComic(Comic comic) {
        mSeriesView.setText(comic.getSeries());
        mVolumeView.setText(Integer.toString(comic.getVolume()));
        mNumberView.setText(Integer.toString(comic.getNumber()));
        mOwnedView.setChecked(comic.isOwned());
    }
}
