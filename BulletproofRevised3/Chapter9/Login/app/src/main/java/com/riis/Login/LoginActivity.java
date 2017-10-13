package com.riis.Login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class LoginActivity extends ActionBarActivity {

    private Button loginButton;
    EditText usernameField, passwordField, emailField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = (EditText) findViewById	(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        emailField = (EditText) findViewById(R.id.emailField);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit(v);
            }
        });

    }

    public void onSubmit(View v){

        // implicit
        // Intent intent = new Intent();

        // explicit
        Intent intent = new Intent(this, IntentReceiverActivity.class);  // line 41

        Bundle bundle = new Bundle();

        bundle.putString("Username", usernameField.getText().toString());
        bundle.putString("Password", passwordField.getText().toString());
        bundle.putString("Email", emailField.getText().toString());

        intent.setAction("com.riis.Login.IntentReceiverActivity");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtras(bundle);

        startActivity(intent);


    }

}
