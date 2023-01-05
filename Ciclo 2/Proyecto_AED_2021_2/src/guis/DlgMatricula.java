package guis;

import java.awt.EventQueue;
import clases.*;
import arreglos.*;
import libreria.Fecha;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgMatricula extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblCodigoAlumno;
	private JLabel lblCurso;
	private JTextField txtCodigoMatricula;
	private JTextField txtCodigoAlumno;
	private JTextField txtCurso;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private JLabel lblHora;
	private JLabel lblFecha;
	private JTextField txtHora;
	private JTextField txtFecha;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JButton btnAccion;
	private DefaultTableModel tabla;
	
	
	
//  Tipo de operaci�n a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int indexBoton;
	
//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatricula dialog = new DlgMatricula();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgMatricula() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMatricula.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setTitle("Matr\u00EDcula");
		setBounds(100, 100, 657, 379);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo de Matricula:");
		lblCodigo.setBounds(10, 11, 120, 14);
		getContentPane().add(lblCodigo);
		
		lblCodigoAlumno = new JLabel("C\u00F3digo del Alumno:");
		lblCodigoAlumno.setBounds(10, 36, 110, 14);
		getContentPane().add(lblCodigoAlumno);
		
		lblCurso = new JLabel("C\u00F3digo del Curso:");
		lblCurso.setBounds(10, 61, 120, 14);
		getContentPane().add(lblCurso);
		
		txtCodigoMatricula = new JTextField();
		txtCodigoMatricula.setEditable(false);
		txtCodigoMatricula.setBounds(140, 8, 86, 20);
		getContentPane().add(txtCodigoMatricula);
		txtCodigoMatricula.setColumns(10);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setBounds(140, 33, 86, 20);
		getContentPane().add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(140, 58, 86, 20);
		getContentPane().add(txtCurso);
		txtCurso.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(542, 7, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(542, 41, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(542, 75, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(542, 109, 89, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 621, 186);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		scrollPane.setViewportView(tblMatricula);
		
		lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 86, 46, 14);
		getContentPane().add(lblHora);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 113, 46, 14);
		getContentPane().add(lblFecha);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(140, 83, 86, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(140, 110, 86, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(250, 7, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(379, 7, 89, 23);
		getContentPane().add(btnVolver);
		
		btnAccion = new JButton("");
		btnAccion.setEnabled(false);
		btnAccion.addActionListener(this);
		btnAccion.setBounds(250, 109, 89, 23);
		getContentPane().add(btnAccion);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("C�digo Matricula");
		tabla.addColumn("C�digo Alumno");
		tabla.addColumn("C�digo del curso");
		tabla.addColumn("Fecha");
		tabla.addColumn("Hora");
		tblMatricula.setModel(tabla);
		
		txtFecha.setText(""+ Fecha.fechaActual());
		listar();
		habilitartxt(false);
	}
	
	/*-------------Declaraci�n global---------------------*/
	ArregloMatricula ma = new ArregloMatricula();
	ArregloAlumnos al = new ArregloAlumnos();
	ArregloCursos cu = new ArregloCursos();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAccion) {
			actionPerformedBtnAccion(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		indexBoton = ADICIONAR;
		habilitarbtn(false);
		btnAccion.setText("Adicionar");
		txtCodigoMatricula.setEditable(true);
		habilitartxt(true);
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		indexBoton = CONSULTAR;
		habilitarbtn(false);
		habilitartxt(false);
		btnAccion.setText("Consultar");
		txtCodigoMatricula.setEditable(true);
		btnBuscar.setEnabled(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		indexBoton = MODIFICAR;
		habilitarbtn(false);
		habilitartxt(false);
		btnAccion.setText("Modificar");
		btnBuscar.setText("Buscar");
		txtCodigoMatricula.setEditable(true);
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		indexBoton = ELIMINAR;
		habilitarbtn(false);
		habilitartxt(false);
		btnAccion.setText("Eliminar");
		btnBuscar.setText("Buscar");
		txtCodigoMatricula.setEditable(true);
	}
	
	protected void actionPerformedBtnVolver(ActionEvent e) {
		habilitarbtn(true);
		btnBuscar.setEnabled(false);
		txtCodigoMatricula.setEditable(false);
		limpiar();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultar();
		btnAccion.setEnabled(true);
		if(indexBoton == MODIFICAR) {
			txtCurso.setEditable(true);
		}
	}
	
	
	protected void actionPerformedBtnAccion(ActionEvent e) {
		switch(indexBoton) {
			case ADICIONAR:
				adicionar();
				break;
			case MODIFICAR:
				modificar();
				break;
			case CONSULTAR:
				consultar();
				break;
			case ELIMINAR:
				eliminar();
				break;
		}
	}
	
	/*-------------fecha---------*/

	void listar() {
		Matricula m;
		tabla.setRowCount(0);
		for(int i = 0; i<ma.tamanio(); i++) {
			m = ma.obtener(i);
			Object [] fila= {
				m.getNumMatricula(),
				m.getCodAlumno(),
				m.getCodCurso(),
				m.getFecha(),
				m.getHora()
			};
			tabla.addRow(fila);
		}
	}
	
	void adicionar() {	
		try {
			int codMatri = leerCodMatricula();
			
			try {
				int codAlumno = leerCodAlumno();
				
				try {
					int codCurso = leerCodCurso();
					
					int okAlumno = verificarCodAlumno();
					int okCurso = verificarCodCurso();
					Matricula m = ma.buscar(codMatri);
					if(m ==null) {
						if (okCurso == 3 && okAlumno == 2) {
							
							Matricula nuevo = new Matricula(codMatri, codAlumno, codCurso, Fecha.fechaActual(), Fecha.horaActual());
							ma.adicionar(nuevo);
							Alumno x = al.buscar(codAlumno);
							x.setEstado(1);
							al.actualizarArchivo();
							listar();
							
						}
						else if(okCurso == -2) {
							mensajeInfo("Curso no encontrado", "Informacion");
						}
						else {
							mensajeInfo("Alumno no encontrado", "Informacion");
						}
					}
					else {
						mensajeError("C�digo repetido", "Error");
					}
					
					
				}
				catch(Exception e) {
					mensajeInfo("Falta ingresar curso", "Informacion");
					limpieza();
				}
				
			}
			catch(Exception e) {
				mensajeInfo("Falta ingresar c�digo del alumno", "Informacion");
			}
		}
		catch(Exception e) {
			mensajeInfo("Falta ingresar c�digo de la matricula", "Informacion");
			limpieza();
		}
	}
	void modificar() {
		try {
			int codMatricula = leerCodMatricula();
			int codCurso = leerCodCurso();
			Matricula x = ma.buscar(codMatricula);
			if(x != null) {
				x.setCodCurso(codCurso);
				listar();
			}
		}
		catch(Exception e) {
			mensajeError("Datos incorrectos", "Error en compilar");
		}
	}
	void consultar() {
		try {
			int codMatricula = leerCodMatricula();
			habilitartxt(false);
			Matricula x = ma.buscar(codMatricula);
			if(x != null) {
				txtCodigoMatricula.setText(""+ x.getNumMatricula());
				txtCodigoAlumno.setText(""+ x.getCodAlumno());
				txtCurso.setText("" + x.getCodCurso());
				txtFecha.setText("" + x.getFecha());
				txtHora.setText("" + x.getHora());
			}
		}
		catch(Exception e) {
			mensajeError("Datos incorrectos", "Error");
		}
	}
	void eliminar() {
		try {
			int codMatricula = leerCodMatricula();
			Matricula m = ma.buscar(codMatricula);
			int codAlumno = m.getCodAlumno();
			Alumno x = al.buscar(codAlumno);
			consultar();
			int okestado = x.getEstado();
			
			if(okestado !=2) {
				int decision = mensajeConfirmacion("�Quiere eliminar el registro?");
				if(decision == 0) {
					ma.eliminar(m);
					listar();
					ma.actualizarArchivo();
				}
			}
			else {
				mensaje("Estado no valido");
			}
			
			
		}
		catch(Exception e) {
			mensajeError("Datos incorrectos", "Error");
		}
	}
	
	void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	int mensajeConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje);
	}

	//------------Verificar los codigos alumnos y cursos existente
	int verificarCodAlumno() {
		int codAlumno = leerCodAlumno();
		for(int i = 0; i<al.tamanio(); i++) {
			if(codAlumno == al.obtener(i).getCodAlumno()) {
				return 2;
			}
			
		}
		return -2;
	}
	int verificarCodCurso() {
		int codCurso = leerCodCurso();
		for(int i = 0; i<cu.tamanio(); i++) {
			if(codCurso == cu.obtener(i).getcodCurso()){
				return 3;
			}
		}
		return -1;
	}
	
	
	//Habilitar caja de texto
	void habilitartxt(boolean condicional) {
		txtCodigoAlumno.setEditable(condicional);
		txtCurso.setEditable(condicional);
		
	}
	
	void habilitarbtn(boolean condicional) {
		btnBuscar.setEnabled(!condicional);
		if(indexBoton == ADICIONAR) {
			btnBuscar.setEnabled(condicional);
		}
		btnAdicionar.setEnabled(condicional);
		btnModificar.setEnabled(condicional);
		btnEliminar.setEnabled(condicional);
		btnConsultar.setEnabled(condicional);
		btnVolver.setEnabled(!condicional);
		btnAccion.setEnabled(!condicional);
		
	}
	int leerCodMatricula(){
		return Integer.parseInt(txtCodigoMatricula.getText().trim());
	}
	int leerCodAlumno() {
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	int leerCodCurso() {
		return Integer.parseInt(txtCurso.getText().trim());
	}
	void limpieza() {
		txtCodigoMatricula.setText("");
		txtCodigoAlumno.setText("");
		txtCurso.setText("");
	}
	void mensajeInfo(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this,mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	void limpiar() {
		txtCodigoMatricula.setText("");
		txtCodigoAlumno.setText("");
		txtCurso.setText("");
		txtHora.setText("");
		txtFecha.setText("");
	}
}
