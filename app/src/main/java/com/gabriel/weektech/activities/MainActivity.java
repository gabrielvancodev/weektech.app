package com.gabriel.weektech.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;

public class MainActivity extends AppCompatActivity {

    Button btnEventos, btnPalestras, btnLocalizacao, btnFAQ, btnAbrirEvento;

    TextView txtProximoEvento, txtDataEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MENU
        btnEventos = findViewById(R.id.btnEventos);
        btnPalestras = findViewById(R.id.btnPalestras);
        btnLocalizacao = findViewById(R.id.btnLocalizacao);
        btnFAQ = findViewById(R.id.btnFAQ);

        // EVENTO PRINCIPAL
        btnAbrirEvento = findViewById(R.id.btnAbrirEvento);

        txtProximoEvento = findViewById(R.id.txtProximoEvento);
        txtDataEvento = findViewById(R.id.txtDataEvento);

        // EVENTO EM DESTAQUE
        txtProximoEvento.setText("WeekTech 2026");
        txtDataEvento.setText("15 de Junho • Auditório UniCesumar");

        // ABRIR EVENTO
        btnAbrirEvento.setOnClickListener(v ->
                startActivity(new Intent(this, EventoActivity.class)));

        // MENU
        btnEventos.setOnClickListener(v ->
                startActivity(new Intent(this, EventoActivity.class)));

        btnPalestras.setOnClickListener(v ->
                startActivity(new Intent(this, EventoActivity.class)));

        btnLocalizacao.setOnClickListener(v ->
                startActivity(new Intent(this, LocalizacaoActivity.class)));

        btnFAQ.setOnClickListener(v ->
                startActivity(new Intent(this, FAQActivity.class)));
    }
}