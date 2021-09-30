package com.example.myapplication.Form.Imitation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.IOException;

public class ShortItemImitationActivity extends AppCompatActivity {

    private Integer[] gambarObjek = {R.drawable.o_susu,R.drawable.o_permen,R.drawable.o_wortel,R.drawable.o_keripik,R.drawable.o_pisang,R.drawable.o_coklat,R.drawable.oo_tomat,R.drawable.o_teh,R.drawable.o_roti,R.drawable.o_puding,R.drawable.o_keju,R.drawable.o_jeruk,R.drawable.o_apel,R.drawable.o_madu,R.drawable.o_air,R.drawable.o_kacang};
    private Integer[] sound = {R.raw.si_susu,R.raw.si_permen_tanya,R.raw.si_wortel,R.raw.si_keripik_datar,R.raw.si_pisang_tanya,R.raw.si_coklat_suka,R.raw.si_tomat_suka,R.raw.si_teh,R.raw.si_roti_tanya,R.raw.si_puding_datar,R.raw.si_keju,R.raw.si_jeruk_tanya,R.raw.si_apel_datar,R.raw.si_madu_suka,R.raw.si_air_suka,R.raw.si_kacang_datar};

    private ImageButton ImBtnGambar;
    private Button btnNext;

    private int currentIndex = 0;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_item_imitation);

        ImBtnGambar = findViewById(R.id.ImBtnGambar);
        btnNext = findViewById(R.id.btnNext);

        ImBtnGambar.setImageResource(gambarObjek[currentIndex]);

        ImBtnGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < 15){
                    nextImage();
                }else{
                    Toast.makeText(ShortItemImitationActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                    btnNext.setEnabled(false);
                }
            }
        });
    }

    public void nextImage(){
        currentIndex++;
        ImBtnGambar.setImageResource(gambarObjek[currentIndex]);
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