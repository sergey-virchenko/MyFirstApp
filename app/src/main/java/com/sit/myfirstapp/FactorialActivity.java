package com.sit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

import static com.sit.myfirstapp.FactorialCalculus.factorial;
import static com.sit.myfirstapp.FactorialCalculus.factorialRec;

public class FactorialActivity extends AppCompatActivity {

    private TextView result;
    private EditText input;
    private RelativeLayout progress;
    private Button btnFastFactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        result = findViewById(R.id.result);
        input = findViewById(R.id.input);
        progress = findViewById(R.id.progress);
        btnFastFactorial = findViewById(R.id.btnFastFactorial);

        btnFastFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = input.getText().toString();
                result.setText(factorial(new BigInteger(inputString)).toString());
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (progress != null && progress.getVisibility() == View.VISIBLE) {
            progress.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}
