package josephoh.android.williamsscheduler;

import android.graphics.Color;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class ToDoItem {

    private static final String JSON_ID = "todo_id";
    private static final String JSON_DONE = "todo_isDone";
    private static final String JSON_TITLE = "title";
    private static final String JSON_DESC = "desc";
    private static final String JSON_CONTEXT = "context";
    private static final String JSON_PRI = "priority";
    private static final String JSON_TIME = "time";

    // The ID of the item
    private UUID mID;
    // Whether the item has been finished
    private boolean isDone;
    // The name of the item
    private String mTitle;
    // A short description of the item
    private String mDesc;
    // The context of the item
    private String context;
    // The priority of the item
    private int priority;
    // The time it takes
    private int time;

    public ToDoItem() {
        mID = UUID.randomUUID();
        isDone = false;
        context = "Home";
        priority = Color.GREEN;
        time = 10;
    }

    public ToDoItem( JSONObject json ) throws JSONException {
        mID = UUID.fromString( json.getString( JSON_ID ) );
        mTitle = json.getString( JSON_TITLE );
        if( json.has( JSON_DESC ) )
            mDesc = json.getString( JSON_DESC );
        context = json.getString( JSON_CONTEXT );
        priority = json.getInt( JSON_PRI );
        time = json.getInt( JSON_TIME );
        isDone = json.getBoolean( JSON_DONE );
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put( JSON_CONTEXT, context );
        json.put( JSON_DESC, mDesc );
        json.put( JSON_DONE, isDone );
        json.put( JSON_ID, mID.toString() );
        json.put( JSON_PRI, priority );
        json.put( JSON_TIME, time );
        json.put( JSON_TITLE, mTitle );
        return json;
    }

    public String getTime() {
        return time + " minutes" ;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public UUID getID() { return mID; }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }
}
