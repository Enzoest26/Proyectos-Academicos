package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.CabeceraBoletaCli;
import entidad.DetalleBoletaCli;
import entidad.Producto;
import entidad.Cuenta;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet(name = "venta", urlPatterns = { "/venta" })
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingresó al Servlet de Venta");
		// Servlet que controla varios procesos
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "agregar": agregarCompra(request, response); break; 
		case "eliminar": eliminarCompra(request,response); break;
		case "finalizar": finalizarCompra(request, response); break;
		default:
			
		}
	}

	private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al proceso de Finalizar compra");
		CabeceraBoletaCli c = new CabeceraBoletaCli();
		Cuenta u = (Cuenta) request.getSession().getAttribute("u"); 
		if (u == null) {
			request.setAttribute("mensaje", 
					"<script>swal('Mensaje','Para finalizar la compra, debe ingresar a su cuenta','error');</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		c.setCod_cliente(u.getCodigo());
		
		// traer el obj carro -> detalle de los productos a comprar
		ArrayList<DetalleBoletaCli> carro = (ArrayList<DetalleBoletaCli>) request.getSession().getAttribute("carro");
		
		// mediante patron DAO grabar
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int ok = fabrica.getVentasCliDAO().realizarVenta(c, carro);
		if(ok == 0) {
			// no se completo el proceso de venta
			request.setAttribute("mensaje", 
					"<script>swal('Mensaje','Error al procesar la venta, verifique o actualice los productos!','error');</script>");
			request.getRequestDispatcher("canasta.jsp").forward(request, response);
		}else {
			request.setAttribute("mensaje", 
					"<script>swal('Mensaje','Venta realizada exitosamente !','success');</script>");
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
			// limpiar las variables globales 
			request.getSession().setAttribute("carro", new ArrayList<DetalleBoletaCli>());
			request.getSession().setAttribute("subTotalVenta", 0.0);
			request.getSession().setAttribute("cantArticulos", 0);
		}
		
	}

	private void eliminarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entró al proceso de Eliminar compra");
		// leer el codigo del producto a eliminar
		String codigo = request.getParameter("codigo");
		// buscar el producto y eliminarlo del carro, actualizar los montos
		ArrayList<DetalleBoletaCli> carro = (ArrayList<DetalleBoletaCli>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		// recorrer el carro para encontrar el producto
		for (DetalleBoletaCli d : carro) {
			if (d.getIdprod().equals(codigo)) {
				// actualizamosun
				cantArticulos -= d.getCantidad();
				subTotalVenta -= d.getImporte();
				carro.remove(d);
				break;
			}
		}
		// actualizamos las variables a nivel de sesion -> como atributos
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		response.sendRedirect("carrito.jsp");
		
	}

	private void agregarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// leer los datos del producto seleccionado para "agregarlo" al carro de compras
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		// la informacion del producto enviado como atributo de sesion
		Producto p = (Producto) request.getSession().getAttribute("p");
		// agregar al carro de compra el producto seleccionado y su cantidad
		DetalleBoletaCli d = new DetalleBoletaCli();
		d.setIdprod(p.getCodProd());
		d.setNomprod(p.getNombre());
		d.setPreciovta(p.getPrecio());
		d.setCantidad(cantidad);
		d.setImporte(d.getCantidad() * d.getPreciovta());
				
		// obtiene las variables del carro a nivel de sesion
		ArrayList<DetalleBoletaCli> carro = (ArrayList<DetalleBoletaCli>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		// agregar / actualizamos 
		carro.add(d);
		subTotalVenta += d.getImporte();
		cantArticulos += d.getCantidad();
				
		// actualizamos las variables a nivel de sesion -> como atributos
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		response.sendRedirect("carrito.jsp");
	}

}
