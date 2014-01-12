package Presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;

import java.awt.FlowLayout;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Persistencia.Conexion;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;


public class CrearPaciente {

	private JFrame frmCrearPaciente,frame;
	private final JPanel pnlDatos = new JPanel();
	private final JPanel pnlDireccion = new JPanel();
	private final JPanel pnlMutua = new JPanel();
	private final JButton btnCancelar = new JButton("Cancelar");
	private final JButton btnAceptar = new JButton("Aceptar");
	private final JLabel lblNombre = new JLabel("Nombre:");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblApellidos = new JLabel("Apellidos:");
	private final JTextField txtApellidos = new JTextField();
	private final JLabel lblFoto = new JLabel("New label");
	private final JButton btnExaminar = new JButton("Examinar...");
	private final JLabel lblDNI = new JLabel("DNI:");
	
	/* QUITAMOS EL FINAL PARA MODIFICARLO */
	private JFormattedTextField ftxtDNI = new JFormattedTextField();
	
	private final JLabel lblSexo = new JLabel("Sexo:");
	private final JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
	
	/* QUITAMOS EL FINAL PARA MODIFICARLO */
	private  JFormattedTextField ftxtFechaNacimiento = new JFormattedTextField();
	
	private final JLabel lblTelefono = new JLabel("Teléfono:");
	
	/* QUITAMOS EL FINAL PARA MODIFICARLO */
	private JFormattedTextField ftxtTelefono = new JFormattedTextField();
	
	private final JLabel lblCorreoElectronico = new JLabel("Correo electrónico:");
	private final JTextField txtEmail = new JTextField();
	private final JRadioButton rdbtnHombre = new JRadioButton("Hombre");
	private final JRadioButton rdbtnMujer = new JRadioButton("Mujer");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblDireccion = new JLabel("Dirección:");
	private final JTextField txtDireccion = new JTextField();
	private final JLabel lblPoblacion = new JLabel("Población:");
	private final JTextField txtPoblacion = new JTextField();
	private final JLabel lblProvincia = new JLabel("Provincia:");
	private final JTextField txtProvincia = new JTextField();
	private final JLabel lblCP = new JLabel("C.P.:");
	private final JTextField txtCP = new JTextField();
	private final JLabel lblMutua = new JLabel("Mutua:");
	private final JTextField txtMutua = new JTextField();
	private final JLabel lblFechaAlta = new JLabel("Fecha de Alta:");
	
	/* QUITAMOS EL FINAL PARA MODIFICARLO */
	private JFormattedTextField ftxtFechaAlta = new JFormattedTextField();
	
	private final JLabel lblNumeroTarjeta = new JLabel("Número Tarjeta:");
	private final JTextField txtNumeroTarjeta = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPaciente window = new CrearPaciente();
					window.getFrmCrearPaciente().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtNumeroTarjeta.setBounds(108, 93, 93, 20);
		txtNumeroTarjeta.setColumns(10);
		txtMutua.setBounds(108, 30, 190, 20);
		txtMutua.setColumns(10);
		txtCP.setBounds(82, 122, 112, 20);
		txtCP.setColumns(10);
		txtProvincia.setBounds(82, 91, 112, 20);
		txtProvincia.setColumns(10);
		txtPoblacion.setBounds(82, 60, 216, 20);
		txtPoblacion.setColumns(10);
		txtDireccion.setBounds(82, 26, 216, 20);
		txtDireccion.setColumns(10);
		txtEmail.setBounds(135, 187, 176, 20);
		txtEmail.setColumns(10);
		txtApellidos.setBounds(135, 61, 176, 20);
		txtApellidos.setColumns(10);
		txtNombre.setBounds(135, 29, 176, 20);
		txtNombre.setColumns(10);
		
		/*
		 * FORMATOS DE LOS CAMPOS 
		 */
		/* Modificamos la actuacion del Jformat en el telefono */
		MaskFormatter formatoTlfno;
		try{
			formatoTlfno = new MaskFormatter("'(###')' ### '- ### '- ###");
			formatoTlfno.setPlaceholderCharacter('*');
			ftxtTelefono = new JFormattedTextField(formatoTlfno);
		}catch (ParseException e){
			e.printStackTrace();
		}
		
		/* Modificamos la actuacion del Jformat en el dni */
		MaskFormatter formatoDNI;
		try{
			formatoDNI = new MaskFormatter("########' -U");
			formatoDNI.setPlaceholderCharacter('_');
			ftxtDNI = new JFormattedTextField(formatoDNI);
		}catch (ParseException e){
			e.printStackTrace();
		}
		/* Modificamos la actuacion del Jformat en la fecha de nacimiento */
		MaskFormatter formatoFechaNacimiento;
		try{
			formatoFechaNacimiento = new MaskFormatter("## / ## / ####");
			formatoFechaNacimiento.setPlaceholderCharacter('_');
			ftxtFechaNacimiento = new JFormattedTextField(formatoFechaNacimiento);
		}catch (ParseException e){
			e.printStackTrace();
		}
		
		MaskFormatter formatoFechaAlta;
		try{
			formatoFechaAlta = new MaskFormatter("## / ## / ####");
			formatoFechaAlta.setPlaceholderCharacter('_');
			ftxtFechaAlta = new JFormattedTextField(formatoFechaAlta);
		}catch (ParseException e){
			e.printStackTrace();
		}
		
		setFrmCrearPaciente(new JFrame());
		getFrmCrearPaciente().setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPaciente.class.getResource("/Recursos/hospital-icon.png")));
		getFrmCrearPaciente().setTitle("Crear Paciente - Fisiplus");
		getFrmCrearPaciente().setBounds(100, 100, 860, 460);
		getFrmCrearPaciente().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmCrearPaciente().getContentPane().setLayout(null);
		{
			pnlDatos.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatos.setBounds(10, 11, 506, 337);
			getFrmCrearPaciente().getContentPane().add(pnlDatos);
		}
		pnlDatos.setLayout(null);
		{
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setBounds(73, 32, 52, 14);
			pnlDatos.add(lblNombre);
		}
		{
			pnlDatos.add(txtNombre);
		}
		{
			lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblApellidos.setBounds(61, 64, 64, 14);
			pnlDatos.add(lblApellidos);
		}
		{
			pnlDatos.add(txtApellidos);
		}
		{
			lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
			lblFoto.setBounds(365, 29, 100, 125);
			pnlDatos.add(lblFoto);
		}
		{
			lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDNI.setBounds(61, 94, 64, 14);
			pnlDatos.add(lblDNI);
		}
		{
			ftxtDNI.setBounds(135, 91, 126, 20);
			pnlDatos.add(ftxtDNI);
		}
		{
			lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSexo.setBounds(79, 128, 46, 14);
			pnlDatos.add(lblSexo);
		}
		{
			lblFechaNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFechaNacimiento.setBounds(20, 221, 105, 14);
			pnlDatos.add(lblFechaNacimiento);
		}
		{
			ftxtFechaNacimiento.setBounds(135, 218, 126, 20);
			pnlDatos.add(ftxtFechaNacimiento);
		}
		{
			lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefono.setBounds(73, 252, 52, 14);
			pnlDatos.add(lblTelefono);
		}
		{
			ftxtTelefono.setBounds(135, 249, 126, 20);
			pnlDatos.add(ftxtTelefono);
		}
		{
			lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCorreoElectronico.setBounds(10, 190, 115, 14);
			pnlDatos.add(lblCorreoElectronico);
		}
		{
			pnlDatos.add(txtEmail);
		}
		{
			buttonGroup.add(rdbtnHombre);
			rdbtnHombre.setBounds(135, 124, 109, 23);
			pnlDatos.add(rdbtnHombre);
		}
		{
			buttonGroup.add(rdbtnMujer);
			rdbtnMujer.setBounds(135, 150, 109, 23);
			pnlDatos.add(rdbtnMujer);
		}
		{
			btnExaminar.setBounds(341, 177, 143, 41);
			pnlDatos.add(btnExaminar);
			btnExaminar.setIcon(new ImageIcon(CrearPaciente.class.getResource("/Recursos/cargarFoto.png")));
		}
		{
			pnlDireccion.setBorder(new TitledBorder(null, "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDireccion.setBounds(526, 11, 308, 173);
			getFrmCrearPaciente().getContentPane().add(pnlDireccion);
		}
		pnlDireccion.setLayout(null);
		{
			lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDireccion.setBounds(10, 29, 62, 14);
			pnlDireccion.add(lblDireccion);
		}
		{
			pnlDireccion.add(txtDireccion);
		}
		{
			lblPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPoblacion.setBounds(10, 63, 62, 14);
			pnlDireccion.add(lblPoblacion);
		}
		{
			pnlDireccion.add(txtPoblacion);
		}
		{
			lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
			lblProvincia.setBounds(10, 94, 62, 14);
			pnlDireccion.add(lblProvincia);
		}
		{
			pnlDireccion.add(txtProvincia);
		}
		{
			lblCP.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCP.setBounds(26, 125, 46, 14);
			pnlDireccion.add(lblCP);
		}
		{
			pnlDireccion.add(txtCP);
		}
		{
			pnlMutua.setBorder(new TitledBorder(null, "Mutua", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlMutua.setBounds(526, 212, 308, 136);
			getFrmCrearPaciente().getContentPane().add(pnlMutua);
		}
		pnlMutua.setLayout(null);
		{
			lblMutua.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMutua.setBounds(52, 33, 46, 14);
			pnlMutua.add(lblMutua);
		}
		{
			pnlMutua.add(txtMutua);
		}
		{
			lblFechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFechaAlta.setBounds(10, 64, 88, 14);
			pnlMutua.add(lblFechaAlta);
		}
		{
			lblNumeroTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNumeroTarjeta.setBounds(0, 96, 98, 14);
			pnlMutua.add(lblNumeroTarjeta);
		}
		{
			pnlMutua.add(txtNumeroTarjeta);
		}
		ftxtFechaAlta.setBounds(108, 61, 126, 20);
		pnlMutua.add(ftxtFechaAlta);
		{
			btnCancelar.addActionListener(new BtnCancelarActionListener());
			btnCancelar.setMinimumSize(new Dimension(63, 23));
			btnCancelar.setMaximumSize(new Dimension(63, 23));
			btnCancelar.setIcon(new ImageIcon(CrearPaciente.class.getResource("/Recursos/back_button.png")));
			btnCancelar.setBounds(10, 359, 133, 41);
			getFrmCrearPaciente().getContentPane().add(btnCancelar);
		}
		{
			btnAceptar.addActionListener(new BtnAceptarActionListener());
			btnAceptar.setIcon(new ImageIcon(CrearPaciente.class.getResource("/Recursos/accept.png")));
			btnAceptar.setMinimumSize(new Dimension(63, 23));
			btnAceptar.setMaximumSize(new Dimension(63, 23));
			btnAceptar.setBounds(701, 359, 133, 41);
			getFrmCrearPaciente().getContentPane().add(btnAceptar);
		}
	}

	public JFrame getFrmCrearPaciente() {
		return frmCrearPaciente;
	}

	public void setFrmCrearPaciente(JFrame frmCrearPaciente) {
		this.frmCrearPaciente = frmCrearPaciente;
		frmCrearPaciente.addWindowListener(new FrmCrearPacienteWindowListener());
	}
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* Llamamos al panel principal */
			PrincipalPanel panel = new PrincipalPanel();
			panel.getFrmFisiplus().setVisible(true);
			frmCrearPaciente.dispose();
		}
	}
	private class FrmCrearPacienteWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(frame, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String apellidos = txtApellidos.getText();
			String nombre = txtNombre.getText();
			String dni = ftxtDNI.getText();
			String correo = txtEmail.getText();
			String fechaNacimiento = ftxtFechaNacimiento.getText();
			String sexo = "Hombre";
			String telefono = ftxtTelefono.getText();
			String direccion = txtDireccion.getText();
			String poblacion = txtPoblacion.getText();
			String cp = txtCP.getText();
			String mutua = txtMutua.getText();
			String fechaAlta = ftxtFechaAlta.getText();
			String numTarjeta = txtNumeroTarjeta.getText();
			
			crearPaciente(apellidos, nombre, dni, sexo, correo, fechaNacimiento, telefono, direccion, poblacion, cp, mutua, fechaAlta, numTarjeta);
		}
	}
	
	private void crearPaciente(String apellidos, String nombre, String dni, String sexo, String correo, String fechaNacimiento, String telefono, String direccion,
			String poblacion, String cp, String mutua, String fechaAlta, String numTarjeta){
		Conexion con = new Conexion();
		
		try{
			Statement pstm = con.getConnection().createStatement();
			pstm.executeUpdate("INSERT INTO Pacientes (Nombre, Apellidos, DNI, Sexo, CorreoElectronico, FechaNacimiento, Telefono,"
					+ "Direccion, Poblacion, CP, Mutua, FechaAlta, NumTarjeta) VALUES ('"+nombre+"','"+apellidos+"','"+dni+"','"+sexo+"','"+correo+"','"+fechaNacimiento+"','"
					+telefono+"','"+direccion+"','"+poblacion+"','"+cp+"','"+mutua+"','"+fechaAlta+"','"+numTarjeta+"')");
			pstm.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		con.desconectar();
	}
}
