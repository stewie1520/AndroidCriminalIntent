package xyz.donghuuhieu.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    private static CrimeLab get(Context ctx) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(ctx);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context ctx) {
        mCrimes = new ArrayList<Crime>();

        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("#Crime " + i);
            crime.setSolve(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
