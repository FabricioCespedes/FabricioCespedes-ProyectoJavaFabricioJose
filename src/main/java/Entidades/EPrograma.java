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
public class EPrograma {
    private int idPrograma;
    private String codigo;
    private String nombrePrograma;
    private String fechaInicio;
    private String fechaFin;
    private String horasInicio;
    private String horasFin;
    private String estado;
    private int anio;
    private int grupo;
    private ECentro centro;
    private ArrayList<EDia>dia;


    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
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

    public String getHorasInicio() {
        return horasInicio;
    }

    public void setHorasInicio(String horasInicio) {
        this.horasInicio = horasInicio;
    }

    public String getHorasFin() {
        return horasFin;
    }

    public void setHorasFin(String horasFin) {
        this.horasFin = horasFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public ECentro getCentro() {
        return centro;
    }

    public void setCentro(ECentro centro) {
        this.centro = centro;
    }

    public ArrayList<EDia> getDia() {
        return dia;
    }

    public void setDia(ArrayList<EDia> dia) {
        this.dia = dia;
    }
    

    public EPrograma() {
    }

    public EPrograma(int idPrograma, String codigo, String nombrePrograma, String fechaInicio, String fechaFin, String horasInicio, String horasFin, String estado, int anio, int grupo, ECentro centro, ArrayList<EDia> dia) {
        this.idPrograma = idPrograma;
        this.codigo = codigo;
        this.nombrePrograma = nombrePrograma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasInicio = horasInicio;
        this.horasFin = horasFin;
        this.estado = estado;
        this.anio = anio;
        this.grupo = grupo;
        this.centro = centro;
        this.dia = dia;
    }
    
    
}
