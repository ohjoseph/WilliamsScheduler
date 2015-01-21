package josephoh.android.williamsscheduler;

import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class ToDoItem {

    private static int color_GREEN = -16711936;

    // The ID of the item
    private UUID mID = UUID.randomUUID();
    // Whether the item has been finished
    private boolean isDone;
    // The name of the item
    private String mTitle;
    // A short description of the item
    private String mDesc;
    // The context of the item
    private String context = "Home";
    // The priority of the item
    private int priority = color_GREEN;
    // The time it takes
    private int time = 10;

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
