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
    private ArrayList<ToDoItem> mToDoItems;

    // Creates the EventLab
    private EventLab( Context appContext ) {
        mAppContext = appContext;
        mDayEvents = new ArrayList<DayEvent>();

        for( int i = 0; i < 17; i++ ) {
            DayEvent d = new DayEvent();
            d.setTitle( "Free" );
            d.setHour(8 + i);
            mDayEvents.add( d );
        }

        mToDoItems = new ArrayList<ToDoItem>();

        for( int i = 0; i < 10; i++ ) {
            ToDoItem t = new ToDoItem();
            t.setTitle( "To-Do #" + i );
            mToDoItems.add( t );
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

    // Returns the list of the To-Do items
    public ArrayList<ToDoItem> getToDoItems() {
        return mToDoItems;
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

    // Returns a specific  ToDoItem
    public ToDoItem getToDoItem( UUID id ) {
        for( ToDoItem t : mToDoItems ) {
            if( t.getID().equals( id ) ) {
                return t;
            }
        }
        return null;
    }
}
