package josephoh.android.williamsscheduler;

import java.util.UUID;

public class ProjectActivity extends SingleFragmentActivity {

    @Override
    protected ProjectFragment createFragment() {

        UUID id = (UUID) getIntent().getSerializableExtra( ProjectFragment.EXTRA_PROJECT_ID );

        return ProjectFragment.newInstance( id );
    }
}
