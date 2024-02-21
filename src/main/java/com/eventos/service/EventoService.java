package com.eventos.service;

import com.eventos.entity.Evento;
import com.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public List<Evento> getEventos(){
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEvento(Long id){
        return eventoRepository.findById(id);
    }

    public void saveOrUpdate(Evento evento){
        eventoRepository.save(evento);
    }

    public void delete(Long id){
        eventoRepository.deleteById(id);
    }

}

