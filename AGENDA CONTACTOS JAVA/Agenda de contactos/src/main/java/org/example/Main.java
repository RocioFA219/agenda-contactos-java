package org.example;

import org.example.model.InfoContacto;
import org.example.repository.ContactoRepository;
import org.example.repository.ContactoRepositoryImp;
import org.example.service.ContactoService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactoRepository repo = new ContactoRepositoryImp();
        ContactoService service = new ContactoService(repo);
        Agenda a = new Agenda(service);

        a.run();

    }
}