import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner; 
import java.util.StringTokenizer;

public class Project implements ActionListener 
{
   static JFrame frame = new JFrame("Find my Item"); 
   static Container contentPane = frame.getContentPane();
   static CardLayout cardLayout = new CardLayout();
   static JTextField username = new JTextField("", 10);
   static JTextField username2 = new JTextField("", 10);
   static JTextField password = new JTextField("", 10);
   static JTextField phone = new JTextField("", 10);
   static JTextField firstName = new JTextField("", 10);
   static JTextField lastName = new JTextField("", 10);
   static JTextField dateOfBirth = new JTextField("MMDDYYYY", 10);
   //static JTextField address = new JTextField("", 10);
   static JTextField email = new JTextField("", 10);
   static JTextField email2 = new JTextField("", 10);
   static JTextField itTF = new JTextField ("",10);
   static JTextField date = new JTextField("MMDDYYYY", 10);
   static JTextField userLogin = new JTextField("", 10);
   static JTextField passLogin = new JTextField("", 10);
   static JTextField answer1 = new JTextField("", 10);
   static JTextField answer2 = new JTextField("", 10);
   static JTextField security1 = new JTextField("",15);
   static JTextField security2 = new JTextField("",15);
   static JTextField security3 = new JTextField("",15);
   static JButton button[] = new JButton[100];
   static JPanel panel[] = new JPanel[60];
   static JPanel Blank[] = new JPanel[20];
   static Person[] array = new Person[100];
   static String user;
   static String pass;
   static String num;
   static String first;
   static String last;
   static String birth;
   static String mail;
   static String it;
   static String created;
   static String answer;
   static String reset = "";
   static int count;
   static int loginError;
   static int Q1; 
   static boolean fail;
   //static Database d = update();

   
   public static void main(String[] args)
   {
       contentPane = (JPanel) frame.getContentPane();
       contentPane.setLayout(cardLayout=new CardLayout());
       
       JLabel reg1 = new JLabel("<html><font size=10><b>Register your item</b></html>", JLabel.CENTER);
       JLabel reg2 = new JLabel("<html><font size=10><b>Register your item</b></html>", JLabel.CENTER);
       JLabel reg3 = new JLabel("<html><font size=10><b>Register your item</b></html>", JLabel.CENTER);
       JLabel reg4 = new JLabel("<html><font size=10><b>Register your item</b></html>", JLabel.CENTER);
       JLabel reg5 = new JLabel("<html><font size=10><b>Register your item</b></html>", JLabel.CENTER);
       JLabel userLabel = new JLabel("Username:");
       JLabel userLabel2 = new JLabel("Username:");
       JLabel passwordLabel = new JLabel("Password:");
       JLabel phoneLabel = new JLabel("Phone Number:");
       JLabel firstLabel = new JLabel("First Name:");
       JLabel lastLabel = new JLabel("Last Name:");
       JLabel birthLabel = new JLabel("Date of Birth:");
       //JLabel addressLabel = new JLabel("Address:");
       JLabel emailLabel = new JLabel("Email Address:");
       JLabel itLabel = new JLabel("What is the item (e.g. Laptop, phone, etc.): ");
       JLabel emailLabel2 = new JLabel("Email Address:");
       JLabel dateLabel = new JLabel("Today's Date:");
       JLabel lostLabel = new JLabel("<html><font size=10><b>Item Lost</b></html>", JLabel.CENTER);
       JLabel label1 = new JLabel("<html><font size=10><b>Pie Device Locator</b></html>", JLabel.CENTER);
       JLabel label2 = new JLabel("<html><font size=10><b>Pie Device Locator</b></html>", JLabel.CENTER);
       JLabel lostMessage = new JLabel("It is unfortunate that you have lost your item. We are currently tracking your item as we speak! It'll take roughly 10 minutes until we locate it.");
       JLabel foundLabel = new JLabel("Have you found your item yet?");
       JLabel foundMessage = new JLabel("Gender: ", JLabel.RIGHT); //Do this later
       JLabel loginLabel = new JLabel("<html><font size=10><b>Log In</b></html>", JLabel.CENTER);
       JLabel userLoginLabel = new JLabel("Please enter your username: ");
       JLabel passLoginLabel = new JLabel("Please enter your password: ");
       JLabel successLabel = new JLabel("You have successfully logged in!");
       JLabel errorLabel = new JLabel("Error: Either your username or password is incorrect. Please try again.");
       JLabel question1 = new JLabel("What is your favorite hobby?");
       JLabel question2 = new JLabel("What was your childhood nickname?");
       JLabel question3 = new JLabel("Where were you born?");
       JLabel error1 = new JLabel("Incorrect Answer. Please Try Again");
       JLabel error2 = new JLabel("Incorrect Answer. Please Try Again");
       JLabel exceed1 = new JLabel("Sorry, you have exceeded the amount of tries available.");
       JLabel exceed2 = new JLabel("Sorry, you have exceeded the amount of tries available.");
       JLabel forget1 = new JLabel("<html><font size=10><b>Forgot Username and Password</b></html>", JLabel.CENTER);
       JLabel forget2 = new JLabel("<html><font size=5><b>Did you forget your username or password?</b></html>", JLabel.CENTER);
       JLabel forget3 = new JLabel("<html><font size=10><b>Forgot Username</b></html>", JLabel.CENTER);
       JLabel forget4 = new JLabel("<html><font size=5><b>Please enter your Email Address</b></html>", JLabel.CENTER);
       JLabel forget5 = new JLabel("<html><font size=10><b>Forgot Password</b></html>", JLabel.CENTER);
       JLabel forget6 = new JLabel("<html><font size=5><b>Please Enter your Username</b></html>", JLabel.CENTER);
       JLabel loginMenu = new JLabel("<html><font size=10><b>Login Menu</b></html>", JLabel.CENTER);
       JLabel pickLabel = new JLabel("<html><font size=5><b>Please Pick the Security Question you prefer.</b></html>", JLabel.CENTER);
       
       ActionListener AL = new Project();
       
       button[0] = new JButton("1. Register");
       button[1] = new JButton("2. Log in");
       button[2] = new JButton("3. Forget Username and Password");
       button[3] = new JButton("4. Exit");
       button[4] = new JButton("Register");
       button[5] = new JButton("Back");
       button[6] = new JButton("Log in");
       button[7] = new JButton("Back");
       button[8] = new JButton("1. Username");
       button[9] = new JButton("2. Password");
       button[10] = new JButton("3. Back to Main Menu");
       button[11] = new JButton("Confirm");
       button[12] = new JButton("1. Find Item");
       button[13] = new JButton("2. Delete Account");
       button[14] = new JButton("3. Update Information");
       button[15] = new JButton("4. Log Out");
       button[16] = new JButton("Return");
       button[17] = new JButton("Confirm");
       button[18] = new JButton("Return");
       button[19] = new JButton("1. Favorite Hobby");
       button[20] = new JButton("2. Childhood Nickname");
       button[21] = new JButton("3. Place of Birth");
       button[22] = new JButton("4. Return");
       button[23] = new JButton("Confirm");
       button[24] = new JButton("Return");
       button[25] = new JButton("Confirm");
       button[26] = new JButton("Return");
       button[27] = new JButton("Confirm");
       button[28] = new JButton("Return");
       
       for(int i = 0; i <= 28; i++)
       {
         button[i].addActionListener(AL);
       }

       //Main Panel / Top Menu
       panel[0] = new JPanel(new GridLayout(3,1,2,2));          
       panel[1] = new JPanel(new FlowLayout());
       panel[11] = new JPanel(new BorderLayout());
       Blank[1] = new JPanel();
       panel[11].add(label1, BorderLayout.CENTER);
       
       for(int i = 0; i <=3; i++)
       {
         panel[1].add(button[i]);
       }
       
       contentPane.add("panel 0", panel[0]);
       panel[0].add(panel[11]);
       panel[0].add(Blank[1]);
       panel[0].add(panel[1]);
       
       //Register
       panel[2] = new JPanel(new BorderLayout());  
       panel[3] = new JPanel(new GridLayout(9,2,1,1));
       panel[4] = new JPanel(new FlowLayout());
       panel[5] = new JPanel(new BorderLayout());
       Blank[3] = new JPanel();
       Blank[4] = new JPanel();
       Blank[5] = new JPanel();
       
       contentPane.add("panel 5", panel[5]);
       
       panel[2].add(reg1, BorderLayout.CENTER);
       
       panel[3].add(userLabel);
       panel[3].add(username);
       panel[3].add(passwordLabel);
       panel[3].add(password);
       panel[3].add(phoneLabel);
       panel[3].add(phone);
       panel[3].add(firstLabel);
       panel[3].add(firstName);
       panel[3].add(lastLabel);
       panel[3].add(lastName);
       panel[3].add(birthLabel);
       panel[3].add(dateOfBirth);
       panel[3].add(emailLabel);
       panel[3].add(email);
       panel[3].add(itLabel);
       panel[3].add(itTF);
       panel[3].add(dateLabel);
       panel[3].add(date);
       /*panel[3].add(question1);
       panel[3].add(security1);
       panel[3].add(question2);
       panel[3].add(security2);
       panel[3].add(question3);
       panel[3].add(security3); */

       panel[4].add(button[4]);
       panel[4].add(button[5]);
       
       panel[5].add(panel[2], BorderLayout.NORTH);
       panel[5].add(panel[3], BorderLayout.CENTER);
       panel[5].add(panel[4], BorderLayout.SOUTH);
       
       //Log In
       panel[6] = new JPanel(new BorderLayout());  
       panel[7] = new JPanel(new GridLayout(2,2,1,1));
       panel[8] = new JPanel(new FlowLayout());
       panel[9] = new JPanel(new GridLayout(3,1,1,1));
       
       contentPane.add("panel 9", panel[9]);
       
       panel[6].add(loginLabel, BorderLayout.CENTER);
       
       panel[7].add(userLoginLabel);
       panel[7].add(userLogin);
       panel[7].add(passLoginLabel);
       panel[7].add(passLogin);
       
       panel[8].add(button[6]);
       panel[8].add(button[7]);
       
       panel[9].add(panel[6]);
       panel[9].add(panel[7]);    
       panel[9].add(panel[8]);  
       
       //Forget Username and Password [Part 1]
       panel[10] = new JPanel(new BorderLayout());
       panel[11] = new JPanel(new BorderLayout());
       panel[12] = new JPanel(new FlowLayout());
       panel[13] = new JPanel(new GridLayout(3,1,2,2));
       
       contentPane.add("panel 13", panel[13]);
       panel[10].add(forget1, BorderLayout.CENTER);
       panel[11].add(forget2, BorderLayout.CENTER);
       panel[12].add(button[8]);
       panel[12].add(button[9]);
       panel[12].add(button[10]);
       panel[13].add(panel[10]);
       panel[13].add(panel[11]);
       panel[13].add(panel[12]);
       
       //Forget Username
       panel[14] = new JPanel(new BorderLayout());
       panel[15] = new JPanel(new BorderLayout());
       panel[16] = new JPanel(new FlowLayout());
       panel[17] = new JPanel(new FlowLayout());
       panel[18] = new JPanel(new GridLayout(4,1,2,2));
       
       contentPane.add("panel 18", panel[18]);
       
       panel[14].add(forget3, BorderLayout.CENTER);
       panel[15].add(forget4, BorderLayout.CENTER);
       panel[16].add(emailLabel2);
       panel[16].add(email2);
       panel[17].add(button[11]);
       panel[17].add(button[16]);
       panel[18].add(panel[14]);
       panel[18].add(panel[15]);
       panel[18].add(panel[16]);
       panel[18].add(panel[17]);
       
       //Login Menu
       panel[19] = new JPanel(new BorderLayout());
       panel[20] = new JPanel(new FlowLayout());
       panel[21] = new JPanel(new FlowLayout());
       panel[22] = new JPanel(new GridLayout(3,1,2,2));
       
       contentPane.add("panel 22", panel[22]);
       
       panel[19].add(loginMenu);
       panel[21].add(button[12]);
       panel[21].add(button[13]);
       panel[21].add(button[14]);
       panel[21].add(button[15]);
       panel[22].add(panel[19]);
       panel[22].add(panel[20]);
       panel[22].add(panel[21]);
       
       //Forget Password
       panel[23] = new JPanel(new BorderLayout());
       panel[24] = new JPanel(new BorderLayout());
       panel[25] = new JPanel(new FlowLayout());
       panel[26] = new JPanel(new FlowLayout());
       panel[27] = new JPanel(new GridLayout(4,1,2,2));
       
       contentPane.add("panel 27", panel[27]);
       
       panel[23].add(forget5, BorderLayout.CENTER);
       panel[24].add(forget6, BorderLayout.CENTER);
       panel[25].add(userLabel2);
       panel[25].add(username2);
       panel[26].add(button[17]);
       panel[26].add(button[18]);
       panel[27].add(panel[23]);
       panel[27].add(panel[24]);
       panel[27].add(panel[25]);
       panel[27].add(panel[26]);
       
       //Security Question Choices
       panel[28] = new JPanel(new BorderLayout());
       panel[29] = new JPanel(new BorderLayout());
       Blank[6] = new JPanel(new FlowLayout());
       panel[30] = new JPanel(new FlowLayout());
       panel[31] = new JPanel(new GridLayout(4,1,2,2));       
       
       contentPane.add("panel 31", panel[31]);
       
       panel[28].add(reg2, BorderLayout.CENTER);
       panel[29].add(pickLabel, BorderLayout.CENTER);
       panel[30].add(button[19]);
       panel[30].add(button[20]);
       panel[30].add(button[21]);
       panel[30].add(button[22]);
       panel[31].add(panel[28]);
       panel[31].add(panel[29]);
       panel[31].add(Blank[6]);
       panel[31].add(panel[30]);
       
       //Security Question 1
       panel[32] = new JPanel(new BorderLayout());
       panel[33] = new JPanel(new FlowLayout());
       panel[34] = new JPanel(new FlowLayout());
       panel[35] = new JPanel(new GridLayout(3,1,2,2));       
       
       contentPane.add("panel 35", panel[35]);
       
       panel[32].add(reg3, BorderLayout.CENTER);
       panel[33].add(question1);
       panel[33].add(security1);
       panel[34].add(button[23]);
       panel[34].add(button[24]);
       panel[35].add(panel[32]);
       panel[35].add(panel[33]);
       panel[35].add(panel[34]);
       
       //Security Question 2
       panel[36] = new JPanel(new BorderLayout());
       panel[37] = new JPanel(new FlowLayout());
       panel[38] = new JPanel(new FlowLayout());
       panel[39] = new JPanel(new GridLayout(3,1,2,2));       
       
       contentPane.add("panel 39", panel[39]);
       
       panel[36].add(reg4, BorderLayout.CENTER);
       panel[37].add(question2);
       panel[37].add(security2);
       panel[38].add(button[25]);
       panel[38].add(button[26]);
       panel[39].add(panel[36]);
       panel[39].add(panel[37]);
       panel[39].add(panel[38]);       
       
       //Security Question 3
       panel[40] = new JPanel(new BorderLayout());
       panel[41] = new JPanel(new FlowLayout());
       panel[42] = new JPanel(new FlowLayout());
       panel[43] = new JPanel(new GridLayout(3,1,2,2));       
       
       contentPane.add("panel 43", panel[43]);
       
       panel[40].add(reg5, BorderLayout.CENTER);
       panel[41].add(question3);
       panel[41].add(security3);
       panel[42].add(button[27]);
       panel[42].add(button[28]);
       panel[43].add(panel[40]);
       panel[43].add(panel[41]);
       panel[43].add(panel[42]);   
       
       frame.setSize(800,500);
       frame.setVisible(true);
       frame.setResizable(true); 
       frame.setLocation(100,50);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   /*public static Database update() throws IOException{
	
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
			String birth = token.nextToken();
			/*int address1 = Integer.parseInt(token.nextToken());
			String address2 = token.nextToken();
			String address3 = token.nextToken();
			String email = token.nextToken();
			String descript = token.nextToken();
			String created = token.nextToken();
			int Q1 = Integer.parseInt(token.nextToken());
			String answer = input.nextLine();
			Person p = new Person(user, pass, phone, first + " " + last, birth , email, 
                               descript, created, item, Q1, answer);
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
			String birth = token1.next();
			/*int address1 = token1.nextInt();
			String address2 = token1.next();
			String address3 = token1.next(); 
			String email = token1.next();
			String descript = token1.next();
			String created = token1.next();
			int Q1 = token1.nextInt();
			String answer = token1.next();
			Person p1 = new Person(user, pass, phone, first + " " + last, birth , email, 
                               descript, created, item1, Q1, answer);
         Node n1 = new Node(p1);
			d.add(n1); 
		}
		return d;
	} */

   
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      
      //Go to "Register" Button
      if (source==button[0]) 
      {
         cardLayout.show(contentPane, "panel 5"); return;
      }
      
      //Go to "Log In" Button
      if (source==button[1]) 
      {
         cardLayout.show(contentPane, "panel 9"); return;
      }   
      
      //Go to "Forget Username and Password" Button       
      if (source==button[2]) 
      {
         cardLayout.show(contentPane, "panel 13"); return;
      }
      
      //Exit Program
      if (source==button[3]) 
      {
         frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      }
      
      //Register a user (Do Later)
      if (source==button[4]) 
      {
         user = username.getText();
         pass = password.getText();
         num = phone.getText();
         first = firstName.getText();
         last = lastName.getText();
         birth = dateOfBirth.getText();
         mail = email.getText();
         it = itTF.getText();
         created = date.getText();
         
         cardLayout.show(contentPane, "panel 31"); return;
      }
      
      //Go back to Main Menu from Register
      if (source==button[5])
      {
         username.setText(reset);
         password.setText(reset);
         phone.setText(reset);
         firstName.setText(reset);
         lastName.setText(reset);
         dateOfBirth.setText("MMDDYYYY");
         email.setText(reset);
         itTF.setText(reset);
         date.setText("MMDDYYYY");
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Log in
      if (source==button[6])
      {
         /*JOptionPane.showMessageDialog(frame, "Incorrect Username and Password. Try again!",
                                              "Error Message", JOptionPane.ERROR_MESSAGE); */
                                              
         //Top is an erro message for Failed login
         cardLayout.show(contentPane, "panel 22"); return;
      } 
          
          
      //Go back to main menu
      if (source==button[7]) 
      {
         userLogin.setText(reset);
         passLogin.setText(reset);
         cardLayout.show(contentPane, "panel 0"); return;
      } 
      
      //Forgot Username
      if (source==button[8]) 
      {
         cardLayout.show(contentPane, "panel 18"); return;
      }
      
      //Forgot Password
      if (source==button[9]) 
      {
         cardLayout.show(contentPane, "panel 27"); return;
      }

      //Go back to Main Menu Button
      if (source==button[10])
      {
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Uses *Correct email to grab username
      if (source==button[11])
      {
         //If email matches, then Pop up dialog that shows the users username
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      if (source==button[12])
      {
      }
      
      if (source==button[13])
      {            
      }
      
      if (source==button[14])
      {  
      }
          
      //Log out button
      if (source==button[15]) 
      {
         JOptionPane.showMessageDialog(frame, "You have Successfully logged out!");
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Return to "Forgot User and Pass" Panel from Forgot User
      if (source==button[16]) 
      {
         email2.setText(reset);
         cardLayout.show(contentPane, "panel 13"); return;
      }
      
      if (source==button[17]) 
      {
         //If right, go to Security Questions panel for that person
         //Else Pop up saying that the Username is wrong
      }
      
      //Return to "Forgot User and Pass" Panel from Forgot Pass
      if (source==button[18]) 
      {
         username2.setText(reset);
         cardLayout.show(contentPane, "panel 13"); return;
      }
      
      //Go to Security Question 1
      if (source==button[19]) 
      {
         cardLayout.show(contentPane, "panel 35"); return;
      }
      
      //Go to Security Question 2
      if (source==button[20]) 
      {
         cardLayout.show(contentPane, "panel 39"); return;
      }
      
      //Go to Security Question 3
      if (source==button[21]) 
      {
         cardLayout.show(contentPane, "panel 43"); return;
      }
      
      //Go Back to Registration 
      if (source==button[22]) 
      {
         cardLayout.show(contentPane, "panel 5"); return;
      }
      
      //Complete Registration with Question 1
      if (source==button[23])  
      {
         Application a = new Application();
         Q1 = 1;
         answer = security1.getText();
      
         //a.register(d, user, pass, num, first, last, birth, mail, it, created, Q1, answer);  
         
         count++; 
      
         JOptionPane.showMessageDialog(frame, "You have Successfully Registered!");
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Return to "Pick Security Questions" From Question 1
      if (source==button[24]) 
      {
         security1.setText(reset);
         cardLayout.show(contentPane, "panel 31"); return;
      }
      
      //Complete Registration with Question 2
      if (source==button[25]) 
      {
         JOptionPane.showMessageDialog(frame, "You have Successfully Registered!");
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Return to "Pick Security Questions" From Question 2
      if (source==button[26]) 
      {
         security2.setText(reset);
         cardLayout.show(contentPane, "panel 31"); return;
      }
      
      //Complete Registration with Question 3
      if (source==button[27]) 
      {
         JOptionPane.showMessageDialog(frame, "You have Successfully Registered!");
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Return to "Pick Security Questions" From Question 3
      if (source==button[28]) 
      {
         security3.setText(reset);
         cardLayout.show(contentPane, "panel 31"); return;
      }
   }
}


