package entidad;

public class SolicitudDetalle {
	private String idInforme, idAlumno, idSede, motivo;

	
	public SolicitudDetalle() {
		
	}

	public SolicitudDetalle(String idInforme, String idAlumno, String idSede, String motivo) {

		this.idInforme = idInforme;
		this.idAlumno = idAlumno;
		this.idSede = idSede;
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(String idInforme) {
		this.idInforme = idInforme;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getIdSede() {
		return idSede;
	}

	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	
	
}
