package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SebastiánFelipe on 01/05/2015.
 */
public class PagerAdapter extends FragmentPagerAdapter
{
    private List<Fragment> data;
    public PagerAdapter(FragmentManager fm,List<Fragment> d)
    {
        super(fm);
        data=d;

    }

    @Override
    public Fragment getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public int getCount()
    {
        return data.size();
    }
}
