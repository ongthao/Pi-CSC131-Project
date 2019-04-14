//purpose of this class is to use Person objects to add people onto the database using linked lists or arraylist
public class Database {
	private Node front;
	private String FILENAME;
	
	//constructor method
	public Database(Node n) {
		
	}
	
	public void isLost() {
		
	}
	
	//adds a new node to the database
	public void add(Node n) {
		// code for adding
		
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
		
	}
	
	//This method should allow the user to change their information (the String s will be an identifier for what specifically needs to be changed)
	public void change(Node n, String s) {
	}
	
	private void writeToFile(Node n) {
		
	}
}
