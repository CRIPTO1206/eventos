package com.eventos.controller;

import com.eventos.entity.Evento;
import com.eventos.entity.EventoXAsistente;
import com.eventos.service.EventoService;
import com.eventos.service.EventoXAsistenteService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EventoController {

    Logger logger = LoggerFactory.getLogger(EventoController.class);

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

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la consulta de eventos: " + timeElapsed / 1000000);

        return eventos;

    }

    @Operation(summary = "Consulta de 1 evento")
    @GetMapping("/eventos/{eventoId}")
    public Optional<Evento> getByIdEvento(@PathVariable("eventoId") Long eventoId){

        Optional<Evento> evento;

        long startTime = System.nanoTime();

        evento = eventoService.getEvento(eventoId);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la consulta de un evento: " + timeElapsed / 1000000);

        return evento;

    }

    @Operation(summary = "Creación y/o actualización de 1 evento")
    @PostMapping("/eventos")
    public void SaveUpdateEvento(@RequestBody Evento evento){

        long startTime = System.nanoTime();

        eventoService.saveOrUpdate(evento);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la creación/actualización de un evento: " + timeElapsed / 1000000);


    }

    @Operation(summary = "Eliminación de 1 evento")
    @DeleteMapping("/eventos/{eventoId}")
    public void deleteEvento(@PathVariable("eventoId") Long eventoId){

        long startTime = System.nanoTime();

        List<EventoXAsistente> eventosXasistentes;

        eventosXasistentes = eventoXasistenteService.getEventoXAsistente_idEvento(eventoId);

        if(eventosXasistentes.size()==0)
            eventoService.delete(eventoId);
        else    logger.warn("*********************************** NO se puede borrar el evento por que ya está asignados asistentes");

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la eliminación de un evento: " + timeElapsed / 1000000);

    }
}
