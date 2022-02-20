/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author josea
 */
public class EDiaLibre {
    protected int idDia;
    protected String fecha;
    protected EMotivoAusencia motivo;

    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EMotivoAusencia getMotivo() {
        return motivo;
    }

    public void setMotivo(EMotivoAusencia motivo) {
        this.motivo = motivo;
    }

    public EDiaLibre() {
    }

    public EDiaLibre(int idDia, String fecha, EMotivoAusencia motivo) {
        this.idDia = idDia;
        this.fecha = fecha;
        this.motivo = motivo;
    }
}
