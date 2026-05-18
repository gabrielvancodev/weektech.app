package com.gabriel.weektech.models.dao;

import androidx.room.*;

import com.gabriel.weektech.models.Inscricao;

import java.util.List;

@Dao
public interface InscricaoDao {

    @Query("SELECT * FROM inscricao WHERE id_evento = :idEvento")
    List<Inscricao> listarPorEvento(int idEvento);
    @Insert
    void inserir(Inscricao inscricao);

    @Query("SELECT * FROM inscricao WHERE id_usuario = :idUsuario")
    List<Inscricao> listarPorUsuario(int idUsuario);

    @Query("UPDATE inscricao SET presenca_confirmada = 1 WHERE id_inscricao = :id")
    void confirmarPresenca(int id);
}