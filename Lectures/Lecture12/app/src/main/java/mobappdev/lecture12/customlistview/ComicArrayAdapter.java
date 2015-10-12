package mobappdev.lecture12.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import mobappdev.lecture12.R;
import mobappdev.lecture12.model.Comic;

/**
 * Created by USX13992 on 10/12/2015.
 */
public class ComicArrayAdapter<T extends Comic> extends ArrayAdapter<T> {

    public ComicArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View layout;
        if(convertView == null ) {
            layout = inflater.inflate(R.layout.view_comic, parent, false);
        }
        else {
            layout = convertView;
        }

        T comic = getItem(position);
        TextView series = (TextView)layout.findViewById(R.id.text_view_series);
        series.setText(comic.getSeries());
        TextView volume = (TextView)layout.findViewById(R.id.text_view_volume);
        volume.setText(Integer.toString(comic.getVolume()));
        TextView number = (TextView)layout.findViewById(R.id.text_view_number);
        number.setText(Integer.toString(comic.getNumber()));
        CheckBox owned = (CheckBox)layout.findViewById(R.id.check_box_owned);
        owned.setChecked(comic.isOwned());

        return layout;
    }
}
