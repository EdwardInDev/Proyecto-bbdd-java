package es.ifp.programacion.ejercicio.uf6;

/**
 * Clase con las utilidades necesarias para realizar las operaciones en la BBDD
 * Se crea una variable de clase con la conexión y un String con URL, usuario y contraseña para utilizarla en todos los métodos
 * Se crea una variable de clase PreparedStatement para utilizarla en todos los métodos
 * Se utiliza PreparedStatement porque ya tenemos los datos de las consultas
 * Se crea una variable de clase ResultSet para utilizarla en todos los métodos
 */

//Se importan las clases necesarias para la ejecución del programa

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DButilidades {
	
	private Connection conexion;
	private String userDB = "postgres";
	private String passDB = "postgreifp";
	private String URL = "jdbc:postgresql://localhost:5432/empresaDB";
	private PreparedStatement ps;
	private ResultSet rs;
	
/**
* Se conecta a la BBDD empresadb creada en postgreSQL.
* @return true si la conexión fue satisfactoria, false sino.
*/
public boolean connectToDB() {
	try {
		this.conexion=DriverManager.getConnection(URL, userDB, passDB);
		System.out.println("Conexión establecida");
		return true;
	}
	catch(SQLException sql) {
		sql.getMessage();
		
		return false;
	}
}

/**
 * Borra el registro de la tabla asociado al objeto emp pasado como parámetro
 * @param emp objeto Empleado que se elimina de la BBDD
 * @return true si el borrado fue correcto, false sino.
 */
public boolean deleteEmpleado(Empleado emp) {
	
	int numFilas = 0;
	boolean borrado = false;
	
	try {
		this.ps=this.conexion.prepareStatement(SQLClassEjercicio.SQL_DELETE);
		ps.setInt(1, emp.getEmpleadoId());
		numFilas = ps.executeUpdate();
		if (numFilas >0) {
			borrado = true;
			System.out.println("Eliminado el empleado con id: "+emp.getEmpleadoId()+" "+emp.getNombre()+", "+emp.getApellidos());
		}
	}
	catch (SQLException sql) {
		sql.getMessage();
	}

	return borrado;
}

/**
 * A partir de un objeto empleado, inserta todos sus datos en la tabla empleados.
 * @param emp Objeto de tipo empleado
 * @return 0 si no se ha insertado valor alguno. En caso contrario, el número de filas insertadas.
 */
public int insertarEmpleado(Empleado emp) {
	
	int numFilas = 0;
	
	try {
		this.ps = this.conexion.prepareStatement(SQLClassEjercicio.SQL_INSERT);
		ps.setInt(1, emp.getEmpleadoId());
		ps.setString(2, emp.getNombre());
		ps.setString(3, emp.getApellidos());
		ps.setInt(4, emp.getSalario());
		numFilas = ps.executeUpdate();
		System.out.println("Se ha insertado el registro con id "+emp.getEmpleadoId()+" en la BBDD: "+emp.getNombre()+", "+emp.getApellidos());

	} catch (SQLException sql) {
		sql.getMessage();
	}
	
	return numFilas;
}

/**
 * Cierra todos los recursos relativos a la BBDD
 * @return true si la operación fue correcta, false sino.
 */
public boolean closeResources() {
	
	//Se introducen varios bucles if en el que se tienen que cumplir el cierre de todos los recursos para que la operación devuelva true
	
	try {
		if (rs != null && !rs.isClosed()) {
			rs.close();
	}
		if (ps != null && !ps.isClosed()) {
			ps.close();
	}
		if (conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
		System.out.println("Conexión cerrada");
		return (rs == null || rs.isClosed()) && (ps == null || ps.isClosed()) && (conexion == null || conexion.isClosed());
	}
	catch (SQLException sql) {
		sql.getMessage();
		
		return false;
	}
}

/**
 * Obtiene todos los registros de la tabla empleados
 * @return un ArrayList de objetos de tipo Empleado mapeados a los registros de la tabla.
 */
public ArrayList<Empleado> getAllEmpleados() {
	
	ArrayList<Empleado> lista = new ArrayList <Empleado>();
	Empleado empleado;
	
	try {
		this.ps = this.conexion.prepareStatement(SQLClassEjercicio.SQL_GETALL);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			empleado = new Empleado (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			lista.add(empleado);
			//método toString que invoca a todos los empleados que estén añadidos
			System.out.println(empleado.toString());
		}
	}
	catch (SQLException sqle) {
		sqle.getMessage();
	}
	
	//Bucle if que indica que si no hay datos de empleados imprima un mensaje indicándolo
	
	if (lista.isEmpty()) {
		System.out.println("No hay registros en la tabla");
	}
	return lista;
  }
}