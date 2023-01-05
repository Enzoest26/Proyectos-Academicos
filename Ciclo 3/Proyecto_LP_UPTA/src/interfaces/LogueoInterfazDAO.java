package interfaces;

import java.util.ArrayList;

import entidad.Empleado;
import entidad.Logueo;

public interface LogueoInterfazDAO {
	public Logueo verificarLogueo(String usu, String pass);
	
	public int cambiarEstado(String idEmple, int estado);
	
}
