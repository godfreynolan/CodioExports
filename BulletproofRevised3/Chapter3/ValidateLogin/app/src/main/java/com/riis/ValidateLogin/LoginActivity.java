package com.riis.ValidateLogin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.util.Log;

public class LoginActivity extends ActionBarActivity {


    public static final String APP_TAG = "com.riis.validatelogin";
    public static final int MinPassLen = 6;
    public static final String SHARED_PREF_NAME = "mySharedPrefs";
    public static final String DEVICE_ID = "lastDevice";
    public static String androidID = "";
    public static String spAndroidID = "";


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
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginToApp();
            }
        });
    }

    private void loginToApp(){
        EditText usernameField = (EditText) findViewById(R.id.usernameField);
        EditText passwordField = (EditText) findViewById(R.id.passwordField);
        EditText emailField = (EditText) findViewById(R.id.emailField);

        if(areFieldsEmpty(usernameField, passwordField)){
            AlertDialogs.showEmptyFieldsAlertDialog(this);
            return;
        }

        if(invalidEmail(emailField)){
            AlertDialogs.showEmptyEmailAlertDialog(this);
            return;
        }

        if(shortPassword(passwordField)){
            AlertDialogs.showBadPasswordAlertDialog(this, MinPassLen);
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

    private boolean shortPassword(EditText passwordField){
        if(passwordField.getText().toString().length() > (MinPassLen - 1)){
            Log.d(APP_TAG, "Valid Password");
            return false;
        }

        Log.d(APP_TAG, "Invalid Password");
        return true;
    }

    private boolean invalidEmail(EditText emailField){
        Pattern pattern;
        Matcher matcher;

        String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(emailField.getText().toString());

        if(matcher.matches()){
            Log.d(APP_TAG,"Valid Email" + matcher);
            return false;
        }

        Log.d(APP_TAG,"Invalid Email" + matcher);
        return true;
    }

}
