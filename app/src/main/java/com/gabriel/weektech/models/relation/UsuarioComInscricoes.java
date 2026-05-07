package com.gabriel.weektech.models.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.gabriel.weektech.models.Usuario;
import com.gabriel.weektech.models.Inscricao;

import java.util.List;

public class UsuarioComInscricoes {

    @Embedded
    public Usuario usuario;

    @Relation(
            parentColumn = "id_usuario",
            entityColumn = "id_usuario"
    )
    public List<Inscricao> inscricoes;
}