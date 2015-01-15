package josephoh.android.williamsscheduler;

import android.support.v4.app.Fragment;

import java.util.UUID;


public class MainActivity extends SingleFragmentActivity {

    @Override
    // Allows MainActivity to call createFragment()
    protected Fragment createFragment() {

        UUID dayEventID = (UUID)getIntent()
                .getSerializableExtra( ScheduleFragment.EXTRA_DAYEVENT_ID );

        return ScheduleFragment.newInstance( dayEventID );
    }
}
