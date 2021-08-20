
public class NormalBoat extends Boat{

	public NormalBoat() {
		
		super(); 
	}
	
	@Override
	public String boatName() {
		
		return "Normal Boat"; 
	}
	
	@Override
	public String toString() {
		
		return String.format("This is a %s", boatName()); 
	}
	
}
