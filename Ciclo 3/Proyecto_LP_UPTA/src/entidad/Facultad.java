package entidad;

public class Facultad {
	private String idFacultad, nombre;

	
	public Facultad() {
		
	}

	public Facultad(String idFacultad, String nombre) {
		
		this.idFacultad = idFacultad;
		this.nombre = nombre;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
