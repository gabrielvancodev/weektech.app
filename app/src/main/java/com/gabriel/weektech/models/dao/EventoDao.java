package com.gabriel.weektech.models.dao;

import androidx.room.*;

import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.relation.EventoComPalestras;

import java.util.List;

@Dao
public interface EventoDao {

    @Insert
    void inserir(Evento evento);

    @Query("SELECT * FROM evento")
    List<Evento> listar();

    @Transaction
    @Query("SELECT * FROM evento")
    List<EventoComPalestras> listarEventosComPalestras();
}