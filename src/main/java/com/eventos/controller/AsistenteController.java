package com.eventos.controller;

import com.eventos.entity.Asistente;
import com.eventos.entity.EventoXAsistente;
import com.eventos.service.AsistenteService;
import com.eventos.service.EventoXAsistenteService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class AsistenteController {

    Logger logger = LoggerFactory.getLogger(AsistenteController.class);

    @Autowired
    private AsistenteService asistenteService;

    @Autowired
    private EventoXAsistenteService eventoXasistenteService;

    @Operation(summary = "Consulta de todos los asistente")
    @GetMapping("/asistentes")
    public List<Asistente> getAllAsistentes(){

        List<Asistente> asistentes;

        long startTime = System.nanoTime();

        asistentes = asistenteService.getAsistentes();

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la consulta de asistentes: " + timeElapsed / 1000000);

        return asistentes;

    }

    @Operation(summary = "Consulta de 1 asistente")
    @GetMapping("/asistentes/{asistenteId}")
    public Optional<Asistente> getByIdAsistente(@PathVariable("asistenteId") Long asistenteId){

        Optional<Asistente> asistente;

        long startTime = System.nanoTime();

        asistente = asistenteService.getAsistente(asistenteId);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la consulta de un asistente: " + timeElapsed / 1000000);

        return asistente;
    }

    @Operation(summary = "Creación y/o actualización de 1 asistente")
    @PostMapping("/asistentes")
    public void SaveUpdateAsistente(@RequestBody Asistente asistente){

        long startTime = System.nanoTime();

        asistenteService.saveOrUpdate(asistente);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la creación/actualización de un asistente: " + timeElapsed / 1000000);
    }

    @Operation(summary = "Eliminación de 1 asistente")
    @DeleteMapping("/asistentes/{asistenteId}")
    public void deleteAsistente(@PathVariable("asistenteId") Long eventoId){

        long startTime = System.nanoTime();

        List<EventoXAsistente> eventosXasistentes;

        eventosXasistentes = eventoXasistenteService.getEventoXAsistente_idAsistente(eventoId);

        if(eventosXasistentes.size()==0)
            asistenteService.delete(eventoId);
        else    logger.warn("*********************************** NO se puede borrar el asistente por que ya está asignado a un evento");

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        logger.info("---------------------------------------------- Tiempo de ejecución en milisegundos de la eliminación de un asistente: " + timeElapsed / 1000000);

    }

}
