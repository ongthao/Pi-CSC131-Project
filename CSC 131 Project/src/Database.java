import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

//purpose of this class is to use Person objects to add people onto the database using linked lists or arraylist
public class Database {
	private Node front;
	//private String FILENAME = "include/database.txt";
	//private File text = new File(FILENAME);
	
	//constructor method
	public Database(Node n) {
		
	}
	
	public void isLost() {
		
	}
	
	//adds a new node to the database
	public void add(Node n) {
		Node i;
		
		for (i = front; i.getHead() != null; i = i.getHead()) {}
		i.setHead(n);
		
		writeToFile(n);
	}
	
	//getter and setter methods
	public void setFront(Node n) {
		front = n;
	}
	
	public Node getFront() {
		return front;
	}
	
	//purpose of this method is to delete a user's account information when requested (can use user's "name" as an identifier for whose info wants to be deleted)
	public void delete(Node n) {
		Node i;
		
		for (i = front; i.getHead() != n; i = i.getHead()) {}
		i.setHead(i.getHead().getHead());
	}
	
	//This method should allow the user to change their information (the String s will be an identifier for what specifically needs to be changed)
	public void change(Node n, String s) {
	}
	
	private void writeToFile(Node n) {
		if(n.getP()== null) {
            System.out.print("This node is empty");
        }
        else {
        	BufferedWriter writer = new BufferedWriter(new FileWriter(new File(/*n.getUsername()*/ "user1" + ".txt")));
            writer.write(PtoS(n.getP()));
            writer.close();
        }
	}
	
	private String PtoS(Person p)
	{
		return "";	//cannot write until we can get user info like getUsername();
	}
}
