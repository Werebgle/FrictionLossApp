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

    private TextView mGpmTextView;
    private EditText mDiameterEditText;
    private EditText mNpEditText;

    private TextView mNrTextView;
    private EditText mDiaEditText;
    private EditText mNozzlePressureEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpm_calc);

        intent = getIntent();
        mFlTextView = (TextView) findViewById(R.id.flTextView);
        mCoeffEditText = (EditText) findViewById(R.id.coeffEditText);
        mGpmEditText = (EditText) findViewById(R.id.gpmEditText);
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        Button CalculateButton = (Button) findViewById(R.id.flCalculateButton);

        mGpmTextView = (TextView) findViewById(R.id.gpmTextView);
        mDiameterEditText = (EditText) findViewById(R.id.diameterEditText);
        mNpEditText = (EditText) findViewById(R.id.npEditText);
        Button GpmCalculateButton = (Button) findViewById(R.id.gpmCalculateButton);

        mNrTextView = (TextView) findViewById(R.id.NrTextView);
        mDiaEditText = (EditText) findViewById(R.id.nozzleDiameterEditText);
        mNozzlePressureEditText = (EditText) findViewById(R.id.nozzlePressureEditText);
        Button NrCalculateButton = (Button) findViewById(R.id.nrCalculateButton);

        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GpmCalculation mGpmCalculation = new GpmCalculation();

                String coeffString = mCoeffEditText.getText().toString();
                if (coeffString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Coefficient value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double coeff = Double.parseDouble(mCoeffEditText.getText().toString());
                    mGpmCalculation.setCoefficient(coeff);
                }

                String gpmString = mCoeffEditText.getText().toString();
                if (gpmString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter GPM value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double gpm = Double.parseDouble(mGpmEditText.getText().toString());
                    mGpmCalculation.setGpm(gpm);
                }

                String lengthString = mLengthEditText.getText().toString();
                if (lengthString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Hose Length value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double length = Double.parseDouble(mLengthEditText.getText().toString());
                    mGpmCalculation.setLength(length);
                }

                long fl = Math.round(mGpmCalculation.getFrictionLoss() * 10) / 10;
                mFlTextView.setText("FL = " + String.valueOf(fl) + " PSI");
            }
        });

        GpmCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GpmCalculation mGpmCalculation = new GpmCalculation();

                String diameterString = mDiameterEditText.getText().toString();
                if (diameterString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Nozzle Diameter value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double diameter = Double.parseDouble(mDiameterEditText.getText().toString());
                    mGpmCalculation.setDiameter(diameter);
                }

                String npString = mDiameterEditText.getText().toString();
                if (npString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Nozzle Pressure value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double np = Double.parseDouble(mNpEditText.getText().toString());
                    mGpmCalculation.setNp(np);
                }


                long gpm = Math.round(mGpmCalculation.getGpmResult() * 10) / 10;
                mGpmTextView.setText("GPM = " + String.valueOf(gpm));
            }
        });

        NrCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GpmCalculation gpmCalculation = new GpmCalculation();

                String diameterString = mDiaEditText.getText().toString();
                if (diameterString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Nozzle Diameter value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double diameter = Double.parseDouble(mDiaEditText.getText().toString());
                    gpmCalculation.setDia(diameter);
                }

                String nozzlePressureString = mNozzlePressureEditText.getText().toString();
                if (nozzlePressureString.equals("")) {
                    Toast toast = Toast.makeText(GpmCalcActivity.this, "Please enter Nozzle Pressure value", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double nozzlePressure = Double.parseDouble(mNozzlePressureEditText.getText().toString());
                    gpmCalculation.setNP(nozzlePressure);
                }

                long nr = Math.round(gpmCalculation.getNr() * 10) / 10;
                mNrTextView.setText("NR = " + String.valueOf(nr) + " lbs");
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
