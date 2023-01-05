package guis;

import java.awt.EventQueue;
import clases.Alumno;

import arreglos.ArregloAlumnos;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DlgAlumnos extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblEdad;
	private JLabel lblEstado;
	private JTextField txtEstado;
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
	private JTextField txtPruebas;
	
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
					DlgAlumnos dialog = new DlgAlumnos();
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
	 */
	public DlgAlumnos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnos.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setTitle("Alumnos");
		setBounds(100, 100, 739, 473);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 21, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(92, 18, 95, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setEditable(false);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 46, 62, 14);
		getContentPane().add(lblNombre);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 43, 122, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 96, 46, 14);
		getContentPane().add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(92, 93, 95, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 122, 46, 14);
		getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(92, 119, 46, 20);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(10, 71, 62, 14);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(92, 68, 122, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 147, 62, 14);
		getContentPane().add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(92, 144, 95, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 172, 62, 14);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(92, 169, 46, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 205, 703, 218);
		getContentPane().add(scrollPane);
		
		tblTable = new JTable();
		scrollPane.setViewportView(tblTable);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(624, 13, 89, 31);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(624, 63, 89, 31);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(624, 164, 89, 31);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(624, 114, 89, 31);
		getContentPane().add(btnModificar);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Codigo");
		tabla.addColumn("Nombres");
		tabla.addColumn("Apellidos");
		tabla.addColumn("DNI");
		tabla.addColumn("Edad");
		tabla.addColumn("Celular");
		tabla.addColumn("Estado");
		tblTable.setModel(tabla);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setBounds(465, 43, 89, 128);
		getContentPane().add(btnOpciones);
		
		listar();
		habilitartxt(false);
		btnOpciones.setEnabled(false);
		
		
		btnAccion = new JButton("");
		btnAccion.addActionListener(this);
		btnAccion.setBounds(293, 164, 89, 23);
		getContentPane().add(btnAccion);
		btnAccion.setEnabled(false);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(293, 17, 89, 23);
		getContentPane().add(btnBuscar);
		btnBuscar.setEnabled(false);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(DlgAlumnos.class.getResource("/img/JUPITER_SCHOOL_sin_fondo_chico.png")));
		lblLogo.setBounds(293, 46, 100, 100);
		getContentPane().add(lblLogo);
		
		txtPruebas = new JTextField();
		txtPruebas.setBounds(186, 169, 86, 20);
		getContentPane().add(txtPruebas);
		txtPruebas.setColumns(10);
	}
	
	ArregloAlumnos aa = new ArregloAlumnos();
	
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
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
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
		limpieza();
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
		habilitarbtn(false);
		btnAccion.setText("Eliminar");
		txtCodigo.setEditable(true);
		btnAccion.setEnabled(true);
		habilitarbtn(false);
		btnBuscar.setText("Buscar");
		btnBuscar.setEnabled(true);
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
		if(indexBoton == MODIFICAR) {
			txtDNI.setEditable(false);
			txtCodigo.setEditable(false);
		}
	}
	
	
	
	
	
	void listar() {
		aa.actualizarArchivo();
		tabla.setRowCount(0);
		for (int i=0; i<aa.tamanio(); i++) {
			Object[] fila = { aa.obtener(i).getCodAlumno(),
					          aa.obtener(i).getNombres(),
					          aa.obtener(i).getApellidos(),
					          aa.obtener(i).getDni(),
					          aa.obtener(i).getEdad(),
					          aa.obtener(i).getCelular(),
					          aa.obtener(i).getEstado()};
			tabla.addRow(fila);
		}
	}
	
	
	
	void limpieza() {
		txtCodigo.setText("" + aa.codigoCorrelativo());
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		txtEstado.setText("");
	}
	
	
	
	//Recogo de valores
	int leerCodigo() {
		
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerApellidos() {
		return txtApellidos.getText().trim();
	}
	String leerDni() {
		return txtDNI.getText().trim();
	}
	int leerEdad() {
		return Integer.parseInt(txtEdad.getText().trim());
	}
	int leerCelular() {
		return Integer.parseInt(txtCelular.getText().trim());
	}
	int leerEstado() {
		return Integer.parseInt(txtEstado.getText().trim());
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
	int verificarDni() {
		int codAlumno = Integer.parseInt(leerDni());
		for(int i = 0; i<aa.tamanio(); i++) {
			if(codAlumno == Integer.parseInt(aa.obtener(i).getDni())) {
				return 2;
			}
			
		}
		return -2;
	}
	void adicionar() {
		txtPruebas.setText(""+verificarDni());
		try {
			int codigo = leerCodigo();
			btnAccion.setText("Adicionar");
			int okdni = verificarDni();
			if(okdni == -2) {
				if (aa.buscar(codigo) == null) {
					String nombre = leerNombre();
					String apellido = leerApellidos();
					String dni = leerDni();
					int edad = leerEdad();
					int celular = leerCelular();
					int estado = leerEstado();
					//Adicionamos a traves del contructor
					Alumno nuevo = new Alumno(codigo, nombre, apellido, dni, edad, celular, estado);
					aa.adicionar(nuevo);
					nuevo.setEstado(0);
					listar();
					limpieza();
					
				}
				else {
					mensaje("Codigo ya exite");
				}
			}
			else {
				mensaje("Dni repetido");
			}
			
			
		}
		catch(Exception e) {
			mensaje("Codigo incorrecto");
		}
	}
	void consultar() {
		try {
			int codigo = leerCodigo();
			
			Alumno x = aa.buscar(codigo);
			if(x != null ) {
				habilitarbtn(false);
				txtNombre.setText(x.getNombres());
				txtApellidos.setText("" + x.getApellidos());
				txtDNI.setText("" + x.getDni());
				txtEdad.setText("" + x.getEdad());
				txtCelular.setText("" + x.getCelular());
				txtEstado.setText("" + x.getEstado());
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
			habilitartxt(true);
			txtCodigo.setEditable(true);
			btnAccion.setText("Modificar");
			int codigo = leerCodigo();
			Alumno x = aa.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				String apellido = leerApellidos();
				String dni = leerDni();
				int edad = leerEdad();
				int celular = leerCelular();
				int estado = leerEstado();
				x.setNombres(nombre);
				x.setApellido(apellido);
				x.setDni(dni);
				x.setEdad(edad);
				x.setCelular(celular);
				x.setEstado(estado);
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
	
	int verificarEstado() {
		int estado = 1;
		for(int i = 0; i<aa.tamanio();i++) {
			if(estado == aa.obtener(i).getEstado()) {
				return 1;
			}
		}
		return -1;
	}
	void eliminar() {
		try {
			int codigo = leerCodigo();
			
			Alumno x = aa.buscar(codigo);
			
			int okestado = x.getEstado();
			if(okestado == 0) {
				if(x != null) {
					txtNombre.setText(x.getNombres());
					txtApellidos.setText("" + x.getApellidos());
					txtDNI.setText("" + x.getDni());
					txtEdad.setText("" + x.getEdad());
					txtCelular.setText("" + x.getCelular());
					txtEstado.setText("" + x.getEstado());
					txtCodigo.requestFocus();
					int decision = mensajeConfirmacion("¿Esta seguro de eliminar el registro?" );
					if(x.getEstado() == 0) {
						if(decision == 0) {
						aa.eliminar(x);
						listar();
						btnAccion.setEnabled(true);
						}
					}
					else {
						mensajeError("El registro no se puede eliminar" + "\n" + "Verificar estado del estudiante");
					}
				}
			}
			else {
				mensajeError("Estado no valido");
			}
		}
		catch(Exception e) {
			mensajeError("No se encontro código");
		}
	}
	
	
	//Habilitar caja de texto
	void habilitartxt(boolean condicional) {
		txtNombre.setEditable(condicional);
		txtApellidos.setEditable(condicional);
		txtDNI.setEditable(condicional);
		txtEdad.setEditable(condicional);
		txtCelular.setEditable(condicional);
		txtEstado.setEditable(condicional);
		
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

