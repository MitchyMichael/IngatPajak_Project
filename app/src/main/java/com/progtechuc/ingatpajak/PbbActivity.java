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

public class PbbActivity extends AppCompatActivity {

    private TextInputLayout textInput_LuasB, textInput_LuasT, textInput_HargaB, textInput_HargaT;
    private Button button_lanjut_inputPPh2;

    private int LuasB, LuasT, HargaB, HargaT, NJOP, NJKP, PBB, Final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pbb);

        initview();

        buttonlock();

        buttonSubmit();
    }

    private void buttonlock() {

        textInput_HargaB.getEditText().addTextChangedListener(IsiTextWatcher);
        textInput_HargaT.getEditText().addTextChangedListener(IsiTextWatcher);
        textInput_LuasB.getEditText().addTextChangedListener(IsiTextWatcher);
        textInput_LuasT.getEditText().addTextChangedListener(IsiTextWatcher);

    }


    private void initview() {
        textInput_HargaB = findViewById(R.id.textInput_HargaB);
        textInput_HargaT = findViewById(R.id.textInput_HargaT);
        textInput_LuasB = findViewById(R.id.textInput_LuasB);
        textInput_LuasT = findViewById(R.id.textInput_LuasT);
        button_lanjut_inputPPh2 = findViewById(R.id.button_lanjut_inputPPh2);
    }

    private int hitungPBB(){
        LuasB = Integer.parseInt(textInput_LuasB.getEditText().getText().toString().trim());
        LuasT = Integer.parseInt(textInput_LuasT.getEditText().getText().toString().trim());
        HargaB = Integer.parseInt(textInput_HargaB.getEditText().getText().toString().trim());
        HargaT = Integer.parseInt(textInput_HargaT.getEditText().getText().toString().trim());

        NJOP = (LuasT * HargaT) + (LuasB * HargaB);

        if (NJOP > 1000000000){
            NJKP = (2 * (NJOP - 12000000)) / 10;
        }else if(NJOP < 1000000000){
            NJKP = (NJOP - 12000000) / 5;
        }

        PBB = NJKP / 200;

        return PBB;
    }

    private void buttonSubmit(){
        button_lanjut_inputPPh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog loadingDialog = new LoadingDialog(PbbActivity.this);
                Final = hitungPBB();

                String PajakPBB_string;

                PajakPBB_string = String.valueOf(Final);

                Intent intent = new Intent(getBaseContext(), hasilPBBActivity.class);
                intent.putExtra("PajakPBB", PajakPBB_string);

                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                        startActivity(intent);
                        finish();
                    }
                },3000);
            }
        });
    }

    private TextWatcher IsiTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String LuasBa = textInput_LuasB.getEditText().getText().toString().trim();
            String LuasTa = textInput_LuasT.getEditText().getText().toString().trim();
            String HargaBa = textInput_HargaB.getEditText().getText().toString().trim();
            String HargaTa = textInput_HargaT.getEditText().getText().toString().trim();

            button_lanjut_inputPPh2.setEnabled(!LuasBa.isEmpty() && !LuasTa.isEmpty() && !HargaBa.isEmpty() && !HargaTa.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };

}