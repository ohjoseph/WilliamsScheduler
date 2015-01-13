
package josephoh.android.williamsscheduler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * Created by Joseph on 1/11/15.
 */

public class TimePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState ) {

        View v = getActivity().getLayoutInflater().inflate( R.layout.dialog_time, null );

        return new AlertDialog.Builder( getActivity() )
                .setView( v )
                .setTitle( R.string.time_picker_title )
                .setPositiveButton( android.R.string.ok, null )
                .create();
    }

}
