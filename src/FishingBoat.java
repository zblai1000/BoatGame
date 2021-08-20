
public class FishingBoat extends Boat{
	
	public FishingBoat() {
		
		super(); 
	}
	
	//fishing boat will move the boat 1 unit forward as a bonus move on top of the value from the dice 
	@Override
	public void moveForward(int move) {
		
		setLocation(getLocation() + move + 1); 
		
	}
	
	//each time the fishing boat is moved backward 1 unit on the negative direction will be negelected 
	@Override
	public void moveBackward(int move) {
		
		setLocation(getLocation() - move + 1); 
		
	}
	
	@Override
	public String boatName() {
		
		return "Fishing Boat"; 
	}
	
	@Override
	public String toString() {
		
		return String.format("This is a %s", boatName()); 
	}


}
