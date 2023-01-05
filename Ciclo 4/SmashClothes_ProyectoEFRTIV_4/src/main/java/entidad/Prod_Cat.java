package entidad;

public class Prod_Cat {
	private String codProd;
	private String nombreProduct;
	private String descripcion;
	private int stock;
	private double precio;
	private String idCate;
	private int estado;
	private String nombreCategoria;
	
	@Override
	public String toString() {
		return "Prod_Cat [codProd=" + codProd + ", nombreProduct=" + nombreProduct + ", descripcion=" + descripcion
				+ ", stock=" + stock + ", precio=" + precio + ", idCate=" + idCate + ", estado=" + estado
				+ ", nombreCategoria=" + nombreCategoria + "]";
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getNombreProduct() {
		return nombreProduct;
	}

	public void setNombreProduct(String nombreProduct) {
		this.nombreProduct = nombreProduct;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getIdCate() {
		return idCate;
	}

	public void setIdCate(String idCate) {
		this.idCate = idCate;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
}
