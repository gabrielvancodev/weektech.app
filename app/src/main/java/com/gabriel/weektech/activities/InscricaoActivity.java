package com.gabriel.weektech.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Inscricao;
import com.gabriel.weektech.models.Usuario;

import java.util.List;

public class InscricaoActivity extends AppCompatActivity {

    private Spinner spinnerEventos, spinnerUsuarios;
    private CheckBox checkCoffee;
    private Button btnInscrever;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao);

        db = AppDatabase.getDatabase(this);

        spinnerEventos = findViewById(R.id.spinnerEventos);
        spinnerUsuarios = findViewById(R.id.spinnerUsuarios);
        checkCoffee = findViewById(R.id.checkCoffee);
        btnInscrever = findViewById(R.id.btnInscrever);

        carregarDados();

        btnInscrever.setOnClickListener(v -> realizarInscricao());
    }

    private void carregarDados() {
        // Carrega Eventos no Spinner
        List<Evento> eventos = db.eventoDao().listar();
        ArrayAdapter<Evento> eventoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, eventos);
        eventoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEventos.setAdapter(eventoAdapter);

        // Carrega Usuários no Spinner (Para teste, o ideal seria pegar o logado)
        List<Usuario> usuarios = db.usuarioDao().listar();
        ArrayAdapter<Usuario> usuarioAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, usuarios);
        usuarioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUsuarios.setAdapter(usuarioAdapter);
    }

    private void realizarInscricao() {
        Evento eventoSelecionado = (Evento) spinnerEventos.getSelectedItem();
        Usuario usuarioSelecionado = (Usuario) spinnerUsuarios.getSelectedItem();

        if (eventoSelecionado == null || usuarioSelecionado == null) {
            Toast.makeText(this, "Selecione um evento e um usuário!", Toast.LENGTH_SHORT).show();
            return;
        }

        Inscricao inscricao = new Inscricao();
        inscricao.id_evento = eventoSelecionado.id_evento;
        inscricao.id_usuario = usuarioSelecionado.id_usuario;
        inscricao.coffe_break = checkCoffee.isChecked();
        inscricao.confirmacao = true; // Confirmado por padrão ao se inscrever
        inscricao.presenca_confirmada = false;

        db.inscricaoDao().inserir(inscricao);

        Toast.makeText(this, "Inscrição realizada com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
