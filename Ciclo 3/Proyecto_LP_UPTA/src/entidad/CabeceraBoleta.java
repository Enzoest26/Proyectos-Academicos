package entidad;

public class CabeceraBoleta {
	private String idBoleta, fechaBoleta, idAlum,idEmple , idTipoBol;
	private double precioBoleta;
	
	
	public CabeceraBoleta() {
		
	}
	public CabeceraBoleta(String idBoleta, String fechaBoleta, String idAlum, String idEmple, double precioBoleta, String idTipoBol) {
		
		this.idBoleta = idBoleta;
		this.fechaBoleta = fechaBoleta;
		this.idAlum = idAlum;
		this.idEmple = idEmple;
		this.precioBoleta = precioBoleta;
		this.idTipoBol = idTipoBol;
	}
	
	public String getIdTipoBol() {
		return idTipoBol;
	}
	public void setIdTipoBol(String idTipoBol) {
		this.idTipoBol = idTipoBol;
	}
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getFechaBoleta() {
		return fechaBoleta;
	}
	public void setFechaBoleta(String fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}
	public String getIdAlum() {
		return idAlum;
	}
	public void setIdAlum(String idAlum) {
		this.idAlum = idAlum;
	}
	public String getIdEmple() {
		return idEmple;
	}
	public void setIdEmple(String idEmple) {
		this.idEmple = idEmple;
	}
	public double getPrecioBoleta() {
		return precioBoleta;
	}
	public void setPrecioBoleta(double precioBoleta) {
		this.precioBoleta = precioBoleta;
	}
	
	
}
