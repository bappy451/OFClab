package com.example.ofc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Loss extends AppCompatActivity {

    public void reset(View view){
        EditText lossPerKm = (EditText) findViewById(R.id.txtDiameter);
        lossPerKm.setText("");

        EditText cableDistance = (EditText) findViewById(R.id.txtLength);
        cableDistance.setText("");

        EditText connectorLoss = (EditText) findViewById(R.id.txtIndexN1);
        connectorLoss.setText("");

        EditText noOfConnectors = (EditText) findViewById(R.id.txtIndexN2);
        noOfConnectors.setText("");

        EditText spliceLoss = (EditText) findViewById(R.id.txtSpliceLoss);
        spliceLoss.setText("");

        EditText noOfSplice = (EditText) findViewById(R.id.txtNoOfSplices);
        noOfSplice.setText("");

        TextView txtTotalFibelossResult = (TextView) findViewById(R.id.totalFiberLossResult);
        txtTotalFibelossResult.setVisibility(View.GONE);

        TextView txtTotalSplicelossResult = (TextView) findViewById(R.id.totalSpliceLossResult);
        txtTotalSplicelossResult.setVisibility(View.GONE);

        TextView txtTotalConnectionlossResult = (TextView) findViewById(R.id.totalConnectorLossResult);
        txtTotalConnectionlossResult.setVisibility(View.GONE);

        TextView txtTotalResult = (TextView) findViewById(R.id.totalLossResult);
        txtTotalResult.setVisibility(View.GONE);

        TextView txtTotalFiberloss = (TextView) findViewById(R.id.totalFiberLoss) ;
        txtTotalFiberloss.setVisibility(View.GONE);

        TextView txtTotalSplice = (TextView) findViewById(R.id.totalSpliceLoss);
        txtTotalSplice.setVisibility(View.GONE);

        TextView txtTotalConnection = (TextView) findViewById(R.id.totalConnectorLoss);
        txtTotalConnection.setVisibility(View.GONE);

        TextView txtTotal = (TextView) findViewById(R.id.totalLoss);
        txtTotal.setVisibility(View.GONE);
    }

    public void calculate(View view){
        double lossperkm = 0;
        double cabledistance = 0;
        double connectorloss = 0;
        double noofconnectors = 0;
        double spliceloss = 0;
        double noofsplice = 0;
        EditText lossPerKm = (EditText) findViewById(R.id.txtDiameter);
        String lossPerKmS = lossPerKm.getText().toString();
        lossperkm = Double.parseDouble(lossPerKmS);

        EditText cableDistance = (EditText) findViewById(R.id.txtLength);
        String cableDistanceS = cableDistance.getText().toString();
        cabledistance = Double.parseDouble(cableDistanceS);

        EditText connectorLoss = (EditText) findViewById(R.id.txtIndexN1);
        String connectorLossS = connectorLoss.getText().toString();
        connectorloss = Double.parseDouble(connectorLossS);

        EditText noOfConnectors = (EditText) findViewById(R.id.txtIndexN2);
        String noOfConnectorsS = noOfConnectors.getText().toString();
        noofconnectors = Double.parseDouble(noOfConnectorsS);

        EditText spliceLoss = (EditText) findViewById(R.id.txtSpliceLoss);
        String spliceLossS = spliceLoss.getText().toString();
        spliceloss = Double.parseDouble(spliceLossS);

        EditText noOfSplice = (EditText) findViewById(R.id.txtNoOfSplices);
        String noOfspliceS = noOfSplice.getText().toString();
        noofsplice = Double.parseDouble(noOfspliceS);

        double totalFiberLoss = 0;
        double totalConnectrLoss = 0;
        double totalSpliceLoss = 0;
        double totalLinkLoss = 0;

        totalFiberLoss = lossperkm * cabledistance;
        totalConnectrLoss = connectorloss * noofconnectors;
        totalSpliceLoss = spliceloss * noofsplice;
        totalLinkLoss = totalFiberLoss + totalConnectrLoss + totalSpliceLoss;

        Log.i("Amount is: ", Double.toString(totalFiberLoss));

        TextView txtTotalFiberloss = (TextView) findViewById(R.id.totalFiberLoss);
        txtTotalFiberloss.setVisibility(View.VISIBLE);
        txtTotalFiberloss.setText("Total fiber loss: ");
        TextView txtTotalFibelossResult = (TextView) findViewById(R.id.totalFiberLossResult);
        txtTotalFibelossResult.setVisibility(View.VISIBLE);
        txtTotalFibelossResult.setText(Double.toString(totalFiberLoss)+" dB");

        TextView txtTotalSplice = (TextView) findViewById(R.id.totalSpliceLoss);
        txtTotalSplice.setVisibility(View.VISIBLE);
        txtTotalSplice.setText("Total splice loss: ");
        TextView txtTotalSplicelossResult = (TextView) findViewById(R.id.totalSpliceLossResult);
        txtTotalSplicelossResult.setVisibility(View.VISIBLE);
        txtTotalSplicelossResult.setText(Double.toString(totalSpliceLoss)+" dB");

        TextView txtTotalConnection = (TextView) findViewById(R.id.totalConnectorLoss);
        txtTotalConnection.setVisibility(View.VISIBLE);
        txtTotalConnection.setText("Total connection loss: ");
        TextView txtTotalConnectionlossResult = (TextView) findViewById(R.id.totalConnectorLossResult);
        txtTotalConnectionlossResult.setVisibility(View.VISIBLE);
        txtTotalConnectionlossResult.setText(Double.toString(totalConnectrLoss)+ " dB");

        TextView txtTotal = (TextView) findViewById(R.id.totalLoss);
        txtTotal.setVisibility(View.VISIBLE);
        txtTotal.setText("Total connection loss: ");
        TextView txtTotalResult = (TextView) findViewById(R.id.totalLossResult);
        txtTotalResult.setVisibility(View.VISIBLE);
        txtTotalResult.setText(Double.toString(totalLinkLoss)+ " dB");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);
    }
}
