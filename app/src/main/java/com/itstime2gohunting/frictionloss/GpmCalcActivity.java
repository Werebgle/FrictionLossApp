package com.itstime2gohunting.frictionloss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GpmCalcActivity extends AppCompatActivity {

    Intent intent;
    private TextView mFlTextView;
    private EditText mCoeffEditText;
    private EditText mGpmEditText;
    private EditText mLengthEditText;
    private Button mCalculateButton;

    private TextView mGpmTextView;
    private EditText mDiameterEditText;
    private EditText mNpEditText;
    private Button mGpmCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpm_calc);

        intent = getIntent();
        mFlTextView = (TextView) findViewById(R.id.flTextView);
        mCoeffEditText = (EditText) findViewById(R.id.coeffEditText);
        mGpmEditText = (EditText) findViewById(R.id.gpmEditText);
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        mCalculateButton = (Button) findViewById(R.id.flCalculateButton);

        mGpmTextView = (TextView) findViewById(R.id.gpmTextView);
        mDiameterEditText = (EditText) findViewById(R.id.diameterEditText);
        mNpEditText = (EditText) findViewById(R.id.npEditText);
        mGpmCalculateButton = (Button) findViewById(R.id.gpmCalculateButton);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GpmCalculation mGpmCalculation = new GpmCalculation();

                String coeffString = mCoeffEditText.getText().toString();
                if (coeffString.equals("")){
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Coefficient value", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    double coeff = Double.parseDouble(mCoeffEditText.getText().toString());
                    mGpmCalculation.setCoefficient(coeff);
                }

                String gpmString = mCoeffEditText.getText().toString();
                if (gpmString.equals("")){
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter GPM value", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    double gpm = Double.parseDouble(mGpmEditText.getText().toString());
                    mGpmCalculation.setGpm(gpm);
                }

                String lengthString = mLengthEditText.getText().toString();
                if (lengthString.equals("")){
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Length value", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    double length = Double.parseDouble(mLengthEditText.getText().toString());
                    mGpmCalculation.setLength(length);
                }

                long fl = Math.round(mGpmCalculation.getFrictionLoss()*10)/10;
                mFlTextView.setText(String.valueOf(fl));
            }
        });

        mGpmCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GpmCalculation mGpmCalculation = new GpmCalculation();

                String diameterString = mDiameterEditText.getText().toString();
                if (diameterString.equals("")){
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Diameter value", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    double diameter = Double.parseDouble(mDiameterEditText.getText().toString());
                    mGpmCalculation.setDiameter(diameter);
                }

                String npString = mDiameterEditText.getText().toString();
                if (npString.equals("")){
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Nozzle Pressure value", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    double np = Double.parseDouble(mNpEditText.getText().toString());
                    mGpmCalculation.setNp(np);
                }


                long gpm = Math.round(mGpmCalculation.getGpmResult()*10)/10;
                mGpmTextView.setText(String.valueOf(gpm));
            }
        });

    }
}
