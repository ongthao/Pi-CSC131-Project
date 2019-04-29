import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.io.*;

public class Project implements ActionListener
{
   static JFrame frame = new JFrame("Find my Item"); 
   static Container contentPane = frame.getContentPane();
   static CardLayout cardLayout = new CardLayout();
   static JTextField username = new JTextField("", 10);
   static JTextField password = new JTextField("", 10);
   static JTextField phone = new JTextField("", 10);
   static JTextField fullName = new JTextField("", 10);
   static JTextField dateOfBirth = new JTextField("MM/DD/YYYY", 10);
   static JTextField address = new JTextField("", 10);
   static JTextField email = new JTextField("", 10);
   static JTextField date = new JTextField("MM/DD/YYYY", 10);
   static JTextField userLogin = new JTextField("", 10);
   static JTextField passLogin = new JTextField("", 10);
   static JTextField answer1 = new JTextField("", 10);
   static JTextField answer2 = new JTextField("", 10);
   static JButton button[] = new JButton[100];
   static JPanel panel[] = new JPanel[60];
   static JPanel Blank[] = new JPanel[20];
   static Person[] array = new Person[100];
   static String userLoginV;
   static String passLoginV;
   static int count;
   static boolean fail;
   
   public static void main(String[] args)
   {
       contentPane = (JPanel) frame.getContentPane();
       contentPane.setLayout(cardLayout=new CardLayout());
       
       JLabel reg = new JLabel("<html><font size=5><b>Register your item</b></html>", JLabel.CENTER);
       JLabel userLabel = new JLabel("Username:");
       JLabel passwordLabel = new JLabel("Password:");
       JLabel phoneLabel = new JLabel("Phone Number:");
       JLabel nameLabel = new JLabel("Full Name:");
       JLabel birthLabel = new JLabel("Date of Birth:");
       JLabel addressLabel = new JLabel("Address:");
       JLabel emailLabel = new JLabel("Email Address:");
       JLabel dateLabel = new JLabel("Today's Date:");
       JLabel lostLabel = new JLabel("<html><font size=5><b>Item Lost</b></html>", JLabel.CENTER);
       JLabel label1 = new JLabel("<html><font size=5><b>Pie Device Locator</b></html>", JLabel.CENTER);
       JLabel label2 = new JLabel("<html><font size=5><b>Pie Device Locator</b></html>", JLabel.CENTER);
       JLabel lostMessage = new JLabel("It is unfortunate that you have lost your item. We are currently tracking your item as we speak! It'll take roughly 10 minutes until we locate it.");
       JLabel foundLabel = new JLabel("Have you found your item yet?");
       JLabel foundMessage = new JLabel("Gender: ", JLabel.RIGHT); //Do this later
       JLabel loginLabel = new JLabel("Log In ");
       JLabel userLoginLabel = new JLabel("Please enter your username: ");
       JLabel passLoginLabel = new JLabel("Please enter your password: ");
       JLabel successLabel = new JLabel("You have successfully logged in!");
       JLabel errorLabel = new JLabel("Error: Either your username or password is incorrect. Please try again.");
       //JLabel question1 = new JLabel();
       //JLabel question2 = new JLabel();
       JLabel error1 = new JLabel("Incorrect Answer. Please Try Again");
       JLabel error2 = new JLabel("Incorrect Answer. Please Try Again");
       JLabel exceed1 = new JLabel("Sorry, you have exceeded the amount of tries available.");
       JLabel exceed2 = new JLabel("Sorry, you have exceeded the amount of tries available.");
       
       ActionListener AL = new Project();
       
       button[0] = new JButton("1. Register");
       button[1] = new JButton("2. Log in");
       button[2] = new JButton("3. Forget Username and Password");
       button[3] = new JButton("4. Exit");
       button[4] = new JButton("Register");
       button[5] = new JButton("Back");
       button[6] = new JButton("Log in");
       button[7] = new JButton("Back");
       button[8] = new JButton("Confirm");
       button[9] = new JButton("Back");
       button[10] = new JButton("Find my Item");
       button[11] = new JButton("Log out");
       button[12] = new JButton("Yes");
       button[13] = new JButton("No");
       
       for(int i = 0; i <=11; i++)
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
       panel[3] = new JPanel(new GridLayout(8,2,1,1));
       panel[4] = new JPanel(new FlowLayout());
       panel[5] = new JPanel(new BorderLayout());
       Blank[3] = new JPanel();
       Blank[4] = new JPanel();
       Blank[5] = new JPanel();
       
       contentPane.add("panel 5", panel[5]);
       
       panel[2].add(reg, BorderLayout.CENTER);
       
       panel[3].add(userLabel);
       panel[3].add(username);
       panel[3].add(passwordLabel);
       panel[3].add(password);
       panel[3].add(phoneLabel);
       panel[3].add(phone);
       panel[3].add(nameLabel);
       panel[3].add(fullName);
       panel[3].add(birthLabel);
       panel[3].add(dateOfBirth);
       panel[3].add(addressLabel);
       panel[3].add(address);
       panel[3].add(emailLabel);
       panel[3].add(email);
       panel[3].add(dateLabel);
       panel[3].add(date);

       panel[4].add(button[4]);
       panel[4].add(button[5]);
       
       panel[5].add(panel[2], BorderLayout.NORTH);
       panel[5].add(panel[3], BorderLayout.CENTER);
       panel[5].add(panel[4], BorderLayout.SOUTH);
       
       //Log In
       panel[6] = new JPanel(new BorderLayout());  
       panel[7] = new JPanel(new GridLayout(2,2,1,1));
       panel[8] = new JPanel(new FlowLayout());
       panel[9] = new JPanel(new FlowLayout());
       
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
       
       //Forget Username and Passowrd
       /*panel[11] = new JPanel(new BorderLayout());
       panel[12] = new JPanel(new FlowLayout());
       panel[13] = new JPanel(new GridLayout(5,2,1,1));
       panel[14] = new JPanel(new FlowLayout());
       combo[0] = new JComboBox(genderBox);
       combo[1] = new JComboBox(levelBox);
       
       contentPane.add("panel 11", panel[11]);
       panel[11].add(panel[12], BorderLayout.NORTH);
       panel[11].add(panel[13], BorderLayout.CENTER);
       panel[11].add(panel[14], BorderLayout.SOUTH);
       panel[12].add(enter);
       panel[13].add(ssn);
       panel[13].add(ssnTF);
       panel[13].add(name4);
       panel[13].add(nameTF);
       panel[13].add(gender);
       panel[13].add(combo[0]);
       panel[13].add(age);
       panel[13].add(ageTF);
       panel[13].add(level);
       panel[13].add(combo[1]);
       panel[14].add(button[12]);
       panel[14].add(button[13]); */
            
       frame.setSize(500,300);
       frame.setVisible(true);
       frame.setResizable(false); 
       frame.setLocation(100,50);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
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
      /*if (source==button[2]) 
      {
         cardLayout.show(contentPane, "panel 27"); return;
      } */   
      
      //Exit Program
      if (source==button[3]) 
      {
         frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      }
      
      //Register a user (Do Later)
      if (source==button[4]) 
      {
         Person p = new Person();
         p.setUser(username.getText());
         p.setPass(password.getText());
         p.setPhone(phone.getText());
         p.setActualName(fullName.getText());
         p.setBirth(dateOfBirth.getText());
         p.setAddress(address.getText());
         p.setEmail(email.getText());
         p.setCreated(date.getText());
         
         String reset = "";
         username.setText(reset);
         password.setText(reset);
         phone.setText(reset);
         fullName.setText(reset);
         dateOfBirth.setText("MM/DD/YYYY");
         address.setText(reset);
         email.setText(reset);
         date.setText("MM/DD/YYYY");
         
         count++;
      }
      
      //Go back to Main Menu
      if (source==button[5])
      {
         cardLayout.show(contentPane, "panel 0"); return;
      }
      
      //Log in
      if (source==button[6])
      {
         userLoginV = userLogin.getText();
         passLoginV = passLogin.getText();
         do
         {
            for(int i = 0; i <= count; i++)
            {
              if(array[i].getUser() == userLoginV)
                 if(array[i].getPass() == passLoginV)
                     fail = false;
                 else
                     System.out.print("Error: Either your username or password is incorrect. Please try again.");
              else
                  System.out.print("Error: Either your username or password is incorrect. Please try again.");
            }
         }while(fail);
         //Code to redirect to another window for lost item for that person that logged in.
      } 
          
          
      //Go back to main menu
      if (source==button[7]) 
      {
         cardLayout.show(contentPane, "panel 0"); return;
      } 
      
      //Forgot password
      if (source==button[8]) 
      {
      }

      //Go back to Main Menu Button
      if (source==button[9])
      {
         cardLayout.show(contentPane, "panel 0"); return;
      }
   }
}

