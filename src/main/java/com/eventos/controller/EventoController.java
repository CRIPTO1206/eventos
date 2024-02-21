package com.eventos.controller;

import com.eventos.entity.Evento;
import com.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/eventos")
    public List<Evento> getAll(){
        return eventoService.getEventos();
    }

    @GetMapping("/{eventoId}")
    public Optional<Evento> getById(@PathVariable("eventoId") Long eventoId){
        return eventoService.getEvento(eventoId);
    }

    @PostMapping
    public void SaveUpdate(@RequestBody Evento evento){
        eventoService.saveOrUpdate(evento);
    }

    @DeleteMapping("/{eventoId}")
    public void delete(@PathVariable("eventoId") Long eventoId){
        eventoService.delete(eventoId);
    }

}
