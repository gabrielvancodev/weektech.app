package com.gabriel.weektech.models;

import androidx.room.Entity;

@Entity(primaryKeys = {"id_evento", "id_patrocinador"})
public class EventoPatrocinadorCrossRef {

    public int id_evento;
    public int id_patrocinador;
}