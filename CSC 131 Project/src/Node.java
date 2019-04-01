import java.util.*;

public class Node {
	private Person p;
	private Node head;
	//can also use a double linked list if desired

	public Node(Person p) {
		this.p = p; 
		head = null;
	}
	
	//getter and setter methods
	public void setP(Person n) {
		
	}
	
	public void setHead(Node h) {
		
	}
	
	public Person getP() {
		return p;
	}
	
	public Node getHead() {
		return head;
	}
}
