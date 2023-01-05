package interfaces;

import java.util.ArrayList;

import entidad.Profesor;

public interface ProfesorInterfazDAO {

	public ArrayList<Profesor> listarProfesor();
	
	public Profesor nombreProfesores(String id);
	
	public int registrar(Profesor prof);
	
	public int modificar(Profesor prof);
	
	public int eliminar(String idProf);
	
	public Profesor obterneID(String nombre);
	
}
