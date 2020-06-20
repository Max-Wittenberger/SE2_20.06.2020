package net.jeremykendall.refactoring.videostore;

public class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}

}
