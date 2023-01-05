package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entidad.Solicitud;
import mantenimiento.GestionSolicitudDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JDBuscarSolicitud extends JInternalFrame implements KeyListener, MouseListener, ActionListener {
	private JLabel lblNewLabel;
	private JTextField txtIdSolicitud;
	private JScrollPane scrollPane;
	private JTable tblListarSolicitudes;
	public static String ventana;
	GestionSolicitudDAO gSol = new GestionSolicitudDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnOk;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBuscarSolicitud dialog = new JDBuscarSolicitud();
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
	public JDBuscarSolicitud() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(JDBuscarSolicitud.class.getResource("/img/Logo.png")));
		setTitle("Buscar Solicitud");
		setBounds(100, 100, 574, 379);
		
		lblNewLabel = new JLabel("IDSolicitud:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtIdSolicitud = new JTextField();
		txtIdSolicitud.addKeyListener(this);
		txtIdSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdSolicitud.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtIdSolicitud, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(283)
							.addComponent(btnOk)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
							.addGap(12))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(txtIdSolicitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnOk))
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblListarSolicitudes = new JTable();
		tblListarSolicitudes.addMouseListener(this);
		tblListarSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tblListarSolicitudes);
		getContentPane().setLayout(groupLayout);
		
		model.addColumn("IDSolicitud");
		model.addColumn("IDTipoSolicitud");
		model.addColumn("IDEmpleado");
		
		model.addColumn("Fecha");
		tblListarSolicitudes.setModel(model);
		listarSolicitud();

	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtIdSolicitud) {
			keyReleasedTxtIdSolicitud(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtIdSolicitud(KeyEvent e) {
		listarSolicitud();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblListarSolicitudes) {
			mouseClickedTblListarSolicitudes(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	private void listarSolicitud() {
		model.setRowCount(0);
		ArrayList<Solicitud> listarSolicitudes= gSol.listarSolicitudes();
		for (Solicitud solicitud : listarSolicitudes) {
			Object[] fila= {
				solicitud.getIdSolicitud(),
				solicitud.getTipoSolicitud(),
				solicitud.getIdEmple(),
				solicitud.getFecha()
			};
			model.addRow(fila);
		}
	}
	protected void mouseClickedTblListarSolicitudes(MouseEvent e) {
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		int fila = tblListarSolicitudes.getSelectedRow();
		try {
			enviarDatos(fila);
		} catch (Exception e2) {
			// TODO: handle exception
			//mensajeError("Seleccione una fila");
		}
		this.dispose();
	}

	private void enviarDatos(int fila) {
		// TODO Auto-generated method stub
		String id = tblListarSolicitudes.getValueAt(fila, 0).toString();
		
		if(ventana.equals("Solicitud")) {
			FrmSolicitud.txtIDSolicitud.setText(id);
			FrmSolicitud.id = id;
			FrmSolicitud.obtenerSol();
		}
	}

	private void mensajeError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string,"ERROR !!!", JOptionPane.ERROR_MESSAGE);
	}
}
