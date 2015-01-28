package josephoh.android.williamsscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joseph on 1/23/15.
 */
public class ProjectListFragment extends ListFragment {

    private final static String TAG = "ProjectListFragment";

    private ArrayList<ProjectItem> mProjectItems;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        // Sets the Activity's Action Bar Title
        getActivity().setTitle(R.string.schedule_title);

        // Returns the ArrayList for the Day's Events and To Do Items
        mProjectItems = TodayLab.get(getActivity()).getProjects();

        // Creates an ArrayAdapter that manages Project objects
        ProjectItemAdapter adapter =
                new ProjectItemAdapter( mProjectItems );

        // Sets the adapter for the ListView
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Gets the clicked DayEvent
        ProjectItem pI = ( (ProjectItemAdapter)getListAdapter() ).getItem(position);

        // Starts a new Day Event
        Intent i = new Intent( getActivity(), ProjectActivity.class );
        i.putExtra( ProjectFragment.EXTRA_PROJECT_ID, pI.getID() );
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Updates the ListView with the new information
        ( (ProjectItemAdapter)getListAdapter() ).notifyDataSetChanged();
    }

    private class ProjectItemAdapter extends ArrayAdapter<ProjectItem> {

        public ProjectItemAdapter(ArrayList<ProjectItem> events) {
            super(getActivity(), 0, events);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If there is no view, then inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_project, null);
            }

            // Configure the view for the DayEvent
            ProjectItem pI = getItem(position);

            TextView projectTitle = (TextView) convertView.findViewById( R.id.project_list_item_title );
            projectTitle.setText( pI.getTitle() );

            TextView nextStep = (TextView) convertView.findViewById( R.id.project_list_item_next_step );
            nextStep.setText( pI.getNextStep() );

            return convertView;
        }
    }
}
