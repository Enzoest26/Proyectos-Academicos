package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Producto;

/**
 * Servlet implementation class SeleccionarCompraServlet
 */
@WebServlet(name = "add", urlPatterns = { "/add" })
public class SeleccionarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró en el Servlet de AgregarSeleccionado");
		// capturar el codigo del producto seleccionado en el catalogo
		String codigo = request.getParameter("codigo");
		// obtener un objeto de Producto y enviarlo como atributo de sesion -> pag compra
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Producto p = fabrica.getProductoDAO().obtenerPro(codigo);
		//
		request.getSession().setAttribute("p", p);
		response.sendRedirect("compra.jsp");
	}

}
