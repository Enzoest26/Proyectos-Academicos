package entidad;

public class Cuenta {
	// atributos privados
	private int codigo;
	private String nombre, apellido, usuario, clave;
	private String fecha_nac;
	private int tipo, estado;
	
	// constructores
	public Cuenta() {
	}
	public Cuenta(int codigo, String nombre, String apellido, String usuario, String clave, String fecha_nac, int tipo,
			int estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.fecha_nac = fecha_nac;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	// método para realizar el seguimiento de los objetos creados
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario
				+ ", clave=" + clave + ", fecha_nac=" + fecha_nac + ", tipo=" + tipo + ", estado=" + estado + "]";
	}
	
	// metodos set/get
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
