package interfaces;

import entidad.AlumnoAca;

public interface AlumnoAcaInterfazDAO {
	public int registrar(AlumnoAca alc);
	public int modificar(AlumnoAca alc);
	
	public AlumnoAca obtenerDatos(String idAlum);
}
