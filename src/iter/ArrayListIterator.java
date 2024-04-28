// Patterns:
// Generic
// Iterator

package iter;

import java.util.ArrayList;

public class ArrayListIterator<T extends CreateIterator> implements Iterator{

    ArrayList<T> list;
    int index;

    public ArrayListIterator(ArrayList<T> list){
        this.list = list;
        index = -1; /// so we know it hasn't started?
    }
    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if(!done()){
            index++;
        }
    }

    @Override
    public T current() {
        if(list.isEmpty()) {
            return null;
        }
        else{
            return list.get(index);
        }
    }

    @Override
    public boolean done() {
        return index + 1 == list.size();
    }
}
