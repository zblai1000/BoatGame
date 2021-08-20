
import java.util.*; 
import java.util.ArrayList;


public class ScoreBoard {
    
	//attributes
    //var that stores rounds it takes to complete each match
 

    //var that stores top scorers 
    private String firstPlace = "Spot not yet claimed"; 
    private String secondPlace = "Spot not yet claimed"; 
    private String thirdPlace = "Spot not yet claimed";
    private String fourthPlace = "Spot not yet claimed"; 
    private String fifthPlace = "Spot not yet claimed"; 

    private String firstRoundsComplete = "-";
    private String secondRoundsComplete = "-"; 
    private String thirdRoundsComplete = "-"; 
    private String fourthRoundsComplete = "-";  
	private String fifthRoundsComplete = "-";

	

    
  //array that stores top 5 num of complete rounds 
    int[] roundsComplete = 
        {0, 0, 0, 0, 0};
    
  //array that stores info of top 5 players 
    String[][] top5 = 
        {
        	
            {firstPlace, "1", firstRoundsComplete},
            {secondPlace, "2", secondRoundsComplete},
            {thirdPlace, "3", thirdRoundsComplete},
            {fourthPlace, "4", fourthRoundsComplete},
            {fifthPlace, "5", fifthRoundsComplete}

		};
		
	ArrayList <String> names = new ArrayList <String>(); 
	ArrayList <Integer> scores = new ArrayList <Integer>(); 
   
    public ScoreBoard() {


    }
    
    public void printTop5() {
    	
    	//print table of top 5 players 
    	System.out.println("-----------------------------Scoreboard-----------------------------"); 
    	
    	for (int i = 0; i < top5.length; i++)
    	{
    		System.out.printf("Player's name: %s\n", top5[i][0]);
    		System.out.printf("Placing: %s\n", top5[i][1]);
    		System.out.printf("Rounds completed: %s\n", top5[i][2]);
    		System.out.println(""); 
    	}
    	
    	System.out.println("--------------------------------------------------------------------");
    	

    	
    }

    public void setTop5(String player, int roundsDone){

		System.out.println("Updating the scoreboard..."); 
		
		for (int i = 0; i < top5.length; i++)
    	{
			if(top5[i][0].equals("Spot not yet claimed"))
			{
				//won't be added into arrayList names and scores
			}
			else
			{
				//add into arrayList names and scores
				names.add(top5[i][0]); 
				int record = Integer.parseInt(top5[i][2]);
				scores.add(record); 
			}
    	}	
		
		names.add(player); 
		scores.add(roundsDone); 
		
		
		
		String[][] pair;
		pair = new String[scores.size()][2]; 
		
		//place the elements of names and scores as a pair to identify which score belongs to which player
		for (int i = 0; i < scores.size(); i++)
		{
			
			String recordsStr = Integer.toString(scores.get(i));
			pair[i][0] = names.get(i);
			pair[i][1] = recordsStr; 
			
				
		}
	
		//sort the scores arrayList in ascending order
		Collections.sort(scores); 
		
		
		
		
		String temp; 
		String temp2; 
		
		//sort the pair array in ascending order
		for (int i = 0; i < pair.length; i++) 
		{
			for (int j = i + 1; j < (pair.length); j++) 
			{
				int record = Integer.parseInt(pair[i][1]);  
				int record2 = Integer.parseInt(pair[j][1]);  
				
				if (record > record2) 
				{
					//sort the scores of the players in the pair array in ascending order
					temp = pair[i][1];
					pair[i][1] = pair[j][1];
					pair[j][1] = temp;
					
					//sort the players based on the scores which are already arranged in ascending order
					temp2 = pair[i][0];
					pair[i][0] = pair[j][0];
					pair[j][0] = temp2;
				}
			}
		}
		

		//if there are more than 5 elements in scores, remove the largest integer. 
		if (scores.size() > 5)
		{
			for (int i = 0; i < scores.size(); i++)
			{
				int record = Integer.parseInt(pair[i][1]);
				
				if(scores.get(scores.size() - 1) == record)
				{
					names.remove(pair[i][0]); 
				}
			}
			
			scores.remove(scores.size() - 1); 
		}
		
	


		

		
		for (int i = 0; i < names.size(); i++)
		{
			
			String name = "someName"; 
			String tempName = "someTempName"; 
			
			for(int j = 0; j < scores.size(); j++)
			{
				String recordsStr = Integer.toString(scores.get(j));
				name = pair[i][0]; 
				
				//if the player name is only used once in the loop and its' score match the value from the score arrayList 
				if (pair[i][1].equals(recordsStr) && (!tempName.equals(name)))
				{
					if(j != (scores.size() - 1)) //if not at the last element of scores
					{
						if (scores.get(j).equals(scores.get(j+1))) //if current and next score have the same value
						{
							tempName = name;
							
							names.set(j+1, pair[i][0]); 
							
						}
						else
						{
							tempName = name;
							
							names.set(j, pair[i][0]); 
							
						}
					}

					else
					{
						tempName = name;
						
						names.set(j, pair[i][0]); 
						
					}
					

				}
				else
				{
					
				}
				
			}
		
	
		}
		

    	for (int i = 0; i < top5.length; i++)
    	{
    		if(top5[i][2].equals("-"))
    		{
    			
				top5[i][2] = "100"; 
				
			}
			
    		
		}


		for (int i = 0; i < scores.size(); i++) 
		{
			String recordsStr = Integer.toString(scores.get(i));
			top5[i][2] = recordsStr; 
		}

		for (int i = 0; i < names.size(); i++)
		{
			
				top5[i][0] = names.get(i); 
				
			
			
		}

		for (int i = 0; i < top5.length; i++)
    	{
    		if(top5[i][2].equals("100"))
    		{
    			
				top5[i][2] = "-"; 
				
			}
			
    		
		}
		
		pair = null; 
    	names.clear();
    	scores.clear();
    }
    
    
    
    


    public String getTop5(int i, int j){
        
        return top5[i][j]; 
    }
    
    public void fillTop5(int i, int j, String input) {
    	
    	top5[i][j] = input; 

    }

}    

















    