package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAOFactory;
import entidad.Producto;

/**
 * Servlet implementation class ProductoControllerServlet
 */
@WebServlet(name = "crudProd", urlPatterns = { "/crudProd" })
public class ProductoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String ruta = "C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\productos\\";
	private File subida = new File(ruta);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("btnAccion");
		switch (accion) {
		case "Registrar":{
			registrarProducto(request, response);
			break;
			}
		case "Editar":{
			editarProducto(request,response);
			break;
		}
		case "Eliminar":{
			eliminarProducto(request,response);
			break;
		}
		case "Volver":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
			request.getSession().setAttribute("listadoProd", listadoProd);
			response.sendRedirect("ManProducto.jsp");
			break;
		}
		default:
			break;
		}
	}
	private void editarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			String codigo = request.getParameter("txtCodigo");
			String fecha = request.getParameter("txtFecha");
			String descrip = request.getParameter("txtDescrip");
			String categoria = request.getParameter("cmbCategoria");
			String estado = request.getParameter("cmbEstado");
			String stock = request.getParameter("txtStock");
			String precio = request.getParameter("txtPrecio");
			String nombre = request.getParameter("txtNombre");
			Part fotoPart = request.getPart("fileFoto");
			String proveedor = request.getParameter("cmbProveedor");
			
			
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			
			//Guardar la foto
			String fotoRu = guardarFoto(fotoPart, subida, codigo);
			String fotoExte = fotoRu.substring(fotoRu.lastIndexOf(".")+1);
			
			//Parte de convertir al objeto
			
			Producto p = new Producto();
			p.setCodProd(codigo);
			
			p.setCodProvee(proveedor);
			p.setDescrip(descrip);
			p.setEstado(Integer.parseInt(estado));
			p.setFecha(fecha);
			p.setFoto(fotoRu);
			p.setFotoExte(fotoExte);
			p.setIdCate(categoria);
			p.setNombre(nombre);
			p.setPrecio(Double.parseDouble(precio));
			p.setStock(Integer.parseInt(stock));
			int ok = fabrica.getProductoDAO().editar(p);
			if(ok == 0) {
				String msjError ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'success',"
						+ "            title: 'Buena',"
						+ "            text: 'Se completo la actualización'"
					
						+ "        })</script>";
				ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
				request.getSession().setAttribute("listadoProd", listadoProd);
				request.setAttribute("msjError", msjError);
				request.getRequestDispatcher("ManProducto.jsp").forward(request, response);
			}else {
				String msjError ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error',"
						+ "            text: 'Error al actualizar'"
					
						+ "        })</script>";
				request.setAttribute("msjError", msjError);
				fabrica = DAOFactory.getDAOFactory(1);
				ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
				request.getSession().setAttribute("listadoProd", listadoProd);
				response.sendRedirect("ManProducto.jsp");
			}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		int ok = fabrica.getProductoDAO().eliminar(codigo);
		
		if(ok == 0) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'No se cambio el estado'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManProducto.jsp").forward(request, response);
		}else {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Buena',"
					+ "            text: 'Se elimino, recuerda que al eliminar se cambio el estado pero sigue estando visible'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
			request.getSession().setAttribute("listadoProd", listadoProd);
			
			request.getRequestDispatcher("ManProducto.jsp").forward(request, response);
			
		}
		
		
	}

	private void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		String fecha = request.getParameter("txtFecha");
		String descrip = request.getParameter("txtDescrip");
		String categoria = request.getParameter("cmbCategoria");
		String estado = request.getParameter("cmbEstado");
		String stock = request.getParameter("txtStock");
		String precio = request.getParameter("txtPrecio");
		String nombre = request.getParameter("txtNombre");
		Part fotoPart = request.getPart("fileFoto");
		String proveedor = request.getParameter("cmbProveedor");
		
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		
		//Guardar la foto
		String fotoRu = guardarFoto(fotoPart, subida, codigo);
		String fotoExte = fotoRu.substring(fotoRu.lastIndexOf(".")+1);
		
		//Parte de convertir al objeto
		
		Producto p = new Producto();
		p.setCodProd(fabrica.getProductoDAO().obtenerCod());
		System.out.println("codigo es: " + fabrica.getProductoDAO().obtenerCod());
		p.setCodProvee(proveedor);
		p.setDescrip(descrip);
		p.setEstado(Integer.parseInt(estado));
		p.setFecha(fecha);
		p.setFoto(fotoRu);
		p.setFotoExte(fotoExte);
		p.setIdCate(categoria);
		p.setNombre(nombre);
		p.setPrecio(Double.parseDouble(precio));
		p.setStock(Integer.parseInt(stock));
		int ok = fabrica.getProductoDAO().registrar(p);
		if(ok == 0) {
			
		}else {
			fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Producto> listadoProd = fabrica.getProductoDAO().listarProductos();
			request.getSession().setAttribute("listadoProd", listadoProd);
			response.sendRedirect("ManProducto.jsp");
		}
		
	}

	private String guardarFoto(Part part, File pathUploads, String codigo) {
		String fullPath = "";
		
		try {
			
			Path path = Paths.get(part.getSubmittedFileName());
			
			String fileName = path.getFileName().toString();
			String extension = fileName.substring(fileName.lastIndexOf(".")).trim();
		
			InputStream input = part.getInputStream();
			String fullFile = codigo.concat(extension) ;
			if(input != null) {
				File file = new File(pathUploads, fullFile);
				if(file.exists()) {
					file.delete();
				}
				fullPath = file.getAbsolutePath();
				Files.copy(input, file.toPath());
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return fullPath;
	}

}
