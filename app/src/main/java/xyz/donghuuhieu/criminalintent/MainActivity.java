package xyz.donghuuhieu.criminalintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

    public static final String EXTRA_CRIME_ID = "xyz.donghuuhieu.criminalitent.crime_id";

    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);

        return intent;
    }

    public static UUID getExtraCrimeId(Intent intent) {
        return (UUID) intent.getSerializableExtra(EXTRA_CRIME_ID);
    }
}