package iter;

public interface Iterator<T extends CreateIterator> {
    public void first();
    public void next();
    public T current();
    public boolean done();
}
