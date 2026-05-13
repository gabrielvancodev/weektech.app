package com.gabriel.weektech.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Inscricao;

import java.util.List;

public class InscricaoActivity extends AppCompatActivity {

    private Spinner spinnerEventos;
    private CheckBox checkCoffee;
    private Button btnInscrever;
    private ImageButton btnVoltar;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao);

        db = AppDatabase.getDatabase(this);

        spinnerEventos = findViewById(R.id.spinnerEventos);
        checkCoffee = findViewById(R.id.checkCoffee);
        btnInscrever = findViewById(R.id.btnInscrever);
        btnVoltar = findViewById(R.id.btnVoltar);

        carregarEventos();

        // BOTÃO VOLTAR
        btnVoltar.setOnClickListener(v -> finish());

        // BOTÃO INSCRIÇÃO
        btnInscrever.setOnClickListener(v -> realizarInscricao());
    }

    private void carregarEventos() {

        List<Evento> eventos = db.eventoDao().listar();

        ArrayAdapter<Evento> eventoAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                eventos
        );

        eventoAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerEventos.setAdapter(eventoAdapter);
    }

    private void realizarInscricao() {

        Evento eventoSelecionado =
                (Evento) spinnerEventos.getSelectedItem();

        if (eventoSelecionado == null) {

            Toast.makeText(
                    this,
                    "Selecione um evento!",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // FUTURAMENTE:
        // PEGAR USUÁRIO LOGADO
        // Por enquanto usamos ID fixo

        Inscricao inscricao = new Inscricao();

        inscricao.id_evento = eventoSelecionado.id_evento;

        // Usuário mockado/logado
        inscricao.id_usuario = 1;

        inscricao.coffee_break =
                checkCoffee.isChecked();

        inscricao.confirmado = true;

        inscricao.presenca_confirmada = false;

        db.inscricaoDao().inserir(inscricao);

        // JANELA DE CONFIRMAÇÃO
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("Inscrição Confirmada");

        if (checkCoffee.isChecked()) {

            builder.setMessage(
                    "Sua inscrição foi realizada com sucesso!\n\n" +
                            "Coffee Break confirmado ☕"
            );

        } else {

            builder.setMessage(
                    "Sua inscrição foi realizada com sucesso!"
            );
        }

        builder.setPositiveButton("OK", (dialog, which) -> {

            dialog.dismiss();

            finish();
        });

        builder.show();
    }
}