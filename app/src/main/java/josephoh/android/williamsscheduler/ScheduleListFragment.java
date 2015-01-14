package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Joseph on 1/10/15.
 */
public class ScheduleListFragment extends android.support.v4.app.ListFragment {

    private ArrayList<DayEvent> mDayEvents;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // Sets the Activity's Action Bar Title
        getActivity().setTitle(R.string.schedule_title);

        // Returns the ArrayList for the Day's Events and To Do Items
        mDayEvents = EventLab.get( getActivity() ).getDayEvents();

        // Creates an ArrayAdapter that manages DayEvent objects
        ArrayAdapter<DayEvent> adapter =
                new ArrayAdapter<DayEvent>( getActivity(),
                        android.R.layout.simple_list_item_1,
                        mDayEvents );

        // Sets the adapter for the ListView
        setListAdapter( adapter );
    }


}
