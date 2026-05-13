package com.gabriel.weektech.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;

public class EventoActivity extends AppCompatActivity {

    Button btnDetalhes1, btnDetalhes2;
    ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        btnDetalhes1 = findViewById(R.id.btnDetalhes1);
        btnDetalhes2 = findViewById(R.id.btnDetalhes2);
        btnVoltar = findViewById(R.id.btnVoltar);

        // VOLTAR
        btnVoltar.setOnClickListener(v -> finish());

        // EVENTO 1
        btnDetalhes1.setOnClickListener(v -> abrirDetalhesEvento(
                "Palestra IA e Futuro",
                "Uma palestra sobre Inteligência Artificial, inovação e tecnologia.\n\nHorário: 19:00\nLocal: Auditório Principal"
        ));

        // EVENTO 2
        btnDetalhes2.setOnClickListener(v -> abrirDetalhesEvento(
                "Workshop Mobile",
                "Workshop prático de desenvolvimento Android.\n\nHorário: 20:30\nLocal: Laboratório 02"
        ));
    }

    private void abrirDetalhesEvento(String titulo, String descricao) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(titulo);

        builder.setMessage(descricao);

        builder.setPositiveButton("Inscrever-se", (dialog, which) -> {

            Intent intent = new Intent(
                    EventoActivity.this,
                    InscricaoActivity.class
            );

            startActivity(intent);
        });

        builder.setNegativeButton("Fechar", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.show();
    }
}