package uvg.edu.gt;

import java.util.ArrayList;

public class ArrayListStack<T> extends Stack<T>{

    private ArrayList<T> coreList;

    public ArrayListStack() {
        coreList = new ArrayList<T>();
    }

    @Override
    public void push(T value) {
        coreList.add(0, value);
    }

    @Override
    public T pull() {
        return coreList.remove(0);
    }

    @Override
    public T peek() {
        return coreList.get(0);
    }

    @Override
    public int count() {
        return coreList.size();
    }

    @Override
    public boolean isEmpty() {
        return coreList.isEmpty();
    }
}

