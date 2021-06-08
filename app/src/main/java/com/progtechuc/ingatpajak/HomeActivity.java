package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button button_PPh, button_PBB, button_PPN, button_Keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

        button_PPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getBaseContext(), input_pph.class);
                startActivity(intent);
            }
        });

        button_Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        button_PBB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getBaseContext(), PbbActivity.class);
                startActivity(intent);
            }
        });

        button_PPN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getBaseContext(), PPN_BMActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        button_PPh = findViewById(R.id.button_PPh);
        button_PBB = findViewById(R.id.button_PBB);
        button_PPN = findViewById(R.id.button_PPN);
        button_Keluar = findViewById(R.id.button_Keluar);
    }
}