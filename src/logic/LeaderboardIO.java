package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LeaderboardIO {
	
	File leaderboard;
	String databasePath = "src/PlayersDatabase";
	File database;
	FileWriter fileWriter;
	public ArrayList<Player> playerLeaderboard;
	FileReader fileReader;
	public LeaderboardIO() {
		playerLeaderboard = new ArrayList<Player>();
		try {
			database = new File(databasePath);
			
			leaderboard = new File("src/Leaderboard");
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Player> SortedLB( ArrayList<Player> list){
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		ArrayList<Player> sortedList = new ArrayList<Player>();
		for(Player p : list) {
			scores.add(p.getMaxScore());
		}
		Collections.sort(scores);
		for(int i : scores) {
			System.out.println(i);
			for(Player p : list) {
				if(p.getMaxScore() == i) {
				
					sortedList.add(p);
				}
			}
		}
		return sortedList;
		
	}

	public ArrayList<Player> GetOldDatabase(){
		System.out.println("OLD DATABASE");
		ArrayList<Player> list = new ArrayList<Player>();
		Player newPlayer;
		try {
			Scanner scanner = new Scanner(database);
			while(scanner.hasNextLine()) {
				String text = scanner.nextLine();
				String[] data = text.split(",");
				newPlayer = new Player(data[0]);
				newPlayer.setMaxScore(Integer.parseInt(data[1]));
				newPlayer.setBestTime(Integer.parseInt(data[2]));
				list.add(newPlayer);
				System.out.println("LISTA: " + text);
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			Collections.sort(list, new Comparator<Player>() {
				public int compare(Player p1, Player p2) {
					return Integer.valueOf(p2.getMaxScore()).compareTo(p1.getMaxScore());
				}
			});
			return list;	
		}
	

	
/*	public void UpdateDatabaseEntry(Player p) {
		String newLine = p.getName() +	"," + p.getMaxScore()+"," +p.getBestTime();
		String oldLine= "";
		
		
		File tempFile = new File("src/runTimeDatabase");
		try {

			Scanner dbScanner = new Scanner(database);
			Scanner _dbScanner = new Scanner(tempFile);
			fileWriter = new FileWriter(tempFile, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			while(dbScanner.hasNextLine()) {
				String text = dbScanner.nextLine();
				if(!text.contains(p.getName())) {
					
					System.out.println(text);
					writer.write("\n" + text);
				}
				
			}
			System.out.println("new line " + newLine);
			writer.write("\n" + newLine);
			writer.close();
			dbScanner.close();
			System.out.println(_dbScanner.hasNextLine());
		
			
		} 
		catch (IOException e) {
			System.out.println("Error located in LeaderboardIO.UpdateDatabaseEntry()");
			e.printStackTrace();
		}
		
	}*/
	public Player GetPlayerFromDatabase(Player p) {
		String playerName = p.getName();
		Player newPlayer = new Player();
		if(PlayerExistsInDatabase(p)) {
			try {
				
				Scanner scanner = new Scanner(database);
				
				while(scanner.hasNextLine()) {
					String text = scanner.nextLine();
					if(text.contains(playerName)) {
						String[] data = text.split(",");
						newPlayer = new Player(data[0]);
						newPlayer.setMaxScore(Integer.parseInt(data[1]));
						newPlayer.setBestTime(Integer.parseInt(data[2]));
						
						
					}
					
					
					
				}
			} catch (FileNotFoundException e) {
				newPlayer = new Player("NULL");

				e.printStackTrace();
				System.out.println("Error located in LeaderboardIO.PlayerExistsInDatabase()");
			}
		}
		return newPlayer;
	}
	public boolean PlayerExistsInDatabase(Player p) {
		String playerName = p.getName();
		boolean alreadyExists = false;
		
		try {
			
			Scanner scanner = new Scanner(database);
			
			while(scanner.hasNextLine()) {
				String text = scanner.nextLine();
				if(text.contains(playerName)) {
					alreadyExists = true;
				}
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error located in LeaderboardIO.PlayerExistsInDatabase()");
		}
		return alreadyExists;
		
	}
	public void AddPlayerToDatabase(Player p){
		
		
		String line = p.getName() +
				"," + p.getMaxScore()+
				
				"," +p.getBestTime();
			
		try {
			fileWriter = new FileWriter(database, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write("\n" + line);
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error located in LeaderboardIO.AddPlayerToDatabase()");
			e.printStackTrace();
		}
	}
	

	public void AddPlayerToLeaderboard(String name, String score, String time) {
		String line = "[Nombre: "+  name +  " Score: " + score + " Tiempo: " + time + "]";
		try {
			fileWriter = new FileWriter(leaderboard);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write("\n" + line);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> GetWholeFile() {
		ArrayList<String> list  = new ArrayList();
		try {
			fileReader = new FileReader(leaderboard);
			Scanner scanner = new Scanner(leaderboard);
			
			while(scanner.hasNextLine()) {
				list.add (scanner.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean playerExistsInFile(String playerName) {
		for(String line : GetWholeFile()) {
			if(line.contains(playerName)) {
				return true;
			}
		}
		return false;
		
	}
		
}
