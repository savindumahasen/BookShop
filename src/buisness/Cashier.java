package buisness;

public class Cashier {
	private int userID;                    // Mark the variable as private
	private String Password;
	private String FirstName;
	private String LastName;
	private String Accounts;
	private String Gender;
	
	
	public Cashier() {             // Create the blank constructor
		
	}
	public Cashier(int userID,String Password, String FirstName,String LastName,String Accounts,String Gender) { // create the parameter constructor
		this.userID=userID;
		this.Password=Password;
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.Accounts=Accounts;
		this.Gender=Gender;
		
	}
	public void setUserID(int userID) {     // Create the set method for UserID
		this.userID = userID;
	}
	public int getUserID() {            // Create the get method for UserID
		return userID;
	}
	public void setPassword(String password) {     // Create the set method for UserID
		Password = password;
	}
	 public String getPassword() {                // Create the get method for UserID
		return Password;
	}
	 public void setFirstName(String firstName) {  // Create the set method for FirstName
		FirstName = firstName;
	}
	 public String getFirstName() {           // Create the get method for FirstName
		return FirstName;
	}
	 public void setLastName(String lastName) {   // Create the set method for LastName
		LastName = lastName;
	}
	 public String getLastName() {         // Create the get method for LastName
		return LastName;
	}
	 public void setAccounts(String accounts) {    // Create the set method for Acccounts
		Accounts = accounts;
	}
	public String getAccounts() {                // Create the get method for Accounts
		return Accounts;
	}
	public void setGender(String gender) {        // Create the set method for Gender
		Gender = gender;
	}
	public String getGender() {                // Create the get method for Gender
		return Gender;
	}

}
