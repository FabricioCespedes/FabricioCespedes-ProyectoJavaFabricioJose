/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author josea
 */
public class EMotivoAusencia {
    private int idMotivoAusencia;
    private String motivo;

    public int getIdMotivoAusencia() {
        return idMotivoAusencia;
    }

    public void setIdMotivoAusencia(int idMotivoAusencia) {
        this.idMotivoAusencia = idMotivoAusencia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return motivo;
    }
    
    public EMotivoAusencia() {
    }
    
    public EMotivoAusencia(int idMotivoAusencia, String motivo) {
        this.idMotivoAusencia = idMotivoAusencia;
        this.motivo = motivo;
    }
   
     
    
}
