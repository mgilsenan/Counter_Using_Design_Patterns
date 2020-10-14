public class LineCounterTemplate extends CounterTemplate {
    private int lineCount;

    public LineCounterTemplate(){
        
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