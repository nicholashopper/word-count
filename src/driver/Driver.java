package driver;

import util.IWordCollection;
import util.WordCollectionImpl;

public class Driver {
	
	public static void main(String[] args) {
		produceHistogram(collectWords());
	}

	private static IWordCollection collectWords() {
		IWordCollection collection = new WordCollectionImpl();
		return collection;
	}
	
	private static void produceHistogram(IWordCollection wordCollection) {
		
	}

}
