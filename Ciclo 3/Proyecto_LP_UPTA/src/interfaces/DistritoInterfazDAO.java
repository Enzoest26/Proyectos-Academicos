package interfaces;

import java.util.ArrayList;

import entidad.Distrito;

public interface DistritoInterfazDAO {
	public ArrayList<Distrito> listarDistritos();
	public ArrayList<Distrito> buscarID(String nombre);
	public Distrito buscarNombre(String id);
}
