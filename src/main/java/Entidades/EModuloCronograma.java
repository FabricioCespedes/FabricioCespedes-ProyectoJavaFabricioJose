/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.util.ArrayList;

/**
 *
 * @author josea
 */
public class EModuloCronograma {
    private String fechaInicio;
    private String fechaFin;
    private String horasDia;
    private String horaInicio;
    private String horaFin;
    private String estado;
    private EModulo modulo;
    private ArrayList<EProfesor> listaProfesores = new ArrayList<>();
    private EPrograma programa;

    public String getFechaInicio() {
        return fechaInicio;
    }
    
    public void agregarProfesor(EProfesor profesor){
        listaProfesores.add(profesor);
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

    public String getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(String horasDia) {
        this.horasDia = horasDia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EModulo getModulo() {
        return modulo;
    }

    public void setModulo(EModulo modulo) {
        this.modulo = modulo;
    }

    public ArrayList<EProfesor> getProfesor() {
        return listaProfesores;
    }

    public void setProfesor(ArrayList<EProfesor> profesor) {
        this.listaProfesores = profesor;
    }
    

    public EPrograma getPrograma() {
        return programa;
    }

    public void setPrograma(EPrograma programa) {
        this.programa = programa;
    }

    public EModuloCronograma() {
    }
    
    public EModuloCronograma(String fechaInicio, String fechaFin, String horasDia, String horaInicio, String horaFin, String estado, EModulo modulo,  EPrograma programa) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasDia = horasDia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.modulo = modulo;
        this.programa = programa;
    }


    
    
}
