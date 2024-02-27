package uvg.edu.gt;
import java.util.Vector;

public class VectorStack<T> extends Stack<T>{
    private Vector<T> vector;


    public VectorStack(){
        vector = new Vector<T>();
    }

    @Override
    public void push(T value) {
        vector.add(value);
    }

    @Override
    public T pull() {
        if(!isEmpty()){
            T temp = vector.lastElement();
            vector.remove(vector.size() - 1);
            return temp;
        }else{
            return null;
        }
    }

    @Override
    public T peek() {
        return vector.lastElement();
    }

    @Override
    public int count() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }
}
