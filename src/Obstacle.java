
import java.util.Random;


public class Obstacle extends Object{
	
	private int power; 
	
	public Obstacle(int loc, int strength) {
		
		super(loc); 
		power = strength; 
	}
	
	public Obstacle() {
		
		Random r = new Random();
		location = 5 + r.nextInt(95);
		power = 1 + r.nextInt(5);
	}
	
	public String obstacleType() {
		
		return "Obstacle"; 
	}
	
	public String toString() {
		
		return String.format("You had hit an %s!", obstacleType()); 
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public int changePower() {
		Random r = new Random();
		return power = 1 + r.nextInt(5); 
	}

}
