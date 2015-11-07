package com.itstime2gohunting.frictionloss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Settings setting = new Settings();

    //hose 1 spinners
    private Spinner mSpinner;
    private Spinner mSpinner1;
    private Spinner mSpinner2;
    private Spinner mSpinner3;
    private Spinner mSpinner4;
    private Spinner mSpinner5;
    //hose 2 spinners
    private Spinner mSpinner6;
    private Spinner mSpinner7;
    private Spinner mSpinner8;
    private Spinner mSpinner9;
    private Spinner mSpinner10;
    private Spinner mSpinner11;
    //hose 3 spinner
    private Spinner mSpinner12;
    private Spinner mSpinner13;
    private Spinner mSpinner14;
    private Spinner mSpinner15;
    private Spinner mSpinner16;
    private Spinner mSpinner17;

    //hose 1 result() calculation
    private int mValue = 0;

    //hose 2 result() calculation
    private int mValue2 = 0;

    //hose 3 result() calculation
    private int mValue3 = 0;

    //hose 1 spinner value user selected
    private Long mItem;
    private Long mItem1;
    private Long mItem2;
    private Long mItem3;
    private Long mItem4;
    private Long mItem5;
    //hose 2 spinner value user selected
    private Long mItem6;
    private Long mItem7;
    private Long mItem8;
    private Long mItem9;
    private Long mItem10;
    private Long mItem11;
    //hose 3 spinner value user selected
    private Long mItem12;
    private Long mItem13;
    private Long mItem14;
    private Long mItem15;
    private Long mItem16;
    private Long mItem17;

    //initial friction loss values hose 1
    private int mFLoss = 0;
    private int mFLoss1 = 0;
    private int mFLoss2 = 0;
    private int mFLoss3 = 0;
    private int mFLoss4 = 0;
    private int mFLoss5 = 0;
    //initial friction loss values hose 2
    private int mFLoss6 = 0;
    private int mFLoss7 = 0;
    private int mFLoss8 = 0;
    private int mFLoss9 = 0;
    private int mFLoss10 = 0;
    private int mFLoss11 = 0;
    //initial friction loss values hose 3
    private int mFLoss12 = 0;
    private int mFLoss13 = 0;
    private int mFLoss14 = 0;
    private int mFLoss15 = 0;
    private int mFLoss16 = 0;
    private int mFLoss17 = 0;

    private Button mButton;
    private Button mResetButton;
    private TextView resultTextView;
    private TextView resultTextView2;
    private TextView resultTextView3;
    private TextView resultTextView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calls Alert Dialog Fragment if User has not clicked Save Button in Settings.
        if (userInfoSet()){
            alertUser();
        }
        //set spinners hose 1
        mSpinner = (Spinner)findViewById(R.id.nozzleSpinner);
        mSpinner1 = (Spinner)findViewById(R.id.hose1Spinner);
        mSpinner2 = (Spinner)findViewById(R.id.hose2Spinner);
        mSpinner3 = (Spinner)findViewById(R.id.hose3Spinner);
        mSpinner4 = (Spinner)findViewById(R.id.applianceSpinner);
        mSpinner5 = (Spinner)findViewById(R.id.floorSpinner);
        //set spinners hose 2
        mSpinner6 = (Spinner)findViewById(R.id.nozzleSpinner2);
        mSpinner7 = (Spinner)findViewById(R.id.hose1Spinner2);
        mSpinner8 = (Spinner)findViewById(R.id.hose2Spinner2);
        mSpinner9 = (Spinner)findViewById(R.id.hose3Spinner2);
        mSpinner10 = (Spinner)findViewById(R.id.applianceSpinner2);
        mSpinner11 = (Spinner)findViewById(R.id.floorSpinner2);
        //set spinners hose 3
        mSpinner12 = (Spinner)findViewById(R.id.nozzleSpinner3);
        mSpinner13 = (Spinner)findViewById(R.id.hose1Spinner3);
        mSpinner14 = (Spinner)findViewById(R.id.hose2Spinner3);
        mSpinner15 = (Spinner)findViewById(R.id.hose3Spinner3);
        mSpinner16 = (Spinner)findViewById(R.id.applianceSpinner3);
        mSpinner17 = (Spinner)findViewById(R.id.floorSpinner3);

        //arrayadapter hose 1
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nozzle, android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.numberSticks1, android.R.layout.simple_spinner_dropdown_item);
        mSpinner1.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.numberSticks2, android.R.layout.simple_spinner_dropdown_item);
        mSpinner2.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.numberSticks3, android.R.layout.simple_spinner_dropdown_item);
        mSpinner3.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.numberAppliances, android.R.layout.simple_spinner_dropdown_item);
        mSpinner4.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.numberFloors, android.R.layout.simple_spinner_dropdown_item);
        mSpinner5.setAdapter(adapter5);
        //arrayadapter hose 2
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.nozzle, android.R.layout.simple_spinner_dropdown_item);
        mSpinner6.setAdapter(adapter6);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.numberSticks1, android.R.layout.simple_spinner_dropdown_item);
        mSpinner7.setAdapter(adapter7);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.numberSticks2, android.R.layout.simple_spinner_dropdown_item);
        mSpinner8.setAdapter(adapter8);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.numberSticks3, android.R.layout.simple_spinner_dropdown_item);
        mSpinner9.setAdapter(adapter9);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.numberAppliances, android.R.layout.simple_spinner_dropdown_item);
        mSpinner10.setAdapter(adapter10);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.numberFloors, android.R.layout.simple_spinner_dropdown_item);
        mSpinner11.setAdapter(adapter11);
        //arrayadapter hose 3
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.nozzle, android.R.layout.simple_spinner_dropdown_item);
        mSpinner12.setAdapter(adapter12);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.numberSticks1, android.R.layout.simple_spinner_dropdown_item);
        mSpinner13.setAdapter(adapter13);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.numberSticks2, android.R.layout.simple_spinner_dropdown_item);
        mSpinner14.setAdapter(adapter14);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.numberSticks3, android.R.layout.simple_spinner_dropdown_item);
        mSpinner15.setAdapter(adapter15);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.numberAppliances, android.R.layout.simple_spinner_dropdown_item);
        mSpinner16.setAdapter(adapter16);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.numberFloors, android.R.layout.simple_spinner_dropdown_item);
        mSpinner17.setAdapter(adapter17);

        //setting values for hose 1
        mSpinner.setOnItemSelectedListener(this);
        mSpinner1.setOnItemSelectedListener(this);
        mSpinner2.setOnItemSelectedListener(this);
        mSpinner3.setOnItemSelectedListener(this);
        mSpinner4.setOnItemSelectedListener(this);
        mSpinner5.setOnItemSelectedListener(this);
        //setting values for hose 2
        mSpinner6.setOnItemSelectedListener(this);
        mSpinner7.setOnItemSelectedListener(this);
        mSpinner8.setOnItemSelectedListener(this);
        mSpinner9.setOnItemSelectedListener(this);
        mSpinner10.setOnItemSelectedListener(this);
        mSpinner11.setOnItemSelectedListener(this);
        //setting values for hose 3
        mSpinner12.setOnItemSelectedListener(this);
        mSpinner13.setOnItemSelectedListener(this);
        mSpinner14.setOnItemSelectedListener(this);
        mSpinner15.setOnItemSelectedListener(this);
        mSpinner16.setOnItemSelectedListener(this);
        mSpinner17.setOnItemSelectedListener(this);

        //need to set up if statement to calculate greatest value of results for resultTextView
        mButton = (Button)findViewById(R.id.calculateButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText(String.valueOf(result()));
                resultTextView2.setText(String.valueOf(result2()));
                resultTextView3.setText(String.valueOf(result3()));
                if ((result() > result2()) && (result() > result3())){
                    resultTextView4.setText(String.valueOf(result()));
                }
                else if((result2() > result()) && (result2() > result3())){
                    resultTextView4.setText(String.valueOf(result2()));
                }
                else {
                    resultTextView4.setText(String.valueOf(result3()));
                }
            }
        });

        mResetButton = (Button)findViewById(R.id.resetButton);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        resultTextView = (TextView)findViewById(R.id.resultTextView);
        resultTextView2 = (TextView)findViewById(R.id.resultTextView2);
        resultTextView3 = (TextView)findViewById(R.id.resultTextView3);
        resultTextView4 = (TextView)findViewById(R.id.resultTextView4);
    }

    //Method that determines if User clicked Save Button
    public boolean userInfoSet(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        boolean userclicksave = sharedPreferences.getBoolean("userclicksave", true);
        return userclicksave;
    }

    //Dialog Fragment method
    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "alert_dialog");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //getting spinner selections hose 1
        mItem = mSpinner.getSelectedItemId();
        mItem1 = mSpinner1.getSelectedItemId();
        mItem2 = mSpinner2.getSelectedItemId();
        mItem3 = mSpinner3.getSelectedItemId();
        mItem4 = mSpinner4.getSelectedItemId();
        mItem5 = mSpinner5.getSelectedItemId();
        //getting spinner selections hose 2
        mItem6 = mSpinner6.getSelectedItemId();
        mItem7 = mSpinner7.getSelectedItemId();
        mItem8 = mSpinner8.getSelectedItemId();
        mItem9 = mSpinner9.getSelectedItemId();
        mItem10 = mSpinner10.getSelectedItemId();
        mItem11 = mSpinner11.getSelectedItemId();
        //getting spinner selections hose 3
        mItem12 = mSpinner12.getSelectedItemId();
        mItem13 = mSpinner13.getSelectedItemId();
        mItem14 = mSpinner14.getSelectedItemId();
        mItem15 = mSpinner15.getSelectedItemId();
        mItem16 = mSpinner16.getSelectedItemId();
        mItem17 = mSpinner17.getSelectedItemId();
    }

    //retrieve user friction loss values from shared preferences set to methods used below
    public int resultHandFog(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info = sharedPreferences.getInt("handfog", 0);
        return info;
    }
    public int resultHandSmooth(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info1 = sharedPreferences.getInt("handsmooth", 0);
        return info1;
    }
    public int resultFog(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info2 = sharedPreferences.getInt("fog", 0);
        return info2;
    }
    public int resultSmooth(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info3 = sharedPreferences.getInt("smooth", 0);
        return info3;
    }
    public int resultBlitzFog(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info4 = sharedPreferences.getInt("blitzfog", 0);
        return info4;
    }
    public int resultBlitzSmooth(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info5 = sharedPreferences.getInt("blitzsmooth", 0);
        return info5;
    }
    public int resultHandline(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info6 = sharedPreferences.getInt("handline", 0);
        return info6;
    }
    public int resultHandline2(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info7 = sharedPreferences.getInt("handline2", 0);
        return info7;
    }
    public int resultHandline3(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info8 = sharedPreferences.getInt("handline3", 0);
        return info8;
    }
    public int resultAppliance(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info9 = sharedPreferences.getInt("appliance", 0);
        return info9;
    }
    public int resultElevation(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        int info10 = sharedPreferences.getInt("elevation", 0);
        return info10;
    }

    //hose 1 calculation method
    public int result(){
        int n1 = resultHandFog();
        int n2 = resultHandSmooth();
        int n3 = resultFog();
        int n4 = resultSmooth();
        int n5 = resultBlitzFog();
        int n6 = resultBlitzSmooth();
        int [] fLossArray = {0, n1, n2, n3, n4, n5, n6};
        mFLoss = fLossArray[mItem.intValue()];

        int hl = resultHandline();
        int h2 = resultHandline2();
        int h3 = resultHandline3();
        int app = resultAppliance();
        int elev = resultElevation();
        int [] fLossArray1 = {0,1,2,3,4,5,6,7,8,9,10};
        int [] fLossArray2 = {0,0,1,2,3,4,5,6,7,8,9};

        int mmFLoss1 = fLossArray1[mItem1.intValue()];
        mFLoss1 = hl * mmFLoss1;
        int mmFLoss2 = fLossArray1[mItem2.intValue()];
        mFLoss2 = h2 * mmFLoss2;
        int mmFLoss3 = fLossArray1[mItem3.intValue()];
        mFLoss3 = h3 * mmFLoss3;
        int mmFLoss4 = fLossArray1[mItem4.intValue()];
        mFLoss4 = app * mmFLoss4;
        int mmFLoss5 = fLossArray2[mItem5.intValue()];
        mFLoss5 = elev * mmFLoss5;
        mValue = (mFLoss + mFLoss1 + mFLoss2 + mFLoss3 + mFLoss4 + mFLoss5);
        return mValue;
    }
    //hose 2 calculation method
    public int result2(){
        int n1 = resultHandFog();
        int n2 = resultHandSmooth();
        int n3 = resultFog();
        int n4 = resultSmooth();
        int n5 = resultBlitzFog();
        int n6 = resultBlitzSmooth();
        int [] fLossArray = {0, n1, n2, n3, n4, n5, n6};
        mFLoss6 = fLossArray[mItem6.intValue()];

        int hl = resultHandline();
        int h2 = resultHandline2();
        int h3 = resultHandline3();
        int app = resultAppliance();
        int elev = resultElevation();
        int [] fLossArray1 = {0,1,2,3,4,5,6,7,8,9,10};
        int [] fLossArray2 = {0,0,1,2,3,4,5,6,7,8,9};

        int mmFLoss1 = fLossArray1[mItem7.intValue()];
        mFLoss7 = hl * mmFLoss1;
        int mmFLoss2 = fLossArray1[mItem8.intValue()];
        mFLoss8 = h2 * mmFLoss2;
        int mmFLoss3 = fLossArray1[mItem9.intValue()];
        mFLoss9 = h3 * mmFLoss3;
        int mmFLoss4 = fLossArray1[mItem10.intValue()];
        mFLoss10 = app * mmFLoss4;
        int mmFLoss5 = fLossArray2[mItem11.intValue()];
        mFLoss11 = elev * mmFLoss5;
        mValue2 = (mFLoss6 + mFLoss7 + mFLoss8 + mFLoss9 + mFLoss10 + mFLoss11);
        return mValue2;
    }
    //hose 3 calculation method
    public int result3(){
        int n1 = resultHandFog();
        int n2 = resultHandSmooth();
        int n3 = resultFog();
        int n4 = resultSmooth();
        int n5 = resultBlitzFog();
        int n6 = resultBlitzSmooth();
        int [] fLossArray = {0, n1, n2, n3, n4, n5, n6};
        mFLoss12 = fLossArray[mItem12.intValue()];

        int hl = resultHandline();
        int h2 = resultHandline2();
        int h3 = resultHandline3();
        int app = resultAppliance();
        int elev = resultElevation();
        int [] fLossArray1 = {0,1,2,3,4,5,6,7,8,9,10};
        int [] fLossArray2 = {0,0,1,2,3,4,5,6,7,8,9};

        int mmFLoss1 = fLossArray1[mItem13.intValue()];
        mFLoss13 = hl * mmFLoss1;
        int mmFLoss2 = fLossArray1[mItem14.intValue()];
        mFLoss14 = h2 * mmFLoss2;
        int mmFLoss3 = fLossArray1[mItem15.intValue()];
        mFLoss15 = h3 * mmFLoss3;
        int mmFLoss4 = fLossArray1[mItem16.intValue()];
        mFLoss16 = app * mmFLoss4;
        int mmFLoss5 = fLossArray2[mItem17.intValue()];
        mFLoss17 = elev * mmFLoss5;
        mValue3 = (mFLoss12 + mFLoss13 + mFLoss14 + mFLoss15 + mFLoss16 + mFLoss17);
        return mValue3;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
