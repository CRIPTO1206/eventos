package com.eventos.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "eventoXasistente")
public class EventoXAsistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idAsistente;
    private Long idEvento;
    private String fecha;
    private String hora;
    private String descripcion;

}
