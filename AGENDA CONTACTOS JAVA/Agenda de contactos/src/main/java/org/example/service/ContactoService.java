package org.example.service;

import org.example.model.InfoContacto;
import org.example.repository.ContactoRepository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

/**
 * LÓGICA DE NEGOCIO USANDO EL CONTACTO REPOSITORY
 * MANEJA LAS BUSQUEDAS, FILTRA RESULTADOS...
 */
public class ContactoService {
    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository){
        this.contactoRepository = contactoRepository;
    }
    public List<InfoContacto> findAll(){
        return contactoRepository.findAll();
    }
    public List<InfoContacto> findByNombre(String nombre){
        return contactoRepository.findByNombre(nombre);
    }
    public List<InfoContacto> findByApellidos(String apellidos){
        return contactoRepository.findByApellidos(apellidos);
    }

     public Optional<InfoContacto> findByNumTelf(Integer num){
       return contactoRepository.findByNumTelf(num);
    }

    public InfoContacto save(InfoContacto contacto) {
        if (contactoRepository.findByNumTelf(contacto.getNumtelf()).isPresent()) {
            System.out.println("El contacto es existente");
            return null;
        } else {
            contactoRepository.save(contacto);
        }
        return contacto;
    }
    public void deleteByNumTelf(Integer num){
     if(contactoRepository.findByNumTelf(num).isPresent()) {
         contactoRepository.deleteByNumTelf(num);
        }else{
         System.out.println("No existe ningún contacto con ese numero");
     }
    }
}
