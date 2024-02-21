package com.eventos.controller;

import com.eventos.entity.Evento;
import com.eventos.entity.EventoXAsistente;
import com.eventos.service.EventoService;
import com.eventos.service.EventoXAsistenteService;
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

    @Autowired
    private EventoXAsistenteService eventoXasistenteService;

    @Operation(summary = "Consulta de todos los eventos")
    @GetMapping("/eventos")
    public List<Evento> getAllEventos(){

        List<Evento> eventos;

        long startTime = System.nanoTime();

        eventos = eventoService.getEventos();

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Tiempo de ejecución en milisegundos: " + timeElapsed / 1000000);

        return eventos;

    }

    @Operation(summary = "Consulta de 1 eventos")
    @GetMapping("/eventos/{eventoId}")
    public Optional<Evento> getByIdEvento(@PathVariable("eventoId") Long eventoId){
        return eventoService.getEvento(eventoId);
    }

    @Operation(summary = "Creación y/o actualización de 1 evento")
    @PostMapping("/eventos")
    public void SaveUpdateEvento(@RequestBody Evento evento){
        eventoService.saveOrUpdate(evento);
    }

    @Operation(summary = "Eliminación de 1 evento")
    @DeleteMapping("/eventos/{eventoId}")
    public void deleteEvento(@PathVariable("eventoId") Long eventoId){

        List<EventoXAsistente> eventosXasistentes;

        eventosXasistentes = eventoXasistenteService.getEventoXAsistente_idEvento(eventoId);

        if(eventosXasistentes.size()==0)
            System.out.println("Se puede borrar");
        else    System.out.println("No Se puede borrar");

        //eventoService.delete(eventoId);
    }

    public void geocode(){

    }

}
