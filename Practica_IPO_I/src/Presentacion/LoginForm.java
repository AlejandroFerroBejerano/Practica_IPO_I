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

public class LoginForm {

	private JFrame frmIdentificacinFisiplus;
	private final JTextField txtUsuario = new JTextField();
	private final JTextField txtPassword = new JTextField();
	private final JLabel lblUsuario = new JLabel("Usuario");
	private final JLabel lblPassword = new JLabel("Contraseña");
	private final JLabel lblIdioma = new JLabel("Idioma:");
	private final JLabel lblLogo = new JLabel("Logo");
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
		txtUsuario.setBounds(20, 111, 190, 20);
		txtUsuario.setColumns(10);
		frmIdentificacinFisiplus = new JFrame();
		frmIdentificacinFisiplus.setResizable(false);
		frmIdentificacinFisiplus.setTitle("Identificación - Fisiplus");
		frmIdentificacinFisiplus.setBounds(100, 100, 236, 338);
		frmIdentificacinFisiplus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdentificacinFisiplus.getContentPane().setLayout(null);
		{
			lblUsuario.setBounds(20, 93, 46, 14);
			frmIdentificacinFisiplus.getContentPane().add(lblUsuario);
		}
		{
			frmIdentificacinFisiplus.getContentPane().add(txtUsuario);
		}
		{
			lblPassword.setBounds(20, 153, 74, 14);
			frmIdentificacinFisiplus.getContentPane().add(lblPassword);
		}
		{
			txtPassword.setColumns(10);
			txtPassword.setBounds(20, 170, 190, 20);
			frmIdentificacinFisiplus.getContentPane().add(txtPassword);
		}
		{
			lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIdioma.setHorizontalTextPosition(SwingConstants.LEADING);
			lblIdioma.setBounds(30, 211, 46, 14);
			frmIdentificacinFisiplus.getContentPane().add(lblIdioma);
		}
		{
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setBounds(10, 11, 215, 71);
			frmIdentificacinFisiplus.getContentPane().add(lblLogo);
		}
		{
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "English"}));
			comboBox.setBounds(86, 208, 124, 20);
			frmIdentificacinFisiplus.getContentPane().add(comboBox);
		}
		{
			btnEntrar.addActionListener(new BtnEntrarActionListener());
			btnEntrar.setBounds(65, 266, 96, 23);
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
			
			PreparedStatement pstm = con.getConnection().prepareStatement("Select count(1) as total FROM Tabla1");
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
			PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Usuario FROM Tabla1");
			ResultSet usr = pstm.executeQuery();
			
			PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT Password FROM Tabla1");
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
				PrincipalPanel panl = new PrincipalPanel();
				panl.frmFisiplus.setVisible(true);
				
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
