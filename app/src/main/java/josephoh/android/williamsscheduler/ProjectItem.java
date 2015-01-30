package josephoh.android.williamsscheduler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Joseph on 1/22/15.
 */
public class ProjectItem {

    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_PURPOSE = "purpose";
    private static final String JSON_NEXT = "nextstep";
    private static final String JSON_OUTCOME = "outcome";

    // The components of the project item
    private UUID mID;
    private String mTitle;
    private String mPurpose;
    private String mOutcome;
    private String mNextStep;

    public ProjectItem() {
        mID = UUID.randomUUID();
    }

    public ProjectItem( JSONObject json ) throws JSONException {
        mID = UUID.fromString( json.getString( JSON_ID ) );
        mTitle = json.getString( JSON_TITLE );
        if( json.has( JSON_TITLE ) )
            mTitle = json.getString( JSON_TITLE );
        if( json.has( JSON_PURPOSE ) )
            mTitle = json.getString( JSON_PURPOSE );
        if( json.has( JSON_OUTCOME ) )
            mTitle = json.getString( JSON_OUTCOME );
        if( json.has( JSON_NEXT ) )
            mTitle = json.getString( JSON_NEXT );
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put( JSON_PURPOSE, mPurpose );
        json.put( JSON_NEXT, mNextStep );
        json.put( JSON_OUTCOME, mOutcome );
        json.put( JSON_ID, mID.toString() );
        json.put( JSON_TITLE, mTitle );
        return json;
    }

    public String getPurpose() {
        return mPurpose;
    }

    public void setPurpose(String purpose) {
        mPurpose = purpose;
    }

    public String getOutcome() {
        return mOutcome;
    }

    public void setOutcome(String outcome) {
        mOutcome = outcome;
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

    public String getNextStep() {
        return mNextStep;
    }

    public void setNextStep(String nextStep) {
        mNextStep = nextStep;
    }
}
