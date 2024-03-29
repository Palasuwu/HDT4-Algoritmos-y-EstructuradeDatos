package uvg.edu.gt;
public class DobleLinkedList<T> extends List<T> {

    private DoubleNode<T> start;
    private DoubleNode<T> end;
    private int count;

    public DobleLinkedList() {
        start = null;
        end = null;
        count = 0;
    }

    @Override
    public void InsertAtStart(T value) {
        DoubleNode<T> newNode = new DoubleNode<T>(value);

        if (IsEmpty()) {

            start = newNode;
            end = newNode;
            start.setNext(start);
            start.setPrevious(start);
        } else {

            newNode.setNext(start);
            start.setPrevious(newNode);
            newNode.setPrevious(end);
            end.setNext(newNode);
            start = newNode;
        }

        count++;
    }

    @Override
    public void InsertAtEnd(T value) {

        DoubleNode<T> newNode = new DoubleNode<T>(value);

        if (IsEmpty()) {

            start = newNode;
            end = newNode;
            start.setNext(start);
            start.setPrevious(start);
        } else {

            newNode.setPrevious(end);
            newNode.setNext(start);
            start.setPrevious(newNode);
            end.setNext(newNode);
            end = newNode;
        }

        count++;

    }

    @Override
    public void Insert(T value, int index) {

        if (IsEmpty())
        {
            InsertAtStart(value);
        }
        else
        {
            if (index >= Count())
            {
                InsertAtEnd(value);
            }
            else if (index == 0)
            {
                InsertAtStart(value);
            }
            else if ((index > 0) && (index < Count()))
            {
                DoubleNode<T> newNode = new DoubleNode<T>(value);
                DoubleNode<T> temp = start;
                int i = 0;


                while ((temp != null) && (i < index)) {
                    temp = temp.getNext();
                    i++;
                }


                newNode.setNext(temp);
                newNode.setPrevious(temp.getPrevious());
                temp.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                count++;
            }
        }

    }

    @Override
    public T Delete(int index) {
        T deletedValue = start.getValue();
        if(start.getNext() == null) {
            start = null;
            count--;
        }else {
            start = start.getNext();
            start.setPrevious(null);
            count--;
        }
        return deletedValue;
    }

    @Override
    public T DeleteAtStart() {
        if (!IsEmpty()) {
            DoubleNode<T> temp = start;
            start = (DoubleNode<T>) start.getNext();
            if (start == null) {
                end = null;
            } else {
                start.setPrevious(null);
            }
            temp.setNext(null);
            count--;
            return temp.getValue();
        }
        return null;
    }


    @Override
    public T DeleteAtEnd() {

        return null;
    }

    @Override
    public T Get(int index) {
        if (!IsEmpty())
        {
            if (index == 0)
            {
                return start.getValue();
            }
            else if (index == (Count() - 1))
            {
                return end.getValue();
            }
            else if ((index > 0) && (index < (Count() - 1)))
            {
                DoubleNode<T> temp = start;
                int i = 0;
                while ((temp != null) && (i != index))
                {
                    temp = temp.getNext();
                    i++;
                }

                if (temp != null)
                {
                    return temp.getValue();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }

        return null;

    }

    @Override
    public boolean IsEmpty() {
        return count == 0;
    }

    @Override
    public int Count() {
        return count;
    }


}