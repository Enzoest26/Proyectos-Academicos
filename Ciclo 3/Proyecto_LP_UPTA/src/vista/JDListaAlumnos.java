package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import entidad.ReportarAlumno;
import mantenimiento.GestionAlumnoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class JDListaAlumnos extends JInternalFrame implements KeyListener, ActionListener {
	private JPanel panel;
	private JTextField txtListarAlumnos;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JTable tblListarAlumnos;
	DefaultTableModel model = new DefaultTableModel();
	GestionAlumnoDAO gAlumnoDAO = new GestionAlumnoDAO();
	public static String ventana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDListaAlumnos dialog = new JDListaAlumnos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDListaAlumnos() {
		setTitle("Buscar Alumno");
		setFrameIcon(new ImageIcon(JDListaAlumnos.class.getResource("/img/Logo.png")));
		setBounds(100, 100, 601, 373);
		
		panel = new JPanel();
		
		txtListarAlumnos = new JTextField();
		txtListarAlumnos.addKeyListener(this);
		txtListarAlumnos.setColumns(10);
		
		lblNewLabel = new JLabel("Estudiante: ");
			
		model.addColumn("Id. Alumno");
		model.addColumn("Nombres Completo");
		model.addColumn("DNI");
		
		btnOk = new JButton("OK");
		
		scrollPane = new JScrollPane();
		
		tblListarAlumnos = new JTable();
		scrollPane.setViewportView(tblListarAlumnos);
		
		tblListarAlumnos.setModel(model);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addGap(39))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtListarAlumnos, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(txtListarAlumnos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnOk)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		btnOk.addActionListener(this);
		
		mostrarListadoAlumno();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtListarAlumnos) {
			keyPressedTxtListarAlumnos(e);
		}
	}
	public void keyReleased(KeyEvent e) {
		mostrarListadoAlumno();
	}
	public void keyTyped(KeyEvent e) {
		//mostrarListadoAlumno();
	}
	protected void keyPressedTxtListarAlumnos(KeyEvent e) {
		//mostrarListadoAlumno();
	}

	private void mostrarListadoAlumno() {
		model.setRowCount(0);
		if(txtListarAlumnos.getText().trim().length() == 0) {
			model.setRowCount(0);
		}
		ArrayList<ReportarAlumno>  listar = gAlumnoDAO.buscarAlumno(getAlumno());
		for (ReportarAlumno rAlum : listar) {
			Object fila[] = {
					rAlum.getIdAlumno(),
					rAlum.getNombrecompletos(),
					rAlum.getDni()
			};
			model.addRow(fila);
		}
	}

	
	private void enviarDatos() {
		String nombres, idAlumno, dni;
		int fila;
		fila = tblListarAlumnos.getSelectedRow();
		
		idAlumno = tblListarAlumnos.getValueAt(fila, 0).toString();
		nombres = tblListarAlumnos.getValueAt(fila, 1).toString();
		dni = tblListarAlumnos.getValueAt(fila, 2).toString();
		if(ventana.equals("Automaticas")) {
			FrmBoletasAutomaticas.txtCodigo.setText(idAlumno);
			FrmBoletasAutomaticas.txtEstudiante.setText(nombres);
			FrmBoletasAutomaticas.txtDNI.setText(dni);
		}else if(ventana.equals("GesAlumnos")) {
			FrmGesAlumnos.idAlu = idAlumno;
			FrmGesAlumnos.nombreAlu = nombres;
			FrmGesAlumnos.mostrarDatosAlumnos();
		}
		else {
			FrmMatricula.txtCodigo.setText(idAlumno);
			FrmMatricula.txtNombreEstudiante.setText(nombres);
			FrmMatricula.txtDNIAlumno.setText(dni);
		}
		mostrarListadoAlumno();
		this.dispose();
	}
	
	
	private String getAlumno() {
		String alumno = null;
		alumno = txtListarAlumnos.getText();
		return alumno;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		try {
			enviarDatos();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		confimarVentana();
		this.dispose();
	}
	private void confimarVentana() {
		if(ventana == "Informe") {
			String iDAlumno;
			int fila = tblListarAlumnos.getSelectedRow();
			 iDAlumno = tblListarAlumnos.getValueAt(fila, 0).toString();
			 FrmSolicitud.txtIDAlumno.setText(iDAlumno);
			 
			 this.dispose();
		}
		

	}
}
