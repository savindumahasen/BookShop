package data;
import java.util.ArrayList;  // import the java.util library

import javax.swing.JOptionPane; // import the javax.swing library

import buisness.Book; // import buisness packge Book class


import java.sql.*; // import java.sql library

public class BookDB implements IData {  // IData abstract methods implements in BookDB class
	private  Connection con;
	
	
	public BookDB() {             // create the database connectivity  
		//Class.forName("com.mysql.jdbc.Driver");                              
		try {         
			String url="jdbc:mysql://localhost:3306/bookshopdetails";
			String userName="root";
			String password="";
			con=DriverManager.getConnection(url,userName,password);
			if(con!=null) {
				System.out.println("database is created successfully");
			}else {
				System.out.println("database is not created successfully");
			}
			
			
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
			
		}
	
		
	}


	@Override
	public int add(Book obj) {
		// TODO Auto-generated method stub
		String insert="insert into books(BookID,BookName,Category,Price,Author,Description,PublisherDate) values(? ,? ,? ,? ,? ,? ,?)"; // insert query
		try {
		PreparedStatement sd=con.prepareStatement(insert);  // convert query to sql statement
		sd.setInt(1,obj.getBookID());
		sd.setString(2,obj.getBookName());
		sd.setString(3, obj.getCategory());
		sd.setDouble(4, obj.getPrice());
		sd.setString(5, obj.getAuthor());
		sd.setString(6,obj.getDescription());
		sd.setDate(7,obj.getPublisherDate());
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
	public int delete(int bookID) {
		String Delete="delete from books where BookID=?"; // Delete query
		try {
			PreparedStatement sd=con.prepareStatement(Delete);  // convert query to sql statement
			sd.setInt(1,bookID);
			int result=sd.executeUpdate();
			return result;
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		// TODO Auto-generated method stub

	}


	@Override
	public int update(Book obj) {
		// TODO Auto-generated method stub
		
		String update="update books set BookName=?,Category=?,Price=?,Author=?,Description=?,PublisherDate=? where BookID=?"; // Update query
	    try {
	    	PreparedStatement sd=con.prepareStatement(update); // convert query to sql statement
		    sd.setString(1, obj.getBookName());
			sd.setString(2, obj.getCategory());
			sd.setDouble(3, obj.getPrice());
			sd.setString(4,obj.getAuthor());
			sd.setString(5,obj.getDescription());
			sd.setDate(6,obj.getPublisherDate());
			sd.setInt(7,obj.getBookID());
			int result=sd.executeUpdate();
			sd.close();
			return result;
	    	
	
         }catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
	}
	
	}

	@Override
	public Book get(int BookID,String BookName) {
		// TODO Auto-generated method stud
      Book std=null;
		  String select="select * from books where BookID=? and BookName=?"; // get query
		  try {
				  PreparedStatement sd=con.prepareStatement(select);  // convert query to sql statement
				  sd.setInt(1,BookID);
				  sd.setString(2, BookName);
				  ResultSet rs=sd.executeQuery();
		        if(rs.next()) {
		    	      int BookID1=rs.getInt("BookID");
			    	  String BookName1=rs.getString("BookName");
			    	  String Catagory1=rs.getString("Category");
			    	  Double Price1=rs.getDouble("Price");
			    	  String Author=rs.getString("Author");
			    	  String Description=rs.getString("Description");
			    	  Date PublisherDate=rs.getDate("PublisherDate");
			    	  std=new Book(BookID1,BookName1,Catagory1,Price1,Author,Description,PublisherDate);
			    	
			    	  }
			      rs.close();
			      sd.close();
			      return std;  
			      
			      
			   }catch(SQLException e) {
					System.out.println(e.getMessage());
					return null;
			}
			// TODO Auto-generated method stub
			
		
}


	@Override
	public ArrayList<Book> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Book> bookList=new ArrayList();
		String select="select *  from books";  // select query
	
		
		try {
			PreparedStatement sd=con.prepareStatement(select);  // convert query to sql statement
		    ResultSet rs=sd.executeQuery();
			 while(rs.next()) {
		    	  int BookID=rs.getInt("BookID");
		    	  String BookName=rs.getString("BookName");
		    	  String Category=rs.getString("Category");
		    	  Double Price=Double.valueOf(rs.getDouble("Price"));
		    	  String Author=rs.getString("Author");
		    	  String Description=rs.getString("Description");
		    	  Date PublisherDate=Date.valueOf(rs.getString("PublisherDate"));
		    	  Book std=new Book(BookID,BookName,Category,Price,Author,Description,PublisherDate); // pass the parameters to the parameter constructor
		    	  bookList.add(std); // add to the arraylist
		    	  
		    	  }
		      rs.close();
		      sd.close();
		      return bookList;  
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	

	
	

}
