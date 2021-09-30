package com.example.myapplication.Form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Form.Imitation.ShortItemImitationActivity;
import com.example.myapplication.R;

public class SubMenuFormActivity extends AppCompatActivity {

    private Button btnImitation,btnAuditoryDiscrimination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_form);

        btnImitation = findViewById(R.id.btnImitation);
        btnAuditoryDiscrimination = findViewById(R.id.btnAuditoryDiscrimination);

        btnImitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubMenuFormActivity.this, ShortItemImitationActivity.class);
                startActivity(intent);
            }
        });

        btnAuditoryDiscrimination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}