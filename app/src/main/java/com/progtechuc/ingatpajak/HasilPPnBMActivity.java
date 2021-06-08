package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilPPnBMActivity extends AppCompatActivity {

    private TextView textView_PPN_Hasil, textView_PPnBM_Hasil;
    private Button button_Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_p_pn_b_m);

        initview();
        hasil();

        goHome();
    }

    private void initview(){

        textView_PPN_Hasil = findViewById(R.id.textView_PPN_Hasil);
        textView_PPnBM_Hasil = findViewById(R.id.textView_PPnBM_Hasil);
        button_Home = findViewById(R.id.button_Home);
    }

    private void hasil(){
        textView_PPN_Hasil.setText(getIntent().getStringExtra("PajakPPN"));
        textView_PPnBM_Hasil.setText(getIntent().getStringExtra("PajakPPnBM"));
    }

    private void goHome(){
        button_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), HomeActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
            }
        });
    }

}