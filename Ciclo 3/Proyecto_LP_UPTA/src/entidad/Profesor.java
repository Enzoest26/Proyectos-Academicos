package entidad;

public class Profesor {
	
	//private String idProfesor, nomnProfesor;

	private String idProf, nomProf,apeProf, dniProf, fechaNac,correo, cel, sexo, domici, idDistrito, idSede;
	private int edad;
	

	public Profesor() {
		
	}


	public Profesor(String idProf, String nomProf, String apeProf, String dniProf, String fechaNac, String correo,
			String cel, String sexo, String domici, String idDistrito, String idSede, int edad) {
		super();
		this.idProf = idProf;
		this.nomProf = nomProf;
		this.apeProf = apeProf;
		this.dniProf = dniProf;
		this.fechaNac = fechaNac;
		this.correo = correo;
		this.cel = cel;
		this.sexo = sexo;
		this.domici = domici;
		this.idDistrito = idDistrito;
		this.idSede = idSede;
		this.edad = edad;
	}


	
	public String getIdProf() {
		return idProf;
	}


	public void setIdProf(String idProf) {
		this.idProf = idProf;
	}


	public String getNomProf() {
		return nomProf;
	}


	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}


	public String getApeProf() {
		return apeProf;
	}


	public void setApeProf(String apeProf) {
		this.apeProf = apeProf;
	}


	public String getDniProf() {
		return dniProf;
	}


	public void setDniProf(String dniProf) {
		this.dniProf = dniProf;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCel() {
		return cel;
	}


	public void setCel(String cel) {
		this.cel = cel;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getDomici() {
		return domici;
	}


	public void setDomici(String domici) {
		this.domici = domici;
	}


	public String getIdDistrito() {
		return idDistrito;
	}


	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}


	public String getIdSede() {
		return idSede;
	}


	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
