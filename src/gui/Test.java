package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.GameSession;
import logic.Player;
import logic.Question;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
public class Test extends JFrame {

	private JPanel contentPane;
	private Player player;
	private int questionCounter = 0;
	private int timePassed;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 */
	public Test(Player p, MainFrame main) {
		
		setUndecorated(true);
		player = p;
		timePassed = 0;
		GameSession session = new GameSession(p);
		Question[] questions = session.getQuestionaire();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(252, 249, 240));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel imageArea = new JLabel("");
		imageArea.setBounds(10, 191, 682, 229);
		contentPane.add(imageArea);
		
		JLabel counter = new JLabel("New label");
		counter.setHorizontalAlignment(SwingConstants.CENTER);
		counter.setFont(new Font("Tahoma", Font.BOLD, 11));
		counter.setBounds(10, 11, 22, 23);
		counter.setText(String.valueOf(questionCounter));
		contentPane.add(counter);
		
		JTextPane pnQuestion = new JTextPane();
		pnQuestion.setEditable(false);
		pnQuestion.setBounds(10, 82, 682, 79);
		pnQuestion.setText(questions[questionCounter].getQuestion());
		contentPane.add(pnQuestion);
		imageArea.setIcon(new ImageIcon(getClass().getClassLoader().getResource(questions[questionCounter].getImage())));
		
		
		
		JLabel lblTimer = new JLabel("");
		lblTimer.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		lblTimer.setBounds(566, 11, 126, 35);
		contentPane.add(lblTimer);	
		Timer  t = new Timer(1000, new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblTimer.setText(String.valueOf(timePassed));
				timePassed++;
			}
			
		});
		t.start();
		
		
		JPanel panelBtnF = new JPanel();
		panelBtnF.setLayout(null);
		panelBtnF.setBounds(360, 451, 161, 37);
		panelBtnF.setBackground(new Color(77, 59, 112));
		contentPane.add(panelBtnF);
		
	
		JLabel answerLbl = new JLabel("");
		answerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		answerLbl.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		answerLbl.setBounds(531, 451, 161, 37);
		contentPane.add(answerLbl);
		
		JPanel panelBtnV = new JPanel();
		panelBtnV.setBounds(162, 451, 161, 37);
		panelBtnV.setBackground(new Color(77, 59, 112));
		contentPane.add(panelBtnV);
		panelBtnV.setLayout(null);
		
		JLabel lbVerdadero = new JLabel("Verdadero");
		lbVerdadero.setForeground(UIManager.getColor("Button.highlight"));
		lbVerdadero.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseReleased(MouseEvent e) {
				answerLbl.setText("");
				
				if(questionCounter < questions.length -1) {
		
					if(questions[questionCounter].getAnswer()) {
						
						session.AnsweredCorrectly();
						setCorrectMessage(answerLbl);
						
					}
					else {
						setIncorrectMessage(answerLbl);
					}
					questionCounter++;
					pnQuestion.setText(questions[questionCounter].getQuestion());
					
					imageArea.setIcon(new ImageIcon(getClass().getClassLoader().getResource(questions[questionCounter].getImage())));
					
					counter.setText(String.valueOf(questionCounter));
				}
				else {
					t.stop();
					session.setTime(timePassed);
					int score = session.CalculateScore();
					player.setMaxScore(score);
					player.setBestTime(timePassed);
					ScorePanel scorePanel = new ScorePanel(player, main);
					scorePanel.setLocationRelativeTo(null);
					scorePanel.setVisible(true);
					dispose();
				}
				
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SetColor(panelBtnV);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ResetColor(panelBtnV);
			}
		});
		lbVerdadero.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));
		lbVerdadero.setHorizontalAlignment(SwingConstants.CENTER);
		lbVerdadero.setBounds(-15, -14, 186, 62);
		panelBtnV.add(lbVerdadero);
		
		
		JLabel lbFalso = new JLabel("Falso");
		lbFalso.setForeground(UIManager.getColor("Button.highlight"));
		lbFalso.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
					answerLbl.setText("");
					if(questionCounter < questions.length -1) {
						System.out.println("FALSO");
						if(!questions[questionCounter].getAnswer()) {
							
							session.AnsweredCorrectly();
							setCorrectMessage(answerLbl);
							
						}
						else {
							setIncorrectMessage(answerLbl);
						}
						questionCounter++;
						counter.setText(String.valueOf(questionCounter));
						pnQuestion.setText(questions[questionCounter].getQuestion());
						imageArea.setIcon(new ImageIcon(questions[questionCounter].getImage()));
					}
					else {
						t.stop();
						session.setTime(timePassed);
						int score = session.CalculateScore();
						player.setMaxScore(score);
						player.setBestTime(timePassed);
						ScorePanel scorePanel = new ScorePanel(player, main);
						scorePanel.setLocationRelativeTo(null);
						scorePanel.setVisible(true);
						dispose();
					}
				
			
				
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SetColor(panelBtnF);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ResetColor(panelBtnF);
			}
		});
		lbFalso.setHorizontalAlignment(SwingConstants.CENTER);
		lbFalso.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));
		lbFalso.setBounds(-13, -12, 186, 60);
		panelBtnF.add(lbFalso);
		
		
		
		
		
		
		
	}
	public void setCorrectMessage(JLabel label) {
		
		label.setText("Correcto!");
		label.setForeground(Color.green);
	
		
	}
	public void setIncorrectMessage(JLabel label) {
		
		label.setText("Incorrecto!");
		label.setForeground(Color.red);
	
	}
	public void SetColor(JPanel panel) {
		panel.setBackground(new Color(95, 76, 133));
	}

	public void ResetColor(JPanel panel) {
		panel.setBackground(new Color(77, 59, 112));
	}
	
	
}
