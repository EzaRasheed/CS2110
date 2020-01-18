// Eza Rasheed
// er6qt
// Homework 3

public class Book {
	
   // Declaring Variables 
   private final String title; // Declare private title variable of type String, "final" because it will never change
   private final String author; // Declare private author variable of type String, "final" because it will never change
   private String dueDate; // Declare private dueDate variable of type String 
   private Boolean checkedOut; // Declare private checkedOut variable of type Boolean
   private final int bookId; // Declare private bookId variable of type int, "final" because it will not be changed (unique)
   private double bookValue; // Declare private bookValue variable of type double
   
   // Constructors
   public Book(String title, String author, int bookId, double bookValue) // Constructor that takes the fields title, author, bookId and bookValue as parameters
   {
	   // Initialize the fields
	   // Setting
	   this.title = title; 
       this.author = author;
       this.bookId = bookId;
       this.bookValue = bookValue;
       this.checkedOut = true;
       this.dueDate = "30 01 2003";
   }
  
   
   // Accessors (Getters)
   
   // Getter method for title
   public String getTitle() 
   {
       return title; // returns title
   }
   
   // Getter method for author
   public String getAuthor() 
   {
       return author;  // return author
   }
   
   // Getter method for dueDate
   public String getDueDate() 
   {
	   return dueDate; // return the due date of the book
   }
   
   // Getter method for checkedOut
   public Boolean isCheckedOut() 
   {
	   return checkedOut; // returns true if book is checked out and false otherwise
   }
   
   // Getter method for bookId
   public int getBookId() 
   {
	   return bookId; // returns the unique ID for the book
   }
   
   // Getter method for bookValue
   public double getBookValue() 
   {
	   return bookValue; // returns current value(price) of the book
   }
   
   
   // Mutators (Setters)
   
   // Setter method for dueDate
   public void setDueDate(String dueDate) 
   {
	   this.dueDate = dueDate;
   }
	   
   // Setter method for checkedOut
   public void setCheckedOut(Boolean checkedOut) 
   {
	   this.checkedOut = checkedOut;
   }
   
   // Setter method for bookValue
   public void setBookValue(double bookValue) 
   {
	   this.bookValue = bookValue;
   }
  
   // Equals method
   public boolean equals(Object o) {
	   if (o instanceof Book) { // Are you a book?
       Book b  = (Book) o; // Assign new Book object (cast to a Book)
       return (this.bookId == b.bookId); // Compares two Book objects, returns true if they equal each other (Modified to only use the bookId for comparing)
	   }
	   else {
		   return false; // Book objects do not match(aren't equal)
	   }
   }
  
   
   // toString method
   public String toString()
   {
       return "Book Title: " + getTitle() + " |" + " Book Author: " + getAuthor() + " |" + " Book Due Date: " + getDueDate() + " |" + "Book Checked Out: " + isCheckedOut() + " |" + "Book ID: " + getBookId() + " |" + "Book Value: " + getBookValue() + " \n"; // Return values of title, author, book due date, book id, and book value
   }
   
}
