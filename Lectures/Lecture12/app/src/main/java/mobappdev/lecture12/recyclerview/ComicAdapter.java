package mobappdev.lecture12.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobappdev.lecture12.R;
import mobappdev.lecture12.model.Comic;

/**
 * Created by USX13992 on 10/12/2015.
 */
public class ComicAdapter extends RecyclerView.Adapter<ComicViewHolder> {
    private List<Comic> mComics;

    public ComicAdapter(List<Comic> comics) {
        mComics = comics;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_comic, parent, false);
        ComicViewHolder holder = new ComicViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        holder.bindComic(mComics.get(position));
    }

    @Override
    public int getItemCount() {
        return mComics.size();
    }
}
