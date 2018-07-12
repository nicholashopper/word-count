package util;

public class WordCount {
	private String word;
	private int count;
	
	public WordCount(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	public WordCount(String word) {
		super();
		this.word = word;
		this.count = 1;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void increment() {
		this.count++;
	}

	@Override
	public String toString() {
		return "WordCount [word=" + word + ", count=" + count + "]";
	}
}
