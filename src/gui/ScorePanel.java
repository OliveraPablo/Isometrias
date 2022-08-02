package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.LeaderboardIO;
import logic.Player;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.TableView.TableRow;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ScorePanel extends JFrame {
	private ScorePanel frame;
	private int mouseX, mouseY;
	private JPanel contentPane;
	private ArrayList<String> leaderboardList;
	private String[] columnNames;
	private String [][][] data;
	private ArrayList<Player> sortedLB;
	private LeaderboardIO leaderboardObj;
	private JTable table;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblPuntaje;
	private JLabel lblTiempo;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public ScorePanel(Player p, MainFrame m) {
		frame = this;
		setUndecorated(true);
		leaderboardObj = new LeaderboardIO();
		leaderboardList = leaderboardObj.GetWholeFile();
		Player player = p;
		columnNames = new String[3];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(77, 59, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(422, 119, -418, 368);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.info);
		table.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {"Nombre", "Puntaje", "Tiempo"
			}
		));
		table.setBounds(14, 134, 410, 448);
		contentPane.add(table);
		contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(table);
		table.setTableHeader(new JTableHeader());
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
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(77, 59, 112));
		panel_1.setBounds(287, 100, 137, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setForeground(SystemColor.text);
		lblTiempo.setBounds(0, 0, 137, 36);
		panel_1.add(lblTiempo);
		lblTiempo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 21));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(77, 59, 112));
		panel_2.setBounds(14, 100, 137, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(0, 0, 137, 36);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 21));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(77, 59, 112));
		panel.setBounds(143, 100, 146, 36);
		contentPane.add(panel);
		
		lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setForeground(SystemColor.text);
		lblPuntaje.setBounds(10, 0, 137, 36);
		panel.add(lblPuntaje);
		lblPuntaje.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 21));
		
		JLabel lblNewLabel_1 = new JLabel("Tabla de puntuaciones");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 414, 76);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("VOLVER");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				m.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel_2.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblNewLabel_2.setBounds(126, 608, 163, 45);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ver respuestas");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AnswersPanel a = new AnswersPanel(m);
				a.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setForeground(UIManager.getColor("Button.light"));
		lblNewLabel_3.setBounds(343, 635, 117, 29);
		contentPane.add(lblNewLabel_3);
		String text = "";
		leaderboardObj.AddPlayerToDatabase(player);
		sortedLB = leaderboardObj.GetOldDatabase();
		AddEntryToTable(sortedLB);
		
			
	}
	public void AddEntryToTable(ArrayList<Player> players){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[3];
		for(int i = 0; i < players.size(); i++) {
			rowData[0] = players.get(i).getName(); 
			rowData[1] = players.get(i).getMaxScore(); 
			rowData[2] = players.get(i).getBestTime(); 
			model.addRow(rowData);
		}
	}
}

