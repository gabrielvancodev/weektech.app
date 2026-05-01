package com.gabriel.weektech.models;

@Entity(tableName = "patrocinador")
public class Patrocinador {

    @PrimaryKey(autoGenerate = true)
    public int id_patrocinador;

    public String nome;
    public String descricao;
}
