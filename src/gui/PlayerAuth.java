package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Player;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class PlayerAuth extends JFrame {
	private int mouseX, mouseY;
	private PlayerAuth auth;
	private JPanel contentPane;
	private JTextField nameField;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	int timePassed = 3;
	Timer  t;
	boolean isClickable = true;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerAuth frame = new PlayerAuth();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 */
	public PlayerAuth(MainFrame main) {
		
		
		setUndecorated(true);
		auth = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
				auth.setLocation(auth.getX() + e.getX() - mouseX, auth.getY() + e.getY() - mouseY);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(77, 59, 112));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBackground(SystemColor.info);
		nameField.setBounds(74, 97, 296, 44);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese su nombre:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		lblNewLabel.setBounds(74, 49, 296, 37);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(95, 76, 133));
		panel.setBounds(129, 207, 186, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Jugar!");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	
				panel.setBackground(new Color(77, 59, 112));
				lblNewLabel_1.setText("");
				if(isClickable) {
					isClickable = false;
					
					t = new Timer(1000, new ActionListener() {
						

						@Override
						public void actionPerformed(ActionEvent e) {
							
							// TODO Auto-generated method stub
							if(timePassed >= 0) {
								if(timePassed == 0) {
									lblNewLabel_1.setText("Prepárate!");
									
								}
								else {
									lblNewLabel_1.setText(String.valueOf(timePassed));
									
									
								}
								timePassed--;
							}
							else {
								
									
									t.stop();
									Player p = new Player(nameField.getText());
									Test test = new Test(p, main);
									test.setLocationRelativeTo(null);
									test.setVisible(true); 
									dispose();
								
								
								
							}
						}
						
					});
					
					
				t.start();
				}
				
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(new Color(125, 104, 166));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(SystemColor.text);
			}
			
		});
		
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 186, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("VOLVER");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				main.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(339, 11, 95, 37);
		contentPane.add(lblNewLabel_2);
	}
}
