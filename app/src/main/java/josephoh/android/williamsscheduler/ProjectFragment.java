package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Joseph on 1/21/15.
 */
public class ProjectFragment extends Fragment {

    // String to identify the arguments bundle's UUID
    public static final String EXTRA_PROJECT_ID = "com.josephoh.williamsScheduler.project_id";

    private ProjectItem mProjectItem;

    public ProjectFragment() {
        // Empty constructor
    }

    public static ProjectFragment newInstance( UUID id ) {
        // Creates a new arguments bundle to hold the project item id
        Bundle args = new Bundle();
        args.putSerializable( EXTRA_PROJECT_ID, id );

        ProjectFragment fragment = new ProjectFragment();

        // Sets the Arguments of the new ProjectFragment
        fragment.setArguments( args );

        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // Gets the project item
        UUID projectID = (UUID) getArguments().getSerializable( EXTRA_PROJECT_ID );

        // Retrieves the specified project item
        mProjectItem = TodayLab.get( getActivity() ).getProjectItem( projectID );

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState ) {

        // Inflates the project view
        View v = inflater.inflate( R.layout.fragment_project, parent, false );

        // Initializes the textviews
        EditText projectTitle = (EditText) v.findViewById( R.id.project_title );
        projectTitle.setSelectAllOnFocus( true );
        projectTitle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        });
        projectTitle.setText( mProjectItem.getTitle() );
        projectTitle.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Renames the project title
                mProjectItem.setTitle( s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Empty
            }
        });

        EditText projectPurpose = (EditText) v.findViewById( R.id.project_purpose );
        projectPurpose.setText( mProjectItem.getPurpose() );
        projectPurpose.setSelectAllOnFocus( true );
        projectPurpose.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        });
        projectPurpose.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Renames the project purpose
                mProjectItem.setPurpose( s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Empty
            }
        });

        EditText projectOutcome = (EditText) v.findViewById( R.id.project_outcome );
        projectOutcome.setSelectAllOnFocus( true );
        projectOutcome.setText( mProjectItem.getOutcome() );
        projectOutcome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        });
        projectOutcome.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Renames the project outcome
                mProjectItem.setOutcome( s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Empty
            }
        });

        EditText projectNextStep = (EditText) v.findViewById( R.id.project_next_action );
        projectNextStep.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        });
        projectNextStep.setText( mProjectItem.getNextStep() );
        projectNextStep.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Renames the project next action
                mProjectItem.setNextStep( s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Empty
            }
        });

        return v;
    }

    @Override
    public void onPause() {
        // Saves the list of projects
        super.onPause();
        TodayLab.get( getActivity() ).saveProjectItems();
    }
}
