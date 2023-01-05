package interfaces;

import java.util.ArrayList;

import entidad.Curso;
import entidad.CursosXProfesores;

public interface CursoInterfazDAO {

	public int registrar(Curso cur);
	
	public int modificar(Curso cur);
	
	public int eliminar(String idCurso);
	
	public ArrayList<Curso> listaCursos();
	
	public ArrayList<CursosXProfesores> buscarCursos(String condi);
	
	public int obtenerCreditos(String idCurso);
	
	public int obtenerVacantes(String idCurso);

	ArrayList<Curso> listarIdCursoXNombre(String tipo);
	
	public Curso obtenerCursoXID(String id);
 }
