package data;
import java.util.ArrayList; //import java.util librarey
import buisness.Book;  //import buisness package Book class


public interface IData {
   int add(Book obj);          // public abstract methods
   int delete(int bookID);
   int update(Book obj);
   Book get(int BookID,String BookName);
   ArrayList<Book>getAll();
	
   
}
