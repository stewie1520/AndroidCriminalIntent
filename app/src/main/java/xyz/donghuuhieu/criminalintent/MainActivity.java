package xyz.donghuuhieu.criminalintent;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_ID = "xyz.donghuuhieu.criminalitent.crime_id";

    @Override
    protected Fragment createFragment() {
        return CrimeFragment.newInstance(getExtraCrimeId(getIntent()));
    }

    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);

        return intent;
    }

    public static UUID getExtraCrimeId(Intent intent) {
        return (UUID) intent.getSerializableExtra(EXTRA_CRIME_ID);
    }
}