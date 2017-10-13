package com.riis.ValidatePhone;

/**
 * Created by SD on 3/15/16.
 */
import android.content.Context;
import android.app.AlertDialog;

public class AlertDialogs{

    public AlertDialogs(){

    }

    protected static void showEmptyFieldsAlertDialog(Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setMessage("Please fill in every field.");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.create().show();
    }

    protected static void showEmptyEmailAlertDialog(Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setMessage("Please enter a valid email.");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.create().show();
    }

    protected static void showBadPasswordAlertDialog(Context context, int passLen){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setMessage("Password needs to be at least " + passLen + " characters.");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.create().show();
    }
}

