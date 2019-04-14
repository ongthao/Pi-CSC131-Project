import java.util.*; 

public class Application {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Database d = update();
	    //database linked list's "front" node is the most recent registered account
		d.add(register(d, kb));
		//"n" now represents the current user that is registered. 
		Node n = logIn(d, kb);
	}
	
	//purpose of this method is to create a database of values we are getting from the text file (if the text file is not null)
	public static Database update() {
		//if the text file is not null
			//read values from the text file and create the appropriate objects to update the database. 
		/*THE STUFF BELOW ARE TEMPORARY*/
		Person p = new Person();
		Node n = new Node(p);
		Database d = new Database(n);
		return d;
	}
	
	//registers the valuable item/make button for register
	public static Node register(Database d, Scanner kb) {
		ValuableItem val = new ValuableItem();
		//prompt for username, password, etc.
		System.out.print("Username: "); 
		String user = kb.nextLine();
		System.out.print("Password: ");
		String pass = kb.nextLine();
		System.out.print("Phone number: ");
		String phone = kb.nextLine();
		System.out.print("Actual name: ");
		String name = kb.nextLine();
		System.out.print("Birth: ");
		String bday = kb.nextLine();
		System.out.print("Address: ");
		String addr = kb.nextLine();
		System.out.print("Email: ");
		String mail = kb.nextLine();
		//use "val" as the tagID for the Person class 
		//all their info (the default "Person()" is just here as a placeholder, it should be changed to its actual constructor)
		/*NEED TO DISCUSS  "STATUS" and "SECURITY" VARIABLES!*/
		Person s = new Person(user, pass, val.getTagID(), phone, name, bday, addr, mail);
		//create a node to add into database linked list
	    Node n = new Node(s);
	    return n;
	}
	
	//prompts user to see if the valuable item is lost/Make button for lost
	public static void lost(Database d) {
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
	public static Node logIn(Database d, Scanner kb) {
		int num = 0; //signal for error
		while(num == 0) {
			Node curr = d.getFront();
			System.out.print("Please enter your username: ");
			String user = kb.next();
			System.out.print("Please enter your password: ");
			String pass = kb.next();
			while(curr != null) {
				if(user.equalsIgnoreCase(curr.getUser()) { //need to check if these getter methods are in place 
					if(pass.equalsIgnoreCase(curr.getPass())) {
						System.out.print("You have successfully logged in.");
						num = 1; //need to check if i really need this
						return curr; 
					}
				} 
			}
			System.out.print("Error: Either your username or password is incorrect. Please try again.");
		}
	}

	//after 2 weeks
	public static void forgotUserOrPass(Database d) {
		//ask security questions
		//send email verification (send the user an email/the email is a pre-written textfile that is read by the class)
		//return username or prompt to change password
	}
	
	//most of the stuff we are comparing are Strings
	public static void dataValid() {
		
	}
}
