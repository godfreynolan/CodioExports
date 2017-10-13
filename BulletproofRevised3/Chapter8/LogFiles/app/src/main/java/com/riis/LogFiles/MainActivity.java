package com.riis.LogFiles;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends ActionBarActivity {

    public static final String APP_TAG = "com.riis.logfiles";
    public static final String PassportNumber = "W123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(APP_TAG, "Passport document #  - " + PassportNumber);
    }


}
