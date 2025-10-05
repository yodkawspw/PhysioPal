package com.example.physiopal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EWH extends AppCompatActivity {

    //Step 1
    Button mywfBT, myfcBT, mywrBT, myfpsBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ewh);
        //Step 2
        mywfBT = findViewById(R.id.wfBT);
        myfcBT = findViewById(R.id.fcBT);
        mywrBT = findViewById(R.id.wrBT);
        myfpsBT = findViewById(R.id.fpsBT);

        //Step 3 for mywfBT
        mywfBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), WristFlexor.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myfcBT
        myfcBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), FistClench.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mywrBT
        mywrBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), WristRotation.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myfpsBT
        myfpsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ForearmPS.class);
                startActivity(myintent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}