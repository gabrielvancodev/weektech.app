package com.gabriel.weektech.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.gabriel.weektech.models.*;
import com.gabriel.weektech.models.dao.*;

@Database(
        entities = {
                Usuario.class,
                Evento.class,
                Palestra.class,
                Inscricao.class,
                Projeto.class,
                Patrocinador.class,
                FAQ.class,
                Localizacao.class
        },
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract EventoDao eventoDao();
    public abstract PalestraDao palestraDao();
    public abstract InscricaoDao inscricaoDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "weektech_db"
                    ).allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}