package interfaces;

import java.util.ArrayList;

import entidad.TipoCurso;

public interface CursoTipoInterfazDAO {
	public ArrayList<TipoCurso> listaCursosxTipo();
	
	public ArrayList<TipoCurso>listarIdCursoXNombre(String nombre);
}
