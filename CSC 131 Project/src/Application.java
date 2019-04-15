import java.util.*;
import java.io.*;

public class Application {
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		//database linked list's "front" node is the most recent registered account
		Database d = update();
		System.out.println("Welcome to Pie Device Locator.\nPlease select an option:\n1. Register\n2. Log In\n3.Forget Username and Password"); 
		String input = kb.next(); 
		while(input.equalsIgnoreCase("1") || input.equalsIgnoreCase("Register") || input.equalsIgnoreCase("2") || input.equalsIgnoreCase("Log In"))  {
			if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("register")) {
				d.add(register(d, kb));
			}else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("log in")) {
				//"n" now represents the current user that is registered. 
				Node n = logIn(d, kb);
				System.out.print("Is your device lost? (yes/no)");
				String answer = kb.next();
				if (answer.equalsIgnoreCase("yes")) {
					lost(n);
				}else {
					System.out.println("Thank you for using this application!");
				}
			}else {
				forgotUserAndPass(n);
			}
		}
		System.out.println("Not a valid option, try again");
	}

	// purpose of this method is to create a database of values we are getting from
	// the text file (if the text file is not null)
	public static Database update() throws IOException{
		// read values from the text file and create the appropriate objects to update
		// the database.
		ValuableItem val = new ValuableItem(12345,  "registered", 22.1, 22.2);
		Person p = new Person("johnsmith1", "Leavemealone1", 12345, "9162781234", "John" + " " + "Smith", 16 + " " + "March" + " " +  1999,
				8155 + " " + "Maple" + " " + "Drive", "jsmith@gmail.com", 12 + " " + "January" + " " +  2019, val);
		Node n = new Node(p);
		Database d = new Database(n);
		// reading from the text file
		File f = new File("Testfile.txt");
		Scanner input = new Scanner(f);
		// adding the new users to the database after the admin account
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner token = new Scanner(line);
			String user = token.next();
			String pass = token.next();
			int tagID = Integer.parseInt(token.next());
			String phone = token.next();
			String first = token.next();
			String last = token.next();
			int date1 = token.nextInt();
			String date2 = token.next();
			int date3 = token.nextInt();
			int address1 = token.nextInt();
			String address2 = token.next();
			String address3 = token.next();
			String email = token.next();
			int created1 = token.nextInt();
			String created2 = token.next();
			int created3 = token.nextInt();
			String status = token.next();
			ValuableItem val1 = new ValuableItem(tagID, status, 22.2, 22.1);
			Person p1 = new Person(user, pass, tagID, phone, first + " " + last, date1 + " " + date2 + " " + date3,
					address1 + " " + address2 + " " + address3, email, created1 + " " + created2 + " " + created3, val1);
			d.add(p1); 
		}
		return d;
	}

	// registers the valuable item/make button for register
	public static Node register(Database d, Scanner kb) {
		ValuableItem val = new ValuableItem(12345, "registered", 12345, 12345); // ****only temp****
		// prompt for username, password, etc.
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
		System.out.print("Today's Date: ");
		String created = kb.nextLine();
		// all their info (the default "Person()" is just here as a placeholder, it
		// should be changed to its actual constructor)
		/* NEED TO DISCUSS "STATUS" and "SECURITY" VARIABLES! */
		Person s = new Person(user, pass, val.getTagID(), phone, name, bday, addr, mail, created, val);
		// create a node to add into database linked list
		Node n = new Node(s);
		return n;
	}

	// prompts user to see if the valuable item is lost/Make button for lost
	public static void lost(Node n) {
			Scanner kb = new Scanner(System.in);
			String answer = "";
			//in GUI create a "Lost?" button
			//ask security the 2 questions 
			//sets item's status to "lost" in both the "database" and "valuableitem" classes
			n.getP().getItem().setStatus("lost");
			//then signals the item to beam location every 10 minutes for GPS location (valuableitem.itemLost() (G)
			System.out.println(n.getP().getItem().itemLost());
			if(n.getP().getItem().getStatus().equalsIgnoreCase("lost")) {
				<V> ScheduledFuture<V> schedule(Callable<V> v.itemLost(), long 10, TimeUnit MINUTES);
				System.out.print("Have you found your item yet? (y/n): ");
				answer = kb.next();
				if(answer.equalsIgnoreCase("y"))
					n.getP().getItem().setStatus("found");
				else
					lost(n);
			}
			if(n.getP().getItem().getStatus().equalsIgnoreCase("found"))
				System.out.print("\nOwner " + n.getP().getUser() + " with Address " + n.getP().getAddress() + " is notified that Owner's item " + n.getP().getItem() + " with Tag ID " + n.getP().getTagID() + " was found at GPS Location " + n.getP().getItem().getLocation());
			//gets item's TagID and info from "database" (X,T,Y) 
			
			//if item is found.....print out informations
				//System.out.print("Owner X with Address Y is notified that Owner's item I with Tag ID T was found at GPS location G");
				//set the status to "found" or "Registered"
		}

	// user logs in if they already have an existing account/will need this to log
	// into another person's phone or device to find their item
	public static Node logIn(Database d, Scanner kb) {
		int num = 0; // signal for error
		while (num == 0) {
			Node curr = d.getFront();
			System.out.print("Please enter your username: ");
			String user = kb.next();
			System.out.print("Please enter your password: ");
			String pass = kb.next();
			while (curr != null) {
				if (user.equalsIgnoreCase(curr.getP().getUser())) { // need to check if these getter methods are in
																	// place
					if (pass.equalsIgnoreCase(curr.getP().getPass())) {
						System.out.print("You have successfully logged in.");
						num = 1; // need to check if i really need this
						return curr;
					}
				}
			}
			System.out.print("Error: Either your username or password is incorrect. Please try again.");
		}
		return null;
	}

	public static void forgotUserAndPass(Node n) {
		Scanner kb = new Scanner(System.in);
		String email = "";
		String pass = "";
		int tries = 1;
		// ask security questions
		System.out.println(n.getP().getSecurityQ1());
		String answer1 = kb.nextLine();
		while (answer1 != n.getP().getAnswer1() & tries != 4) {
			System.out.print("Incorrect Answer. Please Try Again");
			System.out.println(n.getP().getSecurityQ1());
			//String answer1 = kb.nextLine(); *****DUPLICATE OF LINE 164*****
			tries += 1;
		}
		if (tries == 4) {
			System.out.print("Sorry, you have exceeded the amount of tries available.");
			System.exit(0);
		}
		tries = 1;
		System.out.println(n.getP().getSecurityQ2());
		String answer2 = kb.nextLine();
		while (answer2 != n.getP().getAnswer2() & tries != 4) {
			System.out.print("Incorrect Answer. Please Try Again");
			System.out.println(n.getP().getSecurityQ2());
			//String answer2 = kb.nextLine(); *****DUPLICATE OF LINE 177*****
			tries += 1;
		}
		if (tries == 4) {
			System.out.print("Sorry, you have exceeded the amount of tries available.");
			System.exit(0);
		}
		
		//DONT WORRY ABOUT THIS FOR NOW! (Will need to figure out how to make a draft email using a "textfile" to do this part)
		/*System.out.print("\nSend email Verification? (y/n): ");
		email = kb.nextLine();
		if (email == "y") {
			n.getP().addEmail("Your username is " + n.getP().getUser() + "\nType in your new Password: ");
			pass = kb.nextLine();
			n.getP().setPass() = pass;
		} else
			System.exit(0);*/
		
		// send email verification (send the user an email/the email is a pre-written
		// textfile that is read by the class)
		// return username or prompt to change password
	}
}
