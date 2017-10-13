package com.riis.HelloIntent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(getBaseContext(), "username: " + this.getIntent().getStringExtra("Username")+
                        "\npassword: "+this.getIntent().getStringExtra("Password")+
                        "\nemail: "+this.getIntent().getStringExtra("Email"),
                Toast.LENGTH_LONG).show();
    }


}
