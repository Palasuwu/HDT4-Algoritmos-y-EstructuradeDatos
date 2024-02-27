package uvg.edu.gt;
public class ListFactory<T> {
    private int listType;

    /**
     * Constructor for the factory
     * @param listType the type of list to be created
     */
    public ListFactory(int listType){
        this.listType = listType;
    }

    /**
     * Creates the list according to the type sent in the constructor
     * @return The kind of list needed
     */
    public List<T> createList(){
        if(listType == 31){
            return new SingleLinkedList();
        }else{
            return new DobleLinkedList();
        }
    }
}
