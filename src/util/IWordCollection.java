package util;

import java.util.List;

public interface IWordCollection {
	public void add(String word);
	public List<WordCount> getCollection();
}
