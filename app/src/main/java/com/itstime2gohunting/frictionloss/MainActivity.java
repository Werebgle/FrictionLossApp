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

    private Spinner mSpinner;
    private Spinner mSpinner1;
    private Spinner mSpinner2;
    private Spinner mSpinner3;
    private Spinner mSpinner4;
    private Spinner mSpinner5;

    private int mValue = 0;

    private Long mItem;
    private Long mItem1;
    private Long mItem2;
    private Long mItem3;
    private Long mItem4;
    private Long mItem5;

    private int mFLoss = 0;
    private int mFLoss1 = 0;
    private int mFLoss2 = 0;
    private int mFLoss3 = 0;
    private int mFLoss4 = 0;
    private int mFLoss5 = 0;

    private Button mButton;
    private Button mResetButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calls Alert Dialog Fragment if User has not clicked Save Button in Settings.
        if (userInfoSet()){
            alertUser();
        }

        mSpinner = (Spinner)findViewById(R.id.nozzleSpinner);
        mSpinner1 = (Spinner)findViewById(R.id.hose1Spinner);
        mSpinner2 = (Spinner)findViewById(R.id.hose2Spinner);
        mSpinner3 = (Spinner)findViewById(R.id.hose3Spinner);
        mSpinner4 = (Spinner)findViewById(R.id.applianceSpinner);
        mSpinner5 = (Spinner)findViewById(R.id.floorSpinner);

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

        mSpinner.setOnItemSelectedListener(this);
        mSpinner1.setOnItemSelectedListener(this);
        mSpinner2.setOnItemSelectedListener(this);
        mSpinner3.setOnItemSelectedListener(this);
        mSpinner4.setOnItemSelectedListener(this);
        mSpinner5.setOnItemSelectedListener(this);

        mButton = (Button)findViewById(R.id.calculateButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText(String.valueOf(result()));
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
    }

    //Method that determines if User clicked Save Button
    public boolean userInfoSet(){
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        boolean info11 = sharedPreferences.getBoolean("userclicksave", true);
        return info11;
    }

    //Dialog Fragment method
    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "alert_dialog");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mItem = mSpinner.getSelectedItemId();
        mItem1 = mSpinner1.getSelectedItemId();
        mItem2 = mSpinner2.getSelectedItemId();
        mItem3 = mSpinner3.getSelectedItemId();
        mItem4 = mSpinner4.getSelectedItemId();
        mItem5 = mSpinner5.getSelectedItemId();
    }

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
