package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JToolBar;

import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class Historial extends JDialog {
	
	private MiAreadeDibujo miAreadeDibujo;
	private ImageIcon imagen;
	int modo = -1;
	private final int RECTANGULO = 3;
	private final int ARROW = 4;
	private Toolkit toolkit;
	private Image imagRectangulo;
	private Cursor cursorRectangulo;
	private Image imagArrow;
	private static Cursor cursorArrow;
	private int x, y;
	
	private JDialog cat;
	private JDialog frame;
	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton okButton;
	private JPanel pnllUserdata;
	private JPanel pnlTest;
	private JLabel lblIdHistorial;
	private JTextField txtIdHistorial;
	private JLabel lblNombre;
	private JTextField txtNombreHistorial;
	private JLabel lblApellidos;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPaneObservaciones;
	private JTextArea textAreaObservaciones;
	private JScrollPane scrollPanePruebas;
	private JList list;
	private JButton btnAadirPrueba;
	private JPanel pnlAccionesPruebas;
	private JButton btnBorrarPrueba;
	private JToolBar toolBar;
	private JButton btnResaltar;
	private JButton btnLimpiar;
	private JButton btnExplorar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList listPruebas;
	private DefaultListModel MiModeloLista = new DefaultListModel();
	private JButton btnArrow;
	private JButton btnGuardar;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Historial dialog = new Historial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Historial() {
		
		setTitle("Historial - Fisiplus");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historial.class.getResource("/Recursos/hospital-icon.png")));
		setBounds(100, 100, 860, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{179, 210, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{69, 51, 0, 84, 102, 50, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			pnllUserdata = new JPanel();
			pnllUserdata.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnllUserdata.setLayout(null);
			GridBagConstraints gbc_pnllUserdata = new GridBagConstraints();
			gbc_pnllUserdata.gridheight = 2;
			gbc_pnllUserdata.gridwidth = 2;
			gbc_pnllUserdata.insets = new Insets(0, 0, 5, 5);
			gbc_pnllUserdata.fill = GridBagConstraints.BOTH;
			gbc_pnllUserdata.gridx = 0;
			gbc_pnllUserdata.gridy = 0;
			contentPanel.add(pnllUserdata, gbc_pnllUserdata);
			{
				lblIdHistorial = new JLabel("ID Historial:");
				lblIdHistorial.setHorizontalAlignment(SwingConstants.RIGHT);
				lblIdHistorial.setBounds(10, 26, 87, 14);
				pnllUserdata.add(lblIdHistorial);
			}
			{
				txtIdHistorial = new JTextField();
				txtIdHistorial.setEditable(false);
				txtIdHistorial.setBounds(131, 26, 77, 20);
				pnllUserdata.add(txtIdHistorial);
				txtIdHistorial.setColumns(10);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombre.setBounds(20, 56, 77, 14);
				pnllUserdata.add(lblNombre);
			}
			{
				txtNombreHistorial = new JTextField();
				txtNombreHistorial.setEditable(false);
				txtNombreHistorial.setBounds(131, 56, 212, 20);
				pnllUserdata.add(txtNombreHistorial);
				txtNombreHistorial.setColumns(10);
			}
			{
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
				lblApellidos.setBounds(20, 87, 77, 14);
				pnllUserdata.add(lblApellidos);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setBounds(131, 87, 212, 20);
				pnllUserdata.add(textField);
				textField.setColumns(10);
			}
			{
				textArea = new JTextArea();
				textArea.setLineWrap(true);
				textArea.setBorder(new TitledBorder(null, "Comentarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				textArea.setBounds(52, 303, 291, 67);
				pnllUserdata.add(textArea);
			}
		}
		{
			pnlTest = new JPanel();
			pnlTest.setBorder(new TitledBorder(null, "Editor - Vualizador Pruebas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_pnlTest = new GridBagConstraints();
			gbc_pnlTest.gridheight = 6;
			gbc_pnlTest.fill = GridBagConstraints.BOTH;
			gbc_pnlTest.gridx = 2;
			gbc_pnlTest.gridy = 0;
			contentPanel.add(pnlTest, gbc_pnlTest);
			GridBagLayout gbl_pnlTest = new GridBagLayout();
			gbl_pnlTest.columnWidths = new int[]{0, 0, 0};
			gbl_pnlTest.rowHeights = new int[]{46, 0, 0};
			gbl_pnlTest.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlTest.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			pnlTest.setLayout(gbl_pnlTest);
			{
				toolBar = new JToolBar();
				toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
				toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				GridBagConstraints gbc_toolBar = new GridBagConstraints();
				gbc_toolBar.anchor = GridBagConstraints.NORTH;
				gbc_toolBar.fill = GridBagConstraints.HORIZONTAL;
				gbc_toolBar.gridwidth = 2;
				gbc_toolBar.insets = new Insets(0, 0, 5, 0);
				gbc_toolBar.gridx = 0;
				gbc_toolBar.gridy = 0;
				pnlTest.add(toolBar, gbc_toolBar);
				{
					btnExplorar = new JButton("");
					btnExplorar.addActionListener(new BtnExplorarActionListener());
					btnExplorar.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/Folder Open.png")));
					toolBar.add(btnExplorar);
				}
				{
					btnResaltar = new JButton("");
					btnResaltar.addActionListener(new BtnResaltarActionListener());
					btnResaltar.setHorizontalAlignment(SwingConstants.RIGHT);
					btnResaltar.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/Rectangular-2-32.png")));
					toolBar.add(btnResaltar);
				}
				{
					btnLimpiar = new JButton("");
					btnLimpiar.addActionListener(new BtnLimpiarActionListener());
					{
						btnArrow = new JButton("");
						btnArrow.addActionListener(new BtnArrowActionListener());
						btnArrow.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/arrow_up.png")));
						toolBar.add(btnArrow);
					}
					btnLimpiar.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/Trash.png")));
					toolBar.add(btnLimpiar);
				}
				{
					btnGuardar = new JButton("");
					btnGuardar.addActionListener(new BtnGuardarActionListener());
					btnGuardar.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/guardar.png")));
					toolBar.add(btnGuardar);
				}
			}
					
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridwidth = 2;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 1;
				pnlTest.add(scrollPane, gbc_scrollPane);
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setPreferredSize(new Dimension(140, 140));
					scrollPane_1.setAutoscrolls(true);
					scrollPane.setRowHeaderView(scrollPane_1);
					{
						
						listPruebas = new JList();
						scrollPane_1.setViewportView(listPruebas);
						listPruebas.setCellRenderer(new MiListCellRenderer());
						listPruebas.setModel(MiModeloLista);
					}
				}
				{
					miAreadeDibujo = new MiAreadeDibujo();
					miAreadeDibujo.addMouseMotionListener(new MiAreadeDibujoMouseMotionListener());
					miAreadeDibujo.addMouseListener(new MiAreadeDibujoMouseListener());
					scrollPane.setViewportView(miAreadeDibujo);
				}
			}
		}
		//Creación de imágenes y cursores
				toolkit = Toolkit.getDefaultToolkit();
				imagRectangulo = toolkit.getImage(getClass().getClassLoader().getResource("Recursos/Rectangular-2-32.png"));
				imagArrow = toolkit.getImage(getClass().getClassLoader().getResource("Recursos/arrow_up.png"));
				//Creación de los cursores
				cursorRectangulo = toolkit.createCustomCursor(imagRectangulo,new Point(0,0),"CURSOR_RECTANGULO");
				cursorArrow = toolkit.createCustomCursor(imagArrow,new Point(0,0),"CURSOR_ARROW");
				
		{
			scrollPanePruebas = new JScrollPane();
			scrollPanePruebas.setBorder(new TitledBorder(null, "Pruebas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_scrollPanePruebas = new GridBagConstraints();
			gbc_scrollPanePruebas.gridheight = 2;
			gbc_scrollPanePruebas.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPanePruebas.fill = GridBagConstraints.BOTH;
			gbc_scrollPanePruebas.gridx = 0;
			gbc_scrollPanePruebas.gridy = 2;
			contentPanel.add(scrollPanePruebas, gbc_scrollPanePruebas);
			{
				list = new JList();
				scrollPanePruebas.setViewportView(list);
				
			}
		}
		{
			pnlAccionesPruebas = new JPanel();
			pnlAccionesPruebas.setLayout(null);
			GridBagConstraints gbc_pnlAccionesPruebas = new GridBagConstraints();
			gbc_pnlAccionesPruebas.gridheight = 2;
			gbc_pnlAccionesPruebas.insets = new Insets(0, 0, 5, 5);
			gbc_pnlAccionesPruebas.fill = GridBagConstraints.BOTH;
			gbc_pnlAccionesPruebas.gridx = 1;
			gbc_pnlAccionesPruebas.gridy = 2;
			contentPanel.add(pnlAccionesPruebas, gbc_pnlAccionesPruebas);
			{
				btnAadirPrueba = new JButton("Añadir Prueba");
				btnAadirPrueba.setBounds(10, 5, 185, 41);
				pnlAccionesPruebas.add(btnAadirPrueba);
				btnAadirPrueba.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/cargarComentarios.png")));
			}
			{
				btnBorrarPrueba = new JButton("Borrar Prueba");
				btnBorrarPrueba.setBounds(10, 57, 185, 41);
				btnBorrarPrueba.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/Trash.png")));
				pnlAccionesPruebas.add(btnBorrarPrueba);
			}
		}
		{
			scrollPaneObservaciones = new JScrollPane();
			scrollPaneObservaciones.setBorder(new TitledBorder(null, "Observaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_scrollPaneObservaciones = new GridBagConstraints();
			gbc_scrollPaneObservaciones.gridheight = 2;
			gbc_scrollPaneObservaciones.gridwidth = 2;
			gbc_scrollPaneObservaciones.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPaneObservaciones.fill = GridBagConstraints.BOTH;
			gbc_scrollPaneObservaciones.gridx = 0;
			gbc_scrollPaneObservaciones.gridy = 4;
			contentPanel.add(scrollPaneObservaciones, gbc_scrollPaneObservaciones);
			{
				textAreaObservaciones = new JTextArea();
				textAreaObservaciones.setLineWrap(true);
				scrollPaneObservaciones.setViewportView(textAreaObservaciones);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{111, 107, 91, 0};
			gbl_buttonPane.rowHeights = new int[]{41, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/back_button.png")));
				cancelButton.setActionCommand("Cancel");
			}
			GridBagConstraints gbc_cancelButton = new GridBagConstraints();
			gbc_cancelButton.anchor = GridBagConstraints.WEST;
			gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
			gbc_cancelButton.gridx = 0;
			gbc_cancelButton.gridy = 0;
			buttonPane.add(cancelButton, gbc_cancelButton);
			{
				okButton = new JButton("Aceptar");
				okButton.setIcon(new ImageIcon(Historial.class.getResource("/Recursos/accept.png")));
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			GridBagConstraints gbc_okButton = new GridBagConstraints();
			gbc_okButton.anchor = GridBagConstraints.EAST;
			gbc_okButton.gridx = 2;
			gbc_okButton.gridy = 0;
			buttonPane.add(okButton, gbc_okButton);
		}
	}
	private class BtnExplorarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				miAreadeDibujo.setIcon(imagen);
				miAreadeDibujo.borrarTodo();
				miAreadeDibujo.repaint();
				MiModeloLista.clear();
			}
		}
	}
	private class BtnResaltarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTANGULO;
			miAreadeDibujo.setCursor(cursorRectangulo);
		}
	}
	private class MiAreadeDibujoMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			toolkit = Toolkit.getDefaultToolkit();
			if (imagen != null) {
				switch (modo) {
				case RECTANGULO:
					miAreadeDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y,Color.RED));
					MiModeloLista.addElement("Rectangulo");
					break;
				case ARROW:
					miAreadeDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagArrow));
					miAreadeDibujo.repaint();
					MiModeloLista.addElement("Señalando");
					break;
				}
			}
		}
	}
	private class MiAreadeDibujoMouseMotionListener extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			((RectanguloGrafico) miAreadeDibujo.getUltimoObjetoGrafico()).setX1(e
					.getX());
			((RectanguloGrafico) miAreadeDibujo.getUltimoObjetoGrafico()).setY1(e
					.getY());
			miAreadeDibujo.repaint();
		}
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			miAreadeDibujo.borrarTodo();
			miAreadeDibujo.repaint();
			MiModeloLista.clear();
		}
	}
	private class BtnArrowActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = ARROW;
			miAreadeDibujo.setCursor(cursorArrow);
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser selecArchivo=new JFileChooser();
			selecArchivo.setFileFilter(new ImageFilter());
			int valorDevuelto = selecArchivo.showSaveDialog(frame);
			BufferedImage img = new BufferedImage(miAreadeDibujo.getWidth(), miAreadeDibujo.getHeight(), BufferedImage.TYPE_INT_RGB);
			miAreadeDibujo.paint(img.getGraphics());
		    
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = selecArchivo.getSelectedFile();
				
				try{		
				    ImageIO.write(img, "png", new File(file.getAbsolutePath()));
				    JOptionPane.showMessageDialog(frame, "Archivo guardado correctamente.", "Seminario 2", JOptionPane.PLAIN_MESSAGE);
				}catch (IOException ioe){
					JOptionPane.showMessageDialog(frame, "No se ha podido guardar el archivo.", "Seminario 2", JOptionPane.ERROR_MESSAGE);
				}
			}else
				System.out.println("Se ha cancelado la acci�n.");
		}
	}
}
