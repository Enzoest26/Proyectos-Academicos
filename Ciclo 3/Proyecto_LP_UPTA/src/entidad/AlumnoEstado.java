package entidad;

public class AlumnoEstado {
	private int idEstado;
	private String descrip;
	public AlumnoEstado() {

	}
	public AlumnoEstado(int idEstado, String descrip) {

		this.idEstado = idEstado;
		this.descrip = descrip;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
}
