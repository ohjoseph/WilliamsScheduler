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
    // The time of the Event
    private String mHour;
    private String mMinute = "00";
    private String mAM;
    // The duration
    private int mDurHour;
    private int mDurMinute;

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

    public String getHour() { return mHour; }

    public void setHour(String hour) { mHour = hour; }

    public String getMinute() { return mMinute; }

    public void setMinute(String minute) { mMinute = minute; }

    @Override
    public String toString() { return mTitle; }
}
