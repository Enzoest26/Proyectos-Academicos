package interfaces;

import java.util.ArrayList;

import entidad.Carrera;

public interface CarreraInterfazDAO {
	public ArrayList<Carrera> listarCarreras();
	public Carrera buscarCarrera(String nombreCarrera);
	public Carrera buscarNombre(String id);
}
