package com.gabriel.weektech.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.google.android.material.button.MaterialButton;

public class LocalizacaoActivity extends AppCompatActivity {

    MaterialButton btnMaps, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        btnMaps = findViewById(R.id.btnMaps);
        btnVoltar = findViewById(R.id.btnVoltar);

        // ABRIR GOOGLE MAPS
        btnMaps.setOnClickListener(v -> {

            String endereco = "https://maps.google.com/?q=Unicesumar+Londrina";

            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(endereco));

            startActivity(intent);
        });

        // VOLTAR
        btnVoltar.setOnClickListener(v -> finish());
    }
}