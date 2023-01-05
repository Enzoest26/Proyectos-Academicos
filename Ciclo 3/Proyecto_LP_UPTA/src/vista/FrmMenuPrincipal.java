package vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import entidad.ConexionEmple;
import entidad.Empleado;
import entidad.TipoEmpleado;
import hilos.HiloTiempo;
import mantenimiento.GestionConexionEmpleDAO;
import mantenimiento.GestionEmpleadoDAO;
import mantenimiento.GestionTipoEmpleadoDAO;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Font;

import javax.naming.InitialContext;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;

import javax.swing.JLabel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JCheckBoxMenuItem;

public class FrmMenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAlumnos;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JScrollPane scrollPane;
	
	public String mensajeDia;
	
	private JPanel panel_1;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_1;
	public static JPanel panelConectados;
	
	
	public static GestionConexionEmpleDAO gConE = new GestionConexionEmpleDAO();
	public static GestionEmpleadoDAO gEmpleadoDAO = new GestionEmpleadoDAO();
	GestionTipoEmpleadoDAO gTipoEm = new GestionTipoEmpleadoDAO();
	public static String idEmple;
	public static String nomEmpleado;
	public boolean cargoMensaje;

	
	public static ArrayList<Empleado> datosConectados = new ArrayList<>() ;
	public static JDesktopPane escritorio;
	private JMenu mnNewMenu;
	private JMenuItem mntmRepGeCursos;
	private JMenuItem mntmRepProfesores;
	private JMenuItem mntmRepGeAlumno;
	private JMenu mnBoletas;
	private JMenuItem mntmMatricula;
	private JScrollPane scrollPane_3;
	private JMenuItem mntmCursoXProfe;
	private JMenuItem mntmRepAlumnosActivos;
	private JMenu mnGenerar;
	private JMenuItem mntmSolicitud;
	private JMenuItem mntmAutomaticas;
	private JMenuItem mntmCursosXTipo;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_2;
	private JTextArea txtMensajedelDia;
	private JMenuItem mntmCambiarUsuario;
	private JMenuItem mntmGesProf;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public FrmMenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenuPrincipal.class.getResource("/img/Logo.png")));
		setState(Frame.ICONIFIED);
		setAlwaysOnTop(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		try {
			//Seleccionar el diseño
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch (Exception e) {
			// TODO: handle exception3
			System.out.println("Sistema no soportable");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
	
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(6, 0, 0, 0));
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnSistema);
		
		mntmCambiarUsuario = new JMenuItem("Cambiar Usuario");
		mntmCambiarUsuario.addActionListener(this);
		mnSistema.add(mntmCambiarUsuario);
		
		mntmSalir = new JMenuItem("Salir");
		mnSistema.add(mntmSalir);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.addActionListener(this);
		mnNewMenu_1.add(mntmAlumnos);
		
		mntmGesProf = new JMenuItem("Profesores");
		mntmGesProf.addActionListener(this);
		mnNewMenu_1.add(mntmGesProf);
		
		mnGenerar = new JMenu("Documentos");
		mnGenerar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnGenerar);
		
		mntmSolicitud = new JMenuItem("Solicitud");
		mntmSolicitud.addActionListener(this);
		mnGenerar.add(mntmSolicitud);
		
		mnBoletas = new JMenu("Boletas");
		mnBoletas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnBoletas);
		
		mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.addActionListener(this);
		mnBoletas.add(mntmMatricula);
		
		mntmAutomaticas = new JMenuItem("Automaticas");
		mntmAutomaticas.addActionListener(this);
		mnBoletas.add(mntmAutomaticas);
		
		mnNewMenu = new JMenu("Reportes");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		mntmRepProfesores = new JMenuItem("Profesores");
		mntmRepProfesores.addActionListener(this);
		mnNewMenu.add(mntmRepProfesores);
		
		mntmRepGeCursos = new JMenuItem("Cursos General");
		mntmRepGeCursos.addActionListener(this);
		mnNewMenu.add(mntmRepGeCursos);
		
		mntmRepGeAlumno = new JMenuItem("Alumnos General");
		mntmRepGeAlumno.addActionListener(this);
		
		mntmRepAlumnosActivos = new JMenuItem("Alumnos Activos");
		mntmRepAlumnosActivos.addActionListener(this);
		mnNewMenu.add(mntmRepAlumnosActivos);
		mnNewMenu.add(mntmRepGeAlumno);
		
		mntmCursoXProfe = new JMenuItem("Cursos por Profesores");
		mntmCursoXProfe.addActionListener(this);
		mnNewMenu.add(mntmCursoXProfe);
		
		mntmCursosXTipo = new JMenuItem("Cursos por Tipo");
		mntmCursosXTipo.addActionListener(this);
		mnNewMenu.add(mntmCursosXTipo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerSize(15);
		contentPane.add(splitPane);
		
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setMinimumSize(new Dimension(190, 25));
		splitPane_1.setDividerSize(15);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		
		splitPane_2 = new JSplitPane();
		splitPane_2.setMinimumSize(new Dimension(200, 25));
		splitPane_2.setDividerSize(15);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_2);
		
		panel_1 = new JPanel();
		splitPane_2.setLeftComponent(panel_1);
		
		scrollPane_2 = new JScrollPane();
		
		lblNewLabel_1 = new JLabel("Conectados");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(45)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(43))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panelConectados = new JPanel();
		panelConectados.setBackground(new Color(245, 222, 179));
		scrollPane_2.setViewportView(panelConectados);
		panelConectados.setLayout(null);
		panel_1.setLayout(gl_panel_1);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(5, 15));
		splitPane_2.setRightComponent(panel);
		
		lblNewLabel = new JLabel("Consejo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 145, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(46))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
					.addGap(29))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 117, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		txtMensajedelDia = new JTextArea();
		txtMensajedelDia.setLineWrap(true);
		txtMensajedelDia.setWrapStyleWord(true);
		txtMensajedelDia.setEditable(false);
		scrollPane_1.setViewportView(txtMensajedelDia);
		panel.setLayout(gl_panel);
		splitPane_2.setDividerLocation(300);
		
		scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(0, 15));
		scrollPane.setPreferredSize(new Dimension(2, 15));
		splitPane_1.setLeftComponent(scrollPane);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Logo_100x100-removebg-preview.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblNewLabel_2);
		
		splitPane_1.setDividerLocation(120);
		
		scrollPane_3 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_3);
		
		escritorio = new JDesktopPane();
		escritorio.setDragMode(3);
		scrollPane_3.setViewportView(escritorio);
		escritorio.setLayout(new BorderLayout(0, 0));
		splitPane.setDividerLocation(150);
		
	
		permisos();
		mensajeDia();
		empleadoConectado();
		iniciar();
	}
	private void permisos() {
		// TODO Auto-generated method stub
		Empleado em = gEmpleadoDAO.buscarEmpleados(idEmple);
		TipoEmpleado Tem = gTipoEm.obtenerTipo(em.getIdTipo());
		FrmSolicitud.idEmple = em.getIdEmple();
		FrmSolicitud.nombreEm = em.getNombre() + em.getApellido();
	}

	public static void cerrarTodo() {
		escritorio.removeAll();
	}
	
	private void mensajeDia() {
		if(cargoMensaje == false) {
			try {
				String html = "https://proverbia.net/frase-del-dia";
				Document dc = Jsoup.connect(html).get();
				
				Element texto = dc.getElementsByTag("p").get(1);
				/*
				for (Element element : texto) {
					txtMostrarDatos.setText(element.text());
				}
				*/
				
				txtMensajedelDia.setText(""+texto.text());
				cargoMensaje = true;
			} catch (Exception e2) {
				// TODO: handle exception
				cargoMensaje = false;
				System.out.println("Error en captura el mensaje: " + e2.getMessage());
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmGesProf) {
			actionPerformedMntmGesProf(e);
		}
		if (e.getSource() == mntmCambiarUsuario) {
			actionPerformedMntmCambiarUsuario(e);
		}
		if (e.getSource() == mntmRepProfesores) {
			actionPerformedMntmRepProfesores(e);
		}
		if (e.getSource() == mntmCursosXTipo) {
			actionPerformedMntmCursosXTipo(e);
		}
		if (e.getSource() == mntmAutomaticas) {
			actionPerformedMntmAutomaticas(e);
		}
		if (e.getSource() == mntmSolicitud) {
			actionPerformedMntmSolicitud(e);
		}
		if (e.getSource() == mntmRepAlumnosActivos) {
			actionPerformedMntmRepAlumnosActivos(e);
		}
		if (e.getSource() == mntmCursoXProfe) {
			actionPerformedMntmCursoXProfe(e);
		}
		if (e.getSource() == mntmRepGeCursos) {
			actionPerformedMntmRepCursos(e);
		}
		if (e.getSource() == mntmRepGeAlumno) {
			actionPerformedMntmRepAlumno(e);
		}
		if (e.getSource() == mntmMatricula) {
			actionPerformedMntmBoletaAlumno(e);
		}
		if (e.getSource() == mntmAlumnos) {
			actionPerformedMntmAlumnos(e);
		}
	}
	
	public static void empleadoConectado() {
		eliminarConectados();
		
		crearConectadosJlabel();
	}
	private void iniciar() {
		HiloTiempo hilo = new HiloTiempo();
		hilo.start();
	}
	
	public static void crearConectadosJlabel() {
		panelConectados.removeAll();
		 ArrayList<ConexionEmple> estadoConectado = gConE.obtenerEmpleadoConectado();
		int labels = estadoConectado.size();
		JLabel[] crearLabels = new JLabel[labels];
		labels = estadoConectado.size();
		System.out.println(estadoConectado);
		for (ConexionEmple cEmple : estadoConectado) {
			datosConectados.add(gEmpleadoDAO.buscarEmpleados(cEmple.getIdEmple()));
		}
		System.out.println(labels);
		if(labels != 0) {
			int width, height,x,y;
			width = 150;
			height = 18;
			x = 15;
			y = 10;
			
			for (int i = 0; i<labels;i++) {
				
				crearLabels[i] = new JLabel();
				crearLabels[i].setBounds(x,y,width,height);
				crearLabels[i].setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/green_cicle.png")));
				panelConectados.add(crearLabels[i]);
				
				crearLabels[i].setText(datosConectados.get(i).getNombre() + " "+datosConectados.get(i).getIdEmple());
				y += 25;
			
			}
		}
		
	}

	public static void eliminarConectados() {
		//Eliminar los labels
		//panelConectados.
		panelConectados.removeAll();
		try {
			
			//panelConectados.revalidate();
			//panelConectados.repaint();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Esta vacio");
		}
		
	}
	

	
	protected void actionPerformedMntmAlumnos(ActionEvent e) {
		cerrarTodo();
		escritorio.repaint();
		FrmGesAlumnos alum = new FrmGesAlumnos();
		alum.setVisible(true);
		escritorio.add(alum);
	}
	protected void actionPerformedMntmBoletaAlumno(ActionEvent e) {
		cerrarTodo();
		escritorio.repaint();
		FrmMatricula boleta = new FrmMatricula();
		boleta.setVisible(true);
		escritorio.add(boleta);
	}
	protected void actionPerformedMntmRepAlumno(ActionEvent e) {
		/*
		escritorio.repaint();
		FrmReporteAlumno rAlum = new FrmReporteAlumno();
		rAlum.setVisible(true);
		escritorio.add(rAlum);
		*/
		
		cerrarTodo();
		FrmReporteGeneralAlumnos rgAlumno = new FrmReporteGeneralAlumnos();
		rgAlumno.setVisible(true);
		escritorio.add(rgAlumno);
	}
	protected void actionPerformedMntmRepCursos(ActionEvent e) {
		cerrarTodo();
		FrmLstCursos cursos = new FrmLstCursos();
		cursos.setVisible(true);
		escritorio.add(cursos);
	}
	protected void actionPerformedMntmCursoXProfe(ActionEvent e) {
		cerrarTodo();
	
		FrmReporteCursoXProfesor rcuProf = new FrmReporteCursoXProfesor();
		rcuProf.setVisible(true);
		escritorio.add(rcuProf);
	}
	protected void actionPerformedMntmRepAlumnosActivos(ActionEvent e) {
		cerrarTodo();
		
		FrmLstAlumnos alumnos  = new FrmLstAlumnos();
		alumnos.setVisible(true);
		escritorio.add(alumnos);
	}
	protected void actionPerformedMntmSolicitud(ActionEvent e) {
		cerrarTodo();
		
		FrmSolicitud solicitud = new FrmSolicitud();
		solicitud.setVisible(true);
		escritorio.add(solicitud);
	}
	protected void actionPerformedMntmAutomaticas(ActionEvent e) {
		cerrarTodo();
		FrmBoletasAutomaticas automaticas = new FrmBoletasAutomaticas();
		automaticas.setVisible(true);
		escritorio.add(automaticas);
		
	}
	protected void actionPerformedMntmCursosXTipo(ActionEvent e) {
		cerrarTodo();
		FrmReporteCursosTipo ctipo = new FrmReporteCursosTipo();
		ctipo.setVisible(true);
		escritorio.add(ctipo);
	}
	protected void actionPerformedMntmRepProfesores(ActionEvent e) {
		cerrarTodo();
		FrmLstProfesores prof = new FrmLstProfesores();
		prof.setVisible(true);
		escritorio.add(prof);
	}
	protected void actionPerformedMntmCambiarUsuario(ActionEvent e) {
		FrmLogueo loguear = new FrmLogueo();
		loguear.setVisible(true);
		this.dispose();
	}
	protected void actionPerformedMntmGesProf(ActionEvent e) {
		cerrarTodo();
		FrmGesProfesor prof = new FrmGesProfesor();
		prof.setVisible(true);
		escritorio.add(prof);
	}
}
