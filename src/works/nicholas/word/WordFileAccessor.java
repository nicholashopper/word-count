package works.nicholas.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is used for interfacing with input and output files
 * used in collecting words, and outputting counts of the words.
 * 
 * @author hoppern
 *
 */
public class WordFileAccessor {
	private static final String OUTPUT_FILE = "output.txt";
	private static final String INPUT_FILE = "input.txt";

	/**
	 * This reads from a file, breaks the text into words,
	 * and counts the occurrences of each word.
	 * 
	 * @return A collection of WordCounts.
	 */
	public static IWordCollection collectWords() {
		IWordCollection collection = new WordCollectionImpl();
		
		try {
			for(String word: splitIntoWords(readFile(INPUT_FILE))) {
				collection.add(word);
			}
		} catch (IOException e) {
			System.err.println("Cannot read from: " + INPUT_FILE);
		}
		
		return collection;
	}
	
	/**
	 * This outputs to a file an array of WordCount objects.
	 * 
	 * @param wordCollection
	 */
	public static void produceHistogram(IWordCollection wordCollection) {
		try {
			PrintWriter out = new PrintWriter(OUTPUT_FILE);
			for(WordCount wc: wordCollection.getCollection()) {
				out.println(wc);
				System.out.println(wc);
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("Cannot write to: " + OUTPUT_FILE);
		}
	}
	
	/**
	 * This returns a string with an input files contents.
	 * 
	 * @param fileName
	 * @return string of files contents
	 * @throws IOException
	 */
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
	
	/**
	 * This breaks a text block of ASCII characters into
	 * words. Words meaning string of upper and 
	 * lower case letters 'A' through 'Z'.
	 * 
	 * @param text
	 * @return words
	 */
	private static String[] splitIntoWords(String text) {
		return text.split("\\W+");
	}
}
