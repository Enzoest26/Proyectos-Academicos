package interfaces;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.AlumnoEstado;
import entidad.ReportarAlumno;

public interface AlumnoIntefazDAO {

	public int registrar(Alumno al);
	
	public int modificar(Alumno al);
	
	public int eliminar(String idAlumno);
	
	public ArrayList<AlumnoEstado> listarEstados();
	
	public ArrayList<Alumno> listarAlumnosGeneral();
	
	public ArrayList<Alumno> listarAlumnosActivos();
	
	public ArrayList<ReportarAlumno> buscarAlumno(String cond);
	
	public Alumno obtenerDatos(String idAlu);
	
	public String numAlumno();
}
