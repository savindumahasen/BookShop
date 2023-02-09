package data;

import java.sql.*;                          // import java.sql librarey
import buisness.NewUserAccount;              // import buisness package NewUserAccount class

import java.util.ArrayList;       // import java.util.ArrayList

public class NewUserDB implements INewUserAccount {
	private Connection conn;

	public NewUserDB() {      // Create Database connectivity
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookshopdetails";
			String userName = "root";
			String password = "";
			conn = DriverManager.getConnection(url, userName, password);
			if (conn != null) {
				System.out.println("database is created successfully");
			} else {
				System.out.println("database is not created successfully");
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());

		}

	}

	@Override
	public int add(NewUserAccount obj) {
		// TODO Auto-generated method stub
		String insert = "insert into accounts(UserID,Password,FirstName,LastName,Account,Gender) values(? ,? ,? ,?,?,?)"; // insert query
		try {
			PreparedStatement sd = conn.prepareStatement(insert); // convert the query to sql statement
			sd.setInt(1, obj.getUserID());
			sd.setString(2, obj.getPassword());
			sd.setString(3, obj.getFirstName());
			sd.setString(4, obj.getLastName());
			sd.setString(5, obj.getAccount());
			sd.setString(6, obj.getGender());
			int result = sd.executeUpdate();
			sd.close();

			return result;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public int delete(int userID) { 
		// TODO Auto-generated method stub
		String Delete = "delete from accounts where UserID=?";      // delete query
		try {
			PreparedStatement sd = conn.prepareStatement(Delete);  // convert the query to sql statement
			sd.setInt(1, userID);
			int result = sd.executeUpdate();
			return result;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	@Override
	public int Update(NewUserAccount obj) {
		// TODO Auto-generated method stub
		String update = "update accounts set Password=?, FirstName=?,LastName=?,Account=?,Gender=? where UserID=?"; // Update query
		try {
			PreparedStatement sd = conn.prepareStatement(update); // convert the query to sql statement
			sd.setString(1, obj.getPassword());
			sd.setString(2, obj.getFirstName());
			sd.setString(3, obj.getLastName());
			sd.setString(4, obj.getAccount());
			sd.setString(5, obj.getGender());
			sd.setInt(6, obj.getUserID());
			int result = sd.executeUpdate();
			sd.close();
			return result;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	@Override
	public NewUserAccount get(int userID) {
		// TODO Auto-generated method stub
		NewUserAccount std = null;
		String select = "select * from accounts where UserID=?"; // get the data  from database query
		try {
			PreparedStatement sd = conn.prepareStatement(select); // convert the query to sql statement
			sd.setInt(1, userID);
			ResultSet rs = sd.executeQuery();
			if (rs.next()) {
				int userID1 = rs.getInt("userID");
				String Password = rs.getString("Password");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Accounts = rs.getString("Account");
				String Gender = rs.getString("Gender");

				std = new NewUserAccount(userID1, Password, FirstName, LastName, Accounts, Gender);

			}
			rs.close();
			sd.close();
			return std;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public ArrayList<NewUserAccount> getAll() {
		// TODO Auto-generated method stub
		ArrayList<NewUserAccount> NewUserAccountList = new ArrayList();   // ArrayList
		String select = "select *  from accounts";    // GetAll the data from database query

		try {
			PreparedStatement sd = conn.prepareStatement(select);  // convert the query to sql statement
			ResultSet rs = sd.executeQuery();
			while (rs.next()) {
				int UserID = rs.getInt("UserID");
				String Password = rs.getString("Password");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Accounts = rs.getString("Account");
				String Gender = rs.getString("Gender");

				NewUserAccount std = new NewUserAccount(UserID, Password, FirstName, LastName, Accounts, Gender);// pass the parameters to the parameter constructor
				NewUserAccountList.add(std); // add to the arraylist

			}
			rs.close();
			sd.close();
			return NewUserAccountList;  // return the ArrayList
		} catch (SQLException e) { 
			System.out.println(e.getMessage());
			return null;
		}
	}

}
