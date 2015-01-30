package josephoh.android.williamsscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class ClearScreenActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_screen);

        // Initializes the Buttons
        Button noButton = (Button) findViewById( R.id.refresh_no );
        noButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED,returnIntent);
                finish();
            }
        });

        Button yesButton = (Button) findViewById( R.id.refresh_yes );
        yesButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "yes" );
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}