
public class Boat extends Object{

	//attributes
	private String boatName;
	
	public Boat() {
		
		super();
		boatName = "boat"; 
		
	}
	
	public void moveForward(int move) {
		
		setLocation(getLocation() + move); 
		
	}
	
	public void moveBackward(int move) {
		
		setLocation(getLocation() - move); 
		
	}
	
	public String boatName() {
		
		return "boat"; 
	}

	public void setBoatName(String name){

		boatName = name; 
	}

	public String getBoatName(){

		return boatName; 
	}
	
	public String toString() {
		
		return String.format("This is a %s", boatName()); 
	}

}

