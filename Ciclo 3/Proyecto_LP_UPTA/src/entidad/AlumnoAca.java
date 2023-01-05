package entidad;

public class AlumnoAca {
	private String idAlumno, idSede,idCarrera, ciclo;

	
	public AlumnoAca() {
	
	}

	public AlumnoAca(String idAlumno, String idSede, String idCarrera, String ciclo) {
		this.idAlumno = idAlumno;
		this.idSede = idSede;
		this.idCarrera = idCarrera;
		this.ciclo = ciclo;
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

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
}
