package com.gabriel.weektech.models;
import androidx.room.*;



@Entity(
        tableName = "evento",
        foreignKeys = @ForeignKey(
                entity = Localizacao.class,
                parentColumns = "id_localizacao",
                childColumns = "id_localizacao",
                onDelete = ForeignKey.CASCADE
        )
)
public class Evento {

    @PrimaryKey(autoGenerate = true)
    public int id_evento;

    public String nome_evento;
    public String descricao;
    public String data_inicio;
    public String data_fim;

    public int qntd_vagas;
    public int qntd_inscritos;

    public int id_localizacao;
}
