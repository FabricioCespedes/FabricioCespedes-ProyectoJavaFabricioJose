/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author josea
 */
public class EDiaAusente extends EDiaLibre {
    private String fechaFin;
    private EProfesor profesor;


    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EProfesor getProfesor() {
        return profesor;
    }

    public void setProfesor(EProfesor profesor) {
        this.profesor = profesor;
    }

    public EDiaAusente() {
    }

    
    
    public EDiaAusente(String fechaFin, EProfesor profesor) {
        this.fechaFin = fechaFin;
        this.profesor = profesor;
    }

    public EDiaAusente(String fechaFin, EProfesor profesor, int idDia, String fecha, EMotivoAusencia motivo) {
        super(idDia, fecha, motivo);
        this.fechaFin = fechaFin;
        this.profesor = profesor;
    }

    
    
    
}
