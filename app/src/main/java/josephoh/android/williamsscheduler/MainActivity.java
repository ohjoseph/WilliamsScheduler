package josephoh.android.williamsscheduler;

import android.support.v4.app.Fragment;


public class MainActivity extends SingleFragmentActivity {

    @Override
    // Allows MainActivity to call createFragment()
    protected Fragment createFragment() {
        return new ScheduleFragment();
    }
}
