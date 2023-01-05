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
import entidad.Proveedor;

/**
 * Servlet implementation class ProveedorControllerServlet
 */
@WebServlet(name = "crudProve", description = "El crud del proveedor", urlPatterns = { "/crudProve" })
public class ProveedorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ruta = "C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\proveedores\\";
	private File subida = new File(ruta);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorControllerServlet() {
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
			registrarProveedor(request, response);
			
			break;
		}
		case "Editar":{
			editarProveedor(response, request);
			break;
		}
		case "Eliminar":{
			
			eliminarProveedor(request,response);
			break;
		}
		case "Volver":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Proveedor> listadoProv = fabrica.getProveedorDAO().listarProveedor();
			request.getSession().setAttribute("listadoProv", listadoProv);
			response.sendRedirect("ManProveedor.jsp");
			break;
		}
		default:
			break;
		}
	}

	private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod = request.getParameter("txtCodigo");
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		int ok = fabrica.getProveedorDAO().eliminar(cod);
		if(ok == 0) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'No se cambio el estado'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManProveedor.jsp").forward(request, response);
		}else{
			
			fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Proveedor> listadoProv = fabrica.getProveedorDAO().listarProveedor();
			request.getSession().setAttribute("listadoProv", listadoProv);
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Buena',"
					+ "            text: 'Se elimino, recuerda que al eliminar se cambio el estado pero sigue estando visible'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManProveedor.jsp").forward(request, response);
		}
	}

	private void editarProveedor(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String represe= request.getParameter("txtRepre");
		String empresa = request.getParameter("txtEmpresa");
		String ruc = request.getParameter("txtRUC");
		String pais = request.getParameter("txtPais");
		String estado = request.getParameter("cmbEstado");
		String correo =request.getParameter("txtCorreo");
		String telefono =request.getParameter("txtTelefono");
		Part logoPart = request.getPart("fileLogo");
		String codigo = request.getParameter("txtCodigo");
		
		String fotoRu = guardarFoto(logoPart, subida, codigo);
		String fotoExte = fotoRu.substring(fotoRu.lastIndexOf(".")+1);
		
		//Cremos el objeto de clase Proveedor
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		Proveedor prov = new Proveedor();
		prov.setCodProv(codigo);
		prov.setCorreo(correo);
		prov.setEmpresa(empresa);
		prov.setEstado(Integer.parseInt(estado));
		prov.setFotoExte(fotoExte);
		prov.setFotoRu(fotoRu);
		prov.setPais(pais);
		prov.setReprese(represe);
		prov.setRuc(ruc);
		prov.setTele(telefono);
		int ok = fabrica.getProveedorDAO().editar(prov);
		if(ok == 0) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'Error en editar'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManProveedor.jsp").forward(request, response);
			
		}else{
			fabrica = DAOFactory.getDAOFactory(1);
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Exito',"
					+ "            text: 'Actualización completada'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			ArrayList<Proveedor> listadoProv = fabrica.getProveedorDAO().listarProveedor();
			request.getSession().setAttribute("listadoProv", listadoProv);
			response.sendRedirect("ManProveedor.jsp");
		}
	}

	private void registrarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String represe= request.getParameter("txtRepre");
		String empresa = request.getParameter("txtEmpresa");
		String ruc = request.getParameter("txtRUC");
		String pais = request.getParameter("txtPais");
		String estado = request.getParameter("cmbEstado");
		String correo =request.getParameter("txtCorreo");
		String telefono =request.getParameter("txtTelefono");
		Part logoPart = request.getPart("fileLogo");
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		String codigo = fabrica.getProveedorDAO().obtenerCod();
		String fotoRu = guardarFoto(logoPart, subida, codigo);
		String fotoExte = fotoRu.substring(fotoRu.lastIndexOf(".")+1);
		
		//Cremos el objeto de clase Proveedor
		
		Proveedor prov = new Proveedor();
		prov.setCodProv(fabrica.getProveedorDAO().obtenerCod());
		prov.setCorreo(correo);
		prov.setEmpresa(empresa);
		prov.setEstado(Integer.parseInt(estado));
		prov.setFotoExte(fotoExte);
		prov.setFotoRu(fotoRu);
		prov.setPais(pais);
		prov.setReprese(represe);
		prov.setRuc(ruc);
		prov.setTele(telefono);

		int ok = fabrica.getProveedorDAO().registrar(prov);
		if(ok == 0) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'No se registro'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManSubProveedor.jsp").forward(request, response);
		}else{
			fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Proveedor> listadoProv = fabrica.getProveedorDAO().listarProveedor();
			request.getSession().setAttribute("listadoProv", listadoProv);
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'succes',"
					+ "            title: 'Buena',"
					+ "            text: 'Registro completado'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManProveedor.jsp").forward(request, response);
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
