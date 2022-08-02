package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameSession {
	private QuestionCollection questions = new QuestionCollection();
	
	private Question[] Questionaire = new Question[5];
	private Player player;
	private int correctAnswers;
	private int finishTime;
	public GameSession(Player player) {
		correctAnswers = 0;
		this.player = player;
		FillQuestionaire();
	
	}
	public Question[] getQuestionaire() {
		return this.Questionaire;
	}
	void FillQuestionaire() {
		ArrayList<Question> entireList = questions.GetAll();
		Random r = new Random();
		for (int i = 0; i < Questionaire.length; i++) {
		int randomIndex = r.nextInt(entireList.size() -1);
		Question q  = entireList.get(randomIndex);
		q.setId(i + 1);
		Questionaire[i] = q;
		entireList.remove(randomIndex);
		}
	}
	public void AnsweredCorrectly() {
		correctAnswers++;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public int CalculateScore() {
		int score = correctAnswers *100;
		score -= finishTime;
		return score;
	}
	public void setTime(int t) {
		finishTime = t;
	}
}
