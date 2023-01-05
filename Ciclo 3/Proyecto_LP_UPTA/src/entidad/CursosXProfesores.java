package entidad;

public class CursosXProfesores {
	private String idCurso, nombre, nombreProfesor, dia, horario;

	
	public CursosXProfesores() {
		
	}

	public CursosXProfesores(String idCurso, String nombre, String nombreProfesor, String dia, String horario) {
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.nombreProfesor = nombreProfesor;
		this.dia = dia;
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	
}
