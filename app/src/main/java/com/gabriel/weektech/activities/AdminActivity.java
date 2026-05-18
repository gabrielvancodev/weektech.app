package com.gabriel.weektech.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Inscricao;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private MaterialButton btnCadastrarEvento,
            btnCadastrarPalestra,
            btnCadastrarPalestrante,
            btnCadastrarProjeto,
            btnFechar;

    private TextView totalUsuarios;

    private ListView listaUsuarios;

    private ArrayList<String> listaEventos;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        db = AppDatabase.getDatabase(this);

        iniciarComponentes();

        carregarEventos();

        btnFechar.setOnClickListener(v -> finish());

        btnCadastrarEvento.setOnClickListener(v ->
                abrirCadastroEvento()
        );

        btnCadastrarPalestra.setOnClickListener(v ->
                mostrarMensagem("Cadastro de palestras será implementado")
        );

        btnCadastrarPalestrante.setOnClickListener(v ->
                mostrarMensagem("Cadastro de palestrantes será implementado")
        );

        btnCadastrarProjeto.setOnClickListener(v ->
                mostrarMensagem("Cadastro de projetos será implementado")
        );
    }

    private void iniciarComponentes() {

        btnCadastrarEvento =
                findViewById(R.id.btnCadastrarEvento);

        btnCadastrarPalestra =
                findViewById(R.id.btnCadastrarPalestra);

        btnCadastrarPalestrante =
                findViewById(R.id.btnCadastrarPalestrante);

        btnCadastrarProjeto =
                findViewById(R.id.btnCadastrarProjeto);

        btnFechar =
                findViewById(R.id.btnFechar);

        totalUsuarios =
                findViewById(R.id.totalUsuarios);

        listaUsuarios =
                findViewById(R.id.recyclerUsuarios);
    }

    private void carregarEventos() {

        List<Evento> eventos =
                db.eventoDao().listar();

        listaEventos = new ArrayList<>();

        int totalInscritos = 0;

        for (Evento evento : eventos) {

            List<Inscricao> inscricoes =
                    db.inscricaoDao()
                            .listarPorEvento(evento.id_evento);

            int quantidade =
                    inscricoes.size();

            totalInscritos += quantidade;

            String item =
                    "📅 " + evento.nome_evento +
                            "\n📆 " + evento.data_inicio +
                            "\n👥 Inscritos: " + quantidade +
                            "/" + evento.qntd_vagas;

            listaEventos.add(item);
        }

        totalUsuarios.setText(
                "Total de inscrições: " + totalInscritos
        );

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        listaEventos
                );

        listaUsuarios.setAdapter(adapter);
    }

    private void abrirCadastroEvento() {

        View view =
                getLayoutInflater()
                        .inflate(R.layout.dialog_cadastro_evento,
                                null);

        EditText edtNome =
                view.findViewById(R.id.edtNomeEvento);

        EditText edtDescricao =
                view.findViewById(R.id.edtDescricaoEvento);

        EditText edtData =
                view.findViewById(R.id.edtDataEvento);

        EditText edtVagas =
                view.findViewById(R.id.edtVagasEvento);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("Cadastrar Evento");

        builder.setView(view);

        builder.setPositiveButton(
                "Salvar",
                (dialog, which) -> {

                    String nome =
                            edtNome.getText().toString().trim();

                    String descricao =
                            edtDescricao.getText().toString().trim();

                    String data =
                            edtData.getText().toString().trim();

                    String vagasStr =
                            edtVagas.getText().toString().trim();

                    if (nome.isEmpty()
                            || descricao.isEmpty()
                            || data.isEmpty()
                            || vagasStr.isEmpty()) {

                        mostrarMensagem(
                                "Preencha todos os campos"
                        );

                        return;
                    }

                    Evento evento = new Evento();

                    evento.nome_evento = nome;
                    evento.descricao = descricao;
                    evento.data_inicio = data;
                    evento.data_fim = data;
                    evento.qntd_vagas =
                            Integer.parseInt(vagasStr);

                    evento.qntd_inscritos = 0;

                    evento.id_localizacao = 1;

                    db.eventoDao().inserir(evento);

                    mostrarMensagem(
                            "Evento cadastrado com sucesso!"
                    );

                    carregarEventos();
                });

        builder.setNegativeButton(
                "Cancelar",
                (dialog, which) -> dialog.dismiss()
        );

        builder.show();
    }

    private void mostrarMensagem(String mensagem) {

        Toast.makeText(
                this,
                mensagem,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarEventos();
    }
}