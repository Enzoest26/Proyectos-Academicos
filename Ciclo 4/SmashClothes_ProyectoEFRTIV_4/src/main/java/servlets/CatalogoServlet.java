package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entidad.Prod_Cat;

/**
 * Servlet implementation class CatalogoServlet
 */
@WebServlet(name = "verCatalogo", urlPatterns = { "/verCatalogo" })
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet de Catálogo");
		// Obtener un listado de los productos y su descripcion de categoria
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<Prod_Cat> listado = fabrica.getProductoDAO().listadoProductoCategoria();
		// enviar el listado a la página de catalogo
		request.setAttribute("lstProductos", listado);
		request.getRequestDispatcher("catalogopro.jsp").forward(request, response);
	}

}
