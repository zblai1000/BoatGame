
public class Object{  
	protected int location;
	
	public Object(int l) {
		
		location = l; 
		
	}
	
	public Object() {
		
		location = 1; 
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	} 

	public void setLocation(int location, int player) {
		this.location = location;
	} 

	
	
	
	
}
