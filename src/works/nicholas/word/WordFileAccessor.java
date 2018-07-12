package works.nicholas.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WordFileAccessor {
	private static final String OUTPUT_FILE = "output.txt";
	private static final String INPUT_FILE = "input.txt";

	public static IWordCollection collectWords() {
		IWordCollection collection = new WordCollectionImpl();
		
		try {
			for(String word: splitIntoWords(readFile(INPUT_FILE))) {
				collection.add(word);
			}
		} catch (IOException e) {}
		
		return collection;
	}
	
	public static void produceHistogram(IWordCollection wordCollection) {
		try {
			PrintWriter out = new PrintWriter(OUTPUT_FILE);
			for(WordCount wc: wordCollection.getCollection()) {
				out.println(wc);
				System.out.println(wc);
			}
			out.close();
		} catch (FileNotFoundException e) {}
	}
	
	private static String readFile(String fileName) throws IOException {
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
	
	private static String[] splitIntoWords(String text) {
		return text.split("\\W+");
	}
}
