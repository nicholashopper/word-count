package works.nicholas.word;

import java.util.*;

/**
 * This class is used for adding new words to a collection
 *  that tracks the occurrences of the words.
 * 
 * @author hoppern
 *
 */
public class WordCollectionImpl implements IWordCollection {
	
	private Map<String, WordCount> collection;
	
	public WordCollectionImpl() {
		collection = new HashMap<>();
	}

	@Override
	public void add(String word) {
		if(hasCountFor(word)) {
			incrementCounter(word);
		} else {
			initializeCounter(word);
		}
	}
	
	private boolean hasCountFor(String word) {
		return collection.containsKey(word.toLowerCase());
	}

	private void incrementCounter(String word) {
		word = word.toLowerCase();
		collection.get(word).increment(); 
	}

	private void initializeCounter(String word) {
		word = word.toLowerCase();
		collection.put(word.toLowerCase(), new WordCount(word));
	}

	@Override
	public List<WordCount> getCollection() {
		List<WordCount> list = new ArrayList<>(collection.values());
		list.sort(new WordComparator());
		return list;
	}
}
