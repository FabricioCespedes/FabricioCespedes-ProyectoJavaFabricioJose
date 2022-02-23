/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import AccesoDatos.CronogramasDAO;
import Entidades.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Progra
 */
public class CronogramaBLO {

    private String msg;
    
    CronogramasDAO cronogramaDAO;
    List<EDiaFeriado> listaDiasFeriados;
    List<EDiaAusente> listaDiasAusentes;

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con los
     * cronogramas que se han registrado
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Un List con los datos de los cronogramas que coincidieron con la
     * condición
     * @throws Exception Arroja una excepción genérica
     */
    public List<EModuloCronograma> listar(String condicion) throws Exception {
        List<EModuloCronograma> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listar(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * días feriados de un año.
     *
     * @param anio recibe por parámetro un año.
     * @return Retorna la lista de feriados de un año-
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */
    public List<EDiaFeriado> listarDias(int anio) throws Exception {
        List<EDiaFeriado> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarDias(anio);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los que
     * se ausentó un profesor.
     *
     * @param profesor Recibe el profesor el cuál quiere revisar cuales días
     * falto.
     * @param fechaInicio Recibe la fecha de inicio de la cual se quiere empezar
     * a revisar.
     * @return Retorna una lista de días ausentes.
     * @throws Exception Arroja una excepción genérica
     */
    public List<EDiaAusente> listarDias(EProfesor profesor, String fechaInicio) throws Exception {
        List<EDiaAusente> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarDias(profesor, fechaInicio);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * profesores de un módulo de un programa.
     * @param cronograma Recibe un objeto un cronograma.
     * @return Retorna una lista de profesores.
     * @throws Exception Arroja una excepción genérica
     */
    public List<EProfesor> listar(EModuloCronograma cronograma) throws Exception {
        List<EProfesor> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return lista;

    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * módulos registrados.
     * @param condicion Condicion por la que se quiere filtrar en base de datos
     * @return Objeto List con los módulos encontrados en la base de datos
     * @throws Exception Arroja una excepción genérica
     */
    public List<EModulo> listarModulos(String condicion) throws Exception {
        List<EModulo> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarModulos(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * programas registrados.
     * @param condicion Condicion por la que se quiere filtrar en base de datos
     * @return Objeto List con los programas encontrados en la base de datos
     * @throws Exception Arroja una excepción genérica
     */
    public List<EPrograma> listarProgramas(String condicion) throws Exception {
        List<EPrograma> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarProgramas(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    /**
     Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * profesores registrados.
     * @param condicion Condicion por la que se quiere filtrar en base de datos
     * @return Objeto List con los profesores encontrados en la base de datos
     * @throws Exception Exception Arroja una excepción genérica
     */
    public List<EProfesor> listarProfesores(String condicion) throws Exception {
        List<EProfesor> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarProfesores(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos un cronograma según la
     * condición que se quiera filtrar.
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos.
     * @return Retorna un cronograma
     * @throws Exception Arroja una excepción genérica
     */
    public EModuloCronograma obtener(String condicion) throws Exception {
        EModuloCronograma cronograma;
        try {
            cronogramaDAO = new CronogramasDAO();
            cronograma = cronogramaDAO.obtener(condicion);
        } catch (Exception e) {
            throw e;
        }
        return cronograma;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que inserta en la base de datos un cronograma.
     *
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos.
     * @return Retorna -1 si no se pudo insertar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma, int idAsigPr) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertar(cronograma, idAsigPr);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que asigna un profesor a un modulo de un programa.
     *
     * @param cronograma Recibe un objeto cronógrama.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws Exception Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que actualiza en la base de datos un cronograma.
     *
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos.
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción genérica
     */
    public int actualizar(EModuloCronograma cronograma, int idAsigPr) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizar(cronograma, idAsigPr);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que actualiza en la base de datos una asignación de un
     * profesor a un módulo de un programa.
     *
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int actualizar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina en la base de datos un módulo de un
     * cronograma.
     *
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int eliminar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }
    
    /**
     * 
     * @param motivo
     * @return
     * @throws Exception 
     */
    public int insertarMotivo(EMotivoAusencia motivo) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertarMotivo(motivo);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }
    /**
     * 
     * @param motivo
     * @return
     * @throws Exception 
     */
    public int actualizarMotivo(EMotivoAusencia motivo) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizarMotivo(motivo);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }
    /**
     * 
     * @param motivo
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public int eliminarMotivo(EMotivoAusencia motivo) throws SQLException, Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminarMotivo(motivo);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina en la base de datos un cronograma
     *
     * @param idPrograma Valor en entero que recibe un id de un cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int eliminar(int idPrograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminar(idPrograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    /**
     * Este módulo se encarga de calcular el cronograma de un módulo.
     * @param cronograma Es el objeto EMóduloCronograma al que se le calculará su fecha fin.
     * @return Una cadena diciendo si el proceso se realizó correctamente.
     * @throws Exception  Arroja una excepción genérica
     */
    public String calcularCronograma(EModuloCronograma cronograma) throws Exception {
        Calendar calendario = Calendar.getInstance(); //Calendario que se va a rrecorrer
        EProfesor profe = new EProfesor(); //Objeto profesor que se usa en la evaluación 
        boolean existe = false;

        try {
            cronogramaDAO = new CronogramasDAO(); //Instancia de CronogramasDAO para acceder a la capa de datos.
            int mesInicio = Integer.parseInt(cronograma.getFechaInicio().substring(5, 7));//Se va a descomponer la cadena de la fecha inicial del modulo para extraer su mes de inicio.
            int dia = Integer.parseInt(cronograma.getFechaInicio().substring(8, 10));//Se va a descomponer la cadena de la fecha inicial del modulo para extraer su día de inicio.
            int anio = Integer.parseInt(cronograma.getFechaInicio().substring(0, 4)); //Se va a descomponer la cadena de la fecha inicial del modulo para extraer su año de inicio.
            listaDiasFeriados = cronogramaDAO.listarDias(anio);//Se listan los días feriados del año.
            profe = cronograma.getProfesor().get(0);//El objeto profesor se le asigna el primer profesor del ArrayList profesores del cronograma.
            listaDiasAusentes = cronogramaDAO.listarDias(profe, cronograma.getFechaInicio());//Se listan los dias que está ausente el profeosr
            double horaDia = 0;
            double horasPorDia = obtenerHorasDia(cronograma.getHoraInicio(), cronograma.getHoraFin());//Este método obtiene la cantodad de horas por día de un módulo
            int contadorHoras = 0;//Contador de las horas dadas que por día, se va a comparar con las horas totales del módulo
            for (int i = mesInicio; i < 12; i++) {//Aqui se comienza el recorrido del caledario, se inicia un for con el mes inicial y se rrecorren los meses
                calendario.set(anio, i, 1);//Al calendario se le da el año inicial, el mes que se está iterando y un día donde va a empezar
                int lastDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);//lastDay va a guardar el último día del mes que se está iterando
                int x = 0;
                if ((mesInicio) == i) {//Si el mes de inicio es igual al mes iterado
                    x = dia;//La variable x se le asigna el día extraído de la fecha inicial
                } else {
                    x = 1;//Si no se le asigna 1
                }
                for (; x <= lastDay; x++) { //Aqui se rrecorren los días del mes, desde el día que se asignó anteriormente hasta el último día del mes

                    if (contadorHoras == cronograma.getModulo().getHorasTotales()) {//Cuando el contador de horas es el mismo que las horas totales del módulo 
                        cronograma.setFechaFin(anio + "/" + i + "/" + x);//A la fecha fin del cronograma se le asignará la fecha que se lleva iterada
                        break;
                    } else {
                        if (i == 12 && x == 31) {//Si el mes llega a ser el último del año y se llega a su último día 
                            anio++;//Se cambia de año para iterrar
                            listaDiasFeriados = cronogramaDAO.listarDias(anio);//Se vuelven a listar los días feriado pero del nuevo año
                        }
                        if (!revisarDia(anio + "/" + i + "/" + x)) {//Se revisa si la fecha iterada está en los dias de ausencia o la lista de dias feriados
                            contadorHoras += horasPorDia;//Si el resultado es negativo se le suman las horas por día
                        }
                    }
                }

                if (cronogramaDAO.obtener("idModulo = " + cronograma.getModulo().getIdModulo() + " and idPrograma = " + cronograma.getPrograma().getIdPrograma()) != null) {//Si se obtiene un cronograma de módulo que tenga el mismo ID de módulo y el mismo ID de programa
                    int ac1 = actualizar(cronograma);//Se actualiza la asignación cronograma
                    if (ac1 > -1) {
                        int actCro = actualizar(cronograma, ac1);//Se actualiza el cronograma del módulo
                        msg = "Cronograma calculado y actualizado";
                    }
                } else {
                    int insAsig = insertar(cronograma);//Se inserta la asignación cronograma
                    if (insAsig > -1) {
                        int insCro = insertar(cronograma, insAsig);//Se inserta el cronograma del módulo
                        msg = "Cronograma calculado y insertado";
                    }

                }

            }

        } catch (Exception e) {
            throw e;
        }
        return msg;
    }
    /**
     * Este método se encarga de calcular horas diarias 
     * @param inicio Recibe una cadena con la hora inicial
     * @param fin Recibe una cadena con la hora final
     * @return La diferencia entre las horas
     */
    private static double obtenerHorasDia(String inicio, String fin) {
        int horaInicio = Integer.parseInt(inicio.substring(0, 2));
        int minutoInicio = Integer.parseInt(inicio.substring(3, 5));
        int horaFin = Integer.parseInt(fin.substring(0, 2));
        int minutoFin = Integer.parseInt(fin.substring(3, 5));
        double resultado = 0;
        if (minutoInicio != 0 && ((horaInicio + 1) == horaFin)) {
            return 0.5;
        }
        while (horaInicio < horaFin) {
            resultado++;
            horaInicio++;
        }
        if (minutoInicio != minutoFin) {
            resultado += 0.5;
        }
        return resultado;
    }
    /**
     * Este método revisa si una fecha está en la lista de días ausentes o la lista de días feriados
     * @param fecha Cadena con la fecha que se va a comparar en las listas
     * @return Un booleano verdadero si encontro la fecha en algunas de las listas o falso si no lo encontró
     */
    private boolean revisarDia(String fecha) {
        boolean bandera = false;

        if (listaDiasAusentes.contains(fecha) || listaDiasFeriados.contains(fecha)) {
            bandera = true;
        }

        return bandera;
    }
    /**
     * 
     * @param modulos recibe un objeto List con una lista de módulos
     * @param cronograma recibe un objeto cronograma para asignar
     * @return String con cadena que nos dice como salío el calculo del cronogra,
     * @throws SQLException
     * @throws Exception 
     */
    public String recibirModulos(List<EModulo> modulos, EModuloCronograma cronograma) throws SQLException, Exception {
        String mensaje = "";
        try {
            for (EModulo modulo : modulos) {
                cronograma.setModulo(modulo);
                calcularCronograma(cronograma);
            }

        } catch (Exception e) {
            throw e;
        }

        return mensaje;
    }
    /**
     * 
     * @param cronograma
     * @return
     * @throws Exception 
     */
    public int obtenerIdAsignacion(EModuloCronograma cronograma) throws Exception {
        int resultado;

        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.obtenerIdAsignacion(cronograma);
        } catch (Exception e) {
            throw e;
        }

        return resultado;
    }

}
