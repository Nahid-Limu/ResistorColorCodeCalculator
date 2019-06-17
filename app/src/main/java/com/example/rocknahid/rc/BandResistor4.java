package com.example.rocknahid.rc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class BandResistor4 extends AppCompatActivity {

    Spinner s1,s2,s3,s4;
    TextView reg;

    static int ColorArrayBand[] = {0,10,20,30,40,50,60,70,80,90};
    static int ColorArrayBand2[] = {0,1,2,3,4,5,6,7,8,9};
    static double ColorArrayMultiplier[] = {0,10,100,1000,10000,100000,1000000,.1,.01};
    static int ColorArrayTolerance[] = {0,1,2,5,10};

    long TotalResistance = 0;
    double Tolerance = 0.0;
    static String unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_resistor4);

        s1=(Spinner)findViewById(R.id.spin1Band4);
        s2=(Spinner)findViewById(R.id.spin2Band4);
        s3=(Spinner)findViewById(R.id.spinMultiply4);
        s4=(Spinner)findViewById(R.id.spinTolerance4);
        reg=(TextView)findViewById(R.id.txtVTotalResistance4);


        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateReg();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateReg();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateReg();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                updateReg();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void updateReg(){


       double band=0;

        band=(((ColorArrayBand[s1.getSelectedItemPosition()]+ColorArrayBand2[s2.getSelectedItemPosition()])*(int)ColorArrayMultiplier[s3.getSelectedItemPosition()]));

        if(band>=1000000){
            band=band/1000000;
            unit="M Ohms ";

        }

        else if(band>=1000){
            band=band/1000;
            unit="K Ohms ";

        }
        else if(band<1000){

            unit=" Ohms ";
        }
        reg.setText("Resistor Value: "+String.valueOf(band)+unit+"\n"+"Tolerance: "+ColorArrayTolerance[s4.getSelectedItemPosition()]+"%");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_band_resistor4, menu);
        return true;
    }


}
