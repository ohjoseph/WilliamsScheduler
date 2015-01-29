package josephoh.android.williamsscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class ScheduleFragment extends Fragment {

    private static final String DIALOG_TIME = "time";
    public static final String EXTRA_DAYEVENT_ID = "com.josephoh.williamsScheduler.DayEvent_id";

    private DayEvent mDayEvent;
    private EditText mTitle;
    private TextView mHourTextView;
    private Button mMinuteButton;
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
        // Sets the Title
        mTitle.setText( mDayEvent.getTitle() );
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

        // Makes the keyboard automatically appear
        mTitle.setOnFocusChangeListener( new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE );
            }
        });
        
        // Creates the TimePicker Button
        mHourTextView = (TextView) v.findViewById( R.id.event_hour_textview );
        mHourTextView.setText( mDayEvent.getHour() + " :" );

        TextView amTextView = (TextView) v.findViewById( R.id.event_am_textview );
        amTextView.setText( mDayEvent.getAM() );

        // Creates the minutes spinner
        Spinner spinner = (Spinner) v.findViewById(R.id.event_minute_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.minute_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        String curMin = "" + mDayEvent.getMinute();
        // Sets the value of the spinner
        for( int i = 0; i < adapter.getCount(); i++) {
            if (curMin.equals((adapter.getItem(i).toString()))) {
                spinner.setSelection(i);
            }
        }

        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mDayEvent.setMinute(
                         parent.getItemAtPosition( position ).toString() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Creates the duration hour spinner
        Spinner hourSpinner = (Spinner) v.findViewById(R.id.event_duration_hour);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> hourAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.hour_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        hourSpinner.setAdapter(hourAdapter);
        // Sets the spinner to current hour
        String curHour = "" + mDayEvent.getDurHour();
        for( int i = 0; i < hourAdapter.getCount(); i++) {
            if (curHour.equals((hourAdapter.getItem(i).toString()))) {
                hourSpinner.setSelection(i);
            }
        }

        hourSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mDayEvent.setDurHour(
                        Integer.parseInt( parent.getItemAtPosition( position ).toString() ));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Creates the duration hour spinner
        Spinner minuteSpinner = (Spinner) v.findViewById(R.id.event_duration_minute);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> minAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.minute_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        minAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        minuteSpinner.setAdapter(minAdapter);
        // Sets the spinner to current hour
        String curDurMin = "" + mDayEvent.getDurMinute();
        for( int i = 0; i < minAdapter.getCount(); i++) {
            if (curDurMin.equals((minAdapter.getItem(i).toString()))) {
                minuteSpinner.setSelection(i);
            }
        }

        minuteSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mDayEvent.setDurMinute(
                        Integer.parseInt( parent.getItemAtPosition( position ).toString() ));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onPause() {
        // Saves the list of day events
        super.onPause();
        TodayLab.get( getActivity() ).saveDayEvents();
    }

}
