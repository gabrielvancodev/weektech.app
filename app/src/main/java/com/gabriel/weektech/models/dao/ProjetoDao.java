package com.gabriel.weektech.models.dao;

import androidx.room.*;
import com.gabriel.weektech.models.Projeto;
import java.util.List;

@Dao
public interface ProjetoDao {

    @Insert
    void inserir(Projeto projeto);

    @Query("SELECT * FROM projeto")
    List<Projeto> listar();

    @Delete
    void deletar(Projeto projeto);

    @Update
    void atualizar(Projeto projeto);
}