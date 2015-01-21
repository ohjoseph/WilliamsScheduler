package josephoh.android.williamsscheduler;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Joseph on 1/15/15.
 */
public class OtherLab {

    private static OtherLab sOtherLab;
    private Context mAppContext;

    private ArrayList<ToDoItem> mToDoItems;

    // Creates the ToDoLab
    private OtherLab(Context appContext) {
        mAppContext = appContext;

        mToDoItems = new ArrayList<ToDoItem>();

        // Adds items to the to do list
        for( int i = 0; i < 6; i++ ) {
            ToDoItem tdItem = new ToDoItem();
            tdItem.setTitle( "Item # " + i );
            mToDoItems.add( tdItem );
        }
    }

    // Returns the EventLab
    public static OtherLab get( Context c ) {
        if( sOtherLab == null ) {
            sOtherLab = new OtherLab( c.getApplicationContext() );
        }
        return sOtherLab;
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
}
