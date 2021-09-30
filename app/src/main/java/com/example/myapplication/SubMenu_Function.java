package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.TurnEnd.SubMenuTurnEndActivity;
import com.example.myapplication.TurnEnd.TurnEndInput.TurnEndMulaiActivity;

public class SubMenu_Function extends AppCompatActivity {

     private Button btnTurnEnd,BtnAffect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_function);

        btnTurnEnd = findViewById(R.id.btnTurnEnd);
        BtnAffect = findViewById(R.id.btnAffect);

        btnTurnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenu_Function.this, SubMenuTurnEndActivity.class);
                startActivity(intent);

            }
        });
    }
}