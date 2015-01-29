package josephoh.android.williamsscheduler;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
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
}
