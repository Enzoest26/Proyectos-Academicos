package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import mantenimiento.GestionAlumnoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

public class FrmReporteGeneralAlumnos extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTable tblAlumnosReporte;
	private JLabel lblNewLabel;
	
	DefaultTableModel model = new DefaultTableModel();
	
	GestionAlumnoDAO gAlu = new GestionAlumnoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteGeneralAlumnos dialog = new FrmReporteGeneralAlumnos();
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
	public FrmReporteGeneralAlumnos() {
		setClosable(true);
		setBounds(100, 100, 608, 786);
		
		scrollPane = new JScrollPane();
		
		tblAlumnosReporte = new JTable();
		scrollPane.setViewportView(tblAlumnosReporte);
		
		lblNewLabel = new JLabel("REPORTE GENERAL DE ALUMNOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(97)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(106))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);
		
		
		reporteGeneral();
	}
	private void limpiarTabla() {
		model.setColumnCount(0);
		model.setRowCount(0);
	}

	private void reporteGeneral() {
		
		limpiarTabla();
		
		ArrayList<Alumno> listar = gAlu.listarAlumnosGeneral();
		model.addColumn("Id. Alumno");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Fecha Na.");
		model.addColumn("Estado");
		tblAlumnosReporte.setModel(model);
		
		for (Alumno alumno : listar) {
			Object fila [] = {
				alumno.getIdAlumno(),
				alumno.getNombre(),
				alumno.getApellido(),
				alumno.getDni(),
				alumno.getFechNa(),
				alumno.getEstado()
			};
			model.addRow(fila);
		}
	}
}
