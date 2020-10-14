import java.util.ArrayList;
import java.util.List;

public class TotalCounterTemplate extends CounterTemplate {
	// A TotalCounterTemplate is composed of other CounterTemplates.
	private List<CounterTemplate> counterTemplates; 
	
	public List<CounterTemplate> getCounterTemplates() {
		return counterTemplates;
	}


	public TotalCounterTemplate() {
		counterTemplates = new ArrayList<CounterTemplate>();
        WordCounterTemplate wordCount = new WordCounterTemplate();
        CharCounterTemplate charCount = new CharCounterTemplate();
        LineCounterTemplate lineCount = new LineCounterTemplate();
		counterTemplates.add(wordCount);
		counterTemplates.add(charCount);
		counterTemplates.add(lineCount);
	}
	
	
	@Override
	public void setCount(int count) {
			
	}

	
	@Override
	public int getCount() {
	
		return 0;
	}
}