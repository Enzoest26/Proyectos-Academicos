package interfaces;

import java.util.ArrayList;

import entidad.TipoSolicitud;

public interface TipoSolicitudInterfazDAO {
	public ArrayList<TipoSolicitud> listarSolicitud();
	
	public TipoSolicitud obtenerTipoSol(String nombre);
	
	public TipoSolicitud obtenerNombreSol(String id);
}
