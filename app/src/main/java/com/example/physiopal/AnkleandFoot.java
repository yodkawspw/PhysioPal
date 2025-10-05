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

public class AnkleandFoot extends AppCompatActivity {

    //Step 1
    Button myacBT, mytcBT, myhtrBT, myrbaBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ankleand_foot);
        //Step2
        myacBT = findViewById(R.id.acBT);
        mytcBT = findViewById(R.id.tcBT);
        myhtrBT = findViewById(R.id.htrBT);
        myrbaBT = findViewById(R.id.rbaBT);

        //Step 3 for myacBT
        myacBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), AnkleCircles.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mytcBT
        mytcBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ToeCurls.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myhtrBT
        myhtrBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), HeelToeRaises.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myrbaBT
        myrbaBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ResistanceBandAnkle.class);
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