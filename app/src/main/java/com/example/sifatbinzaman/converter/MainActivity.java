package com.example.sifatbinzaman.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnConvert;
    private EditText etNumber;
    private TextView tvinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnConvert = findViewById(R.id.button);
        etNumber = findViewById(R.id.input);

        tvinfo = findViewById(R.id.info);


        final CheckBox meter2inch = (CheckBox) findViewById(R.id.chkMeter2Inch);
        final CheckBox kg2pound = (CheckBox) findViewById(R.id.chkKg2Pound);
        final CheckBox celcius2kelvin = (CheckBox) findViewById(R.id.chkCelcius2Kelvin);
        final CheckBox joule2calorie = (CheckBox) findViewById(R.id.chkJoule2Calorie);
        final CheckBox inch2foot = (CheckBox) findViewById(R.id.chkInch2Foot);
        final CheckBox dollar2euro = (CheckBox) findViewById(R.id.chkDollar2Euro);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int flag=0;
                tvinfo.setText("");
                try {


                    String a = etNumber.getText().toString();
                    double num = Double.parseDouble(a);
                    double ans;
                    tvinfo.setText("");

                    if (meter2inch.isChecked()) {
                        flag=1;
                        ans = 39.3701 * num;
                        tvinfo.append(a + " meters = " + String.format("%.2f", ans) + " inches.\n");
                    }
                    if (kg2pound.isChecked()) {
                        flag=1;
                        ans = 2.20462 * num;
                        tvinfo.append(a + " kg = " + String.format("%.2f", ans) + " pounds.\n");
                    }
                    if (celcius2kelvin.isChecked()) {
                        flag=1;
                        ans = 273.15 + num;
                        tvinfo.append(a + " degree Celcius = " + String.format("%.2f", ans) + " Kelvin.\n");
                    }
                    if (dollar2euro.isChecked()) {
                        flag=1;
                        ans = 0.87 * num;
                        tvinfo.append(a + " Dollars = " + String.format("%.2f", ans) + " Euroes.\n");
                    }
                    if (joule2calorie.isChecked()) {
                        flag=1;
                        ans = 1 / 4.18 * num;
                        tvinfo.append(a + " Joules = " + String.format("%.2f", ans) + " Calories.\n");
                    }
                    if (inch2foot.isChecked()) {
                        flag=1;
                        ans = 0.0833333 * num;
                        tvinfo.append(a + " inch = " + String.format("%.2f", ans) + " foot.\n");
                    }
                    if(tvinfo.getText()=="")
                    {
                        Toast.makeText(MainActivity.this,"Please Check an option",Toast.LENGTH_SHORT).show();
                    }
                    else if(flag==0)
                    {
                        Toast.makeText(MainActivity.this,"Please Check an option",Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Please Enter a number at first",Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}
