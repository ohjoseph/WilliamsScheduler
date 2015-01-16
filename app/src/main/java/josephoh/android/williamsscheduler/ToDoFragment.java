package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class ToDoFragment extends Fragment {

    // TAG to identify the id of the extra argument
    private static final String EXTRA_TODO_ID = "com.josephoh.williamsScheduler.todo_ID";

    private ToDoItem mToDoItem;
    private EditText mTitleText;

    public ToDoFragment() {
        // Empty constructor
    }

    public static ToDoFragment newInstance( UUID id ) {
        // Creates a new fragment and sets its arguments
        Bundle args = new Bundle();
        args.putSerializable( EXTRA_TODO_ID, id );

        ToDoFragment fragment = new ToDoFragment();
        fragment.setArguments( args );

        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // Gets the specific ToDoItem from the Lab
        UUID thisID = (UUID) getArguments().getSerializable( EXTRA_TODO_ID );
        mToDoItem = ToDoLab.get( getActivity() ).getToDoItem( thisID );
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup parent,
                              Bundle savedInstanceState ) {

        // Inflates the view
        View v = inflater.inflate( R.layout.fragment_to_do_item, parent, false );

        // Initializes the TitleText
        mTitleText = (EditText) v.findViewById( R.id.todo_title_textView );
        mTitleText.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Empty method
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Changes the title
                mToDoItem.setTitle( s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Empty method
            }
        });

        return v;
    }
}
