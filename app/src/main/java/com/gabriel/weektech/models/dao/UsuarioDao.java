package com.gabriel.weektech.models.dao;


import androidx.room.*;
import com.gabriel.weektech.models.Usuario;

@Dao
public interface UsuarioDao {

    @Insert
    void inserir(Usuario usuario);

    @Query("SELECT * FROM usuario WHERE email = :email AND senha = :senha")
    Usuario login(String email, String senha);

    @Query("SELECT * FROM usuario")
    List<Usuario> listar();
}
