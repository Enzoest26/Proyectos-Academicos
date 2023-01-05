package vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import entidad.CabeceraBoleta;
import entidad.DetalleBoleta;
import entidad.TipoBoleta;
import mantenimiento.GestionTipoBoletaDAO;
import mantenimiento.GestionVentaDAO;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.invoke.StringConcatFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class FrmBoletasAutomaticas extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField txtNumBoleta;
	private JLabel lblNewLabel_1;
	private JTextField txtFechaActual;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	public static JTextField txtEstudiante;
	private JButton btnBuscar;
	private JLabel lblNewLabel_3;
	public static JTextField txtCodigo;
	private JLabel lblNewLabel_4;
	public static JTextField txtDNI;
	private JPanel panel_2;
	private JLabel lblNewLabel_5;
	private JComboBox cmbTipoBoleta;
	private JPanel panel_3;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane;
	private JTextArea txtDescripcion;
	private JLabel lblNewLabel_7;
	private JTextField txtPrecio;
	private JButton btnGenerar;
	private JButton btnLimpiar;

	GestionVentaDAO gVent = new GestionVentaDAO();
	GestionTipoBoletaDAO gTBol = new GestionTipoBoletaDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoletasAutomaticas frame = new FrmBoletasAutomaticas();
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
	public FrmBoletasAutomaticas() {
		setFrameIcon(new ImageIcon(FrmBoletasAutomaticas.class.getResource("/img/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(192, 192, 192), 3), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		
		lblNewLabel = new JLabel("N\u00B0 Boleta:");
		lblNewLabel.setBounds(10, 22, 69, 14);
		panel_1.add(lblNewLabel);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setText((String) null);
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setColumns(10);
		txtNumBoleta.setBounds(89, 19, 174, 20);
		panel_1.add(txtNumBoleta);
		
		lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setBounds(10, 65, 69, 14);
		panel_1.add(lblNewLabel_1);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setText("2022-06-22");
		txtFechaActual.setEditable(false);
		txtFechaActual.setColumns(10);
		txtFechaActual.setBounds(89, 62, 86, 20);
		panel_1.add(txtFechaActual);
		
		panel = new JPanel();
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(192, 192, 192), 3), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		
		lblNewLabel_2 = new JLabel("Estudiante:");
		
		txtEstudiante = new JTextField();
		txtEstudiante.setEditable(false);
		txtEstudiante.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(FrmBoletasAutomaticas.class.getResource("/img/lupita_16px.png")));
		
		lblNewLabel_3 = new JLabel("C\u00F3digo: ");
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		
		lblNewLabel_4 = new JLabel("DNI:");
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 421, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(txtEstudiante, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
							.addGap(23)
							.addComponent(btnBuscar))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCodigo, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDNI, 79, 79, 79)
							.addGap(21)))
					.addGap(12))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 101, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(txtEstudiante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)))
		);
		panel.setLayout(gl_panel);
		
		panel_2 = new JPanel();
		
		panel_3 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
									.addGap(5))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 241, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		
		btnGenerar = new JButton("GENERAR");
		btnGenerar.addActionListener(this);
		btnGenerar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(153)
					.addComponent(btnGenerar)
					.addPreferredGap(ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(165))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGenerar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLimpiar))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		lblNewLabel_5 = new JLabel("Tipo de Boleta: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cmbTipoBoleta = new JComboBox();
		cmbTipoBoleta.addActionListener(this);
		cmbTipoBoleta.setModel(new DefaultComboBoxModel(new String[] {"...."}));
		cmbTipoBoleta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_6 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane = new JScrollPane();
		
		lblNewLabel_7 = new JLabel("Precio: ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtPrecio =  new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecio.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cmbTipoBoleta, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
							.addGap(12))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(534, Short.MAX_VALUE))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(cmbTipoBoleta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(7))
		);
		
		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
		
		numBoleta();
		mostraCombo();
		txtFechaActual.setText(obtenerFechaActual());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == cmbTipoBoleta) {
			actionPerformedCmbTipoBoleta(e);
		}
		if (e.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		JDListaAlumnos jBuscar = new JDListaAlumnos();
		jBuscar.setVisible(true);
		JDListaAlumnos.ventana = "Automaticas";
		FrmMenuPrincipal.escritorio.add(jBuscar);
		jBuscar.toFront();
	}
	private void numBoleta() {
		txtNumBoleta.setText(gVent.numBoleta());
	}
	
	protected void actionPerformedBtnGenerar(ActionEvent e) {
		
		String numBoleta, nombre, tipo, detalle,fecha,codigo,dni;
		double precio;
		numBoleta = getnumBoleta();
		codigo =getcodigo();
		nombre = getNombre();
		tipo = getTipo();
		detalle = getDetalle();
		precio = getPrecio();
		fecha = getFecha();
		dni = getDni();
		if(numBoleta == null || codigo == null || nombre == null || tipo == null || fecha == null || dni == null) {
			return;
		}else {
			CabeceraBoleta cb = new CabeceraBoleta();
			cb.setIdAlum(codigo);
			cb.setIdTipoBol(gTBol.obtenerID(tipo).getIdTipoBol());
			cb.setFechaBoleta(fecha);
			cb.setPrecioBoleta(precio);
			cb.setIdBoleta(numBoleta);
			cb.setIdEmple("TB0001");
			int ok = gVent.realzarBoletaAuto(cb);
			if(ok == 0) {
				mensajeError("Error en generar la boleta");
			}
			else {
				mensajeExito("Boleta Generada");
				exportarPDF(numBoleta, nombre, fecha, codigo,dni,tipo, detalle, precio);
				limpiar();
			}
			
		}
		
	}
	private void mensajeExito(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string,"Information", JOptionPane.INFORMATION_MESSAGE);
	}

	private void mensajeError(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string,"Error !!!", JOptionPane.INFORMATION_MESSAGE);
	}

	private String getDni() {
		// TODO Auto-generated method stub
		return txtDNI.getText().trim();
	}

	private String getcodigo() {
		// TODO Auto-generated method stub
		return txtCodigo.getText().trim();
	}

	private String getFecha() {
		// TODO Auto-generated method stub
		return txtFechaActual.getText().trim();
	}

	private double getPrecio() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	private String getDetalle() {
		return txtDescripcion.getText().trim();
	}

	private String getTipo() {
		return cmbTipoBoleta.getSelectedItem().toString();
	}

	private String getNombre() {
		// TODO Auto-generated method stub
		return txtEstudiante.getText().trim();
	}

	private String getnumBoleta() {
		// TODO Auto-generated method stub
		return txtNumBoleta.getText().trim();
	}

	private String obtenerFechaActual() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	private void exportarPDF(String idBoleta, String nombre, String fecha, String codigo, String dni,String tipo,String detalle, double prec) {
		String nArchivo = "reportes/Boleta" + "_" + idBoleta +"_"+tipo+".pdf";
		try {
			Document plantilla = new Document();
			FileOutputStream fos = new FileOutputStream(nArchivo);
			
			PdfWriter pdfWriter = PdfWriter.getInstance(plantilla, fos);
			plantilla.open();
			
			plantilla.left(100f);
			plantilla.top(150f);
			
			PdfPTable table = new PdfPTable(2);
			table.setWidths(new int [] {150, 100});
			PdfPCell cell1 = new PdfPCell();
			
			
			
			cell1.setBorderColor(BaseColor.WHITE);
		
			//////////////////////////////////////////////////////////// 
			///////////DATOS
			PdfPTable datos = new PdfPTable(1);
			datos.setWidthPercentage(100f);
			
			PdfPCell nomEmpresa = new PdfPCell(
					new Paragraph("UPTA", FontFactory.getFont("arial", 48,com.itextpdf.text.Font.BOLD))
					);
			nomEmpresa.setBorderColor(BaseColor.WHITE);
			nomEmpresa.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			PdfPCell blanco = new PdfPCell();
			blanco.setFixedHeight(50f);
			blanco.setBorderColor(BaseColor.WHITE);
			PdfPCell codi = new PdfPCell(
					new Paragraph("Codigo: " + codigo, FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL))
					);
			codi.setBorderColor(BaseColor.WHITE);
			codi.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell estudia = new PdfPCell(
					new Paragraph("ESTUDIANTE: " + nombre, FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL))
					);
			estudia.setBorderColor(BaseColor.WHITE);
			estudia.setHorizontalAlignment(Element.ALIGN_BOTTOM);
		
			
			PdfPCell Ddni = new PdfPCell(
					new Paragraph("DNI: " + dni + "\n" + "Fecha: " + fecha, FontFactory.getFont("arial",8,com.itextpdf.text.Font.NORMAL))
					);
			Ddni.setBorderColor(BaseColor.WHITE);
			Ddni.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			datos.addCell(nomEmpresa);
			datos.addCell(blanco);
			datos.addCell(codi);
			datos.addCell(estudia);
			datos.addCell(Ddni);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.addElement(datos);
			
			///////////////////////////////////////////////////////////////
			PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
			cell2.setBorderColor(BaseColor.WHITE);
			//cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			//cell2.setVerticalAlignment(Element.ALIGN_RIGHT);
			PdfPTable tablita = new PdfPTable(1);
			tablita.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell2.addElement(tablita);
		
			PdfPCell titulo = new PdfPCell(new Paragraph("BOLETA",FontFactory.getFont(
					"arial", 28, com.itextpdf.text.Font.BOLD)));
			
			//titulo.addElement(p);
			titulo.setFixedHeight(45f);
			titulo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
			
			//titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell descrip = new PdfPCell(
					new Paragraph("Electronica", FontFactory.getFont("arial", 15))
					);
			descrip.setFixedHeight(30f);
			descrip.setVerticalAlignment(Element.ALIGN_MIDDLE);
			descrip.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell numBoleta = new PdfPCell(
					new Paragraph(idBoleta, FontFactory.getFont("arial"))
					);
			
			numBoleta.setFixedHeight(25f);
			numBoleta.setVerticalAlignment(Element.ALIGN_MIDDLE);
			numBoleta.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			tablita.addCell(titulo);
			tablita.addCell(descrip);
			tablita.addCell(numBoleta);
			/////////////////////////////////////////////////
			
            table.addCell(cell1);
            table.addCell(cell2);
            plantilla.add(table);
            ///TERMINO EL ENCABEZADO
            Paragraph p = new Paragraph(" ");
            plantilla.add(p);
            p = new Paragraph(" ");
            plantilla.add(p);
            p = new Paragraph(" ");
            plantilla.add(p);
            //CONTENIDO
            
            PdfPTable conte = new PdfPTable(3);
            conte.setWidths(new int[] {60,200,100});
            //encabezado contenido
            PdfPCell cant = new PdfPCell(
            		new Paragraph("CANTIDAD")
            		);
            cant.setFixedHeight(25f);
            cant.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cant.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell des = new PdfPCell(
            		new Paragraph("DESCRIPCION")
            		);
            des.setFixedHeight(25f);
            des.setVerticalAlignment(Element.ALIGN_MIDDLE);
			des.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell precio = new PdfPCell(
            		new Paragraph("PRECIO")
            		);
            precio.setFixedHeight(25f);
            precio.setVerticalAlignment(Element.ALIGN_MIDDLE);
			precio.setHorizontalAlignment(Element.ALIGN_CENTER);
            conte.addCell(cant);
            conte.addCell(des);
            conte.addCell(precio);
            ////////////////////////////////
            PdfPCell cantDes = new PdfPCell(
            		new Paragraph("1")
            		);
            cantDes.setFixedHeight(150f);
            cantDes.setPaddingTop(20f);

			cantDes.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell desDes = new PdfPCell(
            		);
            p = new Paragraph(tipo);
            desDes.addElement(p);
            p = new Paragraph(detalle,FontFactory.getFont("arial", 8, com.itextpdf.text.Font.ITALIC, BaseColor.GRAY));
            desDes.addElement(p);
            desDes.setFixedHeight(150f);
            desDes.setPaddingTop(15f);
            desDes.setPaddingLeft(10f);
            
            PdfPCell precDes = new PdfPCell(
            		new Paragraph(String.valueOf(prec))
            		);
            precDes.setPaddingTop(20f);
            precDes.setFixedHeight(500f);
     
			precDes.setHorizontalAlignment(Element.ALIGN_CENTER);
            conte.addCell(cantDes);
            conte.addCell(desDes);
            conte.addCell(precDes);
            
            //////////////////////////////precio
            
            PdfPCell nada1 = new PdfPCell();
            nada1.setFixedHeight(30f);
            PdfPCell nada2 = new PdfPCell(new Paragraph("TOTAL: "));
            nada2.setFixedHeight(30f);
            nada2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            PdfPCell mostrarprecio= new PdfPCell(new Paragraph(String.valueOf(prec)));
            mostrarprecio.setHorizontalAlignment(Element.ALIGN_CENTER);

            mostrarprecio.setFixedHeight(30f);
        
            
            conte.addCell(nada1);
            conte.addCell(nada2);
            conte.addCell(mostrarprecio);
            
            
            plantilla.add(conte);
			plantilla.close();
			Desktop.getDesktop().open(new File(nArchivo));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage() );
		}
	}

	private void mostraCombo() {
		ArrayList<TipoBoleta> mostraTipo = gTBol.listarBoleta();
		for (TipoBoleta tipoBoleta : mostraTipo) {
			if(tipoBoleta.getIdTipoBol().equals("BTI001")) {
				continue;
			}else {
				cmbTipoBoleta.addItem(tipoBoleta.getDescripBol());
			}
			
		}
	}
	
	protected void actionPerformedCmbTipoBoleta(ActionEvent e) {
		String nombre = cmbTipoBoleta.getSelectedItem().toString();
		mostrarPrecio(nombre);
	}
	private void mostrarPrecio(String nombre) {
		TipoBoleta tipo = gTBol.obtenerID(nombre);
		txtPrecio.setText(""+tipo.getPrecio());
	}
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}
	private void limpiar() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtDNI.setText("");
		txtEstudiante.setText("");
		txtFechaActual.setText(obtenerFechaActual());
		txtNumBoleta.setText(gVent.numBoleta());
		txtPrecio.setText("");
	}
}

