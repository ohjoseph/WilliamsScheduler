package josephoh.android.williamsscheduler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class DayEvent {

    // JSON constants
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_DESC = "desc";
    private static final String JSON_HOUR = "hour";
    private static final String JSON_MIN = "minute";
    private static final String JSON_AM = "am";
    private static final String JSON_DURHOUR = "durhour";
    private static final String JSON_DURMIN = "durmin";

    // The ID of the event
    private UUID mID = UUID.randomUUID();
    // The title of the event
    private String mTitle;
    // The description of the event
    private String mDesc;
    // The time of the Event
    private String mHour;
    private String mMinute = "00";
    private String mAM;
    // The duration
    private int mDurHour;
    private int mDurMinute;

    public DayEvent( JSONObject json ) throws JSONException {
        mID = UUID.fromString( json.getString( JSON_ID ) );
        mTitle = json.getString( JSON_TITLE );
        if( json.has( JSON_DESC ) )
        mDesc = json.getString( JSON_DESC );
        mHour = json.getString( JSON_HOUR );
        mMinute = json.getString( JSON_MIN );
        mAM = json.getString( JSON_AM );
        if( json.has( JSON_DURHOUR ) )
        mDurHour = json.getInt( JSON_DURHOUR );
        if( json.has( JSON_DURMIN ) )
        mDurMinute = json.getInt( JSON_DURMIN );
    }

    public int getDurHour() {
        return mDurHour;
    }

    public void setDurHour(int durHour) {
        mDurHour = durHour;
    }

    public int getDurMinute() {
        return mDurMinute;
    }

    public void setDurMinute(int durMinute) {
        mDurMinute = durMinute;
    }

    public String getAM() {
        return mAM;
    }

    public void setAM( String AM) {
        mAM = AM;
    }

    public UUID getID() {
        return mID;
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

    public String getHour() { return mHour; }

    public void setHour(String hour) { mHour = hour; }

    public String getMinute() { return mMinute; }

    public void setMinute(String minute) { mMinute = minute; }

    @Override
    public String toString() { return mTitle; }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put( JSON_ID, mID );
        json.put( JSON_AM, mAM );
        json.put( JSON_TITLE, mTitle );
        json.put( JSON_DESC, mDesc );
        json.put( JSON_HOUR, mHour );
        json.put( JSON_MIN, mMinute );
        json.put( JSON_DURHOUR, mDurHour );
        json.put( JSON_DURMIN, mDurMinute );
        return json;
    }
}
