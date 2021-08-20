import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class Game {

	private Player p1, p2;

	private Dice dice; 
	private ArrayList<Obstacle> olist = new ArrayList<Obstacle>();
    private River river;
    private Winner winner;
    private ScoreBoard scoreboard; 
    //private ScoreBoard scoreboard; 
    

    
    Scanner input = new Scanner(System.in); 
    
    public Game() {
        
    	System.out.println("Game loading ...");
    	
    	p1 = new Player();
    	p2 = new Player();
        river = new River();
        scoreboard = new ScoreBoard();

        dice = new Dice(); 
        
        winner = new Winner();
        
       
        
        
    	//generate current & trap
    	//how many current, how many trap
    	Random r = new Random();
    	int howmanycurrent = 6 + r.nextInt(2);
    	int howmanytrap = 6 + r.nextInt(2);

    	
    	for(int i=0; i< howmanycurrent; i++) 
    	{
    		Current temp = new Current();
    		//check for duplicate
    		boolean duplicate = false;
    		for(Obstacle o: olist) 
    		{
    			for(int j = 1; j <= 3; j++)
    			{
        			if (o.getLocation() == temp.getLocation()) 
        			{
        				
        				duplicate = true;
        				break; //break the for loop if there is duplication to avoid creating the object 
        			}
        			//make sure new current is not created 5 unit after old current
        			else if (o.getLocation() == (temp.getLocation() + j))
        			{
        				
        				duplicate = true; 
        				break;
        			}
        			//make sure new current is not created 5 unit before old current
        			else if (o.getLocation() == (temp.getLocation() - j))
        			{
        				
        				duplicate = true;
        				break;
        			}
    			}

    			
    		}
    		if (!duplicate) 
    		{
    			
    			olist.add(temp);
    		}
    		else 
    		{
    			i--;
    		}
    	}
    	
    	
    	for(int i=0; i< howmanytrap; i++)
    	{
            Trap temp = new Trap();

            //check for duplicates

            boolean duplicate = false;

            for (Obstacle o : olist) 
            {

            	for(int j = 0; j <= 3; j++)
            	{
                    if (o.getLocation() == temp.getLocation())
                    {
                    	
                        duplicate = true;
                        break; //break the for loop if there is duplication to avoid creating the object 
                    }
        			//make sure new trap is not created 5 unit after old trap
        			else if (o.getLocation() == (temp.getLocation() + j))
        			{
        				
        				duplicate = true; 
        				break;
        			}
        			//make sure new trap is not created 5 unit before old trap
        			else if (o.getLocation() == (temp.getLocation() - j))
        			{
        				
        				duplicate = true;
        				break;
        			}
            	}
            }
            if (!duplicate) 
            {
            	
                olist.add(temp);
            }
            else 
            {
                i--;
            }
    	}   	
    }

    
    
   
    

    
    public void startGame() {
    	

    	
    	
    	int roundsCompleted = 0;
        Scanner input = new Scanner(System.in); 
        
        

        Database database = new Database(); 

      

        //WELCOME MESSAGE
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("**********************************************************************************************");
        System.out.println("----------------------------------------------------------------------------------------------");

        System.out.println(" ");
        
        System.out.println("WELCOME TO");
        System.out.println("BOAT RACE!!!");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("**********************************************************************************************");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--------------------------------------------");
        System.out.println("GAME INSTRUCTIONS:");
        System.out.println("--------------------------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1. Please insert the players name.\n"+
                           "   Players' names could not consist of integer or a blank space only!\n"+
                           "   The 1st player will be represented as 'A' on the map\n"+
                           "   The 2nd player will be represented as 'B' on the map\n");
        System.out.println(" ");
        System.out.println("2. Please choose a desired boat.\n"+
                           "   INPUT '1' FOR A NORMAL BOAT OR INPUT '2' FOR A FISHING BOAT.\n " +
                           "  Normal boat will moves normally\n" +
                           "   Fishing boat will moves an additional single step forward just before the rounds complete.\n");
        System.out.println(" ");
        System.out.println("3. Roll the dice.\n"+
                           "   There are 3 options when you roll your dice.\n"+
                           "   You can only choose either one by inserting the number '1' or '2' or '3'\n");
        System.out.println(" ");
        System.out.println("4. Watch out for currents and traps along the race.\n"+
                           "   Currents will help you move forward by a random value between 1 - 5.\n"+
                           "   Traps will move you backward by a random value between 1 - 5."); 
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("5. The first player to reach 100 or more will win the game.\n"+
                           "   Let the luckiest player win!!!\n");     
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("**********************************************************************************************");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println(" "); 
     
        database.loadDatabase(scoreboard); 
        //fill up scoreboard from database here
        
        
        
        scoreboard.printTop5();
        


		

        boolean bool1; 
        bool1 = true; 
        while(bool1)
        {
            p1.promptEnterName();
            p2.promptEnterName(); 
            
            if(p2.getPlayerName().equals(p1.getPlayerName())) 
            {
                //print error message
                System.out.println("Invalid Name!!! Player 2 cannot have the same name as Player 1!");
                bool1 = true; 

                
            }
            else 
            {
                bool1 = false;
            }
        }
		
        
        //choose boat
        
        p1.chooseBoat();
        p2.chooseBoat();
		
		System.out.println("!!!!!!!!!!THE GAME HAS STARTED!!!!!!!!!!"); 
		System.out.println("Position of players and obstacles on river: "); 
        river.displayMap(olist);
        System.out.println(""); 
        
        

        //while loop
        boolean gameStillGoing = true; 
        
        while(gameStillGoing) 
        {
        	System.out.println("???????????????????????????????????????????????????");
        	System.out.println("C represents current");
        	System.out.println("# represents trap"); 
        	System.out.printf("A represents player %s\n", p1.getPlayerName()); 
        	System.out.printf("B represents player %s\n", p2.getPlayerName()); 
        	System.out.println("???????????????????????????????????????????????????");
            //roll dice
        	System.out.printf("%s's turn using a %s\n", p1.getPlayerName(), p1.getBoatUsed()); 
        	System.out.printf("%s's current position is %d\n", p1.getPlayerName(), p1.getLocation());
        	System.out.println(""); 
            dice.rollDice();
            System.out.printf("%s's roll is: %d\n", p1.getPlayerName(), dice.getDiceNum()); 
          
            
            
            //check if it's any Current or Trap
            if(p1.getLocation() > 5)
            {
            	
            	
        		for(Obstacle o: olist)
            	{
                    if (p1.getLocation() == o.getLocation()) 
                    {
                        if (o instanceof Current) 
                        {
                            p1.rowTheBoatForward(o.getPower());
                            
                            System.out.printf("Yes! You had hit a current that brings you %d steps forward!\n", o.getPower());
                            System.out.println(""); 
                            if(p1.getBoatUsed().equals("Fishing Boat"))
                            {
                            	 p1.rowTheBoatBackward(1);
                            }
                        }
                        else if (o instanceof Trap) 
                        {
                            p1.rowTheBoatBackward(o.getPower());
                            
                            System.out.printf("Oh no! You had hit a trap that brings you %d steps backwards!\n", o.getPower());
                            System.out.println(""); 
                            if(p1.getBoatUsed().equals("Fishing Boat"))
                            {
                            	 p1.rowTheBoatBackward(1);
                            }
                        }
                    }
            	}
            	
            }
            
            p1.rowTheBoatForward(dice.getDiceNum());
            

        
            System.out.println("Position of players and obstacles on river: "); 
            river.displayMap(olist, p1.getLocation(), p2.getLocation());
            System.out.println(""); 
            
            if(p1.getLocation() <= 85) 
            {
            	
            	System.out.printf("%s's new position is %d\n", p1.getPlayerName(), p1.getLocation());
            	
            }
            
            else if(p1.getLocation() < 100 && p1.getLocation() >= 85) 
            {
            	System.out.printf("%s's new position is %d\n", p1.getPlayerName(), p1.getLocation());
            	System.out.printf("HAHAHA %s IS GOING TO WIN SOON!\n", p1.getPlayerName());
            }
            
            else if (p1.getLocation()>= 100) 
            {
            	
                
                System.out.printf("Congratulations! Player 1 with name %s has won the race!\n", p1.getPlayerName());
                //congratulation message
                //set winner
                winner.setWinner(p1.getPlayerName());
                System.out.println("");
 
                gameStillGoing = false;
            }
            

            
            System.out.println(""); 
            
     
            System.out.println("------------------------------------------------------------------------------------");


            //roll dice for player 2
            System.out.printf("%s's turn using a %s\n", p2.getPlayerName(), p2.getBoatUsed()); 
            System.out.printf("%s's current position is %d\n", p2.getPlayerName(), p2.getLocation());
            System.out.println(""); 
            dice.rollDice();
            System.out.printf("%s's roll is: %d\n", p2.getPlayerName(), dice.getDiceNum()); 

            //check if hit any current or trap
          
            
            if(p2.getLocation() > 5)
            {
            	
       
        		for(Obstacle o: olist)
            	{
                    if (p2.getLocation() == o.getLocation()) 
                    {
                        if (o instanceof Current) 
                        {
                            p2.rowTheBoatForward(o.getPower());
                            
                            System.out.printf("Yes! You had hit a current that brings you %d steps forward!\n", o.getPower());
                            System.out.println(""); 
                            
                            if(p2.getBoatUsed().equals("Fishing Boat"))
                            {
                            	 p2.rowTheBoatBackward(1);
                            }
                           
                        }
                        else if (o instanceof Trap) 
                        {
                            p2.rowTheBoatBackward(o.getPower());
                           
                            System.out.printf("Oh no! You had hit a trap that brings you %d steps backwards!\n", o.getPower());
                            System.out.println(""); 
                            
                            if(p2.getBoatUsed().equals("Fishing Boat"))
                            {
                            	 p2.rowTheBoatBackward(1);
                            }
                           
                        }
                    }
            	}
            	
            }
            
            p2.rowTheBoatForward(dice.getDiceNum());
            

           
            
            

            System.out.println("Position of players and obstacles on river: "); 
            river.displayMap(olist, p1.getLocation(), p2.getLocation());
            System.out.println(""); 
         
            //check for position 100

            if(p2.getLocation() <= 85) 
            {
            	
            	System.out.printf("%s's new position is %d\n", p2.getPlayerName(), p2.getLocation());
            	System.out.println(""); 
            }
            
            else if(p2.getLocation() < 100 && p2.getLocation() >= 85) 
            {
            	System.out.printf("%s's new position is %d\n", p2.getPlayerName(), p2.getLocation());
            	System.out.printf("HAHAHA %s IS GOING TO WIN SOON!\n", p2.getPlayerName());
            }
            
            else if (p2.getLocation()>= 100) 
            {
            	
                
                System.out.printf("Congratulations! Player 2 with name %s has won the race!\n", p2.getPlayerName());
                //congratulation message
                //set winner
                winner.setWinner(p2.getPlayerName());
                System.out.println(""); 

                gameStillGoing = false;
            }
            
            roundsCompleted++; 
            System.out.println("------------------------------------------------------------------------------------");
            
         
        }

        System.out.println(""); 
        System.out.printf("\nThe winner: %s takes %d rounds to complete the game!\n", winner.getWinner(), roundsCompleted);

        System.out.println("New scoreboard: "); 
        scoreboard.setTop5(winner.getWinner(), roundsCompleted);
        scoreboard.printTop5();
        

        //restart game
    	boolean bool = true;
    	while(bool)
    	{
    		System.out.println("Select 1 to start game or 0 to end"); 
    		String respond;
    		respond = input.nextLine(); 
    		if(respond.equals("1"))
    		{
    			p1.setLocation(1);
    			p2.setLocation(1);
    			database.storeDatabase(scoreboard);
    		
    			startGame(); 
    			
    		}
    		else if(respond.equals("0"))
    		{
    			
    			
    			System.out.println("Thank you for playing!"); 
    			
    			database.storeDatabase(scoreboard);
    			bool = false; 
    			System.exit(0);
    		}
    		else
    		{
    			System.out.println("Invalid input!"); 
    			bool = true; 
    		}
    		
    		
    	}
       
        
        
    }
}

























