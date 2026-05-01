package com.gabriel.weektech.models;
import androidx.room.*;


@Entity(tableName = "faq")
public class FAQ {

    @PrimaryKey(autoGenerate = true)
    public int id_faq;

    public String pergunta;
    public String resposta;
}