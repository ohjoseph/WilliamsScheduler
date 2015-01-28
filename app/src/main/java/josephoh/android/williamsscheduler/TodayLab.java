package josephoh.android.williamsscheduler;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A Singleton class to hold all of the Day's events and To-Do items
 */
public class TodayLab {

    private static TodayLab sTodayLab;
    private Context mAppContext;

    private ArrayList<DayEvent> mDayEvents;
    private ArrayList<ToDoItem> mToDoItems;
    private ArrayList<ProjectItem> mProjectItems;

    // Creates the EventLab
    private TodayLab(Context appContext) {
        // The Instance variables
        mAppContext = appContext;
        mDayEvents = new ArrayList<DayEvent>();
        mToDoItems = new ArrayList<ToDoItem>();
        mProjectItems = new ArrayList<ProjectItem>();

        // Default events
        for (int i = 0; i < 17; i++) {
            DayEvent d = new DayEvent();
            d.setTitle("Free");
            int hour = 8 + i;

            if ( hour < 12 ) {
                d.setAM( "AM" );
                d.setHour( hour + "" );
            } else if ( hour == 24 ) {
                d.setAM( "AM" );
                d.setHour( 12 + "" );
            } else if ( hour == 12 ) {
                d.setAM( "PM" );
                d.setHour( 12 + "" );
            } else if ( hour > 12) {
                d.setAM( "PM" );
                d.setHour( hour % 12 + "" );
            }

            mDayEvents.add(d);
        }

        // Default To-Do items
        for (int i = 0; i < 6; i++) {
            ToDoItem tdItem = new ToDoItem();
            tdItem.setTitle("Item # " + i);
            mToDoItems.add(tdItem);
        }

        // Default projects
        for( int i = 0; i < 6; i++ ) {
            ProjectItem pI = new ProjectItem();
            pI.setTitle( "Project # " + i );
            pI.setNextStep( "Start this project" );
            mProjectItems.add( pI );
        }
    }

    // Returns the EventLab
    public static TodayLab get( Context c ) {
        if( sTodayLab == null ) {
            sTodayLab = new TodayLab( c.getApplicationContext() );
        }
        return sTodayLab;
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

    // Returns the list of the To-Do items
    public ArrayList<ToDoItem> getToDoItems() {
        return mToDoItems;
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

    // Returns the list of Project Items
    public ArrayList<ProjectItem> getProjects() {

        return mProjectItems;
    }

    // Returns a specific project item
    public ProjectItem getProjectItem( UUID id ) {

        // Checks all UUIDs against the given one
        for( ProjectItem pI : mProjectItems ) {
            if( pI.getID().equals( id ) )
                return pI;
        }
        return null;
    }

}
