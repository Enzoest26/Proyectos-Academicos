package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Curso;
import entidad.Profesor;
import mantenimiento.GestionCursoDAO;
import mantenimiento.GestionProfesorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrmReporteCursoXProfesor extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tbUsuarios;
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnReporte;
	//instanciar Objeto
	GestionCursoDAO gUser = new GestionCursoDAO();
	GestionProfesorDAO gProf = new GestionProfesorDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteCursoXProfesor frame = new FrmReporteCursoXProfesor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmReporteCursoXProfesor() {
		setClosable(true);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListadoDeUsuarios = new JLabel("Listado de Cursos");
		lblListadoDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tbUsuarios = new JTable();
		tbUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tbUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuarios);
		//columnas
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Profesor");
		model.addColumn("Tipo");
		
		tbUsuarios.setModel(model);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(138)
					.addComponent(lblListadoDeUsuarios, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(btnReporte, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListadoDeUsuarios, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReporte))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addGap(41))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		cargarReporte();
	}

	private void cargarReporte() {
		//limpiar la tabla
		model.setRowCount(0);
		//Obtener el resultado del proceso de consulta
		ArrayList<Curso> listaUser = gUser.listaCursos();
		Profesor p;
		//Validar el resultado
		if(listaUser.size() == 0) {
			mensajeError("Lista vacía");
		}else {
			for (Curso c : listaUser) {
				//System.out.println(c.getIdCurso());
				p = gProf.nombreProfesores(c.getIdprofesor());
				
				Object fila [] = {c.getIdCurso(),
						          c.getNombre(),
						          p.getNomProf(),
						          c.getIdTipo()
						          };
				model.addRow(fila);
			}
		}
		
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error!! ",0);
		
	}
}
