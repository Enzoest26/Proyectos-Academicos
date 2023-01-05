package dao;

import interfaces.ClienteInterface;
import interfaces.CuentaInterfaces;
import interfaces.EstadoInterface;
import interfaces.ProductoInterface;
import interfaces.ProveedorInterface;
import interfaces.TipoDocumentoInterface;
import interfaces.TipoUsuarioInterface;
import interfaces.UsuarioInterface;

import interfaces.VentaInterface;
import interfaces.VentasClieInterfaces;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	
	//Creamos metodos para "encapsular" la implementación
	//abstract es para extraer o padre
	public abstract ProductoInterface getProductoDAO();
	public abstract UsuarioInterface getUsuarioDAO();
	public abstract ClienteInterface getClienteDAO();
	public abstract ProveedorInterface getProveedorDAO();
	public abstract EstadoInterface getEstadoDAO();
	public abstract TipoDocumentoInterface getTipoDocumentoDAO();
	public abstract TipoUsuarioInterface getTipoUsuarioDAO();
	public abstract VentaInterface getVentaDAO();
	public abstract VentasClieInterfaces getVentasCliDAO();
	public abstract CuentaInterfaces getCuentaDAO();
	//Constructor static de la clase
	public static DAOFactory getDAOFactory(int qdb) {
		switch (qdb) {
		case MYSQL:
			return new MYSQLDAOFactory();
			
		default:
			return null;
		}
	}
}
