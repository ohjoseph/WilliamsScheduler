package josephoh.android.williamsscheduler;

import java.util.UUID;

/**
 * Created by Joseph on 1/10/15.
 */
public class ToDoItem {

    // The ID of the item
    private UUID mID = UUID.randomUUID();
    // Whether the item has been finished
    private boolean isDone;
    // The name of the item
    private String mTitle;
    // A short description of the item
    private String mDesc;

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
