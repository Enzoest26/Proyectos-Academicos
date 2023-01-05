package interfaces;

import java.util.ArrayList;

import entidad.VentaCabezera;
import entidad.VentaDetalle;

public interface VentaInterface {
	public int realizarVenta(VentaCabezera cabezera, ArrayList<VentaDetalle> detalle);
	public String obtenerCod();
}
