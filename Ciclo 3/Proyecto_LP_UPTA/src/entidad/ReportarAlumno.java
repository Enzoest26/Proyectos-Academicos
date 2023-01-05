package entidad;

public class ReportarAlumno {
	private String idAlumno, nombrecompletos, dni;
	

	public ReportarAlumno() {
	}

	public ReportarAlumno(String idAlumno, String nombrecompletos, String dni) {
		this.idAlumno = idAlumno;
		this.nombrecompletos = nombrecompletos;
		this.dni = dni;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombrecompletos() {
		return nombrecompletos;
	}

	public void setNombrecompletos(String nombrecompletos) {
		this.nombrecompletos = nombrecompletos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
