package entidad;

public class Logueo {
	private String idCuenta, usuario, pass, idEmple;

	
	public Logueo() {
		
	}

	public Logueo(String idCuenta, String usuario, String pass, String idEmple) {
		
		this.idCuenta = idCuenta;
		this.usuario = usuario;
		this.pass = pass;
		this.idEmple = idEmple;
	}

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getIdEmple() {
		return idEmple;
	}

	public void setIdEmple(String idEmple) {
		this.idEmple = idEmple;
	}
	
	
}
