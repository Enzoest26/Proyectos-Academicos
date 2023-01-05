package entidad;

public class Horario {
	private String idHorario, tiempo;

	public Horario() {
	}

	public Horario(String idHorario, String tiempo) {
		
		this.idHorario = idHorario;
		this.tiempo = tiempo;
	}

	public String getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
}
