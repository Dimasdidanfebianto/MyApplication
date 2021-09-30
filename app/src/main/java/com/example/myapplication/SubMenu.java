package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Form.SubMenuFormActivity;

public class SubMenu extends AppCompatActivity {

    private Button btnFunction,btnForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        btnFunction = findViewById(R.id.btnFunction);
        btnForm = findViewById(R.id.btnForm);

        btnFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenu.this, SubMenu_Function.class);
                startActivity(intent);
            }
        });

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenu.this, SubMenuFormActivity.class);
                startActivity(intent);
            }
        });
    }
}