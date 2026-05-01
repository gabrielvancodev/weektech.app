package com.gabriel.weektech.models;
import androidx.room.*;


@Entity(
        tableName = "projeto",
        foreignKeys = @ForeignKey(
                entity = Usuario.class,
                parentColumns = "id_usuario",
                childColumns = "id_usuario",
                onDelete = ForeignKey.CASCADE
        )
)
public class Projeto {

    @PrimaryKey(autoGenerate = true)
    public int id_projeto;

    public String nome_projeto;
    public String descricao;

    public int id_usuario;
}