package uvg.edu.gt;
public class ListFactory<T> {
    private int listType;


    public ListFactory(int listType){
        this.listType = listType;
    }


    public List<T> createList(){
        if(listType == 31){
            return new SingleLinkedList();
        }else{
            return new DobleLinkedList();
        }
    }
}
