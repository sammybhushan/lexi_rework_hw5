package iter;

public class NullIter <T extends CreateIterator> implements Iterator{


    @Override
    public void first() {

    }

    @Override
    public void next() {

    }

    @Override
    public T current() {
        return null;
    }

    @Override
    public boolean done() {
        return true;
    }
}
