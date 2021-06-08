package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

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

    private String pendapatanPerBulan, tunjanganPPh, tunjanganLainnya, imbalanLainnya, premiAsuransi,
            natura, bonus, iuranPensiun;

    private int pendapatanPerBulan_int, tunjanganPPh_int, tunjanganLainnya_int, imbalanLainnya_int, premiAsuransi_int,
            natura_int, bonus_int, iuranPensiun_int;

    private int penghasilanBruto, biayaJabatan, totalPengeluaran, penghasilanNetoSebulan,
            penghasilanNetoSetahun, totalPTKP, PKPsetahun, jumlahPajak, pajakTerutang;

    private boolean validatePendapatanPerBulan, validateTunjanganPPH, validateTunjanganLainnya,
            validateImbalanLainnya, validatePremiAsuransi, validateNatura, validateBonus, validateIuranPensiun;


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
        inputCek();

        //button
        buttonContinue();

    }

    private void inputCek() {
        inputPPH_pendapatanPerBulan.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pendapatanPerBulan_cek = inputPPH_pendapatanPerBulan.getEditText().
                        getText().toString().trim();

                if (pendapatanPerBulan_cek.isEmpty()){
                    inputPPH_pendapatanPerBulan.setError("Please fill this column!");
                    validatePendapatanPerBulan = false;
                } else {
                    inputPPH_pendapatanPerBulan.setError("");
                    validatePendapatanPerBulan = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_tunjanganPPH.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String tunjanganPPH_cek = inputPPH_tunjanganPPH.getEditText().
                        getText().toString().trim();

                if (tunjanganPPH_cek.isEmpty()){
                    inputPPH_tunjanganPPH.setError("Please fill this column!");
                    validateTunjanganPPH = false;
                } else {
                    inputPPH_tunjanganPPH.setError("");
                    validateTunjanganPPH = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_tunjanganLainnya.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String tunjanganLainnya_cek = inputPPH_tunjanganLainnya.getEditText().
                        getText().toString().trim();

                if (tunjanganLainnya_cek.isEmpty()){
                    inputPPH_tunjanganLainnya.setError("Please fill this column!");
                    validateTunjanganLainnya = false;
                } else {
                    inputPPH_tunjanganLainnya.setError("");
                    validateTunjanganLainnya = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_imbalanLainnya.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String imbalanLainnya_cek = inputPPH_imbalanLainnya.getEditText().
                        getText().toString().trim();

                if (imbalanLainnya_cek.isEmpty()){
                    inputPPH_imbalanLainnya.setError("Please fill this column!");
                    validateImbalanLainnya = false;
                } else {
                    inputPPH_imbalanLainnya.setError("");
                    validateImbalanLainnya = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_premiAsuransi.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String premiAsuransi_cek = inputPPH_premiAsuransi.getEditText().
                        getText().toString().trim();

                if (premiAsuransi_cek.isEmpty()){
                    inputPPH_premiAsuransi.setError("Please fill this column!");
                    validatePremiAsuransi = false;
                } else {
                    inputPPH_premiAsuransi.setError("");
                    validatePremiAsuransi = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_natura.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String natura_cek = inputPPH_natura.getEditText().
                        getText().toString().trim();

                if (natura_cek.isEmpty()){
                    inputPPH_natura.setError("Please fill this column!");
                    validateNatura = false;
                } else {
                    inputPPH_natura.setError("");
                    validateNatura = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_bonus.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String bonus_cek = inputPPH_bonus.getEditText().
                        getText().toString().trim();

                if (bonus_cek.isEmpty()){
                    inputPPH_bonus.setError("Please fill this column!");
                    validateBonus = false;
                } else {
                    inputPPH_bonus.setError("");
                    validateBonus = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputPPH_iuranPensiun.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String iuranPensiun_cek = inputPPH_iuranPensiun.getEditText().
                        getText().toString().trim();

                if (iuranPensiun_cek.isEmpty()){
                    inputPPH_iuranPensiun.setError("Please fill this column!");
                    validateIuranPensiun = false;
                } else {
                    inputPPH_iuranPensiun.setError("");
                    validateIuranPensiun = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void hitung() {

        pendapatanPerBulan_int = Integer.parseInt(inputPPH_pendapatanPerBulan.getEditText().getText().toString().trim());
        tunjanganPPh_int = Integer.parseInt(inputPPH_tunjanganPPH.getEditText().getText().toString().trim());
        tunjanganLainnya_int = Integer.parseInt(inputPPH_tunjanganLainnya.getEditText().getText().toString().trim());
        imbalanLainnya_int = Integer.parseInt(inputPPH_imbalanLainnya.getEditText().getText().toString().trim());
        premiAsuransi_int = Integer.parseInt(inputPPH_premiAsuransi.getEditText().getText().toString().trim());
        natura_int = Integer.parseInt(inputPPH_natura.getEditText().getText().toString().trim());
        bonus_int = Integer.parseInt(inputPPH_bonus.getEditText().getText().toString().trim());
        iuranPensiun_int = Integer.parseInt(inputPPH_iuranPensiun.getEditText().getText().toString().trim());

        penghasilanBruto = pendapatanPerBulan_int + tunjanganPPh_int + tunjanganLainnya_int +
                imbalanLainnya_int + premiAsuransi_int + natura_int + bonus_int;
        biayaJabatan = penghasilanBruto * 5 / 100;
        totalPengeluaran = biayaJabatan + iuranPensiun_int;
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
        iuranPensiun = inputPPH_iuranPensiun.getEditText().getText().toString().trim();
    }

    private void inputPenghasilan() {
        pendapatanPerBulan = inputPPH_pendapatanPerBulan.getEditText().getText().toString().trim();
        tunjanganPPh = inputPPH_tunjanganPPH.getEditText().getText().toString().trim();
        tunjanganLainnya = inputPPH_tunjanganLainnya.getEditText().getText().toString().trim();
        imbalanLainnya = inputPPH_imbalanLainnya.getEditText().getText().toString().trim();
        premiAsuransi = inputPPH_premiAsuransi.getEditText().getText().toString().trim();
        natura = inputPPH_natura.getEditText().getText().toString().trim();
        bonus = inputPPH_bonus.getEditText().getText().toString().trim();
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
                if(validatePendapatanPerBulan && validateTunjanganPPH && validateTunjanganLainnya &&
                        validateImbalanLainnya && validatePremiAsuransi && validateNatura && validateBonus &&
                        validateIuranPensiun){
                    hitung();
                    Intent intent = new Intent(getBaseContext(), output_pph.class);

                    intent.putExtra("penghasilanBruto", penghasilanBruto);
                    intent.putExtra("penghasilanBruto", biayaJabatan);
                    intent.putExtra("penghasilanBruto", totalPengeluaran);
                    intent.putExtra("penghasilanBruto", penghasilanNetoSebulan);
                    intent.putExtra("penghasilanBruto", penghasilanNetoSetahun);
                    intent.putExtra("penghasilanBruto", totalPTKP);
                    intent.putExtra("penghasilanBruto", PKPsetahun);
                    intent.putExtra("penghasilanBruto", pajakTerutang);

                    startActivity(intent);
                    finish();

                } else {

                    inputPPH_pendapatanPerBulan.setError("Please fill this column!");
                    inputPPH_tunjanganPPH.setError("Please fill this column!");
                    inputPPH_tunjanganLainnya.setError("Please fill this column!");
                    inputPPH_imbalanLainnya.setError("Please fill this column!");
                    inputPPH_premiAsuransi.setError("Please fill this column!");
                    inputPPH_natura.setError("Please fill this column!");
                    inputPPH_bonus.setError("Please fill this column!");
                    inputPPH_iuranPensiun.setError("Please fill this column!");

                    Toast.makeText(getApplicationContext(), "Please fill all the column above!",
                            Toast.LENGTH_SHORT).show();

                }


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

        validatePendapatanPerBulan = false;
        validateTunjanganPPH = false;
        validateTunjanganLainnya = false;
        validateImbalanLainnya = false;
        validatePremiAsuransi = false;
        validateNatura = false;
        validateBonus = false;
        validateIuranPensiun = false;



    }
}