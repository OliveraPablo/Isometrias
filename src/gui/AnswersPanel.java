package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Question;
import logic.QuestionCollection;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class AnswersPanel extends JFrame {
	private AnswersPanel frame;
	private int mouseX, mouseY;
	private String counterText;
	private int questionCounter = 0;
	private int questionCount;
	private ArrayList<Question> questions ;
	private JPanel contentPane;
	private QuestionCollection questionCollection;

	public AnswersPanel(MainFrame m) {
		frame = this;
		frame.setLocationRelativeTo(null);
		setUndecorated(true);
		questionCollection = new QuestionCollection();
		questions = questionCollection.GetAll();
		
		questionCount = questions.size();
		counterText = (questionCounter+1) + "/" + questionCount;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 631);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel count = new JLabel("9/12");
		count.setHorizontalAlignment(SwingConstants.CENTER);
		count.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		count.setBounds(240, 534, 166, 47);
		count.setText(counterText);
		contentPane.add(count);
		
		JLabel questionPanel = new JLabel("");
		questionPanel.setBounds(20, 258, 655, 196);
		contentPane.add(questionPanel);
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
		
		JLabel answerLabel = new JLabel("");
		answerLabel.setBounds(20, 463, 94, 38);
		contentPane.add(answerLabel);
		
		JLabel imagePanel = new JLabel("");
		imagePanel.setBounds(21, 30, 476, 226);
		contentPane.add(imagePanel);
		setQuestionData(imagePanel, questionPanel, answerLabel);
		
		JLabel prevBtn = new JLabel("<");
		prevBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(questionCounter == 0) {
					questionCounter = questionCount -1;
				}
				else {
					questionCounter--;
				}
					
				setQuestionData(imagePanel, questionPanel, answerLabel);
				counterText = (questionCounter+1) + "/" + questionCount;
				count.setText(counterText);
			}
		});
		prevBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 29));
		prevBtn.setBounds(193, 527, 37, 54);
		contentPane.add(prevBtn);
		
		JLabel nextBtn = new JLabel(">");
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(questionCounter == questionCount -1) {
					questionCounter = 0;
				}
				else {
					questionCounter++;
				}
				setQuestionData(imagePanel, questionPanel, answerLabel);
				counterText = (questionCounter+1) + "/" + questionCount;
				 count.setText(counterText);
			}
		});
		nextBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 29));
		nextBtn.setBounds(438, 527, 37, 54);
		contentPane.add(nextBtn);
		
		JLabel lblNewLabel = new JLabel("Volver");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				m.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setBounds(564, 592, 111, 28);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
	public void setQuestionData(JLabel imageArea, JLabel questionText, JLabel answerLb) {
		Question q = questions.get(questionCounter);
		ImageIcon img = new ImageIcon(q.getImage());
		imageArea.setIcon(img);
		questionText.setText(q.getQuestion());
		if(q.getAnswer()) {
			answerLb.setText("Verdadero");
		}
		else {
			answerLb.setText("Falso");
		}
		
	}
}
