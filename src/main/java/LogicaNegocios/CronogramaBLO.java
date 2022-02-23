/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import AccesoDatos.CronogramasDAO;
import Entidades.*;
import com.sun.source.tree.TryTree;
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
     *
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

    public String calcularCronograma(EModuloCronograma cronograma) throws Exception {
        Calendar calendario = Calendar.getInstance();
        EProfesor profe = new EProfesor();
        boolean existe = false;

        try {
            cronogramaDAO = new CronogramasDAO();
            int mesInicio = Integer.parseInt(cronograma.getFechaInicio().substring(5, 7));
            int dia = Integer.parseInt(cronograma.getFechaInicio().substring(8, 10));
            int anio = Integer.parseInt(cronograma.getFechaInicio().substring(0, 4));
            listaDiasFeriados = cronogramaDAO.listarDias(anio);
            profe = cronograma.getProfesor().get(0);
            listaDiasAusentes = cronogramaDAO.listarDias(profe, cronograma.getFechaInicio());
            double horaDia = 0;
            double horasPorDia = obtenerHorasDia(cronograma.getHoraInicio(), cronograma.getHoraFin());
            int contadorHoras = 0;
            for (int i = mesInicio; i < 12; i++) {
                calendario.set(anio, i, 1);
                int lastDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
                int x = 0;
                if ((mesInicio) == i) {
                    x = dia;
                } else {
                    x = 1;
                }
                for (; x <= lastDay; x++) {

                    if (contadorHoras == cronograma.getModulo().getHorasTotales()) {
                        cronograma.setFechaFin(anio + "/" + i + "/" + x);
                        break;
                    } else {
                        if (i == 12 && x == 31) {
                            anio++;
                            listaDiasFeriados = cronogramaDAO.listarDias(anio);
                        }
                        if (!revisarDia(anio + "/" + i + "/" + x)) {
                            contadorHoras += horasPorDia;
                        }

                    }
                }

                if (cronogramaDAO.obtener("idModulo = " + cronograma.getModulo().getIdModulo() + " and idPrograma = " + cronograma.getPrograma().getIdPrograma()) != null) {
                    int ac1 = actualizar(cronograma);//Updates
                    if (ac1 > -1) {
                        int actCro = actualizar(cronograma, ac1);
                        msg = "Cronograma calculado y insertado";
                    }
                } else {
                    int insAsig = insertar(cronograma);//Inserts
                    if (insAsig > -1) {
                        int insCro = insertar(cronograma, insAsig);
                        msg = "Cronograma calculado y modificado";
                    }

                }

            }

        } catch (Exception e) {
            throw e;
        }
        return msg;
    }

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

    private boolean revisarDia(String fecha) {
        boolean bandera = false;

        if (listaDiasAusentes.contains(fecha) || listaDiasFeriados.contains(fecha)) {
            bandera = true;
        }

        return bandera;
    }

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
