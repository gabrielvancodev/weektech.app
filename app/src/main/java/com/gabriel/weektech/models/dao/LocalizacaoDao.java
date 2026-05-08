package com.gabriel.weektech.models.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.gabriel.weektech.models.Localizacao;

import java.util.List;

@Dao
public interface LocalizacaoDao {

    @Insert
    void insert(Localizacao localizacao);

    @Update
    void update(Localizacao localizacao);

    @Delete
    void delete(Localizacao localizacao);

    @Query("SELECT * FROM localizacao")
    List<Localizacao> getAll();

    @Query("SELECT * FROM localizacao WHERE id_localizacao = :id")
    Localizacao getById(int id);
}
