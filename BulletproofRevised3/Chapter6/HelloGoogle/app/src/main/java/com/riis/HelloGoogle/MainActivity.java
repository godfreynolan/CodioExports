package com.riis.HelloGoogle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Context;
import android.view.View;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Context context = this;
        button = (Button) findViewById(R.id.buttonURL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                startActivity(intent);
            }
        });

    }


}
