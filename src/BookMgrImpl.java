import java.util.ArrayList;

public class BookMgrImpl implements BookManager {
    private ArrayList<Book> bList;
	
	private static BookMgrImpl mgr = new BookMgrImpl();
	
	private BookMgrImpl() {
		bList = new ArrayList<>(); 
	}
	
	public static BookMgrImpl getInstance() {
		return mgr;
	}

	// 1. Data Import Method
	public void addBook(Book nBook) {
		boolean find = true;
		for(Book b : bList) {
			if(b.getIsbn().equals(nBook.getIsbn())) {
				System.out.println("Book Name : "+nBook.getTitle()+", You already have this book.");
				find = false;
				break;
			}
		}
		if(find == true) {
			bList.add(nBook);
			System.out.println("Book Name : " + nBook.getTitle()+", Succesfully Added. ");
		}
	}
	
	// 2. All data Search
	public ArrayList<Book> getAllBook(){
		return bList;
	}
	
	// 3. Search with year
	public Book searchBookByIsbn(String isbn) {
		Book temp = new Book();
		for(Book b : bList) if(b.getIsbn().equals(isbn)) temp = b;
		return temp;
	}

	// 4. Search with title
	public ArrayList<Book> searchBookByTitle(String title){
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : bList) if(b.getTitle().contains(title)) temp.add(b);
		return temp;
	}
	
	// 8. Search with publisher
	public ArrayList<Book> searchBookByPublisher(String publisher){
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : bList) {
			if(b.getPublisher().equals(publisher)) temp.add(b);
		}
		return temp;
	}
	
	// 9. Search with price under it
	public ArrayList<Book> searchBookByPrice(int price){
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : bList) {
			if(b.getPrice() < price) {
				temp.add(b);
			}
		}
		return temp;
	}
	
	// 10. Find the total price of books
	public int getTotalPrice() {
		int total = 0;
		for(Book b : bList) total += b.getPrice(); 
		return total;
	}
	
	// 11. Find the average price of books
	public int getAvgPrice() {
		return getTotalPrice() / bList.size();
	}
}
