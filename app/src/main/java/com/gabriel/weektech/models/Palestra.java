package com.gabriel.weektech.models;
import androidx.room.*;


@Entity(
        tableName = "palestra",
        foreignKeys = @ForeignKey(
                entity = Evento.class,
                parentColumns = "id_evento",
                childColumns = "id_evento",
                onDelete = ForeignKey.CASCADE
        )
)
public class Palestra {

    @PrimaryKey(autoGenerate = true)
    public int id_palestra;

    public String titulo;
    public String descricao;
    public String horario_inicio;
    public String horario_fim;

    public int id_evento;
}