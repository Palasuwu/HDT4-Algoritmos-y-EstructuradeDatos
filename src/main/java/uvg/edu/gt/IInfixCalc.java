package uvg.edu.gt;
/**
 * Interface for the calculator functions
 */

public interface IInfixCalc {
    /***
     * This method is used to evaluate a postfix expression
     * @param expresion this is a single expression like: 1 2 + 4 * 3 +
     * @return the evaluation of the expression
     */
    public String toPostfix(String expression);

    /***
     * This method is used as a part of the process to evaluate an infix expression, it is used to know the order of precedence in a operation
     * @param char ch
     * @return the value of the order of precedence to operate
     */
    public int Pemdas(char ch);

    /**
     * It evaluates a postfix expression.
     * @param expression the expression, converted from infix to postfix.
     * @return the result of the operation
     */
    public int evaluate(String expression);
}
