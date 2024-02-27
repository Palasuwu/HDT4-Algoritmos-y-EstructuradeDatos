package uvg.edu.gt;
public class StackFactory<T> {
    private int stackType;


    public StackFactory(int stackType){
        this.stackType = stackType;
    }


    public Stack<T> createStack(){
        if(stackType == 1){
            return new ArrayListStack<T>();
        }else if(stackType == 2){
            return new VectorStack<T>();
        }else{
            return new ListStack<T>(stackType);
        }
    }
}
