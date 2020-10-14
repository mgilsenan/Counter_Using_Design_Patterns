public class CharCounterTemplate extends CounterTemplate {
    private int charCount;

    public CharCounterTemplate(){
        
    }

    @Override
    public int getCount() {
        return charCount;
    }

    @Override
    public void setCount(int count) {
        charCount += count;

    }
    
}
