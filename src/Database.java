import java.util.*;
import java.io.*;


public class Database {
	
	private Scanner cinput;
	private Formatter coutput; 
	ArrayList <String> tempStorage = new ArrayList <String>(); 
	
	
	public void loadDatabase(ScoreBoard scoreboard) {
		
		cinput = openInputFile("TopPlayers.txt"); 
		readTopPlayersFile(scoreboard);
		closeInputFile(cinput); 
		
	}
	
	public void storeDatabase(ScoreBoard scoreboard) {
		coutput = openOutputFile("TopPlayers.txt");
		writeTopPlayersFile(scoreboard);
		closeOutputFile(coutput);
	}
	
	public Scanner openInputFile(String filename){
		Scanner tempinput=null;
		try
		{
			tempinput = new Scanner(new File(filename));
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return tempinput;
	}
	
	public Formatter openOutputFile(String filename) {
		Formatter tempoutput=null;
		try
		{
			tempoutput = new Formatter(new File(filename));
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		return tempoutput;
	}
	
	public void readTopPlayersFile(ScoreBoard scoreboard) {

		int check = 0; 
		
		try
		{
			while (cinput.hasNext())
			{
				check = 1;
				tempStorage.add(cinput.nextLine()); 
			}


		}
		catch (NoSuchElementException elementException)
		{
			
			System.err.println("File improperly formed.");
			cinput.close();
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		}
		
		int k = 0; 
		
		if (check == 1)
		{
			for (int i = 0; i < 5; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					scoreboard.fillTop5(i, j, tempStorage.get(k));
					k++;
				}
			}
		}
		

		
		
	}
	
	


	public void writeTopPlayersFile(ScoreBoard scoreboard) {
		
		
		scoreboard.printTop5();
		
		//get top5 size 
		for ( int i = 0; i < 5; i++ )
		{
			for (int j = 0; j < 3; j++)
			{
				
				coutput.format("%s\n", scoreboard.getTop5(i, j));
				
			}

		}
	}
	
	public void closeInputFile(Scanner input) {
		if (input!=null)
			input.close();
	}

	public void closeOutputFile(Formatter output) {
		if (output!=null)
			output.close();
	}
}