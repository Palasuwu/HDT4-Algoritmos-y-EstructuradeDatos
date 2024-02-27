package uvg.edu.gt;
public class ListStack<T> extends Stack<T>{
    private List<T> list;

    public ListStack(int listType){
        ListFactory factory = new ListFactory(listType);
        list = factory.createList();
    }

    @Override
    public void push(T value) {
        list.InsertAtStart(value);
    }

    @Override
    public T pull() {
        return list.DeleteAtStart();
    }

    @Override
    public T peek() {
        return list.Get(0);
    }

    @Override
    public int count() {
        return list.Count();
    }

    @Override
    public boolean isEmpty() {

        return list.IsEmpty();
    }
}
