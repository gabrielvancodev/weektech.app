package com.gabriel.weektech.models;
import androidx.room.*;


@Entity(tableName = "patrocinador")
public class Patrocinador {

    @PrimaryKey(autoGenerate = true)
    public int id_patrocinador;

    public String nome;
    public String descricao;
}
