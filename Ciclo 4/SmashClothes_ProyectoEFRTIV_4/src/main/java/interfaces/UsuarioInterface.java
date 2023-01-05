package interfaces;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Usuario;

public interface UsuarioInterface {
	public Usuario obtenerUsu(String cod);
	public int registrar(Usuario usu, Cuenta cu);
	public int editar(Usuario usu);
	public int eliminar(String cod);
	public ArrayList<Usuario> listarUsuarios();
	public String obtenerCod();
}
