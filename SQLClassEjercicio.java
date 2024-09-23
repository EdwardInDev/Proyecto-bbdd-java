package es.ifp.programacion.ejercicio.uf6;


/**
 * Clase con variables estáticas que definen las consultas SQL a realizar.
 * La forma de invocarlas (vista en la UF4) es como se invoca a una variable de clase.
 * 
 * Por ejemplo:
 * SQLClassEjercicio.SQL_INSERT
 * 
 * @author juan
 *
 */


public class SQLClassEjercicio {
	public static String SQL_INSERT = "insert into empleados values(?,?,?,?)";
	public static String SQL_GETALL = "select * from empleados";
	public static String SQL_DELETE = "delete from empleados where empleadoid=?";
}
