import java.util.*;

public class ValuableItem {
	private int tagID; 
	private String status;
	
	//constructor method for initializing "tagID"
	public ValuableItem() {
		//use a random number generator to initialize the tagID
		//make sure that the random number is not duplicated
		//set status to "registered"
	}
	
	//setter and getter methods
	public void setTagID() {
		
	}
	
	//sets status to "lost"  or "registered"
	public void setStatus() {
		
	}
	
	public void getStatus() {
		
	}
	
	public int getTagID() {
		return 0; 
	}
	
	//used for sending beams every 10 minutes to update location
	public void itemLost() {
		//writes to a file (sends info about its tagID and location)
	}
}
