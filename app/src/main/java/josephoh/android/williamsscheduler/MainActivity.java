package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Joseph on 1/13/15.
 */
public class MainActivity extends ActionBarActivity {

    FragmentPagerAdapter adapterViewPager;

    // Allows ScheduleFragmentActivity to use SingleFragmentActivity
    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // Inflates the fragmentAdapter layout
        setContentView( R.layout.viewpager_fragment );

        // Sets the view pager and fragment page adapter
        ViewPager vpPager = (ViewPager) findViewById( R.id.vpPager );
        adapterViewPager =  new listPagerFragmentAdapter( getSupportFragmentManager() );
        vpPager.setAdapter( adapterViewPager );
    }

    public static class listPagerFragmentAdapter extends FragmentPagerAdapter {

        private static int numberOfItems = 2;

        public listPagerFragmentAdapter( FragmentManager fm ) {
            super( fm );
        }

        // Returns the total number of pages
        @Override
        public int getCount() {
            return numberOfItems;
        }

        // Returns the fragment to be displayed
        @Override
        public Fragment getItem( int position ) {
            switch( position ) {
                case 0: // Shows the schedule fragment
                    return new ScheduleListFragment();
                case 1: // Shows the to do list fragment
                    return new ToDoListFragment();
                // case 2: // Shows the projects fragment
                   // return null;
                default:
                    return null;
            }
        }

        // Returns the page title for the indicator tab
        @Override
        public CharSequence getPageTitle( int position ) {
            // Fragment fragment = getItem( position );
            return "Page " + position;
        }
    }
}
