package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Empleado;
import entidad.Logueo;
import mantenimiento.GestionEmpleadoDAO;
import mantenimiento.GestionLogueoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmLogueo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUsu;
	private JPasswordField passContra;
	private JButton btnIngresar;
	
	
	GestionLogueoDAO gLogueoDAO = new GestionLogueoDAO();
	GestionEmpleadoDAO gEm = new GestionEmpleadoDAO();
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogueo frame = new FrmLogueo();
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
	public FrmLogueo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogueo.class.getResource("/img/Logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			//Seleccionar el diseño
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch (Exception e) {
			// TODO: handle exception3
			System.out.println("Sistema no soportable");
		}
		
		lblNewLabel = new JLabel("Logueo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(154, 44, 79, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 84, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(24, 128, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		txtUsu = new JTextField();
		txtUsu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsu.setBounds(154, 81, 146, 20);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		passContra = new JPasswordField();
		passContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passContra.setBounds(154, 128, 146, 20);
		contentPane.add(passContra);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(154, 178, 89, 23);
		contentPane.add(btnIngresar);
		
		lblNewLabel_3 = new JLabel("SISTEMA UPTA");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(105, 11, 174, 32);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/logo_200x200_plomo.png")));
		lblNewLabel_4.setBounds(0, 0, 393, 212);
		contentPane.add(lblNewLabel_4);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		verificarDatos();
	}

	private void verificarDatos() {
		String usu, pass;
		usu = getUsuario();
		pass = getPassword();
		if(usu == null || pass == null) {
			return;
		}else {
			Logueo log= gLogueoDAO.verificarLogueo(usu, pass);
			
			if(log == null) {
				mensajeError("Usuario o Contraseña incorrecta");
			}else {
				mensajeExito("Bienvenido");
				Empleado em = gEm.buscarEmpleados(log.getIdEmple());
				FrmMenuPrincipal.idEmple = em.getIdEmple();
				FrmMenuPrincipal.nomEmpleado = em.getIdEmple();
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
				
				this.dispose();
				
			}
				
		}
	}

	private String getUsuario() {
		String usu = null;
		if(txtUsu.getText().trim().length() == 0) {
			mensajeError("Ingrese el usuario");
		}else {
			usu = txtUsu.getText().trim();
		}
		return usu;
	}

	private void mensajeError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string, "Error !!!", JOptionPane.ERROR_MESSAGE);
	}

	private void mensajeExito(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	private String getPassword() {
		String pass = null;
		if(String.valueOf(passContra.getPassword()).length() == 0) {
			mensajeError("Ingrese la contraseña");
		}else {
			pass = String.valueOf(passContra.getPassword());
		}
		return pass;
	}
}
