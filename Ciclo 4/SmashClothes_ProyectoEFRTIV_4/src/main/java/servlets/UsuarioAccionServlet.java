package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Estado;
import entidad.Proveedor;
import entidad.TipoDocumento;
import entidad.TipoUsuario;
import entidad.Usuario;

/**
 * Servlet implementation class UsuarioAccionServlet
 */
@WebServlet(name = "accionUsuario", description = "Accion a realizar el Usuario", urlPatterns = { "/accionUsuario" })
public class UsuarioAccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioAccionServlet() {
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
			String titulo = "Registrar Usuario";
			request.setAttribute("titulo", titulo);
			request.setAttribute("accion", accion);
			String codUsu = fabrica.getUsuarioDAO().obtenerCod();
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<TipoDocumento> tipoDoc = fabrica.getTipoDocumentoDAO().listarTipo();
			ArrayList<TipoUsuario> tipoUsu = fabrica.getTipoUsuarioDAO().listarManUsuario();
			request.setAttribute("tipoUsu", tipoUsu);
			request.setAttribute("tipoDoc", tipoDoc);
			request.setAttribute("estados", estados);
			request.setAttribute("codUsu", codUsu);
			request.setAttribute("titulo", titulo);
			request.getRequestDispatcher("ManSubUsuario.jsp").forward(request, response);
			break;
		}
		case "Editar":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			
			String titulo = "Editar Usuario";
			

			Usuario us = fabrica.getUsuarioDAO().obtenerUsu(codigo);
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<TipoDocumento> tipoDoc = fabrica.getTipoDocumentoDAO().listarTipo();
			ArrayList<TipoUsuario> tipoUsu = fabrica.getTipoUsuarioDAO().listarManUsuario();
			request.setAttribute("tipoUsu", tipoUsu);
			request.setAttribute("tipoDoc", tipoDoc);
			
			request.setAttribute("estados", estados);
			
			request.setAttribute("titulo", titulo);
			request.setAttribute("usu", us);
			request.setAttribute("accion", accion);
			request.getRequestDispatcher("ManSubUsuario.jsp").forward(request, response);
		}
		case "Consultar":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			
			String titulo = "Consultar Usuario";
			
			String retornar = "Volver";
			String disable = "disabled";
			String read = "readonly='readonly'";
			String accion1 = "Volver";
			Usuario us = fabrica.getUsuarioDAO().obtenerUsu(codigo);
			ArrayList<Estado> estados = fabrica.getEstadoDAO().listarEstado();
			ArrayList<TipoDocumento> tipoDoc = fabrica.getTipoDocumentoDAO().listarTipo();
			ArrayList<TipoUsuario> tipoUsu = fabrica.getTipoUsuarioDAO().listarManUsuario();
			request.setAttribute("tipoUsu", tipoUsu);
			request.setAttribute("tipoDoc", tipoDoc);
			request.setAttribute("read", read);
			request.setAttribute("estados", estados);
			request.setAttribute("desactivar", disable);
			request.setAttribute("titulo", titulo);
			request.setAttribute("usu", us);
			request.setAttribute("retornar", retornar);
			request.setAttribute("accion", accion1);
			request.getRequestDispatcher("ManSubUsuario.jsp").forward(request, response);
		}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
