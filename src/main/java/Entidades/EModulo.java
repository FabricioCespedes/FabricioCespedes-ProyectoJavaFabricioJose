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
public class EModulo {
    private int idModulo;
    private String codigo;
    private String nombreModulo;
    private String estado;
    private EModulo moduloRequerido;
    private double horasTotales;

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EModulo getModuloRequerido() {
        return moduloRequerido;
    }

    public void setModuloRequerido(EModulo moduloRequerido) {
        this.moduloRequerido = moduloRequerido;
    }

    public double getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(double horasTotales) {
        this.horasTotales = horasTotales;
    }

    public EModulo() {
    }

    
    
    
    public EModulo(int idModulo, String codigo, String nombreModulo, String estado, EModulo moduloRequerido, double horasTotales) {
        this.idModulo = idModulo;
        this.codigo = codigo;
        this.nombreModulo = nombreModulo;
        this.estado = estado;
        this.moduloRequerido = moduloRequerido;
        this.horasTotales = horasTotales;
    }
    

    
}
