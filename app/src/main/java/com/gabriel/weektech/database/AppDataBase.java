package com.gabriel.weektech.database;

// Imports Necessários
import android.content.Context;
import androidx.room.Database; // Banco de Dados Local
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.gabriel.weektech.models.dao.*;
import com.gabriel.weektech.models.*;

// Listando as Entidades
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

// Classe Abstrata
public abstract class AppDatabase extends RoomDatabase {

    // Classes Abstratas dos Data Acess Object
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
                    ).allowMainThreadQueries() // só pra facilitar agora
                    .build();
        }
        return INSTANCE;
    }
}