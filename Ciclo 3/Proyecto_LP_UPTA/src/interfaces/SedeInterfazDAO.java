package interfaces;

import java.util.ArrayList;

import entidad.Sede;

public interface SedeInterfazDAO {
	public ArrayList<Sede> listarSede();
	public Sede buscarSede(String nombre);
	public Sede buscarNombre(String id);
}
