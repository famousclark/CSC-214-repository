package mobappdev.lecture14.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobappdev.lecture14.R;
import mobappdev.lecture14.model.Album;

/**
 * Created by Bobby on 10/18/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumHolder>{
    private List<Album> mAlbums;

    public AlbumAdapter(List<Album> albums) {
        mAlbums = albums;
    }

    @Override
    public AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_album, parent, false);

        AlbumHolder holder = new AlbumHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AlbumHolder holder, int position) {
        holder.bind(mAlbums.get(position));
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }
}
