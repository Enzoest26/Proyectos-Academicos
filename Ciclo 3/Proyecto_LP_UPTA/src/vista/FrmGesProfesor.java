package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entidad.Distrito;
import entidad.Profesor;
import entidad.Sede;
import mantenimiento.GestionDistritoDAO;
import mantenimiento.GestionProfesorDAO;
import mantenimiento.GestionSedeDAO;
import utils.Validaciones;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class FrmGesProfesor extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//Default model
	DefaultTableModel model = new DefaultTableModel();
	GestionDistritoDAO gDis = new GestionDistritoDAO();
	GestionSedeDAO gSede = new GestionSedeDAO();
	GestionProfesorDAO gProf = new GestionProfesorDAO();
	
	private int index;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtIdProf;
	private JLabel lblNewLabel_2;
	private JTextField txtNomProf;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtApeProf;
	private JTextField txtDniProf;
	private JTextField txtEdadProf;
	private JTextField txtNacionalidad;
	private JComboBox cmbSexo;
	private JDateChooser dcFechaNac;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JComboBox cmbDistrito;
	private JTextField txtDireccionProf;
	private JLabel lblNewLabel_11;
	private JTextField txtCorreoProf;
	private JLabel lblNewLabel_12;
	private JTextField txtCelular;
	private JLabel lblNewLabel_14;
	private JComboBox cmbSede;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGesProfesor frame = new FrmGesProfesor();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmGesProfesor() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(FrmGesProfesor.class.getResource("/img/Logo.png")));
	//	setFocusable(false);
		//setIconifiable(true);
	
		
	//	setMaximizable(true);
	
		
		//setClosable(true);
		
		setTitle("Mantenimiento Profesor");
		setBounds(100, 100, 774, 399);
		
		lblNewLabel = new JLabel("PROFESORES");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		
		lblNewLabel_1 = new JLabel("Id Profesor:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		txtIdProf = new JTextField();
		txtIdProf.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombres:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		txtNomProf = new JTextField();
		txtNomProf.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		lblNewLabel_4 = new JLabel("Dni:");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		lblNewLabel_5 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		lblNewLabel_6 = new JLabel("Edad:");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		lblNewLabel_7 = new JLabel("Nacionalidad:");
		lblNewLabel_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		lblNewLabel_8 = new JLabel("Sexo:");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		txtApeProf = new JTextField();
		txtApeProf.setColumns(10);
		
		txtDniProf = new JTextField();
		txtDniProf.setColumns(10);
		
		txtEdadProf = new JTextField();
		txtEdadProf.setColumns(10);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		
		cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"...", "Masculino ", "Femenino"}));
		
		dcFechaNac = new JDateChooser();
		dcFechaNac.setDateFormatString("yyyy-MM-dd");
		
		
		lblNewLabel_9 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		lblNewLabel_10 = new JLabel("Distrito:");
		lblNewLabel_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		cmbDistrito = new JComboBox();
		cmbDistrito.setModel(new DefaultComboBoxModel(new String[] {"..."}));
		
		txtDireccionProf = new JTextField();
		txtDireccionProf.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Email:");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		txtCorreoProf = new JTextField();
		txtCorreoProf.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Celular:");
		lblNewLabel_12.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Sede:");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		cmbSede = new JComboBox();
		cmbSede.setModel(new DefaultComboBoxModel(new String[] {"..."}));
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(FrmGesProfesor.class.getResource("/img/profesor_Reg.png")));
		btnAgregar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmGesProfesor.class.getResource("/img/ajuste.png")));
		btnModificar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmGesProfesor.class.getResource("/img/eliminar.png")));
		btnEliminar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(FrmGesProfesor.class.getResource("/img/papelera-de-reciclaje.png")));
		btnLimpiar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(321)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtIdProf, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(164)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(dcFechaNac, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtNomProf, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtEdadProf, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(253))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtApeProf, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_7)
					.addGap(10)
					.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(141))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(txtDniProf, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(164)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(cmbSexo, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(233, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(cmbDistrito, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtDireccionProf, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtCelular, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(93))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtCorreoProf, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(cmbSede, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(46)
					.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(93))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txtIdProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_5))
						.addComponent(dcFechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(txtNomProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_6))
						.addComponent(txtEdadProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txtApeProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_7))
						.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtDniProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_8))
						.addComponent(cmbSexo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_10))
						.addComponent(cmbDistrito, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9)
						.addComponent(txtDireccionProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_12))
						.addComponent(txtCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_11))
						.addComponent(txtCorreoProf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_14))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(cmbSede, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
		);
		getContentPane().setLayout(groupLayout);
		
	
		mostrarComboxBox();

}
/*
	private void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
	}*/
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	
	
	private void mensajeError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void mensajeExito(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
	}
	
	private void mostrarComboxBox() {
		mostrarDistrito();
		mostrarSede();
	}
	
	private void mostrarSede() {
		// TODO Auto-generated method stub
		ArrayList<Sede> mostraSede = gSede.listarSede();
		for (Sede sede : mostraSede) {
			cmbSede.addItem(sede.getNombre());
		}
	}

	private void mostrarDistrito() {
		ArrayList<Distrito> mostrarDistrito = gDis.listarDistritos();
		for (Distrito dis : mostrarDistrito) {
			cmbDistrito.addItem(dis.getNombre());
		}
		
	}

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregarProfesor();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificarProfesor();
	}


	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarProfesor();
	}


	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtIdProf.setText("");
		txtNomProf.setText("");
		txtApeProf.setText("");
		txtDniProf.setText("");
		txtNacionalidad.setText("");
		txtEdadProf.setText("");
		txtDireccionProf.setText("");
		txtCelular.setText("");
		txtCorreoProf.setText("");
	}
	
	
	
	
	private void agregarProfesor() {

		int ok = registrarDatosProf();
		if(ok == -1) {
			mensajeError("Error al registrar los datos");
			return;
		}else {
			mensajeExito("Registro existoso");
		}
		
	
	}

	
	private int registrarDatosProf() {
		String idProf, nomProf, apeProf, dniProf, nacionalidad,fechaNacProf, sexo, direccion, correo,distrito, celProf, nombreSede;
		int edad;
		int retornar;
		idProf = getIdProf();
		nomProf = getNombreProf();
		apeProf = getApellidoProf();
		dniProf = getDniProf();
		nacionalidad = getNacionalidad();
		fechaNacProf = getFechaNa();
		sexo = getSexo();
		direccion = getDireccion();
		correo =getCorreo();
		distrito = getCiudad();
		celProf = getCelProf();
		edad = getEdad();	
		nombreSede = getSede();
		
		
		
		if( idProf == null || nomProf == null ||apeProf == null || dniProf == null || edad == 0 ||sexo == null ||direccion == null|| nacionalidad == null || correo == null || distrito == null || celProf == null || fechaNacProf == null || nombreSede == null) {
			retornar = -1;
			return retornar;
		}else {
			Profesor prof = new Profesor();
			ArrayList<Distrito> obtenerIDistritos = gDis.buscarID(distrito);
			
			prof.setIdProf(idProf);
			prof.setNomProf(nomProf);
			prof.setApeProf(apeProf);
			prof.setDniProf(dniProf);
			prof.setFechaNac(fechaNacProf);
			prof.setDomici(direccion);
			prof.setSexo(sexo);
			prof.setCel(celProf);
			prof.setEdad(edad);
			prof.setIdDistrito(obtenerIDistritos.get(0).getIdDistrito());
			prof.setCorreo(correo);
			prof.setIdSede(gSede.buscarSede(nombreSede).getIdSede());
			
			retornar = gProf.registrar(prof);
			
		}
		return retornar;
	}



	private String getSede() {
		String texto = null;
		if(cmbSede.getSelectedIndex() == 0) {
			mensajeError("Selecione la sede");
		}else {
			texto = cmbSede.getSelectedItem().toString();
		}
		return texto;
	}

	private int getEdad() {
		int edad = 0;
		if(txtEdadProf.getText().trim().length() == 0) {
			mensajeError("Ingrese la Edad");
		}else {
			edad = Integer.parseInt(txtEdadProf.getText().trim());
		}
		return edad;
	}

	private String getCelProf() {
		String cel = null;
		if(txtCelular.getText().trim().length() == 0 ) {
			mensajeError("Ingrese su celular");
			txtCelular.requestFocus();
		}else if(txtCelular.getText().trim().matches(Validaciones.CELULAR)){
			cel = txtCelular.getText();
		}else {
			mensajeError("Formato Incorrecto del número del celular");
			txtCelular.setText("");
			txtCelular.requestFocus();
		}
		return cel;
	}

	private String getCiudad() {
		String ciudad = null;
		if(cmbDistrito.getSelectedIndex() == 0) {
			mensajeError("Seleccione el distrito");
			ciudad = null;
		}else {
			ciudad = cmbDistrito.getSelectedItem().toString();
		}
		return ciudad;
	}

	private String getCorreo() {
		String correoProf = null;
		
		if  (txtCorreoProf.getText().trim().length() == 0) {
			mensajeError("Ingrese su correo");
			txtCorreoProf.requestFocus();
		} else if (txtCorreoProf.getText().trim().matches(Validaciones.CORREO)) {
			correoProf = txtCorreoProf.getText().trim();
		} else {
			mensajeError("Formato Incorrecto del Correo electrónico");
			txtCorreoProf.setText("");
			txtCorreoProf.requestFocus();
		}
		
		return correoProf;
		
	}

	private String getDireccion() {
		String texto = null;
		if(txtDireccionProf.getText().trim().length() == 0) {
			mensajeError("Ingrese la direccion");
		}else {
			texto = txtDireccionProf.getText();
		}
		return texto;
	}

	private String getSexo() {
		String sexo = null;
		if(cmbSexo.getSelectedIndex() == 0) {
			mensajeError("Seleccione el sexo");
		}else {
			sexo = cmbSexo.getSelectedItem().toString();
		}
		return sexo;
	}

	private String getFechaNa() {
		String fechaNac = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			fechaNac = sdf.format(dcFechaNac.getDate());
		} catch (NullPointerException e) {
			mensajeError("Ingrese la fecha correctamente, formato (año/mes/dia)");
		}
		return fechaNac;
	}

	private String getNacionalidad() {
		String texto = null;
		if(txtNacionalidad.getText().trim().length() == 0) {
			mensajeError("Ingrese la nacionalidad");
		}else {
			texto = txtNacionalidad.getText();
		}
		return texto;
	}

	private String getDniProf() {

		String dni = null;
		if(txtDniProf.getText().trim().length() == 0 ) {
			mensajeError("Ingrese el DNI");
			txtDniProf.requestFocus();
		}else if(txtDniProf.getText().trim().matches(Validaciones.DNI)){
			dni = txtDniProf.getText();
		}else {
			mensajeError("Formato Incorrecto del DNI");
			txtDniProf.setText("");
			txtDniProf.requestFocus();
		}
		return dni;
	
	}

	private String getApellidoProf() {
		String apelliProf = null;
		if(txtApeProf.getText().trim().length() == 0 ) {
			mensajeError("Ingrese el apellido");
			txtApeProf.requestFocus();
		}else if(txtApeProf.getText().trim().matches(Validaciones.APELLIDO)){
			apelliProf = txtApeProf.getText().trim();
			
		}else {
			mensajeError("Formato incorrecto en APELLIDO");
			txtApeProf.setText("");
			
		}
		return apelliProf;
	}

	private String getNombreProf() {
		String nomProf = null;
		if(txtNomProf.getText().trim().length() == 0 ) {
			mensajeError("Ingrese el nombre");
			txtNomProf.requestFocus();
		}else if(txtNomProf.getText().trim().matches(Validaciones.NOMBRE)){
			nomProf = txtNomProf.getText().trim();
		}else {
			mensajeError("Formato Incorrecto en NOMBRE");
			txtNomProf.setText("");
			txtNomProf.requestFocus();
		}
		return nomProf;
	}

	private String getIdProf() {
		String idProf = null;
		if(txtIdProf.getText().trim().length() == 0) {
			mensajeError("Ingrese el Id Profesor");
			txtIdProf.requestFocus();
		}else if(txtIdProf.getText().trim().matches(Validaciones.ID_PROFESOR)){
			idProf = txtIdProf.getText().trim();
		//	System.out.println(idProf);
		}else {
			mensajeError("Formato Incorrecto del ID PROFESOR");
			txtIdProf.setText("");
			txtIdProf.requestFocus();
		}
		return idProf;
	}

	private void modificarProfesor() {
		

		String idProf, nomProf, apeProf, dniProf, nacionalidad,fechaNacProf, sexo, direccion, correo,distrito, celProf, nombreSede;
		int edad;
		int retornar;
		idProf = getIdProf();
		nomProf = getNombreProf();
		apeProf = getApellidoProf();
		dniProf = getDniProf();
		nacionalidad = getNacionalidad();
		fechaNacProf = getFechaNa();
		sexo = getSexo();
		direccion = getDireccion();
		correo =getCorreo();
		distrito = getCiudad();
		celProf = getCelProf();
		edad = getEdad();
		
		nombreSede = getSede();
		
		
		if( idProf == null || nomProf == null ||apeProf == null || dniProf == null || edad == 0 ||sexo == null ||direccion == null|| nacionalidad == null || correo == null || distrito == null || celProf == null || fechaNacProf == null || nombreSede == null) {
			retornar = -1;
			return;
		}else {
			Profesor prof = new Profesor();
			ArrayList<Distrito> obtenerIDistritos = gDis.buscarID(distrito);
			
			
			prof.setNomProf(nomProf);
			prof.setApeProf(apeProf);
			prof.setDniProf(dniProf);
			prof.setFechaNac(fechaNacProf);
			prof.setDomici(direccion);
			prof.setSexo(sexo);
			prof.setCel(celProf);
			prof.setEdad(edad);
			prof.setIdDistrito(obtenerIDistritos.get(0).getIdDistrito());
			prof.setCorreo(correo);
			prof.setIdSede(gSede.buscarSede(nombreSede).getIdSede());
			prof.setIdProf(idProf);
			
			
			int ok = gProf.modificar(prof);
			if (ok == 0) {
				mensajeError("Proceso no realizado");
			} else {
				listarProfesor();
				mensajeExito("Actualización realizado correctamente");
			}
			
		}
			
	}
	
	
	
	private void eliminarProfesor() {
		
		String idProf;
		int opcion;
		
		
		idProf = getIdProf();
		
		//validar
		if (idProf == null) {
			return;
		} else {
			opcion = JOptionPane.showConfirmDialog(this, "¿Seguro de eliminar?", "Sistema", JOptionPane.YES_NO_OPTION);
			
			//Ejecutar el proceso de eliminar
			int ok = gProf.eliminar(idProf);
			//validar el resultado del proceso
			if ( ok == 0) {
				mensajeError("Id no existe");
			} else {
				mensajeExito("Profesor eliminado");
			}
		}
	
	}
	
	
	private void listarProfesor() {

		model.setRowCount(0);
		ArrayList<Profesor> listarProfesor = gProf.listarProfesor();
		if(listarProfesor.size() == 0) {
			mensajeError("No hay profesores");
		}else {
			for (Profesor pro : listarProfesor) {
				Object fila[]= {
						
						pro.getIdProf(),
						pro.getNomProf(),
						pro.getApeProf(),
						pro.getDniProf(),
						pro.getFechaNac(),
						pro.getEdad(),
						pro.getCel(),
						pro.getDomici(),
						pro.getIdDistrito(),
						pro.getCorreo(),
						pro.getSexo(),
						pro.getIdSede(),
						
				};
				model.addRow(fila);
			}
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
