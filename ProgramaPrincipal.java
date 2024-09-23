package es.ifp.programacion.ejercicio.uf6;

/**
 * Clase principal desde la que se llama a los métodos de la clase DButilidades
 * Se crea una instancia de la clase DButilidades para ejecutar las operaciones de BBDD
 * Se crean tres objetos de tipo Empleado con sus parámetros int, String, String, int
 * El programa imprime un mensaje de conexión y otro de deconexión al finalizar la ejecución en consola
 */

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		DButilidades emp = new DButilidades();
		Empleado empleado1 = new Empleado (1, "Andrea", "Mas Torres", 1000);
		Empleado empleado2 = new Empleado (2, "Andrea2", "Mas2 Torres2", 2000);
		Empleado empleado3 = new Empleado (3, "Andrea3", "Mas3 Torres3", 3000);
		
		emp.connectToDB();
		System.out.println("===========================================================");
		System.out.println("1.- Mostramos todos los registros");
		System.out.println("===========================================================");
		emp.getAllEmpleados();
		System.out.println("===========================================================");
		System.out.println("2.- Insertamos tres empleados");
		System.out.println("===========================================================");
		emp.insertarEmpleado(empleado1);
		emp.insertarEmpleado(empleado2);
		emp.insertarEmpleado(empleado3);
		System.out.println("===========================================================");
		System.out.println("3.- Mostramos todos los registros");
		System.out.println("===========================================================");
		emp.getAllEmpleados();
		System.out.println("===========================================================");
		System.out.println("4.- Borramos un registro");
		System.out.println("===========================================================");
		emp.deleteEmpleado(empleado3);
		System.out.println("===========================================================");
		System.out.println("5.- Mostramos todos los registros");
		System.out.println("===========================================================");
		emp.getAllEmpleados();
		emp.closeResources();
	}
}