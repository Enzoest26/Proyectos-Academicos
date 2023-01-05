package entidad;

public class TipoBoleta {
	private String idTipoBol, descripBol;
	private double precio;

	public TipoBoleta(String idTipoBol, String descripBol,double precio) {
	
		this.idTipoBol = idTipoBol;
		this.descripBol = descripBol;
		this.precio = precio;
	}
	

	public TipoBoleta() {
	
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getIdTipoBol() {
		return idTipoBol;
	}

	public void setIdTipoBol(String idTipoBol) {
		this.idTipoBol = idTipoBol;
	}

	public String getDescripBol() {
		return descripBol;
	}

	public void setDescripBol(String descripBol) {
		this.descripBol = descripBol;
	}
	
}
