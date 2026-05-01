package com.gabriel.weektech.models;

@Entity(tableName = "localizacao")
public class Localizacao {

    @PrimaryKey(autoGenerate = true)
    public int id_localizacao;

    public String nome_local;
    public String endereco;
    public String cidade;
    public String estado;
}