package AccesoDatos;

import Entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 *
 * @author Progra
 */
public class CronogramasDAO {

    private Connection _cnn = null;
    private String msg;

    public CronogramasDAO() throws SQLException, Exception {
        String url = Config.getConnectionString();
        try {
            _cnn = DriverManager.getConnection(url);

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw new Exception("Error genérico: " + e.getMessage());
        }
    }

    /**
     * Este método se encarga de traer de la base de datos una lista con los
     * cronogramas que se han registrado
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Un List con los datos de los cronogramas que coincidieron con la
     * condición
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public List<EModuloCronograma> listar(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EModuloCronograma> list = new ArrayList<>();
        String query = "Select mc.fechaInicio, mc.fechaFin, mc.horasDia, mc.horaInicio, mc.horaFin, mc.estado, m.codigo, m.nombreModulo, m.idModuloRequerido, m.horasTotales, m.idModulo, p.idPrograma, p.codigo, p.nombrePrograma, p.horasDia, p.horaInicio, p.horaFin, p.estado, p.anio, p.grupo from ModulosCronogramas mc inner join Modulos m on mc.idModulo = m.idModulo inner join Programas p on p.idPrograma = mc.idPrograma";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }

        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            while (rs != null && rs.next()) {

                EModulo modulo = new EModulo();
                EPrograma programa = new EPrograma();
                EModuloCronograma cronograma = new EModuloCronograma();
                cronograma.setFechaInicio(rs.getString(1));
                cronograma.setFechaFin(rs.getString(2));
                cronograma.setHorasDia(rs.getString(3));
                cronograma.setHoraInicio(rs.getString(4));
                cronograma.setHoraFin(rs.getString(5));
                cronograma.setEstado(rs.getString(6));
                modulo.setCodigo(rs.getString(7));
                modulo.setNombreModulo(rs.getString(8));
                if (rs.getInt(9) != 0) {
                    EModulo moduloReq = new EModulo();
                    moduloReq.setIdModulo(rs.getInt(9));
                    modulo.setModuloRequerido(moduloReq);
                }else{
                    EModulo moduloReq = new EModulo();
                    moduloReq.setIdModulo(0);
                   modulo.setModuloRequerido(modulo);
                }
                modulo.setHorasTotales(rs.getInt(10));
                modulo.setIdModulo(rs.getInt(11));
                programa.setIdPrograma(rs.getInt(12));
                programa.setCodigo(rs.getString(13));
                programa.setNombrePrograma(rs.getString(14));
                programa.setHorasDia(rs.getString(15));
                programa.setHorasInicio(rs.getString(16));
                programa.setHorasFin(rs.getString(17));
                programa.setEstado(rs.getString(18));
                programa.setAnio(rs.getInt(19));
                programa.setGrupo(rs.getInt(20));
                cronograma.setModulo(modulo);
                cronograma.setPrograma(programa);
                list.add(cronograma);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return list;
    }

    /**
     * Método que lista todos días feriados de un año.
     *
     * @param anio recibe por parámetro un año.
     * @return Retorna la lista de feriados de un año-
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public List<EDiaFeriado> listarDias(int anio) throws SQLException, Exception {
        ResultSet rs = null;
        List<EDiaFeriado> lista = new ArrayList<>();
        String query = "SELECT * FROM DiasFeriados WHERE YEAR(fecha) = " + anio;
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EDiaFeriado dia = new EDiaFeriado();
                EMotivoAusencia motivo = new EMotivoAusencia();
                dia.setIdDia(rs.getInt(1));
                dia.setFecha(rs.getString(2));
                motivo.setMotivo(rs.getString(3));
                dia.setMotivo(motivo);
                lista.add(dia);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Método que retorna una lista de los días de ausencia de un profesor.
     *
     * @param profesor Recibe el profesor el cuál quiere revisar cuales días
     * falto.
     * @param fechaInicio Recibe la fecha de inicio de la cual se quiere empezar
     * a revisar.
     * @return Retorna una lista de días ausentes
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public List<EDiaAusente> listarDias(EProfesor profesor, String fechaInicio) throws SQLException, Exception {
        ResultSet rs = null;
        List<EDiaAusente> lista = new ArrayList<>();
        String query = "SELECT fechaInicio, fechaFin, idMotivo FROM DiasAusentes WHERE fechaInicio >= " + fechaInicio + " and idProfesor = " + profesor.getIdPersona();
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EDiaAusente dia = new EDiaAusente();
                EMotivoAusencia motivo = new EMotivoAusencia();
                dia.setFecha(rs.getString(1));
                dia.setFechaFin(rs.getString(2));
                motivo.setMotivo(rs.getString(3));
                dia.setMotivo(motivo);
                lista.add(dia);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Método que retorna la lista de profesores de un módulo de un programa.
     *
     * @param cronograma Recibe un objeto un cronograma.
     * @return Retorna una lista de profesores.
     * @throws SQLException Retorna excepción sql.
     * @throws Exception Retorna excepción genérica.
     */
    public List<EProfesor> listar(EModuloCronograma cronograma) throws SQLException, Exception {
        ResultSet rs = null;
        List<EProfesor> lista = new ArrayList<>();
        String query = "SELECT p.idProfesor,p.nombreProfesor, p.apellido1Profesor, p.apellido2Profesor , c.nombre, a.fechaInicio,a.fechaFin FROM AsignacionProfesor a inner join Profesores p on a.idProfesor = p.idProfesor inner join Centros c on c.idCentro = p.idCentro where idPrograma = " + cronograma.getPrograma().getIdPrograma() + " and idModulo = " + cronograma.getModulo().getIdModulo();
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EProfesor profesor = new EProfesor();
                ECentro centro = new ECentro();
                profesor.setIdPersona(rs.getLong(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellido1(rs.getString(3));
                if (!"".equals(rs.getString(4))) {
                    profesor.setApellido2(rs.getString(4));
                }
                centro.setNombre(rs.getString(5));
                profesor.setFechaInicio(rs.getString(6));
                profesor.setFechaFin(rs.getString(7));
                profesor.setCentro(centro);
                lista.add(profesor);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Método que retorna la lista de los modulos registrados
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los módulos requeridos
     * @throws SQLException Retorna excepción sql.
     * @throws Exception Retorna excepción genérica.
     */
    public List<EModulo> listarModulos(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EModulo> lista = new ArrayList<>();
        String query = "SELECT idModulo, codigo, nombreModulo, idModuloRequerido, horasTotales FROM Modulos";
        if (!condicion.equals("")) {
            query += " WHERE " + condicion;
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EModulo modulo = new EModulo();
                modulo.setIdModulo(rs.getInt(1));
                modulo.setCodigo(rs.getString(2));
                modulo.setNombreModulo(rs.getString(3));
                EModulo moduloReq = new EModulo();
                moduloReq.setIdModulo(rs.getInt(4));
                modulo.setModuloRequerido(moduloReq);
                modulo.setHorasTotales(rs.getDouble(5));
                lista.add(modulo);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Método que retorna la lista de los programas registrados
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los módulos requeridos
     * @throws SQLException Retorna excepción sql.
     * @throws Exception Retorna excepción genérica.
     */
    public List<EPrograma> listarProgramas(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EPrograma> lista = new ArrayList<>();
        String query = "SELECT idPrograma, codigo, nombrePrograma, horasDia, horaInicio, horaFin, estado, anio, idCentro, grupo FROM Programas";
        if (!condicion.equals("")) {
            query += " WHERE " + condicion;
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EPrograma programa = new EPrograma();
                programa.setIdPrograma(rs.getInt(1));
                programa.setCodigo(rs.getString(2));
                programa.setNombrePrograma(rs.getString(3));
                programa.setHorasDia(rs.getString(4));
                programa.setHorasInicio(rs.getString(5));
                programa.setHorasFin(rs.getString(6));
                programa.setEstado(rs.getString(7));
                programa.setAnio(rs.getInt(8));
                ECentro centro = new ECentro();
                centro.setIdCentro(rs.getInt(9));
                programa.setCentro(centro);
                lista.add(programa);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Método que retorna la lista de los profesores registrados
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los módulos requeridos
     * @throws SQLException Retorna excepción sql.
     * @throws Exception Retorna excepción genérica.
     */
    public List<EProfesor> listarProfesores(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EProfesor> lista = new ArrayList<>();
        String query = "SELECT idProfesor, nombreProfesor, apellido1Profesor, apellido2Profesor, idCentro FROM Profesores";
        if (!condicion.equals("")) {
            query += " WHERE " + condicion;
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EProfesor profesor = new EProfesor();
                profesor.setIdPersona(rs.getInt(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellido1(rs.getString(3));
                profesor.setApellido2(rs.getString(4));
                ECentro centro = new ECentro();
                centro.setIdCentro(rs.getInt(5));
                profesor.setCentro(centro);
                lista.add(profesor);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Este método devuelve un cronograma según la condición por la que se
     * quiera fitrar
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos.
     * @return Retorna un cronograma.
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public EModuloCronograma obtener(String condicion) throws SQLException, Exception {
        EModuloCronograma cronograma = new EModuloCronograma();

        ResultSet rs = null;
        String query = "Select mc.fechaInicio, mc.fechaFin, mc.horasDia, mc.horaInicio, mc.horaFin, mc.estado, m.codigo, m.nombreModulo, m.idModuloRequerido, m.horasTotales, m.idModulo, p.idPrograma, p.codigo, p.nombrePrograma, p.horasDia, p.horaInicio, p.horaFin, p.estado, p.anio, p.grupo from ModulosCronogramas mc inner join Modulos m on mc.idModulo = m.idModulo inner join Programas p on p.idPrograma = mc.idPrograma";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                EModulo modulo = new EModulo();
                EPrograma programa = new EPrograma();
                cronograma.setFechaInicio(rs.getString(1));
                cronograma.setFechaFin(rs.getString(2));
                cronograma.setHorasDia(rs.getString(3));
                cronograma.setHoraInicio(rs.getString(4));
                cronograma.setHoraFin(rs.getString(5));
                cronograma.setEstado(rs.getString(6));
                modulo.setCodigo(rs.getString(7));
                modulo.setNombreModulo(rs.getString(8));
                if (rs.getInt(9) != 0) {
                    EModulo moduloReq = new EModulo();
                    moduloReq.setIdModulo(rs.getInt(9));
                    modulo.setModuloRequerido(moduloReq);
                }
                modulo.setHorasTotales(rs.getInt(10));
                modulo.setIdModulo(rs.getInt(11));
                programa.setIdPrograma(rs.getInt(12));
                programa.setCodigo(rs.getString(13));
                programa.setNombrePrograma(rs.getString(14));
                programa.setHorasDia(rs.getString(15));
                programa.setHorasInicio(rs.getString(16));
                programa.setHorasFin(rs.getString(17));
                programa.setEstado(rs.getString(18));
                programa.setAnio(rs.getInt(19));
                programa.setGrupo(rs.getInt(20));
                cronograma.setModulo(modulo);
                cronograma.setPrograma(programa);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return cronograma;
    }

    /**
     * Método que inserta un cronograma en la base de datos
     *
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos
     * @return Retorna -1 si no se pudo insertar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma, int idAsigPr) throws SQLException, Exception {
        int result = -1;

        String query = "Insert into ModulosCronogramas (idModulo, idAsignacionProfe, idPrograma, fechaInicio, fechaFin, horaInicio, horaFin, horasDia, estado) Values(?,?,?,?,?,?,?,?,?)";
        ResultSet rs = null;
        try {

            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cronograma.getModulo().getIdModulo());
            ps.setInt(2, idAsigPr);
            ps.setInt(3, cronograma.getPrograma().getIdPrograma());
            ps.setString(4, cronograma.getFechaInicio());
            ps.setString(5, cronograma.getFechaFin());
            ps.setString(6, cronograma.getHoraInicio());
            ps.setString(7, cronograma.getHoraFin());
            ps.setDouble(8, Double.parseDouble(cronograma.getHorasDia()));
            ps.setString(9, cronograma.getEstado());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
                msg = "Cronograma almacenado con éxito";
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Este método obtiene la identificación de la asignación de un profesor
     *
     * @param cronograma Parámetro que recibe objeto cronograma para filtrar los
     * datos según sus IDs
     * @return Retorna un valor entero con la identificación de una asignación
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */


    /**
     * Método que asigna profesor a un modulo de un programa
     *
     * @param cronograma Recibe un objeto cronógrama.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws SQLException Si ahí un error en base de datos retorna un error
     * SQL Server.
     * @throws Exception Retorna un error genérico.
     */
    public int insertar(EModuloCronograma cronograma) throws SQLException, Exception {
        int result = -1;

        String query = "Insert into AsignacionProfesor (idModulo, idPrograma, fechaInicio, fechaFin, idProfesor) Values(?,?,?,?,?)";
        ResultSet rs = null;
        try {

            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cronograma.getModulo().getIdModulo());
            ps.setInt(2, cronograma.getPrograma().getIdPrograma());
            ps.setString(3, cronograma.getHoraInicio());
            ps.setString(4, cronograma.getHoraFin());
            ps.setLong(5, (long) cronograma.getProfesor().get(0).getIdPersona());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
                msg = "Profesor asignado con almacenado con éxito";
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que actualiza un modulo cronograma
     *
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int actualizar(EModuloCronograma cronograma, int idAsigPr) throws SQLException, Exception {
        int result = -1;

        String query = "Update ModulosCronogramas idAsignacionProfe=?, fechaInicio=?, fechaFin=?, horaInicio=?, horaFin=?, horasDia=?, estado=? Where idModulo=? and idPrograma=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setInt(8, cronograma.getModulo().getIdModulo());
            ps.setInt(1, idAsigPr);
            ps.setInt(9, cronograma.getPrograma().getIdPrograma());
            ps.setString(2, cronograma.getFechaInicio());
            ps.setString(3, cronograma.getFechaFin());
            ps.setString(4, cronograma.getHoraInicio());
            ps.setString(5, cronograma.getHoraFin());
            ps.setString(6, cronograma.getHorasDia());
            ps.setString(7, cronograma.getEstado());
            ps.executeUpdate();

            if (result > 0) {
                msg = "Modulo del cronograma actualizado con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que actualiza una asignación de profesor de un modulo de un
     * programa.
     *
     * @param cronograma Recibe un objeto cronógrama.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws SQLException Si ahí un error en base de datos retorna un error
     * SQL Server.
     * @throws Exception Retorna un error genérico.
     */
    public int actualizar(EModuloCronograma cronograma) throws SQLException, Exception {
        int result = -1;

        String query = "Update AsignacionProfesor fechaInicio=?, fechaFin=? Where idModulo=? and idPrograma=? and idProfesor=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setInt(3, cronograma.getModulo().getIdModulo());
            ps.setInt(4, cronograma.getPrograma().getIdPrograma());
            ps.setString(1, cronograma.getHoraInicio());
            ps.setString(2, cronograma.getHoraFin());
            ps.setLong(5, (long) cronograma.getProfesor().get(0).getIdPersona());
            ps.executeUpdate();
            if (result > 0) {
                msg = "Asignación de profesor actualizada con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que elimina un modulo cronograma
     *
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int eliminar(EModuloCronograma cronograma) throws SQLException, Exception {
        int result = -1;

        String query = String.format("Delete ModulosCronogramas Where idModulo=%d and idPrograma=%d", cronograma.getModulo().getIdModulo(), cronograma.getPrograma().getIdPrograma());
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.execute(query);

            if (result > 0) {
                msg = "Modulo cronograma eliminado con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que elimina la totalidad de un cronograma.
     *
     * @param idPrograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int eliminar(int idPrograma) throws SQLException, Exception {
        int result = -1;

        String query = String.format("Delete ModulosCronogramas Where idPrograma=%d", idPrograma);
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Cronograma eliminado con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que retorna la lista de los motivos registrados
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los módulos requeridos
     * @throws SQLException Retorna excepción sql.
     * @throws Exception Retorna excepción genérica.
     */
    public List<EMotivoAusencia> listarMotivos(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EMotivoAusencia> lista = new ArrayList<>();
        String query = "SELECT idMotivo, justificacion FROM MotivosDeAusencias";
        if (!condicion.equals("")) {
            query += " WHERE " + condicion;
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EMotivoAusencia motivo = new EMotivoAusencia();
                motivo.setIdMotivoAusencia(rs.getInt(1));
                motivo.setMotivo(rs.getString(2));
                lista.add(motivo);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Este método obtiene un motivo de ausencia
     *
     * @param condicion condicion para filtrar por la base de datos
     * @return Retorna un valor entero con la identificación de una asignación
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */
    public EMotivoAusencia obtenerMotivo(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EMotivoAusencia motivo = new EMotivoAusencia();
        String query = "Select idMotivo, justificacion  from MotivosDeAusencias";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                motivo.setIdMotivoAusencia(rs.getInt(1));
                motivo.setMotivo(rs.getString(2));
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return motivo;
    }

    /**
     * Método que inserta un motivo de ausencia en la base de datos
     *
     * @param motivo Objeto EMotivoAsencia con la información a insertar en la
     * base de datos
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws SQLException Si ahí un error en base de datos retorna un error
     * SQL Server.
     * @throws Exception Retorna un error genérico.
     */
    public int insertarMotivo(EMotivoAusencia motivo) throws SQLException, Exception {
        int result = -1;

        String query = "Insert into MotivosDeAusencias (justificacion) Values(?)";
        ResultSet rs = null;
        try {

            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, motivo.getMotivo());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
                msg = "Motivo almacenado con éxito";
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método se encarga de modificar un motivo de ausencia
     *
     * @param motivo Objeto EMotivoAsencia con la información a modificar en la
     * base de datos
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int actualizarMotivo(EMotivoAusencia motivo) throws SQLException, Exception {
        int result = -1;

        String query = "Update MotivosDeAusencias set justificacion=? Where idMotivo=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setString(1, motivo.getMotivo());
            ps.setInt(2, motivo.getIdMotivoAusencia());
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Motivo actualizado con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método encarga de elminar un motivo de ausencia
     *
     * @param motivo Objeto EMotivoAsencia con la información a eliminar en la
     * base de datos
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int eliminarMotivo(EMotivoAusencia motivo) throws SQLException, Exception {
        int result = -1;

        String query = "Delete MotivosDeAusencias Where idMotivo=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setInt(1, motivo.getIdMotivoAusencia());
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Motivo eliminado";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que inserta un día de ausencia en la base de datos
     *
     * @param diaA objeto EDiaAusente con día que se insertará
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int insertarDiaA(EDiaAusente diaA) throws SQLException, Exception {
        int result = -1;
        String query = "Insert into DiasAusentes (fechaInicio, fechaFin, idProfesor, idMotivo) Values(?,?,?,?)";
        ResultSet rs = null;
        try {

            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, diaA.getFecha());
            ps.setString(2, diaA.getFechaFin());
            ps.setLong(3, diaA.getProfesor().getIdPersona());
            ps.setInt(4, diaA.getMotivo().getIdMotivoAusencia());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
                msg = "Ausencia almacenada con éxito";
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que se encarga de modificar un dia ausente
     *
     * @param diaA Es el objeto EDiaAusente nuevo que tiene la información nueva
     * que sustituir
     * @param diaAAnterior Es el objeto EDiaAusente anterior para identificar
     * donde sustituir
     * @return Retorna -1 si no se pudo modificar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int actualizarDiaA(EDiaAusente diaA, EDiaAusente diaAAnterior) throws SQLException, Exception {
        int result = -1;

        String query = "Update DiasAusentes set fechaInicio=?, fechaFin=?, idProfesor=?, idMotivo=? Where fechaInicio=? and fechaFin=? and idProfesor=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setString(1, diaA.getFecha());
            ps.setString(2, diaA.getFechaFin());
            ps.setLong(3, diaA.getProfesor().getIdPersona());
            ps.setInt(4, diaA.getMotivo().getIdMotivoAusencia());
            ps.setString(5, diaAAnterior.getFecha());
            ps.setString(6, diaAAnterior.getFechaFin());
            ps.setLong(7, diaAAnterior.getProfesor().getIdPersona());
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Día ausente actualizado con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Método que se encarga de eliminar un dia ausente
     *
     * @param diaA Es el objeto EDiaAusente que tiene la información de donde
     * eliminar
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción génerica
     */
    public int eliminarDiaA(EDiaAusente diaA) throws SQLException, Exception {
        int result = -1;

        String query = "Delete DiasAusentes Where fechaInicio=? and fechaFin=? and idProfesor=? and idMotivo=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setString(1, diaA.getFecha());
            ps.setString(2, diaA.getFechaFin());
            ps.setLong(3, diaA.getProfesor().getIdPersona());
            ps.setInt(4, diaA.getMotivo().getIdMotivoAusencia());
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Día ausente eliminado";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }

    /**
     * Este método obtiene un EDiaAusente de la tabla de datos
     *
     * @param condicion condición para filtrar por la base de datos
     * @return Retorna un EDiaAusente necesitado según la condición
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */
    public EDiaAusente obtenerDiaA(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EDiaAusente dia = new EDiaAusente();
        String query = "Select fechaInicio, fechaFin, idProfesor, idMotivo  from DiasAusentes inner join Motivos";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                EProfesor profesor = new EProfesor();
                EMotivoAusencia motivo = new EMotivoAusencia();
                dia.setFecha(rs.getString(1));
                dia.setFechaFin(rs.getString(2));
                profesor.setIdPersona(rs.getLong(3));
                motivo.setIdMotivoAusencia(rs.getInt(4));
                dia.setProfesor(profesor);
                dia.setMotivo(motivo);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return dia;
    }

    /**
     * Método que retorna la lista de los dias ausentes registrados
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los dias ausentes requeridos
     * @throws SQLException Retorna excepción sql.
     * @throws Exception Retorna excepción genérica.
     */
    public List<EDiaAusente> listarDiasA(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EDiaAusente> lista = new ArrayList<>();
        String query = "Select fechaInicio, fechaFin, idProfesor, DiasAusentes.idMotivo  from DiasAusentes inner join MotivosDeAusencias on DiasAusentes.idMotivo = MotivosDeAusencias.idMotivo";
        if (!condicion.equals("")) {
            query += " WHERE " + condicion;
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EDiaAusente diaA = new EDiaAusente();
                EProfesor profesor = new EProfesor();
                EMotivoAusencia motivo = new EMotivoAusencia();
                diaA.setFecha(rs.getString(1));
                diaA.setFechaFin(rs.getString(2));
                profesor.setIdPersona(rs.getLong(3));
                motivo.setIdMotivoAusencia(rs.getInt(4));
                diaA.setProfesor(profesor);
                diaA.setMotivo(motivo);
                lista.add(diaA);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    /**
     * Este método obtiene un profesor de la base de datos
     *
     * @param condicion condicion para filtrar por la base de datos
     * @return Retorna un valor entero con la información de un profesor
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */
    public EProfesor obtenerProfesor(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EProfesor profesor = new EProfesor();
        String query = "Select idProfesor, nombreProfesor, apellido1Profesor, apellido2Profesor, idCentro  from Profesores";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                ECentro centro = new ECentro();
                profesor.setIdPersona(rs.getLong(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellido1(rs.getString(3));
                profesor.setApellido2(rs.getString(4));
                centro.setIdCentro(rs.getInt(5));
                profesor.setCentro(centro);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return profesor;
    }
    
    public List<EDiaFeriado> listarDiasF(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EDiaFeriado> lista = new ArrayList<>();
        String query = "SELECT idDiaFeriado, fecha, DiasFeriados.idMotivo FROM DiasFeriados inner join MotivosDeAusencias on DiasFeriados.idMotivo = MotivosDeAusencias.idMotivo";
        if (!condicion.equals("")) {
            query += " WHERE "+condicion;
        }
        try {
            Statement statement = _cnn.createStatement();            
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EDiaFeriado diaF = new EDiaFeriado();
                diaF.setIdDia(rs.getInt(1));
                diaF.setFecha(rs.getString(2));
                EMotivoAusencia motivo = new EMotivoAusencia();
                motivo.setIdMotivoAusencia(rs.getInt(3));
                diaF.setMotivo(motivo);
                lista.add(diaF);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }
    
    public EDiaFeriado obtenerFeriado(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EDiaFeriado feriado = new EDiaFeriado();
        String query = "Select idDiaFeriado, fecha, idMotivo from DiasFeriados";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                EMotivoAusencia motivo = new EMotivoAusencia();
                feriado.setIdDia(rs.getInt(1));
                feriado.setFecha(rs.getString(2));
                motivo.setIdMotivoAusencia(rs.getInt(3));
                feriado.setMotivo(motivo);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return feriado;
    }
     
    public int insertarDiaF(EDiaFeriado feriado) throws SQLException, Exception {
        int result = -1;

        String query = "Insert into DiasFeriados (fecha, idMotivo) Values(?,?)";
        ResultSet rs = null;
        try {

            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, feriado.getFecha());
            ps.setInt(2, feriado.getMotivo().getIdMotivoAusencia());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
                msg = "Día feriado con almacenado con éxito";
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
     }
     
    public int actualizarDiaF(EDiaFeriado feriado) throws SQLException, Exception {
        int result = -1;

        String query = "Update DiasFeriados set fecha=?, idMotivo=? Where idDiaFeriado=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setString(1, feriado.getFecha());
            ps.setInt(2, feriado.getMotivo().getIdMotivoAusencia());
            ps.setLong(3,feriado.getIdDia());
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Día feriado actualizado con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }
     
    public int eliminarDiaF(EDiaFeriado feriado) throws SQLException, Exception {
        int result = -1;

        String query = "Delete DiasFeriados Where idDiaFeriado=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setInt(1, feriado.getIdDia());
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Día feriado eliminado";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }
    
    public EModuloCronograma obtenerCronograma(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EModuloCronograma cronograma = new EModuloCronograma();
        String query = "Select idModulo, idAsignacionProfe, idPrograma, fechaInicio, fechaFin, horasDia, estado, horaInicio, horafin  from ModulosCronogramas";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                EPrograma programa = new EPrograma();
                EModulo modulo = new EModulo();
                modulo.setIdModulo(rs.getInt(1));
                //profesor.setNombre(rs.getString(2));
                programa.setIdPrograma(rs.getInt(3));
                cronograma.setModulo(modulo);
                cronograma.setPrograma(programa);
                cronograma.setFechaInicio(rs.getString(4));
                cronograma.setFechaFin(rs.getString(5));
                cronograma.setHorasDia(rs.getString(6));
                cronograma.setEstado(rs.getString(7));
                cronograma.setHoraInicio(rs.getString(8));
                cronograma.setHoraFin(rs.getString(9));
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return cronograma;
    }
    
    public EPrograma obtenerPrograma(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EPrograma programa = new EPrograma();
        String query = "Select idPrograma, codigo, nombrePrograma, horasDia, horaInicio, horaFin, estado, anio, idCentro  from Programas";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                ECentro centro = new ECentro();
                programa.setIdPrograma(rs.getInt(1));
                programa.setCodigo(rs.getString(2));
                programa.setNombrePrograma(rs.getString(3));
                programa.setHorasDia(rs.getString(4));
                programa.setHorasInicio(rs.getString(5));
                programa.setHorasFin(rs.getString(6));
                programa.setEstado(rs.getString(7));
                programa.setAnio(rs.getInt(8));
                centro.setIdCentro(rs.getInt(9));
                programa.setCentro(centro);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return programa;
    }
    
    public EModulo obtenerModulo(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        EModulo modulo = new EModulo();
        String query = "Select idModulo, codigo, nombreModulo, idModuloRequerido, horasTotales from Modulos";
        if (!condicion.equals("")) {
            query = String.format("%s Where %s", query, condicion);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                EModulo moduloReq = new EModulo();
                modulo.setIdModulo(rs.getInt(1));
                modulo.setCodigo(rs.getString(2));
                modulo.setNombreModulo(rs.getString(3));
                if (rs.getInt(4) != 0) {
                    moduloReq.setIdModulo(0);
                    modulo.setModuloRequerido(moduloReq);
                }
                else{
                    moduloReq.setIdModulo(rs.getInt(4));
                    modulo.setModuloRequerido(moduloReq);
                }
                modulo.setHorasTotales(rs.getInt(5));
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return modulo;
    }
    

    public String getMessage() {
        return msg;
    }

    public List<EDia> listarDiasPrograma(String condicion) throws SQLException, Exception {
        ResultSet rs = null;
        List<EDia> lista = new ArrayList<>();
        String query = "SELECT d.idDia, d.dia FROM Dias d INNER JOIN ProgramasDias pd ON d.idDia = pd.idDia INNER JOIN Programas p ON p.idPrograma =pd.idPrograma ";
        if (!condicion.equals("")) {
            query += " WHERE " + condicion;
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                EDia dia = new EDia();
                dia.setIdDia(rs.getInt(1));
                dia.setDia(rs.getString(2));
                lista.add(dia);
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return lista;
    }

    public boolean revisarFecha(String fecha) throws SQLException, Exception {
        ResultSet rs = null;
        boolean bandera = false;
        String query;
        query = "SELECT * from DiasAusentes where fechaFin >= '"+ fecha + "' and fechaInicio <= '"+fecha+"'";
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                bandera = true;
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return bandera;
    }
    
        public int insertarAsignacion(EModuloCronograma cronograma, EProfesor profe) throws SQLException, Exception {
            int result = -1;
            String query = "Insert into AsignacionProfesor (idPrograma, idModulo, idProfesor, fechaInicio, fechaFin) Values(?,?,?,?,?)";
            ResultSet rs = null;
            try {

                PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, cronograma.getPrograma().getIdPrograma());
                ps.setInt(2, cronograma.getModulo().getIdModulo());
                ps.setLong(3, profe.getIdPersona());
                ps.setString(4, profe.getFechaInicio());
                ps.setString(5, profe.getFechaFin());
                ps.execute();
                rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    result = rs.getInt(1);
                    msg = "Asignación almacenada con éxito";
                }
            } catch (SQLException sqlE) {
                throw sqlE;
            } catch (Exception e) {
                throw e;
            } finally {
                _cnn = null;
            }

            return result;
    }
        
    public int actualizarAsignacion(EModuloCronograma cronograma, EProfesor profe, int idAsi) throws SQLException, Exception {
        int result = -1;

        String query = "Update AsignacionProfesor set idPrograma=?, idModulo=?, idProfesor=?, fechaInicio=?, fechaFin=? Where idAsignacionProfe=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setInt(1, cronograma.getPrograma().getIdPrograma());
            ps.setInt(2, cronograma.getModulo().getIdModulo());
            ps.setLong(3, profe.getIdPersona());
            ps.setString(4, profe.getFechaInicio());
            ps.setString(5, profe.getFechaFin());
            ps.setInt(6, idAsi);
            result = ps.executeUpdate();
            if (result > 0) {
                msg = "asignación actualizada con exito";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }
    
    public int ElimnarAsignacion(int idAsi) throws SQLException, Exception {
        int result = -1;

        String query = "Delete AsignacionProfesor Where idAsignacionProfe = ?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(query);
            ps.setInt(1, idAsi);

            result = ps.executeUpdate();
            if (result > 0) {
                msg = "Asignación eliminada";
            }

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return result;
    }
    
        public int obtenerIdAsignacion(EModuloCronograma cronograma, EProfesor profesor) throws SQLException, Exception {
        int resultado = -1;

        ResultSet rs = null;
        String query = "Select idAsignacionProfe from AsignacionProfesor Where idModulo = " + cronograma.getModulo().getIdModulo() + " and idPrograma = " + cronograma.getPrograma().getIdPrograma() + " and idProfesor = " + profesor.getIdPersona();

        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                resultado = rs.getInt(1);
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception e) {
            throw e;
        } finally {
            _cnn = null;
        }

        return resultado;
    }

}
