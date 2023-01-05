package entidad;

import java.io.InputStream;

public class Cliente {
	private String codigo, nombre, apellido, numDoc, sexo,fechaNa , correo,fotoRu, fotoExtension;
	private int edad, tipoDoc, estado;
	
	
	public String getFotoRu() {
		return fotoRu;
	}
	public void setFotoRu(String fotoRu) {
		this.fotoRu = fotoRu;
	}
	public int getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	public String getFotoExtension() {
		return fotoExtension;
	}
	public void setFotoExtension(String fotoExtension) {
		this.fotoExtension = fotoExtension;
	}
	
	public String getFechaNa() {
		return fechaNa;
	}
	public void setFechaNa(String fechaNa) {
		this.fechaNa = fechaNa;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
	
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
