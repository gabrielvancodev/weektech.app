package com.gabriel.weektech.models;

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

    public boolean confirmado;
    public boolean presenca_confirmada;
    public boolean coffee_break;
}