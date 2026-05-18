package com.gabriel.weektech.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.adapters.EventoAdapter;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;

import java.util.List;

public class EventoActivity extends AppCompatActivity {

    private ListView listaEventos;
    private ImageButton btnVoltar;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        db = AppDatabase.getDatabase(this);

        listaEventos = findViewById(R.id.listaEventos);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> finish());

        carregarEventos();
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarEventos();
    }

    private void carregarEventos() {

        List<Evento> eventos = db.eventoDao().listar();

        EventoAdapter adapter =
                new EventoAdapter(this, eventos);

        listaEventos.setAdapter(adapter);
    }
}