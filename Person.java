// Eza Rasheed
// er6qt
// Homework 3

import java.util.ArrayList;

public class Person {
	
	// Create variables (fields)
	private String name; // Declare private name variable of type String 
	private String address; // Declare private address variable of type String
	private final int libraryCardNum; // Declare private libraryCardNum variable of type int, "final" because it will never change, replaces id field
	private ArrayList<Book> checkedOut; // Declare private checkedOut variable of type ArrayList<Book>s
	
	public Person(String name, String address, int libraryCardNum) { // Person constructor that takes in name, address, and library card number
		
		// Initialize the fields
		// Setting
		this.name = name; 
		this.address = address;
		this.libraryCardNum = libraryCardNum;
		this.checkedOut = new ArrayList<Book>();
	}
	
	// Getter Methods
	
	public String getName() { // Getter(accessor) method for name
		return name; // Return reference for name field
	}
	
	
	public String getAddress() { // Getter(accesor) method for address
	    return address; // Return reference of address field
	}
	
	
	public int getLibraryCardNum() { // Getter(accessor) method for libraryCardNum
	       return libraryCardNum; // Return value for libraryCardNum field
	}
	
	public ArrayList<Book> getCheckedOut() 
	   {
		   return checkedOut; // Returns an ArrayList of books checked out
	   }
	
	// Setter Method
	
	public void setAddress(String address) { // Setter(mutator) method for address field
	       this.address = address; // Setting
	}
	
	
	public boolean addBook(Book b) {
		if (checkedOut.contains(b)) { // if book b is (contained) in the ArrayList of books checked out,
			return false; // return false because book b was already in the ArrayList books checked out, so it doesn't need to be added
		} 
		else {
			checkedOut.add(b); // book b is not in the list  of books checked out, so add it
	        return true; // return true because the book was added
		}
	}
		
	// Equals Method
	
	public boolean equals(Object o) {
		if (o instanceof Person) { // Are you a person?
			Person p = (Person) o; // Assign new Person object (cast to a Person)
	        return (this.libraryCardNum == p.libraryCardNum); // Return true if the current Person object's library card number value is equal to the library card number value of the Person object passed to equals()
		} 
		else {
			return false; // If not equal, return false
	    }  
	}	
	
	// toString Method
	
	public String toString() {
		return "Name: " + getName() + ", Address: " + getAddress() + ", Library Card Number: " + getLibraryCardNum() + ", Books Checked Out: " + checkedOut.toString(); // Return values of name, address, library card number, and books checked out
	}

}
