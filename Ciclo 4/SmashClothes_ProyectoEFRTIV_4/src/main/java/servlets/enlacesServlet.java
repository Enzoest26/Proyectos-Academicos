package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Categoria;
import entidad.Cliente;
import entidad.Producto;
import entidad.Proveedor;
import entidad.Usuario;

/**
 * Servlet implementation class enlacesServlet
 */
@WebServlet(name = "irA", description = "Enlaces del Servlet", urlPatterns = { "/irA" })
public class enlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enlacesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("btnEnlace");
		switch (accion) {
		case "productos": {
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
			request.getSession().setAttribute("listadoProd", listadoProd);
			
			response.sendRedirect("ManProducto.jsp");
			break;
		}
		case "clientes": {
			listarClientes(request, response);
			break;
		}
		case "proveedor": {
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Proveedor> listadoProv = fabrica.getProveedorDAO().listarProveedor();
			request.getSession().setAttribute("listadoProv", listadoProv);
			response.sendRedirect("ManProveedor.jsp");
			break;
		}
		case "usuario": {
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
			request.getSession().setAttribute("listadoUsu", listadoUsu);
			response.sendRedirect("ManUsuario.jsp");
			break;
		}
		case "ventas":{
			
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Producto> lstProdDispo = fabrica.getProductoDAO().listarDisponibles();
			ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
			String codigo = fabrica.getVentaDAO().obtenerCod();
			request.getSession().setAttribute("codigo", codigo);
			request.getSession().setAttribute("listadoCli", listadoCli);
			request.getSession().setAttribute("lstProdDispo", lstProdDispo);
			response.sendRedirect("Ventas.jsp");
			break;
		}
		case "reporteCliente":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
			request.getSession().setAttribute("listadoCli", listadoCli);
			response.sendRedirect("reporteCliente.jsp");
			break;
		}
		case "reporteProducto":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Proveedor> listadoProv = fabrica.getProveedorDAO().listarProveedor();
			ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
			ArrayList<Categoria> listadoCate = fabrica.getProductoDAO().listarCategorias();
			request.getSession().setAttribute("listadoProv", listadoProv);
			request.getSession().setAttribute("listadoProd", listadoProd);
			request.getSession().setAttribute("listadoCate", listadoCate);
			response.sendRedirect("reporteProducto.jsp");
			break;
		}
		default:
			
		}
	}

	public void listarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
		request.getSession().setAttribute("listadoCli", listadoCli);
		response.sendRedirect("ManCliente.jsp");
		
	}

}
