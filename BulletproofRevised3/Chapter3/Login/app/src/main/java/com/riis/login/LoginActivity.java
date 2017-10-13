package com.riis.Login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    private void initializeViews(){
        loginButton = (Button) findViewById(R.id.loginButton);
    }


    private void bindListenersToViews(){
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                loginToApp();
            }
        });
    }

    private void loginToApp(){
        EditText usernameField = (EditText) findViewById(R.id.usernameField);
        EditText passwordField = (EditText) findViewById(R.id.passwordField);
        //EditText emailField = (EditText) findViewById(R.id.emailField);

        if(areFieldsEmpty(usernameField, passwordField)){
            return;
        }
    }


    private boolean areFieldsEmpty(EditText... fields){
        for(EditText field : fields) {
            if(field.getText().toString().matches("")){
                return true;
            }
        }

        return false;
    }

}
