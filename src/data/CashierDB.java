package data;

import java.sql.*;

import javax.swing.JOptionPane;

import buisness.Cashier;



public class CashierDB implements ICashier {  // ICashier abstract methods implements CashierDB class
	private Connection conn;

	public CashierDB() {                             //  Create Databse connectivity
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookshopdetails";
			String userName = "root";
			String password = "";
			conn = DriverManager.getConnection(url, userName, password);     
			if (conn != null) {
				System.out.println("Database is created successfully");
			} else {
				System.out.println("Database is not created successfully");
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());

		}
	}

	@Override
	public int add(Cashier obj) {
		// TODO Auto-generated method stub
		String insert="insert into accounts(UserID,Password,FirstName,LastName,Account,Gender) values(? ,? ,? ,? ,? ,?)"; // insert query
		try {
		PreparedStatement sd=conn.prepareStatement(insert); // convert query to sql statement
		sd.setInt(1,obj.getUserID());
		sd.setString(2,obj.getPassword());
		sd.setString(3, obj.getFirstName());
		sd.setString(4, obj.getLastName());
		sd.setString(5, obj.getAccounts());
		sd.setString(6,obj.getGender());
		int result=sd.executeUpdate();
		sd.close();
		return result;
		
		
       	
     }catch(SQLException e) {
	  // System.err.println(e.getMessage());
    	 if (e instanceof SQLIntegrityConstraintViolationException) {
    		 JOptionPane.showMessageDialog(null,"There is another account for this userID!"); 
    		 return 0;
    		 }
    	 return 0;
     }
    
}

	@Override
	public int delete(int userID) {
		// TODO Auto-generated method stub
		String Delete = "delete from accounts where UserID=?"; // delete query
		try {
			PreparedStatement sd = conn.prepareStatement(Delete);  // convert query to sql statement
			sd.setInt(1, userID);
			int result = sd.executeUpdate();
			return result;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public int Update(Cashier obj) {
		// TODO Auto-generated method stub

		String update = "update accounts set Password=?,FirstName=?,LastName=?,Account=?,Gender=? where UserID=?";
		try {
			PreparedStatement sd = conn.prepareStatement(update);  // convert query to sql statement
			sd.setString(1, obj.getPassword());
			sd.setString(2, obj.getFirstName());
			sd.setString(3, obj.getLastName());
			sd.setString(4, obj.getAccounts());
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
	public Cashier get(int userID) {
		// TODO Auto-generated method stub
		Cashier scd = null;
		String select = "select * from accounts where UserID=?";
		try {
			PreparedStatement sd = conn.prepareStatement(select);  // convert query to sql statement
			sd.setInt(1, userID);
			ResultSet rs = sd.executeQuery();
			if (rs.next()) {
				int UserID1 = rs.getInt("UserID");
				String Password = rs.getString("Password");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Accounts = rs.getString("Account");
				String Gender = rs.getString("Gender");
				scd = new Cashier(UserID1, Password, FirstName, LastName, Accounts, Gender);// pass the parameters to the parameter constructor

			}
			rs.close();
			sd.close();
			return scd;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		// TODO Auto-generated method stub

	}

}
