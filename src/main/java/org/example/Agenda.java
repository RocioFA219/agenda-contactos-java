package org.example;

import org.example.model.InfoContacto;
import org.example.service.ContactoService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Agenda {
    private final ContactoService service;
    private final Scanner scanner;

    public Agenda(ContactoService service){
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        boolean salir= false;

        while(!salir){
            mostrarMenu();
            int opcion = leerEntero("Elige una opcion: ");
            switch (opcion){
                case 1 ->agregarContactos();
                case 2 ->mostrarContactos();
                case 3 ->buscarContactos();
                case 4 ->eliminarContactos();
                case 5 ->{
                    salir = true;
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion no valida");
            }

        }
    }
    private void mostrarMenu(){
        System.out.println("\n--- Agenda de Contactos ---");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar todos los contactos");
        System.out.println("3. Buscar por teléfono");
        System.out.println("4. Eliminar por teléfono");
        System.out.println("5. Salir");
    }

    private int leerEntero(String mensaje){
        System.out.println(mensaje);
        while(!scanner.hasNextInt()){
            System.out.println("Por favor, introduce un numero valido.");
            scanner.next();
            System.out.println(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
    private void agregarContactos(){
        System.out.println("Nombre :");
        String nombre = scanner.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = scanner.nextLine();
        int num = leerEntero("Numero de telefono: ");

        InfoContacto contacto = new InfoContacto(nombre, apellidos, num);
        InfoContacto guardado = service.save(contacto);
        if(guardado!=null){
            System.out.println("El contacto se ha añadido correctamente.");
        }else{
            System.out.println("Ya existe un contacto con ese numero");
        }
    }
    private void mostrarContactos(){
        List<InfoContacto> contactos = service.findAll();
        if(contactos.isEmpty()){
            System.out.println("No hay contactos");
        }else{
            System.out.println("Contactos: ");
            for(InfoContacto c: contactos) {
                System.out.println(c.getNombre()+ " " + c.getApellidos()+ " "+ c.getNumtelf());
            }
        }
    }
    private void buscarContactos(){
        int num= leerEntero("Introduce el numero de telefono a buscar: ");
        Optional<InfoContacto> contacto = service.findByNumTelf(num);
        if(contacto.isPresent()){
            InfoContacto c = contacto.get();
            System.out.println("Encontrado con exito: " + c.getNombre() + " " + c.getApellidos());
        }else{
            System.out.println("No encontrado.");
        }
    }
    public void eliminarContactos(){
        int num= leerEntero("Numero de telefono para eliminar: ");
        service.deleteByNumTelf(num);
        System.out.println("Numero de telefono eliminado de la agenda.");
    }
}
