package interfaces;

import java.util.ArrayList;

import entidad.CabeceraBoletaCli;
import entidad.DetalleBoletaCli;

public interface VentasClieInterfaces {
	public String generaNumBoleta(); // autogenerado para cadena
	
	public int realizarVenta(CabeceraBoletaCli cab, ArrayList<DetalleBoletaCli> det);
}
