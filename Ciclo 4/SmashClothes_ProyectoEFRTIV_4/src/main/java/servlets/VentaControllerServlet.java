package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Cliente;
import entidad.Producto;
import entidad.VentaCabezera;
import entidad.VentaDetalle;

/**
 * Servlet implementation class VentaControllerServlet
 */
@WebServlet(name = "ventaController", description = "Venta de productos", urlPatterns = { "/ventaController" })
public class VentaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		String[] codigos = request.getParameterValues("rowCodigo");
		String[] cantidad = request.getParameterValues("rowCantidad");
		String numBoleta = fabrica.getVentaDAO().obtenerCod();
		String nombre	 = request.getParameter("txtNombreCli");
		String tipoBoleta=request.getParameter("cmbTipoBoleta");
		double precioTotal = 0.0;
		ArrayList<VentaDetalle> deta = new ArrayList<>();
		
		VentaCabezera cabe = new VentaCabezera();
		Cliente cl = fabrica.getClienteDAO().obtenerXNombre(nombre);
		LocalDate today = LocalDate.now();
		cabe.setNumBol(numBoleta);
		cabe.setPrecioTo(precioTotal);
		cabe.setCodCli(cl.getCodigo());
		cabe.setFecha(today.toString());
		cabe.setPagadoBol("Pagado");
		cabe.setTipoBol(tipoBoleta);
		
		for (int i = 0; i < codigos.length; i++) {
			Producto p = fabrica.getProductoDAO().obtenerPro(codigos[i]);
			precioTotal += p.getPrecio();
			VentaDetalle de = new VentaDetalle();
			de.setCantidad(cantidad[i]);
			de.setPrecioUni(p.getPrecio());
			de.setNumBol(numBoleta);
			de.setCodProd(p.getCodProd());
			deta.add(de);
		}
		cabe.setPrecioTo(precioTotal);
		int ok = fabrica.getVentaDAO().realizarVenta(cabe, deta);
		if(ok == 0) {
			String mensaje = "<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'Error en la venta'"
				
					+ "        })</script>";
			request.setAttribute("mensaje",mensaje);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
		}else {
			String mensaje = "<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Exito',"
					+ "            text: 'Venta realizada'"
				
					+ "        })</script>";
			request.setAttribute("mensaje",mensaje);
			ArrayList<Producto> lstProdDispo = fabrica.getProductoDAO().listarDisponibles();
			request.getSession().setAttribute("lstProdDispo", lstProdDispo);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
		}
		
	}

}
