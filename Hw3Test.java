import org.junit.Test;
import static org.junit.Assert.*;


public class Hw3Test {

	@Test (timeout=100)
	public void testCheckNumCopies1() {
		Library copy1 = new Library("Clark");
		Book a = new Book("Divergent", "Veronica Roth", 256743, 34780.0);
		Book b = new Book("The Kite Runner", "Khaled Hosseini", 17, 17.0);
		copy1.getLibraryBooks().add(a);
		copy1.getLibraryBooks().add(b);
		int c = copy1.checkNumCopies("The Kite Runner", "Khaled Hosseini");
		assertTrue(c == 1);
	}

	@Test (timeout=100)
	public void testCheckNumCopies2() {
		Library copy2 = new Library("Clem");
		Book c = new Book("A Thousand Splendid Suns", "Khaled Hosseini", 100, 100.0);
		Book d = new Book("The Boy in the Striped Pajamas", "John Boyne", 501836, 501933.0);
		Book e = new Book("A Thousand Splendid Suns", "Khaled Hosseini", 100, 100.0);
		copy2.getLibraryBooks().add(c);
		copy2.getLibraryBooks().add(d);
		copy2.getLibraryBooks().add(e);
		int f = copy2.checkNumCopies("A Thousand Splendid Suns", "Khaled Hosseini");
		assertTrue(f == 2);
	}
	
	@Test(timeout=100)
	public void testCheckOut1(){
		Library copy3 = new Library("Alderman");
		Book g = new Book ("The Diving Bell and the Butterfly", "Jean-Dominique Bauby", 21,23.0);
		Book h = new Book("The Great Gatsby", "F. Scott Fitzgerald", 70, 70.0);
		String dueDate = "17 02 2016";
		h.setDueDate(dueDate);
		h.setCheckedOut(true);
		assertTrue(h.isCheckedOut() == true);
	}
	
	@Test(timeout=100)
	public void testCheckOut2(){
		Library copy4 = new Library("Brown");
		Book i = new Book ("The Fault in Our Stars", "John Green", 21,23.0);
		Book j =new Book("Twilight", "Steponme Meyer", 711, 1.4);
		String dueDate = "05 06 2013";
		j.setDueDate(dueDate);
		j.setCheckedOut(true);
		assertFalse(j.isCheckedOut() == false);
	}
	
	@Test(timeout=100)
	public void checkbooksDueOnDate(){
		Library	copy5 = new Library("Health & Sciences");
		Book k = new Book ("The Hunger Games", "Suzanne Collins", 1999,2000.0);
		Book l = new Book("Catching Fire", "Suzanne Collins", 11, 12311.0);
		String dueDate = "11 06 2003";
		String dueDate1 = "11 06 2003";
		k.setDueDate(dueDate);
		l.setDueDate(dueDate1);
		k.getDueDate().equals(dueDate);
		l.getDueDate().equals(dueDate1);
		assertTrue(l.getDueDate() == k.getDueDate());
	}
	
	@Test(timeout=100)
	public void checkbooksDueOnDate2(){
		Library	copy6= new Library("Astronomy");
		Book m = new Book ("Gone With the Wind", "Margaret Mitchell", 1969,2600.0);
		Book n = new Book("Diary of a Wimpy Kid", "Jeff Kineey", 1001, 111.0);
		String dueDate = "11 06 2003";
		String dueDate1 = "11 06 2013";
		m.setDueDate(dueDate);
		n.setDueDate(dueDate1);
		m.getDueDate().equals(dueDate);
		n.getDueDate().equals(dueDate1);
		assertTrue(n.getDueDate() != m.getDueDate());
	}
	
	@Test(timeout=100)
	public void checklateFee1(){
		Library	copy7 = new Library("Fine Arts");
		String date1 = "12 09 2016";
		String duedate = "23 09 2016";
		Person a  = new Person("Jonn", "Smith", 10);
		Book b = new Book("Lord of the Flies", "William Golding",654,10.00);
		copy7.getPatrons().add(a);
		copy7.getLibraryBooks().add(b);
		copy7.checkOut(a, b, date1);
		copy7.setCurrentDate(duedate);
		System.out.println(copy7.lateFee(a));
		assertEquals(1.8, copy7.lateFee(a),1.88);
	}
	
	@Test(timeout=100)
	public void checklateFee2(){
		Library	copy8 = new Library("Mathematics");
		String date1 = "12 09 2016";
		String duedate = "13 09 2016";
		Person o  = new Person("Mark", "Cowell", 10);
		Book b = new Book("The Hobbit", "J.R.R. Tolkien",622,10.00);
		copy8.getPatrons().add(o);
		copy8.getLibraryBooks().add(b);
		copy8.checkOut(o, b, date1);
		copy8.setCurrentDate(duedate);
		System.out.println(copy8.lateFee(o));
		assertTrue(copy8.lateFee(o) == 0.0);
	}
}
