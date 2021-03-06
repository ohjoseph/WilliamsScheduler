package josephoh.android.williamsscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
        mToDoItems = TodayLab.get( getActivity() ).getToDoItems();

        // Sets the menu
        setHasOptionsMenu( true );

        // Creates an adapter to manage ToDoItems
        ToDoAdapter todoAdapter = new ToDoAdapter( mToDoItems );
        setListAdapter( todoAdapter );
    }

    @Override
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate( R.menu.fragment_todo_list, menu );
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        // When an item in the options menu has been selected
        switch( item.getItemId() ) {
            // If addToDoItem
            case R.id.menu_item_new_todo_item:
                // Create and add to the TodayLab
                ToDoItem td = new ToDoItem();
                TodayLab.get( getActivity() ).addToDoItem( td );

                // Starts a new To Do Fragment
                Intent i = new Intent( getActivity(), ToDoActivity.class );
                i.putExtra( ToDoFragment.EXTRA_TODO_ID, td.getID() );
                startActivityForResult( i, 0 );
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    @Override
    public void onListItemClick( ListView l, View v, int position, long id ) {
        // Gets the clicked To-Do item
        ToDoItem td = ( (ToDoAdapter)getListAdapter() ).getItem( position );

        // Starts the To-Do item activity
        Intent i = new Intent( getActivity(), ToDoActivity.class );
        i.putExtra( ToDoFragment.EXTRA_TODO_ID, td.getID() );
        startActivity( i );

    }

    @Override
    public void onResume() {
        super.onResume();

        // Updates the adapter
        ( (ToDoAdapter)getListAdapter() ).notifyDataSetChanged();
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
                        .inflate( R.layout.list_item_to_do_item, null );
            }

            // Configures the view for the ToDoItem
            ToDoItem tdItem = getItem( position );

            // Initializes the priority button
            Button priorityButton =
                    (Button) convertView.findViewById( R.id.todo_list_item_priority_button );
            // Sets its priority
            priorityButton.setBackgroundColor( tdItem.getPriority() );

            // Initializes the title
            TextView titleText =
                    (TextView) convertView.findViewById( R.id.todo_list_item_title );
            // Sets the title
            titleText.setText( tdItem.getTitle() );

            // Initializes the context
            TextView contextText =
                    (TextView) convertView.findViewById( R.id.todo_list_item_context );
            // Sets the context
            contextText.setText( tdItem.getContext() );

            // Initializes the time
            TextView timeText =
                    (TextView) convertView.findViewById( R.id.todo_list_item_time );
            timeText.setText(tdItem.getTime());

            return convertView;
        }
    }
}
