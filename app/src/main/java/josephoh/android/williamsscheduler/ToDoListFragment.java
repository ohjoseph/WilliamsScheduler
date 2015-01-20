package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Joseph on 1/19/15.
 */
public class ToDoListFragment extends ListFragment {

    private final static String TAG = "ToDoListFragment";

    private ArrayList<ToDoItem> mToDoItems;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        // Calls to the superclass
        super.onCreate( savedInstanceState );

        // Retrieves existing ToDoItems list
        mToDoItems = OtherLab.get( getActivity() ).getToDoItems();

        // Creates an adapter to manage ToDoItems
    }

    private class ToDoAdapter extends ArrayAdapter<ToDoItem> {

        public ToDoAdapter( ArrayList<ToDoItem> todoitems ) {
            super( getActivity(), 0, todoitems );
        }

        @Override
        public View getView( int position, View convertView, ViewGroup parent ) {
            // Inflate new list item view if it doesn't exist
            if( convertView == null ) {
                convertView = getActivity().getLayoutInflater()
                        .inflate( R.layout.list_item_to_do_item );
            }
        }
    }
}
