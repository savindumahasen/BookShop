package buisness;

public class BookCategory {
	private int BookID;                       // Mark variables as private
	private String BookName;
	private String Category;
	
	public BookCategory(int BookID,String BookName,String Category) {    // Create parameter constructor
		this.BookID=BookID;
		this.BookName=BookName;
		this.Category=Category;
		
	}
	public void setBookID(int bookID) {    // Create set method for BookID
		BookID = bookID;
	}
	public int getBookID() {                // Create get method for BookID
		return BookID;
	}
	public void setBookName(String bookName) {     // Create set method for BookName
		BookName = bookName;
	}
	public String getBookName() {               // Create get method for BookName
		return BookName;
	}
	public void setCategory(String category) {   // Create set method for Category
		Category = category;
	}
	public String getCategory() {          // Create get method for Category
		return Category;
	}

}
