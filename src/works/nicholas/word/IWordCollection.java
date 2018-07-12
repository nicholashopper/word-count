package works.nicholas.word;

import java.util.List;

/**
 * This interface is used for adding new words to a collection
 *  that tracks the occurrences of the words.
 * 
 * @author hoppern
 *
 */
public interface IWordCollection {
	public void add(String word);
	public List<WordCount> getCollection();
}
