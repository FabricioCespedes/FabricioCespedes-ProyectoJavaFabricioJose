/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author josea
 */
public abstract class EPersona {
    protected long idPersona;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected ECentro centro;

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public ECentro getCentro() {
        return centro;
    }

    public void setCentro(ECentro centro) {
        this.centro = centro;
    }

    public EPersona() {
    }

    public EPersona(long idPersona, String nombre, String apellido1, String apellido2, ECentro centro) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.centro = centro;
    }
    
    @Override
    public String toString(){
        if (apellido2 == null) {
            return nombre+" "+apellido1+" Identificación: "+ String.valueOf(idPersona);
        }else{
            return nombre+" "+apellido1+" "+apellido2+" Identificación: "+ String.valueOf(idPersona);
        }
    }
    
}
