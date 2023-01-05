package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entidad.CursosXProfesores;
import mantenimiento.GestionCursoDAO;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class JDBuscarCurso extends JInternalFrame implements KeyListener, ActionListener {
	private JLabel lblNewLabel;
	private JTextField txtCursos;
	private JScrollPane scrollPane;
	private JTable tblListarCursos;
	private JButton btnOk;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionCursoDAO gCursoDAO = new GestionCursoDAO();
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBuscarCurso dialog = new JDBuscarCurso();
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
	public JDBuscarCurso() {
		setBounds(100, 100, 543, 373);
		
		model.addColumn("Id Curso");
		model.addColumn("Nombre del Curso");
		model.addColumn("Nombre Profesor");
		model.addColumn("Dia");
		model.addColumn("Horario");
		
		
		
		panel_1 = new JPanel();
		
		lblNewLabel = new JLabel("Curso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnOk = new JButton("Seleccionar");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.addActionListener(this);
		
		txtCursos = new JTextField();
		txtCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCursos.addKeyListener(this);
		txtCursos.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(txtCursos, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnOk)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnOk)
						.addComponent(txtCursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		scrollPane = new JScrollPane();
		
		tblListarCursos = new JTable();
		tblListarCursos.setRowHeight(20);
		tblListarCursos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(tblListarCursos);
		tblListarCursos.setModel(model);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);

		mostrarBusquedaCursos();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCursos) {
			keyReleasedTxtCursos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtCursos(KeyEvent e) {
		mostrarBusquedaCursos();
	}

	private void mostrarBusquedaCursos() {
		model.setRowCount(0);
		ArrayList<CursosXProfesores> listar = gCursoDAO.buscarCursos(getCurso());
		
		for (CursosXProfesores cXp : listar) {
			Object fila[] = {
					cXp.getIdCurso(),
					cXp.getNombre(),
					cXp.getNombreProfesor(),
					cXp.getDia(),
					cXp.getHorario()
			};
			model.addRow(fila);
		}
		
	}

	private String getCurso() {
		String curso;
		curso = txtCursos.getText();
		return curso;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		enviarDatos();
	}

	private void enviarDatos() {
		String idCurso, nombre, nombreProf, dia,horario;
		int creditos,vacantes,fila;
		fila = tblListarCursos.getSelectedRow();
		
		idCurso = tblListarCursos.getValueAt(fila, 0).toString();
		nombre = tblListarCursos.getValueAt(fila, 1).toString();
		nombreProf = tblListarCursos.getValueAt(fila, 2).toString();
		dia = tblListarCursos.getValueAt(fila, 3).toString();
		horario = tblListarCursos.getValueAt(fila, 4).toString();
		creditos = gCursoDAO.obtenerCreditos(idCurso);
		vacantes = gCursoDAO.obtenerVacantes(idCurso);
		
		
		FrmMatricula.txtIdCurso.setText(idCurso);
		FrmMatricula.txtNombreCurso.setText(nombre);
		FrmMatricula.txtNombreProfesor.setText(nombreProf);
		FrmMatricula.txtHorario.setText(horario);
		FrmMatricula.txtDia.setText(dia);
		FrmMatricula.txtVacantes.setText(""+vacantes);
		FrmMatricula.txtCreditos.setText("" + creditos);
		this.dispose();
		
	}
}
