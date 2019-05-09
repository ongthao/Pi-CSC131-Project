import java.util.*;
import java.io.*;

public class Application {
	public static void main(String[] args) throws IOException{
      Scanner kb = new Scanner(System.in);
		//database linked list's "front" node is the most recent registered account
		Database d = update();
      menu(d, kb);
	}
   
   public static void menu(Database d, Scanner kb) throws IOException
   {
      dash();
		System.out.println("Welcome to Pie Device Locator.\nPlease input a number to select an option:\n1. Register\n2. Log In\n3. Forget Username and Password\n4. Exit\n"); 
		String input = kb.next(); 
		//while(input.equalsIgnoreCase("1") || input.equalsIgnoreCase("Register") || input.equalsIgnoreCase("2") || input.equalsIgnoreCase("Log In"))  {
		if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("register")) {
            dash();
            System.out.println("User Registration");
   	      register(d, kb);
            reg(d, kb);
		}else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("log in")) {
         	Node n = logIn(d,kb);
            enter(n, d, kb);
		}else if (input.equalsIgnoreCase("3") || input.equalsIgnoreCase("Forget")) {
            forgotUserOrPass(d);
            forget(d, kb);
		}else if (input.equalsIgnoreCase("4") || input.equalsIgnoreCase("exit")) {
         exit();
      }else{
		   System.out.println("Not a valid option, try again \n\n");
         menu(d, kb);
      }
   }
   
   public static void reg(Database d, Scanner kb) throws IOException
   {
	   System.out.print("Your account has been registered. Do you want to log in? (Y/N)");
      String answer = kb.next();
		if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
			Node n = logIn(d,kb);
         enter(n, d, kb);
      }else if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){
         menu(d, kb);
      }else{
         System.out.println("Not a valid option, try again \n\n");
         reg(d, kb);
      }     
   }
   
   public static void enter(Node n, Database d, Scanner kb) throws IOException
   {
      //"n" now represents the current user that is registered. 
		System.out.print("\nIs your device lost? (Y/N) ");
		String answer1 = kb.next();
		if(answer1.equalsIgnoreCase("yes") || answer1.equalsIgnoreCase("y")){
			lost(n);
      }else if(answer1.equalsIgnoreCase("no") || answer1.equalsIgnoreCase("n")){
         System.out.print("\nWould you like to log out? (Y/N) ");
         String answer2 = kb.next();
         if(answer2.equalsIgnoreCase("yes") || answer2.equalsIgnoreCase("y")){
            menu(d, kb);
         }else if(answer2.equalsIgnoreCase("no") || answer2.equalsIgnoreCase("n")){
            enter(n, d, kb);
         }else{
            System.out.println("Not a valid option, Please try again!");
            enter(n, d, kb); 
         }
      }else{
         System.out.println("Not a valid option, Please try again!");
         enter(n, d, kb);
      }
   }
   
   public static void forget(Database d, Scanner kb) throws IOException
   {
		System.out.print("Would you like to try logging in? (Y/N)");
		String ans = kb.next();
		if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
			Node n = logIn(d, kb);
         enter(n, d, kb);
      }else if(ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")){
         menu(d, kb);
      }else{
         System.out.println("Not a valid option, Please try again!");
         forget(d, kb);
      }
   }
   
   public static void exit()
   {
      System.out.println("\nThank you for using this application!");
		System.exit(0);
   }
   
   public static void dash()
   {
      for(int i = 0; i <= 30; i++)
      {
         System.out.print("-");
      }
      System.out.println();
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
			String Q1 = input.nextLine();
			String answer = input.nextLine();
			Person p = new Person(user, pass, phone, first + " " + last, birth1 + " " + birth2 + " " + birth3,
					address1 + " " + address2 + " " + address3, email, descript, created1 + " " + created2 + " " + created3, item, Q1, answer);
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
			String Q1 = input.nextLine();
			String answer = input.nextLine();
			Person p1 = new Person(user, pass, phone, first + " " + last, birth1 + " " + birth2 + " " + birth3,
					address1 + " " + address2 + " " + address3, email, descript, created1 + " " + created2 + " " + created3, item1, Q1, answer);
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
		System.out.print("\nActual First Name (If multiple, join them with the \"-\" symbol): ");
		String name = kb.next();
      System.out.print("\nActual Last Name (If multiple, join them with the \"-\" symbol): ");
		String name2 = kb.next();
		System.out.print("\nBirth (in format - day month year; e.g 12 January 1999): ");
		int day = kb.nextInt();
		String month = kb.next();
		int year = kb.nextInt();
		System.out.print("\nStreet Address (in format - 123 Elmo St): ");
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
		String sec1 = "What is your favorite hobby?";
		String sec2 = "What was your childhood nickname?";
		String sec3 = "Where were you born?";
		System.out.println("Please choose your security question: ");
		System.out.println("1) " + sec1);
		System.out.println("2) " + sec2);
		System.out.println("3) " + sec3);
		int select = kb.nextInt();
		String answer = "";
		String Q1 = "";
		if(select == 1) {
				Q1 = sec1;
				System.out.println(sec1 +  " (One word reply please)");
				answer = kb.next();
		} else if(select == 2) {
				Q1 = sec2;
				System.out.println(sec2 +  " (One word reply please)");
				answer = kb.next();
		} else if(select == 3) {
				Q1 = sec3;
				System.out.println(sec3 + " (One word reply please)");
				answer = kb.next();
		}else 
				System.out.print("No security question listed above was selected");
		Person s = new Person(user, pass, phone, name + " " + name2, day + " " + month + " " + year, number + " " + street + " " + street2, mail, it, created1 + " " + created2 + " " + created3, val, Q1, answer);
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
			System.out.print("Have you found your item yet? (Y/N): \n");
			answer = kb.next();
			if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"))
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
		String ans = "y";
		do {
			 Node curr = d.getFront();
	         dash();
	         System.out.println("User Log in");
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
				System.out.println("Error: Either your username or password is incorrect. Would you like to try again? (y/n) ");
				ans = kb.next();
				while(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
					System.out.print("Please input \'y\' or \'n\' ");
					ans = kb.next();
				}
			}while(ans.equalsIgnoreCase("y"));
			return null;
	}

	public static void forgotUserOrPass(Database d) throws IOException {
		Scanner kb = new Scanner(System.in);
		String user = "";
		String pass = "";
		String email = "";
		String a = "";
		int i, j;
		System.out.println("What did you forget?\n1. Username\n2. Password\n3. Return to Main Menu\n");
		String input = kb.nextLine();
		if (input.equalsIgnoreCase("username") || input.equalsIgnoreCase("user") || input.equalsIgnoreCase("1")) {
			do {
				System.out.println("Enter your email");
				email = kb.nextLine();
				//use while loop to check nodes
				Node curr = d.getFront();
				while(curr != null) {
					if(email.equals(curr.getP().getEmail())) {
						SQ(curr);
						System.out.println("This is your username: " + curr.getP().getUser());
						return;
					}
					else
						curr = curr.getHead();
				}
				System.out.println("We couldn't find that email. Would you like to try again? (y/n): ");
				a = kb.nextLine();
			} while (a.equalsIgnoreCase("y"));
		}else if (input.equalsIgnoreCase("password") || input.equalsIgnoreCase("pass") || input.equalsIgnoreCase("2")) {
			do {
				System.out.println("Enter your username");
				user = kb.nextLine();
				//use while loop to check nodes
				Node curr = d.getFront();
				while(curr != null) {
					if(user.equals(curr.getP().getUser())) {
						SQ(curr);
						System.out.println("Your password is: " + curr.getP().getPass() + "\n");
						return;
					}
					else
						curr = curr.getHead();
				}
				System.out.println("We couldn't find that username. Would you like to try again? (y/n): ");
				a = kb.nextLine();
			} while (a.equalsIgnoreCase("y"));
		}else if (input.equalsIgnoreCase("menu") || input.equalsIgnoreCase("main menu") || input.equalsIgnoreCase("3")){
			menu(d, kb);
      }else{
         System.out.println("Not a valid option, Please try again!");
         forgotUserOrPass(d);
      }
	}
   
	public static void SQ(Node n){
		Scanner kb = new Scanner(System.in);
		int tries = 1;	
		// ask security questions
		System.out.println(n.getP().getSecurityQ1());		
		String answer1 = kb.nextLine();
		while (!answer1.equalsIgnoreCase(n.getP().getAnswer1()) & tries != 4) {
			tries +=1;
			System.out.println("Incorrect Answer. Please Try Again");
			System.out.println(n.getP().getSecurityQ1());
			answer1 = kb.nextLine();
		}
		if (tries == 4) {
			System.out.print("Sorry, you have exceeded the amount of tries available.");
			System.exit(0);
		}
	}
}
