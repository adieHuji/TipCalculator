package com.adie.tipcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText amount = (EditText) findViewById(R.id.edtBillAmount);
                String amountSTR = amount.getText().toString();
                TextView tip = (TextView) findViewById(R.id.txtTipResult);
                if(amountSTR.isEmpty())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Alert")
                            .setMessage("Please enter the bill amount.")
                            .setNeutralButton("OK", null);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else
                {
                    double amountNum = Double.parseDouble(amountSTR);
                    CheckBox round = (CheckBox)findViewById(R.id.chkRound);
                    if(round.isChecked()){
                        int amountRound = (int) Math.ceil((amountNum*12)/100);
                        tip.setText("Tip: "+amountRound+"$");


                    }
                    else{
                        double amountNotRound = ((amountNum*12)/100);
                        tip.setText("Tip: "+amountNotRound+"$");
                    }
                }

            }
        });
    }
}
