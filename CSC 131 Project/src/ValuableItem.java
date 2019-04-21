import java.util.Timer;
import java.util.TimerTask;

public class ValuableItem {
	private Timer timer = new Timer();
	private int tagID; 
	private String status;
	private double x;
	private double y;
	
	//Default Constructor
	public ValuableItem() {
		tagID = 0;
		status = "";
		x = 0.0;
		y = 0.0;
	}
	
	//constructor method for initializing "tagID"
	public ValuableItem(int tagID, String status, double a, double b) {
		//use a random number generator to initialize the tagID
		//make sure that the random number is not duplicated
		//set status to "registered"
		
		this.tagID = tagID;
		this.status = status;
		this.x = a;
		this.y = b;
	}
	
	//setter and getter methods
	public void setTagID(int tagID) {
		this.tagID = tagID;
	}
	
	//sets status to "lost" , "found"  or "registered"
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public int getTagID() {
		return tagID;
	}
	
	public String getStatus() {
		return status;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	//Method that beams location every 10 minutes
    public 	void lost() {
        timer.schedule(new TimerTask() {
        	@Override
            public void run() {
	                System.out.println(itemLost());
	                if((status == "Found") || (status == "found"))
	                {
	                	System.out.println("The Item Has Been Found!");
	                	timer.cancel();
	                }
            }
            
        	//used for sending beams every 10 minutes to update location
        	public String itemLost() {
        		//writes to a file (sends info about its tagID and location
        		double temp1 = Math.round((Math.random()*Math.random()*6355)*100)/100D;
        		double temp2 = Math.round((Math.random()*Math.random()*6355)*100)/100D;
        		setStatus("Lost");
        		setX(temp1);
        		setY(temp2);
        		return String.format("Current Location: (%s, %s)", x, y);
        		
        	}
        	
        	public void itemFound() {
        		setStatus("Found");
        	}
        }, 0, 3 * 1000); // Change the last three numbers to desired time. (Minutes * Seconds * Milliseconds)]
        				 // For 10 minutes put 10 * 60 * 1000 in place of 3 * 1000	
    }
   
   //writes the location in (x,y) format
   public String toString() {
	  return String.format("TagID: %s %nStatus: %s %nLocation: (%s, %s)", tagID, status, x, y);
   }
}
