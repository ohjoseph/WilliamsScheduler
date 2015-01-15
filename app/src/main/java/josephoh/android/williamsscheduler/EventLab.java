package josephoh.android.williamsscheduler;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A Singleton class to hold all of the Day's events and To-Do items
 */
public class EventLab {

    private static EventLab sEventLab;
    private Context mAppContext;

    private ArrayList<DayEvent> mDayEvents;

    // Creates the EventLab
    private EventLab( Context appContext ) {
        mAppContext = appContext;
        mDayEvents = new ArrayList<DayEvent>();

        for (int i = 0; i < 17; i++) {
            DayEvent d = new DayEvent();
            d.setTitle("Free");
            d.setHour(8 + i);
            mDayEvents.add(d);
        }
    }

    // Returns the EventLab
    public static EventLab get( Context c ) {
        if( sEventLab == null ) {
            sEventLab = new EventLab( c.getApplicationContext() );
        }
        return sEventLab;
    }

    // Returns the list of Day Events
    public ArrayList<DayEvent> getDayEvents() {
        return mDayEvents;
    }

    // Returns a specific DayEvent
    public DayEvent getDayEvent( UUID eventID ) {
        for( DayEvent d : mDayEvents ) {
            if( d.getID().equals( eventID ) ) {
                return d;
            }
        }
        return null;
    }

}
