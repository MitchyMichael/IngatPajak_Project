package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class PPN_BMActivity extends AppCompatActivity {

    private TextInputLayout textInput_Harga, textInput_PPNBM;
    private Button button_lanjut_inputPPNBM;

    private int PPN, PPnBM, impor, persentase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_p_n__b_m);

        initview();

        buttonlock();

        buttonnext();

    }

    private void initview(){
        textInput_Harga = findViewById(R.id.textInput_LuasB);
        textInput_PPNBM = findViewById(R.id.textInput_LuasT);
        button_lanjut_inputPPNBM = findViewById(R.id.button_lanjut_inputPPNBM);
    }

    private void buttonlock(){
        textInput_Harga.getEditText().addTextChangedListener(IsiTextWatcher);
        textInput_PPNBM.getEditText().addTextChangedListener(IsiTextWatcher);
    }

    private int hitungPPnBM(){

        int hasil;

        impor = Integer.parseInt(textInput_Harga.getEditText().getText().toString().trim());
        persentase = Integer.parseInt(textInput_PPNBM.getEditText().getText().toString().trim());

        hasil = (persentase * impor) / 100;

        if (hasil <= 0){
            hasil = 0;
        }

        return hasil;
    }

    private int hitungPPN(){

        int hasil;

        impor = Integer.parseInt(textInput_Harga.getEditText().getText().toString().trim());
        persentase = Integer.parseInt(textInput_PPNBM.getEditText().getText().toString().trim());

        hasil = impor / 10;

        if (hasil <= 0){
            hasil = 0;
        }


        return hasil;
    }

    private void buttonnext(){
        button_lanjut_inputPPNBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog loadingDialog = new LoadingDialog(PPN_BMActivity.this);
                PPN = hitungPPN();
                PPnBM = hitungPPnBM();

                String PPN_string, PPnBM_string ;

                PPN_string = String.valueOf(PPN);
                PPnBM_string = String.valueOf(PPnBM);

                Intent intent = new Intent(getBaseContext(), HasilPPnBMActivity.class);
                intent.putExtra("PajakPPN", PPN_string);
                intent.putExtra("PajakPPnBM", PPnBM_string);

                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                        startActivity(intent);
                        finish();
                    }
                }, 3000);

            }
        });
    }

    private TextWatcher IsiTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String Harga = textInput_Harga.getEditText().getText().toString().trim();
            String Persen = textInput_PPNBM.getEditText().getText().toString().trim();

            button_lanjut_inputPPNBM.setEnabled(!Harga.isEmpty() && !Persen.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}