package iter;

import glyph.*;

import java.util.ArrayList;

public class PreorderIterator<T extends CreateIterator> implements Iterator{

    //public ArrayList<Glyph> stack;

    int index;

    public T root;
    public ArrayList<Iterator<T>> stack;
    public Iterator<T> list;




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
        Iterator<T> iter = stack.getLast().current().createIterator(); // create iterator stack.top.current()
        iter.first();
        stack.add(iter);
        while(!stack.isEmpty() && stack.getLast().done()){
            stack.removeLast();
            if(!stack.isEmpty() &&  !stack.getLast().done()){
                stack.getLast().next();
            }
        }
    }

    @Override
    public T current() {
        return stack.getLast().current();
    }

    @Override
    public boolean done() {
        return(stack.isEmpty());
    }
}
