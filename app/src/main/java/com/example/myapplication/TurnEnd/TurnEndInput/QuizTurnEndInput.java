package com.example.myapplication.TurnEnd.TurnEndInput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.HasilNilaiActivity;
import com.example.myapplication.R;

import java.io.IOException;

public class QuizTurnEndInput extends AppCompatActivity {

    private ImageButton gambarObjek, JawabanDeklaratif, JawabanTanya;
    private int currentIndex = 0;
    private int user_jawab; // 1 untuk tanya 0 untuk deklaratif
    int nilai = 0;

    private String key = "KEY_NILAI";
    private String key_nama = "KEY_NAMA";
    String Nama;

    private Integer[] objek = {R.drawable.o_anggur,R.drawable.o_apel,R.drawable.o_coklat,R.drawable.o_jagung,R.drawable.o_jeruk,R.drawable.o_kacang,R.drawable.o_keju,R.drawable.o_keripik,R.drawable.o_kue,R.drawable.o_madu,R.drawable.o_permen,R.drawable.o_pisang,R.drawable.o_puding,R.drawable.o_roti,R.drawable.o_susu,R.drawable.o_teh,R.drawable.o_telur};
    private Integer[] tanya = {R.drawable.t_anggur,R.drawable.t_apel,R.drawable.t_coklat,R.drawable.t_jagung,R.drawable.t_jeruk,R.drawable.t_kacang,R.drawable.t_keju,R.drawable.t_keripik,R.drawable.t_kue,R.drawable.t_madu,R.drawable.t_permen,R.drawable.t_pisang,R.drawable.t_puding,R.drawable.t_roti,R.drawable.t_susu,R.drawable.t_teh,R.drawable.t_telur};
    private Integer[] deklaratif = {R.drawable.d_anggur,R.drawable.d_apel,R.drawable.d_coklat,R.drawable.d_jagung,R.drawable.d_jeruk,R.drawable.d_kacang,R.drawable.d_keju,R.drawable.d_keripik,R.drawable.d_kue,R.drawable.d_madu,R.drawable.d_permen,R.drawable.d_pisang,R.drawable.d_puding,R.drawable.d_roti,R.drawable.d_susu,R.drawable.d_teh,R.drawable.d_telur};
    private Integer[] jawaban = {1,1,0,0,0,0,0,0,1,1,1,0,1,1,0,0,1};
    private Integer[] sound = {R.raw.te_anggur,R.raw.te_apel,R.raw.te_coklat,R.raw.te_jagung,R.raw.te_jeruk,R.raw.te_kacang,R.raw.te_keju,R.raw.te_keripik,R.raw.te_kue,R.raw.te_madu,R.raw.te_permen,R.raw.te_pisang,R.raw.te_puding,R.raw.te_roti,R.raw.te_susu,R.raw.te_teh,R.raw.te_telur};


    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_end);

        gambarObjek = findViewById(R.id.gambarObjek);
        JawabanDeklaratif = findViewById(R.id.JawabanDeklaratif);
        JawabanTanya = findViewById(R.id.JawabanTanya);

        gambarObjek.setImageResource(objek[0]);
        JawabanTanya.setImageResource(tanya[0]);
        JawabanDeklaratif.setImageResource(deklaratif[0]);
        user_jawab = jawaban[currentIndex];

        //Nama Pengisi Quiz
        Nama = (getIntent().getStringExtra(key_nama));


        gambarObjek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        JawabanDeklaratif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user_jawab == 0){
                    Toast.makeText(QuizTurnEndInput.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                    nilai ++;
                }

                if (currentIndex < 16){
                    nextImage();
                }else {
                    String kirimnilai = String.valueOf(nilai);
                    Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                    intent.putExtra(key, kirimnilai);
                    intent.putExtra(key_nama, Nama);
                    startActivity(intent);
                }
            }
        });


        JawabanTanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user_jawab == 1){
                    Toast.makeText(QuizTurnEndInput.this, "Jawaban benar", Toast.LENGTH_SHORT).show();
                    nilai++;
                }

                if (currentIndex < 16){

                    nextImage();
                }else {
                    String kirimnilai = String.valueOf(nilai);
                    Intent intent = new Intent(QuizTurnEndInput.this, HasilNilaiActivity.class);
                    intent.putExtra(key, kirimnilai);
                    intent.putExtra(key_nama, Nama);
                    startActivity(intent);
                }

            }
        });

    }

    public void nextImage(){
            currentIndex++;
            gambarObjek.setImageResource(objek[currentIndex]);
            JawabanTanya.setImageResource(tanya[currentIndex]);
            JawabanDeklaratif.setImageResource(deklaratif[currentIndex]);
            user_jawab = jawaban[currentIndex];
    }

    private void playAudio() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, sound[currentIndex]);
        //Menjalankan Audio / Musik
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer.start();
    }
}