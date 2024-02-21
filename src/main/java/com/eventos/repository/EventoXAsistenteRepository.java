package com.eventos.repository;

import com.eventos.entity.EventoXAsistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoXAsistenteRepository extends JpaRepository<EventoXAsistente,Long> {

    @Query(value = " SELECT id," +
            "        id_Asistente," +
            "        id_Evento," +
            "        fecha," +
            "        hora," +
            "        descripcion" +
            " FROM   evento_Xasistente" +
            " WHERE  id_Evento = ?1"
            , nativeQuery = true)
    List<EventoXAsistente> findByidEvento (Long idEvento);

    @Query(value = " SELECT id," +
            "        id_Asistente," +
            "        id_Evento," +
            "        fecha," +
            "        hora," +
            "        descripcion" +
            " FROM   evento_Xasistente" +
            " WHERE  id_Asistente = ?1"
            , nativeQuery = true)
    List<EventoXAsistente> findByidAsistente (Long idAsistente);

}
