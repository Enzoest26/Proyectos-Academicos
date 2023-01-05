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
import entidad.TipoDocumento;

/**
 * Servlet implementation class ClienteAccionServlet
 */
@WebServlet(name = "accionCliente", description = "Accion a realizar del cliente", urlPatterns = { "/accionCliente" })
public class ClienteAccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAccionServlet() {
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
			String titulo = "Registrar Cliente";
			String codRead = "readonly='readonly'";
			
			request.setAttribute("codRead", codRead);
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			String cod = fabrica.getClienteDAO().obtenerCod();
			request.setAttribute("codCli", cod);
			request.setAttribute("codigo", codigo);
			request.setAttribute("titulo", titulo);
			request.setAttribute("accion", accion);
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<TipoDocumento> tipoDoc = fabrica.getTipoDocumentoDAO().listarTipo();
			request.setAttribute("tipoDoc", tipoDoc);
			request.setAttribute("estados", estados);
			request.getRequestDispatcher("ManSubCliente.jsp").forward(request, response);
			break;
		}
		case "Editar":{
			String titulo = "Editar Cliente";
			String codRead = "readonly='readonly'";
			request.setAttribute("codRead", codRead);
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			Cliente cl = fabrica.getClienteDAO().obtenerCli(codigo);
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<TipoDocumento> tipoDoc = fabrica.getTipoDocumentoDAO().listarTipo();
			request.setAttribute("cl", cl);
			request.setAttribute("accion", accion);
			request.setAttribute("titulo", titulo);
			request.setAttribute("tipoDoc", tipoDoc);
			request.setAttribute("estados", estados);
			request.getRequestDispatcher("ManSubCliente.jsp").forward(request, response);
			break;
		}
		case "Consultar":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			String titulo = "Consultar Cliente";
			String disable = "disabled";
			String retornar= "Volver";
			String read = "readonly='readonly'";
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
		
			Cliente cl = fabrica.getClienteDAO().obtenerCli(codigo);
			
			request.setAttribute("titulo", titulo);
			request.setAttribute("accion", retornar);
			request.setAttribute("cl", cl);
			request.setAttribute("read", read);
			request.setAttribute("estados", estados);
			request.setAttribute("desactivar", disable);
			request.getRequestDispatcher("ManSubCliente.jsp").forward(request, response);
			break;
		}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
