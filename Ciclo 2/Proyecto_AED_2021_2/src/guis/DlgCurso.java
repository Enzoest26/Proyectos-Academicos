package guis;


import clases.Curso;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatricula;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DlgCurso extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblAsignatura;
	private JTextField txtAsignatura;
	private JLabel lblCreditos;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JLabel lblCiclo;
	private JTextField txtCiclo;
	private JLabel lblHoras;
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private DefaultTableModel tabla;
	private JTable tblTable;
	private JButton btnOpciones;
	private JButton btnAccion;
	private JButton btnBuscar;
	private JLabel lblLogo;
	public String nomAccion;
	//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
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
					DlgCurso dialog = new DlgCurso();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 * @return 
	 */
	public DlgCurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgCurso.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setTitle("Cursos");
		setBounds(100, 100, 739, 473);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 46, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(92, 43, 95, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setEditable(false);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(10, 71, 72, 14);
		getContentPane().add(lblAsignatura);
		
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(92, 68, 122, 20);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		
		lblCreditos = new JLabel("Cr\u00E9ditos:");
		lblCreditos.setBounds(10, 121, 62, 14);
		getContentPane().add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(92, 118, 95, 20);
		getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(10, 146, 46, 14);
		getContentPane().add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(92, 143, 46, 20);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(10, 96, 62, 14);
		getContentPane().add(lblCiclo);
		
		txtCiclo = new JTextField();
		txtCiclo.setBounds(92, 93, 122, 20);
		getContentPane().add(txtCiclo);
		txtCiclo.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 703, 237);
		getContentPane().add(scrollPane);
		
		tblTable = new JTable();
		scrollPane.setViewportView(tblTable);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(624, 13, 89, 31);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(624, 54, 89, 31);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(624, 138, 89, 31);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(624, 96, 89, 31);
		getContentPane().add(btnModificar);
		
		
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setBounds(512, 32, 89, 128);
		getContentPane().add(btnOpciones);
		
		
		habilitartxt(false);
		btnOpciones.setEnabled(false);
		
		
		btnAccion = new JButton("");
		btnAccion.addActionListener(this);
		btnAccion.setBounds(269, 146, 89, 23);
		getContentPane().add(btnAccion);
		btnAccion.setEnabled(false);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(269, 17, 89, 23);
		getContentPane().add(btnBuscar);
		btnBuscar.setEnabled(false);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(DlgCurso.class.getResource("/img/JUPITER_SCHOOL_sin_fondo_chico.png")));
		lblLogo.setBounds(381, 46, 100, 100);
		getContentPane().add(lblLogo);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Codigo");
		tabla.addColumn("Asignatura");
		tabla.addColumn("Ciclo");
		tabla.addColumn("Créditos");
		tabla.addColumn("Horas");
		
		tblTable.setModel(tabla);
		listar();
	}
	
	/*---------------------------Declaraciones Globales------------------------*/
	
	ArregloCursos cu = new ArregloCursos();
	ArregloAlumnos aa =  new ArregloAlumnos();
	ArregloMatricula ma = new ArregloMatricula();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnAccion) {
			actionPerformedBtnAccion(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtAsignatura.setText("");
		txtCiclo.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		habilitarbtn(true);
		habilitartxt(false);
		btnAccion.setText("");
		btnBuscar.setText("");
		txtCodigo.setEditable(false);
		btnBuscar.setEnabled(false);
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		indexBoton = CONSULTAR;
		habilitarbtn(false);
		txtCodigo.setEditable(true);
		btnAccion.setText("Consultar");
		btnAccion.setEnabled(true);
		btnBuscar.setEnabled(false);
		btnBuscar.setText("");
	}

	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		indexBoton = ADICIONAR;
		txtCodigo.setEditable(true);
		habilitartxt(true);
		habilitarbtn(false);
		btnAccion.setText("Adicionar");
		btnBuscar.setEnabled(false);
		btnBuscar.setText("");
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		indexBoton = MODIFICAR;
		habilitartxt(false);
		habilitarbtn(false);
		btnAccion.setText("Modificar");
		btnAccion.setEnabled(false);
		btnAccion.setEnabled(true);
		btnBuscar.setEnabled(true);
		btnBuscar.setText("Buscar");
		txtCodigo.setEditable(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		indexBoton = ELIMINAR;
		btnAccion.setText("Eliminar");
		txtCodigo.setEditable(true);
		btnAccion.setEnabled(true);
		habilitarbtn(false);
		btnBuscar.setEnabled(true);
		btnBuscar.setText("Buscar");
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
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultar();
		btnAccion.setEnabled(true);
		habilitartxt(true);
		if(indexBoton == ELIMINAR) {
			habilitartxt(false);
		}
	}
	
	
	
	
	
	void listar() {
		tabla.setRowCount(0);
		for (int i=0; i<cu.tamanio(); i++) {
			Object[] fila = { cu.obtener(i).getcodCurso(),
					          cu.obtener(i).getAsignatura(),
					          cu.obtener(i).getCiclo(),
					          cu.obtener(i).getCreditos(),
					          cu.obtener(i).getHoras()};
			tabla.addRow(fila);
		}
	} 
	
	
	
	void limpieza() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		txtCiclo.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		
	}
	
	
	
	//Recogo de valores
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerAsignatura() {
		return txtAsignatura.getText().trim();
	}
	int leerCiclo() {
		return Integer.parseInt(txtCiclo.getText().trim());
	}
	int leerCreditos() {
		return Integer.parseInt(txtCreditos.getText().trim());
	}
	int leerHoras() {
		return Integer.parseInt(txtHoras.getText().trim());
	}
	
	
	void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	int mensajeConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje);
	}
	void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this,mensaje,"Error",JOptionPane.ERROR_MESSAGE);
	}
	void adicionar() {
		try {
			int codigo = leerCodigo();
			btnAccion.setText("Adicionar");
			if (cu.buscar(codigo) == null) {
				String asignatura = leerAsignatura();
				int ciclo = leerCiclo();
				int creditos = leerCreditos();
				int horas = leerHoras();
				//Adicionamos a traves del contructor
				Curso nuevo = new Curso(codigo, asignatura, ciclo, creditos, horas);
				cu.adicionar(nuevo);
				listar();
				limpieza();
			}
			else {
				mensaje("Codigo ya exite");
				limpieza();
			}
		}
		catch(Exception e) {
			mensaje("Codigo incorrecto");
		}
	}
	void consultar() {
		try {
			int codigo = leerCodigo();
			
			Curso x = cu.buscar(codigo);
			if(x != null ) {
				habilitarbtn(false);
				txtAsignatura.setText(x.getAsignatura());
				txtCiclo.setText("" + x.getCiclo());
				txtCreditos.setText("" + x.getCreditos());
				txtHoras.setText("" + x.getHoras());
				txtCodigo.requestFocus();
			}
			else {
				mensaje("No existe el codigo");
				limpieza();
			}
		
		
		}
		catch(Exception e1) {	
		}
	}
	void modificar() {
		try {
			txtCodigo.setEditable(true);
			btnAccion.setText("Modificar");
			int codigo = leerCodigo();
			Curso x = cu.buscar(codigo);
			if (x != null) {
				String asignatura = leerAsignatura();
				int ciclo = leerCiclo();
				int creditos = leerCreditos();
				int horas = leerHoras();
				x.setAsignatura(asignatura);
				x.setCiclo(ciclo);
				x.setCréditos(creditos);
				x.setHoras(horas);
				listar();
			}
			else
				mensaje("el CÓDIGO no existe");
			limpieza();
		}
		catch(Exception e) {
			mensaje("Datos incorrectos");
		}
	}
	
	int verificarAlumnos() {
		int codCurso = leerCodigo();
		for(int i = 0; i<ma.tamanio(); i++) {
			if(ma.obtener(i).getCodCurso() == codCurso) {
				return 1;
			}
		}
		return -1;
	}
	void eliminar() {
		try {
			
			int codigo = leerCodigo();
			Curso x = cu.buscar(codigo);
			int okcurso = verificarAlumnos();
			if(okcurso == -1) {
				if(x != null) {
					int decision = mensajeConfirmacion("¿Esta seguro de eliminar el registro?" );
					if(decision == 0) {
						cu.eliminar(x);
						listar();
						btnAccion.setEnabled(true);
						cu.grabarCurso();
					}
				}
				else {
					mensajeError("No se encontro código");
				}
			}
			else {
				mensajeError("Alumnos en el curso");
			}
		}
		catch(Exception e) {
			
		}
	}
	//Habilitar caja de texto
	void habilitartxt(boolean condicional) {
		
		txtAsignatura.setEditable(condicional);
		txtCiclo.setEditable(condicional);
		txtCreditos.setEditable(condicional);
		txtHoras.setEditable(condicional);
		
	}
	
	void habilitarbtn(boolean condicional) {
		btnAdicionar.setEnabled(condicional);
		btnModificar.setEnabled(condicional);
		btnEliminar.setEnabled(condicional);
		btnConsultar.setEnabled(condicional);
		btnOpciones.setEnabled(!condicional);
		btnAccion.setEnabled(!condicional);
	}
	
}
