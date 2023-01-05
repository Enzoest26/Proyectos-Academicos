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
import entidad.Estado;
import entidad.Producto;
import entidad.Proveedor;

/**
 * Servlet implementation class ManAccionServlet
 */
@WebServlet(name = "accionProducto", description = "Redireccionar", urlPatterns = { "/accionProducto" })
public class ProductoAccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoAccionServlet() {
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
			DAOFactory fabrica= DAOFactory.getDAOFactory(1);
			String titulo = "Registrar Prodcuto";
			request.setAttribute("titulo", titulo);
			request.setAttribute("accion", accion);
			String cod = fabrica.getProductoDAO().obtenerCod();
			ArrayList<Proveedor> combo = fabrica.getProveedorDAO().listarProveedor();
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<Categoria> categorias = fabrica.getProductoDAO().listarCategorias();
			request.setAttribute("codPro", cod);
			request.setAttribute("estados", estados);
			request.setAttribute("categorias", categorias);
			request.setAttribute("lstProve", combo);
			request.getRequestDispatcher("ManSubProducto.jsp").forward(request, response);
			break;
		}
		case "Editar":{
			String titulo = "Consultar Producto";
			DAOFactory fabrica= DAOFactory.getDAOFactory(1);
			Producto p = fabrica.getProductoDAO().obtenerPro(codigo);
		
			ArrayList<Proveedor> combo = fabrica.getProveedorDAO().listarProveedor();
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<Categoria> categorias = fabrica.getProductoDAO().listarCategorias();
		
			
			request.setAttribute("accion", accion);
			request.setAttribute("lstProve", combo);
			request.setAttribute("titulo", titulo);
			request.setAttribute("p", p);
			
			request.setAttribute("estados", estados);
			
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("ManSubProducto.jsp").forward(request, response);
		}
		case "Consultar": {
			String titulo = "Consultar Producto";
			DAOFactory fabrica= DAOFactory.getDAOFactory(1);
			Producto p = fabrica.getProductoDAO().obtenerPro(codigo);
			String read = "readonly='readonly'";
			ArrayList<Proveedor> combo = fabrica.getProveedorDAO().listarProveedor();
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<Categoria> categorias = fabrica.getProductoDAO().listarCategorias();
			String disable = "disabled";
			String retornar= "Volver";
			request.setAttribute("accion", retornar);
			request.setAttribute("lstProve", combo);
			request.setAttribute("titulo", titulo);
			request.setAttribute("p", p);
			request.setAttribute("read", read);
			request.setAttribute("estados", estados);
			request.setAttribute("desactivar", disable);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("ManSubProducto.jsp").forward(request, response);
		}
		case "Eliminar":{
			
		}
		default:
			break;
		}
	}

}
