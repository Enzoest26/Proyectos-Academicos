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
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Usuario;

/**
 * Servlet implementation class UsuarioControllerServlet
 */
@WebServlet(name = "crudUsuario", description = "El crud de usuario", urlPatterns = { "/crudUsuario" })
public class UsuarioControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ruta = "C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\";
	private File subida = new File(ruta);
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControllerServlet() {
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
			registrarUsuario(request,response);
			break;
		}
		case "Editar":{
			editarUsuario(request, response);
			break;
		}
		case "Eliminar":{
			eliminarUsuario(request, response);
			break;
		}
		case "Volver":{
			DAOFactory fabrica = DAOFactory.getDAOFactory(1);
			ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
			request.getSession().setAttribute("listadoUsu", listadoUsu);
			response.sendRedirect("ManUsuario.jsp");
			break;
		}
		default:
			break;
		}
		
	}
	
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		
		int ok = fabrica.getUsuarioDAO().eliminar(codigo);
		if(ok == 0 ) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'Error en Eliminar'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
			request.getSession().setAttribute("listadoUsu", listadoUsu);
			request.getRequestDispatcher("ManUsuario.jsp").forward(request, response);
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
			ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
			request.getSession().setAttribute("listadoUsu", listadoUsu);
			request.getRequestDispatcher("ManUsuario.jsp").forward(request, response);
			
		}
	}

	private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String codigo = request.getParameter("txtCodigo");
				String nombre = request.getParameter("txtNombre");
				String apellido = request.getParameter("txtApellido");
				String tipoDoc = request.getParameter("cmbTipoDoc");
				String numDoc = request.getParameter("txtNumDoc");
				String sexo =request.getParameter("cmbSexo");
				String edad = request.getParameter("txtEdad");
				String cargo = request.getParameter("cmbCargo");
				String depa = request.getParameter("txtDepa");
				String domici = request.getParameter("txtDomicilio");
				String distrito = request.getParameter("txtDistrito");
				String provincia = request.getParameter("txtProvincia");
				String pais = request.getParameter("txtPais");
				String nacio = request.getParameter("txtNacionalidad");
				String correo = request.getParameter("txtCorreo");
				Part fotoperfil = request.getPart("fileFoto");
				String estado = request.getParameter("cmbEstado");
				DAOFactory fabrica =  DAOFactory.getDAOFactory(1);
				String foto = guardarFoto(fotoperfil, subida, codigo);
				String extension = foto.substring(foto.lastIndexOf(".") + 1);
				Usuario us = new Usuario();
				us.setApellido(apellido);
				us.setCodUsu(codigo);
				us.setCorreo(correo);
				us.setDepa(depa);
				us.setDistrito(distrito);
				us.setDomici(domici);
				us.setEdad(Integer.parseInt(edad));
				us.setEstado(Integer.parseInt(estado));
				us.setFotoExte(extension);
				us.setFotoRu(foto);
				us.setIdtipo(Integer.parseInt(cargo));
				us.setNacio(nacio);
				us.setNombre(nombre);
				us.setNumDoc(numDoc);
				us.setPais(pais);
				us.setProvi(provincia);
				us.setSexo(sexo);
				us.setTipoDoc(Integer.parseInt(tipoDoc));
				
				int ok = fabrica.getUsuarioDAO().editar(us);
				if(ok == 0) {
					String msjError ="<script>"
							+ "Swal.fire({"
							+ "            icon: 'error',"
							+ "            title: 'Error',"
							+ "            text: 'Error en Editar'"
						
							+ "        })</script>";
					request.setAttribute("msjError", msjError);
					ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
					request.getSession().setAttribute("listadoUsu", listadoUsu);
					request.getRequestDispatcher("ManUsuario.jsp").forward(request, response);
				}else {
					String msjError ="<script>"
							+ "Swal.fire({"
							+ "            icon: 'success',"
							+ "            title: 'Exito',"
							+ "            text: 'Acualizacion completado'"
						
							+ "        })</script>";
					request.setAttribute("msjError", msjError);
					ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
					request.getSession().setAttribute("listadoUsu", listadoUsu);
					request.getRequestDispatcher("ManUsuario.jsp").forward(request, response);
				}
	}

	private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("txtCodigo");
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String tipoDoc = request.getParameter("cmbTipoDoc");
		String numDoc = request.getParameter("txtNumDoc");
		String sexo =request.getParameter("cmbSexo");
		String edad = request.getParameter("txtEdad");
		String cargo = request.getParameter("cmbCargo");
		String depa = request.getParameter("txtDepa");
		String domici = request.getParameter("txtDomicilio");
		String distrito = request.getParameter("txtDistrito");
		String provincia = request.getParameter("txtProvincia");
		String pais = request.getParameter("txtPais");
		String nacio = request.getParameter("txtNacionalidad");
		String correo = request.getParameter("txtCorreo");
		String estado = request.getParameter("cmbEstado");
		Part fotoperfil = request.getPart("fileFoto");
		
		DAOFactory fabrica =  DAOFactory.getDAOFactory(1);
		String foto = guardarFoto(fotoperfil, subida, fabrica.getUsuarioDAO().obtenerCod());
		String extension = foto.substring(foto.lastIndexOf(".") + 1);
		Usuario us = new Usuario();
		us.setApellido(apellido);
		us.setCodUsu(fabrica.getUsuarioDAO().obtenerCod());
		us.setCorreo(correo);
		us.setDepa(depa);
		us.setDistrito(distrito);
		us.setDomici(domici);
		us.setEdad(Integer.parseInt(edad));
		us.setEstado(Integer.parseInt(estado));
		us.setFotoExte(extension);
		us.setFotoRu(foto);
		us.setIdtipo(Integer.parseInt(cargo));
		us.setNacio(nacio);
		us.setNombre(nombre);
		us.setNumDoc(numDoc);
		us.setPais(pais);
		us.setProvi(provincia);
		us.setSexo(sexo);
		
		us.setTipoDoc(Integer.parseInt(tipoDoc));
		
		/*Realizar la cuenta*/
		Cuenta cu = new Cuenta();
		
		cu.setCodigo(fabrica.getCuentaDAO().obtenerCod());
		cu.setNombre(nombre);
		cu.setApellido(apellido);
		cu.setTipo(Integer.parseInt(cargo));
		cu.setFecha_nac("2000-12-12");
		cu.setUsuario(fabrica.getUsuarioDAO().obtenerCod() + "@mail.com");
		cu.setEstado(1);
		
		String clave = "";
		for (int i = 0; i < 8; i++) {
			int x = (int) Math.floor(Math.random()*(9 + 1));
			clave += x;
			System.out.println(x);
			i++;
		}
		cu.setClave(clave);
		
		us.setIdCuenta(fabrica.getCuentaDAO().obtenerCod());
	    
		int ok = fabrica.getUsuarioDAO().registrar(us, cu);
		if(ok == 0) {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'error',"
					+ "            title: 'Error',"
					+ "            text: 'Error en Registrar'"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
			request.getSession().setAttribute("listadoUsu", listadoUsu);
			request.getRequestDispatcher("ManUsuario.jsp").forward(request, response);
		}else {
			String msjError ="<script>"
					+ "Swal.fire({"
					+ "            icon: 'success',"
					+ "            title: 'Exito',"
					+ "            text: 'Registro completado, Usuario: "+cu.getUsuario()+", contraseña: "+cu.getClave()+". En caso de perdida, comunicarse con la empresa '"
				
					+ "        })</script>";
			request.setAttribute("msjError", msjError);
			ArrayList<Usuario> listadoUsu = fabrica.getUsuarioDAO().listarUsuarios();
			request.getSession().setAttribute("listadoUsu", listadoUsu);
			request.getRequestDispatcher("ManUsuario.jsp").forward(request, response);
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
