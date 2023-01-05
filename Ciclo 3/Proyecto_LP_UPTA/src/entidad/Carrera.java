package entidad;

public class Carrera {
	private String idCarrera, nombre, idFacultad;

	
	
	public Carrera() {
		
	}

	public Carrera(String idCarrera, String nombre, String idFacultad) {
		
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.idFacultad = idFacultad;
	}

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}
	
	
}
