package works.nicholas.word;

import java.util.List;

public interface IWordCollection {
	public void add(String word);
	public List<WordCount> getCollection();
}
