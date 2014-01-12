package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import Persistencia.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.FlowLayout;

public class LoginForm {

	private JFrame frmIdentificacinFisiplus;
	private final JTextField txtUsuario = new JTextField();
	private final JTextField txtPassword = new JTextField();
	private final JLabel lblUsuario = new JLabel("Usuario");
	private final JLabel lblPassword = new JLabel("Contraseña");
	private final JLabel lblIdioma = new JLabel("Idioma:");
	private final JLabel lblLogo = new JLabel("");
	private final JComboBox comboBox = new JComboBox();
	private final JButton btnEntrar = new JButton("Entrar");
	
	Conexion con;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmIdentificacinFisiplus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtUsuario.setBounds(303, 26, 120, 20);
		txtUsuario.setColumns(10);
		frmIdentificacinFisiplus = new JFrame();
		frmIdentificacinFisiplus.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/Recursos/hospital-icon.png")));
		frmIdentificacinFisiplus.setResizable(false);
		frmIdentificacinFisiplus.setTitle("Identificación - Fisiplus");
		frmIdentificacinFisiplus.setBounds(100, 100, 439, 295);
		frmIdentificacinFisiplus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdentificacinFisiplus.getContentPane().setLayout(null);
		{
			lblUsuario.setBounds(219, 29, 56, 14);
			frmIdentificacinFisiplus.getContentPane().add(lblUsuario);
		}
		{
			frmIdentificacinFisiplus.getContentPane().add(txtUsuario);
		}
		{
			lblPassword.setBounds(219, 83, 74, 14);
			frmIdentificacinFisiplus.getContentPane().add(lblPassword);
		}
		{
			txtPassword.setBounds(303, 80, 120, 20);
			txtPassword.setColumns(10);
			frmIdentificacinFisiplus.getContentPane().add(txtPassword);
		}
		{
			lblIdioma.setBounds(219, 132, 56, 14);
			lblIdioma.setHorizontalTextPosition(SwingConstants.LEADING);
			frmIdentificacinFisiplus.getContentPane().add(lblIdioma);
		}
		{
			lblLogo.setBounds(10, 0, 210, 256);
			lblLogo.setIcon(new ImageIcon(LoginForm.class.getResource("/Recursos/icon-lock.png")));
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			frmIdentificacinFisiplus.getContentPane().add(lblLogo);
		}
		{
			comboBox.setBounds(303, 129, 82, 20);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "English"}));
			frmIdentificacinFisiplus.getContentPane().add(comboBox);
		}
		{
			btnEntrar.setBounds(246, 201, 141, 41);
			btnEntrar.setIcon(new ImageIcon(LoginForm.class.getResource("/Recursos/Login_in.png")));
			btnEntrar.addActionListener(new BtnEntrarActionListener());
			frmIdentificacinFisiplus.getContentPane().add(btnEntrar);
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(comprobarUsuario()){
				//MOSTRAMOS LA SIGUIENTE PANTALLA
			}
		}
	}
	
	private boolean comprobarUsuario(){
		boolean existe = false;
		int registros = 0;
		Conexion con = new Conexion();
		try{
			
			PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Fisioterapeutas");
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("total");
			res.close();
		}catch (SQLException e){
			System.out.println(e);
		}
		Object[][] data = new String[registros][2];
		
		/* Realizamos la consulta a la BD */		
		try{	
			PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Usuario FROM Fisioterapeutas");
			ResultSet usr = pstm.executeQuery();
			
			PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT Password FROM Fisioterapeutas");
			ResultSet pwd = pstm2.executeQuery();
			
			int i = 0;
			String user = "";
			String password = "";
			
			while(usr.next() && pwd.next()){
				user = usr.getString("Usuario");
				password = pwd.getString("Password");
				data[i][0] = user;
				data[i][1] = password;
				i++;
			}
			if (user.equals(txtUsuario.getText()) && password.equals(txtPassword.getText())){
				/* Llamamos al panel principal */
				try{
					Conexion con2 = new Conexion();
					Statement pstmRegistro = con2.getConnection().createStatement();
					pstmRegistro.executeUpdate("INSERT INTO Registro (Fisio) VALUES ('"+user+"')");
					pstmRegistro.close();
				}catch(SQLException e){
					System.out.println(e);
				}
				PrincipalPanel panl = new PrincipalPanel();
				panl.getFrmFisiplus().setVisible(true);
				
				/* Ocultamos el formulario de ingreso */
				frmIdentificacinFisiplus.setVisible(false);
				
				usr.close();
				pwd.close();
			}else{
				JOptionPane.showMessageDialog(btnEntrar, "Datos erróneos");
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		
		return existe;
	}
}
