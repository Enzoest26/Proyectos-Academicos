package interfaces;

import java.util.ArrayList;

import entidad.Proveedor;

public interface ProveedorInterface {
	public Proveedor obtenerProv(String cod);
	public int registrar(Proveedor prov);
	public int editar(Proveedor prov);
	public int eliminar(String cod);
	public ArrayList<Proveedor> listarProveedor();
	public String obtenerCod();
}
