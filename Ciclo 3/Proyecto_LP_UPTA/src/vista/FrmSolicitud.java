package vista;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.jsoup.select.Evaluator.Id;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.Empleado;
import entidad.Sede;
import entidad.Solicitud;

import entidad.SolicitudDetalle;
import entidad.TipoSolicitud;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionEmpleadoDAO;
import mantenimiento.GestionSedeDAO;

import mantenimiento.GestionSolicitudDAO;
import mantenimiento.GestionSolicitudDetalleDAO;
import mantenimiento.GestionTipoSolicitudDAO;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.channels.NonReadableChannelException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Flow.Publisher;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.MouseEvent;

public class FrmSolicitud extends JInternalFrame implements ActionListener, MouseListener {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	public static JComboBox cmbTipoSolicitud;
	private JLabel lblNewLabel_2;
	public static JTextField txtIDSolicitud;
	public static JTextField txtEmpleado;
	private JLabel lblEmpleado;
	public static JTextField txtIDAlumno;
	private JLabel lblDatouno;
	private JScrollPane scrollPane;
	private JTable tblSolicitudes;
	private JLabel lblMotivo;
	private JScrollPane scrollPane_1;
	private JTextArea txtMotivo;
	public static String nombreEm;
	public static String idEmple;
	private JLabel lblDatoDos;
	public static JTextField txtIDEmpleado;
	private JLabel lblNewLabel_3;
	private JButton btnRegistrar;
	private JButton btnBuscarAlumno;
	public static String id;
	GestionAlumnoDAO gAlu = new GestionAlumnoDAO();
	public static GestionEmpleadoDAO gEmple = new GestionEmpleadoDAO();
	GestionSedeDAO gSede = new GestionSedeDAO();
	public static GestionTipoSolicitudDAO gTipoSol = new GestionTipoSolicitudDAO();
	public static GestionSolicitudDetalleDAO gSCS = new GestionSolicitudDetalleDAO();
	public static GestionSolicitudDAO gSol = new GestionSolicitudDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox cmbSede;
	private JButton btnNuevo;
	private JLabel lblNewLabel_4;
	private JButton btnBuscarSolicitud;
	private JLabel lblDatouno_1;
	private JTextField txtFecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSolicitud frame = new FrmSolicitud();
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
	public FrmSolicitud() {
		setFrameIcon(new ImageIcon(FrmSolicitud.class.getResource("/img/Logo.png")));
		setBounds(100, 100, 661, 602);
		
		lblNewLabel = new JLabel("GESTIONAR SOLICITUD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		panel = new JPanel();
		
		scrollPane = new JScrollPane();
		
		lblNewLabel_4 = new JLabel("Ultimos Solicitudes: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addContainerGap(490, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(194)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(174))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(16)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addGap(5))
		);
		
		tblSolicitudes = new JTable();
		tblSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblSolicitudes.addMouseListener(this);
		scrollPane.setViewportView(tblSolicitudes);
		
		lblNewLabel_1 = new JLabel("Tipo de Solicitud: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cmbTipoSolicitud = new JComboBox();
		cmbTipoSolicitud.addActionListener(this);
		cmbTipoSolicitud.setModel(new DefaultComboBoxModel(new String[] {"..."}));
		cmbTipoSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_2 = new JLabel("IDSolicitud:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtIDSolicitud = new JTextField();
		txtIDSolicitud.setEditable(false);
		txtIDSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDSolicitud.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setEditable(false);
		txtEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmpleado.setColumns(10);
		
		lblEmpleado = new JLabel("Nombre Empleado:");
		lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtIDAlumno = new JTextField();
		txtIDAlumno.setEditable(false);
		txtIDAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDAlumno.setColumns(10);
		
		lblDatouno = new JLabel("IDAlumno:");
		lblDatouno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblMotivo = new JLabel("Motivo:");
		lblMotivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane_1 = new JScrollPane();
		
		lblDatoDos = new JLabel("IDSede:");
		lblDatoDos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtIDEmpleado = new JTextField();
		txtIDEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIDEmpleado.setColumns(10);
		
		lblNewLabel_3 = new JLabel("IDEmpleado:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		
		btnBuscarAlumno = new JButton("");
		btnBuscarAlumno.setIcon(new ImageIcon(FrmSolicitud.class.getResource("/img/lupita_16px.png")));
		btnBuscarAlumno.addActionListener(this);
		
		cmbSede = new JComboBox();
		cmbSede.setModel(new DefaultComboBoxModel(new String[] {"..."}));
		cmbSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		
		btnBuscarSolicitud = new JButton("");
		btnBuscarSolicitud.addActionListener(this);
		btnBuscarSolicitud.setIcon(new ImageIcon(FrmSolicitud.class.getResource("/img/lupita_16px.png")));
		
		lblDatouno_1 = new JLabel("Fecha:");
		lblDatouno_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMotivo, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(536, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(scrollPane_1)
							.addGap(33))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatouno, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmpleado, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatoDos, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEmpleado, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(cmbTipoSolicitud, 0, 255, Short.MAX_VALUE)
									.addGap(135)
									.addComponent(btnNuevo))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtIDSolicitud, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBuscarSolicitud, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtIDEmpleado, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cmbSede, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtIDAlumno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
									.addGap(14)
									.addComponent(btnBuscarAlumno)
									.addGap(16)
									.addComponent(lblDatouno_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(247)
					.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(274))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(cmbTipoSolicitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNuevo))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtIDSolicitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIDEmpleado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarSolicitud))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmpleado, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpleado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(14)
									.addComponent(lblDatouno, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtIDAlumno, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(14)
									.addComponent(lblDatoDos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(lblMotivo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cmbSede, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(btnBuscarAlumno))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblDatouno_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(9)
					.addComponent(btnRegistrar))
		);
		
		txtMotivo = new JTextArea();
		txtMotivo.setLineWrap(true);
		txtMotivo.setWrapStyleWord(true);
		txtMotivo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane_1.setViewportView(txtMotivo);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		

		listarCombos();
		txtIDSolicitud.setText(generarNumSolicitud());
		listarSolicitudes();
		txtIDEmpleado.setText(idEmple);
		txtEmpleado.setText(nombreEm);
		txtFecha.setText(obtenerFechaActual());
	}
	private String obtenerFechaActual() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarSolicitud) {
			actionPerformedBtnBuscarSolicitud(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnBuscarAlumno) {
			actionPerformedBtnBuscarAlumno(e);
		}
		if (e.getSource() == cmbTipoSolicitud) {
			actionPerformedCmbTipoSolicitud(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		Solicitud solicitud = registrarSolicitud();
		SolicitudDetalle scs = registrarSolCambioSede();
		String idAlu, nombreSol, nombreAlu, numSol, fec, sede,motivo;
		idAlu = txtIDAlumno.getText().trim();
		numSol = getIDInforme();
		nombreSol = cmbTipoSolicitud.getSelectedItem().toString()	;
		fec = getFecha();
		sede = cmbSede.getSelectedItem().toString();
		motivo = txtMotivo.getText();
		if(solicitud == null || scs == null ) {
			return;
		}else {
			int ok = gSol.registrarSolicitud(solicitud, scs);
			if(ok == 0) {
				mensajeError("Error en la trasacion");
			}else {
				mensajeExito("Transacion completada");
				txtIDSolicitud.setText(generarNumSolicitud());
				listarSolicitudes();
				exportarPDF(numSol, idAlu, "AEA", fec, nombreSol, sede, motivo);
			}
		}
		
	}
	private void exportarPDF(String numSol, String idCod, String nomAlu, String fec, String nombreTipo, String sede, String motivo) {
		String nArchivo = "reportes/Solicitud" + "_"+numSol+"_"+fec+".pdf";
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nArchivo);
			
			PdfWriter pdfWriter = PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int [] {50, 150});
			
			PdfPCell cell1 = new PdfPCell();
			Image img = Image.getInstance("src/img/Logo_200x200-removebg.png");
			
			cell1.setFixedHeight(80f);
			cell1.addElement(img);
			cell1.setBorderColor(BaseColor.WHITE);
			
			PdfPCell cell2 = new PdfPCell();
			cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			//cell2.setPaddingLeft(60f);
			cell2.setPaddingRight(-25f);
			cell2.setBorderColor(BaseColor.WHITE);
			PdfPTable encaTable = new PdfPTable(1);
			PdfPCell fecha = new PdfPCell(
					new Paragraph("UPTA - UNIVERSIDAD PRIVADA TORRES DE AGUILA ")
					);
			fecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
			fecha.setBorderColor(BaseColor.WHITE);
			PdfPCell blacCell = new PdfPCell();
			blacCell.setFixedHeight(30f);
			blacCell.setBorderColor(BaseColor.WHITE);
			PdfPCell Dirrecion = new PdfPCell(
					new Paragraph("San Isisdro, 1698 - Perú")
					);
			Dirrecion.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Dirrecion.setBorderColor(BaseColor.WHITE);
			encaTable.addCell(fecha);
			encaTable.addCell(blacCell);
			encaTable.addCell(Dirrecion);
			
			cell2.addElement(encaTable);
			
			table.addCell(cell1);
			table.addCell(cell2);
			plantilla.add(table);
			////////////////////////////////CUERPO
			Paragraph blaco = new Paragraph(" ");
			
			plantilla.add(blaco);
			plantilla.add(blaco);
			plantilla.add(blaco);
			plantilla.add(blaco);
			Paragraph p = new Paragraph(
					"Estimado (a) Sr. (a): "
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			
			p = new Paragraph("NOMBRE");
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			p = new Paragraph("Gerente Academico");
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			plantilla.add(blaco);
			p = new Paragraph(
					"Me dirijo a usted respetuosamente con la finalidad de solicitar su autorización "
					+ "de " + nombreTipo 
					+ " evento a realizarse el " + fec + " "
							+ "en la sede "+ sede + "," + motivo
					);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			plantilla.add(blaco);
			
			p = new Paragraph("Por todo lo expuesto, le reitero mi solicitud de autorización, "
					+ "agradeciendo de antemano toda la cooperación que pueda prestar al respecto.");
			//p.setAlignment(15);
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			
			plantilla.add(blaco);
			plantilla.add(blaco);
			
			p = new Paragraph("Sin más a qué referirme y "
					+ "en espera de una pronta y favorable respuesta a esta solicitud, me despido.");
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			plantilla.add(p);
			plantilla.add(blaco);
			plantilla.add(blaco);
			p = new Paragraph("Atentamente, " + nomAlu);
			
			p.setIndentationRight(30f);
			p.setIndentationLeft(30f);
			
			plantilla.add(p);
			
			
			
			plantilla.close();
			Desktop.getDesktop().open(new File(nArchivo));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage() );
		}
		
	}

	private void mensajeExito(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string, "Infomation", JOptionPane.INFORMATION_MESSAGE);
	}

	private SolicitudDetalle registrarSolCambioSede() {
		String idInforme, datoUno, motivo, datoDos;
		
		datoUno = getDatoUno(); // Este caso es id Alumno
		datoDos = getDatoDos(); // Este caso es el IDSEDE
		
		motivo = getMotivo();
		
		idInforme = getIDInforme();
		SolicitudDetalle scs = new SolicitudDetalle();
		if(datoDos == null || datoUno == null || motivo == null ||  idInforme == null) {
			mensajeError("Error en el ingreso de datos");
			return null;
		}
		else {
			scs.setIdAlumno(datoUno);
			scs.setIdInforme(idInforme);
			scs.setIdSede(datoDos);
			scs.setMotivo(motivo);
			
		}
		return scs;
	}

	private String getFecha() {
		return txtFecha.getText().trim();
	}
	private Solicitud registrarSolicitud() {
		String idInforme,idEmpleado, idTipoSol,fecha;
		
		
		idTipoSol = getIDTipoInforme();
		
		idEmpleado = getIDEmpleado();
		idInforme = getIDInforme();
		fecha = getFecha();
		Solicitud sol = new Solicitud();
		
		if(idTipoSol == null || idEmpleado == null || idInforme == null) {
			mensajeError("Error en el ingreso de datos");
			return null;
		}
		else {
			sol.setIdEmple(idEmpleado);
			sol.setIdSolicitud(idInforme);
			sol.setTipoSolicitud(idTipoSol);
			sol.setFecha(fecha);
			
		}
		return sol;
		
	}
	public static void obtenerSol() {
		Solicitud sol = gSol.obtenerCabeSol(id);
		SolicitudDetalle solD = gSCS.obtenerDetalle(id);
		String idEmple = sol.getIdEmple();
		Empleado em = gEmple.buscarEmpleados(idEmple);
		txtIDEmpleado.setText(sol.getIdEmple());
		txtEmpleado.setText(em.getNombre() + " " + em.getApellido());
		TipoSolicitud tip = gTipoSol.obtenerNombreSol(sol.getTipoSolicitud());
		//System.out.println(sol.getIdSolicitud());
		System.out.println(tip.getNombreTipoSol());
		for(int i = 1; i<= cmbTipoSolicitud.getItemCount(); i++) {
			if(cmbTipoSolicitud.getItemAt(i).toString().equals(tip.getNombreTipoSol())) {
				cmbTipoSolicitud.setSelectedIndex(i);
				break;
			}
		}
	}
	
	private String getIDInforme() {
		String texto = null;
		if(txtIDSolicitud.getText().trim().length() == 0) {
			mensajeError("Error al obtener el IDInforme");
		}else {
			texto = txtIDSolicitud.getText().trim();
		}
		return texto;
	}
	private String getIDEmpleado() {
		String texto = null;
		if(txtIDEmpleado.getText().trim().length() == 0) {
			mensajeError("Error al obtener el IDEmpleado");
		}else {
			texto = txtIDEmpleado.getText().trim();
		}
		return texto;
	}
	private String getIDTipoInforme() {
		String texto = null;
		if(cmbTipoSolicitud.getSelectedIndex() == 0) {
			mensajeError("Escoga un tipo de Informe");
		}else {
			texto = cmbTipoSolicitud.getSelectedItem().toString();
			TipoSolicitud tsol = gTipoSol.obtenerTipoSol(texto);
			texto = tsol.getIdTipoSol();
			System.out.print(texto);
		}
		return texto;
	}
	
	private String getDatoUno() {
		String texto = null;
		if(txtIDAlumno.getText().trim().length() == 0) {
			mensajeError("Ingrese los datos faltantes");
		}else {
			texto = txtIDAlumno.getText().trim();
		}
		return texto;
	}
	private String getDatoDos() {
		/*
		String texto = null;
		if(txtDatoDos.getText().trim().length() == 0) {
			mensajeError("Ingrese los datos faltantes");
		}else {
			texto = txtDatoDos.getText().trim();
		}
		return texto;
		*/
		Sede sede = null;
		String texto = null;
		if(cmbSede.getSelectedIndex() == 0) {
			mensajeError("Escoga una sede");
		}else {
			texto = cmbSede.getSelectedItem().toString();
			sede = gSede.buscarSede(texto);
			texto = sede.getIdSede();
		}
		return texto;
	}
	private String getMotivo() {
		String texto = null;
		if(txtMotivo.getText().trim().length() == 0) {
			mensajeError("Ingrese el motivo");
		}else {
			texto = txtMotivo.getText().trim();
		}
		return texto;
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void listarCombos() {
		mostrarTipoSol();
		mostrarSede();
	}

	private void mostrarSede() {
		// TODO Auto-generated method stub
		ArrayList<Sede> mostrarSede = gSede.listarSede();
		for (Sede sede : mostrarSede) {
			cmbSede.addItem(sede.getNombre());
		}
	}

	private void mostrarTipoSol() {
		ArrayList<TipoSolicitud> mostrarTipoSol = gTipoSol.listarSolicitud();
		for (TipoSolicitud tipoSolicitud : mostrarTipoSol) {
			cmbTipoSolicitud.addItem(tipoSolicitud.getNombreTipoSol());
		}
	}
	
	private String generarNumSolicitud() {
		String numero = gSol.numSolicitud();
		return numero;
	}
	protected void actionPerformedCmbTipoSolicitud(ActionEvent e) {
		if(cmbTipoSolicitud.getSelectedIndex() == 0) {
			mensajeExito("Escoga un tipo de solicitud");
		}
	}

	

	private void activarParaCambioSede() {
	//	txtDatoDos.setEditable(true);
		
	}
	protected void actionPerformedBtnBuscarAlumno(ActionEvent e) {
		JDListaAlumnos buscarAlumno = new JDListaAlumnos();
		buscarAlumno.setVisible(true);
		FrmMenuPrincipal.escritorio.add(buscarAlumno);
		JDListaAlumnos.ventana = "Informe";
		buscarAlumno.toFront();
	}
	private void listarSolicitudes() {
		model.setColumnCount(0);
		model.setRowCount(0);
		
		model.addColumn("IDSolicitud");
		model.addColumn("IDTipo");
		model.addColumn("IDTrabajador");
		tblSolicitudes.setModel(model);
		model.setRowCount(0);
		ArrayList<Solicitud> listarSolicitud = gSol.listar10Solicitudes();
		for (Solicitud solicitud : listarSolicitud) {
			JButton button = new JButton(); 
			Object[] fila = {
					solicitud.getIdSolicitud(),
					solicitud.getTipoSolicitud(),
					solicitud.getIdEmple(),
					
			};
			
			model.addRow(fila);
		}
		
		
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		
		cmbTipoSolicitud.setSelectedIndex(0);
		cmbSede.setSelectedIndex(0);
		txtIDSolicitud.setText(generarNumSolicitud());
		txtMotivo.setText("");
		txtIDAlumno.setText("");
		txtFecha.setText(obtenerFechaActual());
	}
	private void mostrarData() {
		int fila = tblSolicitudes.getSelectedRow();
		String idAlumno, idSolicitud, idEmpleado,idTipo,nombreSede,nombreEmple,motivo;
		idSolicitud = tblSolicitudes.getValueAt(fila, 0).toString();
		idTipo = tblSolicitudes.getValueAt(fila, 1).toString();
		idEmpleado = tblSolicitudes.getValueAt(fila, 2).toString();
		SolicitudDetalle detalle = gSCS.obtenerDetalle(idSolicitud);
		
		txtIDEmpleado.setText(idEmpleado);
		txtIDAlumno.setText(detalle.getIdAlumno());
		txtMotivo.setText(detalle.getMotivo());
		txtIDSolicitud.setText(idSolicitud);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblSolicitudes) {
			mouseClickedTblSolicitudes(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		mostrarData();
	}
	protected void mouseClickedTblSolicitudes(MouseEvent e) {
		mostrarData();
	}
	protected void actionPerformedBtnBuscarSolicitud(ActionEvent e) {
		JDBuscarSolicitud soli = new JDBuscarSolicitud();
		JDBuscarSolicitud.ventana = "Solicitud";
		soli.setVisible(true);
		FrmMenuPrincipal.escritorio.add(soli);
		soli.toFront();
	}
}
