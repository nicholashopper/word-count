package util;

import java.util.Comparator;

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
