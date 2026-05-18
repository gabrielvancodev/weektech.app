package com.gabriel.weektech.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;

public class MainActivity extends AppCompatActivity {

    Button btnEventos,
            btnPalestras,
            btnLocalizacao,
            btnFAQ,
            btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEventos = findViewById(R.id.btnEventos);
        btnPalestras = findViewById(R.id.btnPalestras);
        btnLocalizacao = findViewById(R.id.btnLocalizacao);
        btnFAQ = findViewById(R.id.btnFAQ);
        btnAdmin = findViewById(R.id.btnAdmin);

        // EVENTOS
        btnEventos.setOnClickListener(v ->
                startActivity(
                        new Intent(this, EventoActivity.class)
                )
        );

        // PALESTRAS
        btnPalestras.setOnClickListener(v ->
                startActivity(
                        new Intent(this, EventoActivity.class)
                )
        );

        // LOCALIZAÇÃO
        btnLocalizacao.setOnClickListener(v ->
                startActivity(
                        new Intent(this, LocalizacaoActivity.class)
                )
        );

        // FAQ
        btnFAQ.setOnClickListener(v ->
                startActivity(
                        new Intent(this, FAQActivity.class)
                )
        );

        // ADMIN
        btnAdmin.setOnClickListener(v ->
                startActivity(
                        new Intent(this, AdminActivity.class)
                )
        );
    }
}