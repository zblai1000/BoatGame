

import java.util.Scanner;




public class Player extends Object{
	
    
    private int rounds;
 
	private Boat b1;
	private String playerName;
	private int move; 
	private int roll; 
    
    Scanner input = new Scanner(System.in); 
	
	public Player() {
		
		super(); 
		rounds = 0; 
		roll = 0; 
		playerName ="";
		
	}
	

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
	
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}

	public String getPlayerName() {

		return playerName;
	}

	public void rowTheBoatForward(int row){

		move = row; 
		b1.moveForward(row); 
		setLocation(b1.getLocation()); 
	}
	
	public void rowTheBoatBackward(int row){

		move = row; 
		b1.moveBackward(row); 
		setLocation(b1.getLocation()); 
	}


	public int getRow(){


		return move;
	}

	public boolean checkName(String naming, String input){

		if (naming.equals(input))
		{
			return true; 
		}
		else
		{
			return false; 
		}
	}


	public void promptEnterName() {
		
		
        boolean bool;
        bool = true; 
        while(bool)
        {
			String name; 
        	System.out.println("Enter your name: "); 
            name = input.nextLine();
			
            int strAsNum;  //var for the string p but in int datatype to be used in try catch block 
            int testTryCatch;
        	 try
             {
                 strAsNum = Integer.parseInt(name);
                 //if the str input only consist of numbers, then testTryCatch = 1
                 testTryCatch = 1;

             }
             catch (NumberFormatException ex)
             {
              
                 //if the str input does not only consist of numbers, then input will be accepted
                 testTryCatch = 2;
                
                
             }

             if(testTryCatch == 2)
             {
            	 
				 //check for empty space 

				if (name.isBlank()) {

					//if input only consist of blank space, then it will be invalid input and user
					//have to reenter their name. 
					System.out.println("Invalid name! Player name cannot be blank or consist of only spaces.");
					strAsNum = 0; 

				}

				

				else {
					

					setPlayerName(name); 
					bool = false; 
				}


             }
             else
             {
                 System.out.println("Invalid name! Player name cannot consist of only integer.");
                 strAsNum = 0; 
             }
        }
       
		
	}

	public void chooseBoat(){

        System.out.printf("%s please select the boat of your choice:\n", getPlayerName()); 
        System.out.println("1: normal boat, \n2: fishing boat");
        String choice;
        int choiceTry; 
        choice = input.nextLine(); 
        
        boolean bool;
        boolean bool1; 
        bool = true;
        bool1 = true; 
     
        while(bool) 
        {
        	while(bool1)
        	{
        		try
                {
                    choiceTry = Integer.parseInt(choice);
                    bool1 = false; 
                     
                

                }
                catch (NumberFormatException ex)
                {
                 
                	System.out.println("Invalid input"); 
                   	choice = null;
                	choiceTry = 0; 
            		System.out.println("Invalid input"); 
                    System.out.println("Please select the boat of your choice:"); 
                    System.out.println("1: normal boat, \n2: fishing boat");
                    choice = input.nextLine(); 
                    bool1 = true; 
                  
                }
        	}
        	choiceTry = Integer.parseInt(choice);


        	if(choiceTry == 1) //make the boat inside the player so inside player got attribute call boat 
        			//so it will be p1.addBoat(choiceTry)
        	{
				b1 = new NormalBoat();
				b1.setBoatName("Normal Boat");
        		bool = false; 
        	
        	}
        	else if(choiceTry == 2)
        	{
				b1 = new FishingBoat(); 
				b1.setBoatName("Fishing Boat");
        		bool = false; 
        		
        	}
        	else
        	{
        		System.out.println("Invalid input"); 
                System.out.println("Please select the boat of your choice:"); 
                System.out.println("1: normal boat, \n2: fishing boat");
               	choice = null;
            	choiceTry = 0; 
            	choice = input.nextLine(); 
                bool = true; 
        		
        	}
        	
        	
		}
		

    	
       	choice = null;
    	choiceTry = 0; 
    	
    	
	}
	
	public String getBoatUsed() {
		
		return b1.boatName(); 
	}
	


}
