import java.util.*; 

public class Application {
	public static void main(String[] args) {
		System.out.println("Hello Team Pi");
	}
	
	//purpose of this method is to create a database of values we are getting from the text file (if the text file is not null)
	public static void update() {
		//if the text file is not null
			//read values from the text file and create the appropriate objects to update the database. 
	}
	
	//registers the valuable item/make button for register
	public static void register() {
		ValuableItem val = new ValuableItem();
		//prompt for username, password, etc.
		
		//use "val" as the tagID for the Person class 
		
		//all their info (the default "Person()" is just here as a placeholder, it should be changed to its actual constructor)
		Person s = new Person();
		//create a node to add into database linked list
	    Node n = new Node(s); 
	    //database linked list's "front" node is now the new person node that was recently created
	    Database d = new Database(n); 
	}
	
	//prompts user to see if the valuable item is lost/Make button for lost
	public static void lost() {
		//in GUI create a "Lost?" button
		//login/authentication (after 2 weeks)
		//ask security the 2 questions 
		//then signals the item to beam location every 10 minutes for GPS location (valuableitem.itemLost() (G)
		//gets item's TagID and info from "database" (X,T,Y) 
		//sets item's status to "lost" in both the "database" and "valuableitem" classes
		//if item is found.....print out informations
			//System.out.print("Owner X with Address Y is notified that Owner's item I with Tag ID T was found at GPS location G");
			//set the status to "found" or "Registered"
	}
	
	//user logs in if they already have an existing account/will need this to log into another person's phone or device to find their item
	public static void logIn() {
		
	}

	//after 2 weeks
	public static void forgotUserOrPass() {
		//ask security questions
		//send email verification (send the user an email/the email is a pre-written textfile that is read by the class)
		//return username or prompt to change password
	}
	
	//most of the stuff we are comparing are Strings 
	public static void dataValid() {
		
	}
}
