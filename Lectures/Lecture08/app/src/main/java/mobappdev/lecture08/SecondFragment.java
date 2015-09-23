package mobappdev.lecture08;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View content = inflater.inflate(R.layout.fragment_second, container, false);

        TextView color = (TextView)content.findViewById(R.id.text_view_color);

        int alpha = 128; // about 50% transparent
        int red = 255; // fully red
        int green = 255; // fully green
        int blue = 0; // no blue

        //shift the alpha 3 bytes to the left, the red 2 bytes, the green 1 byte
        int paleYellow = (alpha << 24 ) + (red << 16) + (green << 8) + blue;
        color.setBackgroundColor(paleYellow);

        return content;
    }


}
