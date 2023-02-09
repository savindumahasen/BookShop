package data;
import buisness.BookCategory; // import buisness package BookCategory

public interface ICategory {
	int add(BookCategory obj); //public abstract methods
	int delete(int BookID);
	int update(BookCategory obj);
	BookCategory get(int BookID,String BookName);
	

}
