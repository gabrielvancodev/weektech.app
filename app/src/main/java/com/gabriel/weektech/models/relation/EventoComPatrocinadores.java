package com.gabriel.weektech.models.relation;

import androidx.room.*;

import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Patrocinador;

import java.util.List;

public class EventoComPatrocinadores {

    @Embedded
    public Evento evento;

    @Relation(
            parentColumn = "id_evento",
            entityColumn = "id_patrocinador",
            associateBy = @Junction(EventoPatrocinadorCrossRef.class)
    )
    public List<Patrocinador> patrocinadores;
}