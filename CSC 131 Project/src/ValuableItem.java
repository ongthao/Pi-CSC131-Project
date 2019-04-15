public class ValuableItem {
	private int tagID; 
	private String status;
		
	static class loc
	{
		public static double x;
		public static double y;
	}
	

	//constructor method for initializing "tagID"
	public ValuableItem(int tagID, String status, double a, double b) {
		//use a random number generator to initialize the tagID
		//make sure that the random number is not duplicated
		//set status to "registered"
		
		this.tagID = tagID;
		this.status = status;
		ValuableItem.loc.x = a;
		ValuableItem.loc.y = b;
	}
	
	//setter and getter methods
	public void setTagID(int tagID) {
		this.tagID = tagID;
	}
	
	//sets status to "lost" , "found"  or "registered"
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setLocation(double x, double y)
	{
		ValuableItem.loc.x = x;
		ValuableItem.loc.y = y;
	}
	
	public int getTagID() {
		return tagID;
	}
	
	public String getStatus() {
		return status;
	}
	
	public loc getLocation() {
		return new loc();
	}
	
	//used for sending beams every 10 minutes to update location
	public loc itemLost() {
		//writes to a file (sends info about its tagID and location)
		double temp1 = Math.round((Math.random()*Math.random()*6355)*100)/100D;
		double temp2 = Math.round((Math.random()*Math.random()*6355)*-100)/100D;
		setLocation(temp1,temp2);
		setStatus("Lost");
		return getLocation();
	}
   
   //writes the location in (x,y) format
   public String toString() {
	  return String.format("TagID: %s %nStatus: %s %nLocation: (%s, %s)", tagID, status, loc.x, loc.y);
   }
}
