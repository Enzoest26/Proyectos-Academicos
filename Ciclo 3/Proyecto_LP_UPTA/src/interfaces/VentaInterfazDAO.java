package interfaces;

import java.util.ArrayList;

import entidad.CabeceraBoleta;
import entidad.DetalleBoleta;

public interface VentaInterfazDAO {
	public String numBoleta();
	
	public int realizarVenta(CabeceraBoleta cBol, ArrayList<DetalleBoleta> dbol);
	
	public int realzarBoletaAuto(CabeceraBoleta cBol);
}
