package mobappdev.lecture13;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import mobappdev.lecture13.model.Comic;

/**
 * Created by USX13992 on 10/12/2015.
 */
public class ComicPagerAdapter extends FragmentStatePagerAdapter {
    private List<Comic> mComics;

    public ComicPagerAdapter(FragmentManager manager, List<Comic> comics) {
        super(manager);
        mComics = comics;
    }

    @Override
    public Fragment getItem(int position) {
        Comic comic = mComics.get(position);
        return ComicFragment.newInstance(comic.getId());
    }

    @Override
    public int getCount() {
        return mComics.size();
    }
}
