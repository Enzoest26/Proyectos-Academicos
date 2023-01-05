package guis;

import libreria.Fecha;
import clases.*;
import arreglos.*;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgRetiro2 extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImgRetiro;
	private JLabel lblnumRetiro;
	private JTextField txtCodRetiro;
	private JTextField txtCodMatricula;
	private JTextField txtFecha;
	private JButton btnProceder;
	private DefaultTableModel tabla;
	private JLabel lblCodMatricula;
	private JLabel lblFecha;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JLabel lblIcono;
	private JButton btnBuscar;
	private JLabel lblHora;
	private JTextField txtHora;
	private JScrollPane scrollPane;
	private JTable tblTable;
	
	

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
					DlgRetiro2 dialog = new DlgRetiro2();
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
	public DlgRetiro2() {
		setResizable(false);
		setTitle("Retiro");
		setBounds(100, 100, 710, 410);
		getContentPane().setLayout(null);

		lblImgRetiro = new JLabel();
		lblImgRetiro.setIcon(new ImageIcon("imagenes/dlgRetiro.png"));
		lblImgRetiro.setBounds(400, 10, 89, 88);
		getContentPane().add(lblImgRetiro);
		
		lblnumRetiro = new JLabel("C\u00F3digo");
		lblnumRetiro.setBounds(14, 14, 50, 14);
		getContentPane().add(lblnumRetiro);
		
		txtCodRetiro = new JTextField();
		txtCodRetiro.setBounds(115, 10, 85, 23);
		getContentPane().add(txtCodRetiro);
		txtCodRetiro.setColumns(10);
		
		txtCodMatricula = new JTextField();
		txtCodMatricula.setEditable(false);
		txtCodMatricula.setBounds(115, 41, 85, 23);
		getContentPane().add(txtCodMatricula);
		txtCodMatricula.setColumns(10);
	
		txtFecha = new JTextField();
		txtFecha.setBounds(115, 75, 85, 23);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		btnProceder = new JButton("Proceder");
		btnProceder.addActionListener(this);
		btnProceder.setForeground(Color.BLUE);
		btnProceder.setBounds(230, 117, 102, 23);
		getContentPane().add(btnProceder);

		
		
		
		txtCodRetiro.setEditable(false);
		txtFecha.setEditable(false);
		
		btnProceder.setEnabled(false);
		
		lblCodMatricula = new JLabel("C\u00F3digo del matricula:");
		lblCodMatricula.setBounds(14, 48, 102, 14);
		getContentPane().add(lblCodMatricula);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(14, 79, 70, 14);
		getContentPane().add(lblFecha);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(595, 10, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(596, 44, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(595, 79, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(596, 117, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(456, 10, 89, 23);
		getContentPane().add(btnVolver);
		
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(DlgRetiro2.class.getResource("/img/JUPITER_SCHOOL_sin_fondo_chico.png")));
		lblIcono.setBounds(342, 59, 108, 95);
		getContentPane().add(lblIcono);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(242, 10, 89, 23);
		getContentPane().add(btnBuscar);
		
		lblHora = new JLabel("Hora:");
		lblHora.setBounds(14, 112, 46, 14);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(114, 109, 86, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 177, 670, 183);
		getContentPane().add(scrollPane);
		
		tblTable = new JTable();
		scrollPane.setViewportView(tblTable);
		
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Codigo");
		tabla.addColumn("Codigo de la Matricula");
		tabla.addColumn("Fecha");
		tabla.addColumn("Hora");
		tblTable.setModel(tabla);
		btnVolver.setEnabled(false);
		listar();
		
		txtFecha.setText("" + Fecha.fechaActual());
	}
	
	//  Declaraci�n global
	ArregloRetiro re = new ArregloRetiro();
	ArregloAlumnos al = new ArregloAlumnos();
	ArregloMatricula ma = new ArregloMatricula();
	
	
	//  M�todos tipo void (con par�metros)
	void mensaje(String s1, String s2) {
		JOptionPane.showMessageDialog(this, s1, s2, 1);
	}

	

	public void actionPerformed(ActionEvent e) {
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
		if (e.getSource() == btnProceder) {
			actionPerformedBtnProceder(e);
		}
	}
	protected void actionPerformedBtnProceder(ActionEvent e) {
		switch(indexBoton) {
			case ADICIONAR:
				adicionar();
				break;
			case MODIFICAR:
				modificar();
				txtCodRetiro.setEditable(true);
				break;
			case CONSULTAR:
				consultar();
				txtCodRetiro.setEditable(true);
				break;
			case ELIMINAR:
				eliminar();
				txtCodRetiro.setEditable(true);
				break;
		}
	}
	
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		indexBoton = ADICIONAR;
		txtCodRetiro.setText(""+re.codigoCorrelativo());
		habilitarbtn(false);
		habilitartxt(true);
		txtCodRetiro.setEditable(false);;
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		indexBoton = CONSULTAR;
		habilitartxt(false);
		habilitarbtn(false);
		
		txtCodRetiro.setEditable(true);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		indexBoton = MODIFICAR;
		habilitartxt(false);
		habilitarbtn(false);
		txtCodRetiro.setEditable(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		indexBoton = ELIMINAR;
		habilitartxt(false);
		habilitarbtn(false);
		txtCodRetiro.setEditable(true);
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		habilitarbtn(true);
		txtCodRetiro.setText("");
		txtCodMatricula.setText("");
		txtHora.setText("");
		txtFecha.setText("");
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultar();
		btnProceder.setEnabled(true);
		if(indexBoton == MODIFICAR) {
			habilitartxt(true);
		}
		if(indexBoton == CONSULTAR) {
			btnProceder.setEnabled(false);
		}
	}
	void adicionar() {
		try {
			int codMatricula = leerCodMatricula();
			Alumno x = al.buscar(codMatricula);
			if(x != null) {
				int codRetiro = leerCodRetiro();
				String fecha = Fecha.fechaActual();
				String hora = Fecha.horaActual();
				//
				Retiro nuevo = new Retiro(codRetiro, codMatricula, fecha, hora);
				re.adicionar(nuevo);
				x.setEstado(2);
				re.actualizarArchivos();
				listar();
			}
			else {
				mensaje("Alumno no encontrado", "Error");
			}
		}
		catch(Exception e) {
			
		}
	}
	void modificar() {
		try {
			int codRetiro = leerCodRetiro();
			Retiro x = re.buscar(codRetiro);
			if(x != null) {
				int codMatricula = leerCodMatricula();
				String fecha = leerFecha();
				String hora = leerHora();
				x.setNumRetiro(codRetiro);
				x.setNumMatricula(codMatricula);;
				x.setHora(hora);
				x.setFecha(fecha);
				listar();
			}
		}
		catch(Exception e) {
			
		}
		
	
	}
	void consultar() {
		int codRetiro = leerCodRetiro();
		habilitartxt(false);
		
		Retiro x = re.buscar(codRetiro);
		if(x != null) {
			txtCodRetiro.setText("" + x.getNumRetiro());
			txtCodMatricula.setText(""+x.getNumMatricula());
			txtFecha.setText(""+x.getFecha());
			txtHora.setText(""+x.getHora());
			
		}
	}
	void eliminar() {
		
		try {
			int codRetiro = leerCodRetiro();
			Retiro x = re.buscar(codRetiro);
			if(x != null) {
				int decision = mensajeConfirmacion("�Estas seguro de eliminar");
				if(decision == 0) {
					re.eliminar(x);
					listar();
					re.actualizarArchivos();
					btnProceder.setEnabled(true);
				}
				else {
					mensaje("Estado no permite", "Error");
				}
			}
			else{
				mensaje("Codigo no encontrado", "Informaci�n");
			}
			
			
		}
		catch(Exception e) {
			mensaje("Error", "Error");
		}
		
	}
	void habilitarbtn(boolean condicion) {
		btnAdicionar.setEnabled(condicion);
		btnConsultar.setEnabled(condicion);
		btnModificar.setEnabled(condicion);
		btnEliminar.setEnabled(condicion);
		btnVolver.setEnabled(!condicion);
		btnBuscar.setEnabled(!condicion);
	}
	void habilitartxt(boolean condicion) {
		txtCodRetiro.setEditable(condicion);
		txtCodMatricula.setEditable(condicion);
	}
	
	int leerCodMatricula() {
		return Integer.parseInt(txtCodMatricula.getText());
	}
	int leerCodRetiro() {
		return Integer.parseInt(txtCodRetiro.getText());
	}
	String leerFecha() {
		return txtFecha.getText();
	}
	String leerHora() {
		return txtHora.getText();
	}
	int mensajeConfirmacion(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje);
	}
	void listar() {
		re.actualizarArchivos();
		tabla.setRowCount(0);
		
		for(int i = 0; i<re.tamanio();i++) {
			Object[] fila = {
				re.obtener(i).getNumRetiro(),
				re.obtener(i).getNumMatricula(),
				re.obtener(i).getFecha(),
				re.obtener(i).getHora()
			};
			tabla.addRow(fila);
			
		}
	}
}