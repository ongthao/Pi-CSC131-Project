import java.util.*;

//purpose of this class is to the registered store information about each person and add it onto the database
public class Person {
	private String username;
	private String password;
	private int tagID; 	//this is going to be used to identify the item, so must not be duplicated (is received from "ValuableItem" class
	private String phoneNum;
	private String actualName;
	private String birth;
	private String address;
	private String security1;
	private String answer1;
	//private String security2;
	//private String answer2;
	private String created; //keeps track of the time and date in which the person registered their info
	private String email;
	private String descript; //the variable that defines what the variable is
	private ValuableItem item;
	
	//don't really need this default method, it is just a placeholder so we don't get an error in the driver. 
	public Person() {
		created = "null"; //should set "created" to the time it this object was created
		username = "";
	}
	
	//constructor method for Person object
	public Person(String user, String pass, String phone, String actualName, String birth, String address, String email, String descript, String created, ValuableItem item, String security1, String answer1) {
		username = user;
		password = pass;
		this.item = item;
		this.tagID = item.getTagID();
		phoneNum = phone;
		this.actualName = actualName;
		this.birth = birth;
		this.address = address;
		this.security1 = security1; 
		this.answer1 = answer1;
		//this.security2 = security2; //after 2 weeks
		this.created = created; //should set "created" to the time it this object was created
		this.email = email; 
		this.descript = descript;
	}
	
	//create setter and getter methods for ALL of the instance variables
	public String getSecurityQ1() {
		return security1;
	}
	
	/*public String getSecurityQ2() {
		return security2;
	}*/
	
	public String getAnswer1() {
		return answer1;
	}
	
	/*public String getAnswer2() {
		return answer2;
	}*/
	
	public String getDescript() {
		return descript;
	}
	
	public ValuableItem getItem() {
		return item;
	}
	
	public String getUser() {
		return username;
	}
	
	public String getPass() {
		return password;
	}
	
	public int getTagID() {
		return tagID;
	}
	
	public String getPhone() {
		return phoneNum;
	}
	
	public String getActualName() {
		return actualName;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCreated() {
		return created;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setUser(String user) {
		username = user;
	}
	
	public void setPass(String pass) {
		password = pass;
	}
	
	public void setPhone(String phone) {
		this.phoneNum = phone;
	}
	
	public void setActualName(String actualName) {
		this.actualName = actualName;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//returns all of the user's information in one line (thinking about printing the whole database "table" style)
	public String toString() {
		return tagID + " " + item.getStatus() + " " + item.getX() + " " + item.getY() + " " + username + " " + password + " " + phoneNum + " " + actualName + " " + birth + " " + address + " " + email + " " + descript + " " + created + "\n" + security1 + "\n" + answer1 + "\n";
	}
}
