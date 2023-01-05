package entidad;


public class Producto {
	private String codProd, fecha, descrip, idCate, nombre, codProvee, foto, fotoExte;
	private int estado, stock;
	private double precio;
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFotoExte() {
		return fotoExte;
	}
	public void setFotoExte(String fotoExte) {
		this.fotoExte = fotoExte;
	}
	public String getCodProd() {
		return codProd;
	}
	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getIdCate() {
		return idCate;
	}
	public void setIdCate(String idCate) {
		this.idCate = idCate;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodProvee() {
		return codProvee;
	}
	public void setCodProvee(String codProvee) {
		this.codProvee = codProvee;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
