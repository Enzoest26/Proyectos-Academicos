package entidad;

public class DetalleBoleta {
	private String idCurso;
	private double precioCurso;
	
	public DetalleBoleta() {
		
	}
	public DetalleBoleta(String idCurso, double precioCurso) {
		
		this.idCurso = idCurso;
		this.precioCurso = precioCurso;
	}
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	public double getPrecioCurso() {
		return precioCurso;
	}
	public void setPrecioCurso(double precioCurso) {
		this.precioCurso = precioCurso;
	}
	
	
	
}
