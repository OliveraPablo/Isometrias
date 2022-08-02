package logic;

public class Player {
	private String name;
	private int maxScore;

	private int bestTime;
	
	public Player(String name) {
		this.name = name;
	}
	public Player() {
		
	}
	public void setMaxScore(int score) {
		this.maxScore = score;
	}
	public int getMaxScore() {
		return maxScore;
	}

	

	public String getName() {
		return name;
	}
	public int getBestTime() {
		return bestTime;
	}
	public void setBestTime(int time) {
		this.bestTime = time;
	}
	public String toString() {
		String text;
		 text = "Jugador: " + getName();
		 text += "Mejor puntaje: " + getMaxScore();
		 text += "Mejor tiempo: " + getBestTime();		
		 return text;
	}
}
