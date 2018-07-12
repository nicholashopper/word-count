package driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import util.IWordCollection;
import util.WordCollectionImpl;
import util.WordCount;

public class Driver {
	
	public static void main(String[] args) {
		produceHistogram(collectWords());
	}

	private static IWordCollection collectWords() {
		IWordCollection collection = new WordCollectionImpl();
		
		try {
			for(String word: splitIntoWords(readFile("input.txt"))) {
				collection.add(word);
			}
		} catch (IOException e) {}
		
		return collection;
	}
	
	private static void produceHistogram(IWordCollection wordCollection) {
		for(WordCount wc: wordCollection.getCollection()) {
			System.out.println(wc);
		}
	}
	
	static String readFile(String fileName) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            builder.append(line);
            builder.append(" ");
            line = reader.readLine();
        } 
        reader.close();
        return builder.toString();
	}
	
	static String[] splitIntoWords(String text) {
		return text.split("\\W+");
	}

}
