package entidad;

public class ConexionEmple {
	private String idEmple;
	private int idEstado;
	
	public ConexionEmple() {
		
	}
	public ConexionEmple(String idEmple, int idEstado) {
		
		this.idEmple = idEmple;
		this.idEstado = idEstado;
	}
	public String getIdEmple() {
		return idEmple;
	}
	public void setIdEmple(String idEmple) {
		this.idEmple = idEmple;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
}
