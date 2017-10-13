package com.riis.Login;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by SD on 3/16/16.
 */
public class IntentReceiverActivity extends ActionBarActivity {

    TextView usernameTextfield, passwordTextfield, emailTextfield;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_receiver);

        Bundle bundle = getIntent().getExtras();

        String result1 = bundle.getString("Username");
        String result2 = bundle.getString("Password");
        String result3 = bundle.getString("Email");


        usernameTextfield=(TextView)findViewById(R.id.usertxt_field);
        passwordTextfield=(TextView)findViewById(R.id.passtxt_field);
        emailTextfield=(TextView)findViewById(R.id.emailtxt_field);

        usernameTextfield.setText("Username:" + result1);
        passwordTextfield.setText("Password:"+result2);
        emailTextfield.setText("Email:"+result3);
    }
}
