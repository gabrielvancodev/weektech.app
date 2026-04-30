package com.gabriel.weektech.models;

@Entity(tableName = "usuario")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    public int id_usuario;

    public String nome_completo;
    public String data_nascimento;
    public String ra;
    public String email;
    public String senha;
    public String tipo; // ADMIN ou ALUNO
}