//package TemplateStrategy;

public class WordCounterTemplate extends CounterTemplate {
    private int wordCount;

    public WordCounterTemplate(){
        
    }

    @Override
    public int getCount() {
        return wordCount;
    }

    @Override
    public void setCount(int count) {
        wordCount += count;
    }
    
}
