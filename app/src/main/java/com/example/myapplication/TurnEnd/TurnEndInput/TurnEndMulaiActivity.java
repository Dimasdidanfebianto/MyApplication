package com.example.myapplication.TurnEnd.TurnEndInput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class TurnEndMulaiActivity extends AppCompatActivity {

    private EditText etNama;
    private Button btnMulai;
    private String key_nama = "KEY_NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_end_mulai);

        etNama = findViewById(R.id.nama);
        btnMulai = findViewById(R.id.btnMulai);

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TurnEndMulaiActivity.this, QuizTurnEndInput.class);
                intent.putExtra(key_nama,etNama.getText().toString());
                startActivity(intent);
            }
        });
    }
}