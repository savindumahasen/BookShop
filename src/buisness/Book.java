package buisness;
import java.sql.*; // import java sql library

public class Book {
	private int bookID;                      // Markethe variables as privat
	private String bookName;
	private String category;
	private double price;
	private String author;
	private String Description;
	private Date PublisherDate;
	
	
	public Book() { // Create the blank constructor
		
	}
	
	public  Book(int bookID,String bookName,String category,double price,String author,String Description,Date PublisherDate) { //create the parameter constructor
		
		this.bookID=bookID;                                                                                                               
		this.bookName=bookName;
		this.category=category;
		this.price=price;
		this.author=author;
		this.Description=Description;
		this.PublisherDate=PublisherDate;
		
		
		
		
	}
	
	  public void set_BookID(int bookID) {             // Create the set method for BookID
			this.bookID = bookID;
		}
		  public int getBookID() {                     // Create the get method for BookID
			return bookID;
		}
		  public void setBookName(String bookName) {       // Create the set method for BookName
			this.bookName = bookName;
		}
		  public String getBookName() {                        // Create the get method for BookName
			return bookName;
		}
		  public void setCategory(String category) {         // Create the set method for Category
			this.category = category;
		}
		  public String getCategory() {                        // Create the get method for Category
			return category;
		}
		  public void setPrice(double price) {        // Create the set method for Price
			this.price = price;
		}
		  public double getPrice() {                   // Create the get method for Price
			return price;
		}
		  public void setAuthor(String author) {      // Create the set method for Author
			this.author = author;
		}
		  public String getAuthor() {       // Create the get method for Author
			return author;
		}
		  public void setDescription(String description) {     // Create the set method for Description
			Description = description;
		}
		  public String getDescription() {    // Create the get method for Description
			return Description;
		}
		public void setPublisherDate(Date publisherDate) {      // Create the set method for publisherDate
			PublisherDate = publisherDate;
		}
		public Date getPublisherDate() {         // Create the get method for publisherDate
			return PublisherDate;
		}
        
}
