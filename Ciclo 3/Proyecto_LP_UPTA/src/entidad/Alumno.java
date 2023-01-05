package entidad;

public class Alumno {
	private String idAlumno, nombre,apellido, dni, correo, fechNa,sexo, teleMo, teleFi, domici, idDistrito,nacio ;
	private int edad, estado;
	
	
	public Alumno() {
		
	}
	public Alumno(String idAlumno, String nombre, String apellido, String dni, String correo, String fechNa, 
			String sexo, String teleMo, String teleFi, String domici, String idDistrito, String nacio, int edad,int estado) {
		
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechNa = fechNa;
	
		this.sexo = sexo;
		this.teleMo = teleMo;
		this.teleFi = teleFi;
		this.domici = domici;
		this.idDistrito = idDistrito;
		this.estado = estado;
		this.edad = edad;
		this.correo = correo;
		this.nacio = nacio;
	}
	
	public String getNacio() {
		return nacio;
	}
	public void setNacio(String nacio) {
		this.nacio = nacio;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechNa() {
		return fechNa;
	}
	public void setFechNa(String fechNa) {
		this.fechNa = fechNa;
	}
	

	public String getTeleMo() {
		return teleMo;
	}
	public void setTeleMo(String teleMo) {
		this.teleMo = teleMo;
	}
	public String getTeleFi() {
		return teleFi;
	}
	public void setTeleFi(String teleFi) {
		this.teleFi = teleFi;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
