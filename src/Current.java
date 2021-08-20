
public class Current extends Obstacle{
	
	public Current() {
		
		super(); 
	}
	
	@Override
	public String obstacleType() {
		
		return "Current"; 
	}
	
	@Override
	public String toString() {
		
		return String.format("You had hit a %s!", obstacleType()); 
	}

}
