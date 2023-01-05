package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Desktop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DAOFactory;
import entidad.Categoria;
import entidad.Cliente;
import entidad.Producto;
import entidad.Proveedor;

/**
 * Servlet implementation class ReporteServlet
 */
@WebServlet(name = "reportes", description = "Serlvet para realizar reportes", urlPatterns = { "/reportes" })
public class ReporteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public ArrayList<Producto> lstPDF ;
     public ArrayList<Cliente> lstCliPDF;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("btnCondi");
		switch (accion) {
		case "producto":{
			
			ArrayList<Producto> listadoProd = new ArrayList<>();
			String fecha = request.getParameter("txtFechaCondi");
			String categoria = request.getParameter("cmbCategoriaCondi");
			System.out.println("Fecha es: " + fecha);
			System.out.println("Categoria es: " + categoria);
			if(fecha.equals("") && categoria.equals("1")) {
				
				DAOFactory fabrica = DAOFactory.getDAOFactory(1);
				listadoProd = fabrica.getProductoDAO().listarReportes(null, null);
				request.getSession().setAttribute("listadoProd", listadoProd);
				response.sendRedirect("reporteProducto.jsp");
				}else {
				if ( categoria.equals( "1") && !fecha.equals("")) {
					
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					listadoProd = fabrica.getProductoDAO().listarReportes(fecha, null);
					request.getSession().setAttribute("listadoProd", listadoProd);
					response.sendRedirect("reporteProducto.jsp");
				}else if ( !categoria.equals( "1") && fecha.equals("")) {
					
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					listadoProd = fabrica.getProductoDAO().listarReportes(null, categoria);
					request.getSession().setAttribute("listadoProd", listadoProd);
					response.sendRedirect("reporteProducto.jsp");
				}
				else {
					
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					listadoProd = fabrica.getProductoDAO().listarReportes(fecha, categoria);
					request.getSession().setAttribute("listadoProd", listadoProd);
					response.sendRedirect("reporteProducto.jsp");
				}
				
			}
			break;
		}
		
		case "productopdf":{
			String fecha = request.getParameter("txtFechaCondi");
			String categoria = request.getParameter("cmbCategoriaCondi");
			System.out.println("Fecha es: " + fecha);
			System.out.println("Categoria es: " + categoria);
			if(fecha.equals("") && categoria.equals("1")) {
				System.out.println("EStoy en fecha nula");
				DAOFactory fabrica = DAOFactory.getDAOFactory(1);
				lstPDF = fabrica.getProductoDAO().listarReportes(null, null);
				generaPDFProducto(request, response);
				}else {
				if ( categoria.equals( "1") && !fecha.equals("")) {
					System.out.println("EStoy en categoria nula");
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					lstPDF = fabrica.getProductoDAO().listarReportes(fecha, null);
					generaPDFProducto(request, response);
				}else if ( !categoria.equals( "1") && fecha.equals("")) {
					System.out.println("EStoy en categoria nula");
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					lstPDF = fabrica.getProductoDAO().listarReportes(null, categoria);
					generaPDFProducto(request, response);
				}
				else {
					System.out.println("EStoy en nulos ");
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					lstPDF = fabrica.getProductoDAO().listarReportes(fecha, categoria);
					generaPDFProducto(request, response);
				}
			}
			
			break;
		}
		case "cliente":{

			ArrayList<Cliente> listadoCli = new ArrayList<>();
			String fecha = request.getParameter("txtFechaNa");
			String nombre = request.getParameter("txtNombreCondi");
			System.out.println("Fecha es: " + fecha);
			System.out.println("Nombre es: " + nombre);
			if(fecha.equals("") && nombre.equals("")) {
				
				DAOFactory fabrica = DAOFactory.getDAOFactory(1);
				listadoCli =fabrica.getClienteDAO().listarXCondi(null, null);
				request.getSession().setAttribute("listadoCli", listadoCli);
				response.sendRedirect("reporteCliente.jsp");
				}else {
				if ( nombre.equals( "") && !fecha.equals("")) {
					
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					listadoCli = fabrica.getClienteDAO().listarXCondi(fecha, null);
					request.getSession().setAttribute("listadoCli", listadoCli);
					response.sendRedirect("reporteCliente.jsp");
				}else if ( !nombre.equals( "") && fecha.equals("")) {
					
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					listadoCli =fabrica.getClienteDAO().listarXCondi(null, nombre);
					request.getSession().setAttribute("listadoCli", listadoCli);
					response.sendRedirect("reporteCliente.jsp");
				}
				else {
					
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					listadoCli = fabrica.getClienteDAO().listarXCondi(fecha, nombre);
					request.getSession().setAttribute("listadoCli", listadoCli);
					response.sendRedirect("reporteCliente.jsp");
				}
				
			}
			break;
			
		}
		case "clientePdf":{
			String fecha = request.getParameter("txtFechaNa");
			String nombre = request.getParameter("txtNombreCondi");
			System.out.println("Fecha es: " + fecha);
			System.out.println("Nombre es: " + nombre);
			if(fecha.equals("") && nombre.equals("")) {
				System.out.println("EStoy en fecha nula");
				DAOFactory fabrica = DAOFactory.getDAOFactory(1);
				lstCliPDF = fabrica.getClienteDAO().listarXCondi(null, null);
				generaPDFCliente(request, response);
				}else {
				if ( nombre.equals( "") && !fecha.equals("")) {
					System.out.println("EStoy en categoria nula");
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					lstCliPDF = fabrica.getClienteDAO().listarXCondi(fecha, null);
					generaPDFCliente(request, response);
				}else if ( !nombre.equals( "") && fecha.equals("")) {
					System.out.println("EStoy en categoria nula");
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					lstCliPDF = fabrica.getClienteDAO().listarXCondi(null, nombre);
					generaPDFCliente(request, response);
				}
				else {
					System.out.println("Estoy en ninguno nulo");
					DAOFactory fabrica = DAOFactory.getDAOFactory(1);
					lstCliPDF = fabrica.getClienteDAO().listarXCondi(fecha, nombre);
					generaPDFCliente(request, response);
				}
			}
			break;
		}
		default:
			break;
		}
	}

	private void generaPDFCliente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		Date fecha1 = new Date();
		String nArchivo = "D:\\ReporteCliente" + "_"+new SimpleDateFormat("dd-MM-yyyy").format(fecha1)+".pdf";
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nArchivo);
			

			PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int [] {50, 150});
			
			PdfPCell cell1 = new PdfPCell();
			//Image img = Image.getInstance("img/logo-mini.png");
			cell1.setFixedHeight(80f);
			//cell1.addElement(img);
			cell1.setBorderColor(BaseColor.WHITE);
			
			//fecha
			Paragraph fecha = new Paragraph();
			fecha.setAlignment(Chunk.ALIGN_RIGHT);
			Date date = new Date();
			
			Paragraph p = new Paragraph("SMASH CLOTHES ",FontFactory.getFont("FontFamily",22,Font.BOLD,BaseColor.GRAY));
			p.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(p); 
			
			
			fecha.add("Fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
			plantilla.add(fecha);
			
			
			//agregar titulo
			Paragraph p2 = new Paragraph("Reporte de Clientes ",FontFactory.getFont("FontFamily",18,Font.BOLD,BaseColor.BLACK));
			p.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(p2);
			//separador
			Paragraph ca = new Paragraph("      ",FontFactory.getFont("FontFamily",22));
			ca.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(ca);	
			
			Paragraph ca1 = new Paragraph("      ",FontFactory.getFont("FontFamily",145));
			ca1.setAlignment(Element.ALIGN_CENTER);
			
			//crear tabla
			PdfPTable tabla = new PdfPTable(5);
			tabla.setWidthPercentage(110);
			tabla.getDefaultCell().setBorder(0);
			float[] ColumnaProd = new float[] {10f, 30f, 30f,20f, 20f};
			tabla.setWidths(ColumnaProd);
			PdfPCell cli1 = new PdfPCell(new Phrase("Codigo"));
			PdfPCell cli2 = new PdfPCell(new Phrase("Nombre"));
			PdfPCell cli3 = new PdfPCell(new Phrase("Apellido"));
			PdfPCell cli4 = new PdfPCell(new Phrase("Fecha Nacimiento"));
			PdfPCell cli5 = new PdfPCell(new Phrase("Sexo"));
			
			
			
			cli1.setBorder(0);
			cli2.setBorder(0);
			cli3.setBorder(0);
			cli4.setBorder(0);
			cli5.setBorder(0);
			
			
			cli1.setBackgroundColor(BaseColor.GRAY);
			cli2.setBackgroundColor(BaseColor.GRAY);
			cli3.setBackgroundColor(BaseColor.GRAY);
			cli4.setBackgroundColor(BaseColor.GRAY);
			cli5.setBackgroundColor(BaseColor.GRAY);
			
			
			tabla.addCell(cli1);
			tabla.addCell(cli2);
			tabla.addCell(cli3);
			tabla.addCell(cli4);
			tabla.addCell(cli5);
			
			
			for (Cliente c : lstCliPDF) {
				tabla.addCell(c.getCodigo() + " ");
				tabla.addCell(c.getNombre());
				tabla.addCell(c.getApellido());						
				tabla.addCell(c.getFechaNa());
				tabla.addCell(c.getSexo());
			}
			plantilla.add(tabla);
			plantilla.add(ca1);
			plantilla.close();
			Desktop.getDesktop().open(new File(nArchivo));
			
			fos.close();
			request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL GENERAR REPORTE "+e.getMessage());
		}
	}

	private void generaPDFProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Date fecha1 = new Date();
		
		String nArchivo = "D:\\ReporteProductos" + "_"+new SimpleDateFormat("dd-MM-yyyy").format(fecha1)+".pdf";
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nArchivo);
			

			PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int [] {50, 150});
			
			PdfPCell cell1 = new PdfPCell();
			//Image img = Image.getInstance("img/logo-mini.png");
			cell1.setFixedHeight(80f);
			//cell1.addElement(img);
			cell1.setBorderColor(BaseColor.WHITE);
			
			//fecha
			Paragraph fecha = new Paragraph();
			fecha.setAlignment(Chunk.ALIGN_RIGHT);
			Date date = new Date();
			
			Paragraph p = new Paragraph("SMASH CLOTHES ",FontFactory.getFont("FontFamily",22,Font.BOLD,BaseColor.GRAY));
			p.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(p); 
			
			
			fecha.add("Fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
			plantilla.add(fecha);
			
			
			//agregar titulo
			Paragraph p2 = new Paragraph("Reporte de Productos ",FontFactory.getFont("FontFamily",18,Font.BOLD,BaseColor.BLACK));
			p.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(p2);
			//separador
			Paragraph cab = new Paragraph("      ",FontFactory.getFont("FontFamily",22));
			cab.setAlignment(Element.ALIGN_JUSTIFIED);
			plantilla.add(cab);
			
			Paragraph ca1 = new Paragraph("      ",FontFactory.getFont("FontFamily",145));
			ca1.setAlignment(Element.ALIGN_CENTER);
			
			//crear tabla
			PdfPTable tabla = new PdfPTable(6);
			tabla.setWidthPercentage(110);
			tabla.getDefaultCell().setBorder(0);
			float[] ColumnaProd = new float[] {15f, 20f, 20f,20f, 20f,10f};
			tabla.setWidths(ColumnaProd);
			PdfPCell cli1 = new PdfPCell(new Phrase("Codigo"));
			PdfPCell cli2 = new PdfPCell(new Phrase("Nombre"));
			PdfPCell cli3 = new PdfPCell(new Phrase("Fecha Publi."));
			PdfPCell cli4 = new PdfPCell(new Phrase("Categoria"));
			PdfPCell cli5 = new PdfPCell(new Phrase("Stock"));
			PdfPCell cli6 = new PdfPCell(new Phrase("Proveedor"));
			
			
			cli1.setBorder(0);
			cli2.setBorder(0);
			cli3.setBorder(0);
			cli4.setBorder(0);
			cli5.setBorder(0);
			cli6.setBorder(0);
			
			cli1.setBackgroundColor(BaseColor.GRAY);
			cli2.setBackgroundColor(BaseColor.GRAY);
			cli3.setBackgroundColor(BaseColor.GRAY);
			cli4.setBackgroundColor(BaseColor.GRAY);
			cli5.setBackgroundColor(BaseColor.GRAY);
			cli6.setBackgroundColor(BaseColor.GRAY);
			
			tabla.addCell(cli1);
			tabla.addCell(cli2);
			tabla.addCell(cli3);
			tabla.addCell(cli4);
			tabla.addCell(cli5);
			tabla.addCell(cli6);
			ArrayList<Categoria> lstCate = (ArrayList<Categoria>) request.getSession().getAttribute("listadoCate");
			ArrayList<Proveedor> lstProve = (ArrayList<Proveedor>) request.getSession().getAttribute("listadoProv");
			for(Producto pr : lstPDF ) {
				tabla.addCell(pr.getCodProd() + "");
				tabla.addCell(pr.getNombre());
				tabla.addCell(pr.getFecha());
				for (Categoria ca : lstCate) {
					if(ca.getIdCate().equals(pr.getIdCate())) {
						tabla.addCell(ca.getDescrip());	
					}else {
						
					}
				}
				tabla.addCell(String.valueOf(pr.getStock()));
				
				for (Proveedor pro : lstProve) {
					if(pro.getCodProv().equals(pr.getCodProvee())) {
						tabla.addCell(pro.getEmpresa());
					}else {
						
					}
				}
				
				
				
				
			}
			plantilla.add(tabla);
			plantilla.add(ca1);
			plantilla.close();
			Desktop.getDesktop().open(new File(nArchivo));
			
			fos.close();
			request.getRequestDispatcher("reporteProducto.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL GENERAR REPORTE "+e.getMessage());
		}
	}



}
