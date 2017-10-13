package com.riis.ValidatePhone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.util.Log;
import android.content.SharedPreferences;
import android.provider.Settings.Secure;

public class LoginActivity extends ActionBarActivity {


    public static final String APP_TAG = "com.riis.validatelogin";
    public static final int MinPassLen = 6;
    public static final String SHARED_PREF_NAME = "mySharedPrefs";
    public static final String DEVICE_ID = "lastDevice";
    public static String androidID = "";
    public static String spAndroidID = "";


    private Button loginButton;
    private SharedPreferences sharedPrefs;

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


    private void getDeviceID(){
        spAndroidID = sharedPrefs.getString(DEVICE_ID, "");

        if(spAndroidID.length() == 0){
            //phone has not been used before
            androidID = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
            Log.d(APP_TAG, "New Shared Prefs Device ID" + androidID);

            //ask security questions as it's a new phone??

            // Save Android ID to Shared Preferences
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString(DEVICE_ID, androidID);
            editor.commit();
        }else{
            // Phone has a saved deviceID
            if(spAndroidID.equals(androidID)){
                Log.d(APP_TAG, "Shared Prefs Device ID" + spAndroidID);
            }else{
                //Ask additional security questions
            }
        }
    }

}
