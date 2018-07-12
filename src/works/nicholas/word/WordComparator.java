package works.nicholas.word;

import java.util.Comparator;

/**
 * This Comparator class allows for two WordCount objects to be compared
 *  in a fashion that compares the count of the word first, then if the 
 *  count is the same the comparator compares the string value of the word.
 * 
 * @author hoppern
 *
 */
public class WordComparator implements Comparator<WordCount> {

	@Override
	public int compare(WordCount w1, WordCount w2) {
		int result = Integer.compare(w1.getCount(), w2.getCount());
		if(result==0) {
			return w1.getWord().compareTo(w2.getWord());
		}
		return Integer.compare(w2.getCount(), w1.getCount());
	}
}
