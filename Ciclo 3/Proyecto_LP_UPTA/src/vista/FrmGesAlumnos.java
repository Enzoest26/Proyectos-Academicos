package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jsoup.select.Evaluator.Id;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

import entidad.Alumno;
import entidad.AlumnoAca;
import entidad.AlumnoEstado;
import entidad.Carrera;
import entidad.Distrito;
import entidad.Sede;
import mantenimiento.GestionAlumnoAcaDAO;
import mantenimiento.GestionAlumnoDAO;
import mantenimiento.GestionCarreraDAO;
import mantenimiento.GestionDistritoDAO;
import mantenimiento.GestionSedeDAO;
import utils.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class FrmGesAlumnos extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public static JTextField txtIdAlumno;
	private JLabel lblNewLabel_2;
	public static JTextField txtNombreAl;
	private JLabel lblNewLabel_3;
	public static JTextField txtApellidoAl;
	private JButton btnAgregar;
	private JButton btnModificar;

	//Default model
	DefaultTableModel model = new DefaultTableModel();
	public static GestionAlumnoDAO gAlu = new GestionAlumnoDAO();
	public static GestionDistritoDAO gDis = new GestionDistritoDAO();
	public static GestionCarreraDAO gCar = new GestionCarreraDAO();
	public static GestionSedeDAO gSede = new GestionSedeDAO();
	public static GestionAlumnoAcaDAO gAluAca = new GestionAlumnoAcaDAO();
	
	public static String nombreAlu;
	public static String idAlu;
	
	
	
	private JLabel lblNewLabel_6;
	private JButton btnEliminar;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnLimpiar;
	private JLabel lblNewLabel_4;
	public static JTextField txtDni;
	public static JTextField txtNacionalidad;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	public static JDateChooser dcFechaNa;
	private JLabel lblNewLabel_8;
	public static JTextField txtEdad;
	private JLabel lblNewLabel_9;
	public static JComboBox cmbSexo;
	private JLabel lblNewLabel_10;
	public static JTextField txtDireccion;
	private JLabel lblNewLabel_12;
	public static JTextField txtCorreoElec;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	public static JTextField txtTeleMovil;
	private JLabel lblNewLabel_15;
	public static JTextField txtTeleFijo;
	private JLabel lblNewLabel_16;
	private JPanel panel_1;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JPanel panel_4;
	private JLabel lblNewLabel_20;
	public static JComboBox cmbDistrito;
	public static JComboBox cmbSede;
	public static JComboBox cmbCiclo;
	public static JComboBox cmbCarrera;
	
	private int index;
	private JButton btnBuscarAlumno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGesAlumnos frame = new FrmGesAlumnos();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmGesAlumnos() {
		setFrameIcon(new ImageIcon(FrmGesAlumnos.class.getResource("/img/Logo.png")));
		setFocusable(false);
		setIconifiable(true);
	
		
		setClosable(true);
		
		setTitle("Mantenimiento Alumno");
		setBounds(100, 100, 1034, 690);
		
		
		lblNewLabel = new JLabel("ALUMNOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		model.addColumn("ID. Alumno");
		model.addColumn("Nombres");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Fecha Nacimiento");
		model.addColumn("Estado");
		
		panel_2 = new JPanel();
		
		panel_3 = new JPanel();
		panel_3.setToolTipText("Operaciones");
		
		btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(FrmGesAlumnos.class.getResource("/img/student.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//btnAgregar.addActionListener(this);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(FrmGesAlumnos.class.getResource("/img/modify.png")));
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//btnModificar.addActionListener(this);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(FrmGesAlumnos.class.getResource("/img/remove.png")));
		btnEliminar.addActionListener(this);
		//btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(FrmGesAlumnos.class.getResource("/img/reset.png")));
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(30)
					.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(btnEliminar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblNewLabel_1 = new JLabel("ID. Alumno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtIdAlumno = new JTextField();
		txtIdAlumno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdAlumno.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtNombreAl = new JTextField();
		txtNombreAl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreAl.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Apellido:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtApellidoAl = new JTextField();
		txtApellidoAl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtApellidoAl.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Ejemplo: AL9999");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		lblNewLabel_16 = new JLabel("Datos Personales");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 971, Short.MAX_VALUE))
					.addGap(13))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 351, Short.MAX_VALUE)
					.addContainerGap())
		);
		//btnLimpiar.addActionListener(this);
		
		lblNewLabel_4 = new JLabel("DNI: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDni.setColumns(10);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNacionalidad.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Nacionalidad:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_7 = new JLabel("Fecha Nacimiento:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		dcFechaNa = new JDateChooser();
		
		lblNewLabel_8 = new JLabel("Edad: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEdad.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Sexo:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"...", "Masculino", "Femenino"}));
		
		lblNewLabel_10 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDireccion.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Distrito:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtCorreoElec = new JTextField();
		txtCorreoElec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCorreoElec.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Correo electronico:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_14 = new JLabel("Telefono movil:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtTeleMovil = new JTextField();
		txtTeleMovil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTeleMovil.setColumns(10);
		
		lblNewLabel_15 = new JLabel("Telefono Fijo:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtTeleFijo = new JTextField();
		txtTeleFijo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTeleFijo.setColumns(10);
		
		cmbDistrito = new JComboBox();
		cmbDistrito.setModel(new DefaultComboBoxModel(new String[] {"...."}));
		
		btnBuscarAlumno = new JButton("");
		btnBuscarAlumno.addActionListener(this);
		btnBuscarAlumno.setIcon(new ImageIcon(FrmGesAlumnos.class.getResource("/img/lupita_16px.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtApellidoAl, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombreAl, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
											.addComponent(dcFechaNa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(txtIdAlumno, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(59)
													.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
													.addGap(50)
													.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(14)
													.addComponent(btnBuscarAlumno, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addGap(90)
													.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(60)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addGap(42)
											.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
											.addGap(52)
											.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(cmbSexo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
								.addComponent(cmbDistrito, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtTeleMovil, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addGap(97)
									.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(txtTeleFijo, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtCorreoElec, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))))
					.addGap(956))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(txtIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(btnBuscarAlumno, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(txtNombreAl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtApellidoAl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dcFechaNa, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(11)
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(9)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEdad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbDistrito, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCorreoElec, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbSexo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTeleMovil, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTeleFijo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panel_2.setLayout(gl_panel_2);
		
		panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
							.addGap(291)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(29))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		
		panel_4 = new JPanel();
		
		lblNewLabel_17 = new JLabel("Ciclo:");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_18 = new JLabel("Sede:");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_19 = new JLabel("Carrera:");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbSede = new JComboBox();
		cmbSede.setModel(new DefaultComboBoxModel(new String[] {"....."}));
		
		cmbCiclo = new JComboBox();
		cmbCiclo.setModel(new DefaultComboBoxModel(new String[] {"...", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		
		cmbCarrera = new JComboBox();
		cmbCarrera.setModel(new DefaultComboBoxModel(new String[] {"...."}));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_17, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(cmbCiclo, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(lblNewLabel_18, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cmbSede, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_19, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(cmbCarrera, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_17))
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
									.addComponent(cmbSede, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_18))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(10)
							.addComponent(cmbCiclo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_19)
							.addGap(14))
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(cmbCarrera, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(10))))
		);
		panel_4.setLayout(gl_panel_4);
		
		lblNewLabel_20 = new JLabel("Datos Academicos");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(40)
							.addComponent(lblNewLabel_20, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)))
					.addGap(29))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_20, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);
		
		mostrarComboxBox();
		txtIdAlumno.setText(gAlu.numAlumno());
		
	}
	
	
	private void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarAlumno) {
			actionPerformedBtnBuscarAlumno(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregarAlumno();
	}
	

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarAlumno();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarAlumno();
	}
	private void eliminarAlumno() {
		int ok = eliminarDatosPersonales();
		if(ok == -1) {
			mensajeError("Error al eliminar al alumno");
			return;
		}else {
			mensajeExito("Eliminacion realizada");
		}
		
	}
	
	private int eliminarDatosPersonales() {
		String idAlum;
		idAlum = getIdAlumno();
		if(idAlum == null) {
			return -1;
		}else {
			int ok = gAlu.eliminar(idAlum);
			return ok;
		}
	}

	

	private void agregarAlumno() {
		int ok = registrarDatosPersonales();
		int ok2 = registrarDatosAcademicos();
		
		if(ok == -1 || ok2 == -1) {
			mensajeError("Error al registrar los datos");
			return;
		}else {
			mensajeExito("Registro existoso");
		}
		
	}
	private void modificarAlumno() {
		int ok = modificarDatosAcademicos();
		int ok2 = modificarDatosPersonales();
		
		if(ok == -1 || ok2 == -1) {
			mensajeError("Error al modificar los datos");
			return;
		}else {
			mensajeExito("Modificación existosa");
		}
	}
	private int modificarDatosPersonales() {
		String idAlumno, apellido, nombre, dni, nacionalidad,fecha, sexo, direccion, correo,distrito, teleFijo, teleMovi;
		int edad;
		int retornar;
		idAlumno = getIdAlumno();
		apellido = getApellido();
		nombre = getNombre();
		dni = getDNI();
		nacionalidad = getNacionalidad();
		fecha = getFechaNa();
		sexo = getSexo();
		direccion = getDireccion();
		correo =getCorreo();
		distrito = getCiudad();
		teleFijo = getTeleFijo();
		teleMovi = getTeleMovil();
		edad = getEdad();
		if(edad == 0 || idAlumno == null || nombre == null ||apellido == null || dni == null || sexo == null ||direccion == null|| nacionalidad == null || correo == null || distrito == null || teleFijo == null || teleMovi == null) {
			retornar = -1;
			return retornar;
		}else {
			Alumno al = new Alumno();
			ArrayList<Distrito> obtenerIDistritos = gDis.buscarID(distrito);
			al.setIdAlumno(idAlumno);
			al.setNombre(nombre);
			al.setApellido(apellido);
			al.setDni(dni);
			al.setDomici(direccion);
			al.setFechNa(fecha);
			al.setSexo(sexo);
			al.setTeleFi(teleFijo);
			al.setTeleMo(teleMovi);
			al.setEdad(edad);
			al.setIdDistrito(obtenerIDistritos.get(0).getIdDistrito());
			al.setCorreo(correo);
			al.setNacio(nacionalidad);
			retornar = gAlu.modificar(al);
			
		}
		return retornar;
	}
	private int modificarDatosAcademicos() {
		String nombreSede, idAlumno, nombreCarrera, ciclo;
		int res;
		idAlumno = getIdAlumno();
		nombreSede = getSede();
		nombreCarrera = getCarrera();
		ciclo = getCiclo();
		if(idAlumno == null || nombreSede == null || nombreCarrera == null || ciclo == null) {
			res = -1;
			return res;
		}else {
			AlumnoAca alc = new AlumnoAca();
			alc.setIdAlumno(idAlumno);
			alc.setIdCarrera(gCar.buscarCarrera(nombreCarrera).getIdCarrera());
			alc.setIdSede(gSede.buscarSede(nombreSede).getIdSede());
			alc.setCiclo(ciclo);
			res = gAluAca.modificar(alc);
		}
		return res;
	}
	private int registrarDatosAcademicos() {
		String nombreSede, idAlumno, nombreCarrera, ciclo;
		int res;
		idAlumno = getIdAlumno();
		nombreSede = getSede();
		nombreCarrera = getCarrera();
		ciclo = getCiclo();
		if(idAlumno == null || nombreSede == null || nombreCarrera == null || ciclo == null) {
			res = -1;
			return res;
		}else {
			AlumnoAca alc = new AlumnoAca();
			alc.setIdAlumno(idAlumno);
			alc.setIdCarrera(gCar.buscarCarrera(nombreCarrera).getIdCarrera());
			alc.setIdSede(gSede.buscarSede(nombreSede).getIdSede());
			alc.setCiclo(ciclo);
			res = gAluAca.registrar(alc);
		}
		return res;
	}

	private int registrarDatosPersonales() {
		String idAlumno, apellido, nombre, dni, nacionalidad,fecha, sexo, direccion, correo,distrito, teleFijo, teleMovi;
		int edad;
		int retornar;
		idAlumno = getIdAlumno();
		apellido = getApellido();
		nombre = getNombre();
		dni = getDNI();
		nacionalidad = getNacionalidad();
		fecha = getFechaNa();
		sexo = getSexo();
		direccion = getDireccion();
		correo =getCorreo();
		distrito = getCiudad();
		teleFijo = getTeleFijo();
		teleMovi = getTeleMovil();
		edad = getEdad();
		if(edad == 0 || idAlumno == null || nombre == null ||apellido == null || dni == null || sexo == null ||direccion == null|| nacionalidad == null || correo == null || distrito == null || teleFijo == null || teleMovi == null) {
			retornar = -1;
			return retornar;
		}else {
			Alumno al = new Alumno();
			ArrayList<Distrito> obtenerIDistritos = gDis.buscarID(distrito);
			al.setIdAlumno(idAlumno);
			al.setNombre(nombre);
			al.setApellido(apellido);
			al.setDni(dni);
			al.setDomici(direccion);
			al.setFechNa(fecha);
			al.setSexo(sexo);
			al.setTeleFi(teleFijo);
			al.setTeleMo(teleMovi);
			al.setEdad(edad);
			al.setIdDistrito(obtenerIDistritos.get(0).getIdDistrito());
			al.setCorreo(correo);
			al.setNacio(nacionalidad);
			
			retornar = gAlu.registrar(al);
			
		}
		return retornar;
	}

	private void mensajeExito(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
	}
	private String getFechaNa() {
		String fechaNac = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			fechaNac = sdf.format(dcFechaNa.getDate());
		} catch (NullPointerException e) {
			mensajeError("Ingrese la fecha correctamente, formato (año/mes/dia)");
		}
		return fechaNac;
	}
	private String getIdAlumno() {
		String texto = null;
		if(txtIdAlumno.getText().trim().length() == 0) {
			mensajeError("Error al momento de crear al ID Alumno");
		}else {
			texto = txtIdAlumno.getText();
		}
		return texto;
	}
	private String getApellido() {
		String texto = null;
		if(txtApellidoAl.getText().trim().length() == 0) {
			mensajeError("Ingrese el Apellido");
		}else {
			texto = txtApellidoAl.getText();
		}
		return texto;
	}
	private String getNombre() {
		String texto = null;
		if(txtNombreAl.getText().trim().length() == 0) {
			mensajeError("Ingrese el Nombre");
		}else {
			texto = txtNombreAl.getText();
		}
		return texto;
	}
	private String getDNI() {
		String texto = null;
		if(txtDni.getText().trim().length() == 0) {
			mensajeError("Ingrese el DNI");
		}else {
			texto = txtDni.getText();
		}
		return texto;
	}
	private String getNacionalidad() {
		String texto = null;
		if(txtNacionalidad.getText().trim().length() == 0) {
			mensajeError("Ingrese la nacionalidad");
		}else {
			texto = txtNacionalidad.getText();
		}
		return texto;
	}
	private int getEdad() {
		int edad = 0;
		if(txtEdad.getText().trim().length() == 0) {
			mensajeError("Ingrese la Edad");
		}else {
			edad = Integer.parseInt(txtEdad.getText().trim());
		}
		return edad;
	}
	private String getSexo() {
		String sexo = null;
		if(cmbSexo.getSelectedIndex() == 0) {
			mensajeError("Seleccione el sexo");
		}else {
			sexo = cmbSexo.getSelectedItem().toString();
		}
		return sexo;
	}
	private String getDireccion() {
		String texto = null;
		if(txtDireccion.getText().trim().length() == 0) {
			mensajeError("Ingrese la direccion");
		}else {
			texto = txtDireccion.getText();
		}
		return texto;
	}
	private String getCorreo() {
		String texto = null;
		if(txtCorreoElec.getText().trim().length() == 0) {
			mensajeError("Ingrese su correo");
		}else {
			texto = txtCorreoElec.getText();
		}
		return texto;
	}
	
	private String getCiudad() {
		String ciudad = null;
		if(cmbDistrito.getSelectedIndex() == 0) {
			mensajeError("Seleccione el distrito");
			ciudad = null;
		}else {
			ciudad = cmbDistrito.getSelectedItem().toString();
		}
		return ciudad;
	}
	private String getTeleMovil() {
		String texto = null;
		if(txtTeleMovil.getText().trim().length() == 0) {
			mensajeError("Ingrese el telefono movil");
		}else {
			texto = txtTeleMovil.getText();
		}
		return texto;
	}
	private String getTeleFijo() {
		String texto = null;
		if(txtTeleFijo.getText().trim().length() == 0) {
			mensajeError("Ingrese el telefono fijo");
		}else {
			texto = txtTeleFijo.getText();
		}
		return texto;
	}
	private String getCarrera() {
		String texto = null;
		if(cmbCarrera.getSelectedIndex() == 0) {
			mensajeError("Selecione la carrera");
		}else {
			texto = cmbCarrera.getSelectedItem().toString();
		}
		return texto;
	}
	private String getCiclo() {
		String texto = null;
		if(cmbCiclo.getSelectedIndex() == 0) {
			mensajeError("Selecione el ciclo");
		}else {
			texto = cmbCiclo.getSelectedItem().toString();
		}
		return texto;
	}
	private String getSede() {
		String texto = null;
		if(cmbSede.getSelectedIndex() == 0) {
			mensajeError("Selecione la sede");
		}else {
			texto = cmbSede.getSelectedItem().toString();
		}
		return texto;
	}
	private void mensajeError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mostrarComboxBox() {
		mostrarDistrito();
		mostrarCarrera();
		mostrarSede();
	}
	private void mostrarSede() {
		// TODO Auto-generated method stub
		ArrayList<Sede> mostraSede = gSede.listarSede();
		for (Sede sede : mostraSede) {
			cmbSede.addItem(sede.getNombre());
		}
	}

	private void mostrarCarrera() {
		ArrayList<Carrera> mostrarCarrera = gCar.listarCarreras();
		for (Carrera carrera : mostrarCarrera) {
			cmbCarrera.addItem(carrera.getNombre());
		}
	}

	private void mostrarDistrito() {
		ArrayList<Distrito> mostrarDistrito = gDis.listarDistritos();
		for (Distrito dis : mostrarDistrito) {
			cmbDistrito.addItem(dis.getNombre());
		}
		
	}
	
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		String distrito = getCiudad();
		ArrayList<Distrito> obtenerIDistritos = gDis.buscarID(distrito);
		System.out.println(distrito);
		System.out.println(obtenerIDistritos.get(0).getIdDistrito());
	}
	protected void actionPerformedBtnBuscarAlumno(ActionEvent e) {
		JDListaAlumnos alumnos = new JDListaAlumnos();
		JDListaAlumnos.ventana = "GesAlumnos";
		FrmMenuPrincipal.escritorio.add(alumnos);
		alumnos.toFront();
		alumnos.setVisible(true);
		
	}
	public static void mostrarDatosAlumnos() {
		limpiar();
		Alumno al = gAlu.obtenerDatos(idAlu);
		AlumnoAca alc = gAluAca.obtenerDatos(idAlu);
		txtIdAlumno.setText(idAlu);
		txtNombreAl.setText(al.getNombre());
		txtApellidoAl.setText(al.getApellido());
		txtDireccion.setText(al.getDomici());
		txtCorreoElec.setText(al.getCorreo());
		txtDni.setText(al.getDni());
		txtEdad.setText(String.valueOf(al.getEdad()));
		txtNacionalidad.setText(al.getNacio());
		txtTeleFijo.setText(al.getTeleFi());
		txtTeleMovil.setText(al.getTeleMo());
		Distrito dis = new Distrito();
		dis = gDis.buscarNombre(al.getIdDistrito());
		Sede sede = new Sede();
		sede = gSede.buscarNombre(alc.getIdSede());
		Carrera car = new Carrera();
		car = gCar.buscarNombre(alc.getIdCarrera());

		for(int i = 1; i<= cmbDistrito.getItemCount();i++) {
			if(cmbDistrito.getItemAt(i).toString().equals(dis.getNombre())) {
				cmbDistrito.setSelectedIndex(i);
				break;
			}
		}
		for(int i = 1; i<= cmbCarrera.getItemCount(); i++) {
			if(cmbCarrera.getItemAt(i).toString().equals(car.getNombre())) {
				cmbCarrera.setSelectedIndex(i);
				break;
			}
			System.out.println(alc.getCiclo());
		}
		for(int i = 1; i<= cmbCiclo.getItemCount();i++) {
			if(cmbCiclo.getItemAt(i).toString().equals(alc.getCiclo())) {
				cmbCiclo.setSelectedIndex(i);
				break;
			}
		}
		
		for(int i = 1;i<= cmbSede.getItemCount();i++) {
			if(cmbSede.getItemAt(i).toString().equals(sede.getNombre())) {
				cmbSede.setSelectedIndex(i);
				break;
			}
		}
		for(int i = 1;i<= cmbDistrito.getItemCount();i++) {
			if(cmbDistrito.getItemAt(i).toString().equals(dis.getNombre())) {
				cmbDistrito.setSelectedIndex(i);
				break;
			}
		}
		for(int i = 1;i<= cmbSexo.getItemCount();i++) {
			if(cmbSexo.getItemAt(i).toString().equals(al.getSexo())) {
				cmbSexo.setSelectedIndex(i);
				break;
			}
		}		
		
		
	}

	private static void limpiar() {
		// TODO Auto-generated method stub
		txtApellidoAl.setText("");
		txtCorreoElec.setText("");
		txtNacionalidad.setText("");
		txtDireccion.setText("");
		txtDni.setText("");
		txtIdAlumno.setText("");
		txtNombreAl.setText("");
		txtTeleFijo.setText("");
		txtTeleMovil.setText("");
		cmbCarrera.setSelectedIndex(0);
		cmbCiclo.setSelectedIndex(0);
		cmbDistrito.setSelectedIndex(0);
		cmbSexo.setSelectedIndex(0);
		cmbSede.setSelectedIndex(0);
		txtIdAlumno.setText(gAlu.numAlumno());
	}
}
