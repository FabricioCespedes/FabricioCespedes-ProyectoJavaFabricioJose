/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;
import AccesoDatos.CronogramasDAO;
import Entidades.*;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Progra
 */
public class CronogramaBLO {
    private String msg;
    private CronogramasDAO ADCronograma;
    
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con los
     * cronogramas que se han registrado
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Un List con los datos de los cronogramas que coincidieron con la
     * condición
     * @throws Exception  Arroja una excepción genérica
     */
    public List<EModuloCronograma> listar(String condicion) throws Exception {
        List<EModuloCronograma> lista = null;
        
        try{
            ADCronograma = new CronogramasDAO();
            lista = ADCronograma.listar(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con
     * todos los días feriados de un año.
     * @param anio recibe por parámetro un año.
     * @return Retorna la lista de feriados de un año-
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception  Arroja una excepción genérica
     */
    public List<EDiaFeriado> listarDias(int anio) throws Exception {
        List<EDiaFeriado> lista = null;
        
        try{
            ADCronograma = new CronogramasDAO();
            lista = ADCronograma.listarDias(anio);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con
     * todos los que se ausentó un profesor.
     * @param profesor Recibe el profesor el cuál quiere revisar cuales días falto.
     * @param fechaInicio Recibe la fecha de inicio de la cual se quiere empezar a revisar.
     * @return Retorna una lista de días ausentes.
     * @throws Exception  Arroja una excepción genérica
     */
    public List<EDiaAusente> listarDias(EProfesor profesor, String fechaInicio) throws Exception {
        List<EDiaAusente> lista = null;
        
        try{
            ADCronograma = new CronogramasDAO();
            lista = ADCronograma.listarDias(profesor, fechaInicio);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con
     * todos los profesores de un módulo de un programa.
     * @param cronograma Recibe un objeto un cronograma.
     * @return Retorna una lista de profesores.
     * @throws Exception  Arroja una excepción genérica
     */
    public List<EProfesor> listar(EModuloCronograma cronograma) throws Exception {
        List<EProfesor> lista = null;
        
        try{
            ADCronograma = new CronogramasDAO();
            lista = ADCronograma.listar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos un cronograma según
     * la condición que se quiera filtrar.
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos.
     * @return Retorna un cronograma
     * @throws Exception  Arroja una excepción genérica
     */
    public EModuloCronograma obtener(String condicion) throws Exception {
        EModuloCronograma cronograma;
        try{
            ADCronograma = new CronogramasDAO();
            cronograma = ADCronograma.obtener(condicion);
        }
        catch (Exception e){
            throw e;
        }
        return cronograma;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que inserta en la base de datos un cronograma.
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos.  
     * @return Retorna -1 si no se pudo insertar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception  Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma, int idAsigPr) throws Exception {
        int resultado;
        try{
           ADCronograma = new CronogramasDAO();
            resultado = ADCronograma.insertar(cronograma, idAsigPr); 
        }
        catch (Exception e){
           throw e;
        }
        return resultado;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que asigna un profesor a un modulo de un programa.
     * @param cronograma Recibe un objeto cronógrama.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws Exception  Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try{
           ADCronograma = new CronogramasDAO();
            resultado = ADCronograma.insertar(cronograma); 
        }
        catch (Exception e){
           throw e;
        }
        return resultado;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que actualiza en la base de datos un cronograma.
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos.  
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception  Arroja una excepción genérica
     */
    public int actualizar(EModuloCronograma cronograma, int idAsigPr) throws Exception {
    int resultado;
        try{
           ADCronograma = new CronogramasDAO();
            resultado = ADCronograma.actualizar(cronograma, idAsigPr); 
        }
        catch (Exception e){
           throw e;
        }
        return resultado;
    
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que actualiza en la base de datos una asignación de 
     * un profesor a un módulo de un programa.
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int actualizar(EModuloCronograma cronograma) throws Exception {
    int resultado;
        try{
           ADCronograma = new CronogramasDAO();
            resultado = ADCronograma.actualizar(cronograma); 
        }
        catch (Exception e){
           throw e;
        }
        return resultado;
    
    }
    
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina en la base de datos un módulo de un
     * cronograma.
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int eliminar(EModuloCronograma cronograma) throws Exception {
       int resultado;
        try{
           ADCronograma = new CronogramasDAO();
            resultado = ADCronograma.eliminar(cronograma); 
        }
        catch (Exception e){
           throw e;
        }
        return resultado; 
    
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina en la base de datos un cronograma
     * @param idPrograma Valor en entero que recibe un id de un cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception  Arroja una excepción genérica
     */
    public int eliminar(int idPrograma) throws Exception {
        int resultado;
        try{
           ADCronograma = new CronogramasDAO();
            resultado = ADCronograma.eliminar(idPrograma); 
        }
        catch (Exception e){
           throw e;
        }
        return resultado;
    }

    
}
