package driver;

import works.nicholas.word.WordFileAccessor;

public class Driver {
	
	public static void main(String[] args) {
		WordFileAccessor.produceHistogram(WordFileAccessor.collectWords());
	}

}
