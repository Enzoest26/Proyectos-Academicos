package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionCuentaMySQL;
import entidad.Cuenta;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name = "crudusu", urlPatterns = { "/crudusu" })
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingresó al servlet registrar usuario");
		// variables
		String mensaje = "";
		String url;
		
		// entradas
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		String fecha_nac = request.getParameter("txtFecha");
		Cuenta u = new Cuenta(0, nombre, apellido, usuario, clave, fecha_nac, 0, 0);
		
		// procesos
		GestionCuentaMySQL gu = new GestionCuentaMySQL();
		int ok = gu.registrar(u);
		
		if (ok == 0) {
			mensaje += "<script>swal('Error al registrar los datos','Revisar los campos', 'error');</script>";
			url = "/registro.jsp";
		}else {
			mensaje = "<script>swal('Registro del usuario Completo','Ya puede ingresar al sistema !', 'success');</script>";
			url = "/login.jsp";
		}
		
		// salidas
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
