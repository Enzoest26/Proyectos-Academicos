package interfaces;

import entidad.Cuenta;

public interface CuentaInterfaces {
	// metodos publicos
	
	// registrar los datos de un nuevo usuario
	public int registrar(Cuenta u);
	
	// validar los datos para el ingreso
	public Cuenta validar(String usuario, String clave);
	
	public int obtenerCod();
}
