package guis;

import java.awt.EventQueue;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class DlgAlumnosMatriculaporCurso extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnProcesar;
	private JScrollPane scrollPane_1;
	private JTextArea txtResultado;
	 /* Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumnosMatriculaporCurso dialog = new DlgAlumnosMatriculaporCurso();
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
	public DlgAlumnosMatriculaporCurso() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculaporCurso.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setTitle("Matr\u00EDcula por curso");
		setBounds(100, 100, 450, 418);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 11, 89, 23);
		getContentPane().add(btnProcesar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 47, 414, 321);
		getContentPane().add(scrollPane_1);
		
		txtResultado = new JTextArea();
		scrollPane_1.setViewportView(txtResultado);
	
		
	}
	ArregloCursos cu = new ArregloCursos();
	ArregloAlumnos al = new ArregloAlumnos();
	ArregloMatricula ma = new ArregloMatricula();
	
	
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
	void limpiar() {
		txtResultado.setText("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
		Curso co;
			limpiar();
			for(int i=0;i<cu.tamanio();i++){
				co = cu.obtener(i);
				int codCurso = co.getcodCurso();
				imprimir("Asignatura: " +"\t"+  cu.buscar(codCurso).getAsignatura() + "\n");
				imprimir("Alumnos: ");
				for(int j = 0; j<ma.tamanio();j++) {
					Matricula m = ma.obtener(j);
					if(codCurso == m.getCodCurso()) {
						
						int codAlumno = m.getCodAlumno();
						Alumno a = al.buscar(codAlumno);
						imprimir("\t"  + a.getNombres());
					}
				}
				imprimir("---------------------------------------------------" + "\n");
			}
					
	}
		
	
}
