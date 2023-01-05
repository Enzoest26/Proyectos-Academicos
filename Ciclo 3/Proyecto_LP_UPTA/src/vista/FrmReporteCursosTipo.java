package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Curso;
import entidad.TipoCurso;

import mantenimiento.GestionCursoDAO;
import mantenimiento.GestionCursoTipoDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrmReporteCursosTipo extends JInternalFrame {

	private JPanel contentPane;
	private JComboBox cboTipo;
	GestionCursoTipoDAO gTipUser = new GestionCursoTipoDAO();
	GestionCursoDAO gUser = new GestionCursoDAO();
	private JTable tbUsuarios;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteCursosTipo frame = new FrmReporteCursosTipo();
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
	public FrmReporteCursosTipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblListadoDeUsuarios = new JLabel("Listado de Cursos");
		lblListadoDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListadoDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarReporte();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		
		tbUsuarios = new JTable();
		tbUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuarios);

		JLabel lblTipo = new JLabel("Tipo:");

		cboTipo = new JComboBox();
		//columnas
		model.addColumn("Nombre");
		model.addColumn("Fecha de inicio");
		model.addColumn("Fecha de finalizacion");
		model.addColumn("ID curso");
		
		tbUsuarios.setModel(model);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(cboTipo, 0, 358, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(167)
							.addComponent(btnReporte, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(163))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(lblListadoDeUsuarios, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addGap(113)))
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblListadoDeUsuarios, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTipo))
						.addComponent(cboTipo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addGap(14)
					.addComponent(btnReporte)
					.addGap(4))
		);
		contentPane.setLayout(gl_contentPane);
		
		cargarDataComboBox();

		
	}
	//método para cargar data al comboBox desde la BD
		@SuppressWarnings("unchecked")
		private void cargarDataComboBox() {
			// 1. Obtener el resultado del proceso de consulta
			ArrayList<TipoCurso> listatipcursos = gTipUser.listaCursosxTipo();
			//2.validar el resultado del proceso
			if(listatipcursos.size() == 0) {
				mensajeError("Lista vacía");
			}else {
				cboTipo.addItem("Seleccione ...");
				for (TipoCurso tipoCursos : listatipcursos) {
					cboTipo.addItem(tipoCursos.getIdTipoCurso() + " - " + tipoCursos.getNombre());
				}
			}
		}
	private void mensajeError(String msj) {
			JOptionPane.showMessageDialog(this, msj,"Error!! ",0);
			
		}
	
	private void cargarReporte() {
		//limpiar la tabla
		model.setRowCount(0);
		//obtener el tipo de usuario ingresado
		String tipo = getTipo(); 		
		//Validar				
		if (tipo == null) {
			return;
		}else {
			//obtener el resultado del proceso de consulta
			ArrayList<Curso> listCursos = gUser.listarIdCursoXNombre(tipo);
			//validar el resultado del proceso
			if(listCursos.size() == 0) {
				mensajeError("Lista vacía");
			}else {
				//bucle
				for (Curso c : listCursos) {
					Object fila[] = {c.getNombre(),
							         c.getFechaIni(),
							         c.getFehcaFin(),
							         c.getIdCurso()
							         };
					model.addRow(fila);
				}
			}
		}
			
		
	}

	private String getTipo() {
		String texto = cboTipo.getSelectedItem().toString();
		String[] datos = texto.split(" ");
		return datos[0];
	}

}
