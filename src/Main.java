import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main 
{
    public static void main(String[] args)
    {
        ArrayList<Book> bs = new ArrayList<>();
		
		bs.add(new Book("1940", "CompSci", "Wonderful guy", "Fairmont", 8500.0, "This book is good"));
		bs.add(new Book("1980", "CompScience", "Wonderful guy", "FairmontP", 9000.0, "This book is good"));
		bs.add(new Book("1977", "Truth of Comp", "Wonderful guy", "FairmontH", 7000.0, "This book is good"));
		bs.add(new Book("2004", "CompSci2", "Wonderful guy", "FairmontC", 10500.0, "This book is good"));
		bs.add(new Book("2014", "CompSci3", "Wonderful guy", "FairmontA", 8320.0, "This book is good"));
		bs.add(new Book("2000", "CompSci4", "Wonderful guy", "FairmontV", 11500.0, "This book is good"));
		bs.add(new Book("2011", "CompSci5", "Wonderful guy", "FairmontX", 8500.0, "This book is good"));
		bs.add(new Book("2010", "CompSci6", "Wonderful guy", "FairmontB", 9500.0, "This book is good"));
		bs.add(new Book("1999", "CompSci7", "Wonderful guy", "FairmontN", 8600.0, "This book is good"));
		bs.add(new Book("1998", "CompSci8", "Wonderful guy", "FairmontM", 10000.0, "This book is good"));
		bs.add(new Book("1969", "CompSci9", "Wonderful guy", "FairmontI", 18500.0, "This book is good"));
		bs.add(new Book("1949", "CompSci0", "Wonderful guy", "FairmontY", 7500.0, "This book is good"));
		bs.add(new Book("1988", "CompSci11", "Wonderful guy", "FairmontP", 9900.0, "This book is good"));
		bs.add(new Book("2001", "CompSci12", "Wonderful guy", "FairmontP", 9500.0, "This book is good"));
		bs.add(new Book("2003", "CompSci13", "Wonderful guy", "FairmontI", 10500.0, "This book is good"));
		bs.add(new Book("1984", "CompSci14", "Wonderful guy", "FairmontI", 15500.0, "This book is good"));
		bs.add(new Book("1991", "CompSci15", "Wonderful guy", "FairmontI", 13500.0, "This book is good"));
		bs.add(new Book("1994", "CompSci16", "Wonderful guy", "FairmontB", 11300.0, "This book is good"));
		bs.add(new Book("1995", "CompSci17", "Wonderful guy", "FairmontK", 11900.0, "This book is good"));
		bs.add(new Book("1985", "CompSci19", "Wonderful guy", "FairmontW", 8500.0, "This book is good"));
		bs.add(new Book("1944", "CompSci20", "Wonderful guy", "FairmontW", 8800.0, "This book is good"));


		printBooks(bs);
    }

    public static void printBooks(ArrayList<Book> bs) {// Printing method
		
		BookMgrImpl service = BookMgrImpl.getInstance(); 
		
		// Adding books to arraylist in service
		for(Book b : bs) {
			System.out.println(b);
			service.addBook(b);
		}
		
		boolean menu = true; // Menu switch
		while(menu == true) { // Repeat while menu switch is on
			System.out.println("===============================");
			System.out.println("S This is Electronic Book Managing sevice.");
			System.out.println("1. List the books");
			System.out.println("2. Add the books");
			System.out.println("3. Find the books");
			System.out.println("4. Find the sum of all book's price.");
			System.out.println("===============================");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt(); // Insert menu num

			// 1. List all the books
			if(choice == 1) {
				System.out.println("===============================");
				System.out.println("Do you want a list of all the books?");
				System.out.println("1. Yes, show me the list.");
				System.out.println("2. No, go back to menu.");
				System.out.println("===============================");
				sc.nextLine();
				int search = sc.nextInt(); 
				if(search == 1) System.out.println(service.getAllBook());
				if(search == 2) menu = true;
			}

			// 2. Add the books
			if(choice == 2) {
				System.out.println("Type the year"); 
				String isbn = sc.next(); 
				System.out.println("Type the name."); sc.nextLine();
				String title = sc.nextLine();
				System.out.println("Type the author.");
				String author = sc.nextLine();
				System.out.println("Type the publisher.");
				String publisher = sc.nextLine();
				System.out.println("Type the price.");
				Double price = sc.nextDouble(); sc.nextLine();
				System.out.println("Write the short descrption.");
				String desc = sc.nextLine();
				service.addBook(new Book(isbn, title, author, publisher, price, desc));
			}

			// 3. Finding books
			if(choice == 3) {
				System.out.println("===============================");
				System.out.println("What method will you use to find books?");
				System.out.println("1. Find with year that book was made");
				System.out.println("2. Find with the title of the book");
				System.out.println("3. Find with the publisher's name");
				System.out.println("4. Find with under the specific price.");
				System.out.println("5. Go Back");
				System.out.println("===============================");
				sc.nextLine();
				int search = sc.nextInt(); 

				if(search == 1) { // Find books with year
					System.out.println("Write the year.");
					String isbn = sc.next(); sc.nextLine();
					System.out.println(service.searchBookByIsbn(isbn));
				}
				else if(search == 2) { // Find book with title
					System.out.println("Write the title.");  sc.nextLine();
					String title = sc.nextLine(); 
					System.out.println(service.searchBookByTitle(title));
				}
				else if(search == 3) { // Find book with publisher
					System.out.println("Write the publisher.");
					String publisher = sc.next();
					System.out.println(service.searchBookByPublisher(publisher));
				}
				else if(search == 4) { // Find book under the price
					System.out.println("Write the price.");
					int price = sc.nextInt(); sc.nextLine();
					System.out.println(service.searchBookByPrice(price));
				}
				else if(search == 5) menu = true; // Go back
				else System.out.println("You have been misinserted.");
			}

			// 4. Find sum of books' price
			if(choice == 4) {
				System.out.println("Total price of books : " + service.getTotalPrice());
				System.out.println("Average price of books : " + service.getAvgPrice());
			}
			
		}

	}
}
