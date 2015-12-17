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

public class SettingsActivity extends AppCompatActivity{

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
        setContentView(R.layout.activity_settings);

        intent = getIntent();

        mHandFogTextView = (EditText)findViewById(R.id.handFogTextView);
        mHandFogTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mHandFogTextView){
                    mHandFogTextView.getText().clear();
                }
            }
        });

        mHandSmoothTextView = (EditText)findViewById(R.id.handSmoothTextView);
        mHandSmoothTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mHandSmoothTextView){
                    mHandSmoothTextView.getText().clear();
                }
            }
        });

        mFogTextView = (EditText)findViewById(R.id.fogTextView);
        mFogTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mFogTextView){
                    mFogTextView.getText().clear();
                }
            }
        });

        mSmoothTextView = (EditText)findViewById(R.id.smoothTextView);
        mSmoothTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mSmoothTextView){
                    mSmoothTextView.getText().clear();
                }
            }
        });

        mBlitzFogTextView = (EditText)findViewById(R.id.blitzFogTextView);
        mBlitzFogTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mBlitzFogTextView){
                    mBlitzFogTextView.getText().clear();
                }
            }
        });

        mBlitzSmoothTextView = (EditText)findViewById(R.id.blitzSmoothTextView);
        mBlitzSmoothTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mBlitzSmoothTextView){
                    mBlitzSmoothTextView.getText().clear();
                }
            }
        });

        mHandlineTextView = (EditText)findViewById(R.id.handlineTextView);
        mHandlineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mHandlineTextView){
                    mHandlineTextView.getText().clear();
                }
            }
        });

        mHandline2TextView = (EditText)findViewById(R.id.handline2TextView);
        mHandline2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mHandline2TextView){
                    mHandline2TextView.getText().clear();
                }
            }
        });

        mHandline3TextView = (EditText)findViewById(R.id.handline3TextView);
        mHandline3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mHandline3TextView){
                    mHandline3TextView.getText().clear();
                }
            }
        });

        mAppliancesTextView = (EditText)findViewById(R.id.applianceTextView);
        mAppliancesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mAppliancesTextView){
                    mAppliancesTextView.getText().clear();
                }
            }
        });

        mElevationTextView = (EditText)findViewById(R.id.elevationTextView);
        mElevationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mElevationTextView){
                    mElevationTextView.getText().clear();
                }
            }
        });

        if(display()){
            displayValues();
        }

        saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEditText();

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
                editor.putBoolean("userclicksave", false);
                editor.putBoolean("display", true);
                editor.apply();

                Toast.makeText(SettingsActivity.this, "Settings Saved", Toast.LENGTH_LONG).show();

                displayValues();
            }
        });

        clearButton = (Button)findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.putBoolean("display", false);
                editor.apply();

                Toast.makeText(SettingsActivity.this, "Settings Cleared", Toast.LENGTH_LONG).show();

                resetValues();
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

    public void checkEditText(){
        if(mHandFogTextView.getText().toString().equals("")) {
            mHandFogTextView.setText("0");
        }
        if(mHandSmoothTextView.getText().toString().equals("")) {
            mHandSmoothTextView.setText("0");
        }
        if(mFogTextView.getText().toString().equals("")) {
            mFogTextView.setText("0");
        }
        if(mSmoothTextView.getText().toString().equals("")) {
            mSmoothTextView.setText("0");
        }
        if(mBlitzFogTextView.getText().toString().equals("")) {
            mBlitzFogTextView.setText("0");
        }
        if(mBlitzSmoothTextView.getText().toString().equals("")) {
            mBlitzSmoothTextView.setText("0");
        }
        if(mHandlineTextView.getText().toString().equals("")) {
            mHandlineTextView.setText("0");
        }
        if(mHandline2TextView.getText().toString().equals("")) {
            mHandline2TextView.setText("0");
        }
        if(mHandline3TextView.getText().toString().equals("")) {
            mHandline3TextView.setText("0");
        }
        if(mAppliancesTextView.getText().toString().equals("")) {
            mAppliancesTextView.setText("0");
        }
        if(mElevationTextView.getText().toString().equals("")) {
            mElevationTextView.setText("0");
        }
    }

    public void resetValues(){
        mHandFogTextView.setText("");
        mHandSmoothTextView.setText("");
        mFogTextView.setText("");
        mSmoothTextView.setText("");
        mBlitzFogTextView.setText("");
        mBlitzSmoothTextView.setText("");
        mHandlineTextView.setText("");
        mHandline2TextView.setText("");
        mHandline3TextView.setText("");
        mAppliancesTextView.setText("");
        mElevationTextView.setText("");
    }

    public boolean display(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        boolean userclicksave = sharedPreferences.getBoolean("display", false);
        return userclicksave;
    }
}


