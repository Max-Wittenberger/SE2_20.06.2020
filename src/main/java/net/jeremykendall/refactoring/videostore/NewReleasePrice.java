package net.jeremykendall.refactoring.videostore;

public class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	double getCharge(int daysRented) {
		return daysRented * 3;
	}

}
