package com.riis.sqlite3;

import android.support.v7.app.ActionBarActivity;
import java.io.File;

import android.os.Bundle;
import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitializeSQLite3();
    }

    private void InitializeSQLite3(){
        SQLiteDatabase.loadLibs(this);
        File databaseFile = getDatabasePath("names.db");
        databaseFile.mkdirs();
        databaseFile.delete();

        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, "pass123", null);

        database.execSQL("create table user(id integer primary key autoincrement,"
                + "first text not null, last text not null,"
                + "username text not null, password test not null)");

        database.execSQL("insert into user(first, last,username,password)"
                + "values('Bertie','Ahern','bahern','celia123')");


    }

}
