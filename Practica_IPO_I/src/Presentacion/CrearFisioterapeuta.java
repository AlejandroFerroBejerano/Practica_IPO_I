package presentacion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Dimension;


public class CrearFisioterapeuta {

	private JFrame frmCrearFisioterapeuta;
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
	private final JFormattedTextField ftxtDNI = new JFormattedTextField();
	private final JLabel lblSexo = new JLabel("Sexo:");
	private final JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
	private final JFormattedTextField ftxtFechaNacimiento = new JFormattedTextField();
	private final JLabel lblTelefono = new JLabel("Teléfono:");
	private final JFormattedTextField ftxtTelefono = new JFormattedTextField();
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
	private final JLabel lblNumeroColegiado = new JLabel("Nº Colegiado:");
	private final JTextField txtMutua = new JTextField();
	private final JLabel lblFechaAlta = new JLabel("Fecha de Alta:");
	private final JFormattedTextField ftxtFechaAlta = new JFormattedTextField();
	private final JLabel lblNumeroTarjeta = new JLabel("Número Tarjeta:");
	private final JTextField txtNumeroTarjeta = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearFisioterapeuta window = new CrearFisioterapeuta();
					window.frmCrearFisioterapeuta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearFisioterapeuta() {
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
		txtEmail.setBounds(135, 187, 159, 20);
		txtEmail.setColumns(10);
		txtApellidos.setBounds(135, 61, 159, 20);
		txtApellidos.setColumns(10);
		txtNombre.setBounds(135, 29, 159, 20);
		txtNombre.setColumns(10);
		frmCrearFisioterapeuta = new JFrame();
		frmCrearFisioterapeuta.setResizable(false);
		frmCrearFisioterapeuta.setIconImage(Toolkit.getDefaultToolkit().getImage(CrearFisioterapeuta.class.getResource("/Recursos/hospital-icon.png")));
		frmCrearFisioterapeuta.setTitle("Crear Fisioterapeuta - Fisiplus");
		frmCrearFisioterapeuta.setBounds(100, 100, 860, 460);
		frmCrearFisioterapeuta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearFisioterapeuta.getContentPane().setLayout(null);
		{
			pnlDatos.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatos.setBounds(10, 11, 516, 300);
			frmCrearFisioterapeuta.getContentPane().add(pnlDatos);
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
			lblFoto.setBounds(354, 29, 100, 125);
			pnlDatos.add(lblFoto);
		}
		{
			btnExaminar.setIcon(new ImageIcon(CrearFisioterapeuta.class.getResource("/Recursos/cargarFoto.png")));
			btnExaminar.setBounds(354, 176, 136, 42);
			pnlDatos.add(btnExaminar);
		}
		{
			lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDNI.setBounds(61, 94, 64, 14);
			pnlDatos.add(lblDNI);
		}
		{
			ftxtDNI.setBounds(135, 91, 81, 20);
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
			ftxtFechaNacimiento.setBounds(135, 218, 81, 20);
			pnlDatos.add(ftxtFechaNacimiento);
		}
		{
			lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefono.setBounds(73, 252, 52, 14);
			pnlDatos.add(lblTelefono);
		}
		{
			ftxtTelefono.setBounds(135, 249, 81, 20);
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
			pnlDireccion.setBorder(new TitledBorder(null, "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDireccion.setBounds(536, 11, 308, 153);
			frmCrearFisioterapeuta.getContentPane().add(pnlDireccion);
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
			pnlMutua.setBounds(536, 175, 308, 136);
			frmCrearFisioterapeuta.getContentPane().add(pnlMutua);
		}
		pnlMutua.setLayout(null);
		{
			lblNumeroColegiado.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNumeroColegiado.setBounds(0, 33, 98, 14);
			pnlMutua.add(lblNumeroColegiado);
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
			ftxtFechaAlta.setBounds(108, 61, 93, 20);
			pnlMutua.add(ftxtFechaAlta);
		}
		{
			lblNumeroTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNumeroTarjeta.setBounds(0, 96, 98, 14);
			pnlMutua.add(lblNumeroTarjeta);
		}
		{
			pnlMutua.add(txtNumeroTarjeta);
		}
		{
			btnCancelar.setMinimumSize(new Dimension(63, 23));
			btnCancelar.setMaximumSize(new Dimension(63, 23));
			btnCancelar.setIcon(new ImageIcon(CrearFisioterapeuta.class.getResource("/Recursos/back_button.png")));
			btnCancelar.setBounds(10, 366, 133, 41);
			frmCrearFisioterapeuta.getContentPane().add(btnCancelar);
		}
		{
			btnAceptar.setIcon(new ImageIcon(CrearFisioterapeuta.class.getResource("/Recursos/accept.png")));
			btnAceptar.setBounds(711, 366, 133, 41);
			frmCrearFisioterapeuta.getContentPane().add(btnAceptar);
		}
	}
}
