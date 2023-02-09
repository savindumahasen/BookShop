package data;
import java.sql.*;

import javax.swing.JOptionPane;
import buisness.BookCategory;

public class CategoryDB  implements ICategory{
	private Connection conn;
	
	public CategoryDB() {   // Create database connectivity
		try {
			//Class.forName("com.mysql.jdbc.Driver");                                         
			String url="jdbc:mysql://localhost:3306/bookshopdetails";
			String userName="root";
			String password="";
			conn=DriverManager.getConnection(url,userName,password);
			if(conn!=null) {
				System.out.println("Database is created successfully");
			}else {
				System.out.println("Database is not created successfully");
			}
			
			
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
			
		}
	}

	@Override
	public int add(BookCategory obj) {
		// TODO Auto-generated method stub
		String insert="insert into bookcategory(BookID,BookName,Category) values(?,?,?)"; // insert query
		try {
		PreparedStatement sd=conn.prepareStatement(insert);// convert query to sql statement
		sd.setInt(1,obj.getBookID());
		sd.setString(2,obj.getBookName());
		sd.setString(3,obj.getCategory());
	    int result=sd.executeUpdate();
		sd.close();
		
		return result;
		
       	
        
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			 if (e instanceof SQLIntegrityConstraintViolationException) {
	    		 JOptionPane.showMessageDialog(null,"There is another account for this userID!"); 
	    		 return 0;
	    		 }
			return 0;
		}
	}

	@Override
	public int delete(int BookID) {
		// TODO Auto-generated method stub
		String Delete="delete from bookcategory where BookID=?"; // delete query
		try {
			PreparedStatement sd=conn.prepareStatement(Delete);  // convert query to sql statement
			sd.setInt(1,BookID);
			int result=sd.executeUpdate();
			return result;
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public int update(BookCategory obj) {
		// TODO Auto-generated method stub
		String update="update bookCategory set BookName=?,Category=? where BookID=?";  // update query
	    try {
	    	PreparedStatement sd=conn.prepareStatement(update); // convert query to sql statement
		    sd.setString(1, obj.getBookName());
			sd.setString(2, obj.getCategory());
			sd.setInt(3,obj.getBookID());
			int result=sd.executeUpdate();
			sd.close();
			return result;
	    	
	
         }catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
	}
		
	}

	@Override
	public BookCategory get(int BookID, String BookName) { // get query
		// TODO Auto-generated method stub
		BookCategory std=null;
		  String select="select * from bookcategory where BookID=? and BookName=?";
		  try {
				  PreparedStatement sd=conn.prepareStatement(select); // convert query to sql statement
				  sd.setInt(1,BookID);
		          sd.setString(2, BookName);
			      ResultSet rs=sd.executeQuery();
		        if(rs.next()) {
		        	  int BookID1=rs.getInt("BookID");
			    	  String BookName1=rs.getString("BookName");
			    	  String Category1=rs.getString("Category");
			          std=new BookCategory(BookID1,BookName1,Category1);
			    	
			    	  }
			      rs.close();
			      sd.close();
			      return std;  
			      
			      
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
	}

}
}
