package josephoh.android.williamsscheduler;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joseph on 1/10/15.
 */
public class ScheduleListFragment extends android.support.v4.app.ListFragment {

    private final static String TAG = "ScheduleListFragment";

    private ArrayList<DayEvent> mDayEvents;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        // Sets the Activity's Action Bar Title
        getActivity().setTitle(R.string.schedule_title);

        // Sets the menu
        setHasOptionsMenu( true );

        // Returns the ArrayList for the Day's Events and To Do Items
        mDayEvents = TodayLab.get(getActivity()).getDayEvents();

        // Creates an ArrayAdapter that manages DayEvent objects
        DayEventAdapter adapter =
                new DayEventAdapter( mDayEvents );

        // Sets the adapter for the ListView
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Gets the clicked DayEvent
        DayEvent dayEvent = ( (DayEventAdapter)getListAdapter() ).getItem(position);

        // Starts a new Day Event
        Intent i = new Intent( getActivity(), DayEventActivity.class );
        i.putExtra( ScheduleFragment.EXTRA_DAYEVENT_ID, dayEvent.getID() );
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Updates the ListView with the new information
        ( (DayEventAdapter)getListAdapter() ).notifyDataSetChanged();
    }

    private class DayEventAdapter extends ArrayAdapter<DayEvent> {

        public DayEventAdapter(ArrayList<DayEvent> events) {
            super(getActivity(), 0, events);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If there is no view, then inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_day_event, null);
            }

            // Configure the view for the DayEvent
            DayEvent dE = getItem(position);

            // Sets the time
            TextView timeTextView = (TextView) convertView.findViewById(R.id.time_id);
            timeTextView.setText( dE.getHour() + ":" + dE.getMinute() + " " + dE.getAM() );


            // Sets the title
            TextView titleTextView = (TextView) convertView.findViewById(R.id.title_id);
            titleTextView.setText( dE.getTitle() );

            if( ! titleTextView.getText().equals( "Free" ) ) {
                titleTextView.setBackgroundColor( Color.rgb( 153, 255, 204 ) );
            }

            return convertView;
        }
    }

}