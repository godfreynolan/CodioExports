package com.riis.LoginCrashlytics;

/**
 * Created by SD on 3/16/16.
 */
import android.content.Context;
import android.app.AlertDialog;

public class AlertDialogs {

    public AlertDialogs(){

    }

    public static void showEmptyFieldsAlertDialog(Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setMessage("Please fill in every field.");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.create().show();
    }

}
