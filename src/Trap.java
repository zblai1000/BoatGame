
public class Trap extends Obstacle{
	
	public Trap() {
		
		super();
	}
	
	@Override
	public String obstacleType() {
		
		return "Trap"; 
	}
	
	@Override
	public String toString() {
		
		return String.format("You had hit a %s!", obstacleType()); 
	}


}
