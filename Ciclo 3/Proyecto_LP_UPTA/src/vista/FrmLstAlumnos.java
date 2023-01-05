package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.Alumno;
import mantenimiento.GestionAlumnoDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;



public class FrmLstAlumnos extends JInternalFrame


{

	private JPanel contentPane;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionAlumnoDAO gUser = new GestionAlumnoDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstAlumnos frame = new FrmLstAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLstAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("LISTADO DE ALUMNOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new java.awt.Font("Century Gothic", java.awt.Font.BOLD, 16));
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// llamar al método
				listado();
			}
		});
		
		JButton btnPdf = new JButton("Exportar");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
		
		scrollPane = new JScrollPane();
		
		tblUsuarios = new JTable();
		tblUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuarios);
		//columnas de la tabla
		
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Fecha");
		model.addColumn("DNI");
		
		tblUsuarios.setModel(model);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(173)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(190))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(165)
					.addComponent(btnListado, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnPdf, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(193))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListado)
						.addComponent(btnPdf)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	private JTable tblUsuarios;
	private JScrollPane scrollPane;
	
	void imprimePDF() {
		//PASO 1
		String nombArchivo = "reportes/listadoAlumnos.pdf";
		try {
			//paso 2: crear plantilla
			Document plantilla = new Document();
			//paso 3: crear el archivo PDF
			FileOutputStream fos = new FileOutputStream(nombArchivo);
			//paso 4: relacionar la pantilla con el archivo pdf creado
			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);
			//paso 5: abrir el documento a modo de escritura
			plantilla.open();
			
			//agregar titulo -- parrafo
			Paragraph p = new Paragraph("LISTADO DE ALUMNOS", FontFactory.getFont("arial",22,Font.BOLD,BaseColor.CYAN));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);
			//agrega un espacio
			p = new Paragraph(" ");
			plantilla.add(p);
			
			//2. llamar proceso --> listar usuario
			ArrayList<Alumno> listarUser = gUser.listarAlumnosGeneral();
			//validar el resultado del proceso
			if(listarUser.size() == 0) {
				p = new Paragraph("lista vacia",FontFactory.getFont("arial",14,Font.ITALIC,BaseColor.RED));
				plantilla.add(p);
			}else {
				//crear tabla
				PdfPTable tabla = new PdfPTable(6);
				//encabezado de la tabla --> agregar las columnas
				tabla.addCell("LOGO");
				tabla.addCell("ID");
				tabla.addCell("NOMBRE");
				tabla.addCell("APELLIDO");
				tabla.addCell("FECHA DE NACIMIENTO");
				tabla.addCell("DNI");
				
				//recorrido
				for(Alumno a : listarUser) {
					
					Image img;
					if(new File("src/img/c"+a.getIdAlumno()+".png").exists()){
						img = Image.getInstance("src/img/c"+a.getIdAlumno()+".png");
					}else {
						img = Image.getInstance("src/img/alumno.png");
					}
					
					tabla.addCell(img);
					tabla.addCell(a.getIdAlumno() + " ");
					tabla.addCell(a.getNombre());
					tabla.addCell(a.getApellido());
					tabla.addCell(a.getFechNa());
					tabla.addCell(a.getDni());

			}
				plantilla.add(tabla);
			}
				//cerrar el documento
				plantilla.close();
				
				//mostrar el archivo pdf
				Desktop.getDesktop().open(new File(nombArchivo));
				
			
		} catch (Exception e) {
			System.out.println("Error al generar el reporte"+e.getMessage());
		}
	}
	
	
	
	void listado(){
		//1. limpiar la tabla
		model.setRowCount(0);
		//2. llamar proceso --> listar usuario
		ArrayList<Alumno> listarUser = gUser.listarAlumnosGeneral();
		//validar el resultado del proceso
		if(listarUser.size() == 0) {
			mensajeError("Lista vacia");
		}else {
			for(Alumno a : listarUser) {
				Object fila[] = {a.getIdAlumno(),
								a.getNombre(),
								a.getApellido(),
								a.getFechNa(),
								a.getDni()
				};
				model.addRow(fila);
			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "ERROR", 0);
		
	}
}



