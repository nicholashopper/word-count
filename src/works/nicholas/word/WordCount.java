package works.nicholas.word;

public class WordCount {
	private static int maxWordLength = 0;
	private String word;
	private int count;
	
	public WordCount(String word, int count) {
		super();
		setWord(word);
		setCount(count);
	}

	public WordCount(String word) {
		super();
		setWord(word);
		setCount(1);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		if(word.length()>maxWordLength) {
			maxWordLength = word.length();
		}
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
		StringBuilder builder = new StringBuilder();
		int whiteSpaceLength = maxWordLength-word.length();
		for(int i = 0; i < whiteSpaceLength; i++) {
			builder.append(' ');
		}
		builder.append(word);
		builder.append(" | ");
		for(int i = 0; i < count; i++) {
			builder.append('=');
		}
		builder.append(" ("+count+")");
		return builder.toString();
	}
}
