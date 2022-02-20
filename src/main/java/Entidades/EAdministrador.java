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
public class EAdministrador {
    private String contrasenia;
    private ArrayList<EProfesor> profesor;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<EProfesor> getProfesores() {
        return profesor;
    }

    public void setProfesores(ArrayList<EProfesor> profesores) {
        this.profesor = profesores;
    }

    public EAdministrador() {
    }

    public EAdministrador(String contrasenia, ArrayList<EProfesor> profesores) {
        this.contrasenia = contrasenia;
        this.profesor = profesores;
    }
    
    
}
