package com.riis.RestfulWebService;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MainActivity extends ActionBarActivity {

    final String URL1 = "api.wunderground.com/api/";
    final String URL2 = "/conditions/q/MI/Troy.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button HTTP = (Button) findViewById(R.id.httpButton);

        HTTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apiKey = ((EditText) findViewById(R.id.apiKey)).getText().toString();
                try {
                    URL url = new URL("http://" + URL1 + apiKey + URL2);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                } catch (Exception e) {
                    Log.e("URL", "Could Not Connect");
                }
            }
        });

    }


}
