package com.eventos.controller;

import com.eventos.entity.Evento;
import com.eventos.service.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Operation(summary = "Consulta de todos los eventos")
    @GetMapping("/eventos")
    public List<Evento> getAll(){

        List<Evento> eventos;

        long startTime = System.nanoTime();

        eventos = eventoService.getEventos();

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Tiempo de ejecución en milisegundos: " + timeElapsed / 1000000);

        return eventos;

    }

    @Operation(summary = "Consulta de 1 eventos")
    @GetMapping("/{eventoId}")
    public Optional<Evento> getById(@PathVariable("eventoId") Long eventoId){
        return eventoService.getEvento(eventoId);
    }

    @Operation(summary = "Creación y/o actualización de 1 evento")
    @PostMapping
    public void SaveUpdate(@RequestBody Evento evento){
        eventoService.saveOrUpdate(evento);
    }

    @Operation(summary = "Eliminación de 1 evento")
    @DeleteMapping("/{eventoId}")
    public void delete(@PathVariable("eventoId") Long eventoId){
        eventoService.delete(eventoId);
    }

    public void geocode(){

    }

}
