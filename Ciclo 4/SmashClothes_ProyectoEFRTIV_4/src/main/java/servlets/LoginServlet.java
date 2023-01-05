package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Cuenta;

/**
 * Servlet implementation class Login2
 */
@WebServlet(name = "ingreso", urlPatterns = { "/ingreso" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet: Login");
		// leer la información ingresada en la página de login (registro para mi)
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		System.out.println(usuario + "/" + clave);
		// proceso
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Cuenta u = fabrica.getCuentaDAO().validar(usuario, clave);
		if(u != null) {
			request.getSession().setAttribute("u", u); // envía atributo a nivel de session
			response.sendRedirect("principal.jsp");
		}else {
			request.setAttribute("mensaje", 
					"<script>swal('Mensaje','Usuario o clave incorrectos','error');</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
