package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Cliente;
import entidad.Estado;
import entidad.Proveedor;

/**
 * Servlet implementation class ProveedorAccionServlet
 */
@WebServlet(name = "accionProvee", description = "Accion a realizar del Proveedor", urlPatterns = { "/accionProvee" })
public class ProveedorAccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorAccionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion  = request.getParameter("btnAccion");
		String codigo = request.getParameter("txtCodigo");
		
		switch (accion) {
		case "Registrar":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			String titulo = "Registrar Proveedor";
			String cod = fabrica.getProveedorDAO().obtenerCod();
			request.setAttribute("codPro", cod);
			request.setAttribute("titulo", titulo);
			request.setAttribute("accion", accion);
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			request.setAttribute("estados", estados);
			request.getRequestDispatcher("ManSubProveedor.jsp").forward(request, response);
			break;
			}
		case "Editar":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			
			String titulo = "Editar Proveedor";
			Proveedor prov = fabrica.getProveedorDAO().obtenerProv(codigo);
			
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
		
			request.setAttribute("estados", estados);
			request.setAttribute("accion", accion);
			request.setAttribute("titulo", titulo);
			request.setAttribute("prov", prov);
			
			request.getRequestDispatcher("ManSubProveedor.jsp").forward(request, response);
			break;
		}
		case "Consultar":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			
			String titulo = "Consultar Proveedor";
			Proveedor prov = fabrica.getProveedorDAO().obtenerProv(codigo);
			String retornar = "Volver";
			String disable = "disabled";
			String read = "readonly='readonly'";
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			request.setAttribute("read", read);
			request.setAttribute("estados", estados);
			request.setAttribute("desactivar", disable);
			request.setAttribute("titulo", titulo);
			request.setAttribute("prov", prov);
			request.setAttribute("accion", retornar);
			request.getRequestDispatcher("ManSubProveedor.jsp").forward(request, response);
		}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
