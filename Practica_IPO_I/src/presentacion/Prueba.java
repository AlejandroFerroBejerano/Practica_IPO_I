package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.TextArea;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Prueba extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JPanel pnlPruebas;
	private JLabel lblTipo;
	private JTextField txtTipo;
	private JLabel lblFecha;
	private JTextField txtHora;
	private JLabel lblHora;
	private JTextField txtTime;
	private JLabel lblLugar;
	private JTextField textField;
	private static Prueba dialog;
	private JDialog frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new Prueba();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Prueba() {
		addWindowListener(new ThisWindowListener());
		setTitle("Crear Prueba - Fisiplus");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Prueba.class.getResource("/Recursos/hospital-icon.png")));
		setBounds(100, 100, 608, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{259, 0};
		gbl_contentPanel.rowHeights = new int[]{50, 51, 40, 98, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel pnlDatosPersonales = new JPanel();
			pnlDatosPersonales.setBorder(new TitledBorder(null, "Datos Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosPersonales.setLayout(null);
			GridBagConstraints gbc_pnlDatosPersonales = new GridBagConstraints();
			gbc_pnlDatosPersonales.gridheight = 3;
			gbc_pnlDatosPersonales.insets = new Insets(0, 0, 5, 0);
			gbc_pnlDatosPersonales.fill = GridBagConstraints.BOTH;
			gbc_pnlDatosPersonales.gridx = 0;
			gbc_pnlDatosPersonales.gridy = 0;
			contentPanel.add(pnlDatosPersonales, gbc_pnlDatosPersonales);
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(73, 25, 325, 20);
				txtNombre.setColumns(10);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(15, 25, 91, 14);
			}
			pnlDatosPersonales.add(lblNombre);
			pnlDatosPersonales.add(txtNombre);
			{
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(10, 53, 96, 14);
			}
			pnlDatosPersonales.add(lblApellidos);
			{
				lblTelefono = new JLabel("Teléfono:");
				lblTelefono.setBounds(10, 81, 96, 14);
			}
			{
				txtApellido = new JTextField();
				txtApellido.setBounds(73, 53, 325, 20);
				txtApellido.setColumns(10);
			}
			pnlDatosPersonales.add(txtApellido);
			pnlDatosPersonales.add(lblTelefono);
			{
				txtTelefono = new JTextField();
				txtTelefono.setBounds(73, 81, 131, 20);
				txtTelefono.setText("");
				txtTelefono.setColumns(10);
			}
			pnlDatosPersonales.add(txtTelefono);
		}
		{
			pnlPruebas = new JPanel();
			pnlPruebas.setBorder(new TitledBorder(null, "Datos Pruebas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlPruebas.setLayout(null);
			GridBagConstraints gbc_pnlPruebas = new GridBagConstraints();
			gbc_pnlPruebas.fill = GridBagConstraints.BOTH;
			gbc_pnlPruebas.gridx = 0;
			gbc_pnlPruebas.gridy = 3;
			contentPanel.add(pnlPruebas, gbc_pnlPruebas);
			{
				lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(10, 24, 54, 14);
				pnlPruebas.add(lblTipo);
			}
			{
				txtTipo = new JTextField();
				txtTipo.setBounds(69, 21, 160, 20);
				pnlPruebas.add(txtTipo);
				txtTipo.setColumns(10);
			}
			{
				lblFecha = new JLabel("Fecha:");
				lblFecha.setBounds(239, 24, 71, 14);
				pnlPruebas.add(lblFecha);
			}
			{
				txtHora = new JTextField();
				txtHora.setBounds(306, 21, 95, 20);
				pnlPruebas.add(txtHora);
				txtHora.setColumns(10);
			}
			{
				lblHora = new JLabel("Hora:");
				lblHora.setBounds(411, 24, 42, 14);
				pnlPruebas.add(lblHora);
			}
			{
				txtTime = new JTextField();
				txtTime.setBounds(458, 21, 86, 20);
				pnlPruebas.add(txtTime);
				txtTime.setColumns(10);
			}
			{
				lblLugar = new JLabel("Lugar:");
				lblLugar.setBounds(10, 55, 54, 14);
				pnlPruebas.add(lblLugar);
			}
			{
				textField = new JTextField();
				textField.setBounds(69, 52, 475, 20);
				pnlPruebas.add(textField);
				textField.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{60, 107, 0, 193, 0, 0, 0, 0, 0};
			gbl_buttonPane.rowHeights = new int[]{41, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setIcon(new ImageIcon(Prueba.class.getResource("/Recursos/back_button.png")));
				cancelButton.setActionCommand("Cancel");
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_cancelButton.anchor = GridBagConstraints.NORTH;
				gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
				gbc_cancelButton.gridx = 1;
				gbc_cancelButton.gridy = 0;
				buttonPane.add(cancelButton, gbc_cancelButton);
			}
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setIcon(new ImageIcon(Prueba.class.getResource("/Recursos/accept.png")));
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_okButton.anchor = GridBagConstraints.NORTH;
				gbc_okButton.gridx = 7;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			/* Llamamos al panel historial */
			Historial hist = new Historial();
			hist.setVisible(true);
			dialog.dispose();
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Historial hist = new Historial();
			hist.setVisible(true);
			dialog.dispose();
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent arg0) {
			JOptionPane.showMessageDialog(frame, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
