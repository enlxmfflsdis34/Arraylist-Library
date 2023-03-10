import java.util.ArrayList;

public interface BookManager {
    void addBook(Book nBook);
	ArrayList<Book> getAllBook();
	Book searchBookByIsbn(String isbn);
	ArrayList<Book> searchBookByTitle(String title);
	ArrayList<Book> searchBookByPublisher(String publisher);
	ArrayList<Book> searchBookByPrice(int price);
	int getTotalPrice();
	int getAvgPrice();
}
