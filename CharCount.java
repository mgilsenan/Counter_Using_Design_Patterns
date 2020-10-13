public class CharCount extends Counter {
    private int charCount;

    public CharCount(){
        
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
