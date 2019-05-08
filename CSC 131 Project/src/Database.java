import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

//purpose of this class is to use Person objects to add people onto the database using linked lists or arraylist
public class Database {
	Node data;
	/*
	private class SortDatabase implements Comparator<Node>
	{
		public int compare(Node a, Node b)
		{
			return a.getP().getTagID() - b.getP().getTagID();
		}
	}
	
	private LinkedList<Node> front;
	//private String FILENAME = "include/database.txt";
	//private File text = new File(FILENAME);
	
	public Database() {
		front = new LinkedList<Node>();
	}
	
	//constructor method
	public Database(Node n) {
		front = new LinkedList<Node>();
		
		n.setHead(null);
		front.add(n);
		setFront(n);
	}
	
	//adds a new node to the database
	public void add(Node n) throws IOException{
		n.setHead(front);
		front = n;
		writeToFile();
	}
	
	//getter and setter methods
	public void setFront(Node n) {
		n.setHead(null);
		front.set(0, n);
	}
	
	public Node getFront() {
		return front.getFirst();
	}
	
	//purpose of this method is to delete a user's account information when requested (can use user's "name" as an identifier for whose info wants to be deleted)
	public void delete(Node n) throws IOException{
		n.setHead(null);
		front.remove(n);
		
		writeToFile();
	}
	
	//This method should allow the user to change their information (the String s will be an identifier for what specifically needs to be changed)
	public void change(Node n, String s) {
	}*/
	public Database() {
		data = null;
	}
	
	public Database(Node n) {
		data = n;
	}
	
	public void add(Node n) {
		n.setHead(data);
		data = n;
	}
	public Node getFront() {
		return data;
	}
	
	private void writeToFile() throws IOException{
		Node curr = data;
    	BufferedWriter writer = new BufferedWriter(new FileWriter(new File(/*front.get(i).getUsername()*/ "Testfile" + ".txt")));
    	while(curr.getHead != null) {
			if(curr.getP()== null) {
	            System.out.print("This node is empty");
	        }
	        else {
	            writer.write(PtoS(curr.getP())+"\n");
	        }
			curr = curr.getHead();
		}
    	writer.write(PtoS(curr.getP()));
		writer.close();
	}
	private String PtoS(Person p)
	{
		return p.toString();
	}
	/*
	private void sort()
	{
		Collections.sort(front, new SortDatabase());
	}*/
	

}
