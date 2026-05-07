package com.gabriel.weektech.models.dao;

import androidx.room.*;

import com.gabriel.weektech.models.Palestra;

import java.util.List;

@Dao
public interface PalestraDao {

    @Insert
    void inserir(Palestra palestra);

    @Query("SELECT * FROM palestra WHERE id_evento = :idEvento")
    List<Palestra> listarPorEvento(int idEvento);
}