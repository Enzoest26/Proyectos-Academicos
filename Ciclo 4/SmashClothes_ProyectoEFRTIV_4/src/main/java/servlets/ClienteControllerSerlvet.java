package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.annotation.Resources;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.tools.FileObject;

import dao.DAOFactory;
import entidad.Cliente;
import entidad.Proveedor;

/**
 * Servlet implementation class ClienteControllerSerlvet
 */
@WebServlet(name = "crudCliente", description = "El CRUD de Cliente", urlPatterns = { "/crudCliente" })
public class ClienteControllerSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ruta = "C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\clientes\\";
	private File subida = new File(ruta);
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteControllerSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion es : " + accion);
		switch (accion) {
		case "Registrar":{
			registrarCliente(request, response);
			break;
		}
		case "Editar":{
			editarCliente(request, response);
			break;
		}
		case "Eliminar":{
			eliminarCliente(request,response);
			break;
		}
		case "Volver":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
			request.getSession().setAttribute("listadoCli", listadoCli);
			response.sendRedirect("ManCliente.jsp");
			break;
		}
		default:
			break;
		}
	}

	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		
		int ok = fabrica.getClienteDAO().eliminar(codigo);
		if(ok == 0 ) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'Error en Eliminar'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
			request.getSession().setAttribute("listadoCli", listadoCli);
			request.getRequestDispatcher("ManCliente.jsp").forward(request, response);
		}else {
			fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
			request.getSession().setAttribute("listadoCli", listadoCli);
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Exito',"
					+ "            text: 'Se elimino, recuerda que al eliminar se cambio el estado pero sigue estando visible'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			
			request.getRequestDispatcher("ManCliente.jsp").forward(request, response);
			
		}
	}

	private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			String codigo = request.getParameter("txtCodigoCli");
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			String tipoDoc = request.getParameter("cmbTipoDoc");
			String numDoc = request.getParameter("txtNumDoc");
			String sexo = request.getParameter("cmbSexo");
			String edad = request.getParameter("txtEdad");
			String fechaNa = request.getParameter("txtFechaNac");
			String correo = request.getParameter("txtCorreo");
			String estado = request.getParameter("cmbEstado");
			Part part = request.getPart("fileFoto");
			String foto = guardarFoto(part, subida,codigo);
			String extension =  foto.substring(foto.lastIndexOf(".") + 1);
			
			Cliente cl = new Cliente();
			cl.setCodigo(codigo);
			cl.setNombre(nombre);
			cl.setApellido(apellido);
			cl.setTipoDoc(Integer.parseInt(tipoDoc));
			cl.setNumDoc(numDoc);
			cl.setSexo(sexo);
			cl.setEdad(Integer.parseInt(edad));
			cl.setFechaNa(fechaNa);
			cl.setCorreo(correo);
			cl.setFotoExtension(extension);
			cl.setFotoRu(foto);
			cl.setEstado(Integer.parseInt(estado));
			
			int ok = fabrica.getClienteDAO().editar(cl);
			if(ok == 0 ) {
				String msjError ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'error',"
						+ "            title: 'Error',"
						+ "            text: 'Error en Editar'"
					
						+ "        })</script>";
				request.setAttribute("msjError", msjError);
				ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
				request.setAttribute("listadoCli", listadoCli);
				request.getRequestDispatcher("ManCliente.jsp").forward(request, response);
			}else {
				fabrica = DAOFactory.getDAOFactory(1);
				String msjError ="<script>"
						+ "Swal.fire({"
						+ "            icon: 'success',"
						+ "            title: 'Exito',"
						+ "            text: 'Actualización completada, si no se aprecia los cambios borrar el cache'"
					
						+ "        })</script>";
				request.setAttribute("msjError", msjError);
				ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
				request.setAttribute("listadoCli", listadoCli);
				request.getRequestDispatcher("ManCliente.jsp").forward(request, response);
				
			}
	}

	private void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String tipoDoc = request.getParameter("cmbTipoDoc");
		String numDoc = request.getParameter("txtNumDoc");
		String sexo = request.getParameter("cmbSexo");
		String edad = request.getParameter("txtEdad");
		String fechaNa = request.getParameter("txtFechaNac");
		String correo = request.getParameter("txtCorreo");
		String estado = request.getParameter("cmbEstado");
		Part part = request.getPart("fileFoto");
		String foto = guardarFoto(part, subida, fabrica.getClienteDAO().obtenerCod());
		String extension =  foto.substring(foto.lastIndexOf(".") + 1);
		
		Cliente cl = new Cliente();
		
		
		
		cl.setCodigo(fabrica.getClienteDAO().obtenerCod());
		cl.setNombre(nombre);
		cl.setApellido(apellido);
		cl.setTipoDoc(Integer.parseInt(tipoDoc));
		cl.setNumDoc(numDoc);
		cl.setSexo(sexo);
		cl.setEdad(Integer.parseInt(edad));
		cl.setFechaNa(fechaNa);
		cl.setCorreo(correo);
		cl.setFotoExtension(extension);
		cl.setFotoRu(foto);
		cl.setEstado(Integer.parseInt(estado));
		int ok = fabrica.getClienteDAO().registrar(cl);
		if(ok == 0 ) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'Error en Registrar'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			request.getRequestDispatcher("ManCliente.jsp").forward(request, response);
		}else {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Error',"
					+ "            text: 'Registro exitoso'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Cliente> listadoCli = fabrica.getClienteDAO().listarClientes();
			request.getSession().setAttribute("listadoCli", listadoCli);
			
			request.getRequestDispatcher("ManCliente.jsp").forward(request, response);
			
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
			File file = new File(pathUploads, fullFile);
			if(input != null) {
				
				if(file.exists()) {
					file.delete();
				}
				
				fullPath = file.getAbsolutePath();
				Files.copy(input, file.toPath());
				
			}
			input.close();
		}
		catch (Exception e) {
			System.out.println("Error en guardar el archivo: " + e.getMessage());
		}
		
		return fullPath;
	}

}
