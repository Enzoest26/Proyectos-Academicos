package entidad;

public class Solicitud {
	private String idSolicitud, tipoSolicitud, idEmple, fecha;

	public Solicitud() {
		
	}

	public Solicitud(String idSolicitud, String tipoSolicitud, String idEmple,String fecha) {
		this.idSolicitud = idSolicitud;
		this.tipoSolicitud = tipoSolicitud;
		this.idEmple = idEmple;
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getIdEmple() {
		return idEmple;
	}

	public void setIdEmple(String idEmple) {
		this.idEmple = idEmple;
	}
	
}
