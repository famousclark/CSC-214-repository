package mobappdev.lecture13;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.List;

import mobappdev.lecture13.model.Collection;
import mobappdev.lecture13.model.Comic;

public class ComicPagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private List<Comic> mComics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mComics = Collection.get(this).getCollection();

        mViewPager = (ViewPager)findViewById(R.id.view_pager_comics);

        mViewPager.setAdapter(new ComicPagerAdapter(getSupportFragmentManager(), mComics));
    }
}
