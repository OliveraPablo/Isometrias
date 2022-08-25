package logic;

public class Question {
	
	private int id;
	private String question;
	private String imagePath;
	private boolean correctAnswer;
	
	
	public Question(String question, boolean correctAnswer ) {
		this.imagePath = "Empty.png";
		this.correctAnswer = correctAnswer;
		this.question = question;
	}
	public Question(String question, boolean correctAnswer, String imagePath ) {
		this.correctAnswer = correctAnswer;
		this.question = question;
		this.imagePath = imagePath;
	}
	public String getQuestion() {
		return question;
	}
	public boolean getAnswer() {
		return correctAnswer;
	}
	public String getImage() {
		return imagePath;
	}
	public void setId(int id) {
		this.id = id;
	}
}
