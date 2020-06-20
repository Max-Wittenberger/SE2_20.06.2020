package net.jeremykendall.refactoring.videostore;

public class TextStatement extends Statement{

	String eachRentalString(Rental aRental) {
		return "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
	}

	String footerString(Customer aCustomer) {
		return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" + "You earned "
				+ String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
	}

	String headerString(Customer aCustomer) {
		return "Rental Record for " + aCustomer.getName() + "\n";
	}
}
