package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;

public class input_pph extends AppCompatActivity {

    private RadioButton radio_statusNPWP_NPWP, radio_statusNPWP_nonNPWP, radio_statusKawin_TK,
            radio_statusKawin_K, radio_statusKawin_HB, radio_jumlahTanggungan_0,
            radio_jumlahTanggungan_1, radio_jumlahTanggungan_2, radio_jumlahTanggungan_3;
    private TextInputLayout inputPPH_pendapatanPerBulan, inputPPH_tunjanganPPH, inputPPH_tunjanganLainnya,
            inputPPH_imbalanLainnya, inputPPH_premiAsuransi, inputPPH_natura, inputPPH_bonus,
            inputPPH_iuranPensiun;
    private Button button_lanjut_inputPPh;
    private int jumlahTanggungan, statusKawin, npwp;

    private int pendapatanPerBulan, tunjanganPPh, tunjanganLainnya, imbalanLainnya, premiAsuransi,
            natura, bonus, iuranPensiun;

    private int penghasilanBruto, biayaJabatan, totalPengeluaran, penghasilanNetoSebulan,
            penghasilanNetoSetahun, totalPTKP, PKPsetahun, jumlahPajak, pajakTerutang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pph);
        initView();

        //input
        inputNPWP();
        inputStatusKawin();
        inputJumlahTanggungan();
        inputPenghasilan();
        inputPengurangan();

        //hitung
        hitung();

        buttonContinue();

    }

    private void hitung() {
        penghasilanBruto = pendapatanPerBulan + tunjanganPPh + tunjanganLainnya +
                imbalanLainnya + premiAsuransi + natura + bonus;
        biayaJabatan = penghasilanBruto * 5 / 100;
        totalPengeluaran = biayaJabatan + iuranPensiun;
        penghasilanNetoSebulan = penghasilanBruto - totalPengeluaran;
        penghasilanNetoSetahun = penghasilanNetoSebulan * 12;
        totalPTKP = statusKawin + jumlahTanggungan;
        PKPsetahun = penghasilanNetoSetahun - totalPTKP;

        if (PKPsetahun <= 50000000){
            jumlahPajak = PKPsetahun * 5 / 100;
        } else if (PKPsetahun <= 250000000){
            int temp1 = 50000000 * 5 / 100;
            int temp2 = (PKPsetahun - 50000000) * 15 / 100;
            jumlahPajak = temp1 + temp2;
        } else if (PKPsetahun <= 500000000){
            int temp1 = 50000000 * 5 / 100;
            int temp2 = 200000000 * 15 / 100;
            int temp3 = (PKPsetahun - 250000000) * 25 / 100;
            jumlahPajak = temp1 + temp2 + temp3;
        } else if (PKPsetahun > 500000000){
            int temp1 = 50000000 * 5 / 100;
            int temp2 = 200000000 * 15 / 100;
            int temp3 = 250000000 * 25 / 100;
            int temp4 = (PKPsetahun - 500000000) * 30 / 100;
            jumlahPajak = temp1 + temp2 + temp3 + temp4;
        }

        pajakTerutang = jumlahPajak * npwp / 100;

    }

    private void inputPengurangan() {
        iuranPensiun = Integer.valueOf(inputPPH_iuranPensiun.getEditText().
                getText().toString().trim());
    }

    private void inputPenghasilan() {
        pendapatanPerBulan = Integer.valueOf(inputPPH_pendapatanPerBulan.getEditText().
                getText().toString().trim());
        tunjanganPPh = Integer.valueOf(inputPPH_tunjanganPPH.getEditText().
                getText().toString().trim());
        tunjanganLainnya = Integer.valueOf(inputPPH_tunjanganLainnya.getEditText().
                getText().toString().trim());
        imbalanLainnya = Integer.valueOf(inputPPH_imbalanLainnya.getEditText().
                getText().toString().trim());
        premiAsuransi = Integer.valueOf(inputPPH_premiAsuransi.getEditText().
                getText().toString().trim());
        natura = Integer.valueOf(inputPPH_natura.getEditText().
                getText().toString().trim());
        bonus = Integer.valueOf(inputPPH_bonus.getEditText().
                getText().toString().trim());
    }

    private void inputJumlahTanggungan() {
        radio_jumlahTanggungan_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumlahTanggungan = 0;
            }
        });

        radio_jumlahTanggungan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahTanggungan = 4500000;
            }
        });

        radio_jumlahTanggungan_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 jumlahTanggungan = 4500000*2;
            }
        });

        radio_jumlahTanggungan_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumlahTanggungan = 4500000*3;
            }
        });

    }

    private void inputStatusKawin() {
        radio_statusKawin_TK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                statusKawin = 54000000;
            }
        });

        radio_statusKawin_K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 statusKawin = 58500000;
            }
        });

        radio_statusKawin_HB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 statusKawin = 54000000;
            }
        });
    }

    private void inputNPWP() {

        radio_statusNPWP_NPWP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 npwp = 100;
            }
        });

        radio_statusNPWP_nonNPWP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 npwp = 120;
            }
        });
    }


    private void buttonContinue() {
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
        radio_statusNPWP_NPWP = findViewById(R.id.radio_statusNPWP_NPWP);
        radio_statusNPWP_nonNPWP = findViewById(R.id.radio_statusNPWP_nonNPWP);
        radio_statusKawin_TK = findViewById(R.id.radio_statusKawin_TK);
        radio_statusKawin_K = findViewById(R.id.radio_statusKawin_K);
        radio_statusKawin_HB = findViewById(R.id.radio_statusKawin_HB);
        radio_jumlahTanggungan_0 = findViewById(R.id.radio_jumlahTanggungan_0);
        radio_jumlahTanggungan_1 = findViewById(R.id.radio_jumlahTanggungan_1);
        radio_jumlahTanggungan_2 = findViewById(R.id.radio_jumlahTanggungan_2);
        radio_jumlahTanggungan_3 = findViewById(R.id.radio_jumlahTanggungan_3);
        inputPPH_pendapatanPerBulan = findViewById(R.id.inputPPH_pendapatanPerBulan);
        inputPPH_tunjanganPPH = findViewById(R.id.inputPPH_tunjanganPPH);
        inputPPH_tunjanganLainnya = findViewById(R.id.inputPPH_tunjanganLainnya);
        inputPPH_imbalanLainnya = findViewById(R.id.inputPPH_imbalanLainnya);
        inputPPH_premiAsuransi = findViewById(R.id.inputPPH_premiAsuransi);
        inputPPH_natura = findViewById(R.id.inputPPH_natura);
        inputPPH_bonus = findViewById(R.id.inputPPH_bonus);
        inputPPH_iuranPensiun = findViewById(R.id.inputPPH_iuranPensiun);


    }
}