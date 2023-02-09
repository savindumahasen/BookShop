package data;
import buisness.Cashier; // import buisness packege Cashier class

public interface ICashier {
	int add(Cashier obj);         // public abstract methods
	int delete(int userID);
	int Update(Cashier obj);
	Cashier get(int userID);
	

}
