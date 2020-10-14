
public class CounterFactory implements IFactory {

	public CounterTemplate createCounter() {
		return new TotalCounterTemplate(); 
	}
}
