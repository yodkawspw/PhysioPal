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

public class ShoulderandArm extends AppCompatActivity {

    //Step 1
    Button mysrBT, mywwBT, mybcBT, mytsBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shoulderand_arm);
        //Step 2
        mysrBT = findViewById(R.id.srBT);
        mywwBT = findViewById(R.id.wwBT);
        mybcBT = findViewById(R.id.bcBT);
        mytsBT = findViewById(R.id.tsBT);

        //Step 3 for mysrBT
        mysrBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ShoulderRoll.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mywwBT
        mywwBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), WallWalk.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mybcBT
        mybcBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), BicepCurl.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mytsBT
        mytsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), TricepsStretch.class);
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