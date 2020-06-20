package net.jeremykendall.refactoring.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer("Arthur Dent");
	}

	@Test
	public void statementRentRegularMovieForOneDay() throws Exception {
		customer.addRental(getRental("Killer Klowns from Outer Space", new RegularPrice(), 1));

		String expected = "Rental Record for Arthur Dent\n" + "\tKiller Klowns from Outer Space\t2.0\n"
				+ "Amount owed is 2.0\n" + "You earned 1 frequent renter points";
		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlStatementRentRegularMovieForOneDay() throws Exception {
		customer.addRental(getRental("Killer Klowns from Outer Space", new RegularPrice(), 1));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n"
				+ "Killer Klowns from Outer Space: 2.0<BR>\n" + "<P>You owe <EM>2.0</EM><P>\n"
				+ "On this rental you earned <EM>1</EM> frequent renter points<P>";
		assertEquals(expected, customer.htmlStatement());
	}

	@Test
	public void statementRentNewReleaseMovieForOneDay() throws Exception {
		customer.addRental(getRental("Awesome New Release", new NewReleasePrice(), 1));

		String expected = "Rental Record for Arthur Dent\n" + "\tAwesome New Release\t3.0\n" + "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points";
		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlStatementRentNewReleaseMovieForOneDay() throws Exception {
		customer.addRental(getRental("Awesome New Release", new NewReleasePrice(), 1));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" + "Awesome New Release: 3.0<BR>\n"
				+ "<P>You owe <EM>3.0</EM><P>\n"
				+ "On this rental you earned <EM>1</EM> frequent renter points<P>";
		assertEquals(expected, customer.htmlStatement());
	}

	@Test
	public void statementRentChildrensMovieForOneDay() throws Exception {
		customer.addRental(getRental("Cars", new ChildrensPrice(), 1));

		String expected = "Rental Record for Arthur Dent\n" + "\tCars\t1.5\n" + "Amount owed is 1.5\n"
				+ "You earned 1 frequent renter points";
		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlStatementRentChildrensMovieForOneDay() throws Exception {
		customer.addRental(getRental("Cars", new ChildrensPrice(), 1));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" + "Cars: 1.5<BR>\n"
				+ "<P>You owe <EM>1.5</EM><P>\n"
				+ "On this rental you earned <EM>1</EM> frequent renter points<P>";
		assertEquals(expected, customer.htmlStatement());
	}

	@Test
	public void statementRentChildrensMovieForFourDays() throws Exception {
		customer.addRental(getRental("Cars", new ChildrensPrice(), 4));

		String expected = "Rental Record for Arthur Dent\n" + "\tCars\t3.0\n" + "Amount owed is 3.0\n"
				+ "You earned 1 frequent renter points";
		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlStatementRentChildrensMovieForFourDays() throws Exception {
		customer.addRental(getRental("Cars", new ChildrensPrice(), 4));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" + "Cars: 3.0<BR>\n"
				+ "<P>You owe <EM>3.0</EM><P>\n" + "On this rental you earned <EM>1</EM> frequent renter points<P>";
		assertEquals(expected, customer.htmlStatement());
	}

	@Test
	public void statementRentRegularMovieForThreeDays() throws Exception {
		customer.addRental(getRental("Killer Klowns from Outer Space", new RegularPrice(), 3));

		String expected = "Rental Record for Arthur Dent\n" + "\tKiller Klowns from Outer Space\t3.5\n"
				+ "Amount owed is 3.5\n" + "You earned 1 frequent renter points";
		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlStatementRentRegularMovieForThreeDays() throws Exception {
		customer.addRental(getRental("Killer Klowns from Outer Space", new RegularPrice(), 3));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n"
				+ "Killer Klowns from Outer Space: 3.5<BR>\n" + "<P>You owe <EM>3.5</EM><P>\n"
				+ "On this rental you earned <EM>1</EM> frequent renter points<P>";
		assertEquals(expected, customer.htmlStatement());
	}

	@Test
	public void statementRentNewReleaseMovieForTwoDays() throws Exception {
		customer.addRental(getRental("Awesome New Release", new NewReleasePrice(), 2));

		String expected = "Rental Record for Arthur Dent\n" + "\tAwesome New Release\t6.0\n" + "Amount owed is 6.0\n"
				+ "You earned 2 frequent renter points";
		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlStatementRentNewReleaseMovieForTwoDays() throws Exception {
		customer.addRental(getRental("Awesome New Release", new NewReleasePrice(), 2));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" + "Awesome New Release: 6.0<BR>\n"
				+ "<P>You owe <EM>6.0</EM><P>\n" + "On this rental you earned <EM>2</EM> frequent renter points<P>";

		assertEquals(expected, customer.htmlStatement());
	}

	@Test
	public void rentOneOfEachTypeForFourDays() throws Exception {
		int daysRented = 4;
		customer.addRental(getRental("Killer Klowns from Outer Space", new RegularPrice(), daysRented));
		customer.addRental(getRental("Awesome New Release", new NewReleasePrice(), daysRented));
		customer.addRental(getRental("Cars", new ChildrensPrice(), daysRented));

		String expected = "Rental Record for Arthur Dent\n" + "\tKiller Klowns from Outer Space\t5.0\n"
				+ "\tAwesome New Release\t12.0\n" + "\tCars\t3.0\n" + "Amount owed is 20.0\n"
				+ "You earned 4 frequent renter points";

		assertEquals(expected, customer.statement());
	}

	@Test
	public void htmlRentOneOfEachTypeForFourDays() throws Exception {
		int daysRented = 4;
		customer.addRental(getRental("Killer Klowns from Outer Space", new RegularPrice(), daysRented));
		customer.addRental(getRental("Awesome New Release", new NewReleasePrice(), daysRented));
		customer.addRental(getRental("Cars", new ChildrensPrice(), daysRented));

		String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" + 
				"Killer Klowns from Outer Space: 5.0<BR>\n" + 
				"Awesome New Release: 12.0<BR>\n" + 
				"Cars: 3.0<BR>\n" + 
				"<P>You owe <EM>20.0</EM><P>\n" + 
				"On this rental you earned <EM>4</EM> frequent renter points<P>";
		
		assertEquals(expected, customer.htmlStatement());
	}

	private Rental getRental(String title, Price price, int daysRented) {
		Movie movie = new Movie(title, price);
		return new Rental(movie, daysRented);
	}
}