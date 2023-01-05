package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DReporteAlumnoCondicional extends JDialog implements ActionListener {
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JCheckBox chbxNombre;
	private JCheckBox chbxApellido;
	private JCheckBox chbxDni;
	private JCheckBox chbxIdEstado;
	private JCheckBox chbxIdAlumno;
	private JButton btnReportar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DReporteAlumnoCondicional dialog = new DReporteAlumnoCondicional();
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
	public DReporteAlumnoCondicional() {
		setBounds(100, 100, 604, 394);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 572, 227);
		getContentPane().add(scrollPane);
		
		lblNewLabel = new JLabel("REPORTE ALUMNOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(210, 11, 213, 25);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ESCOGUE A VISUALIZAR: ");
		lblNewLabel_1.setBounds(10, 40, 141, 14);
		getContentPane().add(lblNewLabel_1);
		
		chbxNombre = new JCheckBox("Nombre");
		chbxNombre.setBounds(119, 61, 103, 23);
		getContentPane().add(chbxNombre);
		
		chbxApellido = new JCheckBox("Apellido");
		chbxApellido.setBounds(224, 61, 97, 23);
		getContentPane().add(chbxApellido);
		
		chbxDni = new JCheckBox("DNI");
		chbxDni.setBounds(323, 61, 97, 23);
		getContentPane().add(chbxDni);
		
		chbxIdEstado = new JCheckBox("Id. Estado");
		chbxIdEstado.setBounds(422, 61, 97, 23);
		getContentPane().add(chbxIdEstado);
		
		chbxIdAlumno = new JCheckBox("Id");
		chbxIdAlumno.setBounds(10, 61, 97, 23);
		getContentPane().add(chbxIdAlumno);
		
		btnReportar = new JButton("REPORTAR");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(234, 91, 89, 23);
		getContentPane().add(btnReportar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
	}
}
