import java.util.*;

//purpose of this class is to the registered store information about each person and add it onto the database
public class Person {
	private String username;
	private String password;
	private int tagID; 	//this is going to be used to identify the item, so must not be duplicated (is received from "ValuableItem" class
	private String status; //going to use the value in the "ValuableItem" class
	private String phoneNum;
	private String actualName;
	private String birth;
	private String address;
	//private String security1;
	//private String security2;
	private Date created; //keeps track of the time and date in which the person registered their info
	private String email;
	
	//don't really need this default method, it is just a placeholder so we don't get an error in the driver. 
	public Person() {
		created = new Date(); //should set "created" to the time it this object was created
		username = "";
	}
	
	//constructor method for Person object
	public Person(String user, String pass, int tagID, String phone, String actualName, String birth, String address, String security1, String security2, String email) {
		username = user;
		password = pass;
		this.tagID = tagID;
		phoneNum = phone;
		this.actualName = actualName;
		this.birth = birth;
		this.address = address;
		//this.security1 = security1; //after 2 weeks
		//this.security2 = security2; //after 2 weeks
		created = new Date(); //should set "created" to the time it this object was created
		this.email = email; 
	}
	
	//create setter and getter methods for ALL of the instance variables
	
	//returns all of the user's information in one line (thinking about printing the whole database "table" style)
	public String toString() {
		return "";
	}
}
