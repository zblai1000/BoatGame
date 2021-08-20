import java.util.Random;
import java.util.Scanner; 

public class Dice {

    //attributes

    private int diceNum;
    private int roller; 

    Random randomNumbers = new Random(); 
    Scanner input = new Scanner(System.in); 

    //constructors

    public Dice() {
        
        diceNum = 0;
        roller = 0; 

    }

    public Dice (int r) {

    
        roller = r; 


    }

    //setters and getters

    public void rollDice() {
        
      
        System.out.println("Enter 1, 2 or 3: ");
        
        try {
        	
            roller = input.nextInt();
    
            if(roller == 1) //1st roll method
            {
                diceNum = 1 + randomNumbers.nextInt(6); 

                setDiceNum(diceNum); 
            }
            else if(roller == 2) //2nd roll method 
            {
            	int limiter = 1 + randomNumbers.nextInt(3); 
            	diceNum = limiter + randomNumbers.nextInt(4); 
            	setDiceNum(diceNum); 
            }
            else if(roller == 3) //3rd roll method
            {
            	int limiter = 1 + randomNumbers.nextInt(4); 
            	diceNum = limiter + randomNumbers.nextInt(3); 
            	setDiceNum(diceNum); 
            }
            else
            {
            	throw new IllegalArgumentException("Invalid input. You can only insert 1 "
            			+ " or 2 or 3 to continue");
            }
            
            
        }

        catch (IllegalArgumentException e) {

            System.out.println("The roll is invalid!");

        }
        

    }

    public int getDiceNum() {
    	
    	 

        return diceNum;

    }

	public void setDiceNum(int diceNum) {
		this.diceNum = diceNum;
	}
    





















}
