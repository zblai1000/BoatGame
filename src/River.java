import java.util.ArrayList;

public class River {
    public char[] Map = {
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
        '-','-','-','-','-','-','-','-','-','-',
    };
    
  

    public River()
    {
       
    }
        


    public River(char[] M){

        Map = M;
    }

    public void displayMap(ArrayList<Obstacle> obstaclelist, int loc1, int loc2) {
       	for(Obstacle o: obstaclelist) {
       		if (o instanceof Current) {
       			Map[o.getLocation()] = 'C';
       		}
       		else if (o instanceof Trap) {
       			Map[o.getLocation()] = '#';
       		}
     	}
       	if(loc1 <= 100 && loc2 <= 100)
       	{
            Map[loc1 - 1] = 'A';
            Map[loc2 - 1] = 'B'; 
            printMap();
            Map[loc1 - 1] = '-';
            Map[loc2 - 1] = '-'; 
       	}
       	else
       	{
       		if(loc1 > 100)
       		{
       			Map[99] = 'A'; 
       		}
       		else if(loc2 > 100)
       		{
       			Map[99] = 'B'; 
       		}
       	}

    }
    
    public void displayMap(ArrayList<Obstacle> obstaclelist) {
       	for(Obstacle o: obstaclelist) {
       		if (o instanceof Current) {
       			Map[o.getLocation()] = 'C';
       		}
       		else if (o instanceof Trap) {
       			Map[o.getLocation()] = '#';
       		}
     	}
  
       printMap();
    }
    
    private void printMap() {
    	//loop through the Map array and print out
    	for(char c:Map) {
    		System.out.print(c + " ");
    	}
    }

}
   