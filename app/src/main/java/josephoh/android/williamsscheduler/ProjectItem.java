package josephoh.android.williamsscheduler;

import java.util.UUID;

/**
 * Created by Joseph on 1/22/15.
 */
public class ProjectItem {

    // The components of the project item
    private UUID mID;
    private String mTitle;
    private String mPurpose;
    private String mOutcome;
    private String mNextStep;

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
