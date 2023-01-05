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
import entidad.Profesor;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionProfesorDAO;

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
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;



public class FrmLstProfesores extends JInternalFrame


{

	private JPanel contentPane;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionProfesorDAO gUser = new GestionProfesorDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstProfesores frame = new FrmLstProfesores();
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
	public FrmLstProfesores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("LISTADO DE PROFESORES");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new java.awt.Font("Century Gothic", java.awt.Font.BOLD, 16));
		
		JButton btnListado = new JButton("Listado");
		btnListado.setBackground(Color.BLACK);
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// llamar al método
				listado();
			}
		});
		
		JButton btnPdf = new JButton("Exportar");
		btnPdf.setBackground(Color.BLACK);
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
		
		scrollPane = new JScrollPane();
		
		tblUsuarios = new JTable();
		tblUsuarios.setBackground(SystemColor.info);
		tblUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuarios);
		//columnas de la tabla
		model.addColumn("ID");
		model.addColumn("Nombre del profesor");

		
		tblUsuarios.setModel(model);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(177)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(186))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(165)
					.addComponent(btnListado, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(17)
					.addComponent(btnPdf, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(186))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListado)
						.addComponent(btnPdf))
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
	}
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	private JTable tblUsuarios;
	private JScrollPane scrollPane;
	
	void imprimePDF() {
		//PASO 1
		String nombArchivo = "reportes/listadoProfesores.pdf";
		try {
			//paso 2: crear plantilla
			Document plantilla = new Document();
			//paso 3: crear el archivo PDF
			FileOutputStream fos = new FileOutputStream(nombArchivo);
			//paso 4: relacionar la pantilla con el archivo pdf creado
			PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);
			//paso 5: abrir el documento a modo de escritura
			plantilla.open();
			
			//logo
			

			
			//agregar titulo -- parrafo
			Paragraph p = new Paragraph("LISTADO DE PROFESORES", FontFactory.getFont("Impact",28,Font.BOLD,BaseColor.LIGHT_GRAY));
			p.setAlignment(Chunk.ALIGN_CENTER);
			plantilla.add(p);
			//agrega un espacio
			p = new Paragraph(" ");
			plantilla.add(p);
			
			//2. llamar proceso --> listar usuario
			ArrayList<Profesor> listarUser = gUser.listarProfesor();
			//validar el resultado del proceso
			if(listarUser.size() == 0) {
				p = new Paragraph("lista vacia",FontFactory.getFont("Tahoma",14,Font.BOLDITALIC,BaseColor.BLUE));
				plantilla.add(p);
			}else {
				//crear tabla
				PdfPTable tabla = new PdfPTable(3);
				//encabezado de la tabla --> agregar las columnas
				tabla.addCell("LOGO");
				tabla.addCell("ID");
				tabla.addCell("NOMBRE DEL PROFESOR");

				
				//recorrido
				for(Profesor pro : listarUser) {
					Image img;
					if(new File("src/img/p"+pro.getIdProf()+".png").exists()){
						img = Image.getInstance("src/img/p"+pro.getIdProf()+".png");
					}else {
						img = Image.getInstance("src/img/profesor.png");
					}
					
					
					tabla.addCell(img);
					tabla.addCell(pro.getIdProf()+ " ");
					tabla.addCell(pro.getNomProf());
					

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
		ArrayList<Profesor> listarUser = gUser.listarProfesor();
		//validar el resultado del proceso
		if(listarUser.size() == 0) {
			mensajeError("Lista vacia");
		}else {
			for(Profesor prof : listarUser) {
				Object fila[] = {prof.getIdProf(),
								prof.getNomProf(),
				};
				model.addRow(fila);
			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "ERROR", 0);
		
	}
}



