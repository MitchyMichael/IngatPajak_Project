package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class input_pph extends AppCompatActivity {

    Button button_lanjut_inputPPh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pph);
        initView();

        button_lanjut_inputPPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), output_pph.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        button_lanjut_inputPPh = findViewById(R.id.button_lanjut_inputPPh);
    }
}