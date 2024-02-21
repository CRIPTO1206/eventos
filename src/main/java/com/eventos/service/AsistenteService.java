package com.eventos.service;

import com.eventos.entity.Asistente;
import com.eventos.repository.AsistenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenteService {

    @Autowired
    AsistenteRepository asistenteRepository;

    public List<Asistente> getAsistentes(){
        return asistenteRepository.findAll();
    }

    public Optional<Asistente> getAsistente(Long id){
        return asistenteRepository.findById(id);
    }

    public void saveOrUpdate(Asistente asistente){
        asistenteRepository.save(asistente);
    }

    public void delete(Long id){
        asistenteRepository.deleteById(id);
    }

}

