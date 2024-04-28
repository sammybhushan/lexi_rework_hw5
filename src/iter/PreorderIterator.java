package iter;

import glyph.*;

import java.util.ArrayList;

public class PreorderIterator<T extends CreateIterator> implements Iterator{

    //public ArrayList<Glyph> stack;

    int index;

    public T root;
    public ArrayList<ArrayListIterator<T>> stack;
    public ArrayListIterator<T> list;




    public PreorderIterator(T root){
        this.root = root;
        index = -1;
        stack = new ArrayList<>();
    }
    @Override
    public void first() {
        list = root.createIterator();
        list.first();
        // push on stack unless done
        if(!list.done()){
            stack.add(list);
        }
    }

    @Override
    public void next() {
        ArrayListIterator iter = stack.getLast().current().createIterator(); // create iterator stack.top.current()
        iter.first();
        stack.add(iter);
        while(!stack.isEmpty() && stack.getLast().done()){
            stack.removeLast();
        }
    }

    @Override
    public T current() {
        return stack.getLast().current();
    }

    @Override
    public boolean done() {
        if(stack.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
