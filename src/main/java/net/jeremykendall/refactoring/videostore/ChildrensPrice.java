package net.jeremykendall.refactoring.videostore;

public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

}
