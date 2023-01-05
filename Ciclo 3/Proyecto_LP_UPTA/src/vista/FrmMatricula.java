package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.ietf.jgss.Oid;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.toedter.calendar.JDateChooser;

import entidad.CabeceraBoleta;
import entidad.Curso;
import entidad.DetalleBoleta;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionCursoDAO;
import mantenimiento.GestionVentaDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class FrmMatricula extends JInternalFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	
	private JButton btnBuscar;
	private JLabel lblNewLabel_1;
	private JTextField txtNumBoleta;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JButton btnBuscarCurso;
	private JLabel lblNewLabel_3;
	private JButton btnHorario;
	private JLabel lblNewLabel_4;

	private JLabel lblNewLabel_5;

	private JLabel lblNewLabel_6;

	private JLabel lblNewLabel_7;
	
	private JButton btnAgregar;
	private JTable tblCursos;
	private JLabel lblNewLabel_10;
	
	
	
	private JLabel lblNewLabel_8;
	public static JTextField txtCodigo;
	private JTextField txtFechaActual;
	private JLabel lblNewLabel_9;
	
	public static JTextField txtDNIAlumno;
	public static JTextField txtNombreEstudiante;
	public static JTextField txtNombreCurso;
	public static JTextField txtNombreProfesor;
	public static JTextField txtHorario;
	public static JTextField txtDia;
	
	public static JTextField txtIdCurso;
	public static JTextField txtCreditos;
	public static JTextField txtVacantes;
	public int Creditos;
	public int vacantes;
	public double precioTotal;
	
	
	DefaultTableModel model = new DefaultTableModel();
	GestionAlumnoDAO gAlumnoDAO = new GestionAlumnoDAO();
	GestionCursoDAO gCursoDAO = new GestionCursoDAO();
	GestionVentaDAO gVentaDAO = new GestionVentaDAO();
	ArrayList<DetalleBoleta> compra = new ArrayList<>();
	private JLabel lblNewLabel_11;
	private JPanel panel_3;
	private JButton btnNuevo;
	private JButton btnFinalizarCompra;
	private JTextField txtPrecioTotal;
	private JLabel lblNewLabel_12;
	
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	public String idConfir;
	private JButton btnEliminar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMatricula frame = new FrmMatricula();
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
	public FrmMatricula() {
		setClosable(true);
		setResizable(false);
		setBounds(100, 100, 841, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(192, 192, 192), 3), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("N\u00B0 Boleta:");
		lblNewLabel_1.setBounds(10, 22, 69, 14);
		panel_1.add(lblNewLabel_1);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setBounds(89, 19, 174, 20);
		panel_1.add(txtNumBoleta);
		txtNumBoleta.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(10, 65, 69, 14);
		panel_1.add(lblNewLabel_2);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setEditable(false);
		txtFechaActual.setBounds(89, 62, 86, 20);
		panel_1.add(txtFechaActual);
		txtFechaActual.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder(new LineBorder(new Color(192, 192, 192), 3), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		
		model.addColumn("ID Curso");
		model.addColumn("Nombre Curso");
		model.addColumn("Nombre Profesor");
		model.addColumn("Dia");
		model.addColumn("Horario");
		model.addColumn("Vacantes");
		model.addColumn("Creditos");
		model.addColumn("Precio");
		
		
		
		panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new LineBorder(new Color(192, 192, 192), 3), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.addActionListener(this);
		
		txtNumBoleta.setText(obtenerNumBoleta());
		txtFechaActual.setText(obtenerFechaActual());
		
		panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(192, 192, 192), 3), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		
		lblNewLabel = new JLabel("Estudiante:");
		
		txtNombreEstudiante = new JTextField();
		txtNombreEstudiante.setEditable(false);
		txtNombreEstudiante.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(FrmMatricula.class.getResource("/img/lupita_16px.png")));
		btnBuscar.addActionListener(this);
		
		lblNewLabel_8 = new JLabel("C\u00F3digo: ");
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		
		lblNewLabel_9 = new JLabel("DNI:");
		
		txtDNIAlumno = new JTextField();
		txtDNIAlumno.setEditable(false);
		txtDNIAlumno.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(txtNombreEstudiante, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
							.addGap(23)
							.addComponent(btnBuscar))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCodigo, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDNIAlumno)
							.addGap(21)))
					.addGap(12))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(txtNombreEstudiante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDNIAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
							.addGap(33)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(154)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addGap(246))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(22)
					.addComponent(btnNuevo, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(79)
					.addComponent(btnFinalizarCompra, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(28))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinalizarCompra, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		panel_3.setLayout(gl_panel_3);
		
		panel_4 = new JPanel();
		
		btnBuscarCurso = new JButton("");
		btnBuscarCurso.setIcon(new ImageIcon(FrmMatricula.class.getResource("/img/lupita_16px.png")));
		
		lblNewLabel_4 = new JLabel("Curso:");
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setEditable(false);
		txtNombreCurso.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Profesor:");
		
		txtNombreProfesor = new JTextField();
		txtNombreProfesor.setEditable(false);
		txtNombreProfesor.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Dia:");
		
		txtDia = new JTextField();
		txtDia.setEditable(false);
		txtDia.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Horario:");
		
		txtHorario = new JTextField();
		txtHorario.setEditable(false);
		txtHorario.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		
		lblNewLabel_10 = new JLabel("Id Curso:");
		
		txtIdCurso = new JTextField();
		txtIdCurso.setEditable(false);
		txtIdCurso.setColumns(10);
		
		txtCreditos = new JTextField();
		txtCreditos.setEditable(false);
		txtCreditos.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Creditos: ");
		
		lblNewLabel_14 = new JLabel("Vacantes");
		
		txtVacantes = new JTextField();
		txtVacantes.setEditable(false);
		txtVacantes.setColumns(10);
		
		panel_5 = new JPanel();
		
		scrollPane = new JScrollPane();
		
		tblCursos = new JTable();
		tblCursos.addMouseListener(this);
		scrollPane.setViewportView(tblCursos);
		tblCursos.setModel(model);
		
		panel_6 = new JPanel();
		
		lblNewLabel_3 = new JLabel("Visualizar Horario");
		
		btnHorario = new JButton("Horario");
		
		lblNewLabel_12 = new JLabel("Total: ");
		
		txtPrecioTotal = new JTextField();
		txtPrecioTotal.setColumns(10);
		
		lblNewLabel_11 = new JLabel("CADA CREDITO VALE 15 SOLES");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnHorario, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(92)
					.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(txtPrecioTotal)
					.addGap(31))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_3))
						.addComponent(btnHorario)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPrecioTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_11)))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel_12)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
					.addGap(0))
		);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(txtNombreCurso, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
							.addGap(41)
							.addComponent(btnBuscarCurso, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(txtDia, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addGap(15)
							.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtCreditos, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(txtIdCurso, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
							.addGap(127)
							.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(txtHorario, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addGap(16)
							.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtVacantes, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtNombreProfesor, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEliminar)
							.addGap(306)))
					.addGap(56))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_4))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(1)
									.addComponent(txtNombreCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_6))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(1)
									.addComponent(txtDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_13))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(1)
									.addComponent(txtCreditos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnBuscarCurso))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_10))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(1)
							.addComponent(txtIdCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAgregar)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_7))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(1)
							.addComponent(txtHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_14))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(1)
							.addComponent(txtVacantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNombreProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEliminar))))
		);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);
		btnAgregar.addActionListener(this);
		btnBuscarCurso.addActionListener(this);
		contentPane.setLayout(gl_contentPane);
		
	}
	private String obtenerFechaActual() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnFinalizarCompra) {
			actionPerformedBtnFinalizarCompra(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnBuscarCurso) {
			actionPerformedBtnBuscarCurso(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		JDListaAlumnos jBuscar = new JDListaAlumnos();
		jBuscar.setVisible(true);
		JDListaAlumnos.ventana = "null";
		FrmMenuPrincipal.escritorio.add(jBuscar);
		jBuscar.toFront();
		
		
	}
	protected void actionPerformedBtnBuscarCurso(ActionEvent e) {
		JDBuscarCurso jBuscar = new JDBuscarCurso();
		jBuscar.setVisible(true);
		FrmMenuPrincipal.escritorio.add(jBuscar);
		jBuscar.toFront();
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregarProducto();		
	}

	private int confirmaProducto() {
		
		int res = 0;
		if(compra.size() == 0) {
			res = 0;
		}else {
			
			for (DetalleBoleta detalleBoleta : compra) {
				if(detalleBoleta.getIdCurso().equals(getIdCurso())) {
					mensajeError("Producto duplicado");
					return -1 ;
				}
			}
			
		}
		return res;
	}
	private void agregarProducto() {
		
		if(confirmaProducto() == -1) {
			return;
		}
		String idCurso, nombreCu, nombreProf, dia, horario;
		int creditos, vaca;
		double precioCu;
		idCurso = getIdCurso();
		nombreCu = getNombreCu();
		nombreProf = getNombreProf();
		dia = getDia();
		horario = getHorario();
		creditos = getCreditos();
		precioCu = calcularPrecioCurso();
		vaca = getVacantes();
		
		
		Object fila[] = {
				idCurso, nombreCu, nombreProf,dia,horario,vaca, creditos, precioCu
		};
		
		precioTotal = precioTotal + precioCu;
		idConfir = idCurso;
		model.addRow(fila);
		
		txtPrecioTotal.setText("" + precioTotal);
		
		DetalleBoleta d = new DetalleBoleta();
		d.setIdCurso(idCurso);
		d.setPrecioCurso(precioCu);
		
		compra.add(d);
	}
	private String getNombreAlu() {
		return txtNombreEstudiante.getText().trim();
	}
	private int getVacantes() {
		return Integer.parseInt(txtVacantes.getText());
	}

	private int getCreditos() {
		return Integer.parseInt(txtCreditos.getText());
	}

	private double calcularPrecioCurso() {
		return getCreditos() * 15;
	}

	private String getHorario() {
		String horario;
		horario = txtHorario.getText();
		return horario;
	}

	private String getDia() {
		String dia;
		dia = txtDia.getText();
		return dia;
	}

	private String getNombreProf() {
		
		String nombreProf;
		nombreProf = txtNombreProfesor.getText();
		return nombreProf;
	}

	private String getNombreCu() {
		String nombreCu;
		nombreCu = txtNombreCurso.getText();
		return nombreCu;
	}

	private String getIdCurso() {
		String idCurso;
		idCurso = txtIdCurso.getText();
		return idCurso;
		
	}
	
	private String obtenerNumBoleta() {
		GestionVentaDAO gVentaDAO = new GestionVentaDAO();
		return gVentaDAO.numBoleta();
		
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		compra.clear();
		precioTotal = 0.0;
		limpiar();
	}

	private void limpiar() {
		txtCodigo.setText("");
		txtDia.setText("");
		txtDNIAlumno.setText("");
		txtHorario.setText("");
		txtIdCurso.setText("");
		txtNombreCurso.setText("");
		txtNombreEstudiante.setText("");
		txtNombreProfesor.setText("");
		txtNumBoleta.setText(obtenerNumBoleta());
		txtFechaActual.setText(obtenerFechaActual());
		model.setRowCount(0);
		
	}
	
	protected void actionPerformedBtnFinalizarCompra(ActionEvent e) {
		finalizarCompra();
		
	}

	
	private void finalizarCompra() {
		//Declarar las variables
		String numBoleta, fechaBoleta, idAlumno, idEmple;
		double preTo;
		
		numBoleta = obtenerNumBoleta();
		fechaBoleta = obtenerFechaActual();
		idAlumno = getIdAlumno();
		idEmple = "TB0001";
		preTo = precioTotal;
		
		CabeceraBoleta cBol = new CabeceraBoleta();
		cBol.setIdBoleta(numBoleta);
		cBol.setIdAlum(idAlumno);
		cBol.setIdEmple(idEmple);
		cBol.setFechaBoleta(fechaBoleta);
		cBol.setPrecioBoleta(preTo);
		
		
		int ok = gVentaDAO.realizarVenta(cBol, compra);
		if(ok == 0) {
			mensajeError("Error en la venta");
		}else {
			mensajeExitoso("Compra Realizada");
			generarPDF(numBoleta,getNombreAlu(), getIdAlumno(), getDNI(), fechaBoleta);
		}
	}

	private int getDNI() {
		return Integer.parseInt(txtDNIAlumno.getText().trim());
	}

	private void generarPDF(String idBoleta, String nombre, String codigo, int dni, String fecha) {
		String nArchivo = "reportes/Boleta" + "_" + idBoleta +"_Matricula"+"_" +fecha+".pdf";
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nArchivo);
			
			PdfWriter pdfWriter = PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			plantilla.left(100f);
			plantilla.top(150f);
			
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int [] {150, 100});
			PdfPCell cell1 = new PdfPCell();
			
			
			
			cell1.setBorderColor(BaseColor.WHITE);
		
			//////////////////////////////////////////////////////////// 
			///////////DATOS
			PdfPTable datos = new PdfPTable(1);
			datos.setWidthPercentage(100f);
			
			PdfPCell nomEmpresa = new PdfPCell(
					new Paragraph("UPTA", FontFactory.getFont("arial", 48,com.itextpdf.text.Font.BOLD))
					);
			nomEmpresa.setBorderColor(BaseColor.WHITE);
			nomEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			PdfPCell blanco = new PdfPCell();
			blanco.setFixedHeight(50f);
			blanco.setBorderColor(BaseColor.WHITE);
			PdfPCell codi = new PdfPCell(
					new Paragraph("Codigo: " + codigo, FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL))
					);
			codi.setBorderColor(BaseColor.WHITE);
			codi.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell estudia = new PdfPCell(
					new Paragraph("ESTUDIANTE: " + nombre, FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL))
					);
			estudia.setBorderColor(BaseColor.WHITE);
			estudia.setHorizontalAlignment(Element.ALIGN_BOTTOM);
		
			
			PdfPCell Ddni = new PdfPCell(
					new Paragraph("DNI: " + dni + "\n" + "Fecha: " + fecha, FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL))
					);
			Ddni.setBorderColor(BaseColor.WHITE);
			Ddni.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			datos.addCell(nomEmpresa);
			datos.addCell(blanco);
			datos.addCell(codi);
			datos.addCell(estudia);
			datos.addCell(Ddni);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.addElement(datos);
			
			///////////////////////////////////////////////////////////////
			PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
			cell2.setBorderColor(BaseColor.WHITE);
			//cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			//cell2.setVerticalAlignment(Element.ALIGN_RIGHT);
			PdfPTable tablita = new PdfPTable(1);
			tablita.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell2.addElement(tablita);
		
			PdfPCell titulo = new PdfPCell(new Paragraph("BOLETA",FontFactory.getFont(
					"arial", 28, com.itextpdf.text.Font.BOLD)));
			
			//titulo.addElement(p);
			titulo.setFixedHeight(45f);
			titulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
			
			//titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell descrip = new PdfPCell(
					new Paragraph("Electronica", FontFactory.getFont("arial", 15))
					);
			descrip.setFixedHeight(30f);
			descrip.setVerticalAlignment(Element.ALIGN_MIDDLE);
			descrip.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell numBoleta = new PdfPCell(
					new Paragraph(idBoleta, FontFactory.getFont("arial"))
					);
			
			numBoleta.setFixedHeight(25f);
			numBoleta.setVerticalAlignment(Element.ALIGN_MIDDLE);
			numBoleta.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			tablita.addCell(titulo);
			tablita.addCell(descrip);
			tablita.addCell(numBoleta);
			/////////////////////////////////////////////////
			
            table.addCell(cell1);
            table.addCell(cell2);
            plantilla.add(table);
            ///TERMINO EL ENCABEZADO
            Paragraph p = new Paragraph(" ");
            plantilla.add(p);
            p = new Paragraph(" ");
            plantilla.add(p);
            p = new Paragraph(" ");
            plantilla.add(p);
            //CONTENIDO
            
            PdfPTable conte = new PdfPTable(3);
            conte.setWidths(new int[] {60,200,100});
            //encabezado contenido
            PdfPCell cant = new PdfPCell(
            		new Paragraph("CANTIDAD")
            		);
            cant.setFixedHeight(25f);
            cant.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cant.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell des = new PdfPCell(
            		new Paragraph("DESCRIPCION")
            		);
            des.setFixedHeight(25f);
            des.setVerticalAlignment(Element.ALIGN_MIDDLE);
			des.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell precio = new PdfPCell(
            		new Paragraph("PRECIO")
            		);
            precio.setFixedHeight(25f);
            precio.setVerticalAlignment(Element.ALIGN_MIDDLE);
			precio.setHorizontalAlignment(Element.ALIGN_CENTER);
            conte.addCell(cant);
            conte.addCell(des);
            conte.addCell(precio);
            ////////////////////////////////
           for (DetalleBoleta deta :  compra) {
        	   Curso curso = gCursoDAO.obtenerCursoXID(deta.getIdCurso());
        	   PdfPCell cantDes = new PdfPCell(
               		new Paragraph("1")
               		);
               //cantDes.setFixedHeight(150f);
               cantDes.setPaddingTop(5f);
               cantDes.setVerticalAlignment(Element.ALIGN_CENTER);
   			cantDes.setHorizontalAlignment(Element.ALIGN_CENTER);
               
               PdfPCell desDes = new PdfPCell(
               		);
               p = new Paragraph(curso.getNombre());
               desDes.addElement(p);
               
               desDes.setHorizontalAlignment(Element.ALIGN_CENTER);
               desDes.setVerticalAlignment(Element.ALIGN_CENTER);
               desDes.setPaddingTop(5f);
               desDes.setPaddingBottom(10f);
               //desDes.setFixedHeight(150f);
               
               
               PdfPCell precDes = new PdfPCell(
               		new Paragraph(String.valueOf(deta.getPrecioCurso()))
               		);
               precDes.setVerticalAlignment(Element.ALIGN_CENTER);
               precDes.setPaddingTop(5f);
               //precDes.setFixedHeight(500f);
        
   				precDes.setHorizontalAlignment(Element.ALIGN_CENTER);
               conte.addCell(cantDes);
               conte.addCell(desDes);
               conte.addCell(precDes);
           }
            
            //////////////////////////////precio
            
            PdfPCell nada1 = new PdfPCell();
            nada1.setFixedHeight(30f);
            PdfPCell nada2 = new PdfPCell(new Paragraph("TOTAL: "));
            nada2.setFixedHeight(30f);
            nada2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            PdfPCell mostrarprecio= new PdfPCell(new Paragraph(String.valueOf(precioTotal)));
            mostrarprecio.setHorizontalAlignment(Element.ALIGN_CENTER);

            mostrarprecio.setFixedHeight(30f);
        
            
            conte.addCell(nada1);
            conte.addCell(nada2);
            conte.addCell(mostrarprecio);
            
            
            plantilla.add(conte);
			plantilla.close();
			Desktop.getDesktop().open(new File(nArchivo));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage() );
		}
		
	}

	private void mensajeExitoso(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string, "Exito", JOptionPane.INFORMATION_MESSAGE);
	}

	private void mensajeError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string,"Error !!!", JOptionPane.ERROR_MESSAGE);
	}

	private String getIdAlumno() {
		return txtCodigo.getText();
	}
	

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		 int fila = tblCursos.getSelectedRow();
		 String idC = tblCursos.getValueAt(fila, 0).toString();
		 for(int i = 0; i<= compra.size() -1;i++ ) {
			 if(compra.get(i).getIdCurso().equals(idC)) {
				 compra.remove(i);
				 model.removeRow(fila);
			 }
		 }
		 limpiar();
	}
	

	private void mostrarData() {
		int posFila = tblCursos.getSelectedRow();
		// declarar las variables
		String cod, nomb, nomp, dia, clave, vacan,credit,prec;
		// paso 1: Obtener los valores de la tabla
		// -- getValueAt(fila,columna)
		cod = tblCursos.getValueAt(posFila, 0).toString();
		nomb = tblCursos.getValueAt(posFila, 1).toString();
		nomp = tblCursos.getValueAt(posFila, 2).toString();
		dia = tblCursos.getValueAt(posFila, 3).toString();
		clave = tblCursos.getValueAt(posFila, 4).toString();
		vacan = tblCursos.getValueAt(posFila, 5).toString();
		credit = tblCursos.getValueAt(posFila, 6).toString();
		prec = tblCursos.getValueAt(posFila, 7).toString();

		// paso 2: mostrar los valores obtenidos en las cajas de texto
		txtIdCurso.setText(cod);
		txtNombreCurso.setText(nomb);
		txtNombreProfesor.setText(nomp);
		txtDia.setText(dia);
		txtHorario.setText(clave);
		txtVacantes.setText(vacan);
		txtCreditos.setText(credit);
		

	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCursos) {
			mouseClickedTblCursos(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblCursos(MouseEvent e) {
		mostrarData();
	}
}
