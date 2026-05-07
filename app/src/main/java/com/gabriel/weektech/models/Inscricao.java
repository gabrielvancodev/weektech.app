package com.gabriel.weektech.models;

import androidx.room.*;

@Entity(
        tableName = "inscricao",
        foreignKeys = {
                @ForeignKey(
                        entity = Usuario.class,
                        parentColumns = "id_usuario",
                        childColumns = "id_usuario",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Evento.class,
                        parentColumns = "id_evento",
                        childColumns = "id_evento",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class Inscricao {

    @PrimaryKey(autoGenerate = true)
    public int id_inscricao;

    public int id_usuario;
    public int id_evento;

    public boolean confirmacao;
    public boolean presenca_confirmada;
    public boolean coffe_break; // Seguindo o nome do diagrama
}
