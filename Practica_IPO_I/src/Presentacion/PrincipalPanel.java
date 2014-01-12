
package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import Dominio.Paciente;
import Dominio.Persona;
import Persistencia.Conexion;

@SuppressWarnings("unused")
public class PrincipalPanel {

	public JFrame frmFisiplus, frame;
	private CrearPaciente frmCrearPaciente;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnEstadisticas;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmImprimir;
	private JSeparator separator;
	private JMenuItem mntmPacientesAtendidos;
	private JMenuItem mntmLoginDeUsusarios;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAcerca;
	private JPanel pnlUserSession;
	private JLabel lblNombre;
	private JLabel lblUsername;
	private JLabel lblApellidos;
	private JLabel lblIdusuario;
	private JLabel lblTiempoConectado;
	private JLabel lblUserlastname;
	private JLabel lblUserid;
	private JLabel lblUsertimesession;
	private JPanel pnlPrincipalContainer;
	private JTabbedPane tabbedPanelConatiner;
	private JPanel pnlAcciones;
	private JPanel pnlAcciones_Pacientes;
	private JPanel pnlAcciones_Historias;
	private JPanel pnlAcciones_Personal;
	private JButton btnAñadirPacientes;
	private JButton btnConsultarResultados;
	private JButton btnProgramarPruebas;
	private JButton btnConsultarHistorial_1;
	private JButton btnEliminarPaciente;
	private JButton btnConsultarHistorial_2;
	private JButton btnEliminarHistorial;
	private JButton btnAnadirPersonal;
	private JButton btnEditarDatos;
	private JButton btnVerLogPersonal;
	private JButton btnEliminarPersonal;
	private JScrollPane scrollPanePacientes;
	private JScrollPane scrollPaneHistoriales;
	private JScrollPane scrollPanePersonal;
	
	Conexion con;
	private final JTable miTabla = new JTable();
	
	static ArrayList <Paciente> TPacientes;
	static ArrayList TUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalPanel window = new PrincipalPanel();
					window.getFrmFisiplus().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalPanel() {
		TPacientes = leerTodoPacientes();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmFisiplus(new JFrame());
		getFrmFisiplus().addWindowListener(new FrmFisiplusWindowListener());
		getFrmFisiplus().setResizable(false);
		getFrmFisiplus().setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalPanel.class.getResource("/Recursos/hospital-icon.png")));
		getFrmFisiplus().setTitle("Fisiplus");
		getFrmFisiplus().setBounds(100, 100, 800, 600);
		getFrmFisiplus().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			menuBar = new JMenuBar();
			getFrmFisiplus().setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
				{
					mntmImprimir = new JMenuItem("Imprimir");
					mntmImprimir.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Imprimir.png")));
					mnArchivo.add(mntmImprimir);
				}
				{
					separator = new JSeparator();
					mnArchivo.add(separator);
				}
				{
					mntmSalir = new JMenuItem("Salir");
					mntmSalir.addActionListener(new MntmSalirActionListener());
					mntmSalir.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/salir.png")));
					mnArchivo.add(mntmSalir);
				}
			}
			{
				mnEstadisticas = new JMenu("Estadísticas");
				menuBar.add(mnEstadisticas);
				{
					mntmPacientesAtendidos = new JMenuItem("Pacientes Atendidos");
					mntmPacientesAtendidos.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/grafico.png")));
					mnEstadisticas.add(mntmPacientesAtendidos);
				}
				{
					mntmLoginDeUsusarios = new JMenuItem("Login de Ususarios");
					mntmLoginDeUsusarios.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/user_est.png")));
					mnEstadisticas.add(mntmLoginDeUsusarios);
				}
			}
			{
				mnAyuda = new JMenu("Ayuda");
				menuBar.add(mnAyuda);
				{
					mntmAyuda = new JMenuItem("Ayuda");
					mntmAyuda.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Ayuda.png")));
					mnAyuda.add(mntmAyuda);
				}
				{
					mntmAcerca = new JMenuItem("Acerca de ...");
					mntmAcerca.addActionListener(new MntmAcercaActionListener());
					mntmAcerca.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Acerca_de.png")));
					mnAyuda.add(mntmAcerca);
				}
			}
		}
		getFrmFisiplus().getContentPane().setLayout(new BorderLayout(0, 0));
		{
			pnlUserSession = new JPanel();
			pnlUserSession.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sesi\u00F3n Actual", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			getFrmFisiplus().getContentPane().add(pnlUserSession, BorderLayout.NORTH);
			GridBagLayout gbl_pnlUserSession = new GridBagLayout();
			gbl_pnlUserSession.columnWidths = new int[]{85, 116, 85, 116, 85, 85, 102, 0, 0, 0};
			gbl_pnlUserSession.rowHeights = new int[]{0, 0};
			gbl_pnlUserSession.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnlUserSession.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnlUserSession.setLayout(gbl_pnlUserSession);
			{
				lblNombre = new JLabel("Nombre: ");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
				gbc_lblNombre.gridx = 0;
				gbc_lblNombre.gridy = 0;
				pnlUserSession.add(lblNombre, gbc_lblNombre);
			}
			{
				lblUsername = new JLabel("");
				GridBagConstraints gbc_lblUsername = new GridBagConstraints();
				gbc_lblUsername.anchor = GridBagConstraints.WEST;
				gbc_lblUsername.insets = new Insets(0, 0, 0, 5);
				gbc_lblUsername.gridx = 1;
				gbc_lblUsername.gridy = 0;
				pnlUserSession.add(lblUsername, gbc_lblUsername);
			}
			{
				lblApellidos = new JLabel("Apellidos: ");
				GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
				gbc_lblApellidos.insets = new Insets(0, 0, 0, 5);
				gbc_lblApellidos.gridx = 2;
				gbc_lblApellidos.gridy = 0;
				pnlUserSession.add(lblApellidos, gbc_lblApellidos);
			}
			{
				lblUserlastname = new JLabel("");
				GridBagConstraints gbc_lblUserlastname = new GridBagConstraints();
				gbc_lblUserlastname.insets = new Insets(0, 0, 0, 5);
				gbc_lblUserlastname.gridx = 3;
				gbc_lblUserlastname.gridy = 0;
				pnlUserSession.add(lblUserlastname, gbc_lblUserlastname);
			}
			{
				lblIdusuario = new JLabel("ID_Usuario: ");
				GridBagConstraints gbc_lblIdusuario = new GridBagConstraints();
				gbc_lblIdusuario.insets = new Insets(0, 0, 0, 5);
				gbc_lblIdusuario.gridx = 4;
				gbc_lblIdusuario.gridy = 0;
				pnlUserSession.add(lblIdusuario, gbc_lblIdusuario);
			}
			{
				lblUserid = new JLabel("");
				GridBagConstraints gbc_lblUserid = new GridBagConstraints();
				gbc_lblUserid.insets = new Insets(0, 0, 0, 5);
				gbc_lblUserid.gridx = 5;
				gbc_lblUserid.gridy = 0;
				pnlUserSession.add(lblUserid, gbc_lblUserid);
			}
			{
				lblTiempoConectado = new JLabel("Tiempo Conectado: ");
				GridBagConstraints gbc_lblTiempoConectado = new GridBagConstraints();
				gbc_lblTiempoConectado.insets = new Insets(0, 0, 0, 5);
				gbc_lblTiempoConectado.gridx = 6;
				gbc_lblTiempoConectado.gridy = 0;
				pnlUserSession.add(lblTiempoConectado, gbc_lblTiempoConectado);
			}
			{
				lblUsertimesession = new JLabel("");
				GridBagConstraints gbc_lblUsertimesession = new GridBagConstraints();
				gbc_lblUsertimesession.insets = new Insets(0, 0, 0, 5);
				gbc_lblUsertimesession.gridx = 7;
				gbc_lblUsertimesession.gridy = 0;
				pnlUserSession.add(lblUsertimesession, gbc_lblUsertimesession);
				
				CargarUsuario();
			}
		}
		{
			pnlPrincipalContainer = new JPanel();
			pnlPrincipalContainer.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(240, 240, 240), new Color(255, 255, 255), new Color(105, 105, 105), new Color(160, 160, 160)), new LineBorder(new Color(180, 180, 180), 5)));
			getFrmFisiplus().getContentPane().add(pnlPrincipalContainer, BorderLayout.CENTER);
			pnlPrincipalContainer.setLayout(null);
			{
				tabbedPanelConatiner = new JTabbedPane(JTabbedPane.TOP);
				tabbedPanelConatiner.setBounds(10, 11, 764, 264);
				pnlPrincipalContainer.add(tabbedPanelConatiner);
				{
					scrollPanePacientes = new JScrollPane();
					scrollPanePacientes.addComponentListener(new ScrollPaneComponentListener());
					tabbedPanelConatiner.addTab("Pacientes", new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Pacientes.png")), scrollPanePacientes, null);
					{
						
						miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						miTabla.setRowHeight(30);
						//NUEVO SETMODEL
						MiModeloTabla modeloTabla = new MiModeloTabla();
						miTabla.setModel(modeloTabla);
						ListSelectionModel rowSM = miTabla.getSelectionModel();
						
						rowSM.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								ListSelectionModel lsm = (ListSelectionModel) e.getSource();
									MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
									int n= miTabla.getSelectedRow();
								}
						});
						scrollPanePacientes.setViewportView(miTabla);
						int id = 0;
						for(int i = 0; i < TPacientes.size(); i++){
							Object[] fila= {id, TPacientes.get(i).getApellidos(), TPacientes.get(i).getNombre(), TPacientes.get(i).getDni()};
							modeloTabla.aniadeFila(fila);
							id++;
						}
					}
				}
				{
					scrollPaneHistoriales = new JScrollPane();
					scrollPaneHistoriales.addComponentListener(new ScrollPaneHistorialesComponentListener());
					tabbedPanelConatiner.addTab("Historiales", new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Folder Open.png")), scrollPaneHistoriales, null);
				}
				{
					scrollPanePersonal = new JScrollPane();
					scrollPanePersonal.addComponentListener(new ScrollPanePersonalComponentListener());
					tabbedPanelConatiner.addTab("Personal", new ImageIcon(PrincipalPanel.class.getResource("/Recursos/doctor.png")), scrollPanePersonal, null);
				}
			}
			{
				pnlAcciones = new JPanel();
				pnlAcciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
				pnlAcciones.setBounds(10, 286, 764, 184);
				pnlPrincipalContainer.add(pnlAcciones);
				pnlAcciones.setLayout(new CardLayout(0, 0));
				{
					pnlAcciones_Pacientes = new JPanel();
					pnlAcciones.add(pnlAcciones_Pacientes, "Acciones_Pacientes");
					{
						btnAñadirPacientes = new JButton("Añadir Pacientes");
						btnAñadirPacientes.setBounds(10, 109, 185, 41);
						btnAñadirPacientes.addActionListener(new BtnAñadirPacientesActionListener());
						pnlAcciones_Pacientes.setLayout(null);
						btnAñadirPacientes.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Add_patient.png")));
						pnlAcciones_Pacientes.add(btnAñadirPacientes);
					}
					{
						btnConsultarResultados = new JButton("Consultar Resultados");
						btnConsultarResultados.setBounds(557, 11, 185, 41);
						btnConsultarResultados.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/See_icon.png")));
						pnlAcciones_Pacientes.add(btnConsultarResultados);
					}
					{
						btnConsultarHistorial_1 = new JButton("Consultar Historial");
						btnConsultarHistorial_1.setBounds(10, 11, 185, 41);
						btnConsultarHistorial_1.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Folder Open.png")));
						pnlAcciones_Pacientes.add(btnConsultarHistorial_1);
					}
					{
						btnProgramarPruebas = new JButton("Programar Pruebas");
						btnProgramarPruebas.setBounds(281, 11, 185, 41);
						btnProgramarPruebas.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/ico-calendar.png")));
						pnlAcciones_Pacientes.add(btnProgramarPruebas);
					}
					{
						btnEliminarPaciente = new JButton("Eliminar Paciente");
						btnEliminarPaciente.addActionListener(new BtnEliminarPacienteActionListener());
						btnEliminarPaciente.setBounds(557, 109, 185, 41);
						btnEliminarPaciente.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Light_Delete_user.png")));
						pnlAcciones_Pacientes.add(btnEliminarPaciente);
					}
				}
				{
					pnlAcciones_Historias = new JPanel();
					pnlAcciones.add(pnlAcciones_Historias, "Acciones_Historias");
					pnlAcciones_Historias.setLayout(null);
					{
						btnConsultarHistorial_2 = new JButton("Consultar Historial");
						btnConsultarHistorial_2.setBounds(10, 11, 185, 41);
						btnConsultarHistorial_2.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Folder Open.png")));
						pnlAcciones_Historias.add(btnConsultarHistorial_2);
					}
					{
						btnEliminarHistorial = new JButton("Eliminar Historial");
						btnEliminarHistorial.setBounds(557, 109, 185, 41);
						btnEliminarHistorial.addActionListener(new BtnEliminarHistorialActionListener());
						btnEliminarHistorial.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Trash.png")));
						pnlAcciones_Historias.add(btnEliminarHistorial);
					}
				}
				{
					pnlAcciones_Personal = new JPanel();
					pnlAcciones.add(pnlAcciones_Personal, "Acciones_Personal");
					pnlAcciones_Personal.setLayout(null);
					{
						btnAnadirPersonal = new JButton("Añadir Personal");
						btnAnadirPersonal.addActionListener(new BtnAnadirPersonalActionListener());
						btnAnadirPersonal.setBounds(10, 109, 185, 41);
						btnAnadirPersonal.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Add_patient.png")));
						pnlAcciones_Personal.add(btnAnadirPersonal);
					}
					{
						btnEditarDatos = new JButton("Editar Datos");
						btnEditarDatos.setBounds(281, 11, 185, 41);
						btnEditarDatos.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/File_edit.png")));
						pnlAcciones_Personal.add(btnEditarDatos);
					}
					{
						btnVerLogPersonal = new JButton("Ver Log Personal");
						btnVerLogPersonal.setBounds(10, 11, 185, 41);
						btnVerLogPersonal.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/See_icon.png")));
						pnlAcciones_Personal.add(btnVerLogPersonal);
					}
					{
						btnEliminarPersonal = new JButton("Eliminar Personal");
						btnEliminarPersonal.setBounds(557, 109, 185, 41);
						btnEliminarPersonal.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/Recursos/Light_Delete_user.png")));
						pnlAcciones_Personal.add(btnEliminarPersonal);
					}
				}
			}
		}
	}

	public JFrame getFrmFisiplus() {
		return frmFisiplus;
	}

	public void setFrmFisiplus(JFrame frmFisiplus) {
		this.frmFisiplus = frmFisiplus;
	}

	private class BtnAñadirPacientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			/* Llamamos al panel crear paciente */
			CrearPaciente paciente = new CrearPaciente();
			paciente.getFrmCrearPaciente().setVisible(true);
			
			/* Ocultamos el formulario principal */
			frmFisiplus.setVisible(false);
		}
	}
	private class BtnEliminarHistorialActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}
	private class FrmFisiplusWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent arg0) {
		 JOptionPane.showMessageDialog(frame, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación", JOptionPane.INFORMATION_MESSAGE);
			getFrmFisiplus().dispose();
		}
	}
	private class MntmAcercaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String autor = "\n Alejandro Ferro Bejereano \n                     y \n Javier García Ceca";
			JOptionPane.showMessageDialog(frame, "            Fisiplus v 1.0 \n Realizado por: " + autor, "Acerca de ...",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class BtnAnadirPersonalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* Llamamos al panel crear personal */
			CrearFisioterapeuta fisio = new CrearFisioterapeuta();
			fisio.getFrmCrearFisioterapeuta().setVisible(true);
			
			/* Ocultamos el formulario principal */
			frmFisiplus.setVisible(false);
		}
	}
	private class ScrollPaneComponentListener extends ComponentAdapter {
		public void componentShown(ComponentEvent e) {
			CardLayout cl = (CardLayout)(pnlAcciones.getLayout());
			cl.show(pnlAcciones, "Acciones_Pacientes");
			
		}
	}
	private class ScrollPaneHistorialesComponentListener extends ComponentAdapter {
		public void componentShown(ComponentEvent e) {
			CardLayout cl = (CardLayout)(pnlAcciones.getLayout());
			cl.show(pnlAcciones, "Acciones_Historias");
		}
	}
	private class ScrollPanePersonalComponentListener extends ComponentAdapter {
		public void componentShown(ComponentEvent e) {
			CardLayout cl = (CardLayout)(pnlAcciones.getLayout());
			cl.show(pnlAcciones, "Acciones_Personal");
		}
	}
	private class BtnEliminarPacienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			int n= miTabla.getSelectedRow();
			System.out.println(n);
			if (n != -1){
				EliminarPaciente(n);
				modeloTabla.eliminaFila(miTabla.getSelectedRow());
			}
			modeloTabla.fireTableDataChanged();
			

		}
	}
	private static ArrayList <Paciente> leerTodoPacientes(){
		Conexion con = new Conexion();
		ResultSet pacientes = null;
		
		try{
			PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM Pacientes");
			pacientes = pstm.executeQuery();
			TPacientes  = new ArrayList <Paciente>();
			
			int i = 0;
			
			while(pacientes.next()){
				Paciente paciente = new Paciente(pacientes.getString("Nombre"), pacientes.getString("Apellidos"), pacientes.getString("DNI"), pacientes.getString("Sexo"), 
						pacientes.getString("CorreoElectronico"), pacientes.getString("FechaNacimiento"), pacientes.getString("Telefono"), 
						pacientes.getString("Direccion"), pacientes.getString("Poblacion"), 
						pacientes.getString("CP"), pacientes.getString("Mutua"), pacientes.getString("FechaAlta"), pacientes.getString("NumTarjeta"));
				
				TPacientes.add(paciente);
			}
			pacientes.close();
			con.desconectar();
			
		}catch(SQLException e){
			System.out.println(e);
		}
		
		return TPacientes;
	}

	private void EliminarPaciente(int n){
		Conexion con = new Conexion();
		MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
		Object aux = modeloTabla.getValueAt(n, 1);
		try{
			Statement pstm = con.getConnection().createStatement();
			pstm.executeUpdate("DELETE FROM Pacientes WHERE Apellidos = '"+aux+"'");
			pstm.close();
		}catch(SQLException e){
			System.out.println("Error al borrar de la base de datos: "+e);
		}
		con.desconectar();
	}

	private void CargarUsuario(){
		Conexion con = new Conexion();
		ResultSet usuarios = null;
		ResultSet per = null;
		
		try{
			PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM Registro");
			usuarios = pstm.executeQuery();
			TUsuarios = new ArrayList();
			
			int i = 0;
			
			while(usuarios.next()){
				TUsuarios.add(usuarios.getString("Fisio"));
			}
			
			/* Mostramos el ultimo usuario logueado */
			String userActual = (String) TUsuarios.get(TUsuarios.size()-2);
			lblUsertimesession.setText(userActual);
			
			PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT * FROM Fisioterapeutas WHERE Usuario = '"+userActual+"'");
			per = pstm2.executeQuery();
			
			while(per.next()){			
				TUsuarios.add(per.getString("Nombre"));
				TUsuarios.add(per.getString("Apellidos"));
				TUsuarios.add(per.getString("Id"));
			}
			
			String nombreActual = (String) TUsuarios.get(TUsuarios.size()-3);
			String apellidoActual = (String) TUsuarios.get(TUsuarios.size()-2);
			String idActual = (String) TUsuarios.get(TUsuarios.size()-1);
			
			lblUsername.setText(nombreActual);
			lblUserlastname.setText(apellidoActual);
			lblUserid.setText(idActual);
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
