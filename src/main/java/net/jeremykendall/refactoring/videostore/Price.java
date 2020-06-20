package net.jeremykendall.refactoring.videostore;

public abstract class Price {
	abstract int getPriceCode();
	abstract double getCharge(int daysRented);
}
