package listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entidad.DetalleBoletaCli;

/**
 * Application Lifecycle Listener implementation class CompraListener
 *
 */
@WebListener
public class CompraListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CompraListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("Id de sesion : " + arg0.getSession().getId());
    	// variables para el proceso de carro de compras
    	ArrayList<DetalleBoletaCli> carro = new ArrayList<DetalleBoletaCli>();
    	double subTotalVenta = 0.0;
    	int cantArticulos = 0;
    	// enviar las variables como atributos de sesion
        arg0.getSession().setAttribute("carro", carro);
        arg0.getSession().setAttribute("subTotalVenta", subTotalVenta);
        arg0.getSession().setAttribute("cantArticulos", cantArticulos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Id de sesion a eliminar : " + arg0.getSession().getId());
    }
	
}
