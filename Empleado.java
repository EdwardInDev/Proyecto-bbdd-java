package es.ifp.programacion.ejercicio.uf6;

/**
 * Se crea la clase empleado para invocar los objetos desde el programa principal
 * con setters y getters correspondientes
 * Se realiza encapsulamiento poniendo el modificador de visibilidad en private para los atributos y en public para los métodos
 * Se sobreescribe el método toString
 */

public class Empleado {
	
	//Definición de atributos

	private int empleadoId;
	private String nombre;
	private String apellidos;
	private int salario;

	//Definición de constructor
	
	/**
	 * Constructor con todos los parámetros
	 * @param empId identificación de empleado
	 * @param nom nombre del empleado
	 * @param ape apellidos del empleado
	 * @param sal salario del empleado
	 */
	public Empleado (int empId, String nom, String ape, int sal) {
		
		this.empleadoId=empId;
		this.nombre=nom;
		this.apellidos=ape;
		this.salario=sal;	
	}
	
	//Definición de métodos

	/**
	 * método que retorna el id del empleado
	 * @return un entero con el id del empleado
	 */
	public int getEmpleadoId() {
		return this.empleadoId;
	}

	//empleadoId no tiene set al no poder modificarse sus datos como dicta el enunciado
	
	/**
	 * método que retorna el nombre del empleado
	 * @return un String con el nombre del empleado
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * modifica el nombre del empleado
	 * @param nombre valor del tipo String con el nuevo nombre de empleado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * método que retorna los apellidos del empleado
	 * @return un String con los apellidos del empleado
	 */
	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * modifica los apellidos del empleado
	 * @param apellidos valor del tipo String con los nuevos apellidos del empleado
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * método que retorna el salario del empleado
	 * @return un entero con el salario del empleado
	 */
	public int getSalario() {
		return this.salario;
	}

	/**
	 * modifica el salario del empleado
	 * @param salario valor de tipo entero con el nuevo salario del empleado
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	//Llamada al método toString
	
	/**
	 * Se sobreescribe el método toString para que retorne todos los datos de Empleado en un String
	 * @return un String con todos los atributos de la clase Empleado
	 */
	
	@Override
	/**
	 * 
	 */
	public String toString() {
		return  "==========================================\n"+
				"EMPLEADO: "+
				"idEmpleado:"+this.getEmpleadoId()+"\n"+
				"Nombre:"+this.getNombre()+"\n"+
				"Apellidos:"+this.getApellidos()+"\n"+
				"Salario:"+this.getSalario()+"\n"+
				"==========================================";
	}
}