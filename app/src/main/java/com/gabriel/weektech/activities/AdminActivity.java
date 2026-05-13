package com.gabriel.weektech.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Palestra;
import com.gabriel.weektech.models.Projeto;
import com.gabriel.weektech.models.Usuario;

public class AdminActivity extends AppCompatActivity {

    TextView totalUsuarios;
    RecyclerView recyclerUsuarios;

    Button btnCadastrarEvento;
    Button btnCadastrarPalestra;
    Button btnCadastrarPalestrante;
    Button btnCadastrarProjeto;
    Button btnVoltar;
    Button btnFechar;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin);

        db = AppDatabase.getDatabase(this);

        totalUsuarios = findViewById(R.id.totalUsuarios);
        recyclerUsuarios = findViewById(R.id.recyclerUsuarios);

        btnCadastrarEvento = findViewById(R.id.btnCadastrarEvento);
        btnCadastrarPalestra = findViewById(R.id.btnCadastrarPalestra);
        btnCadastrarPalestrante = findViewById(R.id.btnCadastrarPalestrante);
        btnCadastrarProjeto = findViewById(R.id.btnCadastrarProjeto);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnFechar = findViewById(R.id.btnFechar);

        carregarTotalUsuarios();

        // EVENTO
        btnCadastrarEvento.setOnClickListener(v -> abrirDialogEvento());

        // PALESTRA
        btnCadastrarPalestra.setOnClickListener(v -> abrirDialogPalestra());

        // PALESTRANTE
        btnCadastrarPalestrante.setOnClickListener(v -> abrirDialogPalestrante());

        // PROJETO
        btnCadastrarProjeto.setOnClickListener(v -> abrirDialogProjeto());

        // VOLTAR
        btnVoltar.setOnClickListener(v -> finish());

        // FECHAR
        btnFechar.setOnClickListener(v -> finishAffinity());
    }

    private void carregarTotalUsuarios() {

        int total = db.usuarioDao().contarUsuarios();

        totalUsuarios.setText("Total de inscritos: " + total);
    }

    // ==========================
    // EVENTO
    // ==========================
    private void abrirDialogEvento() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cadastrar Evento");

        final EditText input = new EditText(this);
        input.setHint("Nome do Evento");

        builder.setView(input);

        builder.setPositiveButton("Salvar", (dialog, width) -> {

            String nomeEvento = input.getText().toString();

            Evento evento = new Evento();
            evento.nome_evento = nomeEvento;

            db.eventoDao().inserir(evento);

            Toast.makeText(this,
                    "Evento cadastrado!",
                    Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Fechar", null);

        builder.show();
    }

    // ==========================
    // PALESTRA
    // ==========================
    private void abrirDialogPalestra() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cadastrar Palestra");

        final EditText input = new EditText(this);
        input.setHint("Título da Palestra");

        builder.setView(input);

        builder.setPositiveButton("Salvar", (dialog, width) -> {

            String titulo = input.getText().toString();

            Palestra palestra = new Palestra();
            palestra.titulo = titulo;

            db.palestraDao().inserir(palestra);

            Toast.makeText(this,
                    "Palestra cadastrada!",
                    Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Fechar", null);

        builder.show();
    }

    // ==========================
    // PALESTRANTE
    // ==========================
    private void abrirDialogPalestrante() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cadastrar Palestrante");

        final EditText input = new EditText(this);
        input.setHint("Nome do Palestrante");

        builder.setView(input);

        builder.setPositiveButton("Salvar", (dialog, width) -> {

            String nome = input.getText().toString();

            Usuario palestrante = new Usuario();

            palestrante.nome_completo = nome;
            palestrante.tipo = "PALESTRANTE";
            palestrante.email = nome + "@weektech.com";
            palestrante.senha = "123";

            db.usuarioDao().inserir(palestrante);

            Toast.makeText(this,
                    "Palestrante cadastrado!",
                    Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Fechar", null);

        builder.show();
    }

    // ==========================
    // PROJETO
    // ==========================
    private void abrirDialogProjeto() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cadastrar Projeto");

        final EditText input = new EditText(this);
        input.setHint("Nome do Projeto");

        builder.setView(input);

        builder.setPositiveButton("Salvar", (dialog, width) -> {

            String nomeProjeto = input.getText().toString();

            Projeto projeto = new Projeto();
            projeto.nome_projeto = nomeProjeto;

            db.projetoDao().inserir(projeto);

            Toast.makeText(this,
                    "Projeto cadastrado!",
                    Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Fechar", null);

        builder.show();
    }
}
