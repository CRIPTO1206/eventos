package com.eventos.controller;

import com.eventos.entity.EventoXAsistente;
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
public class EventoXAsistenteController {

    Logger logger = LoggerFactory.getLogger(EventoXAsistenteController.class);

    @Autowired
    private EventoXAsistenteService eventoXasistenteService;

    @Operation(summary = "Consulta de todos los eventos por asistentes")
    @GetMapping("/eventosXasistentes")
    public List<EventoXAsistente> getAllEventos(){

        List<EventoXAsistente> eventosXasistentes;

        long startTime = System.nanoTime();

        eventosXasistentes = eventoXasistenteService.getEventoXAsistentes();

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la consulta de eventos X asistentes: " + timeElapsed / 1000000);

        return eventosXasistentes;

    }

    @Operation(summary = "Consulta de 1 evento por asistentes")
    @GetMapping("/eventosXasistentes/{eventoXasistenteId}")
    public Optional<EventoXAsistente> getByIdEvento(@PathVariable("eventoXasistenteId") Long eventoXasistenteId){

        long startTime = System.nanoTime();

        Optional<EventoXAsistente> exa = eventoXasistenteService.getEventoXAsistente(eventoXasistenteId);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la consulta de un evento X asistentes: " + timeElapsed / 1000000);

        return exa;
    }

    @Operation(summary = "Creación y/o actualización de 1 evento por asistentes")
    @PostMapping("/eventosXasistentes")
    public void SaveUpdateEventoXAsistente(@RequestBody EventoXAsistente eventoXasistente){

        long startTime = System.nanoTime();

        eventoXasistenteService.saveOrUpdate(eventoXasistente);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la creación/actualización de un evento X asistentes: " + timeElapsed / 1000000);
    }

}
