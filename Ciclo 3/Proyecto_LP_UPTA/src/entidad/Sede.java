package entidad;

public class Sede {
	private String idSede, nombre, idDistrito;
	public Sede() {
		
	}

	public Sede(String idSede, String nombre, String idDistrito) {
		
		this.idSede = idSede;
		this.nombre = nombre;
		this.idDistrito = idDistrito;
	}

	public String getIdSede() {
		return idSede;
	}

	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}
	
}
