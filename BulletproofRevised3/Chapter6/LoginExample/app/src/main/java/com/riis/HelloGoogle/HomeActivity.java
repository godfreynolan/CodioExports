package com.riis.HelloGoogle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class HomeActivity extends ActionBarActivity {

    private Button signInBtn;
    private Button signUpBtn;

    private LoginDatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signInBtn = (Button) findViewById(R.id.buttonSignIn);
        signUpBtn = (Button) findViewById(R.id.buttonSignUp);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.usernameField)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordField)).getText().toString();

                Boolean loggedIn = loginDatabaseAdapter.checkLogin(username, password);

                if(loggedIn){
                    Toast.makeText(HomeActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(HomeActivity.this,
                            "Username or Password is invalid",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUP=new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intentSignUP);
            }
        });

    }


}
