package com.example.ofc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void rest(View view){
        EditText txtDiameter = (EditText) findViewById(R.id.txtDiameter);
        txtDiameter.setText("");

        EditText txtLength = (EditText) findViewById(R.id.txtLength);
        txtLength.setText("");

        TextView txtNAResult = (TextView) findViewById(R.id.txtNAResult);
        txtNAResult.setVisibility(View.GONE);

        EditText txtIndexN1 = (EditText) findViewById(R.id.txtIndexN1);
        txtIndexN1.setText("");

        EditText txtIndexN2 = (EditText) findViewById(R.id.txtIndexN2);
        txtIndexN2.setText("");

        TextView txtFINDResult = (TextView) findViewById(R.id.txtFINDResult);
        txtFINDResult.setVisibility(View.GONE);

        EditText na = (EditText) findViewById(R.id.txtNoOfSplices);
        na.setText("");

        EditText a = (EditText) findViewById(R.id.txtSpliceLoss);
        a.setText("");

        EditText txtLamda = (EditText) findViewById(R.id.txtLamda);
        txtLamda.setText("");

        TextView txtResult = (TextView) findViewById(R.id.txtVNResult);
        txtResult.setVisibility(View.GONE);
    }

    public void calculteNA(View view){
        Double diameterD = 0.0;
        Double lengthD = 0.0;
        Double result = 0.0;

        EditText txtDiameter = (EditText) findViewById(R.id.txtDiameter);
        String diameter = txtDiameter.getText().toString();
        diameterD = Double.parseDouble(diameter);

        EditText txtLength = (EditText) findViewById(R.id.txtLength);
        String length = txtLength.getText().toString();
        lengthD = Double.parseDouble(length);

        result = diameterD/(lengthD*2);

        TextView txtNAResult = (TextView) findViewById(R.id.txtNAResult);
        txtNAResult.setVisibility(View.VISIBLE);
        txtNAResult.setText("Neumerial Apperature: " + result);
    }

    public void calculteFID(View view){
        Double indexN1D = 0.0;
        Double indexN2D = 0.0;
        Double result = 0.0;

        EditText txtIndexN1 = (EditText) findViewById(R.id.txtIndexN1);
        String indexN1 = txtIndexN1.getText().toString();
        indexN1D = Double.parseDouble(indexN1);

        EditText txtIndexN2 = (EditText) findViewById(R.id.txtIndexN2);
        String indexN2 = txtIndexN2.getText().toString();
        indexN2D = Double.parseDouble(indexN2);

        result = (indexN1D*indexN1D)-(indexN2D*indexN2D)/(2*indexN1D*indexN1D);

        TextView txtFINDResult = (TextView) findViewById(R.id.txtFINDResult);
        txtFINDResult.setVisibility(View.VISIBLE);
        txtFINDResult.setText("Fractional Index Differnce: " + result);
    }

    public void calculteID(View view){
        Double aD = 0.0;
        Double NA = 0.0;
        Double lamdaD = 0.0;
        Double result = 0.0;

        EditText a = (EditText) findViewById(R.id.txtSpliceLoss);
        String aS = a.getText().toString();
        aD = Double.parseDouble(aS);

        EditText na = (EditText) findViewById(R.id.txtNoOfSplices);
        String naS = na.getText().toString();
        NA = Double.parseDouble(naS);

        EditText txtLamda = (EditText) findViewById(R.id.txtLamda);
        String txtLamdaS = txtLamda.getText().toString();
        lamdaD = Double.parseDouble(txtLamdaS);
        lamdaD = lamdaD/1000000000;

        result = (NA*2*3.1416)/lamdaD;



        TextView txtFINDResult = (TextView) findViewById(R.id.txtVNResult);
        txtFINDResult.setVisibility(View.VISIBLE);
        txtFINDResult.setText("V number: " + result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button labCalculation = (Button) findViewById(R.id.btnLabCalculations);
        labCalculation.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent labIntent = new Intent(v.getContext(), Loss.class);
                        startActivity(labIntent);
                    }
                }
        );
    }
}
