package com.android.locbookapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class DBHelper {

    SQLiteDatabase myDB = openOrCreateDatabase("Locbook", null, null);

    public String ExecuteDB(String Sql) { // for updating and inserting in database
        try {
            myDB.execSQL(Sql);
        } catch (Exception e) {
            return "Failed";
        }

        return "Success";
    }


    public JSONArray QueryDB(String Sql) { // for select query in database

        Cursor Result = null;
        try {
            Result = myDB.rawQuery(Sql, null);
            return cursorToJson(Result);
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray cursorToJson(Cursor cursor) {

        try {
            JSONArray resultSet = new JSONArray();
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                int totalColumn = cursor.getColumnCount();
                JSONObject rowObject = new JSONObject();
                for (int i = 0; i < totalColumn; i++) {
                    if (cursor.getColumnName(i) != null) {
                        try {
                            if (cursor.getString(cursor.getColumnIndex(cursor.getColumnName(i))) == null) {
                                rowObject.put(cursor.getColumnName(i),
                                        JSONObject.NULL);
                            } else {
                                rowObject.put(cursor.getColumnName(i),
                                        cursor.getString(cursor.getColumnIndex(cursor.getColumnName(i))));
                            }
                            //cursor.getColumnName(i));
                        } catch (Exception e) {
                            Log.d("Error", e.getMessage());
                        }
                    }
                }
                resultSet.put(rowObject);
                try {
                    cursor.moveToNext();
                } catch (Exception e) {
                    Log.d("Error", e.getMessage());
                }

            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                //  cursor = null;

            }
            return resultSet;
        } catch (Exception e) {
            if (cursor != null && !cursor.isClosed()) {

                cursor.close();
                // cursor = null;
            }
            return null;
        }
    }
}
