package entidad;

public class DetalleBoleta {
	private String idprod;
	private double preciovta;
	private int cantidad;
	private String nomprod;
	private double importe;
	
	public DetalleBoleta() {
	}
	@Override
	public String toString() {
		return "DetalleBoleta [idprod=" + idprod + ", preciovta=" + preciovta + ", cantidad=" + cantidad + ", nomprod="
				+ nomprod + ", importe=" + importe + "]";
	}
	
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public double getPreciovta() {
		return preciovta;
	}
	public void setPreciovta(double preciovta) {
		this.preciovta = preciovta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNomprod() {
		return nomprod;
	}
	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
}
