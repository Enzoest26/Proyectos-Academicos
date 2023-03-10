package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DlgMatriculaRetiro extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnMatricula;
	private JButton btnRetiro;
	private JLabel lblMatricula;
	private JLabel lblRetiro;
	private JTextField txtMatricula;
	private JTextField txtRetiro;
	private JLabel lblNewLabel_2;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;
	private JButton btnVolver;
	
	private final static int MATRICULA = 1;
	private final static int RETIRO = 2;
	
//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int indexBoton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatriculaRetiro dialog = new DlgMatriculaRetiro();
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
	public DlgMatriculaRetiro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMatriculaRetiro.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setTitle("Matriculas y Retiros");
		setBounds(100, 100, 606, 373);
		getContentPane().setLayout(null);
		
		btnMatricula = new JButton("Matricula");
		btnMatricula.addActionListener(this);
		btnMatricula.setBounds(489, 11, 89, 23);
		getContentPane().add(btnMatricula);
		
		btnRetiro = new JButton("Retiro");
		btnRetiro.addActionListener(this);
		btnRetiro.setBounds(489, 45, 89, 23);
		getContentPane().add(btnRetiro);
		
		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(10, 15, 75, 14);
		getContentPane().add(lblMatricula);
		
		lblRetiro = new JLabel("Retiro");
		lblRetiro.setBounds(10, 49, 46, 14);
		getContentPane().add(lblRetiro);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(113, 12, 86, 20);
		getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtRetiro = new JTextField();
		txtRetiro.setBounds(113, 46, 86, 20);
		getContentPane().add(txtRetiro);
		txtRetiro.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DlgMatriculaRetiro.class.getResource("/img/JUPITER_SCHOOL_sin_fondo_chico.png")));
		lblNewLabel_2.setBounds(313, 15, 105, 103);
		getContentPane().add(lblNewLabel_2);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(113, 79, 89, 23);
		getContentPane().add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 572, 194);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		scrollPane.setViewportView(txtResultado);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(214, 11, 89, 23);
		getContentPane().add(btnVolver);
		habilitartxt(false);
		txtRetiro.setEditable(false);
		habilitarbtn(true);

	}
	/*---------------------------Declaraciones Globales------------------------*/
	
	ArregloCursos cu = new ArregloCursos();
	ArregloAlumnos al =  new ArregloAlumnos();
	ArregloMatricula ma = new ArregloMatricula();
	ArregloRetiro re = new ArregloRetiro();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnRetiro) {
			actionPerformedBtnRetiro(e);
		}
		if (e.getSource() == btnMatricula) {
			actionPerformedBtnMatricula(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		if(indexBoton == MATRICULA) {
			matricula();
		}
		if(indexBoton == RETIRO) {
			retiro();
		}
	}
	protected void actionPerformedBtnMatricula(ActionEvent e) {
		indexBoton = MATRICULA;
		habilitarbtn(false);
		habilitartxt(true);
	}
	protected void actionPerformedBtnRetiro(ActionEvent e) {
		indexBoton = RETIRO;
		habilitarbtn(false);
		habilitartxt(false);
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		habilitarbtn(true);
		
		habilitartxt(false);
		txtRetiro.setEditable(false);
	}
	
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
	int leerCodMatricula() {
		return Integer.parseInt(txtMatricula.getText());
	}
	int leerCodRetiro() {
		return Integer.parseInt(txtRetiro.getText());
	}
	void limpieza() {
		txtResultado.setText("");
	}
	void matricula() {
		limpieza();
		int codMatricula = leerCodMatricula();
		Matricula m = ma.buscar(codMatricula);
		int codAlumno = m.getCodAlumno();
		Alumno a = al.buscar(codAlumno);
		int codCurso = m.getCodCurso();
		Curso c = cu.buscar(codCurso);
		String nombre = a.getNombres();
		String asignatura = c.getAsignatura();
		imprimir("Nombre es : " + nombre);
		imprimir("Asignatura es : "+ asignatura);
		
	}
	void retiro() {
		limpieza();
		int codRetiro = leerCodRetiro();
		Retiro x = re.buscar(codRetiro);
		int codMatricula = x.getNumMatricula();
		Matricula m = ma.buscar(codMatricula);
		int codAlumno = m.getCodAlumno();
		Alumno a = al.buscar(codAlumno);
		int codCurso = m.getCodCurso();
		Curso c = cu.buscar(codCurso);
		String nombre = a.getNombres();
		String asignatura = c.getAsignatura();
		imprimir("Nombre es : " + nombre);
		imprimir("Asignatura es : "+ asignatura);
	}
	void habilitarbtn(boolean condicion){
		btnProcesar.setEnabled(!condicion);
		btnVolver.setEnabled(!condicion);
		btnMatricula.setEnabled(condicion);
		btnRetiro.setEnabled(condicion);
	}
	void habilitartxt(boolean condicion) {
		txtMatricula.setEditable(condicion);
		txtRetiro.setEditable(!condicion);
	}
	
	
}
