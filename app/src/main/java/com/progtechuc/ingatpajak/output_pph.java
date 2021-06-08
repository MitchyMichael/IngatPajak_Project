package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class output_pph extends AppCompatActivity {

    private TextView outputPPH_penghasilanBruto, outputPPH_biayaJabatan, outputPPH_jumlahPengurang,
            outputPPH_penghasilanNeto, outputPPH_penghasilanNetoSetahun, outputPPH_ptkp,
            outputPPH_pkpSetahun, outputPPH_pphTerutang;

    private Button button_menu_outputPPh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_pph);
        initView();
        textChange();

        buttonMenu();


    }

    private void textChange() {
        Intent intent1 = getIntent();
        outputPPH_penghasilanBruto.setText(intent1.getStringExtra("penghasilanBruto"));
        outputPPH_biayaJabatan.setText(intent1.getStringExtra("biayaJabatan"));
        outputPPH_jumlahPengurang.setText(intent1.getStringExtra("totalPengeluaran"));
        outputPPH_penghasilanNeto.setText(intent1.getStringExtra("penghasilanNetoSebulan"));
        outputPPH_penghasilanNetoSetahun.setText(intent1.getStringExtra("penghasilanNetoSetahun"));
        outputPPH_ptkp.setText(intent1.getStringExtra("totalPTKP"));
        outputPPH_pkpSetahun.setText(intent1.getStringExtra("PKPsetahun"));
        outputPPH_pphTerutang.setText(intent1.getStringExtra("pajakTerutang"));

    }

    private void buttonMenu() {
        button_menu_outputPPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        button_menu_outputPPh = findViewById(R.id.button_menu_outputPPh);
        outputPPH_penghasilanBruto = findViewById(R.id.outputPPH_penghasilanBruto);
        outputPPH_biayaJabatan = findViewById(R.id.outputPPH_biayaJabatan);
        outputPPH_jumlahPengurang = findViewById(R.id.outputPPH_jumlahPengurang);
        outputPPH_penghasilanNeto = findViewById(R.id.outputPPH_penghasilanNeto);
        outputPPH_penghasilanNetoSetahun = findViewById(R.id.outputPPH_penghasilanNetoSetahun);
        outputPPH_ptkp = findViewById(R.id.outputPPH_ptkp);
        outputPPH_pkpSetahun = findViewById(R.id.outputPPH_pkpSetahun);
        outputPPH_pphTerutang = findViewById(R.id.outputPPH_pphTerutang);
    }
}