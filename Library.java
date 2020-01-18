// Eza Rasheed
// er6qt
// Homework 3

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Library {
	
	// Declaring variables (fields)
	private ArrayList<Book> libraryBooks;
	private ArrayList<Person> patrons;
	private String name;
	private int numBooks;
	private int numPeople;
	private String currentDate;
	
	public Library(String name) { // Constructor that takes in a String for the name(parameter) of the library
		
		// Initializing parameter
		// Setting
		this.name = name;	
		this.libraryBooks = new ArrayList<Book>();
		this.patrons = new ArrayList<Person>();
		this.numBooks = 0;
		this.numPeople = 0;
		this.currentDate = "01 01 2003";
	}
	
	
	// Getter(Accessor) Methods
	
	public ArrayList<Book> getLibraryBooks() { // Getter(accessor) method for library books
		return libraryBooks; // Return reference for libraryBooks field
	}
	
	public ArrayList<Person> getPatrons() { // Getter(accessor) method for patrons
		return patrons; // Return reference for patrons field
	}
	
	public String getName() { // Getter(accessor) method for name
		return name; // Return reference for name field
	}
	
	public int getNumBooks() { // Getter(accessor) method for number of books currently available to be checked out
		this.numBooks = 0; // initialize number of books to the value 0 
		for(Book i: getLibraryBooks()){ // for each book available in the library of books
			this.numBooks ++; // add to the number of books available
	        if(i.isCheckedOut()){ // if the book is checked out
	        	this.numBooks --; // subtract the book in the count for available books
	        }
	    }
	       return numBooks; // return number of books currently available
	}

	public int getNumPeople() { // Getter(accessor) method for number of patrons in library
		return patrons.size(); // returns the amount/number of patrons 
	}
	
	public String getCurrentDate() { // Getter(accessor) method for the current date
		return currentDate; // Return reference for currentDate field
	}
	
	// Setter(Mutator) Methods
	
	public void setLibraryBooks(ArrayList<Book> libraryBooks) { // Setter(mutator) method for libraryBooks field
		this.libraryBooks = libraryBooks; // Setting
	}
	
	public void setPatrons(ArrayList<Person> patrons) { // Setter(mutator) method for patrons field
		this.patrons = patrons; // Setting
	}
	
	public void setName(String name) { // Setter(mutator) method for name field
		this.name = name; // Setting
	}
	
	public void setCurrentDate(String currentDate) { // Setter(mutator) method for currentDate field
		this.currentDate = currentDate; // Setting
	}
		
	// checkNumCopies method
	
	public int checkNumCopies(String title, String author) { // Method that takes in a String for the title and author of a book
		int copies = 0; // number of copies starting at 0
	    for(Book b: getLibraryBooks()){ // for each book b in libraryBooks
	    	if (b.getTitle().equals(title) && b.getAuthor().equals(author)){ // Compares two Book objects, returns true if they equal each other
	    		copies += 1; // adding one each time a copy of the same book is found
	        }
	    }
	       	return copies; // returns total number of copies of book in the library
	}
	
	// totalNumBooks method
	
	public int totalNumBooks() { // Method that checks the total number of books in the library
		return libraryBooks.size(); // returns the total amount of books in the library, checked out or not
	}
	
	// checkOut method
	
	public boolean checkOut(Person p, Book b, String dueDate) { // Method that checks out books to people
		if(patrons.contains(p) && libraryBooks.contains(b)){ // if person p is a patron and the book is in the library 
		if(b.isCheckedOut() == false) { // if the book is not checked out
			for (Book i : getLibraryBooks()) { // for each book i in library books
				if (i.getBookId() == b.getBookId()) { // check to see if the book i ID is the same(equal to) as the book b ID
					i.setCheckedOut(true); // update(set) the book to being checked out (true)
					i.setDueDate(dueDate); // as well update(set) the due date for the book object
					p.addBook(b); // add the books checked out by someone(Person p) to the list of checked out books
					return true; // return true if the book is successfully checked out
				}
			}
		}
		}
		return false; // return false otherwise
	}
	
	// booksDueOnDate method
	
	public ArrayList<Book> booksDueOnDate(String date){ // Method on the list of books due on a given date
		ArrayList<Book> book_due = new ArrayList<Book>(); // Initialize new ArrayList to see list of all due books
	    for(Book b: libraryBooks){ // for each book b in the libraryBooks
	    	if (b.getDueDate() == date){ // if book b has a due date that is the same as the given date 
	    		book_due.add(b); // add book b to the list of due books
	        }
	    }
	       return book_due; // return ArrayList of books that are due
	}

	
	// lateFee Method
	
	// method that calculates the late fee the person owes. First parse the substring of days range and combine them using the GregorianCalendar class and get the time in milliseconds
	// then if person p is a patron, for each book b they checked out, get the due dates for them
	// then convert the due date to milliseconds and see if the book is overdue by more than it's due date, and lastly multiply the book's value by how many days it's overdue and 1% (0.01) to get the late fee
	 public double lateFee(Person p) {	
		 String D_1 = this.currentDate.substring(0, 2);
		 Integer D_2 = Integer.parseInt(D_1);
		 String M_1 = this.currentDate.substring(3, 5);
		 Integer M_2 = Integer.parseInt(M_1);
	     String Y_1 = this.currentDate.substring(6, 10);
	     Integer Y_2 = Integer.parseInt(Y_1);
	     GregorianCalendar milli = new GregorianCalendar(D_2, M_2, Y_2);
	     long milli_secs = milli.getTimeInMillis();
	    
		 double totalDue = 0.0;
		 
		 if(patrons.contains(p)) {
			 for (Book b : p.getCheckedOut()) {
				 String date_due = b.getDueDate();
				 String day = date_due.substring(0, 2);
				 Integer day_1 = Integer.parseInt(day);
				 String month = date_due.substring(3, 5);
				 Integer mon_1 = Integer.parseInt(month);
				 String year = date_due.substring(6, 10);
				 Integer yr_1 = Integer.parseInt(year);
			     GregorianCalendar mil_sec = new GregorianCalendar(yr_1, mon_1, day_1);
			     long millisecs = mil_sec.getTimeInMillis();
			     long differ = (milli_secs - millisecs);
			     long con = differ / (24 * 60 * 60 * 1000);
			     
			     if (differ > 0) {
			    	 double fee = b.getBookValue() * con * 0.01;
			    	 
			    	 totalDue = totalDue + fee;
			     }
			 } 
		 }	 
			 return totalDue;
	 }
}