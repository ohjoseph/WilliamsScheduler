package josephoh.android.williamsscheduler;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Joseph on 1/28/15.
 */
public class TodayLabJSONSerializer {

    private Context mContext;
    private String mFileName1;
    private String mFileName2;
    private String mFileName3;

    public TodayLabJSONSerializer( Context c, String f, String g, String h) {
        mContext = c;
        mFileName1 = f;
        mFileName2 = g;
        mFileName3 = h;
    }

    public void saveDayEvents( ArrayList<DayEvent> dayEvents ) throws JSONException, IOException {

        // Builds a DayEvents array in JSON
        JSONArray array = new JSONArray();
        for (DayEvent dE : dayEvents) {
            array.put(dE.toJSON());
        }

        // Writes the files to the disk
        Writer writer = null;
        try {
            // Saves dayEvents
            OutputStream out = mContext
                  .openFileOutput(mFileName1, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter( out );
            writer.write( array.toString() );

        } finally {
            // Closes all the writers
            if( writer != null )
                writer.close();
        }
    }

    public void saveToDoItems( ArrayList<ToDoItem> todoItems ) throws JSONException, IOException {

        // Builds a To-Do item array in JSON
        JSONArray tdArray = new JSONArray();
        for (ToDoItem td : todoItems)
            tdArray.put(td.toJSON());

        // Saves To-Do items
        Writer writer = null;
        try {
        OutputStream out = mContext
                .openFileOutput(mFileName2, Context.MODE_PRIVATE);
        writer = new OutputStreamWriter( out );
        writer.write( tdArray.toString() );
        } finally {
            // Closes all the writers
            if( writer != null )
                writer.close();
        }
    }

    public void saveProjectItems( ArrayList<ProjectItem> projects ) throws JSONException, IOException {

        // Builds a Projects item array in JSON
        JSONArray pArray = new JSONArray();
        for( ProjectItem pI : projects )
            pArray.put( pI.toJSON() );

        // Saves projects
        Writer writer = null;
        try {
        OutputStream out = mContext
                .openFileOutput(mFileName3, Context.MODE_PRIVATE);
        writer = new OutputStreamWriter( out );
        writer.write( pArray.toString() );
        } finally {
            // Closes all the writers
            if( writer != null )
                writer.close();
        }
    }

    public ArrayList<DayEvent> loadDayEvents() throws IOException, JSONException {
        ArrayList<DayEvent> dayEvents = new ArrayList<DayEvent>();
        BufferedReader reader = null;
        try{
            InputStream in = mContext.openFileInput( mFileName1 );
            reader = new BufferedReader( new InputStreamReader( in ) );
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while( (line = reader.readLine()) != null ) {
                jsonString.append(line);
            }

            JSONArray array = (JSONArray) new JSONTokener( jsonString.toString() ).nextValue();

            for( int i = 0; i < array.length(); i++ ) {
                dayEvents.add( new DayEvent( array.getJSONObject( i ) ) );
            }
        } catch ( FileNotFoundException e ) {

        } finally {
            if( reader != null )
                reader.close();
        }
        return dayEvents;
    }

    public ArrayList<ToDoItem> loadToDoItems() throws IOException, JSONException {
        ArrayList<ToDoItem> todoitems = new ArrayList<ToDoItem>();
        BufferedReader reader = null;
        try{
            InputStream in = mContext.openFileInput( mFileName2 );
            reader = new BufferedReader( new InputStreamReader( in ) );
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while( (line = reader.readLine()) != null ) {
                jsonString.append(line);
            }

            JSONArray array = (JSONArray) new JSONTokener( jsonString.toString() ).nextValue();

            for( int i = 0; i < array.length(); i++ ) {
                todoitems.add( new ToDoItem( array.getJSONObject( i ) ) );
            }
        } catch ( FileNotFoundException e ) {

        } finally {
            if( reader != null )
                reader.close();
        }
        return todoitems;
    }

    public ArrayList<ProjectItem> loadProjectItems() throws IOException, JSONException {
        ArrayList<ProjectItem> projectItems = new ArrayList<ProjectItem>();
        BufferedReader reader = null;
        try{
            InputStream in = mContext.openFileInput( mFileName3 );
            reader = new BufferedReader( new InputStreamReader( in ) );
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while( (line = reader.readLine()) != null ) {
                jsonString.append(line);
            }

            JSONArray array = (JSONArray) new JSONTokener( jsonString.toString() ).nextValue();

            for( int i = 0; i < array.length(); i++ ) {
                projectItems.add( new ProjectItem( array.getJSONObject( i ) ) );
            }
        } catch ( FileNotFoundException e ) {

        } finally {
            if( reader != null )
                reader.close();
        }
        return projectItems;
    }
}
