package josephoh.android.williamsscheduler;

import java.util.UUID;

/**
 * Created by Joseph on 1/21/15.
 */
public class ToDoActivity extends SingleFragmentActivity {

    @Override
    protected ToDoFragment createFragment() {
        // Gets the id of the specific ToDoItem to be created
        UUID id = (UUID) getIntent().getSerializableExtra( ToDoFragment.EXTRA_TODO_ID );

        // Creates the specific ToDoItem
        return ToDoFragment.newInstance( id );
    }
}
