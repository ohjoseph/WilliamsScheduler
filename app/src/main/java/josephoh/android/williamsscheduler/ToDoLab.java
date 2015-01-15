package josephoh.android.williamsscheduler;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Joseph on 1/15/15.
 */
public class ToDoLab {

    private static ToDoLab sToDoLab;
    private Context mAppContext;

    private ArrayList<ToDoItem> mToDoItems;

    // Creates the ToDoLab
    private ToDoLab( Context appContext ) {
        mAppContext = appContext;

        mToDoItems = new ArrayList<ToDoItem>();
    }

    // Returns the EventLab
    public static ToDoLab get( Context c ) {
        if( sToDoLab == null ) {
            sToDoLab = new ToDoLab( c.getApplicationContext() );
        }
        return sToDoLab;
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
