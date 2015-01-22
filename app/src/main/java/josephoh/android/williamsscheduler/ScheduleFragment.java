package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class ScheduleFragment extends Fragment {

    private static final String DIALOG_TIME = "time";
    public static final String EXTRA_DAYEVENT_ID = "com.josephoh.williamsScheduler.DayEvent_id";

    private DayEvent mDayEvent;
    private EditText mTitle;
    private Button mTimePickerButton;
    private NumberPicker mNumberPicker;
    private EditText mDescription;

    public ScheduleFragment() {
        // Required public empty constructor
    }

    public static ScheduleFragment newInstance( UUID uuid ) {
        Bundle args = new Bundle();
        args.putSerializable( EXTRA_DAYEVENT_ID, uuid );

        ScheduleFragment fragment = new ScheduleFragment();
        fragment.setArguments( args );

        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        UUID eventID = (UUID) getArguments().getSerializable( EXTRA_DAYEVENT_ID );

        mDayEvent = TodayLab.get(getActivity()).getDayEvent( eventID );
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState ) {

        // Inflates the layout of the ScheduleFragment
        View v = inflater.inflate( R.layout.fragment_day_event, parent, false );
        // The title of the event and adds a Text Listener
        mTitle = (EditText) v.findViewById( R.id.event_title );
        mTitle.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDayEvent.setTitle( s.toString() );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Creates the TimePicker Button
        mTimePickerButton = (Button) v.findViewById( R.id.event_time_button );
        mTimePickerButton.setText( Calendar.getInstance().getTime().toString() );

        mTimePickerButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
                TimePickerFragment dialog = new TimePickerFragment();
                dialog.show( fm, DIALOG_TIME );
            }
        });

        return v;
    }
}
