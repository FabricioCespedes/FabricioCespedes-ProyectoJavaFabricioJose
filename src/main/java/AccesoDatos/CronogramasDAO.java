/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
     * Este método se encarga de traer de la base de datos una lista con los cronogramas que se han registrado
     * @param condicion Condicion por la que se quiere filtrar en la base de datos
     * @return Un List con los datos de los cronogramas que coincidieron con la condición
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de datos tenga un fallo
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
                }
                modulo.setHorasTotales(rs.getInt(10));
                modulo.setIdModulo(rs.getInt(11));
                programa.setIdPrograma(rs.getInt(12));
                programa.setCodigo(rs.getString(13));
                programa.setNombrePrograma(rs.getString(14));
                programa.setHorasDia(rs.getInt(15));
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
         * Este método devuelve un cronograma segun la condición por la que se quiera fitrar
         * @param condicion Condicion por la que se quiere filtrar en la base de datos
         * @throws SQLException Arroja un excepción de SQL en caso de que la base de datos tenga un fallo
         * @throws Exception Arroja una excepción génerica
         */
        public EModuloCronograma obtener(String condicion) throws SQLException, Exception{
           EModuloCronograma cronograma = new EModuloCronograma();
           
           ResultSet rs = null;
           String query = "Select mc.fechaInicio, mc.fechaFin, mc.horasDia, mc.horaInicio, mc.horaFin, mc.estado, m.codigo, m.nombreModulo, m.idModuloRequerido, m.horasTotales, m.idModulo, p.idPrograma, p.codigo, p.nombrePrograma, p.horasDia, p.horaInicio, p.horaFin, p.estado, p.anio, p.grupo from ModulosCronogramas mc inner join Modulos m on mc.idModulo = m.idModulo inner join Programas p on p.idPrograma = mc.idPrograma";
            if (!condicion.equals("")) {
                query = String.format("%s Where %s", query, condicion);   
            }
            try{
                Statement statement = _cnn.createStatement();
                rs = statement.executeQuery(query);
                
                if (rs!= null && rs.next()) {
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
                programa.setHorasDia(rs.getInt(15));
                programa.setHorasInicio(rs.getString(16));
                programa.setHorasFin(rs.getString(17));
                programa.setEstado(rs.getString(18));
                programa.setAnio(rs.getInt(19));
                programa.setGrupo(rs.getInt(20));
                cronograma.setModulo(modulo);
                cronograma.setPrograma(programa);
                }
            }catch (SQLException sqlE){
                throw sqlE;
            }catch (Exception e){
                throw e;
            }
            finally{
                _cnn=null;
            }
            

            return cronograma;
        }
        
        /**
         * Método que inserta un cronograma en la base de datos
         * @param cronograma Recibe objeto cronograma
         * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la base de datos
         * @return Retorna -1 si no se pudo insertar, en caso contrario retorna el numero de filas afectadas
         * @throws SQLException Arroja un excepción de SQL en caso de que la base de datos tenga un fallo
         * @throws Exception Arroja una excepción génerica
         */
        public int insertar(EModuloCronograma cronograma, int idAsigPr) throws SQLException, Exception{
            int result = -1;
            
            String query = "Insert into ModulosCronogramas (idModulo, idAsignacionProfe, idPrograma, fechaInicio, fechaFin, horaInicio, horaFin, horasDia, estado) Values(?,?,?,?,?,?,?,?,?)";
            ResultSet rs = null;
            try{
                
                PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, cronograma.getModulo().getIdModulo());
                ps.setInt(2, idAsigPr);
                ps.setInt(3, cronograma.getPrograma().getIdPrograma());
                ps.setString(4, cronograma.getFechaInicio());
                ps.setString(5, cronograma.getFechaFin());
                ps.setString(6, cronograma.getHoraInicio());
                ps.setString(7, cronograma.getHoraFin());
                ps.setString(8, cronograma.getHorasDia());
                ps.setString(9, cronograma.getEstado());
                ps.execute();
                rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    result = rs.getInt(1);
                    msg = "Cronograma almacenado con éxito";
                }
            }catch (SQLException sqlE){
                throw sqlE;
            }catch (Exception e){
                throw e;
            }
            finally{
                _cnn=null;
            }
            
            return result;
        }
        /**
         * Método que actualiza un modulo cronograma
         * @param cronograma Recibe objeto cronograma
         * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la base de datos
         * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el numero de filas afectadas
         * @throws SQLException Arroja un excepción de SQL en caso de que la base de datos tenga un fallo
         * @throws Exception Arroja una excepción génerica
         */
        public int actualizar(EModuloCronograma cronograma, int idAsigPr) throws SQLException, Exception{
            int result = -1;
            
            String query = "Update ModulosCronogramas idAsignacionProfe=?, fechaInicio=?, fechaFin=?, horaInicio=?, horaFin=?, horasDia=?, estado=? Where idModulo=? and idPrograma=?";
            try{
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
                
            }catch (SQLException sqlE){
                throw sqlE;
            }catch (Exception e){
                throw e;
            }
            finally{
                _cnn=null;
            }
            
            
            return result;
        }
        /**
         * Método que elimina un modulo cronograma
         * @param cronograma Recibe objeto cronograma
         * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la base de datos
         * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el numero de filas afectadas
         * @throws SQLException Arroja un excepción de SQL en caso de que la base de datos tenga un fallo
         * @throws Exception Arroja una excepción génerica
         */
        public int eliminar (EModuloCronograma cronograma) throws SQLException, Exception{
            int result = -1;
            
            String query = String.format("Delete ModulosCronogramas Where idModulo=%d and idPrograma=%d",cronograma.getModulo().getIdModulo(), cronograma.getPrograma().getIdPrograma());
            try{
                PreparedStatement ps = _cnn.prepareStatement(query);
                ps.execute(query);
                
                if (result > 0) {
                    msg = "Modulo cronograma eliminado con exito";
                }
                
            }catch (SQLException sqlE){
                throw sqlE;
            }catch (Exception e){
                throw e;
            }
            finally{
                _cnn=null;
            }
            
            
            return result;
        }
        
        public String getMessage(){
            return msg;
        }
}

