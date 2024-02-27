package uvg.edu.gt;
public interface IInfixCalc {

    public String toPostfix(String expression);


    public int Pemdas(char ch);


    public int evaluate(String expression);
}
