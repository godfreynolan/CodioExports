package com.riis.HelloGoogle;

/**
 * Created by SD on 3/15/16.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends ActionBarActivity{
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;

    private Button createAccountBtn;

    private LoginDatabaseAdapter loginDatabaseAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginDatabaseAdapter=new LoginDatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();

        createAccountBtn = (Button) findViewById(R.id.createAccountButton);

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.usernameField)).getText().toString();
                String email = ((EditText) findViewById(R.id.emailField)).getText().toString();

                String password = ((EditText) findViewById(R.id.passwordField)).getText().toString();
                String confirmPassword = ((EditText) findViewById(R.id.confirmPasswordField)).getText().toString();

                if (username.equals("") || password.equals("") || confirmPassword.equals("") || email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    // Save the Data in Database
                    loginDatabaseAdapter.insertEntry(username, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
