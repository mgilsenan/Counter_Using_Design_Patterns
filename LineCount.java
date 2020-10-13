public class LineCount extends Counter {
    private int lineCount;

    public LineCount(){
        
    }

    
    @Override
    public int getCount() {
        return lineCount;
    }

    @Override
    public void setCount(int count) {
        lineCount += count;

    }
    
}
