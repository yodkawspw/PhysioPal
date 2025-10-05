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

public class HipandPelvis extends AppCompatActivity {

    //Step 1
    Button myhfBT, mygbBT, myclamsBT, mypelvictBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hipand_pelvis);
        //Step 2
        myhfBT = findViewById(R.id.hfBT);
        mygbBT = findViewById(R.id.gbBT);
        myclamsBT = findViewById(R.id.clamsBT);
        mypelvictBT = findViewById(R.id.pelvictBT);

        //Step 3 for myhfBT
        myhfBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), HipFlexor.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mygbBT
        mygbBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), GluteBridge.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myclamsBT
        myclamsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), Clamshell.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mypelvictBT
        mypelvictBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), PelvicTilt.class);
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