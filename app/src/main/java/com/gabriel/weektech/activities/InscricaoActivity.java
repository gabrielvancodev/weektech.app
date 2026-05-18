package com.gabriel.weektech.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Inscricao;

public class InscricaoActivity extends AppCompatActivity {

    private TextView txtEvento;
    private CheckBox checkCoffee;
    private Button btnInscrever;
    private ImageButton btnVoltar;

    private AppDatabase db;

    private Evento eventoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao);

        db = AppDatabase.getDatabase(this);

        txtEvento = findViewById(R.id.txtEvento);
        checkCoffee = findViewById(R.id.checkCoffee);
        btnInscrever = findViewById(R.id.btnInscrever);
        btnVoltar = findViewById(R.id.btnVoltar);

        // RECEBE ID DO EVENTO
        int idEvento = getIntent().getIntExtra("id_evento", -1);

        if (idEvento != -1) {

            eventoSelecionado =
                    db.eventoDao().buscarPorId(idEvento);

            if (eventoSelecionado != null) {

                txtEvento.setText(
                        eventoSelecionado.nome_evento
                );
            }
        }

        // VOLTAR
        btnVoltar.setOnClickListener(v -> finish());

        // INSCRIÇÃO
        btnInscrever.setOnClickListener(v -> realizarInscricao());
    }

    private void realizarInscricao() {

        if (eventoSelecionado == null) {

            Toast.makeText(
                    this,
                    "Evento inválido!",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        Inscricao inscricao = new Inscricao();

        inscricao.id_evento =
                eventoSelecionado.id_evento;

        // USUÁRIO LOGADO (temporário)
        inscricao.id_usuario = 1;

        inscricao.coffee_break =
                checkCoffee.isChecked();

        inscricao.confirmado = true;

        inscricao.presenca_confirmada = false;

        db.inscricaoDao().inserir(inscricao);

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