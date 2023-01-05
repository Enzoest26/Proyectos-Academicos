package interfaces;

import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteInterface {
	public Cliente obtenerCli(String cod);
	public int registrar(Cliente cl);
	public int editar(Cliente cl);
	public int eliminar(String cod);
	public ArrayList<Cliente> listarClientes();
	public String obtenerCod();
	public Cliente obtenerXNombre(String nombre);
	public ArrayList<Cliente> listarXCondi(String fecha, String nombre);
}
