package com.eventos.service;

import com.eventos.entity.EventoXAsistente;
import com.eventos.repository.EventoXAsistenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoXAsistenteService {

    @Autowired
    EventoXAsistenteRepository eventoXasistenteRepository;

    public List<EventoXAsistente> getEventoXAsistentes(){
        return eventoXasistenteRepository.findAll();
    }

    public List<EventoXAsistente> getEventoXAsistente_idEvento(Long id){
        return eventoXasistenteRepository.findByidEvento(id);
    }

    public List<EventoXAsistente> getEventoXAsistente_idAsistente(Long id){
        return eventoXasistenteRepository.findByidAsistente(id);
    }

    public Optional<EventoXAsistente> getEventoXAsistente(Long id){
        return eventoXasistenteRepository.findById(id);
    }

    public void saveOrUpdate(EventoXAsistente eventoXAsistente){
        eventoXasistenteRepository.save(eventoXAsistente);
    }

    public void delete(Long id){
        eventoXasistenteRepository.deleteById(id);
    }

}

