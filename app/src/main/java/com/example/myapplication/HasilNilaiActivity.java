package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HasilNilaiActivity extends AppCompatActivity {

    private String nilaiakhir;

    private TextView txtnilai, txtNama;

    private String key = "KEY_NILAI";
    private String key_nama = "KEY_NAMA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_nilai);

        txtnilai = findViewById(R.id.Nilai);
        txtNama = findViewById(R.id.nama);

        txtnilai.setText(getIntent().getStringExtra(key));
        //Nama Pengisi Quiz
        txtNama.setText(getIntent().getStringExtra(key_nama));
    }
}