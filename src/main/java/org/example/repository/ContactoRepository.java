package org.example.repository;

import org.example.model.InfoContacto;

import java.util.List;
import java.util.Optional;

public interface ContactoRepository {
    List<InfoContacto> findAll();

    List<InfoContacto> findByNombre(String nombre);
    List<InfoContacto> findByApellidos(String apellidos);
    Optional<InfoContacto> findByNumTelf(Integer num);

    InfoContacto save(InfoContacto contacto);

    void deleteByNumTelf(Integer num);
}
