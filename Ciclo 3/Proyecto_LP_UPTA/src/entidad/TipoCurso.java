package entidad;

public class TipoCurso {
	private String idTipoCurso, nombre;
	public TipoCurso() {
	}
	public TipoCurso(String idTipoCurso, String nombre) {
		
		this.idTipoCurso = idTipoCurso;
		this.nombre = nombre;
	}

	public String getIdTipoCurso() {
		return idTipoCurso;
	}

	public void setIdTipoCurso(String idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
