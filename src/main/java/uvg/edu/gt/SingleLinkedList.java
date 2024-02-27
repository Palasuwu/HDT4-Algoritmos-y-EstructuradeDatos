package uvg.edu.gt;

public class SingleLinkedList<T> extends List<T> {

    private int count;
    private Node<T> start;
    private Node<T> end;

    @Override
    public void InsertAtStart(T value) {
        Node<T> newNode = new Node<T>(value);
        if (IsEmpty()) {
            start = newNode;
            end = newNode;
        } else {
            newNode.setNext(start);
            start = newNode;
        }
        count++;
    }

    @Override
    public void InsertAtEnd(T value) {
        Node<T> newNode = new Node<T>(value);
        if(IsEmpty()) {
            start = newNode;
            end = newNode;
        } else {
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
        } else {
            if (index >= Count())
            {
                InsertAtEnd(value);
            } else if (index == 0)
            {
                InsertAtStart(value);
            } else if ((index > 0) && (index < Count()))
            {
                Node<T> newNode = new Node<T>(value);
                Node<T> pretemp = start;
                Node<T> temp = start.getNext();
                int i = 1;


                while ((temp != null) && (i < index)) {
                    pretemp = temp;
                    temp = temp.getNext();
                    i++;
                }


                newNode.setNext(temp);
                pretemp.setNext(newNode);
                count++;
            }
        }
    }

    @Override
    public T Delete(int index) {

        if (index == 0) {
            return DeleteAtStart();
        } else if (index == (Count() - 1)) {
            return DeleteAtEnd();
        } else if ((index > 0) && (index < (Count() - 1))) {
            Node<T> pretemp = start;
            Node<T> temp = start.getNext();
            int i = 1;


            while ((temp != null) && (i < (Count() - 1))) {
                pretemp = temp;
                temp = temp.getNext();
                i++;
            }

            //Delete the node
            pretemp.setNext(temp.getNext());
            count--;
            return temp.getValue();
        } else {
            return null;
        }

    }

    @Override
    public T DeleteAtStart() {

        if (!IsEmpty()) {
            Node<T> temp = start;
            start = start.getNext();
            count--;
            return temp.getValue();
        }

        return null;
    }

    @Override
    public T DeleteAtEnd() {
        if (!IsEmpty())
        {

            if (Count() == 1)
            {
                Node<T> temp = start;
                start = null;
                end = null;
                count--;
                return temp.getValue();
            }
            else
            {
                Node<T> pretemp = start;
                Node<T> temp = start.getNext();


                while (temp != null)
                {
                    pretemp = temp;
                    temp = temp.getNext();
                }


                end = pretemp;
                end.setNext(null);
                count--;
                return temp.getValue();
            }

        }

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
                Node<T> temp = start;
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
        // TODO Auto-generated method stub
        return count;
    }
}