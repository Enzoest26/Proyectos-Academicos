package interfaces;

import java.util.ArrayList;

import entidad.Categoria;
import entidad.Producto;
import entidad.Prod_Cat;

public interface ProductoInterface {
	public Producto obtenerPro(String cod);
	public int registrar(Producto p);
	public int editar(Producto p);
	public int eliminar(String cod);
	public ArrayList<Producto> listarProductos();
	public String obtenerCod();
	public ArrayList<Categoria> listarCategorias();
	public ArrayList<Producto> listarDisponibles();
	public ArrayList<Prod_Cat> listadoProductoCategoria();
	public ArrayList<Producto> listarReportes(String fecha, String cate);
}
