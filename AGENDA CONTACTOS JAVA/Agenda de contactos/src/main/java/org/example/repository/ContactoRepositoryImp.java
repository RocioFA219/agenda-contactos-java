package org.example.repository;

import org.example.model.InfoContacto;

import java.util.*;
import java.util.stream.Collectors;

public class ContactoRepositoryImp implements ContactoRepository{

    private final Map<Integer, InfoContacto> contactos = new HashMap<>();

    @Override
    public List<InfoContacto> findAll(){
        return new ArrayList<>(contactos.values());
    }
     @Override
    public List<InfoContacto> findByNombre(String nombre){
        return contactos.values().stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
     }
     @Override
    public  List<InfoContacto> findByApellidos(String apellidos){
        return contactos.values().stream()
                .filter(c-> c.getApellidos().equalsIgnoreCase(apellidos))
                .collect(Collectors.toList());
     }

    @Override
    public Optional<InfoContacto> findByNumTelf(Integer num){
        return Optional.ofNullable(contactos.get(num));
    }
    @Override
    /**
     * Guarda el numero, si el numero ya existia, lo reemplaza y si no lo añade
     * devuelve el mismo contacto para confirmar que fue guardado.
     */
    public InfoContacto save(InfoContacto contacto){
        contactos.put(contacto.getNumtelf(),contacto);
        return contacto;
    }
    @Override
    public void deleteByNumTelf(Integer num){
        contactos.remove(num);
    }
}
