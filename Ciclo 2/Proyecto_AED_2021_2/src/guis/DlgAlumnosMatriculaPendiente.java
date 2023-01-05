package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import arreglos.ArregloAlumnos;
import clases.Alumno;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DlgAlumnosMatriculaPendiente extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JButton btnProcesar;
	private JTextArea txtresultado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumnosMatriculaPendiente dialog = new DlgAlumnosMatriculaPendiente();
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
	public DlgAlumnosMatriculaPendiente() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculaPendiente.class.getResource("/img/JUPITER_SCHOOL_MINI_sin fondo.png")));
		setTitle("Alumnos por Matr\u00EDcula");
		setBounds(100, 100, 447, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 414, 310);
		contentPanel.add(scrollPane);
		
		txtresultado = new JTextArea();
		scrollPane.setViewportView(txtresultado);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnProcesar);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		
	}
	
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		ArregloAlumnos al=new ArregloAlumnos();
		Alumno a;
		for(int i=0;i<al.tamanio();i++){
			a=al.obtener(i);
			if(a.getEstado()!=1){
				imprimir("\t" + "ALUMNO" + "\n");
				imprimir("Codigo de estudiante:"+"\t"+a.getCodAlumno());
				imprimir("Nombre:"+"\t"+"\t"+a.getNombres());
				imprimir("Apellidos:"+"\t"+"\t"+a.getApellidos());
				imprimir("Edad:"+"\t"+"\t"+a.getEdad());
				imprimir("Dni:"+"\t"+"\t"+a.getDni());
				imprimir("Telefono:"+"\t"+"\t"+a.getCelular());
				imprimir("---------------------------------------------------------------------------------");
			}
		}
			
		
		
	}
	void imprimir(String s) {
		txtresultado.append(s + "\n");
	}
	void limpiar(){
		txtresultado.setText("");
		}
}
