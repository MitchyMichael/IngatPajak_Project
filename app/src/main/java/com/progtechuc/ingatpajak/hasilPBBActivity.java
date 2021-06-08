package com.progtechuc.ingatpajak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hasilPBBActivity extends AppCompatActivity {

    private TextView textView_Pajak_PBB;
    private Button button_balikmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_p_b_b);

        initview();
        hasil();

        Goback();

    }

    private void initview() {
        textView_Pajak_PBB = findViewById(R.id.textView_Pajak_PBB);
        button_balikmenu = findViewById(R.id.button_balikmenu);
    }

    private void hasil(){
        Intent intent = getIntent();
        textView_Pajak_PBB.setText(intent.getStringExtra("PajakPBB"));
    }

    private void Goback(){
        button_balikmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), HomeActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
            }
        });
    }
}