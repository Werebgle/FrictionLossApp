package com.itstime2gohunting.frictionloss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity{

    Intent intent;

    private EditText mHandFogTextView;
    private EditText mHandSmoothTextView;
    private EditText mFogTextView;
    private EditText mSmoothTextView;
    private EditText mBlitzFogTextView;
    private EditText mBlitzSmoothTextView;
    private EditText mHandlineTextView;
    private EditText mHandline2TextView;
    private EditText mHandline3TextView;
    private EditText mAppliancesTextView;
    private EditText mElevationTextView;


    private Button saveButton;
    private Button clearButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        intent = getIntent();

        mHandFogTextView = (EditText)findViewById(R.id.handFogTextView);
        mHandSmoothTextView = (EditText)findViewById(R.id.handSmoothTextView);
        mFogTextView = (EditText)findViewById(R.id.fogTextView);
        mSmoothTextView = (EditText)findViewById(R.id.smoothTextView);
        mBlitzFogTextView = (EditText)findViewById(R.id.blitzFogTextView);
        mBlitzSmoothTextView = (EditText)findViewById(R.id.blitzSmoothTextView);
        mHandlineTextView = (EditText)findViewById(R.id.handlineTextView);
        mHandline2TextView = (EditText)findViewById(R.id.handline2TextView);
        mHandline3TextView = (EditText)findViewById(R.id.handline3TextView);
        mAppliancesTextView = (EditText)findViewById(R.id.applianceTextView);
        mElevationTextView = (EditText)findViewById(R.id.elevationTextView);


        saveButton = (Button)findViewById(R.id.saveButton);

        displayValues();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("handfog", Integer.parseInt(mHandFogTextView.getText().toString()));
                editor.putInt("handsmooth", Integer.parseInt(mHandSmoothTextView.getText().toString()));
                editor.putInt("fog", Integer.parseInt(mFogTextView.getText().toString()));
                editor.putInt("smooth", Integer.parseInt(mSmoothTextView.getText().toString()));
                editor.putInt("blitzfog", Integer.parseInt(mBlitzFogTextView.getText().toString()));
                editor.putInt("blitzsmooth", Integer.parseInt(mBlitzSmoothTextView.getText().toString()));
                editor.putInt("handline", Integer.parseInt(mHandlineTextView.getText().toString()));
                editor.putInt("handline2", Integer.parseInt(mHandline2TextView.getText().toString()));
                editor.putInt("handline3", Integer.parseInt(mHandline3TextView.getText().toString()));
                editor.putInt("appliance", Integer.parseInt(mAppliancesTextView.getText().toString()));
                editor.putInt("elevation", Integer.parseInt(mElevationTextView.getText().toString()));


                editor.apply();

                Toast.makeText(Settings.this, "Settings Saved", Toast.LENGTH_LONG).show();
            }
        });

        clearButton = (Button)findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                displayValues();

                Toast.makeText(Settings.this, "Settings Cleared", Toast.LENGTH_LONG).show();
            }
        });

    }
    public void displayValues() {
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info = sharedPreferences.getInt("handfog", 0);
        int info1 = sharedPreferences.getInt("handsmooth", 0);
        int info2 = sharedPreferences.getInt("fog", 0);
        int info3 = sharedPreferences.getInt("smooth", 0);
        int info4 = sharedPreferences.getInt("blitzfog", 0);
        int info5 = sharedPreferences.getInt("blitzsmooth", 0);
        int info6 = sharedPreferences.getInt("handline", 0);
        int info7 = sharedPreferences.getInt("handline2", 0);
        int info8 = sharedPreferences.getInt("handline3", 0);
        int info9 = sharedPreferences.getInt("appliance", 0);
        int info10 = sharedPreferences.getInt("elevation", 0);


        mHandFogTextView.setText(String.valueOf(info));
        mHandSmoothTextView.setText(String.valueOf(info1));
        mFogTextView.setText(String.valueOf(info2));
        mSmoothTextView.setText(String.valueOf(info3));
        mBlitzFogTextView.setText(String.valueOf(info4));
        mBlitzSmoothTextView.setText(String.valueOf(info5));
        mHandlineTextView.setText(String.valueOf(info6));
        mHandline2TextView.setText(String.valueOf(info7));
        mHandline3TextView.setText(String.valueOf(info8));
        mAppliancesTextView.setText(String.valueOf(info9));
        mElevationTextView.setText(String.valueOf(info10));

    }
}


