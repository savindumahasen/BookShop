package data;

import buisness.NewUserAccount; // import buisness package NewUserAccount class
import java.util.ArrayList;     // import java.util librarey

public interface INewUserAccount {
	int add(NewUserAccount obj);  // public abstract methods
	int delete(int  userID);
	int Update(NewUserAccount obj);
	NewUserAccount get(int userID);
	ArrayList<NewUserAccount>getAll();
	
	

}
