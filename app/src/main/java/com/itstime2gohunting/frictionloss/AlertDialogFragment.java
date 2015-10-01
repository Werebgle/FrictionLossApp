package com.itstime2gohunting.frictionloss;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_dialog)
                .setPositiveButton(R.string.alert_button, null);

        AlertDialog dialog = builder.create();
        return dialog;
    }
}
