/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author josea
 */
public class EProfesor extends EPersona{
    private String fechaInicio;
    private String fechaFin;

    public EProfesor() {
        this.fechaInicio = "";
        this.fechaFin = "";
    }

    public EProfesor(long idPersona, String nombre, String apellido1, String apellido2, ECentro centro) {
        super(idPersona, nombre, apellido1, apellido2, centro);
        this.fechaInicio = "";
        this.fechaFin = "";
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    

    
}
