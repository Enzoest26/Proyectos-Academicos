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
import mantenimientos.GestionClienteDAOMYSQL;
import mantenimientos.GestionCuentaMySQL;
import mantenimientos.GestionEstadoDAOMYSQL;
import mantenimientos.GestionProductoDAOMYSQL;
import mantenimientos.GestionProveedorDAOMYSQL;
import mantenimientos.GestionTipoDocumentoDAOMYSQL;
import mantenimientos.GestionTipoUsuarioDAOMYSQL;
import mantenimientos.GestionUsuarioDAOMYSQL;
import mantenimientos.GestionVentaDAOMYSQL;
import mantenimientos.GestionVentasCliDAOMySQL;


public class MYSQLDAOFactory extends DAOFactory{

	@Override
	public ProductoInterface getProductoDAO() {
		// TODO Auto-generated method stub
		return new GestionProductoDAOMYSQL();
	}

	@Override
	public UsuarioInterface getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionUsuarioDAOMYSQL();
	}

	@Override
	public ClienteInterface getClienteDAO() {
		// TODO Auto-generated method stub
		return new GestionClienteDAOMYSQL();
	}

	@Override
	public ProveedorInterface getProveedorDAO() {
		// TODO Auto-generated method stub
		return new GestionProveedorDAOMYSQL();
	}

	@Override
	public EstadoInterface getEstadoDAO() {
		// TODO Auto-generated method stub
		return new GestionEstadoDAOMYSQL();
	}

	@Override
	public TipoDocumentoInterface getTipoDocumentoDAO() {
		// TODO Auto-generated method stub
		return new GestionTipoDocumentoDAOMYSQL();
	}

	@Override
	public TipoUsuarioInterface getTipoUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionTipoUsuarioDAOMYSQL();
	}

	@Override
	public VentaInterface getVentaDAO() {
		// TODO Auto-generated method stub
		return new GestionVentaDAOMYSQL();
	}

	@Override
	public CuentaInterfaces getCuentaDAO() {
		// TODO Auto-generated method stub
		return new GestionCuentaMySQL();
	}

	@Override
	public VentasClieInterfaces getVentasCliDAO() {
		// TODO Auto-generated method stub
		return new GestionVentasCliDAOMySQL();
	}

	
	
}
