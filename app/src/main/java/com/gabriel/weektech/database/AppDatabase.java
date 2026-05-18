package com.gabriel.weektech.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.FAQ;
import com.gabriel.weektech.models.Inscricao;
import com.gabriel.weektech.models.Localizacao;
import com.gabriel.weektech.models.Palestra;
import com.gabriel.weektech.models.Patrocinador;
import com.gabriel.weektech.models.Projeto;
import com.gabriel.weektech.models.Usuario;

import com.gabriel.weektech.models.dao.EventoDao;
import com.gabriel.weektech.models.dao.InscricaoDao;
import com.gabriel.weektech.models.dao.LocalizacaoDao;
import com.gabriel.weektech.models.dao.PalestraDao;
import com.gabriel.weektech.models.dao.ProjetoDao;
import com.gabriel.weektech.models.dao.UsuarioDao;

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
        version = 3,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract EventoDao eventoDao();
    public abstract PalestraDao palestraDao();
    public abstract InscricaoDao inscricaoDao();
    public abstract LocalizacaoDao localizacaoDao();
    public abstract ProjetoDao projetoDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {

        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "weektech_db"
                    )

                    .fallbackToDestructiveMigration()

                    .allowMainThreadQueries()

                    .build();
        }

        return INSTANCE;
    }
}