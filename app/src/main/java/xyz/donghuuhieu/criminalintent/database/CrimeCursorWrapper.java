package xyz.donghuuhieu.criminalintent.database;

import android.database.CursorWrapper;
import android.database.Cursor;

import java.util.UUID;
import java.util.Date;

import xyz.donghuuhieu.criminalintent.Crime;
import xyz.donghuuhieu.criminalintent.database.CrimeDbSchema.CrimeTable;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolve(isSolved != 0);
        crime.setSuspect(suspect);

        return crime;
    }
}
