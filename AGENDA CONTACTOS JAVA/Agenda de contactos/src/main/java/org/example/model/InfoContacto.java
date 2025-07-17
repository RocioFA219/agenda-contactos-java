package org.example.model;

public class InfoContacto {
    private String nombre;
    private String apellidos;
    private Integer numtelf;

    public InfoContacto(String nombre, String apellidos, Integer numtelf){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numtelf = numtelf;
    }
    public String getNombre(){
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getNumtelf() {
        return numtelf;
    }

    public void setNumtelf(Integer numtelf) {
        this.numtelf = numtelf;
    }
}
