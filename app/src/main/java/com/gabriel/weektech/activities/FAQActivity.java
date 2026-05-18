package com.gabriel.weektech.activities;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;

public class FAQActivity extends AppCompatActivity {

    ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> finish());
    }
}