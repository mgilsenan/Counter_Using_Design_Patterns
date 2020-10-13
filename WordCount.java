public class WordCount extends Counter {
    private int wordCount;

    public WordCount(){
        
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
