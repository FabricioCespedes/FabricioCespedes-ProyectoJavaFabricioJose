/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

/**
 *
 * @author josea
 */
public class Config {
    /**
     * Método que tiene la cadena de conexión con la base de datos
     * @return La cadena de conexión
     */
    public static String getConnectionString(){
        return "jdbc:sqlserver://localhost:1433;databaseName=DBCronograma;user=javaUser;password=javaPass";
    }
}
