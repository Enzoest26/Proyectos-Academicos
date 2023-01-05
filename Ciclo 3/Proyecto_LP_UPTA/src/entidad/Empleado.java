package entidad;

public class Empleado {
	private String idEmple, nombre, apellido, dni, idTipo;
	public Empleado() {
		
	}
	public Empleado(String idEmple, String nombre, String apellido, String dni, String idTipo) {
		
		this.idEmple = idEmple;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.idTipo = idTipo;
	}

	public String getIdEmple() {
		return idEmple;
	}

	public void setIdEmple(String idEmple) {
		this.idEmple = idEmple;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	
	
}
