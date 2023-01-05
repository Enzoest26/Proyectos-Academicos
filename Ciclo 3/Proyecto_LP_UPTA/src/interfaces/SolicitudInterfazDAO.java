package interfaces;

import java.util.ArrayList;

import entidad.Solicitud;

import entidad.SolicitudDetalle;

public interface SolicitudInterfazDAO {
	
	public String numSolicitud();
	public int registrarSolicitud(Solicitud sol, SolicitudDetalle scs);

	//public int registrarSolicitudCambioSede(SolicitudCambioSede scs);
	
	public ArrayList<Solicitud> listarSolicitudes();
	public ArrayList<Solicitud> listar10Solicitudes();
	
	public Solicitud obtenerCabeSol(String idSol);
	
}
