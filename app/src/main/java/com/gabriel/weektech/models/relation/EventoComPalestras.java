package com.gabriel.weektech.models.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Palestra;

import java.util.List;

public class EventoComPalestras {

    @Embedded
    public Evento evento;

    @Relation(
            parentColumn = "id_evento",
            entityColumn = "id_evento"
    )
    public List<Palestra> palestras;
}