package com.eventos.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asistente")
public class Asistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

}
