abstract class Counter implements ICounter{
    public void Count(int count){
        setCount(count);
    }

    public abstract void setCount(int count);
    public abstract int getCount();
    
}
