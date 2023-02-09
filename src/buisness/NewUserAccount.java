package buisness;

public class NewUserAccount {

	private int userID;                // Mark the variables as private
	private String Password;
	private String firstName;
	private String lastName;
	private String account;
	private String gender;

	
	public NewUserAccount(int userID,String Password,String firstName,String lastName,String account,String gender) //paremeter constructor
	{
		this.userID=userID;    // assign the values to variables
		this.Password=Password;
		this.firstName=firstName;
	    this.lastName=lastName;
		this.account=account;
		this.gender=gender;
		
	}
	
	public void setUserID(int userID) {          // create set method for UserID
		this.userID = userID;
	}
	public int getUserID() {                     // create get method for UserID
		return userID;
	}
	public void setPassword(String password) {  // create set method for Password
		Password = password;
	}
	public String getPassword() {              // create get method for Password
		return Password;
	}
	public void setFirstName(String firstName) {           // create set method for FirstName
		this.firstName = firstName;
	}
	public String getFirstName() {               // create get method for FirstName
		return firstName;
	}
	public void setLastName(String lastName) {             // create set method for LastName
		this.lastName = lastName;
	}
	public String getLastName() {        // create get method for LastName
		return lastName;
	}
	public void setAccount(String account) {              // create set method for Account
		this.account = account;
	}
	public String getAccount() {          // create get method for Account
		return account;
	}
	public void setGender(String gender) {         // create set method for Gender
		this.gender = gender;
	}
	public String getGender() {        // create get method for Gender
		return gender;
	}
}

