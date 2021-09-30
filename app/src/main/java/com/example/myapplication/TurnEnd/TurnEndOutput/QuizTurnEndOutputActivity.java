package com.example.myapplication.TurnEnd.TurnEndOutput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;

public class QuizTurnEndOutputActivity extends AppCompatActivity {

    private ImageView gambarQuiz;
    private Button btnNext;
    private int currentIndex = 0;

    //soal Quiz
    private Integer[] asGambarQuiz = {R.drawable.d_keju,R.drawable.t_apel,R.drawable.d_jeruk,R.drawable.t_kue,R.drawable.t_madu,R.drawable.d_coklat,R.drawable.d_pisang,R.drawable.t_anggur,R.drawable.d_jagung,R.drawable.t_permen,R.drawable.t_air,R.drawable.d_keripik,R.drawable.t_telur,R.drawable.t_puding,R.drawable.d_susu,R.drawable.d_kacang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_turn_end_output);

        gambarQuiz = findViewById(R.id.gambarQuiz);
        btnNext = findViewById(R.id.btnNext);

        gambarQuiz.setImageResource(asGambarQuiz[currentIndex]);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < 15){
                    nextImage();
                }else{
                    Toast.makeText(QuizTurnEndOutputActivity.this, "Selamat Soal Habis", Toast.LENGTH_SHORT).show();
                    btnNext.setEnabled(false);
                }
            }
        });

    }

    public void nextImage(){
        currentIndex++;
        gambarQuiz.setImageResource(asGambarQuiz[currentIndex]);
    }
}