package entidad;

public class TipoSolicitud {
	private String idTipoSol, nombreTipoSol;

	public TipoSolicitud() {

		// TODO Auto-generated constructor stub
	}

	public TipoSolicitud(String idTipoSol, String nombreTipoSol) {
		
		this.idTipoSol = idTipoSol;
		this.nombreTipoSol = nombreTipoSol;
	}

	public String getIdTipoSol() {
		return idTipoSol;
	}

	public void setIdTipoSol(String idTipoSol) {
		this.idTipoSol = idTipoSol;
	}

	public String getNombreTipoSol() {
		return nombreTipoSol;
	}

	public void setNombreTipoSol(String nombreTipoSol) {
		this.nombreTipoSol = nombreTipoSol;
	}
	
}
