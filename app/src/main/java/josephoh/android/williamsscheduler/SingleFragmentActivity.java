package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Joseph on 1/13/15.
 */
public abstract class SingleFragmentActivity extends ActionBarActivity {

    protected abstract Fragment createFragment();

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // Inflates the activity's view
        setContentView( R.layout.activity_fragment );

        // Calls the fragment manager
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById( R.id.fragmentContainer );

        // Creates a new fragment if it doesn't exist
        if( fragment == null ) {
            fragment = createFragment();
            // Adds the new fragment to the Activity's view
            fm.beginTransaction()
                    .add( R.id.fragmentContainer, fragment )
                    .commit();
        }
    }
}
