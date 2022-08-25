package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Player;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private static MainFrame frame;
	private int mouseX, mouseY;
	public static Timer t;
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new MainFrame();
					
					//dale pal centro amigo
					frame.setLocationRelativeTo(null);
					
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
	public MainFrame() {
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 866);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		contentPane.setBackground(new Color(252, 249, 240));
		contentPane.setBorder(new LineBorder(new Color(77, 59, 112), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(77, 59, 112));
		panel.setBounds(0, 0, 242, 866);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Isometrías");
		title.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
		});
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 21));
		title.setForeground(SystemColor.text);
		title.setBounds(0, -13, 246, 74);
		panel.add(title);
		
		
		
		//PANELS
		JPanel pnIsometria = new JPanel();
		pnIsometria.setBackground(new Color(77, 59, 112));
		pnIsometria.setBounds(0, 168, 246, 42);
		panel.add(pnIsometria);
		pnIsometria.setLayout(null);
		
		JPanel pnAxial = new JPanel();
		pnAxial.setLayout(null);
		pnAxial.setBackground(new Color(77, 59, 112));
		pnAxial.setBounds(0, 210, 246, 42);
		panel.add(pnAxial);
		
		JPanel pnCentral = new JPanel();
		pnCentral.setLayout(null);
		pnCentral.setBackground(new Color(77, 59, 112));
		pnCentral.setBounds(0, 252, 246, 42);
		panel.add(pnCentral);
		
		JPanel pnTraslacion = new JPanel();
		pnTraslacion.setLayout(null);
		pnTraslacion.setBackground(new Color(77, 59, 112));
		pnTraslacion.setBounds(0, 336, 246, 42);
		panel.add(pnTraslacion);
	
		JPanel pnRotacion = new JPanel();
		pnRotacion.setLayout(null);
		pnRotacion.setBackground(new Color(77, 59, 112));
		pnRotacion.setBounds(0, 294, 246, 42);
		panel.add(pnRotacion);
		
		JPanel pnAntitraslacion = new JPanel();
		pnAntitraslacion.setLayout(null);
		pnAntitraslacion.setBackground(new Color(77, 59, 112));
		pnAntitraslacion.setBounds(0, 378, 246, 42);
		panel.add(pnAntitraslacion);
		
		JPanel pnPuntoUnido = new JPanel();
		pnPuntoUnido.setLayout(null);
		pnPuntoUnido.setBackground(new Color(77, 59, 112));
		pnPuntoUnido.setBounds(0, 420, 246, 42);
		panel.add(pnPuntoUnido);
		
		JPanel pnPrueba = new JPanel();
		pnPrueba.setBounds(0, 738, 246, 42);
		panel.add(pnPrueba);
		pnPrueba.setLayout(null);
		pnPrueba.setBackground(new Color(77, 59, 112));
		

		
		JLabel lbPrueba = new JLabel("Realizar Prueba");
		lbPrueba.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lbPrueba.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbPrueba.setForeground(SystemColor.text);
			}@Override
			public void mouseReleased(MouseEvent e) {
				PlayerAuth auth = new PlayerAuth(frame);
				auth.setLocationRelativeTo(null);
				auth.setVisible(true); 
				frame.setVisible(false);
			}
		});
		lbPrueba.setBounds(0, 0, 246, 42);
		pnPrueba.add(lbPrueba);
		lbPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrueba.setForeground(Color.WHITE);
		lbPrueba.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		
		
		//TEXT PANELS
		JTextPane paneTitle = new JTextPane();
		paneTitle.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 24));
		paneTitle.setEditable(false);
		paneTitle.setBackground(new Color(252, 249, 240));
		paneTitle.setBounds(270, 73, 302, 67);
		contentPane.add(paneTitle);
		
		JTextPane paneContent = new JTextPane();
		paneContent.setBorder(null);
		paneContent.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		paneContent.setEditable(false);
		paneContent.setBackground(new Color(252, 249, 240));
		paneContent.setBounds(270, 155, 603, 482);
		
		contentPane.add(paneContent);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBorder(null);
		imageLabel.setBounds(270, 648, 603, 207);
		contentPane.add(imageLabel);
		
		
		
		JLabel lblIsometria = new JLabel("Isometria");
		lblIsometria.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnIsometria);
				ResetColor(pnAxial);
				ResetColor(pnRotacion);
				ResetColor(pnCentral);
				ResetColor(pnTraslacion);
				ResetColor(pnAntitraslacion);
				ResetColor(pnPuntoUnido);
				
				FileToTextPane("res/isometria", "Isometría: ", paneContent, paneTitle, imageLabel, "isometria.png");
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIsometria.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIsometria.setForeground(SystemColor.text);
			}
		});
		lblIsometria.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblIsometria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsometria.setForeground(SystemColor.text);
		lblIsometria.setBounds(0, 0, 246, 42);
		pnIsometria.add(lblIsometria);
		
		
		
		

		JLabel lblaxial = new JLabel("Simetría Axial");
		lblaxial.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnAxial);
				ResetColor(pnIsometria);
				ResetColor(pnRotacion);
				ResetColor(pnCentral);
				ResetColor(pnTraslacion);
				ResetColor(pnAntitraslacion);
				ResetColor(pnPuntoUnido);
				
				FileToTextPane("res/simetria_axial", "Simetría Axial: ", paneContent, paneTitle, imageLabel, "simetriaAxial.png");
			}
			public void mouseEntered(MouseEvent e) {
				lblaxial.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblaxial.setForeground(SystemColor.text);
			}
		});
		lblaxial.setHorizontalAlignment(SwingConstants.CENTER);
		lblaxial.setForeground(Color.WHITE);
		lblaxial.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblaxial.setBounds(10, 0, 236, 42);
		pnAxial.add(lblaxial);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 246, -20);
		pnAxial.add(panel_1);
		
		
		
		
	
		
		JLabel lblCentral = new JLabel("Simetría Central");
		lblCentral.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnCentral);
				ResetColor(pnIsometria);
				ResetColor(pnRotacion);
				ResetColor(pnAxial);
				ResetColor(pnTraslacion);
				ResetColor(pnAntitraslacion);
				ResetColor(pnPuntoUnido);
				
				FileToTextPane("res/simetria_central", "Simetría Central: ", paneContent, paneTitle, imageLabel, "simetriaCentral.png");
			}
			public void mouseEntered(MouseEvent e) {
				lblCentral.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCentral.setForeground(SystemColor.text);
			}
		});
		lblCentral.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentral.setForeground(Color.WHITE);
		lblCentral.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblCentral.setBounds(10, 0, 236, 42);
		pnCentral.add(lblCentral);
		

		JLabel lblRotación = new JLabel("Rotación");
		lblRotación.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnRotacion);
				ResetColor(pnIsometria);
				ResetColor(pnAxial);
				ResetColor(pnCentral);
				ResetColor(pnTraslacion);
				ResetColor(pnAntitraslacion);
				ResetColor(pnPuntoUnido);
				
				FileToTextPane("res/rotacion", "Rotación: ", paneContent, paneTitle, imageLabel, "rotacion.png");
			}
			public void mouseEntered(MouseEvent e) {
				lblRotación.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRotación.setForeground(SystemColor.text);
			}
		});
		lblRotación.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotación.setForeground(Color.WHITE);
		lblRotación.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lblRotación.setBounds(10, 0, 236, 42);
		pnRotacion.add(lblRotación);
		
	
		
		JLabel lbTraslacion = new JLabel("Traslación");
		lbTraslacion.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnTraslacion);
				ResetColor(pnIsometria);
				ResetColor(pnAxial);
				ResetColor(pnCentral);
				ResetColor(pnRotacion);
				ResetColor(pnAntitraslacion);
				ResetColor(pnPuntoUnido);
				
				FileToTextPane("res/traslacion", "Traslación: ", paneContent, paneTitle, imageLabel, "traslacion.png");
			}
			public void mouseEntered(MouseEvent e) {
				lbTraslacion.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbTraslacion.setForeground(SystemColor.text);
			}
		});
		lbTraslacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbTraslacion.setForeground(Color.WHITE);
		lbTraslacion.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lbTraslacion.setBounds(10, 0, 236, 42);
		pnTraslacion.add(lbTraslacion);
		

		
		JLabel lbAntitraslacion = new JLabel("Antitraslación");
		lbAntitraslacion.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnAntitraslacion);
				ResetColor(pnIsometria);
				ResetColor(pnAxial);
				ResetColor(pnCentral);
				ResetColor(pnRotacion);
				ResetColor(pnTraslacion);
				ResetColor(pnPuntoUnido);
			
				FileToTextPane("res/antitraslacion", "Antitraslación: ", paneContent, paneTitle, imageLabel, "antitraslacion.png");
			}
			public void mouseEntered(MouseEvent e) {
				lbAntitraslacion.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbAntitraslacion.setForeground(SystemColor.text);
			}
		});
		lbAntitraslacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbAntitraslacion.setForeground(Color.WHITE);
		lbAntitraslacion.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lbAntitraslacion.setBounds(10, 0, 236, 42);
		pnAntitraslacion.add(lbAntitraslacion);
		
	
		
		JLabel lbPuntoUnido = new JLabel("Figuras unidas y dobles");
		lbPuntoUnido.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				SetColor(pnPuntoUnido);
				ResetColor(pnIsometria);
				ResetColor(pnAxial);
				ResetColor(pnCentral);
				ResetColor(pnRotacion);
				ResetColor(pnTraslacion);
				ResetColor(pnAntitraslacion);
				FileToTextPane("res/unidas", "Figuras y puntos unidos: ", paneContent, paneTitle, imageLabel, "Empty.png");

				
			}
			public void mouseEntered(MouseEvent e) {
				lbPuntoUnido.setForeground(new Color(125, 104, 166));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbPuntoUnido.setForeground(SystemColor.text);
			}
		});
		lbPuntoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		lbPuntoUnido.setForeground(Color.WHITE);
		lbPuntoUnido.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		lbPuntoUnido.setBounds(10, 0, 236, 42);
		pnPuntoUnido.add(lbPuntoUnido);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setBounds(864, 0, 36, 39);
		contentPane.add(lblNewLabel);
		//lblNewLabel.setIcon(new ImageIcon(".//res//100-1005181_cancel-close-delete-eraser-exit-remove-trash-x-in-red-circle.png"));
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("100-1005181_cancel-close-delete-eraser-exit-remove-trash-x-in-red-circle.png")));
	

	}
	public void HighlightPanel(JPanel panel) {
		panel.setBackground(new Color(125, 104, 166));
	}

	public void SetColor(JPanel panel) {
		panel.setBackground(new Color(95, 76, 133));
	}

	public void ResetColor(JPanel panel) {
		panel.setBackground(new Color(77, 59, 112));
	}
	public void FileToTextPane(String sourcePath, String title, JTextPane textPane, JTextPane titlePane, JLabel imageArea, String imagePath) {
		File f = new File(sourcePath);
		//InputStream input = getClass().getResourceAsStream(sourcePath);
		//InputStream file = getClass().getResourceAsStream(sourcePath);
		try {
			//BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			Scanner scanner = new Scanner(f);
			String text = "";
			//String line;
			//while((line = reader.readLine()) != null) {
		//		text = text.concat(line);
				
		//	}
			while(scanner.hasNextLine()) {
				text = text.concat(scanner.nextLine() + "\n");
			}
			
			textPane.setText(text);
			titlePane.setText(title);
			//ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(sourcePath));
			imageArea.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imagePath)));
			//imageArea.setIcon(image);
		} catch (Exception e1) {
			
			System.out.println("File not found");
			e1.printStackTrace();
		}
	}
}


