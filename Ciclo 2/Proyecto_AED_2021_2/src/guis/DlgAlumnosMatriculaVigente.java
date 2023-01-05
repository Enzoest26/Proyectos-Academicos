package guis;


import java.awt.EventQueue;

import arreglos.ArregloAlumnos;
import arreglos.ArregloMatricula;
import clases.Alumno;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class DlgAlumnosMatriculaVigente extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnProcesar;
	private JScrollPane scrollPane_1;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumnosMatriculaVigente dialog = new DlgAlumnosMatriculaVigente();
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
	public DlgAlumnosMatriculaVigente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculaVigente.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setResizable(false);
		setTitle("Alumnos con Matr\u00EDcula Vigente");
		setBounds(100, 100, 450, 417);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(323, 11, 89, 23);
		getContentPane().add(btnProcesar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 60, 414, 307);
		getContentPane().add(scrollPane_1);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		scrollPane_1.setViewportView(txtResultado);
		
		listar();
	}

	ArregloAlumnos al=new ArregloAlumnos();
	ArregloMatricula ma=new ArregloMatricula();
	
	
	void listar(){
		
	}
	
	
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
	void limpiar(){
		txtResultado.setText("");
		}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Alumno a;
			limpiar();
			for(int i=0;i<al.tamanio();i++){
				a=al.obtener(i);
				if(a.getEstado() != 2) {
					imprimir("\t" + "ALUMNO" + "\n");
					imprimir("Codigo de estudiante: " + "\t" +a.getCodAlumno());
					imprimir("Nombre:"+ "\t"+ "\t"+a.getNombres());
					imprimir("Apellidos:"+ "\t"+ "\t"+a.getApellidos());
					imprimir("Edad:"+ "\t"+ "\t"+a.getEdad());
					imprimir("Dni:"+ "\t"+ "\t"+a.getDni());
					imprimir("Telefono:"+ "\t"+ "\t"+a.getCelular());
					imprimir("--------------------------------------------------------");
					imprimir("");
					
				}		

		}
	}
}
