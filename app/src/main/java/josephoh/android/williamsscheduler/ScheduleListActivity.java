package josephoh.android.williamsscheduler;

import android.support.v4.app.Fragment;

/**
 * Created by Joseph on 1/13/15.
 */
public class ScheduleListActivity extends SingleFragmentActivity {

    // Allows ScheduleFragmentActivity to use SingleFragmentActivity
    @Override
    protected Fragment createFragment() {
        return new ScheduleListFragment();
    }
}
