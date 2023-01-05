package entidad;

public class Curso {
	private String idCurso, nombre, idprofesor, idHorario, fechaIni,fehcaFin, dia,idTipo, carrera, ciclo;
	private int creditos, vacantes;
	
	public Curso() {
	}

	public Curso(String idCurso, String nombre, String idprofesor, String idHorario, String fechaIni, String fehcaFin, String dia,
			int creditos, int vacantes, String carrera, String ciclo, String idTipo) {
		
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.idprofesor = idprofesor;
		this.idHorario = idHorario;
		this.fechaIni = fechaIni;
		this.fehcaFin = fehcaFin;
		this.creditos = creditos;
		this.dia = dia;
		this.idTipo = idTipo;
		this.carrera = carrera;
		this.ciclo = ciclo;
		this.vacantes = vacantes;
	}
	
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacante) {
		this.vacantes = vacante;
	}

	public String getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFehcaFin() {
		return fehcaFin;
	}
	public void setFehcaFin(String fehcaFin) {
		this.fehcaFin = fehcaFin;
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
	public String getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(String idprofesor) {
		this.idprofesor = idprofesor;
	}

	
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

}
