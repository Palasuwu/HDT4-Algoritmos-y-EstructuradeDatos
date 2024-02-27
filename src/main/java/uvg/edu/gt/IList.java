package uvg.edu.gt;
public interface IList<T> {

    /**
     * Inserts the value at the start of the list
     * @param value the value to be inserted
     */
    void InsertAtStart(T value);

    /**
     * Inserts the value at the end of the list
     * @param value the vlaue to be inserted
     */
    void InsertAtEnd(T value);

    /**
     * Inserts the value at the specified index of the list
     * @param value the value to be inserted
     * @param index the index of the list for the value to be inserted at
     */
    void Insert(T value, int index);

    /**
     * Deletes and returns the value of the specified index in the list
     * @param index the index to delete and return the value
     * @return the value that was in the specified index
     */
    T Delete(int index);

    /**
     * Deletes and returns the value at the start of the list
     * @return the value that was on the start of the list
     */
    T DeleteAtStart();

    /**
     * Deletes and returns the value at the end of the list
     * @return the value that was on the end of the list
     */
    T DeleteAtEnd();

    /**
     * Gets the value of the specified list index but does not remove it
     * @param index the index to get
     * @return the value on the index
     */
    T Get(int index);

    /**
     * Checks if the list is empty
     * @return true if empty, false if there's items left in the list
     */
    boolean IsEmpty();

    /**
     * Counts the amount of items in the list
     * @return the amount of items in the list
     */
    int Count();
}
