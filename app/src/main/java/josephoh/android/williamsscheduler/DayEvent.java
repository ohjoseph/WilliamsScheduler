package josephoh.android.williamsscheduler;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class DayEvent {

    // The ID of the event
    private UUID mID = UUID.randomUUID();
    // The Day of the event
    private Date mDate;
    // The title of the event
    private String mTitle;
    // The description of the event
    private String mDesc;

    public UUID getID() {
        return mID;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
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
