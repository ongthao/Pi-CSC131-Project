import java.util.*; 

public class Application {
	public static void main(String[] args) {
		
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
		//prompt user such as "Is your item lost?"
		//ask security the 2 questions 
		//then signals the item to beam location every 10 minutes
	}
	
	//user logs in if they already have an existing account
	public static void logIn() {
		
	}
}
