package com.example.myapplication.TurnEnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.TurnEnd.TurnEndInput.TurnEndMulaiActivity;
import com.example.myapplication.TurnEnd.TurnEndOutput.QuizTurnEndOutputActivity;
import com.example.myapplication.TurnEnd.TurnEndOutput.TurnEndOutputMulaiActivity;

public class SubMenuTurnEndActivity extends AppCompatActivity {

    private Button btnTunEndInput, btnTurnEndOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_turn_end);

        btnTunEndInput = findViewById(R.id.btnTurnEndInput);
        btnTurnEndOutput = findViewById(R.id.btnTurnEndOutput);

        btnTurnEndOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenuTurnEndActivity.this, QuizTurnEndOutputActivity.class);
                startActivity(intent);
            }
        });

        btnTunEndInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenuTurnEndActivity.this, TurnEndMulaiActivity.class);
                startActivity(intent);
            }
        });
    }
}