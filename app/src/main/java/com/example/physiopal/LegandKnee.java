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

public class LegandKnee extends AppCompatActivity {

    //Step1
    Button myqsBT, myslrBT, myhsBT, mysuBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_legand_knee);
        //Step 2
        myqsBT = findViewById(R.id.qsBT);
        myslrBT = findViewById(R.id.slrBT);
        myhsBT = findViewById(R.id.hsBT);
        mysuBT = findViewById(R.id.suBT);

        //Step 3 for myqsBT
        myqsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), QuadSet.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myslrBT
        myslrBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), StraightLegRaise.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myhsBT
        myhsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), HeelSlide.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mysuBT
        mysuBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), StepUp.class);
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