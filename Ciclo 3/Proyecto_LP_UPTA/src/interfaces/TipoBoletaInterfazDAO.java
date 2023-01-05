package interfaces;

import java.util.ArrayList;

import entidad.TipoBoleta;

public interface TipoBoletaInterfazDAO {
	public ArrayList<TipoBoleta> listarBoleta();
	
	public TipoBoleta obtenerID(String nombre);
}
