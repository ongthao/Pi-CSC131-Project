import java.util.*;
import java.io.*;

public class Application {
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		//database linked list's "front" node is the most recent registered account
		Database d = update();
		System.out.println("Welcome to Pie Device Locator.\nPlease select an option:\n1. Register\n2. Log In\n3. Forget Username and Password"); 
		String input = kb.next(); 
		//while(input.equalsIgnoreCase("1") || input.equalsIgnoreCase("Register") || input.equalsIgnoreCase("2") || input.equalsIgnoreCase("Log In"))  {
			if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("register")) {
				register(d, kb);
				System.out.print("Your account has been registered. Do you want to log in? ");
				if(kb.next().equalsIgnoreCase("yes"))
					logIn(d, kb);
			}else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("log in")) {
				//"n" now represents the current user that is registered. 
				Node n = logIn(d,kb);
				System.out.print("\nIs your device lost? (yes/no) ");
				String answer = kb.next();
				if (answer.equalsIgnoreCase("yes")) {
					lost(n);
				}else {
					System.out.println("\n\nThank you for using this application!");
				}
			}else {
				//forgotUserOrPass(d);
			}
		//System.out.println("Not a valid option, try again");
	}
	// purpose of this method is to create a database of values we are getting from
	// the text file (if the text file is not null)
	public static Database update() throws IOException{
	
		// reading from the text file create the appropriate objects to update the database.
		File f = new File("Testfile.txt");
		Scanner input = new Scanner(f);		
		StringTokenizer token = new StringTokenizer(input.nextLine());
		Database d = new Database();
		while (token.hasMoreTokens()) {
			int tagID = Integer.parseInt(token.nextToken());
			String status = token.nextToken();
			double x = Double.parseDouble(token.nextToken());
			double y = Double.parseDouble(token.nextToken());
			ValuableItem item = new ValuableItem(tagID, status, x, y);
			
			String user = token.nextToken();
			String pass = token.nextToken();
			String phone = token.nextToken();
			String first = token.nextToken();
			String last = token.nextToken();
			int birth1 = Integer.parseInt(token.nextToken());
			String birth2 = token.nextToken();
			int birth3 = Integer.parseInt(token.nextToken());
			int address1 = Integer.parseInt(token.nextToken());
			String address2 = token.nextToken();
			String address3 = token.nextToken();
			String email = token.nextToken();
			String descript = token.nextToken();
			int created1 = Integer.parseInt(token.nextToken());
			String created2 = token.nextToken();
			int created3 = Integer.parseInt(token.nextToken());
			Person p = new Person(user, pass, phone, first + " " + last, birth1 + " " + birth2 + " " + birth3,
					address1 + " " + address2 + " " + address3, email, descript, created1 + " " + created2 + " " + created3, item);
			Node n = new Node(p);
			d = new Database(n);
		}
		
		
		// adding the new users to the database after the admin account
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner token1 = new Scanner(line);
			int tagID = Integer.parseInt(token1.next());
			String status = token1.next();
			double x = token1.nextDouble();
			double y = token1.nextDouble();
			ValuableItem item1 = new ValuableItem(tagID, status, x, y);
			
			String user = token1.next();
			String pass = token1.next();
			String phone = token1.next();
			String first = token1.next();
			String last = token1.next();
			int birth1 = token1.nextInt();
			String birth2 = token1.next();
			int birth3 = token1.nextInt();
			int address1 = token1.nextInt();
			String address2 = token1.next();
			String address3 = token1.next();
			String email = token1.next();
			String descript = token1.next();
			int created1 = token1.nextInt();
			String created2 = token1.next();
			int created3 = token1.nextInt();
			Person p1 = new Person(user, pass, phone, first + " " + last, birth1 + " " + birth2 + " " + birth3,
					address1 + " " + address2 + " " + address3, email, descript, created1 + " " + created2 + " " + created3, item1);
			Node n1 = new Node(p1);
			d.add(n1); 
		}
		return d;
	}

	// registers the valuable item/make button for register
	public static void register(Database d, Scanner kb) throws IOException{
		Random r = new Random();
		int tag = 0;
		while(tag == 0) {
			tag = r.nextInt(99998) + 1;
			Node n = d.getFront();
			while(n != null) {
				if(tag != n.getP().getTagID())
					n = n.getHead();
				else {
					tag = 0; 
					break;
				}
			}
		}
		System.out.print(tag);
		double x = r.nextDouble() + 10;
		double y = r.nextDouble() + 10;
		ValuableItem val = new ValuableItem(tag, "registered", x, y); // ****only temp****
		// prompt for username, password, etc.
		System.out.print("\nUsername: ");
		String user = kb.next();
		System.out.print("\nPassword: ");
		String pass = kb.next();
		System.out.print("\nPhone number: ");
		String phone = kb.next();
		System.out.print("\nActual name (first and last): ");
		String name = kb.next();
		String name2 = kb.next();
		System.out.print("\nBirth (in format - day month year; e.g 12 January 1999): ");
		int day = kb.nextInt();
		String month = kb.next();
		int year = kb.nextInt();
		System.out.print("\nAddress: ");
		int number = kb.nextInt();
		String street = kb.next();
		String street2 = kb.next();
		System.out.print("\nEmail: ");
		String mail = kb.next();
		System.out.print("\nWhat kind of item is it? (e.g. phone, laptop, notebook, etc.): ");
		String it = kb.next();
		System.out.print("\nToday's Date (in format of \"day month year\"; e.g. 12 January 1999): ");
		int created1 = kb.nextInt();
		String created2 = kb.next();
		int created3 = kb.nextInt();
		// all their info (the default "Person()" is just here as a placeholder, it
		// should be changed to its actual constructor)
		/* NEED TO DISCUSS "STATUS" and "SECURITY" VARIABLES! */
		Person s = new Person(user, pass, phone, name + " " + name2, day + " " + month + " " + year, number + " " + street + " " + street2, mail, it, created1 + " " + created2 + " " + created3, val);
		// create a node to add into database linked list
		Node n = new Node(s);
		d.add(n);
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
		do{
			n.getP().getItem().lost();
			System.out.print("Have you found your item yet? (y/n): \n");
			answer = kb.next();
			if(answer.equalsIgnoreCase("y"))
				n.getP().getItem().setStatus("found");
		}while(n.getP().getItem().getStatus().equalsIgnoreCase("lost"));
		if(n.getP().getItem().getStatus().equalsIgnoreCase("found"))
			System.out.print("\nOwner " + n.getP().getUser() + " with Address " + n.getP().getAddress() + " is notified that Owner's " + n.getP().getDescript() + " with Tag ID " + n.getP().getTagID() + " was found at GPS Location " + n.getP().getItem().getX() + ", " + n.getP().getItem().getY() + ".");
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
			System.out.print("\nPlease enter your username: ");
			String user = kb.next();
			System.out.print("Please enter your password: ");
			String pass = kb.next();
			while (curr != null) {
				if (user.equalsIgnoreCase(curr.getP().getUser())) { 
					if (pass.equalsIgnoreCase(curr.getP().getPass())) {
						System.out.println("\nYou have successfully logged in.");
						return curr;
					}
				}
				else
					curr = curr.getHead();
			}
			System.out.println("Error: Either your username or password is incorrect. Please try again.");
		}
		return null;
	}

	/*public static void forgotUserOrPass(Database d) {
	Scanner kb = new Scanner(System.in);
	String user = "";
	String pass = "";
	String email = "";
	String a = "";
	System.out.println("Did you forget your username or password?");
	String input = kb.nextLine();
	if (input.equalsIgnoreCase("username")) {
		do {
			System.out.println("Enter your email");
			email = kb.nextLine();
			if (email.equals(d.GETSOMETHINGFROMDATABASE)) {
				SQ(d.GETSOMETHINGFROMDATABASE);// security questions
				System.out.println(d.GETSOMETHINGFROMDATABASE);// gets username
			} else {
				System.out.println("We couldn't find that email. Would you like to try again? (y/n): ");
				a = kb.nextLine();
			}
		} while (a.equalsIgnoreCase("y"));`
	}
	else if (input.equalsIgnoreCase("password")) {
		do {
			System.out.println("Enter your username");
			user = kb.nextLine();
			if (user.equals(d.GETSOMETHINGFROMDATABASE)) {
				SQ(d.GETSOMETHINGFROMDATABASE);// security questions
				System.out.println(d.GETSOMETHINGFROMDATABASE);// gets password
			} else {
				System.out.println("We couldn't find that username. Would you like to try again? (y/n): ");
				a = kb.nextLine();
			}
		} while (a.equalsIgnoreCase("y"));
	} else
		System.exit(0);
	}*/
	 
	//DONT WORRY ABOUT THIS FOR NOW! (Will need to figure out how to make a draft email using a "textfile" to do this part)
	/*System.out.print("\nSend Email Verification? (y/n): ");
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
    //}

	/*public static void SQ(Node n)
	{
		Scanner kb = new Scanner(System.in);
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
	
	}*/

	public static void options() {
		//provide a list of options for a user that is logged in
		//options includes: finding a lost item, deleting their account, updating their account information, etc.
	}
	
	public static void delete() {
		
	}
	
	//specify what info to change, Database
	public static void changeInfo(Node n) {
		
	}	
}
